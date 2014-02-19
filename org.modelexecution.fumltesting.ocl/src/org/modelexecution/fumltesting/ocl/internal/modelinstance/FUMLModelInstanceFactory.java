package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.osgi.util.NLS;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration;
import org.modelexecution.fumltesting.ocl.internal.util.FUMLModelInstanceTypeUtil;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceEnumerationLiteral;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceFactory;
import tudresden.ocl20.pivot.modelinstancetype.types.base.BasisJavaModelInstanceFactory;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelInstanceFactory extends BasisJavaModelInstanceFactory implements IModelInstanceFactory {
	private Map<Object, IModelInstanceElement> myCachedAdaptedObjects = new WeakHashMap<Object, IModelInstanceElement>();
	private IModel dslModel;
	private FUMLModelInstanceTypeUtil dslTypeUtil;

	public FUMLModelInstanceFactory(IModel model) {
		dslModel = model;
		dslTypeUtil = new FUMLModelInstanceTypeUtil(model);
	}

	public IModelInstanceElement createModelInstanceElement(Object adapted) throws TypeNotFoundInModelException {
		IModelInstanceElement result = super.createModelInstanceElement(adapted);
		if (result == null) {
			if (adapted instanceof Enumeration) {
				result = createFUMLModelInstanceEnumerationLiteral((Enumeration) adapted);
			} else if (adapted instanceof Object) {
				Object object = (Object) adapted;
				if (myCachedAdaptedObjects.containsKey(object)) {
					result = myCachedAdaptedObjects.get(object);
				} else {
					result = createFUMLModelInstanceObject(object);
					myCachedAdaptedObjects.put(object, result);
				}
			} else {
				throw new TypeNotFoundInModelException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_AdapteeIsNoEObjectInstance, adapted));
			}
		}
		return result;
	}

	public IModelInstanceElement createModelInstanceElement(Object adapted, tudresden.ocl20.pivot.pivotmodel.Type type) {
		IModelInstanceElement result = myCachedAdaptedObjects.get(adapted);
		if (result == null) {
			if (type instanceof Enumeration) {
				if (adapted == null) {
					result = BasisJavaModelInstanceFactory.createModelInstanceEnumerationLiteral(null);
				} else {
					if (adapted.getClass().isEnum()) {
						List<String> modelInstanceElementTypeName = FUMLModelInstanceTypeUtil
								.toQualifiedNameList(adapted.getClass().getCanonicalName());
						if (modelInstanceElementTypeName.size() > 0) {
							try {
								tudresden.ocl20.pivot.pivotmodel.Type modelInstanceElementType = null;
								while (modelInstanceElementTypeName.size() > 0 && modelInstanceElementType == null) {
									modelInstanceElementType = dslModel.findType(modelInstanceElementTypeName);
									modelInstanceElementTypeName.remove(0);
								}
								if (modelInstanceElementType != null && modelInstanceElementType.conformsTo(type)) {
									try {
										result = createFUMLModelInstanceEnumerationLiteral((Enumeration) adapted);
									} catch (TypeNotFoundInModelException e) {
										e.printStackTrace();
									}
								}
							} catch (ModelAccessException e) {
								throw new IllegalArgumentException(NLS.bind(
										FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType,
										adapted, type));
							}
						}
					}
				}
				if (result == null) {
					throw new IllegalArgumentException(NLS.bind(
							FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
				}
			}
		} else {
			if (adapted instanceof Object) {
				Object object = (Object) adapted;
				try {
					tudresden.ocl20.pivot.pivotmodel.Type modelInstanceElementType = dslTypeUtil
							.findTypeOfObjectInModel(object);
					if (modelInstanceElementType.conformsTo(type) || type.getQualifiedName().equals("ecore::EObject")) {
						result = createFUMLModelInstanceObject(object, type, modelInstanceElementType);
						this.myCachedAdaptedObjects.put(object, result);
					} else {
						throw new IllegalArgumentException(
								NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType,
										adapted, type));
					}
				} catch (TypeNotFoundInModelException e) {
					throw new IllegalArgumentException(NLS.bind(
							FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
				}
			} else {
				if (adapted == null) {
					result = new FUMLModelInstanceObject(null, type, type, this);
				}

				/* Else the throw an exception. */
				else {
					throw new IllegalArgumentException(NLS.bind(
							FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
				}
			}
		}
		return result;
	}

	public FUMLModelInstanceTypeUtil getTypeUtil() {
		return dslTypeUtil;
	}

	private IModelInstanceElement createFUMLModelInstanceObject(Object object) throws TypeNotFoundInModelException {
		tudresden.ocl20.pivot.pivotmodel.Type type = dslTypeUtil.findTypeOfObjectInModel(object);
		IModelInstanceElement result = new FUMLModelInstanceObject(object, type, type, this);
		return result;
	}

	private IModelInstanceElement createFUMLModelInstanceObject(Object object,
			tudresden.ocl20.pivot.pivotmodel.Type type, tudresden.ocl20.pivot.pivotmodel.Type originalType) {
		IModelInstanceElement result = new FUMLModelInstanceObject(object, type, originalType, this);
		return result;
	}

	private IModelInstanceElement createFUMLModelInstanceEnumerationLiteral(Enumeration enumeration)
			throws TypeNotFoundInModelException {
		IModelInstanceEnumerationLiteral result = null;
		tudresden.ocl20.pivot.pivotmodel.Type type = null;
		try {
			ArrayList<String> qualifiedName = new ArrayList<String>(Arrays.asList(enumeration.getQualifiedName().split("::")));
			type = dslTypeUtil.findTypeOfClassInModel(qualifiedName);
		} catch (TypeNotFoundInModelException e) {
			e.printStackTrace();
		}
		if (type != null && type instanceof tudresden.ocl20.pivot.pivotmodel.Enumeration) {
			tudresden.ocl20.pivot.pivotmodel.Enumeration adaptedEnumeration = (tudresden.ocl20.pivot.pivotmodel.Enumeration) type;
			for (tudresden.ocl20.pivot.pivotmodel.EnumerationLiteral literal : adaptedEnumeration.getOwnedLiteral()) {
				if (literal.getName().equalsIgnoreCase(enumeration.toString())) {
					result = createModelInstanceEnumerationLiteral(literal);
					break;
				}
			}
			if (result == null) {
				throw new TypeNotFoundInModelException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel, enumeration));
			}
		} else {
			throw new TypeNotFoundInModelException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel, enumeration));
		}
		return result;
	}
}
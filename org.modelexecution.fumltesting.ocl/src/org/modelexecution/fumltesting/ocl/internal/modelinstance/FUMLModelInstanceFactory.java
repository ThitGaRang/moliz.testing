/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

import org.dresdenocl.model.IModel;
import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.modelinstancetype.exception.TypeNotFoundInModelException;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.modelinstancetype.types.IModelInstanceEnumerationLiteral;
import org.dresdenocl.modelinstancetype.types.IModelInstanceFactory;
import org.dresdenocl.modelinstancetype.types.base.BasisJavaModelInstanceFactory;
import org.dresdenocl.pivotmodel.EnumerationLiteral;
import org.dresdenocl.pivotmodel.PrimitiveType;
import org.dresdenocl.pivotmodel.Type;
import org.eclipse.osgi.util.NLS;
import org.modelexecution.fumltesting.ocl.internal.util.FUMLModelInstanceTypeUtil;

import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Syntax.Classes.Kernel.Enumeration;

/**
 * 
 * @author Stefan Mijatov
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
			} else if (adapted instanceof Object_) {
				Object_ object = (Object_) adapted;
				if (myCachedAdaptedObjects.containsKey(object)) {
					result = myCachedAdaptedObjects.get(object);
				} else {
					result = createFUMLModelInstanceObject(object);
					myCachedAdaptedObjects.put(object, result);
				}
			} else if (adapted instanceof Link) {
				Link link = (Link) adapted;
				if (myCachedAdaptedObjects.containsKey(link)) {
					result = myCachedAdaptedObjects.get(link);
				} else {
					result = createFUMLModelInstanceObject(link);
					myCachedAdaptedObjects.put(link, result);
				}
			} else {
				throw new TypeNotFoundInModelException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_AdapteeIsNoEObjectInstance, adapted));
			}
		}
		return result;
	}

	public IModelInstanceElement createModelInstanceElement(Object adapted, Type type) {
		IModelInstanceElement result = myCachedAdaptedObjects.get(adapted);
		if (result == null) {
			if (type instanceof PrimitiveType) {
				if (adapted == null) {
					if (((PrimitiveType) type).getKind().getName().equals("String"))
						result = BasisJavaModelInstanceFactory.createModelInstanceString(null);
					if (((PrimitiveType) type).getKind().getName().equals("Boolean")) {
						result = BasisJavaModelInstanceFactory.createModelInstanceBoolean(null);
					}
					if (((PrimitiveType) type).getKind().getName().equals("Integer")) {
						result = BasisJavaModelInstanceFactory.createModelInstanceInteger(null);
					}
				} else {
					ArrayList<String> qualifiedName = new ArrayList<String>(type.getQualifiedNameList());
					if (qualifiedName.size() > 0) {
						try {
							Type modelInstanceElementType = null;
							while (qualifiedName.size() > 0 && modelInstanceElementType == null) {
								modelInstanceElementType = dslModel.findType(qualifiedName);
								qualifiedName.remove(0);
							}
							if (modelInstanceElementType != null && modelInstanceElementType.conformsTo(type)) {
								try {
									result = createFUMLModelInstanceObject(adapted);
								} catch (TypeNotFoundInModelException e) {
									e.printStackTrace();
								}
							}
						} catch (ModelAccessException e) {
							throw new IllegalArgumentException(
									NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
						}
					}
				}
			} else {
				if (adapted instanceof Object_) {
					Object_ object = (Object_) adapted;
					try {
						Type modelInstanceElementType = dslTypeUtil.findTypeOfObjectInModel(object);
						if (modelInstanceElementType.conformsTo(type) || type.getQualifiedName().equals("ecore::EObject")) {
							result = createFUMLModelInstanceObject(object, type, modelInstanceElementType);
							this.myCachedAdaptedObjects.put(object, result);
						} else {
							throw new IllegalArgumentException(
									NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
						}
					} catch (TypeNotFoundInModelException e) {
						throw new IllegalArgumentException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
					}
				} else if (adapted instanceof Link) {
					try {
						Link link = (Link) adapted;
						Type modelInstanceElementType = dslTypeUtil.findTypeOfObjectInModel(link);
						if (modelInstanceElementType.conformsTo(type) || type.getQualifiedName().equals("ecore::EObject")) {
							result = createFUMLModelInstanceObject(link, type, modelInstanceElementType);
							this.myCachedAdaptedObjects.put(link, result);
						} else {
							throw new IllegalArgumentException(
									NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
						}
					} catch (TypeNotFoundInModelException e) {
						throw new IllegalArgumentException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
					}
				} else {
					if (adapted == null) {
						result = new FUMLModelInstanceObject(null, type, type, this);
					}

					/* Else the throw an exception. */
					else {
						throw new IllegalArgumentException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_CannotAdaptToType, adapted, type));
					}
				}
			}
		}
		return result;
	}

	public FUMLModelInstanceTypeUtil getTypeUtil() {
		return dslTypeUtil;
	}

	private IModelInstanceElement createFUMLModelInstanceObject(Object object) throws TypeNotFoundInModelException {
		Type type = dslTypeUtil.findTypeOfObjectInModel(object);
		IModelInstanceElement result = new FUMLModelInstanceObject(object, type, type, this);
		return result;
	}

	private IModelInstanceElement createFUMLModelInstanceObject(Object object, Type type, Type originalType) {
		IModelInstanceElement result = new FUMLModelInstanceObject(object, type, originalType, this);
		return result;
	}

	private IModelInstanceElement createFUMLModelInstanceEnumerationLiteral(Enumeration enumeration) throws TypeNotFoundInModelException {
		IModelInstanceEnumerationLiteral result = null;
		Type type = null;
		try {
			ArrayList<String> qualifiedName = new ArrayList<String>(Arrays.asList(enumeration.qualifiedName.split(".")));
			type = dslTypeUtil.findTypeOfClassInModel(qualifiedName);
		} catch (TypeNotFoundInModelException e) {
			e.printStackTrace();
		}
		if (type != null && type instanceof org.dresdenocl.pivotmodel.Enumeration) {
			org.dresdenocl.pivotmodel.Enumeration adaptedEnumeration = (org.dresdenocl.pivotmodel.Enumeration) type;
			for (EnumerationLiteral literal : adaptedEnumeration.getOwnedLiteral()) {
				if (literal.getName().equalsIgnoreCase(enumeration.toString())) {
					result = createModelInstanceEnumerationLiteral(literal);
					break;
				}
			}
			if (result == null) {
				throw new TypeNotFoundInModelException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel, enumeration));
			}
		} else {
			throw new TypeNotFoundInModelException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel, enumeration));
		}
		return result;
	}
}
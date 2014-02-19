package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;
import org.modelexecution.fumltesting.ocl.internal.util.FUMLModelInstanceTypeUtil;

import tudresden.ocl20.pivot.modelinstance.base.AbstractModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.AsTypeCastException;
import tudresden.ocl20.pivot.modelinstancetype.exception.CopyForAtPreException;
import tudresden.ocl20.pivot.modelinstancetype.exception.OperationAccessException;
import tudresden.ocl20.pivot.modelinstancetype.exception.OperationNotFoundException;
import tudresden.ocl20.pivot.modelinstancetype.exception.PropertyAccessException;
import tudresden.ocl20.pivot.modelinstancetype.exception.PropertyNotFoundException;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceBoolean;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceCollection;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceEnumerationLiteral;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceInteger;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstancePrimitiveType;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceReal;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceString;
import tudresden.ocl20.pivot.modelinstancetype.types.base.AbstractModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelInstanceObject extends AbstractModelInstanceObject implements IModelInstanceObject {
	private Object myObject;
	private Class<?> myAdaptedClass;
	private FUMLModelInstanceFactory myFactory;

	protected FUMLModelInstanceObject(Object object, Type type, Type originalType, FUMLModelInstanceFactory factory) {
		super(type, originalType);
		myObject = object;
		myFactory = factory;
	}

	protected FUMLModelInstanceObject(Object object, Class<?> typeClass, Type type, Type originalType,
			FUMLModelInstanceFactory factory) {
		super(type, originalType);
		myObject = object;
		myAdaptedClass = typeClass;
		myType = type;
		myFactory = factory;
	}

	public IModelInstanceElement asType(Type type) throws AsTypeCastException {
		if (type == null) {
			throw new IllegalArgumentException("Parameter 'type' must not be null!");
		}
		IModelInstanceElement result = null;
		if (getOriginalType().conformsTo(type)) {
			if (myObject == null) {
				result = new FUMLModelInstanceObject(null, type, getOriginalType(), myFactory);
			} else {
				Class<?> typeClass = FUMLModelInstanceTypeUtil.findClassOfType(myObject.getClass(), type);
				if (typeClass == null) {
					throw new AsTypeCastException(NLS.bind(
							FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotCastTypeClassNotFound, type));
				}
				result = new FUMLModelInstanceObject(myObject, typeClass, type, getOriginalType(), myFactory);
			}
		} else {
			throw new AsTypeCastException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotCastTypeClassNotFound, type));
		}
		return result;
	}

	public IModelInstanceElement copyForAtPre() throws CopyForAtPreException {
		IModelInstanceElement result = null;
		if (myObject instanceof Cloneable) {
			try {
				result = copyForAtPreWithClone();
			} catch (CopyForAtPreException e) {
				e.printStackTrace();
			}
		}
		if (result == null) {
			copyForAtPreWithReflections();
		}
		return result;
	}

	public Object getObject() {
		return myObject;
	}

	public IModelInstanceElement getProperty(Property property) throws PropertyAccessException,
			PropertyNotFoundException {
		if (property == null) {
			throw new IllegalArgumentException("Property 'property' must not be null!");
		}
		IModelInstanceElement result = null;
		if (myObject == null) {
			result = myFactory.createModelInstanceElement(null, property.getType());
		} else {
			Field theField = null;
			for (Field field : myObject.getClass().getFields()) {
				if (field.getName().equals(property.getName())) {
					theField = field;
				}
			}
			if (theField == null) {
				throw new PropertyNotFoundException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_PropertyNotFoundInModelInstanceElement,
						property));
			}
			result = AbstractModelInstance.adaptInvocationResult(theField, property.getType(), myFactory);
		}
		return result;
	}

	public IModelInstanceElement invokeOperation(Operation operation, List<IModelInstanceElement> args)
			throws OperationNotFoundException, OperationAccessException {
		if (operation == null) {
			throw new IllegalArgumentException("Parameter 'operation' must not be null!");
		} else if (args == null) {
			throw new IllegalArgumentException("Parameter 'args' must not be null!");
		}
		IModelInstanceElement result = null;
		if (myObject == null) {
			result = myFactory.createModelInstanceElement(null, operation.getType());
		} else {
			Method operationMethod = findMethodOfAdaptedObject(operation);
			int argSize = 0;
			Class<?>[] argumentTypes;
			Object[] argumentValues;

			argumentTypes = operationMethod.getParameterTypes();
			argumentValues = new Object[argSize];

			argSize = Math.min(args.size(), operation.getSignatureParameter().size());
			for (int index = 0; index < argSize; index++) {
				argumentValues[index] = createAdaptedElement(args.get(index), argumentTypes[index]);
			}
			try {
				Object adapteeResult;
				operationMethod.setAccessible(true);

				adapteeResult = operationMethod.invoke(myObject, argumentValues);

				/* Adapt the result to the expected result type. */
				if (adapteeResult instanceof Object) {
					try {
						Type adapteeType = myFactory.getTypeUtil().findTypeOfObjectInModel((Object) adapteeResult);
						result = AbstractModelInstance
								.adaptInvocationResult(adapteeResult, adapteeType, this.myFactory);
					} catch (TypeNotFoundInModelException e) {
						throw new OperationAccessException("Result of invocation of Operation '" + operation.getName()
								+ "' could not be adapted to any model type.", e);
					}
				} else {
					result = AbstractModelInstance.adaptInvocationResult(adapteeResult, operation.getType(),
							this.myFactory);
				}
			} catch (IllegalArgumentException e) {
				throw new OperationAccessException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_OperationAccessFailed, operation), e);
			} catch (IllegalAccessException e) {
				throw new OperationAccessException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_OperationAccessFailed, operation), e);
			} catch (InvocationTargetException e) {
				throw new OperationAccessException(NLS.bind(
						FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_OperationAccessFailed, operation), e);
			}
		}
		return result;
	}

	@Override
	public boolean isKindOf(Type type) {
		return getOriginalType().conformsTo(type);
	}

	public String toString() {
		StringBuffer result;
		result = new StringBuffer();
		result.append(this.getClass().getSimpleName());
		result.append("[type=");
		result.append(this.getType().getName());
		result.append(",originalType=");
		result.append(this.getOriginalType().getName());
		result.append(",");
		result.append(this.myObject.toString());
		result.append("]");
		return result.toString();
	}

	private IModelInstanceElement copyForAtPreWithClone() throws CopyForAtPreException {
		IModelInstanceElement result;
		Method cloneMethod;
		try {
			Object adaptedResult;
			cloneMethod = myObject.getClass().getMethod("clone");
			cloneMethod.setAccessible(true);
			adaptedResult = (Object) cloneMethod.invoke(myObject);
			result = new FUMLModelInstanceObject(adaptedResult, myAdaptedClass, myType, getOriginalType(), myFactory);
		} catch (SecurityException e) {
			throw new CopyForAtPreException(
					NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, getName(),
							e.getMessage()), e);
		} catch (NoSuchMethodException e) {
			throw new CopyForAtPreException(
					NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, getName(),
							e.getMessage()), e);
		} catch (IllegalArgumentException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (IllegalAccessException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (InvocationTargetException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		}
		return result;
	}

	private IModelInstanceObject copyForAtPreWithReflections() throws CopyForAtPreException {
		IModelInstanceObject result;
		Class<?> adapteeClass = myObject.getClass();
		try {
			Object copiedAdaptedObject;
			Constructor<?> emptyConstructor;
			emptyConstructor = adapteeClass.getConstructor(new Class<?>[0]);
			copiedAdaptedObject = (Object) emptyConstructor.newInstance(new Object[0]);
			while (adapteeClass != null) {
				for (Field field : adapteeClass.getDeclaredFields()) {
					field.setAccessible(true);
					if (!(Modifier.isFinal(field.getModifiers()) || Modifier.isStatic(field.getModifiers()))) {
						field.set(copiedAdaptedObject, field.get(myObject));
					}
				}
				adapteeClass = adapteeClass.getSuperclass();
			}
			result = new FUMLModelInstanceObject(copiedAdaptedObject, myAdaptedClass, myType, getOriginalType(),
					myFactory);
		} catch (SecurityException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (NoSuchMethodException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (IllegalArgumentException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (InstantiationException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (IllegalAccessException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		} catch (InvocationTargetException e) {
			throw new CopyForAtPreException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_CannotCopyForAtPre, this.getName(),
					e.getMessage()), e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private Object createAdaptedElement(IModelInstanceElement modelInstanceElement, Class<?> typeClass) {
		Object result;
		if (modelInstanceElement == null) {
			result = null;
		} else if (modelInstanceElement instanceof IModelInstancePrimitiveType) {
			if (modelInstanceElement instanceof IModelInstanceBoolean) {
				result = ((IModelInstanceBoolean) modelInstanceElement).getBoolean();
			} else if (modelInstanceElement instanceof IModelInstanceInteger) {
				result = createAdaptedIntegerValue((IModelInstanceInteger) modelInstanceElement, typeClass);
			} else if (modelInstanceElement instanceof IModelInstanceReal) {
				result = createAdaptedRealValue((IModelInstanceReal) modelInstanceElement, typeClass);
			} else if (modelInstanceElement instanceof IModelInstanceString) {
				result = createAdaptedStringValue((IModelInstanceString) modelInstanceElement, typeClass);
			} else {
				result = null;
			}
		} else if (modelInstanceElement instanceof IModelInstanceEnumerationLiteral) {
			result = createAdaptedEnumerationLiteral((IModelInstanceEnumerationLiteral) modelInstanceElement, typeClass);
		} else if (modelInstanceElement instanceof IModelInstanceCollection<?>) {
			if (typeClass.isArray()) {
				result = createAdaptedArray(modelInstanceElement, typeClass);
			} else if (Collection.class.isAssignableFrom(typeClass)) {
				result = createAdaptedCollection(
						(IModelInstanceCollection<IModelInstanceElement>) modelInstanceElement, typeClass);
			} else {
				throw new IllegalArgumentException(
						FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotRecreateCollection);
			}
		} else if (modelInstanceElement instanceof IModelInstanceObject) {
			result = ((IModelInstanceObject) modelInstanceElement).getObject();
		} else {
			result = null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private Object createAdaptedArray(IModelInstanceElement modelInstanceElement, Class<?> type) {
		Object result;
		if (modelInstanceElement instanceof IModelInstanceCollection) {
			IModelInstanceCollection<IModelInstanceElement> modelInstanceCollection;
			Collection<IModelInstanceElement> adaptedCollection;
			Class<?> componentType;
			int index = 0;
			componentType = type.getComponentType();
			modelInstanceCollection = (IModelInstanceCollection<IModelInstanceElement>) modelInstanceElement;
			adaptedCollection = modelInstanceCollection.getCollection();
			if (componentType.isPrimitive()) {
				if (boolean.class.isAssignableFrom(componentType)) {
					boolean[] array;
					array = new boolean[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceBoolean) anElement).getBoolean().booleanValue();
					}
					result = array;
				} else if (byte.class.isAssignableFrom(componentType)) {
					byte[] array;
					array = new byte[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement).getLong().byteValue();
					}
					result = array;
				} else if (char.class.isAssignableFrom(componentType)) {
					char[] array;
					array = new char[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceString) anElement).getString().charAt(0);
					}
					result = array;
				} else if (double.class.isAssignableFrom(componentType)) {
					double[] array;
					array = new double[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceReal) anElement).getDouble().doubleValue();
					}
					result = array;
				} else if (float.class.isAssignableFrom(componentType)) {
					float[] array;
					array = new float[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceReal) anElement).getDouble().floatValue();
					}
					result = array;
				} else if (int.class.isAssignableFrom(componentType)) {
					int[] array;
					array = new int[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement).getLong().intValue();
					}
					result = array;
				} else if (long.class.isAssignableFrom(componentType)) {
					long[] array;
					array = new long[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement).getLong().longValue();
					}
					result = array;
				} else if (short.class.isAssignableFrom(componentType)) {
					short[] array;
					array = new short[adaptedCollection.size()];
					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement).getLong().shortValue();
					}
					result = array;
				} else {
					throw new IllegalArgumentException(
							FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotRecreateArray);
				}
			} else {
				Object[] array;
				array = (Object[]) Array.newInstance(componentType, adaptedCollection.size());
				for (IModelInstanceElement anElement : adaptedCollection) {
					array[index] = createAdaptedElement(anElement, componentType);
				}
				result = array;
			}
		} else {
			throw new IllegalArgumentException(FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotRecreateArray);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private Collection<?> createAdaptedCollection(
			IModelInstanceCollection<IModelInstanceElement> modelInstanceCollection, Class<?> clazzType) {
		Collection<Object> result;
		if (Collection.class.isAssignableFrom(clazzType)) {
			try {
				Constructor<?> collectionConstructor;
				collectionConstructor = clazzType.getConstructor(new Class<?>[0]);
				result = (Collection<Object>) collectionConstructor.newInstance(new Object[0]);
			} catch (SecurityException e) {
				result = null;
			} catch (NoSuchMethodException e) {
				result = null;
			} catch (IllegalArgumentException e) {
				result = null;
			} catch (InstantiationException e) {
				result = null;
			} catch (IllegalAccessException e) {
				result = null;
			} catch (InvocationTargetException e) {
				result = null;
			}
			if (result == null) {
				if (UniqueEList.class.isAssignableFrom(clazzType)) {
					result = new UniqueEList<Object>();
				} else if (List.class.isAssignableFrom(clazzType)) {
					result = new BasicEList<Object>();
				} else if (Set.class.isAssignableFrom(clazzType)) {
					result = new HashSet<Object>();
				}
			}
			if (result != null) {
				Class<?> elementClassType;
				if (clazzType.getTypeParameters().length == 1
						&& clazzType.getTypeParameters()[0].getBounds().length == 1
						&& clazzType.getTypeParameters()[0].getBounds()[0] instanceof Class) {
					elementClassType = (Class<?>) clazzType.getTypeParameters()[0].getBounds()[0];
				} else {
					elementClassType = Object.class;
				}
				for (IModelInstanceElement anElement : modelInstanceCollection.getCollection()) {
					result.add(createAdaptedElement(anElement, elementClassType));
				}
			} else {
				throw new IllegalArgumentException(
						FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotRecreateCollection);
			}
		} else {
			throw new IllegalArgumentException(FUMLModelInstanceTypeMessages.FUMLModelInstance_CannotRecreateCollection);
		}
		return result;
	}

	private Object createAdaptedEnumerationLiteral(IModelInstanceEnumerationLiteral modelInstanceEnumerationLiteral,
			Class<?> typeClass) {
		Object result;
		if (typeClass.isEnum()) {
			result = null;
			for (Object anEnumConstant : typeClass.getEnumConstants()) {
				if (anEnumConstant.toString().equals(modelInstanceEnumerationLiteral.getLiteral().getName())) {
					result = anEnumConstant;
					break;
				}
			}
			if (result == null) {
				throw new IllegalArgumentException(NLS.bind(modelInstanceEnumerationLiteral.getLiteral()
						.getQualifiedName(),
						"The enumeration literal could not be adapted to any constant of the given Enum class."));
			}
		} else {
			List<String> enumerationQualifiedName;
			String enumClassName;
			enumerationQualifiedName = modelInstanceEnumerationLiteral.getLiteral().getQualifiedNameList();
			enumerationQualifiedName.remove(enumerationQualifiedName.size() - 1);

			enumClassName = FUMLModelInstanceTypeUtil.toCanonicalName(enumerationQualifiedName);
			try {
				Class<?> enumClass;
				enumClass = loadJavaClass(enumClassName);
				if (enumClass.isEnum()) {
					result = null;
					for (Object anEnumConstant : enumClass.getEnumConstants()) {
						if (anEnumConstant.toString().equals(modelInstanceEnumerationLiteral.getLiteral().getName())) {
							result = anEnumConstant;
							break;
						}
					}
					if (result == null) {
						throw new IllegalArgumentException(
								NLS.bind(modelInstanceEnumerationLiteral.getLiteral().getQualifiedName(),
										"The enumeration literal could not be adapted to any constant of the given Enum class."));
					}
				} else {
					throw new IllegalArgumentException(NLS.bind(modelInstanceEnumerationLiteral.getLiteral()
							.getQualifiedName(), "The found class " + enumClass + " is not an Enum."));
				}
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException(NLS.bind(modelInstanceEnumerationLiteral.getLiteral()
						.getQualifiedName(), e.getMessage()), e);
			}
		}
		return result;
	}

	private Object createAdaptedIntegerValue(IModelInstanceInteger modelInstanceInteger, Class<?> type) {
		Object result;
		if (type.equals(BigDecimal.class)) {
			result = new BigDecimal(modelInstanceInteger.getLong());
		} else if (type.equals(BigInteger.class)) {
			result = BigInteger.valueOf(modelInstanceInteger.getLong());
		} else if (type.equals(byte.class) || type.equals(Byte.class)) {
			result = modelInstanceInteger.getLong().byteValue();
		} else if (type.equals(int.class) || type.equals(Integer.class)) {
			result = modelInstanceInteger.getLong().intValue();
		} else if (type.equals(long.class) || type.equals(Long.class)) {
			result = modelInstanceInteger.getLong();
		} else if (type.equals(short.class) || type.equals(Short.class)) {
			result = modelInstanceInteger.getLong().shortValue();
		} else {
			result = modelInstanceInteger.getLong();
		}
		return result;
	}

	private Object createAdaptedRealValue(IModelInstanceReal modelInstanceReal, Class<?> type) {
		Object result;
		if (type.equals(double.class) || type.equals(BigInteger.class)) {
			result = modelInstanceReal.getDouble();
		} else if (type.equals(float.class) || type.equals(Float.class)) {
			result = modelInstanceReal.getDouble().floatValue();
		} else {
			result = modelInstanceReal.getDouble();
		}
		return result;
	}

	private Object createAdaptedStringValue(IModelInstanceString modelInstanceString, Class<?> type) {
		Object result;
		String stringValue = modelInstanceString.getString();

		if (type.equals(char.class) || type.equals(BigInteger.class)) {
			if (stringValue.length() > 0) {
				result = stringValue.toCharArray()[0];
			} else {
				result = null;
			}
		} else if (type.equals(float.class) || type.equals(Float.class)) {
			if (stringValue.length() > 0) {
				result = new Character(stringValue.toCharArray()[0]);
			} else {
				result = null;
			}
		} else {
			result = stringValue;
		}
		return result;
	}

	private Method findMethodOfAdaptedObject(Operation operation) throws OperationNotFoundException {
		Method result = null;
		Class<?> methodSourceClass = myAdaptedClass.getClass();

		while (methodSourceClass != null && result == null) {
			for (Method aMethod : methodSourceClass.getDeclaredMethods()) {
				boolean nameIsEqual;
				boolean resultTypeIsConform;
				boolean argumentSizeIsEqual;
				nameIsEqual = aMethod.getName().equals(operation.getName());
				resultTypeIsConform = FUMLModelInstanceTypeUtil.conformsTypeToType(aMethod.getGenericReturnType(),
						operation.getType());
				argumentSizeIsEqual = aMethod.getParameterTypes().length == operation.getSignatureParameter().size();
				if (nameIsEqual && resultTypeIsConform && argumentSizeIsEqual) {

					java.lang.reflect.Type[] javaTypes = aMethod.getGenericParameterTypes();
					List<Parameter> pivotModelParamters = operation.getSignatureParameter();
					boolean matches = true;
					for (int index = 0; index < operation.getSignatureParameter().size(); index++) {
						if (!FUMLModelInstanceTypeUtil.conformsTypeToType(javaTypes[index],
								pivotModelParamters.get(index).getType())) {
							matches = false;
							break;
						}
					}
					if (matches) {
						result = aMethod;
						break;
					}
				}
			}
			methodSourceClass = methodSourceClass.getSuperclass();
		}
		if (result == null) {
			throw new OperationNotFoundException(NLS.bind(
					FUMLModelInstanceTypeMessages.FUMLModelInstanceObject_OperationNotFound, operation,
					myObject.getClass()));
		}
		return result;
	}

	private Class<?> loadJavaClass(String canonicalName) throws ClassNotFoundException {
		Class<?> result = null;
		result = myAdaptedClass.getClass().getClassLoader().loadClass(canonicalName);
		return result;
	}
}
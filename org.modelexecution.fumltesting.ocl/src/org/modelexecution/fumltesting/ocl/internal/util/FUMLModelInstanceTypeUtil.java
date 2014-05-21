/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.osgi.util.NLS;
import org.modelexecution.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.modelexecution.fuml.Semantics.Classes.Kernel.IntegerValue;
import org.modelexecution.fuml.Semantics.Classes.Kernel.StringValue;
import org.modelexecution.fumltesting.ocl.internal.modelinstance.FUMLModelInstanceTypeMessages;

import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.model.ModelConstants;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.ComplexType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLModelInstanceTypeUtil {
	private static final Class<?> BOOLEAN_CLASSES[] = new Class<?>[] { boolean.class, Boolean.class };
	private static final Class<?> INTEGER_CLASSES[] = new Class<?>[] { BigDecimal.class, BigInteger.class, byte.class, Byte.class, int.class,
			Integer.class, long.class, Long.class, short.class, Short.class };
	private static final Class<?> REAL_CLASSES[] = new Class<?>[] { double.class, Double.class, float.class, Float.class };
	private static final Class<?> STRING_CLASSES[] = new Class<?>[] { char.class, Character.class, String.class };
	private static Map<Type, Class<?>> cachedClasses = new WeakHashMap<Type, Class<?>>();
	private Map<List<String>, Type> cachedTypes = new WeakHashMap<List<String>, Type>();
	private IModel model;

	public FUMLModelInstanceTypeUtil(IModel model) {
		this.model = model;
	}

	public static boolean conformsTypeToType(java.lang.reflect.Type reflectionType, Type type) {
		boolean result;
		if (reflectionType instanceof Class<?>) {
			Class<?> clazz;
			clazz = (Class<?>) reflectionType;
			if (clazz.isArray()) {
				result = conformsTypeToType(clazz.getComponentType(), type);
			} else {
				List<String> reflectionTypeQualifiedNameList = toQualifiedNameList(clazz.getCanonicalName());
				List<String> typeQualifiedNameList = type.getQualifiedNameList();
				if (type instanceof PrimitiveType) {
					result = Arrays.asList(new String[] { ((PrimitiveType) type).getKind().getName() }).equals(reflectionTypeQualifiedNameList);
				} else {
					if (typeQualifiedNameList.size() > 0 && typeQualifiedNameList.get(0).equals(ModelConstants.ROOT_PACKAGE_NAME)) {
						typeQualifiedNameList.remove(0);
					}
					if (typeQualifiedNameList.size() > reflectionTypeQualifiedNameList.size()) {
						result = false;
					} else {
						int offset = reflectionTypeQualifiedNameList.size() - typeQualifiedNameList.size();
						result = true;
						for (int index = 0; index < typeQualifiedNameList.size(); index++) {
							result &= typeQualifiedNameList.get(index).equals(reflectionTypeQualifiedNameList.get(index + offset));
							if (!result) {
								break;
							}
						}
					}
				}
			}
		} else if (reflectionType instanceof GenericArrayType) {
			GenericArrayType genericArrayType = (GenericArrayType) reflectionType;
			result = conformsTypeToType(genericArrayType.getGenericComponentType(), type);
		} else if (reflectionType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) reflectionType;
			if (parameterizedType.getActualTypeArguments().length == 1) {
				result = conformsTypeToType(parameterizedType.getActualTypeArguments()[0], type);
			} else {
				result = false;
			}
		} else if (reflectionType instanceof TypeVariable<?>) {
			result = false;
		} else if (reflectionType instanceof WildcardType) {
			result = false;
		} else {
			result = false;
		}
		return result;
	}

	public static String toCanonicalName(List<String> qualifiedNameList) {
		StringBuffer resultBuffer = new StringBuffer();
		qualifiedNameList = new ArrayList<String>(qualifiedNameList);
		if (qualifiedNameList.get(0).equals(ModelConstants.ROOT_PACKAGE_NAME)) {
			qualifiedNameList.remove(0);
		}
		for (String aPackageName : qualifiedNameList) {
			if (resultBuffer.length() > 0) {
				resultBuffer.append(".");
			}
			resultBuffer.append(aPackageName);
		}
		return resultBuffer.toString();
	}

	public static List<String> toQualifiedNameList(String canonicalName) {
		List<String> result = toPrimitiveQualifiedName(canonicalName);
		if (result == null) {
			result = new ArrayList<String>(Arrays.asList(canonicalName.split("[.]")));
			result.add(0, ModelConstants.ROOT_PACKAGE_NAME);
		}
		return result;
	}

	public static Class<?> findClassOfType(Class<?> baseClass, Type type) {
		Class<?> result = cachedClasses.get(type);
		if (result == null) {
			result = findSuperClassConformingToName(baseClass, baseClass, toCanonicalName(type.getQualifiedNameList()), new HashSet<Class<?>>());
			cachedClasses.put(type, result);
		}
		return result;
	}

	public Type findTypeOfClassInModel(ArrayList<String> qualifiedTypeName) throws TypeNotFoundInModelException {
		Type result = this.cachedTypes.get(qualifiedTypeName);
		if (result == null) {
			try {
				while (result == null && qualifiedTypeName.size() >= 1) {
					result = model.findType(qualifiedTypeName);
					qualifiedTypeName.remove(0);
				}
			} catch (ModelAccessException e) {
				result = null;
			}
			if (result == null) {
				throw new TypeNotFoundInModelException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel,
						qualifiedTypeName));
			}
			this.cachedTypes.put(qualifiedTypeName, result);
		}
		return result;
	}

	public Type findTypeOfObjectInModel(Object object) throws TypeNotFoundInModelException {
		Type result;
		Set<Type> resultSet;
		ArrayList<String> qualifiedTypeNameSeparated = null;

		if (object instanceof org.modelexecution.fuml.Semantics.Classes.Kernel.Object) {
			String qualifiedTypeName = ((org.modelexecution.fuml.Semantics.Classes.Kernel.Object) object).getTypes().get(0).getQualifiedName();
			qualifiedTypeNameSeparated = new ArrayList<String>(Arrays.asList(qualifiedTypeName.split("::")));
		}

		if (object instanceof StringValue || object instanceof String) {
			qualifiedTypeNameSeparated = new ArrayList<String>();
			qualifiedTypeNameSeparated.add("String");
		}

		if (object instanceof BooleanValue || object instanceof Boolean) {
			qualifiedTypeNameSeparated = new ArrayList<String>();
			qualifiedTypeNameSeparated.add("Boolean");
		}

		if (object instanceof IntegerValue || object instanceof Integer || object instanceof Long) {
			qualifiedTypeNameSeparated = new ArrayList<String>();
			qualifiedTypeNameSeparated.add("Integer");
		}

		result = this.cachedTypes.get(qualifiedTypeNameSeparated);
		if (result == null) {
			resultSet = findTypesOfClassInModel(qualifiedTypeNameSeparated);
			try {
				Type objectType = this.model.findType(Arrays.asList(new String[] { "Object" }));
				if (resultSet.size() > 1 && objectType != null && resultSet.contains(objectType)) {
					resultSet.remove(objectType);
				}
			} catch (ModelAccessException e) {
				e.printStackTrace();
			}
			if (resultSet.size() == 1) {
				result = resultSet.iterator().next();
			} else {
				result = new ComplexType(resultSet);
			}
			this.cachedTypes.put(qualifiedTypeNameSeparated, result);
		}
		return result;
	}

	private static Set<Type> removeRedundantModelTypes(Set<Type> types) {
		List<Type> typeList = new ArrayList<Type>(types);
		Set<Type> result = new HashSet<Type>();
		for (int index1 = 0; index1 < typeList.size(); index1++) {
			Type type1 = typeList.get(index1);
			boolean isRedundant = false;
			for (int index2 = 0; index2 < typeList.size(); index2++) {
				Type type2;
				type2 = typeList.get(index2);
				if (index1 != index2 && type2.conformsTo(type1)) {
					isRedundant = true;
					break;
				}
			}
			if (!isRedundant) {
				result.add(type1);
			}
		}
		return result;
	}

	private static List<String> toPrimitiveQualifiedName(String canonicalName) {
		List<String> result = null;
		if (canonicalName.equalsIgnoreCase(PrimitiveTypeKind.VOID.toString())) {
			result = new ArrayList<String>();
			result.add(PrimitiveTypeKind.VOID.toString());
		}
		if (result == null) {
			for (Class<?> clazz : BOOLEAN_CLASSES) {
				if (canonicalName.equals(clazz.getCanonicalName())) {
					result = new ArrayList<String>();
					result.add(PrimitiveTypeKind.BOOLEAN.toString());
					break;
				}
			}
		}
		if (result == null) {
			for (Class<?> clazz : INTEGER_CLASSES) {
				if (canonicalName.equals(clazz.getCanonicalName())) {
					result = new ArrayList<String>();
					result.add(PrimitiveTypeKind.INTEGER.toString());
					break;
				}
			}
		}
		if (result == null) {
			for (Class<?> clazz : REAL_CLASSES) {
				if (canonicalName.equals(clazz.getCanonicalName())) {
					result = new ArrayList<String>();
					result.add(PrimitiveTypeKind.REAL.toString());
					break;
				}
			}
		}
		if (result == null) {
			for (Class<?> clazz : STRING_CLASSES) {
				if (canonicalName.equals(clazz.getCanonicalName())) {
					result = new ArrayList<String>();
					result.add(PrimitiveTypeKind.STRING.toString());
					break;
				}
			}
		}
		return result;
	}

	private static Class<?> findSuperClassConformingToName(Class<?> baseClass, Class<?> currentClass, String canonicalName,
			Set<Class<?>> alreadyCheckedClasses) {
		Class<?> result = null;
		if (currentClass.getCanonicalName().matches(".*" + canonicalName.replaceAll("\\.", ".*") + ".*") && currentClass.isAssignableFrom(baseClass)) {
			result = currentClass;
		} else {
			alreadyCheckedClasses.add(currentClass);
			if (currentClass.getSuperclass() != null && !alreadyCheckedClasses.contains(currentClass.getSuperclass())) {
				result = findSuperClassConformingToName(baseClass, currentClass.getSuperclass(), canonicalName, alreadyCheckedClasses);
			}
			if (result == null) {
				for (Class<?> interfaze : currentClass.getInterfaces()) {
					if (!alreadyCheckedClasses.contains(interfaze)) {
						result = findSuperClassConformingToName(baseClass, interfaze, canonicalName, alreadyCheckedClasses);
						if (result != null) {
							break;
						}
					}
				}
			}
		}
		return result;
	}

	private Set<Type> findTypesOfClassInModel(ArrayList<String> qualifiedTypeName) throws TypeNotFoundInModelException {
		Set<Type> result = new HashSet<Type>();
		if (qualifiedTypeName != null) {
			try {
				result.add(findTypeOfClassInModel(qualifiedTypeName));
			} catch (TypeNotFoundInModelException e) {
				result = removeRedundantModelTypes(result);
			}
		}
		if (result.size() == 0) {
			throw new TypeNotFoundInModelException(NLS.bind(FUMLModelInstanceTypeMessages.FUMLModelInstanceFactory_TypeNotFoundInModel,
					qualifiedTypeName));
		}
		return result;
	}
}
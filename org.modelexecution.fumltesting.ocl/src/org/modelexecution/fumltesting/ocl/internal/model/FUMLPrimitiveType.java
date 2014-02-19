package org.modelexecution.fumltesting.ocl.internal.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Type;

import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractPrimitiveType;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLPrimitiveType extends AbstractPrimitiveType implements PrimitiveType {
	private static String booleanKindNames[] = new String[] { "Boolean", boolean.class.getCanonicalName(),
			Boolean.class.getCanonicalName(), "EBoolean", "EBooleanObject" };
	private static String integerKindNames[] = new String[] { "Integer", "UnlimitedNatural",
			byte.class.getCanonicalName(), Byte.class.getCanonicalName(), short.class.getCanonicalName(),
			Short.class.getCanonicalName(), int.class.getCanonicalName(), Integer.class.getCanonicalName(),
			long.class.getCanonicalName(), Long.class.getCanonicalName(), BigInteger.class.getCanonicalName(),
			BigDecimal.class.getCanonicalName(), "EByte", "EByteObject", "EShort", "EShortObject", "EInt",
			"EIntegerObject", "ELong", "ELongObject", "EBigInteger", "EBigDecimal" };
	private static String realKindNames[] = new String[] { float.class.getCanonicalName(),
			Float.class.getCanonicalName(), double.class.getCanonicalName(), Double.class.getCanonicalName(), "EFloat",
			"EFloatObject", "EDouble", "EDoubleObject" };
	private static String stringKindNames[] = new String[] { "String", char.class.getCanonicalName(),
			Character.class.getCanonicalName(), String.class.getCanonicalName(), "EChar", "ECharacter", "EString" };

	private org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType dslPrimitiveType;
	private FUMLAdapterFactory factory;

	public FUMLPrimitiveType(org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType dslPrimitiveType,
			FUMLAdapterFactory factory) {
		this.dslPrimitiveType = dslPrimitiveType;
		this.factory = factory;
	}

	public static PrimitiveTypeKind getKind(Type type) {
		for (String name : booleanKindNames) {
			if (name.equals(type.getName())) {
				return PrimitiveTypeKind.BOOLEAN;
			}
		}
		for (String name : integerKindNames) {
			if (name.equals(type.getName())) {
				return PrimitiveTypeKind.INTEGER;
			}
		}
		for (String name : realKindNames) {
			if (name.equals(type.getName())) {
				return PrimitiveTypeKind.REAL;
			}
		}
		for (String name : stringKindNames) {
			if (name.equals(type.getName())) {
				return PrimitiveTypeKind.STRING;
			}
		}
		return PrimitiveTypeKind.UNKNOWN;
	}

	@Override
	public PrimitiveTypeKind getKind() {
		return getKind(dslPrimitiveType);
	}

	@Override
	public String getName() {
		String result = dslPrimitiveType.getName();
		if (result == null) {
			result = getKind().getName();
		}
		return result;
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslPrimitiveType.getPackage());
	}
}
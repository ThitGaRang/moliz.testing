package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Association;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;
import org.modelexecution.fuml.Syntax.Classes.Kernel.DataType;
import org.modelexecution.fuml.Syntax.Classes.Kernel.LiteralBoolean;
import org.modelexecution.fuml.Syntax.Classes.Kernel.LiteralInteger;
import org.modelexecution.fuml.Syntax.Classes.Kernel.LiteralNull;
import org.modelexecution.fuml.Syntax.Classes.Kernel.LiteralString;
import org.modelexecution.fuml.Syntax.Classes.Kernel.LiteralUnlimitedNatural;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;
import org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.pivotmodel.AssociationProperty;
import tudresden.ocl20.pivot.pivotmodel.Enumeration;
import tudresden.ocl20.pivot.pivotmodel.EnumerationLiteral;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLAdapterFactory {

	private Map<org.modelexecution.fuml.Syntax.Classes.Kernel.NamedElement, NamedElement> adapters;
	private Namespace rootNamespace;
	private Map<String, FUMLPackage> adaptedNamespaces = new HashMap<String, FUMLPackage>();
	private Map<org.modelexecution.fuml.Syntax.Classes.Kernel.Operation, Parameter> adaptedVoidReturnParameters;

	public FUMLAdapterFactory(Namespace rootNamespace) {
		adapters = new WeakHashMap<org.modelexecution.fuml.Syntax.Classes.Kernel.NamedElement, NamedElement>();
		adaptedVoidReturnParameters = new HashMap<org.modelexecution.fuml.Syntax.Classes.Kernel.Operation, Parameter>();
		this.rootNamespace = rootNamespace;
	}

	public Namespace createNamespace(Package rootPackage) {
		return createNamespace(rootPackage, null);
	}

	public Namespace createNamespace(Package dslPackage, Namespace nestingNamespace) {
		Namespace result = null;
		if (dslPackage == null || !(dslPackage instanceof Package)) {
			result = this.rootNamespace;
		} else {
			FUMLPackage fumlPackage = null;
			if (adaptedNamespaces.containsKey(dslPackage.getQualifiedName())) {
				fumlPackage = adaptedNamespaces.get(dslPackage.getQualifiedName());
				fumlPackage.mergePackage(dslPackage);
			} else {
				fumlPackage = new FUMLPackage(dslPackage, nestingNamespace, this);
				adaptedNamespaces.put(dslPackage.getQualifiedName(), fumlPackage);
			}
			result = fumlPackage;
		}
		return result;
	}

	public Type createType(org.modelexecution.fuml.Syntax.Classes.Kernel.Type dslType) {
		Type result = null;
		if (dslType == null) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclVoid();
		} else if (dslType instanceof Class) {
			result = createClass((Class) dslType);
		} else if (dslType instanceof PrimitiveType) {
			if (!FUMLPrimitiveType.getKind(dslType).equals(PrimitiveTypeKind.UNKNOWN)) {
				result = createPrimitiveType((PrimitiveType) dslType);
			}
		} else if (dslType instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration) {
			result = createEnumeration((org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration) dslType);
		} else if (dslType instanceof DataType) {
			result = createDataType((DataType) dslType);
		} else if (dslType instanceof Association) {
			Association association = (Association) dslType;
			List<org.modelexecution.fuml.Syntax.Classes.Kernel.Property> allEnds = association.getOwnedEnd();
			addNavigableAssociationEnds(allEnds);
		} else {
			throw new IllegalArgumentException("Unknown type: " + dslType);
		}
		return result;
	}

	public Enumeration createEnumeration(org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration dslEnumeration) {
		if (dslEnumeration == null) {
			return null;
		}
		Enumeration enumeration = (Enumeration) adapters.get(dslEnumeration);
		if (enumeration == null) {
			enumeration = new FUMLEnumeration(dslEnumeration, this);
			adapters.put(dslEnumeration, enumeration);
		}
		return enumeration;
	}

	public EnumerationLiteral createEnumerationLiteral(
			org.modelexecution.fuml.Syntax.Classes.Kernel.EnumerationLiteral dslEnumerationLiteral) {
		if (dslEnumerationLiteral == null) {
			return null;
		}
		EnumerationLiteral literal = (EnumerationLiteral) adapters.get(dslEnumerationLiteral);
		if (literal == null) {
			literal = new FUMLEnumerationLiteral(dslEnumerationLiteral, this);
			adapters.put(dslEnumerationLiteral, literal);
		}
		return literal;
	}

	public Property createProperty(org.modelexecution.fuml.Syntax.Classes.Kernel.Property dslProperty) {
		if (dslProperty == null) {
			return null;
		}
		Property property = (Property) adapters.get(dslProperty);
		if (property == null) {
			property = new FUMLProperty(dslProperty, this);
			adapters.put(dslProperty, property);
		}
		return property;
	}

	public Property createProperty(Association dslProperty) {
		if (dslProperty == null) {
			return null;
		}
		Property property = (Property) adapters.get(dslProperty);
		if (property == null) {
			property = new FUMLAssociation(dslProperty, this);
			adapters.put(dslProperty, property);
		}
		return property;
	}

	public AssociationProperty createAssociationProperty(
			org.modelexecution.fuml.Syntax.Classes.Kernel.Property dslProperty) {
		if (dslProperty == null) {
			return null;
		}
		AssociationProperty property = (AssociationProperty) adapters.get(dslProperty);
		if (property == null) {
			property = new FUMLAssociationProperty(dslProperty, this);
			adapters.put(dslProperty, property);
		}
		return property;
	}

	public Operation createOperation(org.modelexecution.fuml.Syntax.Classes.Kernel.Operation dslOperation) {
		if (dslOperation == null) {
			return null;
		}
		Operation operation = (Operation) adapters.get(dslOperation);
		if (operation == null) {
			operation = new FUMLOperation(dslOperation, this);
			adapters.put(dslOperation, operation);
		}
		return operation;
	}

	public Parameter createParameter(org.modelexecution.fuml.Syntax.Classes.Kernel.Parameter dslParameter) {
		if (dslParameter == null) {
			return null;
		}
		Parameter parameter = (Parameter) adapters.get(dslParameter);
		if (parameter == null) {
			parameter = new FUMLParameter(dslParameter, this);
			adapters.put(dslParameter, parameter);
		}
		return parameter;
	}

	public Parameter createVoidReturnParameter(org.modelexecution.fuml.Syntax.Classes.Kernel.Operation dslOperation) {
		Parameter result = null;
		if (dslOperation != null) {
			result = adaptedVoidReturnParameters.get(dslOperation);
			if (result == null) {
				result = new FUMLVoidReturnParameter(dslOperation, this);
				adaptedVoidReturnParameters.put(dslOperation, result);
			}
		}
		return result;
	}

	public Type createPrimitiveType(PrimitiveType dslPrimitiveType) {
		Type result = (Type) adapters.get(dslPrimitiveType);
		if (result != null) {
			return result;
		} else if (dslPrimitiveType instanceof LiteralNull) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclVoid();
		} else if (dslPrimitiveType instanceof LiteralString) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclString();
		} else if (dslPrimitiveType instanceof LiteralUnlimitedNatural) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclReal();
		} else if (dslPrimitiveType instanceof LiteralInteger) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclInteger();
		} else if (dslPrimitiveType instanceof LiteralBoolean) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclBoolean();
		} else {
			throw new IllegalArgumentException("Unknown type: " + dslPrimitiveType);
		}
		if (result != null) {
			adapters.put(dslPrimitiveType, result);
		}
		return result;
	}

	public Type createType(Class dslClass) {
		if (dslClass == null) {
			return null;
		}
		Type type = (Type) adapters.get(dslClass);
		if (type == null) {
			type = new FUMLClass(dslClass, this);
			adapters.put(dslClass, type);
		}
		return type;
	}

	public Type createType(DataType dslDataType) {
		if (dslDataType == null) {
			return null;
		}
		Type type = (Type) adapters.get(dslDataType);
		if (type == null) {
			type = new FUMLDataType(dslDataType, this);
			adapters.put(dslDataType, type);
		}
		return type;
	}

	public Type createTypePrimitiveType(PrimitiveType dslPrimitiveType) {
		if (dslPrimitiveType == null) {
			return null;
		}
		Type type = (Type) adapters.get(dslPrimitiveType);
		if (type == null) {
			type = new FUMLTypePrimitiveType(dslPrimitiveType, this);
			adapters.put(dslPrimitiveType, type);
		}
		return type;
	}

	public Type createDataType(org.modelexecution.fuml.Syntax.Classes.Kernel.DataType dslDataType) {
		Type dataType = null;
		if (dslDataType == null) {
			return null;
		}
		if (dslDataType instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType) {
			dataType = createPrimitiveType((org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType) dataType);
		}
		if (dslDataType instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration) {
			dataType = createEnumeration((org.modelexecution.fuml.Syntax.Classes.Kernel.Enumeration) dataType);
		} else {
			throw new IllegalArgumentException("Unknown type: " + dataType);
		}
		return dataType;
	}

	public Type createClass(org.modelexecution.fuml.Syntax.Classes.Kernel.Class dslClass) {
		if (dslClass == null) {
			return null;
		}
		Type type = (Type) adapters.get(dslClass);
		if (type == null) {
			type = new FUMLClass(dslClass, this);
			adapters.put(dslClass, type);
		}
		return type;
	}

	private void addNavigableAssociationEnds(List<org.modelexecution.fuml.Syntax.Classes.Kernel.Property> properties) {
		List<AssociationProperty> adaptedAssociations = new LinkedList<AssociationProperty>();
		boolean allArentNavigable = true;
		int size = 0;
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : properties) {
			boolean isNavigable = property.getAssociation().getNavigableOwnedEnd().contains(property);
			allArentNavigable &= !isNavigable;
			if (isNavigable)
				++size;
		}
		if (allArentNavigable) {
			for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : properties) {
				adaptedAssociations.addAll(addAllOtherAssociationEnds(property, properties, true));
			}
		} else {
			for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : properties) {
				boolean isNavigable = property.getAssociation().getNavigableOwnedEnd().contains(property);
				if (isNavigable) {
					adaptedAssociations.addAll(this.addAllOtherAssociationEnds(property, properties, (size > 1)));
				}
			}
		}
		for (AssociationProperty prop : adaptedAssociations) {
			prop.addAssociations(adaptedAssociations);
		}
	}

	private List<AssociationProperty> addAllOtherAssociationEnds(
			org.modelexecution.fuml.Syntax.Classes.Kernel.Property owner,
			List<org.modelexecution.fuml.Syntax.Classes.Kernel.Property> allProperties, boolean association) {
		List<AssociationProperty> result = new LinkedList<AssociationProperty>();
		Property adaptedProperty;
		if (association) {
			adaptedProperty = createAssociationProperty(owner);
			result.add((AssociationProperty) adaptedProperty);
		} else {
			adaptedProperty = createProperty(owner);
		}
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : allProperties) {
			if (owner != property) {
				Type ownerType;
				ownerType = createType(property.getType());
				if (!ownerType.getOwnedProperty().contains(adaptedProperty)) {
					ownerType.addProperty(adaptedProperty);
				}
			}
		}
		return result;
	}
}
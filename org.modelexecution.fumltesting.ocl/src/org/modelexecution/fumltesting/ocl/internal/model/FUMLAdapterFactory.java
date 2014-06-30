/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.pivotmodel.AssociationProperty;
import org.dresdenocl.pivotmodel.Enumeration;
import org.dresdenocl.pivotmodel.EnumerationLiteral;
import org.dresdenocl.pivotmodel.NamedElement;
import org.dresdenocl.pivotmodel.Namespace;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Parameter;
import org.dresdenocl.pivotmodel.PrimitiveTypeKind;
import org.dresdenocl.pivotmodel.Property;
import org.dresdenocl.pivotmodel.Type;

import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.PrimitiveType;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLAdapterFactory {

	private Map<fUML.Syntax.Classes.Kernel.NamedElement, NamedElement> adapters;
	private Namespace rootNamespace;
	private Map<String, FUMLPackage> adaptedNamespaces = new HashMap<String, FUMLPackage>();
	private Map<fUML.Syntax.Classes.Kernel.Operation, Parameter> adaptedVoidReturnParameters;

	public FUMLAdapterFactory(Namespace rootNamespace) {
		adapters = new WeakHashMap<fUML.Syntax.Classes.Kernel.NamedElement, NamedElement>();
		adaptedVoidReturnParameters = new HashMap<fUML.Syntax.Classes.Kernel.Operation, Parameter>();
		this.rootNamespace = rootNamespace;
	}

	public Namespace createNamespace(fUML.Syntax.Classes.Kernel.Package rootPackage) {
		return createNamespace(rootPackage, null);
	}

	public Namespace createNamespace(fUML.Syntax.Classes.Kernel.Package dslPackage, Namespace nestingNamespace) {
		Namespace result = null;
		if (dslPackage == null || !(dslPackage instanceof fUML.Syntax.Classes.Kernel.Package)) {
			result = this.rootNamespace;
		} else {
			FUMLPackage fumlPackage = null;
			if (adaptedNamespaces.containsKey(dslPackage.qualifiedName)) {
				fumlPackage = adaptedNamespaces.get(dslPackage.qualifiedName);
				fumlPackage.mergePackage(dslPackage);
			} else {
				fumlPackage = new FUMLPackage(dslPackage, nestingNamespace, this);
				adaptedNamespaces.put(dslPackage.qualifiedName, fumlPackage);
			}
			result = fumlPackage;
		}
		return result;
	}

	public Type createType(fUML.Syntax.Classes.Kernel.Type dslType) {
		Type result = null;
		if (adapters.get(dslType) != null) {
			return (Type) adapters.get(dslType);
		}
		if (dslType == null) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclVoid();
		} else if (dslType instanceof Class_) {
			result = createClass((Class_) dslType);
		} else if (dslType instanceof PrimitiveType) {
			if (!FUMLPrimitiveType.getKind(dslType).equals(PrimitiveTypeKind.UNKNOWN)) {
				result = createPrimitiveType((PrimitiveType) dslType);
			}
		} else if (dslType instanceof fUML.Syntax.Classes.Kernel.Enumeration) {
			result = createEnumeration((fUML.Syntax.Classes.Kernel.Enumeration) dslType);
		} else if (dslType instanceof DataType) {
			result = createDataType((DataType) dslType);
		} else if (dslType instanceof Association) {
			Association association = (Association) dslType;
			List<fUML.Syntax.Classes.Kernel.Property> allEnds = association.ownedEnd;
			addNavigableAssociationEnds(allEnds);
		} else {
			throw new IllegalArgumentException("Unknown type: " + dslType);
		}
		adapters.put(dslType, result);
		return result;
	}

	public Enumeration createEnumeration(fUML.Syntax.Classes.Kernel.Enumeration dslEnumeration) {
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

	public EnumerationLiteral createEnumerationLiteral(fUML.Syntax.Classes.Kernel.EnumerationLiteral dslEnumerationLiteral) {
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

	public Property createProperty(fUML.Syntax.Classes.Kernel.Property dslProperty) {
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

	public AssociationProperty createAssociationProperty(fUML.Syntax.Classes.Kernel.Property dslProperty) {
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

	public Operation createOperation(fUML.Syntax.Classes.Kernel.Operation dslOperation) {
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

	public Parameter createParameter(fUML.Syntax.Classes.Kernel.Parameter dslParameter) {
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

	public Parameter createVoidReturnParameter(fUML.Syntax.Classes.Kernel.Operation dslOperation) {
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
		} else if (dslPrimitiveType == null) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclVoid();
		} else if (dslPrimitiveType.name.equals("String")) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclString();
		} else if (dslPrimitiveType.name.equals("UnlimitedNatural")) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclReal();
		} else if (dslPrimitiveType.name.equals("Integer")) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclInteger();
		} else if (dslPrimitiveType.name.equals("Boolean")) {
			result = EssentialOclPlugin.getOclLibraryProvider().getOclLibrary().getOclBoolean();
		} else {
			throw new IllegalArgumentException("Unknown type: " + dslPrimitiveType);
		}
		if (result != null) {
			adapters.put(dslPrimitiveType, result);
		}
		return result;
	}

	public Type createType(Class_ dslClass) {
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

	public Type createDataType(DataType dslDataType) {
		Type dataType = null;
		if (dslDataType == null) {
			return null;
		}
		if (dslDataType instanceof PrimitiveType) {
			dataType = createPrimitiveType((PrimitiveType) dataType);
		}
		if (dslDataType instanceof fUML.Syntax.Classes.Kernel.Enumeration) {
			dataType = createEnumeration((fUML.Syntax.Classes.Kernel.Enumeration) dataType);
		} else {
			throw new IllegalArgumentException("Unknown type: " + dataType);
		}
		return dataType;
	}

	public Type createClass(Class_ dslClass) {
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

	private void addNavigableAssociationEnds(List<fUML.Syntax.Classes.Kernel.Property> properties) {
		List<AssociationProperty> adaptedAssociationProperties = new LinkedList<AssociationProperty>();
		boolean allArentNavigable = true;
		int size = 0;
		for (fUML.Syntax.Classes.Kernel.Property property : properties) {
			boolean isNavigable = property.association.navigableOwnedEnd.contains(property);
			allArentNavigable &= !isNavigable;
			if (isNavigable)
				++size;
		}
		if (allArentNavigable) {
			for (fUML.Syntax.Classes.Kernel.Property property : properties) {
				adaptedAssociationProperties.addAll(addAllOtherAssociationEnds(property, properties, true));
			}
		} else {
			for (fUML.Syntax.Classes.Kernel.Property property : properties) {
				boolean isNavigable = property.association.navigableOwnedEnd.contains(property);
				if (isNavigable) {
					adaptedAssociationProperties.addAll(addAllOtherAssociationEnds(property, properties, (size > 1)));
				}
			}
		}
	}

	private List<AssociationProperty> addAllOtherAssociationEnds(fUML.Syntax.Classes.Kernel.Property property,
			List<fUML.Syntax.Classes.Kernel.Property> allProperties, boolean association) {
		List<AssociationProperty> result = new LinkedList<AssociationProperty>();
		Property adaptedProperty;
		if (association) {
			adaptedProperty = createAssociationProperty(property);
			result.add((AssociationProperty) adaptedProperty);
		} else {
			adaptedProperty = createProperty(property);
		}
		for (fUML.Syntax.Classes.Kernel.Property theProperty : property.association.navigableOwnedEnd) {
			for (fUML.Syntax.Classes.Kernel.Property oposite : property.association.ownedEnd) {
				if (!oposite.name.equals(theProperty.name)) {
					FUMLClass newOwner = (FUMLClass) adapters.get(oposite.typedElement.type);
					boolean alreadyAdded = false;
					for (Property addedProperty : newOwner.getOwnedProperty()) {
						if (addedProperty.getName().equals(adaptedProperty.getName()))
							alreadyAdded = true;
					}
					if (!alreadyAdded)
						newOwner.addProperty(adaptedProperty);
				}
			}
		}
		return result;
	}
}
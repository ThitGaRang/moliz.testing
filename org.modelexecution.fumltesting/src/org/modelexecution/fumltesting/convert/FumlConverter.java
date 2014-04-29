/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.convert;

import java.util.HashMap;

import org.modelexecution.fuml.Semantics.Classes.Kernel.KernelFactory;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Object;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Value;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Association;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Package;
import org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType;
import org.modelexecution.fuml.Syntax.Classes.Kernel.StructuralFeature;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Type;
import org.modelexecution.fuml.Syntax.Classes.Kernel.VisibilityKind;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.NamedElement;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * Utility class that provides mapping from fUML implementation classes to fUML
 * meta model classes.
 * 
 * @author Stefan Mijatov
 * 
 */
public class FumlConverter {
	private HashMap<Class_, Class> mappedClasses = new HashMap<Class_, Class>();
	private HashMap<fUML.Syntax.Classes.Kernel.Association, Association> mappedAssociations = new HashMap<fUML.Syntax.Classes.Kernel.Association, Association>();
	private HashMap<fUML.Syntax.Classes.Kernel.Package, Package> mappedPackages = new HashMap<fUML.Syntax.Classes.Kernel.Package, Package>();
	private HashMap<fUML.Syntax.Classes.Kernel.PrimitiveType, PrimitiveType> mappedPrimitiveTypes = new HashMap<fUML.Syntax.Classes.Kernel.PrimitiveType, PrimitiveType>();

	private HashMap<Object_, Object> mappedObjects = new HashMap<Object_, Object>();
	private HashMap<fUML.Semantics.Classes.Kernel.Link, Link> mappedLinks = new HashMap<fUML.Semantics.Classes.Kernel.Link, Link>();

	public Package mapAndWire(fUML.Syntax.Classes.Kernel.Package package_) {
		Package mappedPackage = map(package_);
		wirePackageElements();
		return mappedPackage;
	}

	private void wirePackageElements() {
		for (Class_ class_ : mappedClasses.keySet()) {
			Class mappedClass = mappedClasses.get(class_);

			if (class_.owner != null && class_.owner instanceof fUML.Syntax.Classes.Kernel.Package)
				mappedClass.setOwner(map((fUML.Syntax.Classes.Kernel.Package) class_.owner));

			if (class_.package_ != null && class_.package_ instanceof fUML.Syntax.Classes.Kernel.Package)
				mappedClass.setPackage(map((fUML.Syntax.Classes.Kernel.Package) class_.package_));
		}
		for (fUML.Syntax.Classes.Kernel.Association association : mappedAssociations.keySet()) {
			Association mappedAssociation = mappedAssociations.get(association);

			if (association.owner != null && association.owner instanceof fUML.Syntax.Classes.Kernel.Package)
				mappedAssociation.setOwner(map((fUML.Syntax.Classes.Kernel.Package) association.owner));

			if (association.package_ != null && association.package_ instanceof fUML.Syntax.Classes.Kernel.Package)
				mappedAssociation.setPackage(map((fUML.Syntax.Classes.Kernel.Package) association.package_));

			for (Property property : association.ownedEnd) {
				org.modelexecution.fuml.Syntax.Classes.Kernel.Property mappedProperty = (org.modelexecution.fuml.Syntax.Classes.Kernel.Property) map(property);
				mappedProperty.setAssociation(mappedAssociation);
				if (property.typedElement != null && property.typedElement.type instanceof Class_) {
					mappedProperty.setType(map((Class_) property.typedElement.type));
				}
				mappedAssociation.getOwnedEnd().add(mappedProperty);
			}
		}

		// mapping properties
		for (Class_ class_ : mappedClasses.keySet()) {
			Class mappedClass = mappedClasses.get(class_);
			for (Property property : class_.attribute) {
				org.modelexecution.fuml.Syntax.Classes.Kernel.Property mappedProperty = (org.modelexecution.fuml.Syntax.Classes.Kernel.Property) map(property);
				boolean propertyAdded = false;
				for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property aProperty : mappedClass.getAttribute()) {
					if (aProperty.getName().equals(mappedProperty.getName()))
						propertyAdded = true;
				}
				if (!propertyAdded) {
					mappedClass.getOwnedAttribute().add(mappedProperty);
					mappedClass.getAttribute().add(mappedProperty);
					mappedProperty.setOwner(mappedClass);
					if (property.typedElement != null && property.typedElement.type instanceof fUML.Syntax.Classes.Kernel.PrimitiveType)
						mappedProperty.setType(mapPrimitiveType((fUML.Syntax.Classes.Kernel.PrimitiveType) property.typedElement.type));
					if (property.typedElement != null && property.typedElement.type instanceof Class_) {
						mappedProperty.setType(map((Class_) property.typedElement.type));
					}
				}
			}
		}
	}

	private Package map(fUML.Syntax.Classes.Kernel.Package package_) {
		if (mappedPackages.containsKey(package_)) {
			return mappedPackages.get(package_);
		} else {
			Package mappedPackage = getSyntaxFactory().createPackage();

			mappedPackage.setName(package_.name);
			if (package_.nestingPackage != null) {
				mappedPackage.setNestingPackage(map(package_.nestingPackage));
			}

			mappedPackage.setQualifiedName(package_.qualifiedName);
			mappedPackage.setVisibility(mapVisibility(package_));

			if (package_.owner != null)
				mappedPackage.setOwner(map((fUML.Syntax.Classes.Kernel.Package) package_.owner));

			// mapping packages, classes and associations within the package
			for (NamedElement element : package_.ownedMember) {
				if (element instanceof fUML.Syntax.Classes.Kernel.Package) {
					Package ownedPackage = map((fUML.Syntax.Classes.Kernel.Package) element);
					mappedPackage.getOwnedElement().add(ownedPackage);
				}
				if (element instanceof Class_) {
					Class ownedClass = map((Class_) element);
					mappedPackage.getOwnedElement().add(ownedClass);
				}
				if (element instanceof fUML.Syntax.Classes.Kernel.Association) {
					Association ownedAssociation = map((fUML.Syntax.Classes.Kernel.Association) element);
					mappedPackage.getOwnedElement().add(ownedAssociation);
				}
			}

			mappedPackages.put(package_, mappedPackage);
			return mappedPackage;
		}
	}

	private Class map(Class_ class_) {
		if (mappedClasses.containsKey(class_)) {
			return mappedClasses.get(class_);
		} else {
			Class mappedClass = getSyntaxFactory().createClass();

			mappedClass.setAbstract(class_.isAbstract);
			mappedClass.setActive(class_.isActive);
			mappedClass.setFinalSpecialization(class_.isFinalSpecialization);
			mappedClass.setName(class_.name);
			mappedClass.setQualifiedName(class_.qualifiedName);
			mappedClass.setVisibility(mapVisibility(class_));

			mappedClasses.put(class_, mappedClass);
			/**
			 * Following fields are NOT set: ClassifierBehavior
			 */
			return mappedClass;
		}
	}

	private Association map(fUML.Syntax.Classes.Kernel.Association association) {
		if (mappedAssociations.containsKey(association)) {
			return mappedAssociations.get(association);
		} else {
			Association mappedAssociation = getSyntaxFactory().createAssociation();

			mappedAssociation.setAbstract(association.isAbstract);
			mappedAssociation.setAbstract(association.isDerived);
			mappedAssociation.setFinalSpecialization(association.isFinalSpecialization);
			mappedAssociation.setName(association.name);
			mappedAssociation.setQualifiedName(association.qualifiedName);
			mappedAssociation.setVisibility(mapVisibility(association));

			mappedAssociations.put(association, mappedAssociation);
			return mappedAssociation;
		}
	}

	private StructuralFeature map(fUML.Syntax.Classes.Kernel.StructuralFeature structuralFeature) {
		StructuralFeature mappedFeature = getSyntaxFactory().createProperty();

		mappedFeature.setLeaf(structuralFeature.isLeaf);
		mappedFeature.setLower(structuralFeature.multiplicityElement.lower);
		mappedFeature.setName(structuralFeature.name);
		mappedFeature.setOrdered(structuralFeature.multiplicityElement.isOrdered);
		mappedFeature.setQualifiedName(structuralFeature.qualifiedName);
		mappedFeature.setReadOnly(structuralFeature.isReadOnly);
		mappedFeature.setStatic(structuralFeature.isStatic);
		mappedFeature.setUnique(structuralFeature.multiplicityElement.isUnique);
		mappedFeature.setUpper(structuralFeature.multiplicityElement.upper.naturalValue);
		mappedFeature.setVisibility(mapVisibility(structuralFeature));

		if (structuralFeature.owner != null && structuralFeature.owner instanceof Class_) {
			mappedFeature.setOwner(map((Class_) structuralFeature.owner));
		}
		if (structuralFeature.owner != null && structuralFeature.owner instanceof fUML.Syntax.Classes.Kernel.Association) {
			Association owner = map((fUML.Syntax.Classes.Kernel.Association) structuralFeature.owner);
			boolean isNavigable = ((fUML.Syntax.Classes.Kernel.Association) structuralFeature.owner).navigableOwnedEnd.contains(structuralFeature);
			if (isNavigable)
				owner.getNavigableOwnedEnd().add((org.modelexecution.fuml.Syntax.Classes.Kernel.Property) mappedFeature);
			else
				owner.getOwnedEnd().add((org.modelexecution.fuml.Syntax.Classes.Kernel.Property) mappedFeature);
			mappedFeature.setOwner(owner);
		}
		if (structuralFeature.typedElement != null && structuralFeature.typedElement.type instanceof fUML.Syntax.Classes.Kernel.PrimitiveType)
			mappedFeature.setType(mapPrimitiveType((fUML.Syntax.Classes.Kernel.PrimitiveType) structuralFeature.typedElement.type));

		return mappedFeature;
	}

	private Type mapPrimitiveType(fUML.Syntax.Classes.Kernel.PrimitiveType type) {
		if (mappedPrimitiveTypes.containsKey(type)) {
			return mappedPrimitiveTypes.get(type);
		} else {
			org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType mappedPrimitiveType = getSyntaxFactory().createPrimitiveType();
			mappedPrimitiveType.setAbstract(type.isAbstract);
			mappedPrimitiveType.setFinalSpecialization(type.isFinalSpecialization);
			mappedPrimitiveType.setName(type.name);
			mappedPrimitiveType.setQualifiedName(type.qualifiedName);
			mappedPrimitiveType.setVisibility(mapVisibility(type));

			if (type.owner instanceof fUML.Syntax.Classes.Kernel.Package) {
				mappedPrimitiveType.setOwner(map((fUML.Syntax.Classes.Kernel.Package) type.owner));
			} else if (type.owner instanceof Class_) {
				mappedPrimitiveType.setOwner(map((Class_) type.owner));
			} else if (type.owner instanceof fUML.Syntax.Classes.Kernel.Association) {
				mappedPrimitiveType.setOwner(map((fUML.Syntax.Classes.Kernel.Association) type.owner));
			}

			if (type.namespace instanceof fUML.Syntax.Classes.Kernel.Package) {
				mappedPrimitiveType.setNamespace(map((fUML.Syntax.Classes.Kernel.Package) type.namespace));
			} else if (type.namespace instanceof Class_) {
				mappedPrimitiveType.setNamespace(map((Class_) type.namespace));
			} else if (type.namespace instanceof fUML.Syntax.Classes.Kernel.Association) {
				mappedPrimitiveType.setNamespace(map((fUML.Syntax.Classes.Kernel.Association) type.namespace));
			}

			return mappedPrimitiveType;
		}
		/**
		 * Following fields are NOT set: Package
		 */
	}

	private VisibilityKind mapVisibility(NamedElement element) {
		switch (element.visibility) {
		case package_:
			return VisibilityKind.PACKAGE;
		case private_:
			return VisibilityKind.PRIVATE;
		case protected_:
			return VisibilityKind.PROTECTED;
		case public_:
			return VisibilityKind.PUBLIC;
		default:
			return null;
		}
	}

	public Object map(Object_ object_) {
		for (Object_ key : mappedObjects.keySet()) {
			if (key == object_)
				return mappedObjects.get(object_);
		}

		Object object = getSemanticsFactory().createObject();
		object.getTypes().add(map(object_.types.get(0)));

		for (FeatureValue featureValue : object_.featureValues) {
			org.modelexecution.fuml.Semantics.Classes.Kernel.FeatureValue mappedFeatureValue = getSemanticsFactory().createFeatureValue();
			mappedFeatureValue.setFeature(map(featureValue.feature));
			for (fUML.Semantics.Classes.Kernel.Value value : featureValue.values) {
				mappedFeatureValue.getValues().add(map(value));
			}
			object.getFeatureValues().add(mappedFeatureValue);
		}
		mappedObjects.put(object_, object);

		return object;
	}

	public Link map(fUML.Semantics.Classes.Kernel.Link link) {
		Link mappedLink = getSemanticsFactory().createLink();
		mappedLink.setType(map(link.type));

		for (FeatureValue featureValue : link.featureValues) {
			org.modelexecution.fuml.Semantics.Classes.Kernel.FeatureValue mappedFeatureValue = getSemanticsFactory().createFeatureValue();
			mappedFeatureValue.setFeature(map(featureValue.feature));
			for (fUML.Semantics.Classes.Kernel.Value value : featureValue.values) {
				mappedFeatureValue.getValues().add(map(((Reference) value).referent));
			}
			mappedLink.getFeatureValues().add(mappedFeatureValue);
		}

		mappedLinks.put(link, mappedLink);
		return mappedLink;
	}

	private Value map(fUML.Semantics.Classes.Kernel.Value value) {
		Value mappedValue = null;

		if (value instanceof BooleanValue) {
			mappedValue = getSemanticsFactory().createBooleanValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.BooleanValue) mappedValue).setValue(((BooleanValue) value).value);
		}
		if (value instanceof StringValue) {
			mappedValue = getSemanticsFactory().createStringValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.StringValue) mappedValue).setValue(((StringValue) value).value);
		}
		if (value instanceof IntegerValue) {
			mappedValue = getSemanticsFactory().createIntegerValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.IntegerValue) mappedValue).setValue(((IntegerValue) value).value);
		}
		if (value instanceof Reference) {
			mappedValue = map(((Reference) value).referent);
		}

		return mappedValue;
	}

	public Object_ mappedFrom(Object object) {
		for (Object_ key : mappedObjects.keySet()) {
			if (mappedObjects.get(key) == object) {
				return key;
			}
		}
		return null;
	}

	private org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory getSyntaxFactory() {
		return org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory.eINSTANCE;
	}

	private KernelFactory getSemanticsFactory() {
		return KernelFactory.eINSTANCE;
	}
}
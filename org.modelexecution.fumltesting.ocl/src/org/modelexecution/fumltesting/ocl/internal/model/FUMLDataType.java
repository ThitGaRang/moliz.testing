/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fuml.Syntax.Classes.Kernel.Classifier;
import org.modelexecution.fuml.Syntax.Classes.Kernel.DataType;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Element;
import org.modelexecution.fuml.Syntax.Classes.Kernel.NamedElement;

import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractType;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLDataType extends AbstractType implements Type {
	private DataType dslDataType;
	private FUMLAdapterFactory factory;

	public FUMLDataType(DataType dslDataType, FUMLAdapterFactory factory) {
		this.dslDataType = dslDataType;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslDataType.getName();
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslDataType.getPackage());
	}

	@Override
	protected List<Property> getOwnedPropertyImpl() {
		List<Property> result = new ArrayList<Property>();
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : dslDataType.getOwnedAttribute()) {
			result.add(factory.createProperty(property));
		}
		return result;
	}

	@Override
	protected List<Operation> getOwnedOperationImpl() {
		List<Operation> result = new ArrayList<Operation>();
		for (Element element : dslDataType.getOwnedElement()) {
			if (element instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Operation)
				result.add(factory.createOperation((org.modelexecution.fuml.Syntax.Classes.Kernel.Operation) element));
		}
		return result;
	}

	@Override
	protected List<Type> getSuperTypeImpl() {
		List<Type> result = new ArrayList<Type>();
		for (NamedElement inheritedElement : dslDataType.getInheritedMember()) {
			if (inheritedElement instanceof Classifier)
				result.add(factory.createType((Classifier) inheritedElement));
		}
		return result;
	}
}
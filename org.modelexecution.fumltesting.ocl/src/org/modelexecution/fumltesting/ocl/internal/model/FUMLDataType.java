/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.dresdenocl.pivotmodel.Namespace;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Property;
import org.dresdenocl.pivotmodel.Type;
import org.dresdenocl.pivotmodel.base.AbstractType;

import fUML.Syntax.Classes.Kernel.Classifier;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.NamedElement;

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
		return dslDataType.name;
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslDataType.package_);
	}

	@Override
	protected List<Property> getOwnedPropertyImpl() {
		List<Property> result = new ArrayList<Property>();
		for (fUML.Syntax.Classes.Kernel.Property property : dslDataType.ownedAttribute) {
			result.add(factory.createProperty(property));
		}
		return result;
	}

	@Override
	protected List<Operation> getOwnedOperationImpl() {
		List<Operation> result = new ArrayList<Operation>();
		for (Element element : dslDataType.ownedElement) {
			if (element instanceof fUML.Syntax.Classes.Kernel.Operation)
				result.add(factory.createOperation((fUML.Syntax.Classes.Kernel.Operation) element));
		}
		return result;
	}

	@Override
	protected List<Type> getSuperTypeImpl() {
		List<Type> result = new ArrayList<Type>();
		for (NamedElement inheritedElement : dslDataType.inheritedMember) {
			if (inheritedElement instanceof Classifier)
				result.add(factory.createType((Classifier) inheritedElement));
		}
		return result;
	}
}
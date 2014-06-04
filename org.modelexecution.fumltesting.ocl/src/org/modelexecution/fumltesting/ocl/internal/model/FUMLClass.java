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
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class FUMLClass extends AbstractType implements Type {
	private Class dslClass;
	private FUMLAdapterFactory factory;

	public FUMLClass(Class dslClass, FUMLAdapterFactory factory) {
		this.dslClass = dslClass;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslClass.getName();
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslClass.getPackage());
	}

	@Override
	protected List<Property> getOwnedPropertyImpl() {
		List<Property> result = new ArrayList<Property>();
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : dslClass.getOwnedAttribute()) {
			result.add(factory.createProperty(property));
		}
		return result;
	}

	@Override
	protected List<Operation> getOwnedOperationImpl() {
		List<Operation> result = new ArrayList<Operation>();
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Operation operation : dslClass.getOwnedOperation()) {
			result.add(factory.createOperation(operation));
		}
		return result;
	}

	@Override
	protected List<Type> getSuperTypeImpl() {
		List<Type> result = new ArrayList<Type>();
		for (Class clazz : dslClass.getSuperClass()) {
			result.add(factory.createType(clazz));
		}
		return result;
	}
}
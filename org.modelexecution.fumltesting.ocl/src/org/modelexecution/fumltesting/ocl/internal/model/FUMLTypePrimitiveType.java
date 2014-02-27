/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.ocl.internal.model;

import java.util.ArrayList;
import java.util.List;

import org.modelexecution.fuml.Syntax.Classes.Kernel.NamedElement;
import org.modelexecution.fuml.Syntax.Classes.Kernel.PrimitiveType;

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
public class FUMLTypePrimitiveType extends AbstractType implements Type {
	private PrimitiveType dslPrimitiveType;
	private FUMLAdapterFactory factory;

	public FUMLTypePrimitiveType(PrimitiveType dslPrimitiveType, FUMLAdapterFactory factory) {
		this.dslPrimitiveType = dslPrimitiveType;
		this.factory = factory;
	}

	@Override
	public String getName() {
		return dslPrimitiveType.getName();
	}

	@Override
	public Namespace getNamespace() {
		return factory.createNamespace(dslPrimitiveType.getPackage());
	}

	@Override
	protected List<tudresden.ocl20.pivot.pivotmodel.Property> getOwnedPropertyImpl() {
		List<Property> result = new ArrayList<Property>();
		for (org.modelexecution.fuml.Syntax.Classes.Kernel.Property property : dslPrimitiveType.getOwnedAttribute()) {
			result.add(factory.createProperty(property));
		}
		return result;
	}

	@Override
	protected List<Operation> getOwnedOperationImpl() {
		List<Operation> result = new ArrayList<Operation>();
		for (NamedElement operation : dslPrimitiveType.getOwnedMember()) {
			if (operation instanceof org.modelexecution.fuml.Syntax.Classes.Kernel.Operation) {
				result.add(factory.createOperation((org.modelexecution.fuml.Syntax.Classes.Kernel.Operation) operation));
			}
		}
		return result;
	}

	@Override
	protected List<Type> getSuperTypeImpl() {
		return new ArrayList<Type>();
	}
}
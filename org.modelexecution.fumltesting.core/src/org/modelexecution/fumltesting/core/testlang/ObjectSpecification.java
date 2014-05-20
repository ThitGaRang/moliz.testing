/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.testlang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fUML.Syntax.Classes.Kernel.Class_;

/**
 * @author Stefan Mijatov
 * 
 */
public class ObjectSpecification {
	private String name;
	private Class_ type;
	private Scenario containerScenario;

	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();

	public ObjectSpecification(Scenario containerScenario) {
		this.containerScenario = containerScenario;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class_ getType() {
		return this.type;
	}

	public void setType(Class_ type) {
		this.type = type;
	}

	public Scenario getContainer() {
		return this.containerScenario;
	}

	public void setContainer(Scenario scenario) {
		this.containerScenario = scenario;
	}

	public void addAttribute(Attribute attribute) {
		this.attributes.add(attribute);
	}

	public List<Attribute> getAllAttributes() {
		return Collections.unmodifiableList(this.attributes);
	}
}
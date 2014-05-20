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

/**
 * @author Stefan Mijatov
 * 
 */
public class Scenario {
	private String name;
	private TestSuite container;

	private ArrayList<ObjectSpecification> objects = new ArrayList<ObjectSpecification>();
	private ArrayList<Link> links = new ArrayList<Link>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestSuite getContainer() {
		return this.container;
	}

	public void setContainer(TestSuite container) {
		this.container = container;
	}

	public void addObject(ObjectSpecification objectSpecification) {
		objectSpecification.setContainer(this);
		this.objects.add(objectSpecification);
	}

	public List<ObjectSpecification> getAllObjects() {
		return Collections.unmodifiableList(this.objects);
	}

	public void addLink(Link link) {
		link.setContainer(this);
		this.links.add(link);
	}

	public List<Link> getAllLinks() {
		return Collections.unmodifiableList(this.links);
	}
}
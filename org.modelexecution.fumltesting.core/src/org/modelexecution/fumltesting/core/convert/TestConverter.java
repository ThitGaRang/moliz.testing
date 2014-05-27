/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

import org.modelexecution.fumltesting.core.testlang.Check;
import org.modelexecution.fumltesting.core.testlang.Link;
import org.modelexecution.fumltesting.core.testlang.NodeOrder;
import org.modelexecution.fumltesting.core.testlang.ReferencePoint;
import org.modelexecution.fumltesting.core.testlang.Scenario;
import org.modelexecution.fumltesting.core.testlang.TestCase;
import org.modelexecution.fumltesting.core.testlang.TestSuite;

/**
 * @author Stefan Mijatov
 * 
 */
public interface TestConverter {

	public ModelConverter getModelConverter();

	public TestSuite convertSuite(Object suite);

	public Scenario convertScenario(Object aScenario);

	public TestCase convertTestCase(Object aTestCase);

	public Object convertValue(Object aValue);

	public Link convertLink(Object aLink);

	public Object convertAssertion(Object anAssertion);

	public NodeOrder convertNodeOrder(Object aNodeOrder);

	public Check convertCheck(Object aCheck);

	public ReferencePoint convertReferencePoint(Object umlReferencePoint);
}
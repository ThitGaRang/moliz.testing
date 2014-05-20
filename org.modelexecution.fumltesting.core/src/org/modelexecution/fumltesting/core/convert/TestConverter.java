/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

import org.modelexecution.fumltesting.core.testlang.TestSuite;

/**
 * @author Stefan Mijatov
 * 
 */
public interface TestConverter {

	public abstract ModelConverter getModelConverter();

	public abstract TestSuite convertSuite(Object suite);

}
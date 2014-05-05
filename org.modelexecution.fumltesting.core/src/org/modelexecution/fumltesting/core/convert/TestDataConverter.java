/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

/**
 * @author Stefan Mijatov
 *
 */
public interface TestDataConverter {

	public abstract void cleanUp();

	public abstract Object getFUMLElement(Object value);

}
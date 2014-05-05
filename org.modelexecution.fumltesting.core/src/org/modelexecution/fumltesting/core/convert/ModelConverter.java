/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

import java.util.Collection;

import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Element;

/**
 * @author Stefan Mijatov
 *
 */
public interface ModelConverter {

	public abstract void setModelAndConvert(Object model);

	public abstract Object getOriginal(Element element);

	public abstract Object convertElement(Object element);

	public abstract Collection<Activity> getAllActivities();

}
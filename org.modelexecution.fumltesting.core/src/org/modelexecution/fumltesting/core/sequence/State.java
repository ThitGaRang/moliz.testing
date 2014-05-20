/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
/**
 * 
 * @author Stefan Mijatov
 *
 */
public interface State extends EObject {

	org.modelexecution.fuml.Semantics.Classes.Kernel.Object getStateSnapshot(ValueInstance instance);

	ValueInstance getInstance(org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot);

	void addSnapshotMapping(ValueInstance instance, org.modelexecution.fuml.Semantics.Classes.Kernel.Object snapshot);

	Set<ValueInstance> getValueInstances();

	void copySnapshotMappings(State anotherState);

	EList<org.modelexecution.fuml.Semantics.Classes.Kernel.Object> getObjects();

	EList<Link> getLinks();

	State getSuccessor();

	void setSuccessor(State value);

	State getPredecessor();

	void setPredecessor(State value);

	ActivityNodeExecution getNodeExecution();

	void setNodeExecution(ActivityNodeExecution value);
}
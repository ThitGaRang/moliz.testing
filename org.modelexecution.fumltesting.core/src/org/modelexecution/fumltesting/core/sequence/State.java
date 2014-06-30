/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;

import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class State {

	private ActivityNodeExecution stateCreator;
	private HashMap<ValueInstance, Object_> objectSnapshotMappings = new HashMap<ValueInstance, Object_>();
	private HashMap<ValueInstance, Link> linkSnapshotMappings = new HashMap<ValueInstance, Link>();
	private State successor;
	private State predecessor;

	public State(ActivityNodeExecution stateCreator) {
		this.stateCreator = stateCreator;
	}

	public State getSuccessor() {
		return successor;
	}

	public void setSuccessor(State successor) {
		this.successor = successor;
	}

	public State getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(State predecessor) {
		this.predecessor = predecessor;
	}

	public ActivityNodeExecution getStateCreator() {
		return stateCreator;
	}

	public Set<ValueInstance> getStateObjectInstances() {
		return Collections.unmodifiableSet(objectSnapshotMappings.keySet());
	}

	public Set<ValueInstance> getStateLinkInstances() {
		return Collections.unmodifiableSet(linkSnapshotMappings.keySet());
	}

	public Object_ getStateObjectSnapshot(ValueInstance instance) {
		for (ValueInstance key : objectSnapshotMappings.keySet()) {
			if (key == instance)
				return objectSnapshotMappings.get(key);
		}
		return null;
	}

	public Link getStateLinkSnapshot(ValueInstance instance) {
		for (ValueInstance key : linkSnapshotMappings.keySet()) {
			if (key == instance)
				return linkSnapshotMappings.get(key);
		}
		return null;
	}

	public void addStateObjectSnapshot(Object_ object, ValueInstance instance) {
		objectSnapshotMappings.put(instance, object);
	}

	public void addStateLinkSnapshot(Link link, ValueInstance instance) {
		linkSnapshotMappings.put(instance, link);
	}

	public void removeStateObjectSnapshot(ValueInstance instance) {
		Object_ removedObject = getStateObjectSnapshot(instance);
		objectSnapshotMappings.remove(instance);
		for (ValueInstance linkInstance : linkSnapshotMappings.keySet()) {
			Link link = getStateLinkSnapshot(linkInstance);
			boolean sourceContained = false;
			FeatureValue sourceFeatureValue = null;
			for (FeatureValue featureValue : link.featureValues) {
				if (!link.type.navigableOwnedEnd.contains(featureValue.feature))
					sourceFeatureValue = featureValue;
			}
			if (sourceFeatureValue != null) {
				for (Value linkEndValue : sourceFeatureValue.values) {
					Reference reference = (Reference) linkEndValue;
					if(reference.referent == removedObject)
						sourceContained = true;
				}
			}
			if(sourceContained){
				linkSnapshotMappings.remove(instance);
			}
		}
	}
}
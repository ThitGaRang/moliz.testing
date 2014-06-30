/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Stefan Mijatov
 * 
 */
public class SequenceTrace {
	private List<Sequence> sequences;

	public List<Sequence> getSequences() {
		if (sequences == null) {
			sequences = new ArrayList<Sequence>();
		}
		return sequences;
	}
}
package org.modelexecution.fumltesting.results;

import org.eclipse.uml2.uml.ActivityParameterNode;

public class ActivityInput {
	private ActivityParameterNode parameter;
	private Object value;

	public ActivityInput(ActivityParameterNode parameter, Object value) {
		this.parameter = parameter;
		this.value = value;
	}

	public ActivityParameterNode getParameter() {
		return parameter;
	}

	public Object getValue() {
		return value;
	}
}
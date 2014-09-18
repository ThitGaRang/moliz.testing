package org.modelexecution.fumltesting.test;

import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.papyrus.PapyrusModelExecutor;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Parameter;

public class PetStoreUtil {
	private PapyrusModelExecutor executor = new PapyrusModelExecutor("model/petstore/petstore.di");

	public ParameterValue getParameterValue(String activityName, String parameterName, Object value) throws Exception {
		Activity activity = executor.getConversionResult().getActivity(activityName);
		ParameterValue parameterValue = new ParameterValue();

		// set up parameter
		for (Parameter parameter : activity.ownedParameter) {
			if (parameter.name.equals(parameterName)) {
				parameterValue.parameter = parameter;
				break;
			}
		}
		if (parameterValue.parameter == null) {
			throw new Exception("Parameter not found!");
		}

		// set up value
		Value convertedValue = null;
		if (value instanceof String) {
			convertedValue = new StringValue();
			((StringValue) convertedValue).value = (String) value;
			((StringValue) convertedValue).type = executor.getExecutionContext().getPrimitiveStringType();
		}
		if (value instanceof Integer) {
			convertedValue = new IntegerValue();
			((IntegerValue) convertedValue).value = (Integer) value;
			((IntegerValue) convertedValue).type = executor.getExecutionContext().getPrimitivIntegerType();
		}
		if (value instanceof Boolean) {
			convertedValue = new BooleanValue();
			((BooleanValue) convertedValue).value = (Boolean) value;
			((BooleanValue) convertedValue).type = executor.getExecutionContext().getPrimitiveBooleanType();
		}
		if (value instanceof Object_) {
			parameterValue.values.add((Object_) value);
		}

		return parameterValue;
	}

	public Trace executeActivity(String activityName, Object_ context, ParameterValueList parameters) {
		executor.getExecutionContext().getLocus().extensionalValues.clear();
		return executor.executeActivity(activityName, context, parameters);
	}
}
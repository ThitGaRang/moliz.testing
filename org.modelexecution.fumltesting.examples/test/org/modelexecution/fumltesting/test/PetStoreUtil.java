package org.modelexecution.fumltesting.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.modelexecution.fuml.convert.ConverterRegistry;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fuml.convert.IConverter;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.core.ExecutionEventListener;
import org.modelexecution.fumldebug.core.event.ActivityEntryEvent;
import org.modelexecution.fumldebug.core.event.Event;
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Parameter;

public class PetStoreUtil implements ExecutionEventListener {
	/** Result obtained from converting UML to fUML model. */
	private IConversionResult convertedModel;
	private ResourceSet resourceSet;
	private Resource resource;
	private NamedElement model;
	private int mainActivityID;

	public PetStoreUtil() {
		setup();
	}

	public ParameterValue createParameterValue(String activityName, String parameterName, Object value) throws Exception {
		Activity activity = convertedModel.getActivity(activityName);
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
			((StringValue) convertedValue).type = getExecutionContext().getPrimitiveStringType();
		}
		if (value instanceof Integer) {
			convertedValue = new IntegerValue();
			((IntegerValue) convertedValue).value = (Integer) value;
			((IntegerValue) convertedValue).type = getExecutionContext().getPrimitivIntegerType();
		}
		if (value instanceof Boolean) {
			convertedValue = new BooleanValue();
			((BooleanValue) convertedValue).value = (Boolean) value;
			((BooleanValue) convertedValue).type = getExecutionContext().getPrimitiveBooleanType();
		}
		parameterValue.values.add(convertedValue);

		return parameterValue;
	}

	public Object_ createReference(String className) {
		Class theClass = getUmlClass((org.eclipse.uml2.uml.Package) model, className);
		if (theClass != null) {
			Class_ class_ = (Class_) convertedModel.getFUMLElement(theClass);
			Object_ instance = getExecutionContext().getLocus().instantiate(class_);
			return instance;
		}
		return null;
	}

	public void setPropertyValue(Object_ instance, String property, Object value) {
		for (FeatureValue featureValue : instance.featureValues) {
			if (featureValue.feature.name.equals(property)) {
				if (value instanceof Boolean) {
					BooleanValue booleanValue = new BooleanValue();
					booleanValue.value = (boolean) value;
					featureValue.values.add(booleanValue);
				} else if (value instanceof String) {
					StringValue stringValue = new StringValue();
					stringValue.value = (String) value;
					featureValue.values.add(stringValue);
				} else if (value instanceof Integer) {
					IntegerValue integerValue = new IntegerValue();
					integerValue.value = (int) value;
					featureValue.values.add(integerValue);
				}
			}
		}
	}

	public Object getOutputValue(Trace trace, String activityName, String parameterName) {
		for (ActivityExecution execution : trace.getActivityExecutions()) {
			if (execution.getActivity().name.equals(activityName)) {
				for (OutputParameterSetting parameterSetting : execution.getActivityOutputs()) {
					if (parameterSetting.getParameter().name.equals(parameterName)) {
						if (parameterSetting.getParameterValues().size() == 1) {
							Value value = parameterSetting.getParameterValues().get(0).getValueSnapshot().getValue();
							if (value instanceof BooleanValue) {
								return ((BooleanValue) value).value;
							} else if (value instanceof StringValue) {
								return ((StringValue) value).value;
							} else if (value instanceof IntegerValue) {
								return ((IntegerValue) value).value;
							} else if (value instanceof Reference) {
								return ((Reference) value).referent;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public List<Object> getOutputValues(Trace trace, String activityName, String parameterName) {
		for (ActivityExecution execution : trace.getActivityExecutions()) {
			if (execution.getActivity().name.equals(activityName)) {
				for (OutputParameterSetting parameterSetting : execution.getActivityOutputs()) {
					if (parameterSetting.getParameter().name.equals(parameterName)) {
						ArrayList<Object> values = new ArrayList<Object>();
						for (OutputParameterValue value : parameterSetting.getParameterValues()) {
							if (value instanceof BooleanValue) {
								values.add(((BooleanValue) value).value);
							} else if (value instanceof StringValue) {
								values.add(((StringValue) value).value);
							} else if (value instanceof IntegerValue) {
								values.add(((IntegerValue) value).value);
							} else if (value instanceof Reference) {
								values.add(((Reference) value).referent);
							}
						}
					}
				}
			}
		}
		return null;
	}

	private Class getUmlClass(org.eclipse.uml2.uml.Package package_, String name) {
		for (Element element : package_.getOwnedElements()) {
			if (element instanceof Class && ((Class) element).getName().equals(name))
				return (Class) element;
			if (element instanceof org.eclipse.uml2.uml.Package) {
				Class aClass = getUmlClass((org.eclipse.uml2.uml.Package) element, name);
				if (aClass != null)
					return aClass;
			}
		}
		return null;
	}

	public Trace executeActivity(String activityName, Object_ context, ParameterValueList parameters) {
		Activity activity = convertedModel.getActivity(activityName);
		getExecutionContext().getLocus().extensionalValues.clear();
		getExecutionContext().execute(activity, context, parameters);
		return getExecutionContext().getTrace(mainActivityID);
	}

	private void setup() {
		try {
			resourceSet = new ResourceSetImpl();
			resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
			// model with UML elements under test, referenced by testing model
			resource = resourceSet.getResource(URI.createFileURI(new File("model/petstore/petstore.uml").getAbsolutePath()), true);
			resource.load(null);

			for (EObject model : resource.getContents()) {
				if (model instanceof NamedElement) {
					this.model = (NamedElement) model;
				}
			}
			ExecutionContext.getInstance().addEventListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		EcoreUtil.resolveAll(resourceSet);
		IConverter converter = ConverterRegistry.getInstance().getConverter(model);
		convertedModel = converter.convert(model);
	}

	private ExecutionContext getExecutionContext() {
		return ExecutionContext.getInstance();
	}

	@Override
	public void notify(Event event) {
		if (event instanceof ActivityEntryEvent && (((ActivityEntryEvent) event).getParent() == null)) {
			mainActivityID = ((ActivityEntryEvent) event).getActivityExecutionID();
		}
	}
}
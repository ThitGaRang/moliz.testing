package org.modelexecution.fumltesting.test.userstudy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
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
import org.modelexecution.fumldebug.core.trace.tracemodel.ActivityNodeExecution;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterSetting;
import org.modelexecution.fumldebug.core.trace.tracemodel.OutputParameterValue;
import org.modelexecution.fumldebug.core.trace.tracemodel.Trace;
import org.modelexecution.fumldebug.core.trace.tracemodel.ValueInstance;
import org.modelexecution.fumldebug.libraryregistry.LibraryRegistry;
import org.modelexecution.fumldebug.libraryregistry.OpaqueBehaviorCallReplacer;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Activities.IntermediateActivities.Activity;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Parameter;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

public class ExecutionTraceUtil implements ExecutionEventListener {
	/** Result obtained from converting UML to fUML model. */
	private IConversionResult convertedModel;
	private ResourceSet resourceSet;
	private Resource resource;
	private NamedElement model;
	private int mainActivityID;
	private ActivityExecution activityExecution;

	public ExecutionTraceUtil() {
		setup();
	}

	public void setActivityExecution(ActivityExecution activityExecution) {
		this.activityExecution = activityExecution;
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
		if (value instanceof Object_) {
			Reference reference = new Reference();
			reference.referent = (Object_) value;
			convertedValue = reference;
		}
		parameterValue.values.add(convertedValue);
		return parameterValue;
	}

	public Object_ createInstance(String className) {
		Class theClass = getUmlClass((Package) model, className);
		if (theClass != null) {
			Class_ class_ = (Class_) convertedModel.getFUMLElement(theClass);
			Object_ instance = getExecutionContext().getLocus().instantiate(class_);
			instance.createFeatureValues();
			return instance;
		}
		return null;
	}

	public Link createLink(String associationName) {
		Association theAssociation = getUmlAssociation((Package) model, associationName);
		if (theAssociation != null) {
			fUML.Syntax.Classes.Kernel.Association association = (fUML.Syntax.Classes.Kernel.Association) convertedModel.getFUMLElement(theAssociation);

			Link link = new Link();
			link.type = association;
			link.createFeatureValues();
			link.addTo(getExecutionContext().getLocus());
			return link;
		}
		return null;
	}

	public boolean isInLocus(Object instance) {
		return getExecutionContext().getExtensionalValues().contains(instance);
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

	public void setPropertyValue(Link link, String propertyName, Object_ value) {
		for (FeatureValue featureValue : link.featureValues) {
			if (featureValue.feature.name.equals(propertyName)) {
				Reference reference = new Reference();
				reference.referent = value;
				featureValue.values.add(reference);
				break;
			}
		}
	}

	public Object getPropertyValue(Object_ instance, String property) {
		for (FeatureValue featureValue : instance.featureValues) {
			if (featureValue.feature.name.equals(property)) {
				Value value = featureValue.values.get(0);
				if (value instanceof BooleanValue) {
					return ((BooleanValue) value).value;
				} else if (value instanceof StringValue) {
					return ((StringValue) value).value;
				} else if (value instanceof IntegerValue) {
					return ((IntegerValue) value).value;
				}
			}
		}
		return null;
	}

	public Object_ getLinkedObject(Object_ source, String associationName) {
		for (ValueInstance valueInstance : activityExecution.getTrace().getValueInstances()) {
			if (valueInstance.getRuntimeValue() instanceof Link && ((Link) valueInstance.getRuntimeValue()).type.name.equals(associationName)) {
				Link link = (Link) valueInstance.getRuntimeValue();
				if (link.type.name.equals(associationName)) {
					Object_ firstValue = ((Reference) link.featureValues.get(0).values.get(0)).referent;
					Object_ secondValue = ((Reference) link.featureValues.get(1).values.get(0)).referent;
					if (firstValue.equals(source)) {
						return secondValue;
					}
					if (secondValue.equals(source)) {
						return firstValue;
					}
				}
			}
		}
		return null;
	}

	public List<Object_> getLinkedObjects(Object_ source, String associationName) {
		List<Object_> linkedObjects = new ArrayList<Object_>();
		for (ValueInstance valueInstance : activityExecution.getTrace().getValueInstances()) {
			if (valueInstance.getRuntimeValue() instanceof Link && ((Link) valueInstance.getRuntimeValue()).type.name.equals(associationName)) {
				Link link = (Link) valueInstance.getRuntimeValue();
				if (link.type.name.equals(associationName)) {
					Object_ firstValue = ((Reference) link.featureValues.get(0).values.get(0)).referent;
					Object_ secondValue = ((Reference) link.featureValues.get(1).values.get(0)).referent;
					if (firstValue.equals(source)) {
						linkedObjects.add(secondValue);
					}
					if (secondValue.equals(source)) {
						linkedObjects.add(firstValue);
					}
				}
			}
		}
		return linkedObjects;
	}

	public Object getOutputValue(ActivityExecution activityExecution, String parameterName) {
		for (OutputParameterSetting parameterSetting : activityExecution.getActivityOutputs()) {
			if (parameterSetting.getParameter().name.equals(parameterName)) {
				if (parameterSetting.getParameterValues().size() == 1) {
					Value value = parameterSetting.getParameterValues().get(0).getValueSnapshot().getValue();
					if (value instanceof BooleanValue) {
						return ((BooleanValue) value).value;
					} else if (value instanceof StringValue) {
						return ((StringValue) value).value;
					} else if (value instanceof IntegerValue) {
						return ((IntegerValue) value).value;
					} else if (value instanceof Object_) {
						return (Object_) value;
					}
				}
			}
		}
		return null;
	}

	public boolean activityNodeExecuted(ActivityExecution activityExecution, String nodeName) {
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getNode().name.equals(nodeName) && nodeExecution.isExecuted())
				return true;
		}
		return false;
	}

	public int indexOfExecutedNode(ActivityExecution activityExecution, String nodeName) {
		for (ActivityNodeExecution nodeExecution : activityExecution.getNodeExecutions()) {
			if (nodeExecution.getNode().name.equals(nodeName) && nodeExecution.isExecuted())
				return activityExecution.getNodeExecutions().indexOf(nodeExecution);
		}
		return -1;
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

	private Class getUmlClass(Package package_, String name) {
		for (Element element : package_.getOwnedElements()) {
			if (element instanceof Class && ((Class) element).getName().equals(name))
				return (Class) element;
			if (element instanceof Package) {
				Class aClass = getUmlClass((Package) element, name);
				if (aClass != null)
					return aClass;
			}
		}
		return null;
	}

	private Association getUmlAssociation(Package package_, String name) {
		for (Element element : package_.getOwnedElements()) {
			if (element instanceof Association && ((Association) element).getName().equals(name)) {
				return (Association) element;
			}
			if (element instanceof Package) {
				Association anAssociation = getUmlAssociation((Package) element, name);
				if (anAssociation != null)
					return anAssociation;
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
		registerOpaqueBehaviors();
	}
	
	private void registerOpaqueBehaviors() {
		LibraryRegistry libraryRegistry = new LibraryRegistry(getExecutionContext());
		Map<String, OpaqueBehavior> registeredOpaqueBehaviors = libraryRegistry.loadRegisteredLibraries();
		OpaqueBehaviorCallReplacer.instance.replaceOpaqueBehaviorCalls(convertedModel.getAllActivities(), registeredOpaqueBehaviors);		
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
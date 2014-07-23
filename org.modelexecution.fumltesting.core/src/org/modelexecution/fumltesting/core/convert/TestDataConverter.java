/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.core.convert;

import java.util.HashMap;

import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumltesting.core.testlang.Attribute;
import org.modelexecution.fumltesting.core.testlang.DoubleValue;
import org.modelexecution.fumltesting.core.testlang.ObjectSpecification;
import org.modelexecution.fumltesting.core.testlang.ObjectValue;
import org.modelexecution.fumltesting.core.testlang.Scenario;
import org.modelexecution.fumltesting.core.testlang.TestSuite;
import org.modelexecution.fumltesting.core.testlang.Value;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Link;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Loci.LociL1.Locus;
import fUML.Syntax.Classes.Kernel.Association;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.Property;

/**
 * Utility class for converting test data specification into fUML objects, which
 * are than used as input for activity parameters.
 * 
 * @author Stefan Mijatov
 * 
 */
public class TestDataConverter {

	private Locus locus = ExecutionContext.getInstance().getLocus();
	private HashMap<ObjectSpecification, Object_> objects = new HashMap<ObjectSpecification, Object_>();

	public void cleanUpAndInit(TestSuite suite) {
		objects = new HashMap<ObjectSpecification, Object_>();
		locus.extensionalValues.removeAll(locus.extensionalValues);
		convertScenarios(suite);
	}

	public Object_ getFumlObject(ObjectValue objectValue) {
		return objects.get(objectValue.getValue());
	}

	public fUML.Semantics.Classes.Kernel.Value getFumlValue(Value value) {
		if (value instanceof org.modelexecution.fumltesting.core.testlang.StringValue) {
			String theValue = ((org.modelexecution.fumltesting.core.testlang.StringValue) value).getValue();
			return convertValue(theValue);
		} else if (value instanceof org.modelexecution.fumltesting.core.testlang.IntegerValue) {
			Integer theValue = ((org.modelexecution.fumltesting.core.testlang.IntegerValue) value).getValue();
			return convertValue(theValue);
		} else if (value instanceof DoubleValue) {
			Double theValue = ((DoubleValue) value).getValue();
			return convertValue(theValue);
		} else if (value instanceof org.modelexecution.fumltesting.core.testlang.BooleanValue) {
			Boolean theValue = ((org.modelexecution.fumltesting.core.testlang.BooleanValue) value).getValue();
			return convertValue(theValue);
		}
		return null;
	}

	private void convertScenarios(TestSuite suite) {
		for (Scenario scenario : suite.getAllScenarios()) {
			for (ObjectSpecification object : scenario.getAllObjects()) {
				ObjectValue objectValue = new ObjectValue(object);
				convertObject(objectValue);
			}
		}
	}

	private Object_ convertObject(ObjectValue value) {
		if (objects.containsKey(value.getValue()))
			return objects.get(value.getValue());

		ObjectSpecification object = ((ObjectValue) value).getValue();
		Scenario testData = object.getContainer();

		Object_ object_ = null;
		Class_ class_ = ((ObjectValue) value).getValue().getType();
		object_ = locus.instantiate(class_);

		for (Attribute attribute : object.getAllAttributes()) {
			Property property = ((Attribute) attribute).getProperty();
			Value theValue = ((Attribute) attribute).getValue();

			for (FeatureValue featureValue : object_.featureValues) {
				if (featureValue.feature.name.equals(property.name)) {
					fUML.Semantics.Classes.Kernel.Value simpleValue = getFumlValue(theValue);
					featureValue.values.add(simpleValue);
				}
			}
		}

		for (org.modelexecution.fumltesting.core.testlang.Link link : testData.getAllLinks()) {
			if (link.getSourceValue().equals(object)) {
				Link fumlLink = new Link();
				Association fumlAssoc = link.getAssociation();
				fumlLink.type = fumlAssoc;

				FeatureValue sourceValue = new FeatureValue();
				FeatureValue targetValue = new FeatureValue();

				Property source = link.getSourceProperty();
				Property target = link.getTargetProperty();

				fUML.Syntax.Classes.Kernel.Property sourcePropertyFuml = null;
				fUML.Syntax.Classes.Kernel.Property targetPropertyFuml = null;

				for (fUML.Syntax.Classes.Kernel.Property attribute : fumlAssoc.memberEnd) {
					if (attribute.name.equals(source.name)) {
						sourcePropertyFuml = attribute;
					}
					if (attribute.name.equals(target.name)) {
						targetPropertyFuml = attribute;
					}
				}

				sourceValue.feature = sourcePropertyFuml;
				ObjectValue objectValueSource = new ObjectValue(null);
				objectValueSource.setValue(link.getSourceValue());
				Reference sourceReference = new Reference();
				sourceReference.referent = object_;
				sourceValue.values.add(sourceReference);

				targetValue.feature = targetPropertyFuml;
				ObjectValue objectValueTarget = new ObjectValue(null);
				objectValueTarget.setValue(link.getTargetValue());
				Object_ targetObject_ = (Object_) convertObject(objectValueTarget);
				Reference targetReference = new Reference();
				targetReference.referent = targetObject_;
				targetValue.values.add(targetReference);

				fumlLink.featureValues.add(sourceValue);
				fumlLink.featureValues.add(targetValue);

				fumlLink.addTo(locus);
			}
		}
		objects.put(object, object_);
		return object_;
	}

	private fUML.Semantics.Classes.Kernel.Value convertValue(Object value) {
		if (value instanceof String) {
			StringValue fumlValue = new StringValue();
			fumlValue.type = locus.factory.getBuiltInType("String");
			fumlValue.value = (String) value;
			fumlValue.specify();
			return fumlValue;
		}
		if (value instanceof Boolean) {
			BooleanValue fumlValue = new BooleanValue();
			fumlValue.type = locus.factory.getBuiltInType("Boolean");
			fumlValue.value = (Boolean) value;
			fumlValue.specify();
			return fumlValue;
		}
		if (value instanceof Integer) {
			IntegerValue fumlValue = new IntegerValue();
			fumlValue.type = locus.factory.getBuiltInType("Integer");
			fumlValue.value = (Integer) value;
			fumlValue.specify();
			return fumlValue;
		}
		if (value instanceof Double) {
			IntegerValue fumlValue = new IntegerValue();
			fumlValue.type = locus.factory.getBuiltInType("Integer");
			fumlValue.value = (int) Math.round(((Double) value));
			return fumlValue;
		}
		return null;
	}
}
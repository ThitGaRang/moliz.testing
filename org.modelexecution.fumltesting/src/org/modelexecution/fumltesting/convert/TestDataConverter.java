/*
 * Copyright (c) 2012 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License v1.0 which accompanies 
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html 
 */
package org.modelexecution.fumltesting.convert;

import java.util.HashMap;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumltesting.testLang.TestLangFactory;
import org.modelexecution.fumltesting.testLang.UMLAttribute;
import org.modelexecution.fumltesting.testLang.UMLLink;
import org.modelexecution.fumltesting.testLang.UMLObjectSpecification;
import org.modelexecution.fumltesting.testLang.UMLObjectValue;
import org.modelexecution.fumltesting.testLang.UMLScenario;
import org.modelexecution.fumltesting.testLang.UMLSimpleValue;
import org.modelexecution.fumltesting.testLang.UMLValue;

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
@SuppressWarnings("restriction")
public class TestDataConverter {

	private ModelConverter modelConverter;
	private Locus locus = ExecutionContext.getInstance().getLocus();
	private HashMap<Object, Object> fumlElements = new HashMap<Object, Object>();

	public TestDataConverter(ModelConverter modelConverter) {
		this.modelConverter = modelConverter;
	}

	public void cleanUp() {
		fumlElements = new HashMap<Object, Object>();
		locus.extensionalValues.removeAll(locus.extensionalValues);
	}

	public Object getFUMLElement(UMLValue value) {
		if (value instanceof UMLSimpleValue) {
			XExpression expression = ((UMLSimpleValue) value).getValue();
			return getFumlValue(expression);
		}
		if (value instanceof UMLObjectValue) {
			if (fumlElements.containsKey(value))
				return fumlElements.get(value);
			UMLObjectSpecification object = ((UMLObjectValue) value).getValue();
			UMLScenario testData = (UMLScenario) object.eContainer();

			Object_ object_ = null;
			Class_ class_ = modelConverter.convertClass((((UMLObjectValue) value).getValue().getType()));
			object_ = locus.instantiate(class_);

			for (UMLAttribute attribute : object.getAttributes()) {
				Property property = modelConverter.convertProperty(((UMLAttribute) attribute).getAtt());
				XExpression expression = ((UMLSimpleValue) ((UMLAttribute) attribute).getValue()).getValue();

				for (FeatureValue featureValue : object_.featureValues) {
					if (featureValue.feature.name.equals(property.name)) {
						Object simpleValue = getFumlValue(expression);
						featureValue.values.add((fUML.Semantics.Classes.Kernel.Value) simpleValue);
					}
				}
			}

			for (UMLLink link : testData.getLinks()) {
				if (link.getSourceValue().equals(object)) {
					Link fumlLink = new Link();
					Association fumlAssoc = modelConverter.convertAssociation((link.getAssoc()));
					fumlLink.type = fumlAssoc;

					FeatureValue sourceValue = new FeatureValue();
					FeatureValue targetValue = new FeatureValue();

					Property source = modelConverter.convertProperty(link.getSourceProperty());
					Property target = modelConverter.convertProperty(link.getTargetProperty());

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
					UMLObjectValue objectValueSource = TestLangFactory.eINSTANCE.createUMLObjectValue();
					objectValueSource.setValue(link.getSourceValue());
					Reference sourceReference = new Reference();
					sourceReference.referent = object_;
					sourceValue.values.add(sourceReference);

					targetValue.feature = targetPropertyFuml;
					UMLObjectValue objectValueTarget = TestLangFactory.eINSTANCE.createUMLObjectValue();
					objectValueTarget.setValue(link.getTargetValue());
					Object_ targetObject_ = (Object_) getFUMLElement(objectValueTarget);
					Reference targetReference = new Reference();
					targetReference.referent = targetObject_;
					targetValue.values.add(targetReference);

					fumlLink.featureValues.add(sourceValue);
					fumlLink.featureValues.add(targetValue);

					fumlLink.addTo(locus);
				}
			}
			fumlElements.put(value, object_);
			return object_;
		}
		return null;
	}

	private Object getFumlValue(XExpression expression) {
		if (expression instanceof XStringLiteral) {
			StringValue fumlValue = new StringValue();
			String stringValue = ((XStringLiteral) expression).getValue();
			fumlValue.type = locus.factory.getBuiltInType("String");
			fumlValue.value = stringValue;
			fumlValue.specify();
			return fumlValue;
		}
		if (expression instanceof XBooleanLiteral) {
			BooleanValue fumlValue = new BooleanValue();
			boolean booleanValue = ((XBooleanLiteral) expression).isIsTrue();
			fumlValue.type = locus.factory.getBuiltInType("Boolean");
			fumlValue.value = booleanValue;
			fumlValue.specify();
			return fumlValue;
		}
		if (expression instanceof XNumberLiteral) {
			IntegerValue fumlValue = new IntegerValue();
			double numberValue = Double.valueOf(((XNumberLiteral) expression).getValue());
			fumlValue.type = locus.factory.getBuiltInType("Integer");
			fumlValue.value = new Integer((int) numberValue);
			fumlValue.specify();
			return fumlValue;
		}
		return null;
	}
}
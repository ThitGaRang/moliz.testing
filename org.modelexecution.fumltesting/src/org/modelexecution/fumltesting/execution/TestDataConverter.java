package org.modelexecution.fumltesting.execution;

import java.util.HashMap;

import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.modelexecution.fuml.convert.IConversionResult;
import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumltesting.testLang.Attribute;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.Scenario;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.TestLangFactory;
import org.modelexecution.fumltesting.testLang.Value;

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

/**
 * Utility class for converting test data specification into fUML objects, which
 * are than used as input for activity parameters.
 * 
 * @author Stefan Mijatov
 * 
 */
@SuppressWarnings("restriction")
public class TestDataConverter {

	private static TestDataConverter INSTANCE;
	private IConversionResult model;
	private Locus locus;
	private HashMap<Value, Object> fumlObjects;

	private TestDataConverter() {
		locus = ExecutionContext.getInstance().getLocus();
		fumlObjects = new HashMap<Value, Object>();
	}

	public void cleanUp() {
		fumlObjects = new HashMap<Value, Object>();
		locus.extensionalValues.removeAll(locus.extensionalValues);
	}

	public static TestDataConverter getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TestDataConverter();
		}
		return INSTANCE;
	}

	public static void setModel(IConversionResult model) {
		TestDataConverter.getInstance().model = model;
	}

	public Object getFUMLElement(Value value) {
		// TODO needs more testing..
		if (fumlObjects.containsKey(value))
			return fumlObjects.get(value);

		if (value instanceof SimpleValue) {
			XExpression expression = ((SimpleValue) value).getValue();
			return getFumlValue(expression);
		}
		if (value instanceof ObjectValue) {
			ObjectSpecification object = ((ObjectValue) value).getValue();
			Scenario testData = (Scenario) object.eContainer();

			Object_ object_ = null;
			Class_ class_ = (Class_) model.getFUMLElement(((ObjectValue) value)
					.getValue().getType());
			object_ = locus.instantiate(class_);

			for (Attribute attribute : object.getAttributes()) {
				Property property = (Property) ((Attribute) attribute).getAtt();
				XExpression expression = ((SimpleValue) ((Attribute) attribute)
						.getValue()).getValue();

				for (FeatureValue featureValue : object_.featureValues) {
					if (featureValue.feature.name.equals(property.getName())) {
						Object simpleValue = getFumlValue(expression);
						featureValue.values
								.add((fUML.Semantics.Classes.Kernel.Value) simpleValue);
					}
				}
			}

			for (org.modelexecution.fumltesting.testLang.Link link : testData
					.getLinks()) {
				if (link.getSourceValue().equals(object)) {
					Link fumlLink = new Link();
					Association fumlAssoc = (Association) model
							.getFUMLElement(link.getAssoc());
					fumlLink.type = fumlAssoc;

					FeatureValue sourceValue = new FeatureValue();
					FeatureValue targetValue = new FeatureValue();

					Property source = link.getSourceProperty();
					Property target = link.getTargetProperty();

					fUML.Syntax.Classes.Kernel.Property sourcePropertyFuml = null;
					fUML.Syntax.Classes.Kernel.Property targetPropertyFuml = null;

					for (fUML.Syntax.Classes.Kernel.Property attribute : fumlAssoc.memberEnd) {
						if (attribute.name.equals(source.getName())) {
							sourcePropertyFuml = attribute;
						}
						if (attribute.name.equals(target.getName())) {
							targetPropertyFuml = attribute;
						}
					}

					sourceValue.feature = sourcePropertyFuml;
					ObjectValue objectValueSource = TestLangFactory.eINSTANCE
							.createObjectValue();
					objectValueSource.setValue(link.getSourceValue());
					Reference sourceReference = new Reference();
					sourceReference.referent = object_;
					sourceValue.values.add(sourceReference);

					targetValue.feature = targetPropertyFuml;
					ObjectValue objectValueTarget = TestLangFactory.eINSTANCE
							.createObjectValue();
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
			double numberValue = Double.valueOf(((XNumberLiteral) expression)
					.getValue());
			fumlValue.type = locus.factory.getBuiltInType("Integer");
			fumlValue.value = new Integer((int) numberValue);
			fumlValue.specify();
			return fumlValue;
		}
		return null;
	}
}
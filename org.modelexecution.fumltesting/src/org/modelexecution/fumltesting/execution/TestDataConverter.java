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
import org.modelexecution.fumltesting.testLang.Feature;
import org.modelexecution.fumltesting.testLang.ObjectSpecification;
import org.modelexecution.fumltesting.testLang.ObjectValue;
import org.modelexecution.fumltesting.testLang.SimpleValue;
import org.modelexecution.fumltesting.testLang.Value;

import UMLPrimitiveTypes.UnlimitedNatural;
import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fUML.Semantics.Loci.LociL1.Locus;
import fUML.Syntax.Classes.Kernel.Class_;

/**
 * Utility class for converting test data specification into fUML objects,
 * which are than used as input for activity parameters.
 * @author Stefan Mijatov
 *
 */
@SuppressWarnings("restriction")
public class TestDataConverter {
	
	private IConversionResult model;
	private HashMap<String, Object_> objects = new HashMap<String, Object_>();
	private Locus locus = ExecutionContext.getInstance().getLocus();
	
	public TestDataConverter(IConversionResult model){
		this.model = model;
	}
	
	public Object getFUMLElement(Value value){		
		if(value instanceof SimpleValue){
			XExpression expression = ((SimpleValue)value).getValue();
			return getFumlValue(expression);
		}		
		if(value instanceof ObjectValue){
			ObjectSpecification object = ((ObjectValue)value).getValue();			
			
			if(objects.containsKey(object.getName())){
				return objects.get(object.getName());
			}
			
			Object_ object_ = null;
			Class_ class_ = (Class_)model.getFUMLElement(((ObjectValue) value).getValue().getType());
			object_ = locus.instantiate(class_);
			
			for(Feature feature: object.getFeatures()){
				if(feature instanceof Attribute){
					Property property = (Property)((Attribute)feature).getAtt();
					XExpression expression = ((SimpleValue)((Attribute)feature).getValue()).getValue(); 
					
					for(FeatureValue featureValue: object_.featureValues){
						if(featureValue.feature.name.equals(property.getName())){
							Object simpleValue = getFumlValue(expression);
							featureValue.values.add((fUML.Semantics.Classes.Kernel.Value)simpleValue);
						}
					}
				}				
			}
			
			objects.put(object.getName(), object_);
			return object_;
		}
		return null;
	}
	
	private Object getFumlValue(XExpression expression){
		if(expression instanceof XStringLiteral){
			StringValue fumlValue = new StringValue();
			String stringValue = ((XStringLiteral)expression).getValue();
			fumlValue.type = locus.factory.getBuiltInType("String");
			fumlValue.value = stringValue;
			fumlValue.specify();
			return fumlValue;
		}
		if(expression instanceof XBooleanLiteral){
			BooleanValue fumlValue = new BooleanValue();
			boolean booleanValue = ((XBooleanLiteral)expression).isIsTrue();
			fumlValue.type = locus.factory.getBuiltInType("Boolean");
			fumlValue.value = booleanValue;
			fumlValue.specify();
			return fumlValue;
		}
		if(expression instanceof XNumberLiteral){
			UnlimitedNaturalValue fumlValue = new UnlimitedNaturalValue();
			double numberValue = Double.valueOf(((XNumberLiteral)expression).getValue());
			fumlValue.type = locus.factory.getBuiltInType("UnlimitedNatural");
			fumlValue.value = new UnlimitedNatural((int)numberValue);
			fumlValue.specify();
			return fumlValue;
		}
		return null;
	}
}
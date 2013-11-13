package org.modelexecution.fumltesting.sequence.execution;

import java.util.HashMap;

import org.modelexecution.fuml.Semantics.Classes.Kernel.KernelFactory;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Link;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Object;
import org.modelexecution.fuml.Semantics.Classes.Kernel.Value;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Association;
import org.modelexecution.fuml.Syntax.Classes.Kernel.Class;
import org.modelexecution.fuml.Syntax.Classes.Kernel.StructuralFeature;
import org.modelexecution.fuml.Syntax.Classes.Kernel.VisibilityKind;

import fUML.Semantics.Classes.Kernel.BooleanValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.StringValue;
import fUML.Syntax.Classes.Kernel.Class_;
import fUML.Syntax.Classes.Kernel.NamedElement;

/** Mappings from fUML implementation classes to fUML meta model classes */
public class SequenceMapper {
	private HashMap<Class_, Class> mappedClasses= new HashMap<Class_, Class>();
	private HashMap<fUML.Syntax.Classes.Kernel.Association, Association> mappedAssociations= new HashMap<fUML.Syntax.Classes.Kernel.Association, Association>();
	
	public SequenceMapper(){}
	
	public Object map(Object_ object_){
		Object object = KernelFactory.eINSTANCE.createObject();
		object.getTypes().add(map(object_.types.get(0)));		
		
		for(FeatureValue featureValue: object_.featureValues){
			org.modelexecution.fuml.Semantics.Classes.Kernel.FeatureValue mappedFeatureValue = KernelFactory.eINSTANCE.createFeatureValue();
			mappedFeatureValue.setFeature(map(featureValue.feature));
			for(fUML.Semantics.Classes.Kernel.Value value: featureValue.values){
				mappedFeatureValue.getValues().add(map(value));
			}
			object.getFeatureValues().add(mappedFeatureValue);
		}
		
		return object;
	}
	
	public Link map(fUML.Semantics.Classes.Kernel.Link link){
		Link mappedLink = KernelFactory.eINSTANCE.createLink();		
		mappedLink.setType(map(link.type));		
		
		for(FeatureValue featureValue: link.featureValues){
			org.modelexecution.fuml.Semantics.Classes.Kernel.FeatureValue mappedFeatureValue = KernelFactory.eINSTANCE.createFeatureValue();
			mappedFeatureValue.setFeature(map(featureValue.feature));
			for(fUML.Semantics.Classes.Kernel.Value value: featureValue.values){
				mappedFeatureValue.getValues().add(map(value));
			}
			mappedLink.getFeatureValues().add(mappedFeatureValue);
		}
		
		return mappedLink;
	}
	
	private Class map(Class_ class_){
		if(mappedClasses.containsKey(class_)){
			return mappedClasses.get(class_);
		}else{
			Class mappedClass = org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory.eINSTANCE.createClass();
			
			mappedClass.setAbstract(class_.isAbstract);
			mappedClass.setActive(class_.isActive);
			mappedClass.setFinalSpecialization(class_.isFinalSpecialization);
			mappedClass.setName(class_.name);
			mappedClass.setQualifiedName(class_.qualifiedName);
			mappedClass.setVisibility(mapVisibility(class_));
			
			mappedClasses.put(class_, mappedClass);
			/** Following fields are NOT set: ClassifierBehavior, NameSpace, Owner, Package */
			return mappedClass;
		}
	}
	
	private Association map(fUML.Syntax.Classes.Kernel.Association association){
		if(mappedAssociations.containsKey(association)){
			return mappedAssociations.get(association);
		}else{
			Association mappedAssociation = org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory.eINSTANCE.createAssociation();
			
			mappedAssociation.setAbstract(association.isAbstract);
			mappedAssociation.setAbstract(association.isDerived);
			mappedAssociation.setFinalSpecialization(association.isFinalSpecialization);
			mappedAssociation.setName(association.name);
			mappedAssociation.setQualifiedName(association.qualifiedName);
			mappedAssociation.setVisibility(mapVisibility(association));
			
			mappedAssociations.put(association, mappedAssociation);
			/** Following fields are NOT set: NameSpace, Owner, Package */
			return mappedAssociation;
		}		
	}
	
	private StructuralFeature map(fUML.Syntax.Classes.Kernel.StructuralFeature structuralFeature){
		StructuralFeature mappedFeature = org.modelexecution.fuml.Syntax.Classes.Kernel.KernelFactory.eINSTANCE.createProperty();
		
		mappedFeature.setLeaf(structuralFeature.isLeaf);
		mappedFeature.setLower(structuralFeature.multiplicityElement.lower);
		mappedFeature.setName(structuralFeature.name);
		mappedFeature.setOrdered(structuralFeature.multiplicityElement.isOrdered);
		mappedFeature.setQualifiedName(structuralFeature.qualifiedName);
		mappedFeature.setReadOnly(structuralFeature.isReadOnly);
		mappedFeature.setStatic(structuralFeature.isStatic);
		mappedFeature.setUnique(structuralFeature.multiplicityElement.isUnique);
		mappedFeature.setUpper(structuralFeature.multiplicityElement.upper.naturalValue);
		mappedFeature.setVisibility(mapVisibility(structuralFeature));
		
		/** Following fields are NOT set: LowerValue, UpperValue, NameSpace, Owner, Type */
		return mappedFeature;
	}
	
	private Value map(fUML.Semantics.Classes.Kernel.Value value){
		Value mappedValue = null;
		
		if(value instanceof BooleanValue){
			mappedValue = KernelFactory.eINSTANCE.createBooleanValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.BooleanValue)mappedValue).setValue(((BooleanValue) value).value);			
		}
		if(value instanceof StringValue){
			mappedValue = KernelFactory.eINSTANCE.createStringValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.StringValue)mappedValue).setValue(((StringValue) value).value);
		}
		if(value instanceof IntegerValue){
			mappedValue = KernelFactory.eINSTANCE.createIntegerValue();
			((org.modelexecution.fuml.Semantics.Classes.Kernel.IntegerValue)mappedValue).setValue(((IntegerValue) value).value);
		}
		if(value instanceof Reference){
			mappedValue = map(((Reference) value).referent);
		}
		
		return mappedValue;
	}
	
	private VisibilityKind mapVisibility(NamedElement element){
		switch(element.visibility){
		case package_:
			return VisibilityKind.PACKAGE;
		case private_:
			return VisibilityKind.PRIVATE;
		case protected_:
			return VisibilityKind.PROTECTED;
		case public_:
			return VisibilityKind.PUBLIC;
		default:
			return null;
		}
	}
}
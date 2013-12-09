package org.modelexecution.fumltesting.ocl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.modelexecution.fumltesting.sequence.SequencePackage;
import org.modelexecution.fumltesting.sequence.State;

/**
 * Utility class for loading and evaluating OCL constraints.
 * 
 * @author Stefan Mijatov
 * 
 */
public class OclUtil {
	private OCL ocl;
	private OCLHelper<EClassifier, ?, ?, Constraint> helper;
	private static OclUtil INSTANCE;

	private OclUtil() {
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		helper = ocl.createOCLHelper();
	}

	public static OclUtil getInstance() {
		if (INSTANCE == null)
			INSTANCE = new OclUtil();
		return INSTANCE;
	}

	public boolean evaluate(State context, String invariant) throws ParserException {
		helper.setContext(SequencePackage.Literals.STATE);
		OCLExpression<EClassifier> constraint = helper.createQuery(invariant);
		Query constraintEvaluation = ocl.createQuery(constraint);
		return constraintEvaluation.check(context);
	}

	public Object query(State context, String query) throws ParserException {
		helper.setContext(SequencePackage.Literals.STATE);
		OCLExpression<EClassifier> queryExpression = helper.createQuery(query);
		Query queryEvaluation = ocl.createQuery(queryExpression);
		return queryEvaluation.evaluate(context);
	}
}
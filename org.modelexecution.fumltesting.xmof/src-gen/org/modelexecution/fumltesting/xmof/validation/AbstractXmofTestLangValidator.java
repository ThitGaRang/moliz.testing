/*
 * generated by Xtext
 */
package org.modelexecution.fumltesting.xmof.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractXmofTestLangValidator extends org.eclipse.xtext.xbase.validation.XbaseValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.modelexecution.fumltesting.xmof.xmofTestLang.XmofTestLangPackage.eINSTANCE);
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/xbase/Xbase"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/common/JavaVMTypes"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/xbase/Xtype"));
		return result;
	}
}

/*
* generated by Xtext
*/
package org.modelexecution.fumltesting.xmof.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class XmofTestLangAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/modelexecution/fumltesting/xmof/parser/antlr/internal/InternalXmofTestLang.tokens");
	}
}

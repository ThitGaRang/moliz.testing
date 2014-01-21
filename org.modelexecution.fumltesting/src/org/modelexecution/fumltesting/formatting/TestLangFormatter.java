package org.modelexecution.fumltesting.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

public class TestLangFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getGrammar());
		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getGrammar());
		c.setLinewrap(0, 1, 1).after(getGrammarAccess().getGrammar());
	}
}
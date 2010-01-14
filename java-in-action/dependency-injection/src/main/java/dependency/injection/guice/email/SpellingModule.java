package dependency.injection.guice.email;

import com.google.inject.AbstractModule;
import dependency.injection.model.email.English;
import dependency.injection.model.email.EnglishSpellChecker;
import dependency.injection.model.email.French;
import dependency.injection.model.email.FrenchSpellChecker;
import dependency.injection.model.email.SpellChecker;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 1:06:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpellingModule extends AbstractModule{
	@Override
	protected void configure() {
		bind(SpellChecker.class).annotatedWith(English.class).to(EnglishSpellChecker.class);
		bind(SpellChecker.class).annotatedWith(French.class).to(FrenchSpellChecker.class);
	}
}

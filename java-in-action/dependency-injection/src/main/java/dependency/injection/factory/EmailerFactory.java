package dependency.injection.factory;

import dependency.injection.model.email.EmailBook;
import dependency.injection.model.email.FrenchSpellChecker;
import dependency.injection.model.email.JapaneseSpellChecker;
import dependency.injection.model.email.SimpleFrenchTextEditor;
import dependency.injection.model.email.SimpleJapaneseTextEditor;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 1:51:36 AM
 */
public class EmailerFactory {
	private static Emailer instance;

	public Emailer newEmailer() {
		if(null == instance)
			return new Emailer();
		return instance;
	}

	/* save mock instance to static holder */

	static void set(Emailer mock) {
		instance = mock;
	}

	public Emailer newFrenchEmailer() {
		Emailer service = new Emailer();
		service.setSpellChecker(new FrenchSpellChecker());
		service.setAddressBook(new EmailBook());
		service.setTextEditor(new SimpleFrenchTextEditor());
		return service;
	}

	public Emailer newJapaneseEmailer() {
		Emailer service = new Emailer();
		service.setSpellChecker(new JapaneseSpellChecker());
		service.setAddressBook(new EmailBook());
		service.setTextEditor(new SimpleJapaneseTextEditor());
		return service;
	}

	public Emailer newEnglishEmailer() {
		return null;  //To change body of created methods use File | Settings | File Templates.
	}

}

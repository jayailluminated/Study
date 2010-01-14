package dependency.injection.model;

import dependency.injection.model.email.SpellChecker;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 12:50:33 AM
 */
public class MockSpellChecker implements SpellChecker {


	@Override
	public boolean check(String text) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
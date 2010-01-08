package dependency.injection.setter;

import dependency.injection.model.SpellChecker;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 12:40:38 AM
 */
public class Emailer {
	private SpellChecker spellChecker;

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}


	public void send(String message) {
		System.out.println("message : "+ message);
	}
}

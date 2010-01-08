package dependency.injection.factory;

import dependency.injection.model.EmailBook;
import dependency.injection.model.JapaneseSpellChecker;
import dependency.injection.model.SimpleJapaneseTextEditor;
import dependency.injection.model.SpellChecker;
import dependency.injection.model.TextEditor;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 1:50:23 AM
 */
public class Emailer {

	/*
	* The most important thing to notice here is that the client code has no reference
	* to spellchecking, address books, or any of the other internals of Emailer
	* */
//	Emailer service = new EmailerFactory().newFrenchEmailer();

	private SpellChecker spellChecker;

	public Emailer(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}


	public Emailer() {

	}

	public void setSpellChecker(SpellChecker japaneseSpellChecker) {
	}

	public void setTextEditor(TextEditor simpleJapaneseTextEditor) {
	}

	public void setAddressBook(EmailBook emailBook) {
	}

	public void send(String message) {
		System.out.println("message send : "+ message);
	}
}

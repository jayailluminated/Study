package dependency.injection.guice.email;

import com.google.inject.Inject;
import dependency.injection.model.email.SpellChecker;

public class Emailer {
    private SpellChecker spellChecker;

    @Inject
    public Emailer(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	//    public void send(String text) {
//        spellChecker.check(text);
//         send if ok
//    }
    
}
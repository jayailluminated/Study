package dependency.injection.guice;

import com.google.inject.Inject;
import dependency.injection.model.SpellChecker;

public class Emailer {
    private SpellChecker spellChecker;

    @Inject
    public Emailer(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void send(String text) {
        spellChecker.check(text);
    }
}
package dependency.injection.model.email;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 12:42:03 AM
 */
public class EnglishSpellChecker implements SpellChecker {
    @Override
    public boolean check(String text) {
        return text.equals("Hello");
    }
}

package dependency.injection.model.email;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 1:52:08 AM
 */
public class FrenchSpellChecker implements SpellChecker {
    @Override
    public boolean check(String text) {
        return text.equals("Bonjour");
    }
}

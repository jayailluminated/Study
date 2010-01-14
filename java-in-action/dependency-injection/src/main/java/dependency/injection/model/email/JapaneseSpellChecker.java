package dependency.injection.model.email;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 2:01:50 AM
 */
public class JapaneseSpellChecker implements SpellChecker{
    @Override
    public boolean check(String text) {
        return text.equals("???");
    }
}

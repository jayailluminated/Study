package dependency.injection.guice.email;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Key;
import dependency.injection.model.email.English;
import dependency.injection.model.email.SpellChecker;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 11, 2010
 * Time: 2:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
//public class EmailModule implements Module{
//    public void configure(Binder binder){
//        binder.bind(Emailer.class);
//        binder.bind(SpellChecker.class);
        
//    }
//}

public class EmailModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Emailer.class);
        bind(SpellChecker.class);
    }
}

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 1:14:43 AM
 * To change this template use File | Settings | File Templates.
 */
//public class EmailModule {
//	public static void main(String[] args) {
//		Guice.createInjector(new SpellingModule()).getInstance(Key.get(SpellChecker.class, English.class))
//				.check("Hello!");
//
//	}
//}
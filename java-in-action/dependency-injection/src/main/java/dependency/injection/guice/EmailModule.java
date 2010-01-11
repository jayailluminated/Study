package dependency.injection.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;
import dependency.injection.model.SpellChecker;

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
        ...
//    }
//}

public class EmailModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Emailer.class);
        bind(SpellChecker.class);
    }
}
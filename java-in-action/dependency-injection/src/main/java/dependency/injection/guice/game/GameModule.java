package dependency.injection.guice.game;

import com.google.inject.AbstractModule;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 12:17:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameModule extends AbstractModule{
    @Override
    protected void configure() {

        //this will not compile because HalfList is the pcgame
//        bind(WiiGame.class).to(HalfLife.class);        
    }
}

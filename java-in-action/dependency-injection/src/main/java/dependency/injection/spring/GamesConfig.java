package dependency.injection.spring;

import dependency.injection.model.game.HalfLife;
import dependency.injection.model.game.Wii;
import dependency.injection.model.game.WiiGame;
import org.springframework.config.java.annotation.Bean;
import org.springframework.config.java.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 12:14:23 AM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class GamesConfig {

    @Bean
    public WiiGame game() {
//        return new HalfLife();
	    return null;
    }

    @Bean
    public Wii gameConsole() {
	    return new Wii(game());
    }
}

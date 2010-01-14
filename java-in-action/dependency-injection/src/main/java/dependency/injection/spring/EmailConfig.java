package dependency.injection.spring;

import dependency.injection.model.email.EnglishSpellChecker;
import dependency.injection.model.email.SpellChecker;
import org.springframework.config.java.annotation.Bean;
import org.springframework.config.java.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 1:28:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class EmailConfig {

	@Bean
	public SpellChecker english() {
		return new EnglishSpellChecker();
	}

	@Bean
	public Emailer emailer() {
		return new Emailer(english());
	}

}

package dependency.injection.factory;

import org.junit.Test;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 2:12:43 AM
 */

public class EmailerTest {

	@Test
	public void testEmailClient() {
		MockEmailer mock = new MockEmailer();
		EmailerFactory.set(mock);

		try{
			new EmailClient().run();
			assert mock.correctlySent();

		} finally {
			EmailerFactory.set(null);
			
		}

	}

	@Test
	public void testEmailer() {
		MockSpellChecker spellChecker = new MockSpellChecker();
	}
}

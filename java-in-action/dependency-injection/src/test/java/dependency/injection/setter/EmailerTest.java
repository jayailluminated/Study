package dependency.injection.setter;

import dependency.injection.model.MockSpellChecker;
import dependency.injection.setter.Emailer;
import org.junit.*;
import junit.framework.JUnit4TestAdapter;

/**
 * User: jungjooseo
 * Date: Jan 8, 2010
 * Time: 12:45:11 AM
 */
public class EmailerTest {
	public static Test suite() {
		return (Test) new JUnit4TestAdapter(EmailerTest.class);
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void ensureEmailerCheckerSpelling() {
		MockSpellChecker mock = new MockSpellChecker();
		Emailer emailer = new Emailer();
		emailer.setSpellChecker(mock);
		emailer.send("Hello there");
	}
}
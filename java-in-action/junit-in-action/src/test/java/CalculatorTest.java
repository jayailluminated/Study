import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: moretajoo
 * Date: Oct 10, 2010
 * Time: 5:46:04 PM
 */
public class CalculatorTest {

	@Before
	public void setUp () {
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(10, 50);
		assertEquals(60, result, 0);
	}
}
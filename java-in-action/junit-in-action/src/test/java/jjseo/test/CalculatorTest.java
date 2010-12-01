package jjseo.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: moretajoo
 * Date: Oct 10, 2010
 * Time: 5:46:04 PM
 */
public class CalculatorTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Test
    public void testLog() {
        logger.debug("logger test");
    }
}
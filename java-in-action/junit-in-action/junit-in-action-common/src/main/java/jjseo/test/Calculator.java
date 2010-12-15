package jjseo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User: moretajoo
 * Date: Oct 10, 2010
 * Time: 5:45:57 PM
 */
public class Calculator {
    static Logger logger = LoggerFactory.getLogger(Calculator.class);

    public double add (double number1, double number2) {
        logger.debug("test values {}", number1);
        return number1 + number2;
    }
}

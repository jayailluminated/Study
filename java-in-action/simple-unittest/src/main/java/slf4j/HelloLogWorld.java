package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLogWorld {

	final	Logger logger = LoggerFactory.getLogger(HelloLogWorld.class);
	Integer t;
	Integer oldT;

	public void printLogLevel() {
		logger.debug(HelloLogWorld.class.getName());

		logger.trace("Hello World");
		logger.debug("Hello World");
		logger.info("Hello World");
		logger.warn("Hello World");
		logger.error("Hello World");

		
	}

	public void usingSlf4jPlaceholder(Integer temperature) {
		oldT = t;
		t = temperature;

		logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);

		if (temperature.intValue() > 50) {
			logger.info("Temperature has risen above 50 degrees.");
		}
	}
}
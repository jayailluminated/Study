package springstudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 2:22:07 AM
 */
public class Main {



		final Logger logger = LoggerFactory.getLogger(Main.class);
		Integer t;
		Integer oldT;

		public Main() {
			t = new Integer(0);
			oldT = t;
		}

		public void setTemperature(Integer temperature) {
			oldT = t;
			t = temperature;
			logger.debug("Temperature set to{}. Old temperature was {}.", t, oldT);

			if(temperature.intValue() > 50) {
				logger.info("Temperature has risen above 50 degrees.");
			}
		}

		public static void main(String[] args) {
			Main test = new Main();
			test.setTemperature(new Integer(10));
			test.setTemperature(new Integer(60));
		}

}

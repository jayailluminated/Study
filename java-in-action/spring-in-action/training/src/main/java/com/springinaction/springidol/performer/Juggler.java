package com.springinaction.springidol.performer;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.PerformerApp;
import com.springinaction.springidol.performer.Performer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 12:25:28 AM
 */
public class Juggler implements Performer {
	final Logger logger = LoggerFactory.getLogger(PerformerApp.class.getSimpleName());

	private int beanBags = 3;

	public Juggler() {}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public void perform() throws PerformanceException {
		logger.debug("{} is name", beanBags);

		logger.debug("JUGGLING {} BEANBAGS", beanBags);
	}
}

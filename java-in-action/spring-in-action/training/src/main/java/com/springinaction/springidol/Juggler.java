package com.springinaction.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 12:25:28 AM
 */
public class Juggler implements Performer{
	static Logger logger = LoggerFactory.getLogger(PerformerApp.class.getSimpleName());

	private int beanBags = 3;

	public Juggler() {}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public String perform() throws PerformanceException {
		logger.debug("{} is name", beanBags);
		return "JUGGLING " + beanBags + "BEANBAGS";
		
	}
}

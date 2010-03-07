package com.springinaction.scripting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: moretajoo
 * Date: Mar 3, 2010
 * Time: 11:51:48 PM
 */
public class Coconut {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Coconut () {
	}

	public void drinkThemBothUp() {
		logger.info("You put the lime in the coconut");
		logger.info("and drink 'em both up...");
		logger.info("You put the lime in the coconut");
		lime.drink();
	}

	private Lime lime;

	public void setLime (Lime lime) {
		this.lime = lime;
	}
}

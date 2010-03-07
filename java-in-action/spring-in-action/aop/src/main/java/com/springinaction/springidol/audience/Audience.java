package com.springinaction.springidol.audience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: moretajoo
 * Date: Mar 4, 2010
 * Time: 11:41:12 PM
 */
public class Audience {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public Audience () {
	}

	public void takeSeats(){
		logger.info("The audience is taking their seats.");
	}

	public void turnOffCellPhones(){
		logger.info("The adience is turning off "+ "their cellphones");
	}

	public void applaud() {
		logger.info("CLAP CLAP CLAP CLAP CLAP CLAP CLAP");
	}

	public void demandRefund(){
		logger.info("Boo ! We want our money back!!");
	}
}
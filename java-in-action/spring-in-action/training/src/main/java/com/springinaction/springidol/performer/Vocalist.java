package com.springinaction.springidol.performer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 23, 2010
 * Time: 1:48:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vocalist implements Performer{
	Logger logger = LoggerFactory.getLogger(Vocalist.class);
	private String song;


	@Override
	public void perform () throws PerformanceException {
		logger.info("Singing {}");

	}

	public void setSong (String song) {
		//To change body of created methods use File | Settings | File Templates.
	}
}

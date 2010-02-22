package com.springinaction.springidol.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 1:09:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cymbal implements Instrument{
	Logger logger = LoggerFactory.getLogger(Cymbal.class);

	public Cymbal () {
	}

	@Override
	public void play () {
		logger.info("play Cymbal");
	}

	@Override
	public void tune () {
		logger.info("Cymbal tune");
	}

	@Override
	public void clean () {
		logger.info("Cymbal clean");
	}
}

package com.springinaction.springidol.instrument;

import com.springinaction.springidol.instrument.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 19, 2010
 * Time: 12:30:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Saxophone implements Instrument {

	Logger logger = LoggerFactory.getLogger(Saxophone.class.getSimpleName());

	public Saxophone () {
	}


	@Override
	public void play () {
		logger.info("TOOT TOOT TOOT");
	}

	@Override
	public void tune () {
		logger.info("Saxophone tune");
	}

	@Override
	public void clean () {
		logger.info("Saxophone clean");
	}
}

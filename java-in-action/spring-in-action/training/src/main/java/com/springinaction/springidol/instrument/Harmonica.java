package com.springinaction.springidol.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 1:11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Harmonica implements Instrument{
	Logger logger = LoggerFactory.getLogger(Harmonica.class);

	public Harmonica () {
	}

	@Override
	public void play () {
		logger.info("play Harmonica");
	}
}

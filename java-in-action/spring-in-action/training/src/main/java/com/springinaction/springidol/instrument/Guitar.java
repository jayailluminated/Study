package com.springinaction.springidol.instrument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 3:13:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Guitar implements Instrument{
	Logger logger = LoggerFactory.getLogger(Guitar.class);

	public Guitar () {
	}

	@Override
	public void play () {
		logger.info("play Guitar ");
	}
}

package com.springinaction.springidol.instrument;

import com.springinaction.springidol.instrument.Instrument;
import com.springinaction.springidol.instrument.Saxophone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 19, 2010
 * Time: 12:47:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Piano implements Instrument {
	Logger logger = LoggerFactory.getLogger(Saxophone.class.getSimpleName());

	public Piano () {
	}


	@Override
	public void play () {
		logger.info("PIANO");
	}
}

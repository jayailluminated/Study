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

	public String getSong () {
		return song;
	}

	public void setSong (String song) {
		this.song = song;
	}

	private String song;

	public Piano () {
	}


	@Override
	public void play () {
		setSong("PIANO");
		logger.info("PIANO");
	}

	@Override
	public void tune () {
		logger.info("Piano tune");
	}

	@Override
	public void clean () {
		logger.info("Piano clean");
	}
}

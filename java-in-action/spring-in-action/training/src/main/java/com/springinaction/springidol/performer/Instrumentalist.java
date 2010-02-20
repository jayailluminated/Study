package com.springinaction.springidol.performer;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.instrument.Instrument;
import com.springinaction.springidol.performer.Performer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 18, 2010
 * Time: 11:51:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Instrumentalist implements Performer {
	Logger logger = LoggerFactory.getLogger(Instrumentalist.class.getSimpleName());

	private String age;
	private Instrument instrument;
	private String song;

	public Instrumentalist() {}

	@Override
	public void perform () throws PerformanceException {
		logger.info("Playing : {}", song);
		instrument.play();
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument (Instrument instrument) {
		this.instrument = instrument;
	}

	public void setAge (String age) {
		this.age = age;
	}
}

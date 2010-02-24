package com.springinaction.springidol.performer;

import com.springinaction.springidol.instrument.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import sun.audio.AudioDevice;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 18, 2010
 * Time: 11:51:35 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class InstrumentalistGetterInjection implements Performer {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private Instrument instrument;
	private String song;


	public InstrumentalistGetterInjection () {
	}

	@Override
	public void perform () throws PerformanceException {
		logger.info("Playing : {}", song);
		getInstrument().play();
	}

	public void setSong (String song) {
		this.song = song;
	}

	public abstract Instrument getInstrument ();
}
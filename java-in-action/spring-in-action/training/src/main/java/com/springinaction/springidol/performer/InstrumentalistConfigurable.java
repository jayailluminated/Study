package com.springinaction.springidol.performer;

import com.springinaction.springidol.instrument.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 26, 2010
 * Time: 1:13:20 AM
 * To change this template use File | Settings | File Templates.
 */

@Configurable("pianist")
public class InstrumentalistConfigurable implements Performer{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private Instrument instrument;
	private String song;


	@Override
	public void perform () throws PerformanceException {
		logger.info("Playing : {}", song);
		instrument.play();		
	}

	public void setSong (String song) {
		this.song = song;
	}

	public void setInstrument (Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrument getInstrument () {
		return instrument;
	}
}

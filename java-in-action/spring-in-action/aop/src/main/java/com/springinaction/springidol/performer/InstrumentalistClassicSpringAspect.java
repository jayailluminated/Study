package com.springinaction.springidol.performer;

import com.springinaction.springidol.audience.Audience;
import com.springinaction.springidol.instrument.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 18, 2010
 * Time: 11:51:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class InstrumentalistClassicSpringAspect implements Performer {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private Instrument instrument;
	private String song;
	private Audience audience;

	public InstrumentalistClassicSpringAspect () {
	}

	@Override
	public void perform () throws PerformanceException {
		audience.takeSeats();
		audience.turnOffCellPhones();

		try {
			logger.info("Playing : {}", song);
			instrument.play();

			audience.applaud();
		} catch (Throwable e) {
			audience.demandRefund();
		}

	}

	public void setSong (String song) {
		this.song = song;
	}
	
	public void setInstrument (Instrument instrument) {
		this.instrument = instrument;
	}

	public void setAudience (Audience audience) {
		this.audience = audience;
	}
}
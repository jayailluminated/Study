package com.springinaction.springidol.performer;

import com.springinaction.springidol.instrument.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 2:58:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class OneManBandMap implements Performer {
	Logger logger = LoggerFactory.getLogger(OneManBand.class);
	public OneManBandMap () {
	}

	@Override
	public void perform () throws PerformanceException {
		for(String key : instruments.keySet()){
			logger.info("Key is {}", key);
			Instrument instrument = instruments.get(key);
			instrument.play();

		}
	}

	private Map<String, Instrument> instruments;

	public void setInstruments (Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}
}
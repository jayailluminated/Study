package com.springinaction.springidol.performer;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import com.springinaction.springidol.instrument.Instrument;

import java.util.Collection;


/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 2:58:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class OneManBand implements Performer {
	
	public OneManBand () {
	}

	@Override
	public void perform () throws PerformanceException {
		for(Instrument instrument : instruments)
			instrument.play();
	}

	private Collection<Instrument> instruments;

	public void setInstruments (Collection<Instrument> instruments) {
		this.instruments = instruments;
	}


}

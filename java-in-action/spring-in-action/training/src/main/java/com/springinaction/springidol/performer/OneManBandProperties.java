package com.springinaction.springidol.performer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 20, 2010
 * Time: 2:58:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class OneManBandProperties implements Performer {
	Logger logger = LoggerFactory.getLogger(OneManBandProperties.class);
	private Properties instruments;
	private Properties someNonNullProperty;

	                                        

	public OneManBandProperties () {
	}

	@Override
	public void perform () throws PerformanceException {
		for (Iterator iter = instruments.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			logger.debug("{} : {}", key, instruments.getProperty(key));
		}
	}


	public void setInstruments (Properties instruments) {
		this.instruments = instruments;
	}
	public void setSomeNonNullProperty (Properties someNonNullProperty) {
		this.someNonNullProperty = someNonNullProperty;
	}
}

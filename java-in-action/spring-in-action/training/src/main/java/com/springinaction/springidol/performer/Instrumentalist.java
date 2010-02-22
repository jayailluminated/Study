package com.springinaction.springidol.performer;

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
public class Instrumentalist implements Performer, InitializingBean, DisposableBean {
	Logger logger = LoggerFactory.getLogger(Instrumentalist.class.getSimpleName());

	private String age;
	private Instrument instrument;
	private String song;

	public Instrumentalist () {
	}

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

	public void setAge (String age) {
		this.age = age;
	}

	public void tuneInstrument () {
		instrument.tune();
	}

	public void cleanInstrument () {
		instrument.clean();
	}

	@Override
	public void afterPropertiesSet () throws Exception {
		instrument.tune();
	}

	@Override
	public void destroy () throws Exception {
		instrument.clean();
	}
}

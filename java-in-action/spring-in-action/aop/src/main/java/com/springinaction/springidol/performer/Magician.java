package com.springinaction.springidol.performer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 24, 2010
 * Time: 12:46:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Magician implements Performer {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void perform () throws PerformanceException {
		logger.info(magicWords);
		logger.info("The magic box contains..");
		logger.info(magicBox.getContents());
	}

	// injected
	private MagicBox magicBox;

	public void setMagicBox (MagicBox magicBox) {
		this.magicBox = magicBox;
	}

	private String magicWords;

	public void setMagicWords (String magicWords) {
		this.magicWords = magicWords;
	}
}
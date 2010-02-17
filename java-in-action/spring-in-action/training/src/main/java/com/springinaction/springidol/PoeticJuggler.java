package com.springinaction.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 18, 2010
 * Time: 12:34:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class PoeticJuggler extends Juggler {
	Logger logger = LoggerFactory.getLogger(PoeticJuggler.class);
	private Poem poem;

	public PoeticJuggler (Poem poem) {
		super();
		this.poem = poem;
	}

	public PoeticJuggler (int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	public void perform() throws PerformanceException {
		super.perform();
		logger.info("WHILE RECITING...");
		poem.recite();
	}

}

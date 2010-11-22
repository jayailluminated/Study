package com.springinaction.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 18, 2010
 * Time: 12:43:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sonnet29 implements Poem {
	Logger logger = LoggerFactory.getLogger(Sonnet29.class.getSimpleName());
	private static String[] LINES = {
			"When, in disgrace with fortune and men's eyes,",
			"I all alone beweep my outcast state",
			"And trouble deaf heaven with my bootless cries",
			"And look upon myself and curse my fate,",
			"Wishing me like to one more rich in hope,",
			"Featured like him, like him with friends possess'd,",
			"Desiring this man's art and that man's scope,",
			"With what I most enjoy contented least;",
			"Yet in these thoughts myself almost despising,",
			"Haply I think on thee, and then my state,",
			"Like to the lark at break of day arising",
			"From sullen earth, sings hymns at heaven's gate;",
			"For thy sweet love remember'd such wealth brings",
			"That then I scorn to change my state with kings."
	};

	public Sonnet29 () {}

	@Override
	public void recite () {
		for (int i = 0 ; i < LINES.length; i++) {
			logger.debug(LINES[i]);
		}
	}
}

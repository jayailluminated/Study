package com.springinaction.chapter01.knight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User: jungjooseo
 * Date: Jan 2, 2010
 * Time: 5:48:10 AM
 */
public class Minstrel {
	final Logger SONG = LoggerFactory.getLogger(Minstrel.class);

	public void singBefore(Knight knight) {
		SONG.info("Fa la la ; Sir "+ knight.getName() + "is so brave!");
	}

	public void singAfter(Knight knight) {
		SONG.info("Tee-heehee; Sir" + knight.getName() + " did embark on a quest");
	}
}

package com.springinaction.chapter01.knight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Feb 1, 2010
 * Time: 1:29:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunQuest {


	public static void main(String[] args) {
		final Logger log = LoggerFactory.getLogger(RunQuest.class);

		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// ?????????
		Knight knight = (Knight) context.getBean("knight");

		try {
			HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
			log.debug(String.valueOf(grail.isHoly()));
		} catch (QuestFailedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
}

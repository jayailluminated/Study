package com.springinaction.chapter01.knight;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 1:37:56 AM
 */
public class KnightOfTheRoundTableTest {

	private final Logger log = LoggerFactory.getLogger(KnightOfTheRoundTableTest.class);
	private BeanFactory factory;

	@Before
	public void setUp() {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

//	@Test
//	public void testEmbarkOnQuest() throws QuestFailedException {
//		KnightOfTheRoundTable knight = new KnightOfTheRoundTable("Bedivere");
//		knight.setQuest(new HolyGrailQuest());
//		HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
//		assertNotNull(grail);
//		assertTrue(grail.isHoly());
//
//	}

	@Test
	public void testAOPEmbarkOnQuest() throws QuestFailedException {
		Knight knight = (Knight) factory.getBean("knight");
		HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
		assertNotNull(grail);
		assertTrue(grail.isHoly());
	}
}

package com.springinaction.chapter01.knight;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Feb 1, 2010
 * Time: 12:08:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinstrelTest {

	private final Logger log = LoggerFactory.getLogger(MinstrelTest.class);
	private BeanFactory factory;

	@Before
	public void setUp() {
		System.setProperty("user.dir", System.getProperty("user.dir") + "/spring-in-action/intro/src/test/resource/");
		factory = new XmlBeanFactory(new FileSystemResource(System.getProperty("user.dir") + "applicationContext.xml"));
	}

	@Test
	public void testSingBefore() {
		log.debug("test sing before");
		Knight knight = (Knight) factory.getBean("knight");
		Minstrel minstrel = (Minstrel) factory.getBean("minstrel");

		log.debug(knight.getName());

		minstrel.singBefore(knight);
	}
}

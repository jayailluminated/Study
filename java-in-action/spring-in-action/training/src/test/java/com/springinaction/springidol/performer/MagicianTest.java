package com.springinaction.springidol.performer;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 24, 2010
 * Time: 12:57:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class MagicianTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ApplicationContext ctx;

	@BeforeClass
	public void setUpOnce() {
		ctx = new ClassPathXmlApplicationContext("spring-advancedwiring.xml");
	}

	@Test
	public void replaceMethodTest() throws PerformanceException {
		Performer magician = (Performer) ctx.getBean("harry");
		magician.perform();
	}

	@Test
	public void lookupMethodTest() throws PerformanceException {
		Performer instrumentalist = (Performer) ctx.getBean("stevieGetterInjection");
		instrumentalist.perform();
	}

}

package com.springinaction.springidol.performer;

import com.springinaction.springidol.instrument.Piano;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;

/**
 * User: moretajoo
 * Date: Feb 24, 2010
 * Time: 12:57:36 AM
 */
public class MagicianTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	static ApplicationContext ctx;

	@BeforeClass
	public static void setUpOnce() {
		ctx = new ClassPathXmlApplicationContext("spring-advancedwiring.xml");
	}

	@Test
	public void testReplaceMethod() throws PerformanceException {
		Performer magician = (Performer) ctx.getBean("harry");
		magician.perform();
	}

	@Test
	public void lookupMethodTest() throws PerformanceException {
		Performer instrumentalist = (Performer) ctx.getBean("stevieGetterInjection");
		instrumentalist.perform();
	}

	@Test
	public void testInjectionNonSpringBean() throws PerformanceException {
//		Performer instrumentalist = (Performer) ctx.getBean("pianist");
		InstrumentalistConfigurable instrument = new InstrumentalistConfigurable();
		instrument.perform();
		Piano piano = (Piano) instrument.getInstrument();
		assertEquals("PIANO", piano.getSong());
	}

}

package com.springinaction.springidol;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: moretajoo
 * Date: Mar 6, 2010
 * Time: 9:25:31 PM
 */
public class InstrumentalClassicSpringAspectTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before
	public void setUp () {
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testInstrumetalClassicSpringAspectTest () throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-aop.xml");
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();
	}
}
package com.springinaction.springidol;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: moretajoo
 * Date: Mar 8, 2010
 * Time: 12:42:28 AM
 */
public class AOPTest {

	@Before
	public void setUp () {
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testAOPBasicTest () throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-aop.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();
		Performer performer2 = (Performer) ctx.getBean("stevie");
		performer2.perform();

	}


	@Test
	public void testAOPAbtractProxyFactoryTest () throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-aop.xml");
		Performer performer = (Performer) ctx.getBean("duke2");
		performer.perform();
		Performer performer2 = (Performer) ctx.getBean("stevie2");
		performer2.perform();
	}


}
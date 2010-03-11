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
 * Date: Mar 9, 2010
 * Time: 10:39:54 PM
 */
public class DefaultAdvisorAutoProxyCreatorTest {

	@Before
	public void setUp () {
	}

	@After
	public void tearDown () {
	}

	@Test
	public void testDefaultAdvisorAutoProxyCreatorTest () throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-aop-auto-proxy.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();
	}
}
package com.springinaction.postprocessor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: moretajoo
 * Date: Feb 28, 2010
 * Time: 1:25:22 AM
 */
public class BeanCounterTest {
	@Test
	public void testBeanCounter() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-propeditor.xml");
		BeanCounter beanCounter = (BeanCounter) ctx.getBean("beanCounter");
	}
	
}

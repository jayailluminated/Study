package com.springinaction.postprocessor;

import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;

/**
 * User: moretajoo
 * Date: Feb 28, 2010
 * Time: 12:31:49 AM
 */
public class FuddifierTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testFuddifier() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-propeditor.xml");
		Rabbit rabbit = (Rabbit) ctx.getBean("bugs");
		assertEquals("That wascawwy wabbit!", rabbit.getDescription());
	}
}

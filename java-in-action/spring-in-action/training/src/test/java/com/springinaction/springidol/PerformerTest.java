package com.springinaction.springidol;


import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 1:03:55 AM
 */
public class PerformerTest {
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Test
	public void beanTest() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();
		String str = "JUGGLING 3 BEANBAGS";
		logger.debug("{} is name",str);
		
	}


}

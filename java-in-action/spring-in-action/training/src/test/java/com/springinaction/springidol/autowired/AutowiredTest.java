package com.springinaction.springidol.autowired;


import com.springinaction.springidol.performer.PerformanceException;
import com.springinaction.springidol.performer.Performer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 1:03:55 AM
 */
public class AutowiredTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void beanTest() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("kennyWiredByName");
		performer.perform();
	}


}
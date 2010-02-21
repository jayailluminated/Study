package com.springinaction.springidol;

import com.springinaction.springidol.performer.PerformanceException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 22, 2010
 * Time: 2:13:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class StageTest {
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Test
	public void beanTest() throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
		Stage stage = (Stage) ctx.getBean("theStage");

		assertNotNull(stage);

	}
}

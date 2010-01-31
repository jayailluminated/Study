package com.springinaction.chapter01.hello;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import static junit.framework.Assert.assertEquals;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 12:38:35 AM
 */
public class HelloAppTest {
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Test
	public void beanTest() {
		System.setProperty("user.dir", System.getProperty("user.dir") + "/spring-in-action/intro/src/test/resource/");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(System.getProperty("user.dir")+"applicationContext.xml"));
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		greetingService.sayGreeting();
		assertEquals("a", "a");

	}


}

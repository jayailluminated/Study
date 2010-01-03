package com.springinaction.chapter01.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 12:38:35 AM
 */
class HelloAppTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("/Users/jungjooseo/Workspaces/springstudy/src/main/resources/applicationContext.xml"));
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		greetingService.sayGreeting();
	}
}

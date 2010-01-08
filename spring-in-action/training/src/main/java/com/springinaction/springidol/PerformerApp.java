package com.springinaction.springidol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 1:03:55 AM
 */
public class PerformerApp {


	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/springidol/spring-idol.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		try {
			performer.perform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
		String str = "JUGGLING 3BEANBAGS";
//		System.out.println("test");
	}


}
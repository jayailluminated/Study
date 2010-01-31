package com.springinaction.chapter01.hello;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Dec 13, 2009
 * Time: 3:41:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class GreetingServiceImpl implements GreetingService {
	private String greeting;

	public GreetingServiceImpl() {
	}

	public GreetingServiceImpl(String greeting) {
		this.greeting = greeting;
	}

	public String sayGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}

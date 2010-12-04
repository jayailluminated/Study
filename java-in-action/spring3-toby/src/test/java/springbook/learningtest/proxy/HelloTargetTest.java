package springbook.learningtest.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class HelloTargetTest {

	@Test
	public void simpleProxy() {
		Hello hello = new HelloTarget();
		assertThat(hello.sayHello("jjseo"), is("Hello jjseo"));
		assertThat(hello.sayHi("jjseo"), is("Hi jjseo"));
		assertThat(hello.sayThankYou("jjseo"), is("Thank you jjseo"));
	}

	@Test
	public void testUppercase() {
		Hello hello = new HelloUppercase(new HelloTarget());
		assertThat(hello.sayHello("jjseo"), is("HELLO JJSEO"));
		assertThat(hello.sayHi("jjseo"), is("HI JJSEO"));
		assertThat(hello.sayThankYou("jjseo"), is("THANK YOU JJSEO"));
	}

	@Test
	public void testDynamicProxy() {
		Hello hello = (Hello) Proxy.newProxyInstance(
				getClass().getClassLoader(),
				new Class[] { Hello.class },
				new UppercaseHandler(new HelloTarget()));
		assertThat(hello.sayHello("jjseo"), is("HELLO JJSEO"));
		assertThat(hello.sayHi("jjseo"), is("HI JJSEO"));
		assertThat(hello.sayThankYou("jjseo"), is("THANK YOU JJSEO"));
	}
}

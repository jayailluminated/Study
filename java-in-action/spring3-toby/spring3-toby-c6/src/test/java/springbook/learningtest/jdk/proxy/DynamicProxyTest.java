package springbook.learningtest.jdk.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;

public class DynamicProxyTest {



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

	@Test
	public void testProxyFacotryBean() {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		pfBean.addAdvice(new UppercaseAdvice()); //

		Hello proxiedHello = (Hello) pfBean.getObject();
		assertThat(proxiedHello.sayHello("jjseo"), is("HELLO JJSEO"));
		assertThat(proxiedHello.sayHi("jjseo"), is("HI JJSEO"));
		assertThat(proxiedHello.sayThankYou("jjseo"), is("THANK YOU JJSEO"));
	}

	@Test
	public void classNamePointcutAdvisor() {
		// pointcut準備
		NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
			@Override
			public ClassFilter getClassFilter() {
				return new ClassFilter() {
					@Override
					public boolean matches(Class<?> clazz) {
						return clazz.getSimpleName().startsWith("HelloT");
					}
				};
			}
		};
		classMethodPointcut.setMappedName("sayH*");

		//テスト
		checkAdviced(new HelloTarget(), classMethodPointcut, true);
		class HelloWorld extends HelloTarget {
		}
		;

		checkAdviced(new HelloWorld(), classMethodPointcut, false);

		class HelloToby extends HelloTarget {
		}
		;

		checkAdviced(new HelloToby(), classMethodPointcut, true);

	}

	private void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(target);
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		Hello proxiedHello = (Hello) pfBean.getObject();

		if (adviced) {
			assertThat(proxiedHello.sayHello("jjseo"), is("HELLO JJSEO"));
			assertThat(proxiedHello.sayHi("jjseo"), is("HI JJSEO"));
			assertThat(proxiedHello.sayThankYou("jjseo"), is("Thank you jjseo"));
		} else {
			assertThat(proxiedHello.sayHello("jjseo"), is("Hello jjseo"));
			assertThat(proxiedHello.sayHi("jjseo"), is("Hi jjseo"));
			assertThat(proxiedHello.sayThankYou("jjseo"), is("Thank you jjseo"));
		}

	}
}

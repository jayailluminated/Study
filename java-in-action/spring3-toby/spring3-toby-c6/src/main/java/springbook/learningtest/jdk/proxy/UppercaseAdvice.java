package springbook.learningtest.jdk.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author moretajoo
 * 일종의 공유 가능한 템플릿처럼 동작한다.
 *
 * 이점이 JDK의 다이내믹 프록시를 집접 사용하는 코드와 스프링이 제공하는 플록시 추사오하 기능인
 * ProxyFactoryBean을 사용하는 코드의 가장 큰 차이점
 * ProxyFactoryBean은 작은 단위의 템플릿/콜백 구조를 응용해서 적용했기 때문에
 * 템플릿 역할을 하는 MethodInvocation을 싱글톤으로 두고 공유할 수 있다.
 */
public class UppercaseAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String ret = (String) invocation.proceed();
		return ret.toUpperCase();
	}
}


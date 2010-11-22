package com.springinaction.springidol.audience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * User: moretajoo
 * Date: Mar 6, 2010
 * Time: 10:34:27 PM
 */
public class AudienceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private Audience audience;

	public void setAudience (Audience audience) {
		this.audience = audience;
	}

	public AudienceAdvice () {
	}

	@Override
	public void before (Method method, Object[] args, Object target) throws Throwable {
		audience.takeSeats();
		audience.turnOffCellPhones();
	}

	@Override
	public void afterReturning (Object o, Method method, Object[] args, Object target) throws Throwable {
		audience.applaud();
	}

	public void afterThrowing (Throwable throwable) {
		audience.demandRefund();
	}


}

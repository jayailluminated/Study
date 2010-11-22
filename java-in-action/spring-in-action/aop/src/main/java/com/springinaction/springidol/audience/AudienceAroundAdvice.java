package com.springinaction.springidol.audience;

import com.springinaction.springidol.performer.PerformanceException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
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
public class AudienceAroundAdvice implements MethodInterceptor {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private Audience audience;

	public void setAudience (Audience audience) {
		this.audience = audience;
	}

	public AudienceAroundAdvice () {
	}

	@Override
	public Object invoke (MethodInvocation methodInvocation) throws Throwable {
		try {
			audience.takeSeats();
			audience.turnOffCellPhones();

			Object returnValue = methodInvocation.proceed();

			audience.applaud();
			return returnValue;
		} catch (PerformanceException throwable) {
			audience.demandRefund();
			throw throwable;
		}


	}
}
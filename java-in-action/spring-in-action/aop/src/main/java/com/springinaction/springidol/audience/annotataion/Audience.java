package com.springinaction.springidol.audience.annotataion;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: moretajoo
 * Date: Mar 4, 2010
 * Time: 11:41:12 PM
 */
@Aspect
public class Audience {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Audience () {
	}

	//Defines performance pointcut

	@Pointcut("execution(* *.perform(..))")
	public void performance () {
	}

	@Before("performance()")
	public void takeSeats () {
		logger.info("The audience is taking their seats.");
	}

	@Before("performance()")
	public void turnOffCellPhones () {
		logger.info("The adience is turning off " + "their cellphones");
	}

	@AfterReturning("performance()")
	public void applaud () {
		logger.info("CLAP CLAP CLAP CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance()")
	public void demandRefund () {
		logger.info("Boo ! We want our money back!!");
	}
}
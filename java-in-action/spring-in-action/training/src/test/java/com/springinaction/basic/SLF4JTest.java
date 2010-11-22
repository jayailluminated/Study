package com.springinaction.basic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class SLF4JTest {
	@Test
	public void logginTest() {
		Logger logger = LoggerFactory.getLogger(SLF4JTest.class);
		logger.info("Hello World");
		assertTrue(true);
	}
}
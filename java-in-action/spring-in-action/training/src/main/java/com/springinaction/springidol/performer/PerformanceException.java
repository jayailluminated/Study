package com.springinaction.springidol.performer;

/**
 * User: jungjooseo
 * Date: Jan 6, 2010
 * Time: 12:22:03 AM
 */
public class PerformanceException extends Exception {
	public PerformanceException() {
	}

	public PerformanceException(String message) {
		super(message);
	}

	public PerformanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PerformanceException(Throwable cause) {
		super(cause);
	}
}

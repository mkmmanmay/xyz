package com.guru.framework.testing.objects.exceptions;

public class TimeoutException extends FrameworkException {

	private static final long serialVersionUID = 3587539802896623789L;

	public TimeoutException(String message) {
		super(message);
	}

	public TimeoutException(String message, Throwable cause) {
		super(message, cause);
	}
}
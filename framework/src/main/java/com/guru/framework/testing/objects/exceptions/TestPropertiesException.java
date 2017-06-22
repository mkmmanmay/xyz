package com.guru.framework.testing.objects.exceptions;

public class TestPropertiesException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public TestPropertiesException() {
		super();		
	}
	
	public TestPropertiesException(final String message) {
		super(message);
	}
	
	public TestPropertiesException(final String message, final Throwable t) {
		super(message, t);
	}
	
	public TestPropertiesException(final Throwable t) {
		super(t);
	}
	
}

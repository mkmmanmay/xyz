package com.guru.framework.testing.objects.exceptions;

public class SkipAllException extends Exception {

	private static final long serialVersionUID = -7007696309771573902L;

	public SkipAllException(final String message) { super(message); }
	
	public SkipAllException(final Throwable t) { super(t); }
	
	public SkipAllException(final String message, final Throwable t) { super(message, t); }
	
}

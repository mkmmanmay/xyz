package com.guru.framework.testing.objects.exceptions;

public class DataTableException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public DataTableException() {
		super();		
	}
	
	public DataTableException(final String message) {
		super(message);
	}
	
	public DataTableException(final String message, final Throwable t) {
		super(message, t);
	}
	
	public DataTableException(final Throwable t) {
		super(t);
	}
	
}

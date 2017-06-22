package com.guru.framework.testing.objects.exceptions;

public class CollectionAssertionException extends Exception {
	 
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7903074487095541616L;

	public CollectionAssertionException(final Throwable t) {
	    super(t);
	  }


	  public CollectionAssertionException(final String message) {
	    super("\n" + message);
	  }

	  public CollectionAssertionException(final String message, final Throwable t) {
	    super(message, t);
	    
	  }

}

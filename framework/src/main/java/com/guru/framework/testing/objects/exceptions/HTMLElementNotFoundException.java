package com.guru.framework.testing.objects.exceptions;

import com.guru.framework.testing.logger.ScriptLogger;

public class HTMLElementNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HTMLElementNotFoundException(Exception e, String message){
		super(message);
		ScriptLogger.error(e);
	}
}

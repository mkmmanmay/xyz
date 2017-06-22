package com.guru.framework.testing.objects.exceptions;

import com.guru.framework.testing.logger.ScriptLogger;

public class ScriptException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScriptException(Exception e) {
	  super("Automated Script Exception-Please check error log");
	  ScriptLogger.error(e);
	}
	
	public ScriptException(String message){
		super("Automated Script Exception-Please check error log");
		ScriptLogger.error(new Exception(message));
	}
}

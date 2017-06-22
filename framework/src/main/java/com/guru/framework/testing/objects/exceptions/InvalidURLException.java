package com.guru.framework.testing.objects.exceptions;

public class InvalidURLException extends FrameworkException {

	private static final long serialVersionUID = -8593204700529133170L;
	private static String exMessage = "exception for invalid url:";

	public InvalidURLException(String url) {
		super(exMessage + url);
	}

	public InvalidURLException(String url, Throwable cause) {
		super(exMessage + url, cause);
	}
}
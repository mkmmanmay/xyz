package com.guru.framework.testing.objects.exceptions;

public class ConfigFileException extends FrameworkException {
	
	private static final long serialVersionUID = -796054518491967432L;
	private static String exMessage = "exception for config: ";

	public ConfigFileException(String path) {
		super(exMessage + path);
	}

	public ConfigFileException(String path, Throwable cause) {
		super(exMessage + path, cause);
	}
}
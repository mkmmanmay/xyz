package com.guru.framework.testing.utils;


import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class PathHelper {
	
	
	/**
	 * Uses a stack trace of the current thread to return a path to the root
	 * folder of the running class
	 * 
	 * @return A path to the root of the caller class
	 * @throws ClassNotFoundException
	 * @throws URISyntaxException
	 */
	public static String getRootPath() throws ClassNotFoundException, URISyntaxException {
		final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(int i = 0; i < stackTraceElements.length-1; i++) {
			if(stackTraceElements[i].getClassName().equals("com.guru.framework.testing.utils.PathHelper")) {
				System.out.println("Path is "+Class.forName(stackTraceElements[i+1].getClassName()));
				return getRootPath(Class.forName(stackTraceElements[i+1].getClassName()));
			}
		}
		throw new ClassNotFoundException("Could not find a caller class");
	}

	/**
	 * Returns a path to a root folder of the specified class
	 * 
	 * @param clazz
	 *            A Class object
	 * @return A string representing a path to a root folder of the clazz
	 * @throws URISyntaxException
	 */
	public static String getRootPath(final Class<?> clazz) throws URISyntaxException {
		final CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
		final File jarFile = new File(codeSource.getLocation().toURI().getPath());
		final File jarDir = jarFile.getParentFile();
		return jarDir.getPath();
	}
	
	/**
	 * Returns a path to Working Project wherever this is called
	 * 
	 * @return String
	 * 
	 */

	public static String getWorkingDirectoryPath()  {
		
		return System.getProperty("user.dir");

	}

}

package com.guru.framework.testing.helpers;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ScriptException;

public class FileHandler {
	
	 public static Enumeration readProperties(String filename) throws IOException {
		 Properties prop = new Properties();
	    	InputStream input = null;
	    	//String filename = "DBProperties.properties";
	    	input = FileHandler.class.getClassLoader().getResourceAsStream(filename);
	    	if(input==null){
	    		System.out.println("Sorry, unable to find " + filename);
	   
	    		}

	    	//load a properties file from class path, inside static method
	    	prop.load(input);
	
	    	Enumeration em = prop.keys();
	    	return em;
	    	
	 }
	

	public static void uploadFilesFromPath(String filePath,String symbol) throws Exception {
		String multipleFiles = null;
		StringSelection s;
		if(filePath.contains(symbol)){
			String string=filePath.replace(symbol, "\" \"");
			multipleFiles="\""+string+"\"";
			s = new StringSelection(multipleFiles);
		}
		
		else{
			s = new StringSelection(filePath);
		}
		ScriptLogger.info();	
		try {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
			throw new ScriptException(  e);
		}
	}
   
}

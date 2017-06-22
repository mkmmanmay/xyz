package com.guru.framework.testing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lightweighted reader that reads from InputStream into a String.
 * Typical usage:
 * BufferedInputStreamReader bis = new BufferedInputStreamReader(is);
 * bis.start();
 * while(isReading()) { wait somehow }
 * String result = bis.getOutput();
 * @author 
 *
 */
public class BufferedInputStreamReader extends Thread {
	private static final Logger logger = Logger.getLogger(BufferedInputStreamReader.class.getName());
	
	InputStream is;
	String message;
	String output;
	boolean reading = false;
	
	public BufferedInputStreamReader(final InputStream is) {
		this(is, null);
	}
	
	public BufferedInputStreamReader(final InputStream is, final String message) {
		this.is = is;
		this.message = message;
	}
	
	 public void run()  {
		 reading = true;
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		 try  {
			 isr = new InputStreamReader(is);
	         br = new BufferedReader(isr);	         
	         final StringBuilder sb = new StringBuilder();
	         String line=null;
	         while ( (line = br.readLine()) != null) {	        	 
	        	 if(message != null) {sb.append(message).append(">");}
	             sb.append(line).append("\n");  
	         } 
	         if(sb.length() > 0) {this.output = sb.toString().substring(0, sb.length()-1);}
		 }
	     catch (IOException ioe) { logger.log(Level.SEVERE, ioe.getMessage());  }
		 finally {
			 if(br != null)  {try {br.close();}catch(Exception e1){logger.log(Level.SEVERE, e1.getMessage()); }}
			 if(isr != null) {try {isr.close();}catch(Exception e2){logger.log(Level.SEVERE, e2.getMessage()); }}
			 reading  = false;
		 }
	 }

	 public boolean isReading() { return this.reading; }
	 
	 public String getOutput() {
		 return this.output;
	 }
}

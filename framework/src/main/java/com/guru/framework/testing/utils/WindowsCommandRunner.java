package com.guru.framework.testing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Executes windows commands and returns a String 
 * that contains either normal command output or an 
 * exit code if there is no output 
 *
 * @author Isha Sharma
 * @since Nov 23,2016
 *
 */
public class WindowsCommandRunner {
	
	private List<String> arguments;
	private boolean throwExceptionOnStdErr;
	private String STDERRVal;
	
	public WindowsCommandRunner()
	{
		throwExceptionOnStdErr = true;
		STDERRVal = "";
	}
	
	public void setSTDERRException(Boolean input)
	{
		throwExceptionOnStdErr = input;
	}
	
	public String getSTDErr()
	{
		return STDERRVal; 
	}
	public WindowsCommandRunner(final String... args) {
		if(args.length < 1) 
			{throw new IllegalArgumentException("Need at least one argument");}
		this.arguments = new ArrayList<String>(args.length + 2);
		this.arguments.add("cmd.exe");
		this.arguments.add("/C");
		for(String each : args)
			{this.arguments.add(each);}
	}
	
	/**
	 * This method executes a windows command
	 * @return A String that contains either normal command output or an exit code if there is no output
	 * @throws Exception If any IO error or error output is produced
	 */
			
	public String execute() throws Exception {
		int exitCode;
		try {
			final ProcessBuilder builder = new ProcessBuilder(this.arguments);
			final Process proc = builder.start();
			final BufferedInputStreamReader errorReader = new BufferedInputStreamReader(proc.getErrorStream());
			final BufferedInputStreamReader outputReader = new BufferedInputStreamReader(proc.getInputStream());
			errorReader.start();
			outputReader.start();
			exitCode = proc.waitFor();
			
			while(errorReader.isReading()) { Thread.sleep(10);}
			if(errorReader.getOutput() != null) 
			{
				STDERRVal = errorReader.getOutput();
				if (throwExceptionOnStdErr)
				{
					throw new Exception(STDERRVal);
				}
			}
			
			while(outputReader.isReading()) { Thread.sleep(10);}
			
			if(outputReader.getOutput() != null) {return outputReader.getOutput();}
		}
		catch(Exception e) { throw new Exception(e); }
		
		return exitCode + "";
	}
	
	private Process proc;
	private listener lErr;
	private listener lOut;
	private String STDOut = "";
	
	public boolean checkRunStatus(String inp)
	{
		if (STDOut.contains(inp))
		{
			return true;
		}
		return false;
	}
	public void stopNonBlocking() 
	{
		proc.destroy();
		lErr.stopThread();
		lOut.stopThread();
	}
	
	public void executeNonBlocking() throws Exception
	{
		try {
			final ProcessBuilder builder = new ProcessBuilder(this.arguments);
			
			//inheritIO can be used to redirect stdout and stderr to this thread.
			//final Process proc = builder.inheritIO().start();
			proc = builder.start();
			
			lErr = new listener(proc.getErrorStream());
			Thread tErr = new Thread(lErr);
			tErr.start();
			lOut = new listener(proc.getInputStream());
			Thread tOut = new Thread(lOut);
			tOut.start();
		}
		catch(Exception e) { throw new Exception(e); }
	}
	
	private class listener extends Thread
	{
		private boolean toStop;
		public void stopThread()
		{
			toStop = true;
		}
		private InputStream reader;
		public listener(InputStream reader_inp)
		{
			reader = reader_inp;
			toStop = false;
		}
		
		@Override
		public void run()
		{
			InputStreamReader isr = new InputStreamReader(reader);
	        BufferedReader br = new BufferedReader(isr);
			String line = null;
			try {
				while((line =  br.readLine())!= null && !toStop) 
				{
					System.out.println("STDOUT----------------------------->" + line);
					STDOut += line;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public static void main(String[] args) throws Exception {
	//	System.out.println(new WindowsCommandRunner("ipconfig", "/flushdns").execute());
	//	System.out.println(new WindowsCommandRunner("certutil.exe", "-urlcache", "*", "delete").execute());
	//	System.out.println(new WindowsCommandRunner("certutil.exe", "-setreg", "chain\\ChainCacheResyncFiletime", "@now").execute());
	//	System.out.println(new WindowsCommandRunner("RunDll32.exe", "InetCpl.cpl,ClearMyTracksByProcess", "4351").execute());	
	}*/
	
}

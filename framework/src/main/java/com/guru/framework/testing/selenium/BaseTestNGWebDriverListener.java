package com.guru.framework.testing.selenium;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.guru.framework.testing.utils.PathHelper;

/**
 * TestNG listener adapter that enables 
 *  1. Screenshots on failure (both test methods and configurations)
 *  2. Killing all browser processes after all tests are completed regardless of test outcome
 * @author Isha Sharma
 * @version 1.0
 */
public class BaseTestNGWebDriverListener extends TestListenerAdapter implements ISuiteListener {
	
	private String path;	
	
	public BaseTestNGWebDriverListener(String path) throws Throwable{
		this.path = path;
	}
	
	
	public BaseTestNGWebDriverListener() throws Throwable{
		this(PathHelper.getRootPath());
	}
	public void onConfigurationFailure(ITestResult tr) { printScreenshot(tr);	}
	
	public void onTestFailure(ITestResult tr) { printScreenshot(tr);	}
	
	
	public void onFinish(ITestContext context) {
		
		
		/*
		try {
			if(getProcessInstanceCount("ie") > 0)
				killProcess("ie");
			if(getProcessInstanceCount("firefox") > 0)
				killProcess("firefox");
			if(getProcessInstanceCount("chrome") > 0)
				killProcess("chrome");
			Thread.sleep(5000);
		}
		catch(Exception e) {
			System.out.println("Exception while closing the browser: " + e.getMessage());
		}
		*/
	}

	/**
	 * Helper method that makes screenshots on failure
	 * @param tr TestNG test result object
	 */
	private void printScreenshot(ITestResult tr) {
		try {
			  Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
			  Rectangle screenBounds = new Rectangle(0, 0, screenDim.width, screenDim.height);
			  Robot robot = new Robot();
			  BufferedImage image =  robot.createScreenCapture(screenBounds);

			  	File screenshotFile = new File(path + File.separator
			                                   + "error_" + tr.getMethod().getXmlTest().getName() 
			                                   + "_" + tr.getMethod().getMethodName()
			                                   + "_" + new SimpleDateFormat("yyyy_MM_dd_HH_mmZ").format(new Date()) + ".png");
			    ImageIO.write(image, "png", screenshotFile);
			}
			catch(Throwable t) {
				System.err.println(t.getStackTrace());		
			}
	}
	
	private static final String TASKLIST = "tasklist";
	private static final String TASKKILL = "taskkill";
	
		
	public static int getProcessInstanceCount(String name ) throws Exception {
		Process p = Runtime.getRuntime().exec(TASKLIST + " /fi \"imagename eq " + name + "*\"");
		BufferedReader reader  = new BufferedReader(new InputStreamReader(p.getInputStream()));
		int result = 0;
		String line;
		while((line =  reader.readLine()) != null) {
			if(line.toLowerCase().contains(name.toLowerCase()))
				result++;
		}
		return result;
	}
	
	public static void killProcess(String name) throws Exception {
		Runtime.getRuntime().exec(TASKKILL + " /f /im  " + name.toLowerCase() + "* /t");
	}


		
	
	public void onStart(ISuite suite) {
	
	}
	
	public void onFinish(ISuite suite) {
		try {
		 	FileWriter dummy = new FileWriter(path + File.separator  + suite.getName() + "_completed_" + new SimpleDateFormat("yyyy_MM_dd_HH_mmZ").format(new Date()) + ".png");
		 	 BufferedWriter out = new BufferedWriter (dummy);
                String text = "Suite completed";
                out.write(text);
                out.close();
		}
		catch(Throwable t) {
			System.err.println(t.getStackTrace());		
		}
	
	}


	
}

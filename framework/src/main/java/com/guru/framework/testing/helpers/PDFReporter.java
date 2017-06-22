package com.guru.framework.testing.helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.guru.framework.testing.database.statustracker.StatusTrackerInterface;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.selenium.WebDriverAccess;
import com.guru.framework.testing.selenium.WebDriverPerformance;
import com.guru.framework.testing.testng.FailureMessage;
import com.guru.framework.testing.utils.PathHelper;
import com.guru.framework.testing.utils.UnzipJar;
import com.guru.framework.testing.utils.objects.StringUtils;

/**
 * PDF Report implementation with screenshot making capabilities
 * @author Isha Sharma
 * @since Dec 6,2016
 */
public class PDFReporter implements ITestListener, IReporter {
	private static final Logger logger = Logger.getLogger(PDFReporter.class.getName());
	
	private String screenshotPath;	
	private String reportPath;
	private String suiteName="";
	private String useApplicationPDF=null;	
	private String triggerEmail=null;
	private String browser = null;
	private List<Integer> verbosity = null; 
	
	protected static List<BufferedImage> extraScreenshotImage = new ArrayList<BufferedImage>();
	
	protected static DateFormat dfTime = new SimpleDateFormat("hh:mm:ss a");
	protected static DateFormat dfDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
	protected static Calendar calendar = Calendar.getInstance();
	private static String suitHeader;
	private static HashMap<String, String> extraParameters;

	private static String testDescription;
	
	public PDFReporter(final String screenshotPath, final String reportPath) throws Throwable {
		setScreenshotPath(screenshotPath);
		setReportPath(reportPath);
		extraParameters = new HashMap<String, String>();
	}
	
	
	public PDFReporter() throws Throwable{
		this(null, null);
	}
	
	
	public String getScreenshotPath() {
		return this.screenshotPath;
	}
	
	public void setScreenshotPath(final String path) throws Throwable {
		if(path == null)	{this.screenshotPath = System.getProperty("user.dir").toString() + "\\target";}
		else				{this.screenshotPath = path;}
	}
	
	public static void takeExtraScreenshot() throws Throwable {
		try {
			final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
			final Rectangle screenBounds = new Rectangle(0, 0, screenDim.width, screenDim.height);
			final Robot robot = new Robot();
			extraScreenshotImage.add(robot.createScreenCapture(screenBounds));
		} catch (Throwable t) {
			System.err.println(t.getStackTrace());
		}
	}
	
	
	public static void addParameter(String input)
	{
		String methodName =Thread.currentThread().getStackTrace()[2].getMethodName();
		extraParameters.put(methodName,input);
		
	}
	
	public String getReportPath() {
		return this.reportPath;
	}
	
	public void setReportPath(final String path) throws Throwable {
		if(path == null){this.reportPath = System.getProperty("user.dir").toString() + "\\target";} // + File.separator + "test-output";}
		else				{this.reportPath = path;}
		
		/*System.out.println(">>>PDF REPORT PATH>>>"+this.reportPath);*/
	}
	
	// This method is used to log the output within methods
	@SuppressWarnings("unchecked")
	protected static void logOutput(final ITestResult result, final String line) {
		final Object log = result.getAttribute("log");
		final List<String> logList = (null == log) ? new ArrayList<String>() : (List<String>)log;
		logList.add(line);
		result.setAttribute("log", logList);			
	}
	
	// Store the verbosity as powers of 2
	public void onStart(final ITestContext context) {
		final String verbosityValue = context.getSuite().getParameter(ReportVerbosity.PARAMETER);	
	    suitHeader=context.getSuite().getParameter("reportName");
	    testDescription=context.getSuite().getParameter("testDescription");
	    useApplicationPDF=context.getSuite().getParameter("useApplicationPDF");
	    triggerEmail=context.getSuite().getParameter("triggerEmail");
	    browser=context.getSuite().getParameter("browser");
	    final String reportPath = context.getSuite().getParameter("reportPath");
	    if(reportPath==null||reportPath.length()==0 || "".equalsIgnoreCase(reportPath))
	    {suiteName="target/"+context.getSuite().getParameter("reportName")+".pdf";}
	    else
	    	{suiteName = reportPath +context.getSuite().getParameter("reportName")+".pdf";}
	    if(verbosityValue == null)
	    	{this.verbosity = Arrays.asList(new Integer(0));}
	    else
	    	{this.verbosity =  ReportVerbosity.computePowersOfTwoPartition(ReportVerbosity.validateVerbosity(verbosityValue));}		
	}

	// Makes a screenshot if verbosity is set to make screenshots
	public void onTestFailure(final ITestResult result) {
		if (ReportVerbosity.contains(this.verbosity, ReportVerbosity.SCREENSHOTS_ON_FAILURE.value()) ) {
			final String filePath = printScreenshot(result);
			if (null != filePath)
				{result.setAttribute("screenshot", filePath);}
		}
		setDocumentationValues(result);
		setFailureMessage(result);
		setPerformance(result);
	}
	
	
	// Makes a screenshot if verbosity is set to make screenshots always
	public void onTestSuccess(final ITestResult result) {
		if (ReportVerbosity.contains(this.verbosity, ReportVerbosity.SCREENSHOTS_ON_SUCCESS.value()) ) {
			final String filePath = printScreenshot(result);
			if (null != filePath)
				{result.setAttribute("screenshot", filePath);}
		}
		setDocumentationValues(result);
		setPerformance(result);
	}
	private void setPerformance(final ITestResult result)
	{
		WebDriverPerformance.PerfData data = WebDriverPerformance.getResults();
		if (data != null)
		{
			result.setAttribute("docLoadTime", data.docCompleteTime);
			result.setAttribute("docRequests", data.docCompleteRequests);
			result.setAttribute("docBytesIn", data.docCompleteBytesIn);
			result.setAttribute("fullLoadTime", data.fullyLoadedTime);
			result.setAttribute("fullRequests", data.fullyLoadedRequests);
			result.setAttribute("fullBytesIn", data.fullyLoadedBytesIn);
			result.setAttribute("PerformanceVisuallyComplete", data.visuallycomplete);
			result.setAttribute("PerformanceScore", data.speedIndex);
			result.setAttribute("Performancedetails", data.url);
			result.setAttribute("TransactionName", data.transactionName);
		}
		
	}
	
	protected void setFailureMessage(final ITestResult result){
		Annotation[] annotations;
		final String methodName=result.getMethod().getMethodName();
		for(Method method:result.getTestClass().getRealClass().getDeclaredMethods()){
			if(method.getName().equals(methodName)){
					//System.out.println(method.getName());
					annotations=method.getAnnotations();
					for(Annotation annotation:annotations){
						//System.out.println(annotation.annotationType());
						if(annotation instanceof FailureMessage){
							final FailureMessage myAnnotation = (FailureMessage) annotation;
							result.setAttribute("failureMessage", myAnnotation.value());
							System.out.println("<Failure-Message>" + myAnnotation.value() + "</Failure-Message>");
						}
					}
			}
		}
	}
	protected void setDocumentationValues(final ITestResult result){
		Annotation[] annotations;
		final String methodName=result.getMethod().getMethodName();
		for(Method method:result.getTestClass().getRealClass().getDeclaredMethods()){
			if(method.getName().equals(methodName)){
					//System.out.println(method.getName());
					annotations=method.getAnnotations();
					for(Annotation annotation:annotations){
						//System.out.println(annotation.annotationType());
						if(annotation instanceof Documentation){
							final Documentation myAnnotation = (Documentation) annotation;
							result.setAttribute("expected", myAnnotation.expected());
							result.setAttribute("step", myAnnotation.step());
						}
					}
			}
		}
	}
	
	protected String printScreenshot(final ITestResult tr) {
		try {
			final String filePath = screenshotPath + File.separator + tr.getMethod().getXmlTest().getName().replace(' ', '_') + "_" + tr.getMethod().getMethodName() + "_"
					+ System.currentTimeMillis() + ".gif";
			if (browser == null || !browser.equals("sauce"))
			{
				final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
				final Rectangle screenBounds = new Rectangle(0, 0, screenDim.width, screenDim.height);
				final Robot robot = new Robot();
				BufferedImage image = robot.createScreenCapture(screenBounds);
				final File screenshotFile = new File(filePath);
				
	 			for(BufferedImage imageLoop : extraScreenshotImage) {
					image = combineImages(image, imageLoop);
				}	
				
				ImageIO.write(image, "gif", screenshotFile);
			}
			else
			{
				File scrFile = ((TakesScreenshot)(WebDriverAccess.getDriver())).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(filePath));
			}			
			return filePath;
		} catch (Throwable t) {
			System.err.println(t.getStackTrace());
			return null;
		}
	} 
	
	private static String translateTestStatus(final int status) {
		switch(status) {
			case ITestResult.SUCCESS: return "PASS"; 
			case ITestResult.FAILURE: return "FAIL"; 
			case ITestResult.SKIP: return "SKIP"; 
		}
		return "FAIL";
	}		
	
	
	private static void writeXMLFile(final DOMSource source, final String path) throws Exception {
		final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		final Transformer transformer = transformerFactory.newTransformer();
	
		/*final StreamResult res=new StreamResult(new File(path).getAbsolutePath());*/
		final StreamResult res=new StreamResult(transformFileAbsolutePath(path));
		
		transformer.transform(source, res);
	}
	
	private static File transformFileAbsolutePath(String path) {
		File fp= new File(path);
		
		String finalPath=fp.getAbsolutePath();
		finalPath=finalPath.replace("\\", "/");
		File newFile= new File(finalPath);
		return newFile;
		
	}
	
	private static File transformFilePath(String path) {
		String finalPath=path.replace("\\", "/");
		File newFile= new File(finalPath);
		return newFile;
		
		
		
	}
	
	


	private static BufferedImage combineImages(BufferedImage img1, BufferedImage img2) {
		int offset = 5;
		int wid = Math.max(img1.getWidth(), img2.getWidth()) + offset;
		int height = img1.getHeight() + img2.getHeight() + offset;
		
		BufferedImage newImage = new BufferedImage(wid, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = newImage.createGraphics();
		Color oldColor = g2.getColor();
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, wid, height);
		g2.setColor(oldColor);
		g2.drawImage(img1, null, 0, 0);
		
		g2.drawImage(img2, null, 0, img1.getHeight() + offset);
		g2.dispose();
		return newImage;
	}
	
	public void generateReport(final List<XmlSuite> xmlSuites, final List<ISuite> suites, final String outputDirectory) {		
	
		try {		
			// process the root element
			final Document doc = DOMBuilder.createEmptyDocument();
			final Element rootElement = doc.createElement("test-run-result");		
			doc.appendChild(rootElement);	
			
			/*List<String> reporterOutput = Reporter.getOutput();
			if(reporterOutput != null && !reporterOutput.isEmpty()) {
				Element outputElement = addElement(doc, rootElement, "reporter-output");
				for(String line : reporterOutput) {
					Element lineElement = addElement(doc, outputElement, "line");
					addCDATA(doc, lineElement, line);
				}
			}*/
			
			// overall counts
			int passedRunCount = 0;
			int failedRunCount = 0;
			int skippedRunCount = 0;
			
			// overall durations
			long passedRunDuration = 0l;
			long failedRunDuration  = 0l;
			long skippedRunDuration = 0l;		
			long totalRunDuration = 0l;
			// overall dates
			Date runStartDate = null;
			Date runEndDate = null;		
			
			String runStatus = "PASS";
			
			// process all suites	
			for(ISuite suite : suites) {
				final Element suiteElement  = DOMBuilder.buildSuite(doc, rootElement, suite);	
				/*if(issuiteName){
				suiteName="target/"+suiteElement.getAttribute("name")+".pdf";
				issuiteName=false;
				}*/
				passedRunCount += Integer.parseInt(suiteElement.getAttribute("passed"));
				skippedRunCount += Integer.parseInt(suiteElement.getAttribute("skipped"));
				failedRunCount += Integer.parseInt(suiteElement.getAttribute("failed"));
				passedRunDuration += Long.parseLong(suiteElement.getAttribute("passed-duration-ms"));
				skippedRunDuration += Long.parseLong(suiteElement.getAttribute("skipped-duration-ms"));
				failedRunDuration += Long.parseLong(suiteElement.getAttribute("failed-duration-ms"));
				totalRunDuration += Long.parseLong(suiteElement.getAttribute("duration-ms"));
				
				final long startTime  = dfDateTime.parse(suiteElement.getAttribute("started-at")).getTime();
				final long endTime =  dfDateTime.parse(suiteElement.getAttribute("finished-at")).getTime();
				
				if(runStartDate == null || runStartDate.getTime() > startTime) {
					calendar.setTimeInMillis(startTime); 
					runStartDate = calendar.getTime();
				}
				if(runEndDate == null || runEndDate.getTime() < endTime) {
					calendar.setTimeInMillis(endTime); 
					runEndDate = calendar.getTime();
				}
				
				final String suiteStatus = suiteElement.getAttribute("status");
				if("PASS".equals(runStatus))	{runStatus = suiteStatus;}
				else if("SKIP".equals(runStatus) && "FAIL".equals(suiteStatus)){ runStatus = "FAIL";}
			}
			
			DOMBuilder.addAttribute(doc, rootElement, "passed",  String.valueOf(passedRunCount));
			DOMBuilder.addAttribute(doc, rootElement, "skipped",  String.valueOf(skippedRunCount));
			DOMBuilder.addAttribute(doc, rootElement, "failed",  String.valueOf(failedRunCount));
			DOMBuilder.addAttribute(doc, rootElement, "total",  String.valueOf(passedRunCount + skippedRunCount + failedRunCount));
			DOMBuilder.addAttribute(doc, rootElement, "passed-duration-ms",  String.valueOf(passedRunDuration));
			DOMBuilder.addAttribute(doc, rootElement, "skipped-duration-ms",  String.valueOf(skippedRunDuration));
			DOMBuilder.addAttribute(doc, rootElement, "failed-duration-ms",  String.valueOf(failedRunDuration));
			DOMBuilder.addAttribute(doc, rootElement, "duration-ms",  String.valueOf(totalRunDuration));
			DOMBuilder.addAttribute(doc, rootElement, "started-at", dfDateTime.format(runStartDate));
			DOMBuilder.addAttribute(doc, rootElement, "finished-at", dfDateTime.format(runEndDate));
			DOMBuilder.addAttribute(doc, rootElement, "status", runStatus);
			//if (null != suite.getParameter("almAllRunsUnderBrowserDateCombo"))
			
			if ((useApplicationPDF!=null) && (true == useApplicationPDF.equalsIgnoreCase("Yes")))
			{
				//no need to extract from the jar or copy from project because the project has its own templates for use
				System.out.println("Using PDFtempletes folder from application");
			}
			else 
			{
				if (PDFReporter.class.getResource("PDFReporter.class").toString().startsWith("jar:") == true)
				{
					//unpack the templates from the jar for use
					UnzipJar.unzipJar("target/test-classes/pdftemplates", "framework", "LATESTONLOCAL", "pdftemplates");
					System.out.println("Unpacked pdftemplates folder from framework jar file");
				}
				else
				{
					if (System.getProperty("os.name").toLowerCase().contains("win") == false)
					{
						try
						{
							File sourceFile = new File(System.getProperty("user.dir").toString().substring(0,System.getProperty("user.dir").toString().lastIndexOf("/")) + "/framework/src/test/resources/pdftemplates");
						
							File destFile = new File("target/test-classes/pdftemplates");
							FileUtils.copyDirectory(sourceFile,destFile);	
							destFile.setExecutable(true);
							System.out.println("Copied pdftemplates to target folder ");
						}
						catch (Exception ex)
						{
							System.out.println("EXCEPTION IN PDF Reporter: " + ex.getMessage().toString());
						}
					}
					else
					{
						try
						{	File sourceFile;					
							try {
								String path=PathHelper.getWorkingDirectoryPath()+"\\\\src\\\\test\\\\resources\\\\pdftemplates";
								
								sourceFile = new File(path);
								System.out.println("in TRY");
							} catch (Exception e) {
								sourceFile = new File(System.getProperty("user.dir").substring(0,System.getProperty("user.dir").lastIndexOf("workspace") + 10) + "framework\\\\src\\\\test\\\\resources\\\\pdftemplates");
								System.out.println("in catch");
							}
						
							File destFile = new File("target/test-classes/pdftemplates");
							FileUtils.copyDirectory(sourceFile,destFile);	
							destFile.setExecutable(true);
							System.out.println("Copied pdftemplates to target folder ");
						}
						catch (Exception ex)
						{
							System.out.println("EXCEPTION IN PDF Reporter: " + ex.getMessage().toString());
						}
					}
				}
			}
									
			final DOMSource dom = new DOMSource(doc);
			
			writeXMLFile(dom, "target/test-run-result.xml");	
			writeCSVFile("target/test-classes/pdftemplates/csvreport.xsl", suiteName);
			writeXMLFile(dom, suiteName.replace(".pdf", "") + "_test-run-result.xml");	
			//writePDFFile(dom, "target/test-classes/ReportTemplate.xsl", "test-output/result.pdf");
			
			//Put in this work around so we get a special variation, rather then having two different PDF listeners.
			/*TODO isha
			 * 
			 * String jenkinsInstance;
			try{
				jenkinsInstance = System.getenv("BUILD_URL").toString();
			}
			catch (Exception ex)
			{
				//do nothing, value probably does not exist.  so just set the instance to blank
				jenkinsInstance = "";
			}
			if (jenkinsInstance.contains("8086")|| jenkinsInstance.contains("8082"))if (jenkinsInstance.contains("8080")){
				if ((failedRunCount > 0 || skippedRunCount > 0)	&& (suiteName.lastIndexOf("_FAILED") == -1)) {
					suiteName = suiteName.substring(0, suiteName.indexOf(".pdf")) + "_FAILED" + ".pdf";
				}
			}*/
			
			writePDFFile(dom, "target/test-classes/pdftemplates/pdfreport.xsl", suiteName);
			
			//writePDFFile(dom, "../framework/target/classes/pdftemplates/pdfreport.xsl", suiteName);	
			
			//delete the test-run-result file since we really only want to use the ones with the suite name in them
			//the base one is used only in pdf generation
			new File("target/test-run-result.xml").delete();
			
			if ((triggerEmail!=null) && (true == triggerEmail.equalsIgnoreCase("Yes")))
			{
				triggerMail();
			}
		} 
		catch(Exception e) {
			System.out.println("Error in Generate Report:");
			e.printStackTrace();
		}
			
	}	
	
	private static void writeCSVFile(final String templatePath, final String reportPath) throws Exception {
		
		try{
			
		/*final File xsltFile = new File(templatePath);*/  // templatePath
		/*File xmlsource=new File ("target/test-run-result.xml");*/
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document resultDoc = builder.parse(transformFilePath("target/test-run-result.xml"));
	    Source resultSrc = new DOMSource(resultDoc);
	    final StreamSource transformSource = new StreamSource(transformFilePath(templatePath));
	    
		/*final Transformer transformer = TransformerFactory.newInstance().newTransformer();*/
		Transformer transformer = TransformerFactory.newInstance().newTransformer(transformSource);
		String reportPathTransform=reportPath.replace("\\", "/");
	    final String csvName=reportPathTransform.replace(".pdf", "")+".csv";
	    Result outputTarget = new StreamResult(transformFileAbsolutePath(csvName));
	    transformer.transform(resultSrc, outputTarget);
		System.out.println("writing CSV File SUCCESS");
		}
		catch (Exception ex)
		{
			System.out.println("Exception in writing CSV File: " + ex.getMessage());
			
		}
	
	}
	private static void writePDFFile(final DOMSource dom, final String templatePath, final String reportPath) throws Exception {
		FileOutputStream fileStream = null;
		ByteArrayOutputStream outStream = null;
		try
		{
			final FopFactory fopFactory = FopFactory.newInstance();
			final FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			outStream = new ByteArrayOutputStream();
			/*final File xsltFile = new File(templatePath);*/  // templatePath
			final StreamSource transformSource = new StreamSource(transformFilePath(templatePath));
			final Transformer xslfoTransformer = new net.sf.saxon.TransformerFactoryImpl().newTransformer(transformSource);
			final Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,	foUserAgent, outStream);
			final Result res = new SAXResult(fop.getDefaultHandler());
			
			xslfoTransformer.transform(dom, res);
			final File pdfFile = new File(reportPath);	// reportPath
			fileStream = new FileOutputStream(pdfFile);
			fileStream.write(outStream.toByteArray());
			fileStream.close();		
			System.out.println("writing PDF File SUCCESS");
		}
		catch (Exception ex)
		{
			System.out.println("Exception in writing PDF File: " + ex.getMessage());
			//try to close the filestream and outstream just in case, because we dont want to deal with files that are left open
			//open files hang the archiver
			try
			{
				fileStream.close();
			}
			catch (Exception ex1)
			{
				//dont care, just making sure the file is closed
				logger.log(Level.SEVERE, ex1.getMessage());
			}
			
			try
			{
				outStream.close();
			}
			catch (Exception ex2)
			{
				//dont care, just making sure the outstream is closed
				logger.log(Level.SEVERE, ex2.getMessage());
			}
		}
				
	}
	
		
		
	
	
	enum ReportVerbosity {		
		NONE(0), SUITESUMMARY(1), TESTSUMMARY(2), STEPS(4), DETAILS(8), LOG(16), SCREENSHOTS_ON_FAILURE(32), SCREENSHOTS_ON_SUCCESS(64);
		
		public static String PARAMETER = "reportDetailLevel";
		public static String SCREENSHOT = "makeScreenshots";
		public static String BROWSER = "browser";
		
		public static int MAX = 127;
		
		private int verbosity;
		
		ReportVerbosity(final int value) {
			this.verbosity = value;
		}
		
		public String toString() {
			return String.valueOf(verbosity);
		}
		
		public int value() {
			return verbosity;
		}
		
		public static List<Integer> computePowersOfTwoPartition(final int number) {
			final ArrayList<Integer> partition = new ArrayList<Integer>();
	        int tmp;
	        if (number == 0) {
	            partition.add(new Integer(0));
	            return partition;
	        }

	        for (int i = 0; i < 32; i++) {
	        	final int mask = 1 << i;
	            tmp = mask & number;
	            if (tmp != 0) {partition.add(new Integer(tmp));}
	        }

	        return partition;
	    }
		
		public static List<Integer> computePowersOfTwo(final int number){
			final List<Integer> partition = new ArrayList<Integer>();
			
			 int exponent;
		      for(exponent=0;exponent <= number;exponent++ ){
		    	  if((Math.pow(2, exponent))<=number){
			         // System.out.println ("2^" + exponent + " = " +(int)Math.pow(2, exponent));
			         partition.add((int)Math.pow(2, exponent));
		      }
		    }
			return partition;
		}
		
		public static boolean contains(final List<?> list, final int verbosity) {		
			if(list != null) {
				for(Object each : list) {
					if(each != null && each instanceof Integer && Integer.parseInt(each.toString())== verbosity) {
						{return true;}
					}
				}
			}
			return false;
		}
		
		public static  int validateVerbosity(final String value) {
		if(value == null) {return 0;}
		try {
			final int verbosity = Integer.parseInt(value);
			if(verbosity > 0 && verbosity <= ReportVerbosity.MAX)
				{return verbosity;}
		}
		catch(NumberFormatException e) {logger.log(Level.SEVERE, e.getMessage());}
		return 0;
	}
		
	}

	
	// Compares 2 ITestResult objects in chronological order	
	 static class ChronologicalTestResultComparator  implements Comparator<ITestResult>{
			
		public int compare(final ITestResult one, final ITestResult two) {
			final long oneStart = one.getStartMillis();
			final long twoStart = two.getStartMillis();
			if (oneStart > twoStart)
				{return 1;}
			if (twoStart > oneStart)
				{return -1;}
			final long oneEnd = one.getEndMillis();
			final long twoEnd = two.getEndMillis();
			if (oneEnd > twoEnd)
				{return 1;}
			if (twoEnd > oneEnd)
				{return -1;}
			return 0;
		}

	}
	 
	// Compares 2 ITestContext objects in chronological order
	 static class ChronologicalTestContextComparator  implements Comparator<ITestContext>{
			
			public int compare(final ITestContext one, final ITestContext two) {
				final long oneStart = one.getStartDate().getTime();
				final long twoStart = two.getStartDate().getTime();
				if (oneStart > twoStart)
					{return 1;}
				if (twoStart > oneStart)
					{return -1;}
				final long oneEnd = one.getEndDate().getTime();
				final long twoEnd = two.getEndDate().getTime();
				if (oneEnd > twoEnd)
					{return 1;}
				if (twoEnd > oneEnd)
					{return -1;}
				return 0;
			}

		}
	 
	
	 static class DOMBuilder {
		 public static StringBuffer verbosityList= new StringBuffer();
		 public static Element buildSuite(final Document doc, final Element parent, final ISuite suite) throws Exception {
				// overall counts
				int passedSuiteCount = 0;
				int failedSuiteCount = 0;
				int skippedSuiteCount = 0;
				
				// overall durations
				long passedSuiteDuration = 0l;
				long failedSuiteDuration  = 0l;
				long skippedSuiteDuration = 0l;		
				long totalSuiteDuration = 0l;
				// overall dates
				Date suiteStartDate = null;
				Date suiteEndDate = null;	
				
				String suiteStatus = "PASS";
				
				int verbosity  = 0;
				try { verbosity  = Integer.parseInt(suite.getParameter(ReportVerbosity.PARAMETER)); }
				catch(Exception e) { verbosity = ReportVerbosity.SCREENSHOTS_ON_FAILURE.value(); }
				
				
				final List<Integer> verbosityType=ReportVerbosity.computePowersOfTwoPartition(verbosity);
				
				for(Integer temp:verbosityType){
					verbosityList.append("-");
					verbosityList.append(temp.toString());					
				}
				verbosityList.append("-");
				
				//System.out.println(verbosityList);
				final Element suiteElement = addElement(doc, parent, "suite");
				addAttribute(doc, suiteElement, "name", suite.getName());
				addAttribute(doc, suiteElement, "verbosity", verbosityList.toString());
				
				final Map<String, ISuiteResult> resultMap = suite.getResults();
				final ArrayList<ITestContext> contextList=new ArrayList<ITestContext>();
								
				for(String resultName : resultMap.keySet()) {
					final ITestContext context = resultMap.get(resultName).getTestContext();					
					contextList.add(context);
				}
				// sort test Name by their start time
				Collections.sort(contextList, new PDFReporter.ChronologicalTestContextComparator());
				
				//for(String resultName : resultMap.keySet()) {
				for(ITestContext tempSuit : contextList) {					
					//Element testElement = buildTest(doc, suiteElement, resultMap.get(resultName));
					final Element testElement = buildTest(doc, suiteElement,tempSuit.getSuite().getResults().get(tempSuit.getName()));
					passedSuiteCount += Integer.parseInt(testElement.getAttribute("passed"));
					skippedSuiteCount += Integer.parseInt(testElement.getAttribute("skipped"));
					failedSuiteCount += Integer.parseInt(testElement.getAttribute("failed"));
					passedSuiteDuration += Long.parseLong(testElement.getAttribute("passed-duration-ms"));
					skippedSuiteDuration += Long.parseLong(testElement.getAttribute("skipped-duration-ms"));
					failedSuiteDuration += Long.parseLong(testElement.getAttribute("failed-duration-ms"));
					totalSuiteDuration += Long.parseLong(testElement.getAttribute("duration-ms"));
					final String testStatus = testElement.getAttribute("status");
					if("PASS".equals(suiteStatus))	{suiteStatus = testStatus;}
					else if("SKIP".equals(suiteStatus) && "FAIL".equals(testStatus)) {suiteStatus = "FAIL";}
					
					final long startTime  = dfDateTime.parse(testElement.getAttribute("started-at")).getTime();
					final long endTime =  dfDateTime.parse(testElement.getAttribute("finished-at")).getTime();
					
					if(suiteStartDate == null || suiteStartDate.getTime() > startTime) {
						calendar.setTimeInMillis(startTime); 
						suiteStartDate = calendar.getTime();
					}
					if(suiteEndDate == null || suiteEndDate.getTime() < endTime) {
						calendar.setTimeInMillis(endTime); 
						suiteEndDate = calendar.getTime();
					}
					
					buildHistory(doc, suiteElement,tempSuit.getSuite().getResults().get(tempSuit.getName()));
				}
				
				
				final List<String> reportLog=Reporter.getOutput();
				for(String tempLog:reportLog){
					final Element logsElement = addElement(doc, suiteElement, "logs");
					final Element valueElement = addElement(doc, logsElement, "log");
					addCDATA(doc, valueElement, tempLog);
				}
				addAttribute(doc, suiteElement, "passed",  String.valueOf(passedSuiteCount));
				addAttribute(doc, suiteElement, "skipped",  String.valueOf(skippedSuiteCount));
				addAttribute(doc, suiteElement, "failed",  String.valueOf(failedSuiteCount));
				addAttribute(doc, suiteElement, "total",  String.valueOf(passedSuiteCount + skippedSuiteCount + failedSuiteCount));
				addAttribute(doc, suiteElement, "passed-duration-ms",  String.valueOf(passedSuiteDuration));
				addAttribute(doc, suiteElement, "skipped-duration-ms",  String.valueOf(skippedSuiteDuration));
				addAttribute(doc, suiteElement, "failed-duration-ms",  String.valueOf(failedSuiteDuration));
				addAttribute(doc, suiteElement, "duration-ms",  String.valueOf(totalSuiteDuration));
				addAttribute(doc, suiteElement, "started-at", dfDateTime.format(suiteStartDate));
				addAttribute(doc, suiteElement, "finished-at", dfDateTime.format(suiteEndDate));
				addAttribute(doc, suiteElement, "status",  suiteStatus);
				addAttribute(doc, suiteElement, "reportName",  suitHeader);
				addAttribute(doc, suiteElement, "testDescription",  testDescription);
				//addAttribute(doc, suiteElement, "verbosityType", verbosityList.toString());
				return suiteElement;
			}
			
		 	private static void buildHistory(final Document doc, final Element suite, final ISuiteResult result)
		 	{
		 		List<String> runtimedates = new ArrayList<String>();
		 		List<String> durations = new ArrayList<String>();
		 		List<String> skips = new ArrayList<String>();
		 		List<String> passes = new ArrayList<String>();
		 		List<String> fails = new ArrayList<String>();
		 		List<String> totals = new ArrayList<String>();
		 		List<String> failedTestNames = new ArrayList<String>();
		 		List<String> exceptions = new ArrayList<String>();
		 		List<String> testLists = new ArrayList<String>();
		 		
		 		final int numHistoryRows = 10;
		 		int rows = 0;
		 		try {
					rows = StatusTrackerInterface.getTestHistory(result.getTestContext().getSuite().getName(),numHistoryRows +1, runtimedates, durations,skips,passes,fails,totals,failedTestNames,exceptions,testLists);
				} catch (Throwable e) {
					System.out.println("Failed to get results from Database");
					e.printStackTrace();
					rows = 0;
				}
		 		//start with 1 because we don't really want the current row from this test run.
		 		for (int i=1; i< rows; i++)
		 		{
		 			final Element testElement = addElement(doc, suite, "history");	
		 			addAttribute(doc, testElement, "runtimedate", runtimedates.get(i));
		 			addAttribute(doc, testElement, "duration", durations.get(i));
		 			addAttribute(doc, testElement, "skip", skips.get(i));
		 			addAttribute(doc, testElement, "pass", passes.get(i));
		 			addAttribute(doc, testElement, "fail", fails.get(i));
		 			addAttribute(doc, testElement, "total", totals.get(i));
		 			addAttribute(doc, testElement, "failedtestname", failedTestNames.get(i));
		 			addAttribute(doc, testElement, "exceptionstacktrace", exceptions.get(i));
		 			addAttribute(doc, testElement, "testlist", testLists.get(i));
		 			if (Integer.parseInt(fails.get(i)) <=0 && Integer.parseInt(skips.get(i)) <= 0)
		 			{
		 				addAttribute(doc, testElement, "historystatus", "PASS");
		 			}
		 			else
		 			{
		 				addAttribute(doc, testElement, "historystatus", "FAIL");
		 			}
		 		}
		 		if (rows < 2)
		 		{
		 			//This makes the xsl happy if there is no history.
		 			final Element testElement = addElement(doc, suite, "history");	
		 			addAttribute(doc, testElement, "runtimedate", "N/A");
		 			addAttribute(doc, testElement, "historystatus", "N/A");
		 		}
				
		 	}
			
			public static Element buildTest(final Document doc, final Element suite, final ISuiteResult result) throws Exception {
				
				int passedTestCount = 0;
				int failedTestCount = 0;
				int skippedTestCount = 0;

				long passedTestDuration = 0l;
				long failedTestDuration  = 0l;
				long skippedTestDuration = 0l;		
				
				final ITestContext context = result.getTestContext();
				final Date testStartDate = context.getStartDate();
				final Date testEndDate = context.getEndDate();
				final long testDuration = testEndDate.getTime() - testStartDate.getTime();
				
				int testStatus = ITestResult.SUCCESS;
				
				final Element testElement = addElement(doc, suite, "test");	
				addAttribute(doc, testElement, "name", context.getName());
				addAttribute(doc, testElement, "started-at",  dfDateTime.format(testStartDate));
				addAttribute(doc, testElement, "finished-at",  dfDateTime.format(testEndDate));
				addAttribute(doc, testElement, "duration-ms",  String.valueOf(testDuration));
				//addAttribute(doc, testElement, "verbosityType", verbosityList.toString());		
				// sort test steps by their start time
				final ArrayList<ITestResult> allresults = new ArrayList<ITestResult>();
				allresults.addAll(context.getPassedTests().getAllResults());
				allresults.addAll(context.getFailedTests().getAllResults());
				allresults.addAll(context.getSkippedTests().getAllResults());
				Collections.sort(allresults, new PDFReporter.ChronologicalTestResultComparator());
				// process test steps		
				int testNo = 0;
				for(ITestResult each : allresults) {
					buildTestStep(doc, testElement, each, ++testNo);	
					final long duration  = each.getEndMillis() - each.getStartMillis();
					switch(each.getStatus()) {
						case ITestResult.SUCCESS: passedTestCount++; passedTestDuration += duration; break;
						case ITestResult.FAILURE: failedTestCount++; failedTestDuration += duration; testStatus = ITestResult.FAILURE; break;
						case ITestResult.SKIP: skippedTestCount++; skippedTestDuration += duration; if(testStatus != ITestResult.FAILURE) {testStatus = ITestResult.SKIP;} break;
					}
				}
				addAttribute(doc, testElement, "passed",  String.valueOf(passedTestCount));
				addAttribute(doc, testElement, "skipped",  String.valueOf(skippedTestCount));
				addAttribute(doc, testElement, "failed",  String.valueOf(failedTestCount));
				addAttribute(doc, testElement, "total",  String.valueOf(passedTestCount + skippedTestCount + failedTestCount));
				addAttribute(doc, testElement, "passed-duration-ms",  String.valueOf(passedTestDuration));
				addAttribute(doc, testElement, "skipped-duration-ms",  String.valueOf(skippedTestDuration));
				addAttribute(doc, testElement, "failed-duration-ms",  String.valueOf(failedTestDuration));
				addAttribute(doc, testElement, "status",  String.valueOf(translateTestStatus(testStatus)));
				
				return testElement;
			}

		// this function puts a zero-width space between each char so that the
		// PDF reporter can wrap if needed.
		private static String splitByLine(String input) {
			try {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < input.length(); i++) {
					sb.append(input.charAt(i) + "\u200B");
				}
				return sb.toString();
			} catch (Exception ex) {
				System.out.println("Error inserting zero width chars: "
						+ ex.getMessage());
				return input;
			}
		}
		 
		public static Element buildTestStep(final Document doc, final Element test, final ITestResult result, final int stepNo) throws Exception {
			final Element testStepElement = addElement(doc, test, "test-method");
			addAttribute(doc, testStepElement, "name", result.getName());
			addAttribute(doc, testStepElement, "status", translateTestStatus(result.getStatus()));
			calendar.setTimeInMillis(result.getStartMillis());
			addAttribute(doc, testStepElement, "started-at", dfTime.format(calendar.getTime()));
			calendar.setTimeInMillis(result.getEndMillis());
			addAttribute(doc, testStepElement, "finished-at", dfTime.format(calendar.getTime()));
			addAttribute(doc, testStepElement, "duration-ms", String.valueOf(result.getEndMillis() - result.getStartMillis()));
			addAttribute(doc, testStepElement, "sequence", String.valueOf(stepNo));
			final String className = result.getMethod().getRealClass().getName();
			addAttribute(doc, testStepElement, "class", String.valueOf(className.substring(className.lastIndexOf(".")+1)));	
			try
			{
				String extraParam = extraParameters.get(result.getName());
				if (extraParam != null)
				{
					addAttribute(doc,testStepElement,"testaddedparameter","\""+extraParam.replaceAll("(\\r|\\n)", "")+"\"");
				}
			}
			catch (Exception ex)
			{
				//Do nothing there is no test added parameters to add to the PDF.
			}
			
			//addAttribute(doc, testStepElement, "verbosityType", verbosityList.toString());
			final Object[] parameters = result.getParameters();
			if (parameters != null && parameters.length > 0) {
				final Element parametersElement = addElement(doc, testStepElement, "parameters");				
				for (int i = 0; i < parameters.length; i++) {
					final Element parameterElement = addElement(doc, parametersElement, "parameter");
					addAttribute(doc, parameterElement, "index", String.valueOf(i + 1));
					final Element valueElement = addElement(doc, parameterElement, "value");
					addCDATA(doc, valueElement, splitByLine(parameters[i].toString()));
				}
			}

			//Element logsElement = addElement(doc, testStepElement, "logs");
			
			if (result.getStatus() != ITestResult.SUCCESS && result.getThrowable() != null) {
				final Throwable t = result.getThrowable();
				final Element exception = addElement(doc, testStepElement, "exception");
				addAttribute(doc, exception, "class", t.getClass().getName());
				final Element message = addElement(doc, exception, "message");
				addCDATA(doc, message, t.getMessage());
				final Element stackTrace = addElement(doc, exception, "full-stacktrace");
				final StackTraceElement[] lines = t.getStackTrace();
				final StringBuffer bf = new StringBuffer();
				for (int i = 0; i < 10 && i < lines.length; i++) {
					final String line  = lines[i].toString();
					if(line.length() < 100)
					{bf.append(line).append("\n");}
					else {
						final List<String> stackLines = StringUtils.splitEqually(line, 100);
					for(String stackline : stackLines)
						{bf.append(stackline).append("\n");}
					}
					}  
				addCDATA(doc, stackTrace, bf.toString());

			}
			if (result.getAttribute("step") != null) {
				addAttribute(doc, testStepElement, "step", result.getAttribute("step").toString());
			}
			if (result.getAttribute("testname") != null) {
				addAttribute(doc, testStepElement, "testname", result.getAttribute("testname").toString());
			}
			if (result.getAttribute("expected") != null) {
				addAttribute(doc, testStepElement, "expected", result.getAttribute("expected").toString());
			}
			if (result.getAttribute("failureMessage") != null) {
				addAttribute(doc, testStepElement, "failureMessage", result.getAttribute("failureMessage").toString());
			}
			if (result.getAttribute("screenshot") != null) {
				addAttribute(doc, testStepElement, "screenshot", result.getAttribute("screenshot").toString());
			}
			//Add performance stuff
			if (result.getAttribute("docLoadTime") != null) {
				addAttribute(doc, testStepElement, "docLoadTime", result.getAttribute("docLoadTime").toString());
			}
			if (result.getAttribute("docRequests") != null) {
				addAttribute(doc, testStepElement, "docRequests", result.getAttribute("docRequests").toString());
			}
			if (result.getAttribute("docBytesIn") != null) {
				addAttribute(doc, testStepElement, "docBytesIn", result.getAttribute("docBytesIn").toString());
			}
			
			if (result.getAttribute("fullLoadTime") != null) {
				addAttribute(doc, testStepElement, "fullLoadTime", result.getAttribute("fullLoadTime").toString());
			}
			if (result.getAttribute("fullRequests") != null) {
				addAttribute(doc, testStepElement, "fullRequests", result.getAttribute("fullRequests").toString());
			}
			if (result.getAttribute("fullBytesIn") != null) {
				addAttribute(doc, testStepElement, "fullBytesIn", result.getAttribute("fullBytesIn").toString());
			}
			
			if (result.getAttribute("PerformanceVisuallyComplete") != null) {
				addAttribute(doc, testStepElement, "PerformanceVisuallyComplete", result.getAttribute("PerformanceVisuallyComplete").toString());
			}
			if (result.getAttribute("PerformanceScore") != null) {
				addAttribute(doc, testStepElement, "PerformanceScore", result.getAttribute("PerformanceScore").toString());
				addAttribute(doc, testStepElement, "TransactionName", result.getAttribute("TransactionName").toString());
			}
			if (result.getAttribute("Performancedetails") != null) {
				addAttribute(doc, testStepElement, "Performancedetails", result.getAttribute("Performancedetails").toString());
			}
			
			if (result.getAttribute("log") != null) {
				final Element reporterElement = addElement(doc, testStepElement, "reporter-output");
				@SuppressWarnings("unchecked")
				final List<String> lines = (List<String>) result.getAttribute("log");
				for (String line : lines) {
					final Element lineElement = addElement(doc, reporterElement, "line");
					addCDATA(doc, lineElement, line);
				}
			}

			return testStepElement;
		}
		 
		
		// creates an empty document
		public static Document createEmptyDocument() throws Exception {
			final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			final Document doc = docBuilder.newDocument();
			return doc;
		}

		// adds an attribute to an element
		public static void addAttribute(final Document doc, final Element element, final String attribute, final String value) {
			final Attr attr = doc.createAttribute(attribute);
			attr.setValue(value);
			element.setAttributeNode(attr);
		}

		// adds a CDATA section to the element
		public static void addCDATA(final Document doc, final Element element, final String data) {
			final CDATASection cdata = doc.createCDATASection(data);
			element.appendChild(cdata);
		}

		// adds a text to the element
		public static void addText(final Element element, final String textContent) {
			//element.setTextContent(textContent);
		}

		// adds an element
		public static Element addElement(final Document doc, final Element parent, final String name) {
			final Element child = doc.createElement(name);
			parent.appendChild(child);
			return child;
		}
		
		
	}


	public void onFinish(final ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
	}


	public void onTestSkipped(final ITestResult result) {
		setDocumentationValues(result);
	}

	

	public void onTestStart(final ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void triggerMail() {
		//this method is overridden in other code that specifically needs this.  this is because we dont want to bury custom support and email
		//handling into a framework core item.
		
	}
	
	public static void main(final String [ ] args)
	{
	System.out.println(ReportVerbosity.computePowersOfTwo(16));
	System.out.println(ReportVerbosity.computePowersOfTwoPartition(16));
	}


}






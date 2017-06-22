
package com.guru.framework.testing.selenium;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

public class WebDriverPerformance extends BaseWebDriver {
	
	private static PerfData localPerfData;
	private static List<PerfData> LocalPerfDataCollection;
	private static boolean stale;
	private static String name;
	private static String appName;
	private static boolean simple;
	private static long startTime;
	private static List<SubTransaction> subTransactions;

	//the boolean simple indicates if we should use the chrome logs to process, or just start a simple timer.
	public static void startSimple()
	{
		simple = true;
		startTime = System.currentTimeMillis(); 
	}
	public static void start()
	{		 
		simple = false;
		if (subTransactions != null)
		{
			subTransactions.clear();
		}
		//just clear the chrome log
		if(browser.equalsIgnoreCase("chrome"))
		{
			try
			{
				driver.manage().logs().get(LogType.PERFORMANCE).getAll();
			}
			catch (Exception ex)
			{
				System.out.println("Error occured trying to clear the chrome log.  This is expected with chrome versions less than 32 " + ex.getMessage());
				System.out.println("This error is ignored");
			}
		}
	}
	public static void definePerformanceSubTransactionByRegex(String regex, String name)
	{
		if (subTransactions == null)
		{
			subTransactions = new ArrayList<SubTransaction>();
		}
		subTransactions.add(new SubTransaction(regex,name));
	}
	public static void stop(String appName_inp, String transactionName)
	{
		if (simple)
		{
			long time = System.currentTimeMillis() - startTime;
			processSimplePerformance(appName_inp, transactionName, time);
		}
		else
		{
		if(browser.equalsIgnoreCase("chrome"))
		{
			appName = appName_inp;
			name = transactionName;
			stale = false;
			try {
				Logs logs = driver.manage().logs();
				System.out.println("Log types: " + logs.getAvailableLogTypes());
				printLog(LogType.BROWSER);
				submitPerformanceResult(driver.getCurrentUrl(), logs.get(LogType.PERFORMANCE).getAll());
			}	
		    catch (Exception ex)
			{
				System.out.println("Error occured trying to access the chrome log: " + ex.getMessage());
				System.out.println("This error is ignored and test will continue");
				stale = true;
				name = "";
				appName = "";
			}
		}
		else
		{
			System.out.println("Performance not supported in " + browser + ", doing nothing.");
		}
		}
	}
	public static void clearAllResults()
	{
		if (LocalPerfDataCollection == null)
		{
			LocalPerfDataCollection = new ArrayList<PerfData>();
		}
		LocalPerfDataCollection.clear();
	}
	public static List<PerfData> getAllResults()
	{
		return LocalPerfDataCollection;
	}
	public static PerfData getResults()
	{
		if (stale)
		{
			return null;
		}
		else
		{
			stale = true;
			return localPerfData;
		}
	}
	private static void printLog(String type) {
		    List<LogEntry> entries = driver.manage().logs().get(type).getAll();
		    System.out.println(entries.size() + " " + type + " log entries found****");
		    for (LogEntry entry : entries) {
		      System.out.println(
		          new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		    }
	}
		 
	private static void submitPerformanceResult(String name, List<LogEntry> perfLogEntries)
		      throws IOException, JSONException, InterruptedException {
		    JSONArray devToolsLog = new JSONArray();
		    System.out.println(perfLogEntries.size() + " performance log entries found");
		    for (LogEntry entry : perfLogEntries) {
		    	JSONObject message = new JSONObject(entry.getMessage());
		    	JSONObject devToolsMessage = message.getJSONObject("message");
		    	// System.out.println(
		    	//     devToolsMessage.getString("method") + " " + message.getString("webview"));
		    	devToolsLog.put(devToolsMessage);
		    }
		    byte[] screenshot = null;
		    screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    String resultUrl = new WebPageTest(new URL("http://rainbow.comfin.ge.com:82/"), "Test", name)
		        .submitResult(devToolsLog, screenshot);
		     parseHTMLResult(resultUrl + "1/details/",name);
		    
		  }
	private static void processSimplePerformance(String app, String transaction, long time)
	{
		if (localPerfData == null)
		{
			localPerfData = new PerfData();
		}
		localPerfData.transactionName = transaction;
		localPerfData.appName = app;
		localPerfData.fullyLoadedTime = (time/1000) + "s";
		localPerfData.loadTime = "-1";
		localPerfData.firstByte = "-1";
		localPerfData.startRender = "-1";
		localPerfData.visuallycomplete = "-1";
		localPerfData.speedIndex = "-1";
		localPerfData.resultError = "-1";	
		localPerfData.docCompleteTime = "-1";
		localPerfData.docCompleteRequests = "-1";
		localPerfData.docCompleteBytesIn = "-1";
		localPerfData.fullyLoadedRequests = "-1";
		localPerfData.fullyLoadedBytesIn = "-1";
		localPerfData.url = "-1";
		localPerfData.testedURL = "-1";
		
		System.out.println("Transaction: " + localPerfData.transactionName);
		System.out.println("------------------------------");
		System.out.println("Fully Loaded Time: " + localPerfData.fullyLoadedTime);
		
		if (LocalPerfDataCollection == null)
		{
			LocalPerfDataCollection = new ArrayList<PerfData>();
		}
		PerfData temp = new PerfData(localPerfData);
		LocalPerfDataCollection.add(temp);		
	}
	
	private static void parseSubTransactions(Document doc, String resultURL, String appName)
	{
		if (subTransactions != null)
		{
			for (SubTransaction t: subTransactions)
			{
				parseSubTransaction(doc,t, resultURL, appName);
			}
		}
	}
	
	private static void parseSubTransaction(Document doc, SubTransaction trans, String resultURL, String appName)
	{
		//Loop through all IDs like "Headers_x" where x is an integer
		//this is where the data is stored for each URI, check if the regex
		//matches the saved URL, if so, its found, pull the data
		boolean found = false;
		int i = 1;
		do
		{
			Elements headersElements = doc.select("#headers_" + i );
					
			if (!headersElements.isEmpty())
			{
				//check the first one matching headers_, there should be only one or 0
				Elements subSections = headersElements.get(0).select(".indented2");
				//There are multiple, but the stuff we want is in the first "indented2" class
				Elements URLMatches = subSections.get(0).select("a[href~=" + trans.regex + "]");
				if (!URLMatches.isEmpty())
				{
					//Found a match, gather the data and then exit
					found = true;
					String regexForBreakingLine = "(URL: | Host: | Error/Status Code: | Start Offset: | Time to First Byte: | Content Download: | Bytes In \\(downloaded\\): | Bytes Out \\(uploaded\\): )";
					String resultsString = subSections.get(0).text();
					String[] values = resultsString.split(regexForBreakingLine);
					
					try
					{
						localPerfData.transactionName = trans.name;
						localPerfData.url = resultURL;
						localPerfData.appName = appName;
						localPerfData.testedURL = values[1];
						localPerfData.resultError = values[3];
						localPerfData.startRender = standardizeToS(values[4]);
						localPerfData.firstByte = standardizeToS(values[5]);
						//Its a mystery as to why its missing sometimes, which really messes up this parsing sometimes.  grrrr...
						if (resultsString.contains("Content Download:"))
						{
							localPerfData.loadTime = values[6];
							localPerfData.fullyLoadedBytesIn = values[7];
						}
						else
						{
							localPerfData.loadTime = "0";
							localPerfData.fullyLoadedBytesIn = values[6];
						}
						
						localPerfData.visuallycomplete = "-1";
						localPerfData.speedIndex = "-1";
						localPerfData.docCompleteTime = "-1";
						localPerfData.docCompleteRequests = "-1";
						localPerfData.docCompleteBytesIn = "-1";
						localPerfData.fullyLoadedRequests = "-1";
						localPerfData.fullyLoadedTime = "-1";
					}
					catch (Exception ex)
					{
						System.out.println("Somthing went wrong trying to parse the WPT data for page sub-transaction: " + trans);
						System.out.println("Data read:" + subSections.get(0).text() );
						ex.printStackTrace();
					}
				}
			}
			else
			{
				break;
			}
			i++;
		}
		while(!found);
		
		System.out.println("Partial Page Transaction: " + localPerfData.transactionName);
		System.out.println("------------------------------");
		System.out.println("URL: " + localPerfData.testedURL);
		System.out.println("HTTP Status: " + localPerfData.resultError);
		System.out.println("Start Offset: " + localPerfData.startRender);
		System.out.println("Time to First Byte: " + localPerfData.firstByte);
		System.out.println("Content Download: " + localPerfData.loadTime);
		System.out.println("Bytes In: " + localPerfData.fullyLoadedBytesIn);
		PerfData temp = new PerfData(localPerfData);
		LocalPerfDataCollection.add(temp);
	}
	private static String standardizeToS(String input)
	{
		if (input.toLowerCase().contains("ms"))
		{
			input = input.replace("ms","").replace(" ","");
			//double offset = Double.parseDouble(input);
			//offset /= 1000;
			//return String.format("%d", (int)offset);
		}
		if (input.toLowerCase().contains("s"))
		{
			input = input.replace("s","").replace(" ","");
			//return input;
		}
		
		return input;
	}
	private static void parseHTMLResult(String resultURL, String appURL)
			throws InterruptedException {
		try {
			Document doc = Jsoup.connect(resultURL).get();
			if (localPerfData == null) {
				localPerfData = new PerfData();
			}
			try {
				//Parse out and print the sub-transactions first.
				parseSubTransactions(doc,resultURL, appName);
				
				localPerfData.loadTime = doc.select("#LoadTime").get(0).text();
				localPerfData.firstByte = doc.select("#TTFB").get(0).text();
				localPerfData.startRender = doc.select("#startRender").get(0).text();
				try {
					localPerfData.visuallycomplete = doc.select("#visualComplate").get(0).text();
				} catch (Exception ex) {
					// Do nothing, sometimes this is just plain missing
					localPerfData.visuallycomplete = "-1";
				}	
				try {
					localPerfData.speedIndex = doc.select("#speedIndex").get(0)
							.text();
				} catch (Exception ex) {
					// Do nothing, sometimes this is just plain missing
					localPerfData.speedIndex = "-1";
				}
				try {
					localPerfData.resultError = doc.select("#result").get(1)
							.text();
				} catch (Exception ex) {
					// do nothing, sometimes this is just just plain missing
					localPerfData.resultError = "-1";
				}

				localPerfData.docCompleteTime = doc.select("#docComplete").get(0).text();
				localPerfData.docCompleteRequests = doc.select("#requestsDoc").get(0).text();
				localPerfData.docCompleteBytesIn = doc.select("#bytesInDoc").get(0).text();
				localPerfData.fullyLoadedTime = doc.select("#fullyLoaded").get(0).text();
				localPerfData.fullyLoadedRequests = doc.select("#requests").get(0).text();
				localPerfData.fullyLoadedBytesIn = doc.select("#bytesIn").get(0).text();
				localPerfData.url = resultURL;
				localPerfData.transactionName = name;
				localPerfData.appName = appName;
				URI uri = new URI(appURL);
				localPerfData.testedURL = uri.getHost();
			} catch (Exception ex) {

				System.out.println("Failed to parse Jsoup data" + ex.getMessage());
				System.out.println("URL: " + resultURL);
				ex.printStackTrace();
				localPerfData = null;
				return;
			}

			System.out.println("Full Page Transaction: " + localPerfData.transactionName);
			System.out.println("------------------------------");
			System.out.println("Load Time: " + localPerfData.loadTime);
			System.out.println("First Byte: " + localPerfData.firstByte);
			System.out.println("Start Render: " + localPerfData.startRender);
			System.out.println("Visualy Complete: "	+ localPerfData.visuallycomplete);
			System.out.println("Speed Index: " + localPerfData.speedIndex);
			System.out.println("Result Error Code: "+ localPerfData.resultError);
			System.out.println("Doc Complete Time: "+ localPerfData.docCompleteTime);
			System.out.println("Doc Complete Requests: "+ localPerfData.docCompleteRequests);
			System.out.println("Doc Complete Bytes In: "+ localPerfData.docCompleteBytesIn);
			System.out.println("Fully Loaded Time: "+ localPerfData.fullyLoadedTime);
			System.out.println("Fully Loaded Requests: "+ localPerfData.fullyLoadedRequests);
			System.out.println("Fully Loaded Bytes In: " + localPerfData.fullyLoadedBytesIn);
			System.out.println("Details URL: " + localPerfData.url);
			System.out.println("Tested URL: " + localPerfData.testedURL);

			if (LocalPerfDataCollection == null) {
				LocalPerfDataCollection = new ArrayList<PerfData>();
			}
			PerfData temp = new PerfData(localPerfData);
			LocalPerfDataCollection.add(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
public static class SubTransaction
{
	public SubTransaction(String regex_inp, String name_inp)
	{
		regex = regex_inp;
		name = name_inp;
	}
	public String regex;
	public String name;
}
public static class PerfData
{
	public PerfData()
	{
		//do nothing
	}
	public PerfData(PerfData tmp)
	{
		loadTime = tmp.loadTime;
		firstByte = tmp.firstByte;
		startRender = tmp.startRender;
		visuallycomplete = tmp.visuallycomplete;
		speedIndex = tmp.speedIndex;
		resultError = tmp.resultError;
		docCompleteTime = tmp.docCompleteTime;
		docCompleteRequests = tmp.docCompleteRequests;
		docCompleteBytesIn = tmp.docCompleteBytesIn;
		fullyLoadedTime = tmp.fullyLoadedTime;
		fullyLoadedRequests = tmp.fullyLoadedRequests;
		fullyLoadedBytesIn = tmp.fullyLoadedBytesIn;
		url = tmp.url;
		transactionName = tmp.transactionName;
		testedURL = tmp.testedURL;	
		appName = tmp.appName;
	}
	public String loadTime;
	public String firstByte;
	public String startRender;
	public String visuallycomplete;
	public String speedIndex;
	public String resultError;
	public String docCompleteTime;
	public String docCompleteRequests;
	public String docCompleteBytesIn;
	public String fullyLoadedTime;
	public String fullyLoadedRequests;
	public String fullyLoadedBytesIn;
	public String url;
	public String transactionName;
	public String testedURL;
	public String appName;
}
public static class WebPageTest extends BaseWebDriver {
	  private final String location;
	  private final URL createTestUrl;
	  private final URL workDoneUrl;
	  private final String mimeBoundary = "-----CorrectBatteryHorseStaple";
	 
	  public WebPageTest(URL baseUrl, String location, String testUrl) throws IOException {
	    this.location = location;
	    this.createTestUrl = new URL(baseUrl,
	        "runtest.php?location=" + location + "&url=" + URLEncoder.encode(testUrl, "UTF-8") +
	        "&fvonly=1&f=json");
	    this.workDoneUrl = new URL(baseUrl, "work/workdone.php");
	  }
	 
	  public String submitResult(JSONArray devToolsLog, byte[] screenshot) throws IOException, JSONException {
	    JSONObject testDescriptor = createTest();
	    postResult(testDescriptor, devToolsLog, screenshot);
	    return testDescriptor.getJSONObject("data").getString("userUrl");
	  }
	 
	  private void writeResultsZip(OutputStream os, JSONArray devToolsLog, byte[] screenshot)
	      throws IOException, JSONException {
	    ZipOutputStream zos = new ZipOutputStream(os);
	    if (null != devToolsLog) {
	      zos.putNextEntry(new ZipEntry("1_devtools.json"));
	      OutputStreamWriter writer = new OutputStreamWriter(zos);
	      devToolsLog.write(writer);
	      writer.flush();
	      zos.closeEntry();
	    }
	    if (null != screenshot) {
	      zos.putNextEntry(new ZipEntry("1_screen.png"));
	      zos.write(screenshot);
	      zos.closeEntry();
	    }
	    zos.finish();
	  }
	 
	  private JSONObject createTest() throws IOException, JSONException {
	    HttpURLConnection http = (HttpURLConnection) createTestUrl.openConnection();
	    if (HttpURLConnection.HTTP_OK != http.getResponseCode()) {
	      throw new IOException("WebPageTest test creation failed for location " + location + ": " +
	                            http.getResponseCode() + " " +http.getResponseMessage());
	    }
	    Reader reader = new InputStreamReader(http.getInputStream(), "UTF-8");
	    try {
	    	JSONObject result = new JSONObject(new JSONTokener(reader));
	    	if (!result.has("data")) {
	    	    throw new IOException("WebPageTest test creation failed for location " + location + ": " + result);
	    	}
	    	return result;
	     // return new JSONObject(new JSONTokener(reader));
	    } finally {
	      reader.close();
	    }
	  }
	 
	  private void postResult(JSONObject testDescriptor, JSONArray devToolsLog, byte[] screenshot)
	      throws IOException, JSONException {
	    HttpURLConnection http = (HttpURLConnection) workDoneUrl.openConnection();
	    http.setDoOutput(true);
	    http.addRequestProperty("Content-Type", "multipart/form-data; boundary=" +
	                            mimeBoundary);
	    http.setChunkedStreamingMode(4096);
	    writeMultipartContent(http.getOutputStream(), testDescriptor, devToolsLog, screenshot);
	    http.getInputStream().close();
	    if (HttpURLConnection.HTTP_OK != http.getResponseCode()) {
	      throw new IOException("Result submission failed for " +
	                            testDescriptor.getJSONObject("data").getString("userUrl") + " : " +
	                            http.getResponseCode() + " " +http.getResponseMessage());
	    }
	  }
	 
	  private void writeMultipartContent(
	      OutputStream os, JSONObject testDescriptor, JSONArray devToolsLog, byte[] screenshot)
	      throws IOException, JSONException {
	    String testId = testDescriptor.getJSONObject("data").getString("testId");
	    OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
	    startMimePart(writer, "location", null);
	    writer.write("\r\n" + location + "\r\n");
	    startMimePart(writer, "id", null);
	    writer.write("\r\n" + testId + "\r\n");
	    startMimePart(writer, "done", null);
	    writer.write("\r\n1\r\n");
	    startMimePart(writer, "file", "1_results.zip");
	    writer.write("Content-Type: application/zip\r\n");
	    writer.write("Content-Transfer-Encoding: binary\r\n\r\n");
	    writer.flush();
	    writeResultsZip(os, devToolsLog, screenshot);
	    writer.write("\r\n--");
	    writer.write(mimeBoundary);
	    writer.write("--\r\n");
	    writer.flush();
	  }
	 
	  private void startMimePart(Writer writer, String name, String filename) throws IOException {
	    writer.write("--");
	    writer.write(mimeBoundary);
	    writer.write("\r\n");
	    writer.write("Content-Disposition: form-data; name=\"");
	    writer.write(name);
	    if (null != filename) {
	      writer.write("\"; filename=\"");
	      writer.write(filename);
	    }
	    writer.write("\"\r\n");
	  }
}
public static void main(String[] argv)
{
	try {
		definePerformanceSubTransactionByRegex("/tanalyzeperformance/applyTier1Widget\\.do.*accidentCostPerDistanceDriven", "Accidents");  
		definePerformanceSubTransactionByRegex("/tanalyzeperformance/applyTier1Widget\\.do.*maintenanceCostPerMile", "maintenance");  
		definePerformanceSubTransactionByRegex("/tanalyzeperformance/applyTier1Widget\\.do.*fuelCostPerGallon", "Fuelcost");  
		definePerformanceSubTransactionByRegex("/tanalyzeperformance/applyTier1Widget\\.do.*leaseDepreciationCostPerMile", "Depreciation");  
		
		parseHTMLResult("http://rainbow.comfin.ge.com:82/result/150102_S8_V/1/details/", "https://qsecurity.gefleet.com/auth/login.htm?TYPE=33554433&REALMOID=06-3117eee5-e9e3-102a-853e-853c5ee80cb3&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=$SM$2iFt1n7kV0zzR0AMtCPuAK8CsxCjnux%2fi4In3cKXt8KBYL%2bGGAhwrKfATTzODx0a%2fqLS7O%2fnLKw9h2k%2fZEE%2bP9vsUezwzKam&TARGET=$SM$HTTP%3a%2f%2fqamfo2%2egefleet%2ecom%2f");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
package com.guru.framework.testing.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.guru.framework.testing.utils.WindowsCommandRunner;
import com.guru.framework.testing.utils.WindowsProxy;




/**
 * Base class intended as a wrapper for WebDriver and properties controlling the test, such as various think times
 * @author Isha Sharma
 * 
 */
@SuppressWarnings("deprecation")
public class BaseWebDriver {
	
	protected static WebDriver driver;		
	protected static String browser;
	protected static int waitTime;
	protected static int thinkTime;
	protected static Class<?> objectMapClass;
	protected static int implicitWaitTime;
	protected static String browserDrivers /*= "C:\\browserdrivers"*/;
	public static Class<?> localizationClass; // Added for implementing language localization
	
	public static final String WEBDRIVER_SERVER_IE = "IEDriverServer.exe";
	public static final String WEBDRIVER_SERVER_CHROME = "chromedriver.exe";
	public static final String WEBDRIVER_SERVER_FIREFOX = "geckodriver.exe";

	/**
	 * This a factory method executed before every suite that initializes a WebDriver instance for appropriate browsers
	 * 
	 * @param when				When to start browser: before suite or before test (default is suite)
	 * @param browser			Name of the browser that will be driven by the test (default is ie)
	 * @param waitTime			Explicit wait time in seconds to be used in custom waits(default is 30 sec)
	 * @param thinkTime			Think time in seconds between test steps (default is 0)
	 * @param implicitWait		Implicit wait time in seconds that will be used by web driver for synchronization (default is 5 sec)
	 * @param proxy				Proxy is one of the following: default, direct, autodetect, <proxy>:<port>, <pacFile> (default is default)
	 * @param libraryPath		Path to chrome driver (default is  C:\\browserdrivers)
	 */
	@BeforeSuite(alwaysRun=true)
	@Parameters ({"startBrowserBefore", "browser", "waitTime", "thinkTime", "implicitWait", "clearCacheLevel", "proxy", "noProxy", "libraryPath"})
	public void startBrowserBeforeSuite( @Optional("suite") String startBrowserBefore,
										 @Optional("ie") String browser, 
										 @Optional("30") int waitTime, 
										 @Optional("0") int thinkTime,
										 @Optional("5") int implicitWait,	
										 @Optional("0") int clearCacheLevel,
										 @Optional("default") String proxy,
										 @Optional("default") String noProxy,
										 @Optional("C:\\browserdrivers") String libraryPath) throws Exception {
		
		if(startBrowserBefore.equalsIgnoreCase("suite")) {	
			System.out.println("startBrowserBeforeSuite");
			init(libraryPath, clearCacheLevel, proxy, noProxy, browser, waitTime, thinkTime, implicitWait);
		}			
	}	
	
	@BeforeTest(alwaysRun=true)
	@Parameters ({"startBrowserBefore", "browser", "waitTime", "thinkTime", "implicitWait", "clearCacheLevel", "proxy", "noProxy", "libraryPath"})
	public void startBrowserBeforeTest(	@Optional("suite") String startBrowserBefore,
			 							@Optional("ie") String browser, 
			 							@Optional("30") int waitTime, 
			 							@Optional("0") int thinkTime,
			 							@Optional("5") int implicitWait,	
			 							@Optional("0") int clearCacheLevel,
			 							@Optional("default") String proxy,
			 							@Optional("default") String noProxy,
			 							@Optional("C:\\browserdrivers") String libraryPath) throws Exception {
		
		if(startBrowserBefore.equalsIgnoreCase("test")) {		
			init(libraryPath, clearCacheLevel, proxy, noProxy, browser, waitTime, thinkTime, implicitWait);
		}			
	}	
	
	protected static void init(String libraryPath, int clearCacheLevel, String proxy, String noProxy, String browser, int waitTime, int thinkTime, int implicitWait) throws Exception {
		BaseWebDriver.browserDrivers = libraryPath;
		if(clearCacheLevel > 0) clearCache(clearCacheLevel,browser);
		if(!"default".equals(proxy) || !"default".equals(noProxy)) setProxy(libraryPath, proxy, noProxy);
		init(browser, waitTime, thinkTime, implicitWait); 
		startBrowser();
	}
	
	
	/**
	 * Clears caching based upon level
	 * @param level
	 * 0 = no cleaning
	 * 1 = clear WinInetm ,chrome or Safari cache and temporary files
	 * 2 = flush DNS
	 * 4 = clear cert store
	 * 8 = clear WinInet, chrome or Safari cookies ONLY 
	 * @return an integer code indicating number of successful cleanup operations (0 - no successful cleanup)
	 */
	public static int clearCache(int level, String browser) throws Exception {
		int result = 0;
		if(level <= 0) return result;		
		for(Integer flag : computePowersOfTwoPartition(level)) {
			switch(flag){
				case 1: // clear WinInet and Safari cache and temporary files
					String exitCode;
					if (browser.toLowerCase().startsWith("safari"))
					{ 
						exitCode = clearSafariCookies();
					}
					else if (browser.toLowerCase().startsWith("chrome"))
					{
						exitCode = clearChromeCookies();
					}
					else
					{//Exit code
						exitCode = new WindowsCommandRunner("RunDll32.exe", "InetCpl.cpl,ClearMyTracksByProcess", "4351").execute();
					}
					result += (Integer.parseInt(exitCode) == 0) ? 1 : 0;
					break;
				case 2: // flush DNS
					String output2 = new WindowsCommandRunner("ipconfig", "/flushdns").execute();
					result += output2.contains("Successfully flushed the DNS Resolver Cache") ? 2 : 0;
					break;
				case 4: // clear certificate store
					String output4 = new WindowsCommandRunner("certutil.exe", "-urlcache", "*", "delete").execute();
					result += output4.contains("WinHttp Cache entries deleted") ? 4 : 0;
					break;	
				case 8: //Clear WinInet or Safari cookies ONLY
					String cookieCode;
					if (browser.toLowerCase().startsWith("safari"))
					{ 
						cookieCode = clearSafariCookies();
					}
					else if (browser.toLowerCase().startsWith("chrome"))
					{
						cookieCode = clearChromeCookies();
					}
					else
					{//Just assume IE, as its always been this way
						cookieCode = new WindowsCommandRunner("RunDll32.exe", "InetCpl.cpl,ClearMyTracksByProcess", "2").execute();
						System.out.println("Deleted IE cookie file, return code: " + cookieCode);
					}					
					result += (Integer.parseInt(cookieCode) == 0) ? 8 : 0;
					break;
			}			
		}
		return result;
	}
	
	private static String clearChromeCookies()
	{
		String appdata = System.getenv("userprofile");
		File file = new File(appdata + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cookies");
		if (file.exists())
		{
			if (file.delete())
			{
				System.out.println("Succesfully deleted: "+ file.getAbsolutePath());
				return "1";
			}
			else
			{
				System.out.println("FAILed to delete: "+ file.getAbsolutePath() );
				return "0";
			}
		}
		else
		{
			System.out.println("Chrome cookie file does not exist, no action taken: " + file.getAbsolutePath());
			return "1";
		}
	}
	
	
	private static String clearSafariCookies()
	{
		String appdata = System.getenv("appdata");
		File file = new File(appdata + "\\Apple Computer\\Safari\\Cookies\\Cookies.binarycookies");
		if (file.exists())
		{
			if (file.delete())
			{
				System.out.println("Succesfully deleted: "+ file.getAbsolutePath());
				return "1";
			}
			else
			{
				System.out.println("FAILed to delete: "+ file.getAbsolutePath() );
				return "0";
			}
		}
		else
		{
			System.out.println("Safari cookie file does not exist, no action taken: " + file.getAbsolutePath());
			return "1";
		}
	}
	
	protected static void setProxy(String libraryPath, String proxyValue, String noProxyValue) throws Exception {
		WindowsProxy proxy = null;
		try { 
			if(new File(proxyValue).isDirectory())
				proxy = new WindowsProxy(libraryPath);
		}
		catch(Exception e) {e.printStackTrace();}
		finally { 
			if(null == proxy) {
				proxy = new WindowsProxy(); 
			}
		}
		if(proxyValue.equalsIgnoreCase("direct")) {
			proxy.setDirect(true);
			proxy.setAutodetect(false);
			proxy.setProxy(false);
			proxy.setAutoProxyUrl(false);
		}
		else if(proxyValue.equalsIgnoreCase("autodetect")) {
			proxy.setDirect(false);
			proxy.setAutodetect(true);
			proxy.setProxy(false);
			if(noProxyValue != null && !noProxyValue.equalsIgnoreCase("default"))
				proxy.setProxyBypass(noProxyValue);
			proxy.setAutoProxyUrl(false);
		}		
		else if(proxyValue.trim().endsWith(".pac")){
			proxy.setDirect(false);
			proxy.setAutodetect(false);
			proxy.setProxy(false);
			proxy.setAutoProxyUrl(true);
			if(noProxyValue != null && !noProxyValue.equalsIgnoreCase("default"))
				proxy.setProxyBypass(noProxyValue);
			proxy.setProxyAutoconfigUrl(proxyValue.trim());
		}
		else if(proxyValue.contains(":")) {
			proxy.setDirect(false);
			proxy.setAutodetect(false);
			proxy.setProxy(true);
			proxy.setAutoProxyUrl(false);
			if(noProxyValue != null && !noProxyValue.equalsIgnoreCase("default"))
				proxy.setProxyBypass(noProxyValue);
			proxy.setProxyServer(proxyValue.trim());
		}
		proxy.apply();
	}
	
	protected static void init(String browser, int waitTime, int thinkTime, int implicitWait) {
		BaseWebDriver.browser = browser;
		BaseWebDriver.waitTime = waitTime;
		BaseWebDriver.thinkTime = thinkTime;
		BaseWebDriver.implicitWaitTime = implicitWait;
	}
	
	@SuppressWarnings("deprecation")
	protected static void startBrowser()  throws Exception {
		//default to IE
		System.setProperty("webdriver.ie.driver", browserDrivers + File.separator + WEBDRIVER_SERVER_IE);
				
		if(browser.equalsIgnoreCase("firefox")) { 
			System.setProperty("webdriver.firefox.marionette", browserDrivers + File.separator + WEBDRIVER_SERVER_FIREFOX);
			
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", browserDrivers + File.separator + WEBDRIVER_SERVER_CHROME); 
		    		
			ChromeDriverService service = ChromeDriverService.createDefaultService(); 
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--start-maximized"); 
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false); 
			options.setExperimentalOption("prefs", prefs);
			
			driver  = new ChromeDriver(service, options); 
		}
		
		else if(browser.equalsIgnoreCase("android")) {
			driver  = new IPhoneDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver  = new SafariDriver();
		}
		/*******************For future support************************/ 
		/*  else if(browser.equalsIgnoreCase("android")) {
			driver  = new AndroidDriver();
		}*/	
		else  {	
			//default to IE
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability("requireWindowFocus", true);
			//ieCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			
			//The multiple versions of IE is here for a sanity check, if the parameters specify a
			//specific version of IE then check that this is the one actually used.  If its not,
			//something has gone wrong.
			if(browser.equalsIgnoreCase("ie8")) {		
				checkIEVersion("8");
			}
			else if(browser.equalsIgnoreCase("ie9")) {		
				checkIEVersion("9");
			}
			else if(browser.equalsIgnoreCase("ie10")) {		
				checkIEVersion("10");
			}
			else if(browser.equalsIgnoreCase("ie11")) {		
				checkIEVersion("11");
			}
		}
		
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	private static void checkIEVersion(String version) throws Exception{
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName+" "+browserVersion);
		if (!browserVersion.equalsIgnoreCase(version)){
			throw new Exception("The browser version requested:" + version + " does not match the installed version: " + browserVersion);
		}
	}
	
	
	/**
	 * Sleeps for a specified time before each test method
	 * @throws Exception
	 */
	@BeforeMethod
	public void waitTime() throws Exception {
		Thread.sleep(1 * 1000 * thinkTime); // additional delay between test steps
	}	
	
	
	
	/**
	 * Closes a browser after test suite
	 * @throws Exception
	 */
	@AfterSuite(alwaysRun = true)
	@Parameters ({"when"})
	public void closeBrowserAfterSuite(@Optional("suite") String when) throws Exception {
		if(when.equalsIgnoreCase("suite")) {
			System.out.println("closeBrowserAfterSuite");
			closeBrowser();
		}		
	}	
	
	
	@AfterTest(alwaysRun = true)
	@Parameters ({"browserStart"})
	public void closeBroserAfterTest(@Optional("suite") String when) throws Exception {
		if(when.equalsIgnoreCase("test")) {
			closeBrowser();
		}		
	}	
	
	protected static void closeBrowser()  {
//		try {	WebDriverAction.closeActiveWindow(); } catch(Exception e) {e.printStackTrace();}
		try { 	
			driver.quit(); 	
			
		} catch(Exception e){e.printStackTrace();}
	}
	
	
	
	public static List<Integer> computePowersOfTwo(int number){
		List<Integer> partition = new ArrayList<Integer>();		
		for(int exponent=0;exponent <= number;exponent++ )
	    	  if((Math.pow(2, exponent))<=number)
		         partition.add((int)Math.pow(2, exponent));
		return partition;
	}
	
	public static List<Integer> computePowersOfTwoPartition(int number) {
        ArrayList<Integer> partition = new ArrayList<Integer>();
        int tmp;
        if (number == 0) {
            partition.add(new Integer(0));
            return partition;
        }
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            tmp = mask & number;
            if (tmp != 0) partition.add(new Integer(tmp));
        }
        return partition;
    }
	
	

}

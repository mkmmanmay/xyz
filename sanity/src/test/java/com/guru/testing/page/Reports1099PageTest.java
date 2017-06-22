package com.guru.testing.page;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.objectmap.Reports1099PageObjectMap;
import com.guru.testing.objectmap.TransactionsPageObjectMap;

public class Reports1099PageTest {
	
	@Test
	@Documentation(step = "Verify the 1099 reports", expected = "1099 Reports page should be loaded.")
	public static void verify1099ReportsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("1099 Report - Guru.com");
			BrowserWait.waitUntilText("Payments");
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_DROPDOWN_XPATH);						
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_SELECTED_YEAR_DROPDOWN_XPATH);
			
			try {
				try {
					BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_NO_REPORT_TEXT_XPATH,2);
					BrowserWait.waitUntilText("No 1099 report is currently available");
					ScriptLogger.debug("No 1099 report is currently available");
				} catch (Exception e) {
					BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_NO_REPORT_TEXT_XPATH,2);
					BrowserWait.waitUntilText("No 1099 report is currently available. Make sure you’ve ");
					BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_NO_REPORT_NOT_OPTED_NAVIGATION_PLINK);
					ScriptLogger.debug("Not opted for 1099 report so no report is currently available");
				}
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRINT_BUTTON_XPATH);				
				BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_COMMON_DATA_TABLE_XPATH);
				ScriptLogger.debug("1099 report is currently present");
				
			}
			
			
			
		} catch (Exception e) {
			throw new ApplicationException(e,"Unable to find elements on Transaction page");
		}
	}
	
	@Test
	@Documentation(step = "Verify Default year", expected = "Default year should be the previous")
	public static void verifyDefaultYearTest() throws Exception {		
		ScriptLogger.info();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		int year=cal.get(Calendar.YEAR);
		String priorYear=Integer.toString(year-1);	
		
		if(!(BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_SELECTED_YEAR_DROPDOWN_XPATH).getText().contains(priorYear))){
			throw new ApplicationException("Default year selected is not prior year");
		}
		
			
	}
	
	@Test
	@Documentation(step = "Close Prior Year Dropdown", expected = "Prior year dropdown should be closed")
	public static void closePriorYearDropDownTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_OPEN_DROPDOWN_XPATH);
		Thread.sleep(3000);
		} catch (Exception e) {
			throw new ScriptException(e);
		}	
		
	}	

	@Test
	@Documentation(step = "Close Download Dropdown", expected = "Download dropdown should be closed")
	public static void closeDownloadDropDownTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
			Thread.sleep(3000);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
					
	}	
	
	@Test
	@Documentation(step = "Verify prior year dropdown", expected = "Verify dropdown UI and all prior years till 2008 are present")
	public static void verifyPriorYearsInDropDownTest() throws Exception {		
		ScriptLogger.info();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		int year=cal.get(Calendar.YEAR);
		
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_OPEN_DROPDOWN_XPATH);	
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		List <WebElement> element = BrowserAction.getElements(Reports1099PageObjectMap.REPORTS_1099_PAGE_ALL_YEARS_IN_DROPDOWN_XPATH);
		if(element.size()==year-2008){
			for (WebElement webElement : element) {
				if(!((year-1)>=Integer.parseInt(webElement.getText()))){
					throw new ApplicationException("Year present "+webElement.getText()+" is incorrect");
					
				}
			}
		}
		else{
			throw new ApplicationException("All years from 2008 are not loaded");
		}
			
	}
	
	
	@Test
	@Parameters("year")
	@Documentation(step = "Select year in prior year dropdown", expected = "Year parameter should be selected")
	public static void applyPriorYearFilterTest(String priorYear) throws Exception {
		ScriptLogger.info();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		int year=cal.get(Calendar.YEAR);
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRIOR_YEAR_OPEN_DROPDOWN_XPATH);	
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		List <WebElement> element = BrowserAction.getElements(Reports1099PageObjectMap.REPORTS_1099_PAGE_ALL_YEARS_IN_DROPDOWN_XPATH);
		if(element.size()==year-2008){
			for (WebElement webElement : element) {
				if(priorYear.equalsIgnoreCase(webElement.getText())){
					webElement.click();
					break;
				}
			}
		}
		else{
			throw new ApplicationException("All years from 2008 are not loaded");
		}
	}
	
	@Test
	@Parameters("year")
	@Documentation(step = "Verify Service Requested-US Guru by year", expected = "Service Requested - US Guru should be verified")
	public static void verifyServiceRequestedForUSGuruTest(String yearSelected) throws Exception {
		
		ScriptLogger.info();
		String reportYear=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_SELECTED_YEAR_DROPDOWN_XPATH).getText();
		if(reportYear.contains(yearSelected)){
			try {
				BrowserWait.waitUntilText("1099 Service Requested – U.S. Guru");			
				BrowserWait.waitUntilText("If appropriate, a 1099 tax form will be issued to these gurus.");
				BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_US_GURU_DATA_TABLE_XPATH);
				verifyTableHeadersTest("US");
			} catch (Exception e) {
				throw new ApplicationException("Service Requested by US Guru elements are not loaded");
			}
			
		}
		else{
			throw new ApplicationException("Report Year is not matching year expected");
		}				
		
	}
	
	@Test
	@Parameters("year")
	@Documentation(step = "Verify Service Requested- Non US Guru", expected = "Service Requested - Non US Guru should be verified")
	public static void verifyServiceRequestedForNonUSGuruTest(String yearSelected) throws Exception {
		
		ScriptLogger.info();
		String reportYear=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_SELECTED_YEAR_DROPDOWN_XPATH).getText();
		if(reportYear.contains(yearSelected)){
			try{
			BrowserWait.waitUntilText("1099 Service Requested – Non U.S. Guru");			
			BrowserWait.waitUntilText("1099 tax form will not be issued to these gurus, as they do not live in the US.");
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_NON_US_GURU_DATA_TABLE_XPATH);
			verifyTableHeadersTest("NON US");
			}catch (Exception e) {
				throw new ApplicationException("Service Requested by Non US Guru elements are not loaded");
			}
			
		}
		else{
			throw new ApplicationException("Report Year is not matching year expected");
		}				
		
	}
	
	@Test
	@Parameters("year")
	@Documentation(step = "Verify Service Not Requested", expected = "Service Not Requested should be verified")
	public static void verifyServiceNotRequestedTest(String yearSelected) throws Exception {
		
		ScriptLogger.info();
		String reportYear=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_NOT_REQUESTED_DATA_TABLE_XPATH).getText();
		if(reportYear.contains(yearSelected)){
			try{
			BrowserWait.waitUntilText("1099 Service Not Requested");			
			BrowserWait.waitUntilText("A 1099 tax form will not be issued to these gurus, as you did not request our 1099 service for the following invoices.");
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_NON_US_GURU_DATA_TABLE_XPATH);
			verifyTableHeadersTest("NOT REQUESTED");
			}catch (Exception e) {
				throw new ApplicationException("Service NOT Requested elements not loaded");
			}
			
		}
		else{
			throw new ApplicationException("Report Year is not matching year expected");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify Table header for Service type provided", expected = "Table headers should be verified")
	public static void verifyTableHeadersTest(String tableType) throws Exception {
		ScriptLogger.info();
		List <WebElement> thElements=new ArrayList<WebElement>();
		if(tableType.equals("US")){
			thElements=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_US_GURU_DATA_TABLE_XPATH).findElement(By.tagName("table")).findElements(By.tagName("th"));
		}
		else if(tableType.equals("NON US")){
			thElements=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_NON_US_GURU_DATA_TABLE_XPATH).findElement(By.tagName("table")).findElements(By.tagName("th"));
		}
		else if(tableType.equals("NOT REQUESTED")){
			thElements=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_NOT_REQUESTED_DATA_TABLE_XPATH).findElement(By.tagName("table")).findElements(By.tagName("th"));
		}
		
		if(!"Guru".equalsIgnoreCase(thElements.get(0).getText())&&
				!"Date Paid".equalsIgnoreCase(thElements.get(1).getText())&&
				!"Description".equalsIgnoreCase(thElements.get(2).getText())&&
				!"Amounts Paid".equalsIgnoreCase(thElements.get(3).getText())&&
				!"Total".equalsIgnoreCase(thElements.get(4).getText())){
							throw new ApplicationException("Table headers not loaded");
						}	
	
	}	
	
	@Test
	@Parameters("noDataText")
	@Documentation(step = "Verify page message when no data is present", expected = "Text on page shouold be 'No 1099 report is currently available.'")
	public static void verifyWhenNoDataPresentTest(String noDataText) throws Exception {
		ScriptLogger.info();
		
			if(!noDataText.equals(BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_NO_REPORT_TEXT_XPATH).getText())){
				throw new ApplicationException("Application Issue: ");
			}
	
	}
	
	@Test
	@Parameters("fileType")
	@Documentation(step = "Download report by PDF or CSV option", expected = "Download parameter provided should be clicked")
	public static void downloadReportByTest(String fileType) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
			
			
		
			if(fileType.equalsIgnoreCase("PDF")){
				BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_PDF_OPTION_XPATH);
			}
			if(fileType.equalsIgnoreCase("CSV")){
				BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_CSV_OPTION_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH,10);
			}
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: ");
		}
		
	}
	
	@Test
	@Documentation(step = "Click on Print button", expected = "Print button should be clicked and print window should open")
	public static void clickPrintButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRINT_BUTTON_XPATH);		
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: ");
		}
		
	}

	@Test
	@Documentation(step = "Verify print window and click escape", expected = "Print window should be closed")
	public static void verifyPrintWindowTest() throws Exception {
		ScriptLogger.info();
		TransactionsPageTest.verifyPrintWindowTest();

	}
	
	@Test
	@Documentation(step = "Verrify Print button is present", expected = "Print button should be present when data is there")
	public static void verifyPrintButtonIsPresentTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_PRINT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Print is not present");
		}
	}
	
	@Test
	@Documentation(step = "Verify download options", expected = "Verify PDF and CSVoption in download drop down")
	public static void verifyDownloadOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
		WebElement element=BrowserAction.getElement(Reports1099PageObjectMap.REPORTS_1099_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
		List<WebElement> list=element.findElement(By.tagName("ul")).findElements(By.tagName("li"));
			
		if(!"Download PDF".equals(list.get(0).getText().trim())){
			/*TODO This will be added later when CSV comes in if(!"DownLoad CSV".equals(list.get(1).getText().trim())){ commented till the feature is implemented*/
					
					throw new ApplicationException("Download Dropdown is incorrectly lodaed");
					
			/*}*/
		}
	}
	
	@Test
	@Documentation(step = "Scroll Window to Non US Guru", expected = "Scrolling should be done")
	public static void scrollWindowForNonUSGuruTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.scrollWindow(0,9000);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Scroll Window to Not requested", expected = "Scrolling should be done")
	public static void scrollWindowForNotRequestedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.scrollWindow(0,6100);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}	

}

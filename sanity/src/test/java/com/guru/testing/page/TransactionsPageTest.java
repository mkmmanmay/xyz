package com.guru.testing.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
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
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.TransactionsPageObjectMap;

public class TransactionsPageTest {
			
	
	
	@Test
	@Documentation(step = "Verify the Transactions Page for Freelancer's login.", expected = "Transactions page should be loaded.")
	public static void verifyTransactionsPageTest() throws Exception {
		
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Transaction Report - Guru.com");
			BrowserWait.waitUntilText("Payments");
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);				
			
			try{
				try {
					verifyTableHeadersByTest("Guru");
					BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_GURU_APPLIED_XPATH);
				} catch (Exception e) {
					verifyTableHeadersByTest("Employer");
					BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_GURU_APPLIED_XPATH);
				}
				
			}catch (Exception e) {
				verifyWhenNoDataPresentTest("You have no transaction in this date range.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Unable to find elements on Transaction page");
		}
	}
	
	
	@Test
	@Documentation(step = "Verify Table headers by passed report name ", expected = "Table headers should be verified by guru or payment menthod or job id")
	public static void verifyTableHeadersByTest(String reportNameHeader) throws Exception {
		ScriptLogger.info();
		List <WebElement> thElements;
		try {
		thElements=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH).findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		} catch (Exception e) {
			thElements=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FL_RESULTS_TABLE_XPATH).findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		}
		if(reportNameHeader.equalsIgnoreCase("Employer")){
			if(		!"Date Paid".equalsIgnoreCase(thElements.get(1).getText())&&
					!"Invoice ID".equalsIgnoreCase(thElements.get(2).getText())&&
					!"Invoice Amount".equalsIgnoreCase(thElements.get(3).getText())&&
					!"Job Fee".equalsIgnoreCase(thElements.get(4).getText()) &&
					!"Net Total".equalsIgnoreCase(thElements.get(4).getText())){
			
								throw new ApplicationException("Table headers for "+reportNameHeader+" not loaded");
			
			
		}
		}
		
		else{
			if(!reportNameHeader.equalsIgnoreCase(thElements.get(0).getText())&&
		
				!"Date Paid".equalsIgnoreCase(thElements.get(1).getText())&&
				!"Description".equalsIgnoreCase(thElements.get(2).getText())&&
				!"Amounts Paid".equalsIgnoreCase(thElements.get(3).getText())&&
				!"Total".equalsIgnoreCase(thElements.get(4).getText())){
							throw new ApplicationException("Table headers for "+reportNameHeader+" not loaded");
						}
		}
	}
	
	
	
	@Test
	@Documentation(step = "Verify Reporting By Options", expected = "Reporting Dropdown should have guru, payment menthod & job id")
	public static void verifyReportingByOptionsTest() throws Exception {
		
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		WebElement element = BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
		List<WebElement> list = element.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		try {
			if (!"Guru".equalsIgnoreCase(list.get(0).getText().trim())&&!"Payment Method".equals(list.get(1).getText().trim()) &&!"Job".equals(list.get(2).getText().trim())) {
						throw new ApplicationException("Reporting Dropdown is incorrectly lodaed");
					}
			
		} catch (Exception e) {
			if (!"Employer".equalsIgnoreCase(list.get(1).getText().trim()) && !"Payment Method".equals(list.get(2).getText().trim())){
						throw new ApplicationException("Reporting Dropdown is incorrectly lodaed");
			}
		}			
	}

	
	@Test
	@Documentation(step = "Verify download options", expected = "Verify PDF and CSV option in download drop down")
	public static void verifyDownloadOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
		WebElement element=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
		List<WebElement> list=element.findElement(By.tagName("ul")).findElements(By.tagName("li"));
			
		if(!"Download PDF".equals(list.get(0).getText().trim())&&"Download CSV".equals(list.get(1).getText().trim())){
			throw new ApplicationException("Download Dropdown having incorrect dropdown options");
		}
	}
	
	
	@Test
	@Documentation(step = "Click Date Range option and Verify Calendar is loaded ", 
	expected = "Verify Calendar should be open, From: & To: text should be present, Input box for From and To should be present and filter button should be present")
	public static void verifyCalendarTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);
			BrowserWait.waitUntilText("From:","To:");
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_FROM_INPUT_BOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_TO_INPUT_BOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_FILTER_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
		
	}
	
	@Test
	@Documentation(step = "Verify Default Date Range", expected = "Verify Default date range is FROM 1st of the month TO today's date")
	public static void verifyDefaultDateRangeTest() throws Exception {
		ScriptLogger.info();
		String range = BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_TEXT_XPATH)
				.getText();
		String fromDate = StringUtils.stringBetween(range, "", " to", 1);
		String fromMonth = StringUtils.stringBetween(fromDate, "", " ", 1);
		String fromDay = StringUtils.stringBetween(fromDate, " ", "", 1);
		String toDate = StringUtils.stringBetween(range, "to ", "", 1);
		String toMonth = StringUtils.stringBetween(toDate, "", " ", 1);
		String toDay = StringUtils.stringBetween(toDate, " ", "", 1);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		int month = calendar.get(Calendar.MONTH);
		int todayDay = calendar.get(Calendar.DATE);
		List<String> monthList = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec");
		if (!(monthList.indexOf(toMonth) == month && todayDay == Integer.parseInt(toDay))) {
			throw new ApplicationException("Default To date is not set to today's date");

		}

		if (!(monthList.indexOf(fromMonth) == month && Integer.parseInt(fromDay) == 1)) {
			throw new ApplicationException("Default From date is not set to 1st Date of the month");

		}

	}
	
	@Test
	@Documentation(step = "Reload page and verify date range", expected = "Page should be reloaded")
	public static void reloadAndVerifyDateRangeTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.refresh();
			//This has been changed earlier it was having the default date range verifyDefaultDateRangeTest();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
	
	
	@Test
	@Parameters("validDataDateRange")
	@Documentation(step = "Apply date range for dates having data for transactions", expected = "To and From dates having valid data should be applied")
	public static void applyDateRangeValidDataTest(String dateData) throws Exception {
		ScriptLogger.info();
		applyDateRange(dateData);			
	}
	
	@Test
	@Parameters("validDataDateRange")
	@Documentation(step = "Apply date range for dates having data for transactions", expected = "To and From dates having valid data should be applied")
	public static void applyDateRangeValidDataInFutureTest(String dateData) throws Exception {
		ScriptLogger.info();
		
		BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
		BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
		
		String fromDate=(StringUtils.splitDataBySymbol(dateData, "|"))[0];
		String toDate=(StringUtils.splitDataBySymbol(dateData, "|"))[1];
		if(toDate!=null){
			setDate("To",toDate);	
		}
		
		if(fromDate!=null)
		{
			setDate("From",fromDate);
			
		}
	}
	
	@Test
	@Documentation(step = "Verify Data is loaded", expected = "Transactions table should be loaded having data ")
	public static void verifyDataIsLoadedTest() throws Exception {
		ScriptLogger.info();
		
		try {
			try {
				BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH);
		} catch (Exception e) {
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FL_RESULTS_TABLE_XPATH);
		}
		}
		 catch (Exception e) {
			throw new ApplicationException("Transactions data Table is not loaded");
		}
	}
	
	@Test
	@Documentation(step = "Click to close calendar", expected = "Calendar should be closed")
	public static void closeCalendarTest() throws Exception {		
		ScriptLogger.info();
		try {
		BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OPEN_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}			
	}
	
	@Test
	@Documentation(step = "Click to close Download  Dropdown", expected = "Download should be closed")
	public static void closeDownloadOptionTest() throws Exception {		
		ScriptLogger.info();
		try {
		BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
			
	}
	
	@Test
	@Documentation(step = "Apply date range for dates having NO data for transactions", expected = "To and From dates having NO data should be applied")
	@Parameters("noDataDateRange")
	public static void applyDateRangeNoDataTest(String dateData) throws Exception {
		ScriptLogger.info();
		applyDateRange(dateData);	
	}

	@Test
	@Parameters("noDataText")
	@Documentation(step = "Verify NO Data is loaded and error message is displayed", 
	expected = "Transactions table should NOT be loaded and message should be shown as You have no transaction in this date range. ")
	public static void verifyWhenNoDataPresentTest(String noDataText) throws Exception {
		ScriptLogger.info();
		BrowserAction.switchToDefaultContent();
			if(!noDataText.equals(BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_NO_DATA_TRANSACTION_TEXT_XPATH).getText())){
				throw new ApplicationException("Message '"+noDataText+"' is not shown on applying dates");
			}
	
	}
	
	@Test
	@Parameters("dateRangeMoreThanAYear")
	@Documentation(step = "Apply date range for more than 12 months", expected = "To and From dates having 12 months range should be applied")
	public static void applyDateRangeMoreThanAYearTest(String dateData) throws Exception {
		ScriptLogger.info();
		applyDateRange(dateData);	
	}
	
	@Test
	@Parameters("rangeMoreThanYearText")
	@Documentation(step = "Verify NO Data is loaded and error message is displayed", 
	expected = "Transactions table should NOT be loaded and message should be shown as Please select a date range that does not exceed 12 months.")
	public static void verifyDateRangeMoreThanAYearTest(String rangeMoreThanYearText) throws Exception {
		ScriptLogger.info();
	
			if(!rangeMoreThanYearText.equals(BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_NO_DATA_TRANSACTION_TEXT_XPATH).getText())){
				throw new ApplicationException("Message '"+rangeMoreThanYearText+"' is not shown on applying dates");
			}
		
	}
	
	@Test
	@Documentation(step = "Apply date range for more than 12 months", expected = "To and From dates having 12 months range should be applied")
	public static void applyAndVerifyFutureToDateIsDisabledTest() throws Exception {
		ScriptLogger.info();
		int daysToAdd=2;		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		calendar.add(Calendar.DATE, daysToAdd);	
		int month=calendar.get(Calendar.MONTH);
		month++;
		String toDate=calendar.get(Calendar.DATE)+"-"+month+"-"+calendar.get(Calendar.YEAR);
		ScriptLogger.debug(toDate);
		BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
		BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
		verifyDateIsDisabled("To",toDate);			
			
		
	}

	@Test
	@Documentation(step = "Apply 'From' date after 'To'", expected = " Verify date is disabled")
	@Parameters("fromDateAfterToDate")
	public static void applyAndVerifyFromDateAfterToDateIsDisabledTest(String dateData) throws Exception {
		setDate("To", (StringUtils.splitDataBySymbol(dateData, "|"))[1]);
		verifyDateIsDisabled("From",(StringUtils.splitDataBySymbol(dateData, "|"))[0]);	
	}
	
	
	@Test
	@Documentation(step = "Verify Report by Guru with data", expected = "Report by guru should be verified")
	public static void verifyReportByGuruTest() throws Exception {
		ScriptLogger.info();
		try {
			//verifyTransactionsPageTest();			
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);		
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH);
			verifyTableHeadersByTest("Guru");
			BrowserWait.waitUntilAtLeastOneElementPresent(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_INVOICE_ID_PLINK);
		} catch (Exception e) {
			throw new ApplicationException("Report By guru with data is expected but not loaded");
		}
	}
	
	@Test
	@Documentation(step = "Verify Report by Employer with data", expected = "Report by guru should be verified")
	public static void verifyReportByEmployerTest() throws Exception {
		ScriptLogger.info();
		try {
			//verifyTransactionsPageTest();			
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);		
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FL_RESULTS_TABLE_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH);
			verifyTableHeadersByTest("Employer");
			BrowserWait.waitUntilAtLeastOneElementPresent(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FL_INVOIDCE_ID_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Report By Employer with data is expected but not loaded");
		}
	}
	

	@Test
	@Documentation(step = "Apply Reporting by dropdown to JOB", expected = "JOb from the Reporting by filter should be selected")
	public static void applyReportByJobTest() throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_JOB_OPTION_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Report By Job filter not applied");
		}
	}
	@Test
	@Documentation(step = "Verify Reporting by Job with data", expected = "Report by Job should be verified")
	public static void verifyReportByJobTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);				
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_JOB_APPLIED_XPATH);			
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH);
			verifyTableHeadersByTest("Job");
			BrowserWait.waitUntilAtLeastOneElementPresent(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_INVOICE_ID_PLINK);
			try {
				BrowserWait.waitUntilAtLeastOneElementPresent(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FEATURED_JOB_RECIEPT_PLINK);	
			} catch (Exception e) {
				ScriptLogger.debug("Threre is not even 1 featured job for him");
			}
					
			
			
		} catch (Exception e) {
			throw new ApplicationException("Report By Job not verified");
		}
	}
	
	@Test
	@Documentation(step = "Apply Reporting by dropdown to Payment Method", expected = "PaymentMethodfrom the Reporting by filter should be selected")
	public static void applyReportByPaymentMethodTest() throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_PAYMENT_METHOD_OPTION_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Report By Payment Method filter not applied");
		}
	}
	
	@Test
	@Documentation(step = "Apply Reporting by dropdown to Payment Method", expected = "PaymentMethodfrom the Reporting by filter should be selected")
	public static void applyReportByEmployerTest() throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_EMPLOYER_OPTION_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Report By Employer sort not applied");
		}
	}
	@Test
	@Documentation(step = "Verify Reporting by Payment Method with data", expected = "Report by Payment Method  should be verified")
	public static void verifyReportByPaymentMethodTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH);				
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_PAYMENT_METHOD_APPLIED_XPATH);			
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH,10);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH,10);
			try {
					BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH,5);
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_FL_RESULTS_TABLE_XPATH,5);
			}
			verifyTableHeadersByTest("Pay Method");				
			
		} catch (Exception e) {
			throw new ApplicationException("Report By Payment Method with data not verified");
		}
	}
	
	@Test
	@Documentation(step = "Verify Sorting by ID", expected = "Data should be sorted by ID in ascending order")
	public static void verifySortByIDTest() throws Exception {
		ScriptLogger.info();
		
		List<String> idValue=new ArrayList<String>();
		List<WebElement> elements;
		try {
			
			elements= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_GURU_OR_JOB_ID_XPATH);
			if(elements.size()>1)
			{
			for (WebElement webElement : elements) {
				idValue.add(webElement.getText());
			}
			}
		}catch (Exception e) {
			throw new ApplicationException("ID is not present");
		}	
		if(idValue.size()>1)
		{
		if(Integer.parseInt(idValue.get(0))>Integer.parseInt(idValue.get(1))||Integer.parseInt(idValue.get(1))>Integer.parseInt(idValue.get(2))){
				throw new ApplicationException("Data is not sorted by ID");
			}
		}
		
	}
	
	
	@Test
	@Documentation(step = "Verify Sorting by Payment Method", expected = "Data should be sorted by Payment in ascending order")
	public static void verifySortByPaymentMethodTest() throws Exception {
		ScriptLogger.info();		
		List<String> idValue=new ArrayList<String>();
		Boolean isThereData=true;
		try {
			BrowserWait.waitUntilText("You have no transaction in this date range.");
			isThereData=false;
		} catch (Exception e) {
			ScriptLogger.debug("Data is present");
			isThereData=true;
		}
		if(isThereData){
			List<WebElement> elements= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_REPORTING_BY_PAYMENT_METHOD_TYPE_TEXT_XPATH);
			
			if(elements.size()>1){
			for (WebElement webElement : elements) {
				idValue.add(webElement.getText());
			}
			List<String> tmp=new ArrayList<String>(idValue);

			Collections.sort(tmp);
			if(!tmp.equals(idValue)){
				throw new ApplicationException("The list is not sorted by Payment method A-Z");
			}
			}
			else if(elements.size()==1){
				ScriptLogger.debug("Try changing dates to apply this method");
			}
		}
		
		else{
			ScriptLogger.debug("There is only no transaction in this date range. Try changing dates to apply this method");
		}
		
	
	
	}
	
	@Test
	@Parameters("fileType")
	@Documentation(step = "Download report by PDF or CSV option", expected = "Download parameter provided should be clicked")
	public static void downloadReportByTest(String fileType) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH);
			if(fileType.equalsIgnoreCase("PDF")){
				BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_PDF_OPTION_XPATH);
			}
			if(fileType.equalsIgnoreCase("CSV")){
				BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_CSV_OPTION_XPATH);
				BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_CSV_OPTION_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH,10);
			}
		} catch (Exception e) {
			throw new ApplicationException("Unable to download by option provided ");
		}
	}
	
	@Test
	@Parameters({"filePath","fileType"})
	@Documentation(step = "Download report by PDF or CSV option", expected = "Download parameter provided should be clicked")
	public static void verifyFileDownloadByTest(String fileType) throws Exception {
	
		/*File file
		if(fileType.contains(pdf)){
			file contains .pdf && Transaction Report
				
			
		}
		
		if(fileType.contains(csv)){
			file contains .csv
				
			
		}*/
	}
	
	@Test
	@Documentation(step = "Click on Print button", expected = "Print button should be clicked and print window should open")
	public static void clickPrintButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH);		
		} catch (Exception e) {
			throw new ApplicationException("Print button is not present");
		}
	}
	@Test
	@Documentation(step = "Verify print window and click escape", expected = "Print window should be closed")
	public static void verifyPrintWindowTest() throws Exception {
		ScriptLogger.info();
		try {
			try {
                Robot r = new Robot();
                r.delay(5000);
                r.keyPress(KeyEvent.VK_ESCAPE);
                r.keyRelease(KeyEvent.VK_ESCAPE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
					
		} catch (Exception e) {
			throw new ApplicationException("Print window is not closed");
		}
	}
	
	
	@Test
	@Documentation(step = "Click Filter button in Calendar", expected = "Filter in calendar should be clicked")
	public static void clickFilterTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_FILTER_BUTTON_XPATH);
					
		} catch (Exception e) {
			throw new ApplicationException("Filter in calendar is not clicked");
		}
	}
	
	@Test
	@Documentation(step = "Click Filter button in Calendar", expected = "Filter in calendar should be clicked")
	public static void clickFilter1Test() throws Exception {
		ScriptLogger.info();
		clickFilterTest();
	}
	
	
	@Test
	@Documentation(step = "Click Filter button in Calendar", expected = "Filter in calendar should be clicked")
	public static void clickFilter2Test() throws Exception {
		ScriptLogger.info();
		clickFilterTest();
	}
	
	
	@Test
	@Documentation(step = "Click Filter button in Calendar", expected = "Filter in calendar should be clicked")
	public static void clickFilter3Test() throws Exception {
		ScriptLogger.info();
		clickFilterTest();
	}
	
	
	/************************************All private Methods****************************************/
	
	private static void applyDateRange(String dateData) throws Exception {
		BrowserAction.click(TransactionsPageObjectMap.TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH);	
		BrowserWait.waitUntilElementIsDisplayed(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH);
		
		String fromDate=(StringUtils.splitDataBySymbol(dateData, "|"))[0];
		String toDate=(StringUtils.splitDataBySymbol(dateData, "|"))[1];
		if(fromDate!=null)
		{
			setDate("From",fromDate);
			
		}
		if(toDate!=null){
			setDate("To",toDate);	
		}
			
	}


	
	private static void setDate(String dateType,String dateExp) throws Exception {
		WebElement element;
		List< WebElement> elements=new ArrayList<WebElement>();
		try {
			int year=0;
			int month=00;
			int day=00;
			
			if(dateExp!=null){
				
				String[] date = dateExp.split("-");
				day = Integer.parseInt(date[0]);
				month = Integer.parseInt(date[1]);
				year = Integer.parseInt(date[2]);			
			
				if(dateType.equalsIgnoreCase("From")){
					element=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_FROM_INPUT_BOX_XPATH);
					element.click();
					WebElement headRow= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_TO_FROM_WIDGET_TABLE_XPATH).get(0).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
					elements=headRow.findElements(By.tagName("th"));
				}
				else if(dateType.equalsIgnoreCase("To")){
					element=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_TO_INPUT_BOX_XPATH);
					element.click();
					WebElement headRow= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_TO_FROM_WIDGET_TABLE_XPATH).get(1).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
					elements=headRow.findElements(By.tagName("th"));
					
				}
						
				 List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
				 boolean dateNotFound=true;
				 
				while(dateNotFound)
				  { 
					String[] webElement=elements.get(1).getText().split(" ");
				   
					String monthWebElement =webElement[0];
					
					String yearWebElement =webElement[1];
					  
				   
				   if(monthList.indexOf(monthWebElement)+1== month && (year == Integer.parseInt(yearWebElement)))
				   {
					   //Click on the day when month and year are matching
				    selectDay(dateType,day);
				    dateNotFound = false;
				   }
				  
				   else if(monthList.indexOf(monthWebElement)+1 < month && (year == Integer.parseInt(yearWebElement)) || year > Integer.parseInt(yearWebElement))
				   {
				
				    elements.get(2).findElement(By.tagName("button")).click();
				    
				   }
				 
				   else if(monthList.indexOf(monthWebElement)+1 > month && (year == Integer.parseInt(yearWebElement)) || year < Integer.parseInt(yearWebElement))
				   {
				   
					   elements.get(0).findElement(By.tagName("button")).click();
				   }
				  }			
				}
				
				
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}
		
	
		
	}


	private static void selectDay(String dateType, int day) throws Exception {
		int i=0;
		int j=0;
		List <WebElement> datePicker = BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_DAY_CELL_XPATH);
		if(dateType.equalsIgnoreCase("From")){
			i=0;
			j=41;
		}
		
		else if(dateType.equalsIgnoreCase("To")){
			i=42;
			j=84;
		}
		for (int k = i; k <= j; k++) {
			 
				 
				 if(datePicker.get(k).getText()!=null){
				   if (Integer.parseInt(datePicker.get(k).getText())==(day)){
					   datePicker.get(k).click();
				    break;
				   }
				  }
		 
		}
		
		
		
	}
	
	
	private static void verifyDateIsDisabled(String dateType, String dateExp ) throws Exception {
		WebElement element;
		List< WebElement> elements=new ArrayList<WebElement>();		
		try {
			int year=0;
			int month=00;
			int day=00;
			
			if(dateExp!=null){
				
				String[] date = dateExp.split("-");
				day = Integer.parseInt(date[0]);
				month = Integer.parseInt(date[1]);
				year = Integer.parseInt(date[2]);			
			
				if(dateType.equalsIgnoreCase("From")){
					element=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_FROM_INPUT_BOX_XPATH);
					element.click();
					WebElement headRow= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_TO_FROM_WIDGET_TABLE_XPATH).get(0).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
					elements=headRow.findElements(By.tagName("th"));
				}
				else if(dateType.equalsIgnoreCase("To")){
					element=BrowserAction.getElement(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_TO_INPUT_BOX_XPATH);
					element.click();
					WebElement headRow= BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_TO_FROM_WIDGET_TABLE_XPATH).get(1).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
					elements=headRow.findElements(By.tagName("th"));
					
				}
						
				 List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
				 boolean dateNotFound=true;
				 
				while(dateNotFound)
				  { 
					String[] webElement=elements.get(1).getText().split(" ");
					String monthWebElement =webElement[0];				
					String yearWebElement =webElement[1];				
				   if(monthList.indexOf(monthWebElement)+1== month && (year == Integer.parseInt(yearWebElement)))
				   {
				    // verify Day Is Disabled
					  verifyDayIsDisabled(dateType,day);
				    dateNotFound = false;
				   }
				   else if(monthList.indexOf(monthWebElement)+1 < month && (year == Integer.parseInt(yearWebElement)) || year > Integer.parseInt(yearWebElement))
				   {
				    elements.get(2).findElement(By.tagName("button")).click();
				    
				   }
				
				   else if(monthList.indexOf(monthWebElement)+1 > month && (year == Integer.parseInt(yearWebElement)) || year < Integer.parseInt(yearWebElement))
				   {
				    
					   elements.get(0).findElement(By.tagName("button")).click();
				   }
				  }			
				}
				
				
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}
	}

	
	private static void verifyDayIsDisabled(String dateType, int day) throws Exception {
		int i=0;
		int j=0;
		List <WebElement> datePicker = BrowserAction.getElements(TransactionsPageObjectMap.TRANSACTIONS_PAGE_CALENDAR_WIDGET_DAY_CELL_XPATH);
		if(dateType.equalsIgnoreCase("From")){
			i=0;
			j=41;
		}
		
		else if(dateType.equalsIgnoreCase("To")){
			i=42;
			j=84;
		}
		for (int k = i; k <= j; k++) {
			 
				 
				 if(datePicker.get(k).getText()!=null){
				   if (Integer.parseInt(datePicker.get(k).getText())==(day)){
					   if(!(datePicker.get(k).findElement(By.xpath("//button[@disabled='disabled']")) != null)){
						   throw new ApplicationException("Day is not disabled");
					   }
				    break;
				   }
				  }
		 
		}
		
		
		
	}
	
		
}

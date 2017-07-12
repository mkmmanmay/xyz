package com.guru.testing.page;

import java.util.List;

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
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.PostAJobPageObjectMap;
import com.guru.testing.objectmap.QuotesPageObjectMap;

public class QuotesPageTest {
	
	/****************************This is Quotes Tab page on the Freelancer side****************************************/
	
	public static String RANDOM_MESSAGE;
	
	@Test
	@Documentation(step = "Verify if 'Quotes' page loaded.", expected = "'Quotes' page for the user should load.")
	public static void verifyFLQuotesPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Manage Quotes - Guru.com");
			BrowserWait.waitUntilText("Quotes","Sort by:", " All Quotes In Negotiation");
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_QUOTES_IN_NEGOTIATON_ID);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_ALL_QUOTES_ID);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_ARCHIVED_QUOTES_TAB_ID);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_MY_QUOTE_TEMPLATES_LEFT_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_MANAGE_BIDS_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_SEARCH_TEXTBOX_ID);			
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_SORT_BY_FILTER_ID);
						
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	
	@Test
	@Documentation(step = "Click All quotes tab on Quotes page", expected = "All quoptes should be clicked")
	public static void clickAllQuotesTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(QuotesPageObjectMap.QUOTES_PAGE_ALL_QUOTES_ID,WebDriverAction.ACTION_STYLE_WEBDRIVER,WebDriverAction.ACTION_STYLE_JAVASCRIPT);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify Random job title is present", expected = "Job title should be present")
	public static void verifyQuoteIsPresentTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText(PostAJobPageTest.RANDOM_JOB_TITLE);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Job Title is not found");
		}
	}
	
	@Test
	@Documentation(step = "Select the random job applied", expected = "Random job posted should be clicked")
	public static void selectJobAppliedByRandomNameTest() throws Exception {
		ScriptLogger.info();
		try {
		
			List<WebElement> list=BrowserAction.getElements(QuotesPageObjectMap.QUOTES_PAGE_JOB_NAME_XPATH);

			for (WebElement webElement : list) {
				WebElement element=webElement;
				if(webElement.getText().equals(PostAJobPageTest.RANDOM_JOB_TITLE)){
					element.click();
					break;
				}			
			}		
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify quote is loaded", expected = "Quote should be loaded")
	public static void verifyQuoteLoadedTest() throws Exception {		
		ScriptLogger.info();
		try {

			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_BACK_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_ARCHIVE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_MAKE_MY_JOB_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_MIDDLE_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_AGREEMENT_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_EDIT_QUOTE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_HIDE_QUOTE_PLINK);				
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}		
				if(WorkroomPageTest.isSendMessageEnabledTest()){
					throw new ApplicationException("Message section is enablesd");
					
				}		
	}
	


	@Test
	@Documentation(step = "Click hide quote", expected = "Quote shoudld be hidden")
	public static void hideQuoteTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserAction.click(QuotesPageObjectMap.QUOTES_PAGE_OPEN_QUOTE_HIDE_QUOTE_PLINK);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	@Test
	@Parameters("messageText")
	@Documentation(step = "Enter Random message in Quote", expected = "Random message should be entered")
	public static void enterMsgTest(String messageText) throws Exception {
		ScriptLogger.info();
		RANDOM_MESSAGE=messageText+StringUtils.generateRandomString(5);
		WorkroomPageTest.enterMessageTest(RANDOM_MESSAGE);	
	}
		
	@Test
	@Documentation(step = "Click to send message", expected = "Message should be sent")
	public static void clickSendTest() throws Exception {
		ScriptLogger.info();
		WorkroomPageTest.clickSendMessageTest();
	}
	
	@Test
	@Documentation(step = "Verify Random message is present", expected = "Message should be present in the message thread")
	public static void verifyMsgSentThreadTest() throws Exception{
		ScriptLogger.info();
		try {			
			BrowserWait.waitUntilElementIsDisplayed(QuotesPageObjectMap.QUOTES_PAGE_MESSAGE_THREAD_LIST_XPATH);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		
		}
		
		if(!BrowserAction.getElement(QuotesPageObjectMap.QUOTES_PAGE_MESSAGE_TEXT_ELEMENT_XPATH).getText().contains(RANDOM_MESSAGE)){
			throw new ApplicationException("One of more element necessary for page verification didn't appear.");	
		}
	}
	
}

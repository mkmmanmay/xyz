package com.guru.testing.page;

import javax.script.ScriptException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.FLProfilePageObjectMap;

public class FLProfilePageTest {
	
	@Test
	@Documentation(step="", expected="")
	public static void verifyFLProfilePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FLProfilePageObjectMap.FL_PROFILE_PAGE_PROFILE_PIC_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(FLProfilePageObjectMap.FL_PROFILE_PAGE_PORTFOLIO_TAB_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Verification failed; either one or more of the elements for validation didn't load, or were missing.");
		}
	}


	@Test
	@Documentation(step="", expected="")
	public static void clickPortfolioTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FLProfilePageObjectMap.FL_PROFILE_PAGE_PORTFOLIO_TAB_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Failed clicking; either element didn't load, or was missing.");
		}
	}
	
	@Test
	@Documentation(step="", expected="")
	public static void verifyPortfolioEmptyTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Your portfolio is empty!", "to show Employers what you can do.");
			BrowserWait.waitUntilElementIsDisplayed(FLProfilePageObjectMap.FL_PROFILE_PAGE_PORTFOLIO_TAB_ADD_A_WORK_COLLECTION_LINK_XPATH);		
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Verification failed; either one or more of the elements for validation didn't load, or were missing.");
		}
	}
	
	@Test
	@Documentation(step="", expected="")
	public static void verifyPublishedPortNameTest() throws Exception {
		ScriptLogger.info();
		try {
			String name = BrowserWait.getElement(FLProfilePageObjectMap.FL_PROFILE_PAGE_PORTFOLIO_TAB_FIRST_PORTFOLIO_XPATH).getText();
			if(!name.equalsIgnoreCase(EditProfilePageTest.publishedPortName)) {
				throw new ApplicationException("Published portfolio name, and the portfolio name in the Freelancer's profile do not match.");
			}
		} catch (Exception e) {
			throw new ScriptException("Error in logic to compare portfolio names.");
		}
	}
	
	// --------- WHEN EMP VISITS FL's PROFILE --------
	// ------------------- START ---------------------
	@Test
	@Documentation(step="Select existing job from dropdown.", expected="Able to select from dropdown.")
	public static void selectExistingJobTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserAction.click(FLProfilePageObjectMap.FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_A_JOB_ALREADY_POSTED_DROPDOWN_ID);
			BrowserWait.getElement(FLProfilePageObjectMap.FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_A_JOB_ALREADY_POSTED_DROPDOWN_ID).sendKeys(Keys.DOWN);
			BrowserWait.getElement(FLProfilePageObjectMap.FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_A_JOB_ALREADY_POSTED_DROPDOWN_ID).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Documentation(step="Click 'Get a Quote' button.", expected="Able to click")
	public static void clickGetAQuoteTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(3000);
			BrowserAction.click(FLProfilePageObjectMap.FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_BUTTON_XPATH);
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new ScriptException("Failed clicking, possible locator issue; or element didn't load, or was missing.");
		}
	}
	
	@Test
	@Parameters("quoteInviteMsg")
	@Documentation(step="Click 'Get a Quote' button.", expected="Able to click")
	public static void enterMessageTest(String message) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(FLProfilePageObjectMap.FL_PROFILE_PAGE_SEND_A_MESSAGE_UNDER_GET_A_QUOTE_ID, message);
		} catch (Exception e) {
			throw new ScriptException("Failed sending data; possible selenium, or locator issue. If not, possible it's application issue.");
		}
	}
	
	@Test
	@Documentation(step="Verify Quote Invitation was successfully sent.", expected="Verification successfully done.")
	public static void verifyGetQuoteSuccessfulTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FLProfilePageObjectMap.FL_PROFILE_PAGE_GET_A_QUOTE_SUCCESS_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Success Toast message didn't appear. Possible application error.");
		}
	}
	
	// ------------- END ---------------------------------
	
}	
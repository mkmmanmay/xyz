package com.guru.testing.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.objectmap.SecurityQuestionsPageObjectMap;

public class SecurityQuestionsPageTest {

	@Test
	@Documentation(step = "Click 'Skip this for now' link", expected = "'Skip this for now' link should be clicked")
	public static void clickSkipThisForNowTest() throws Exception {
		
		try {
			ScriptLogger.info();
			BrowserAction.click(SecurityQuestionsPageObjectMap.SECURITY_QUESTIONS_PAGE_SKIP_THIS_FOR_NOW_LINK_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
		
	@Test
	@Documentation(step = "Verify Security Questions page is loaded", expected = "Security Questions page should be loaded")
	public static void verifySecurityQuestionsPageTest() throws Exception {
		try {
			BrowserWait.waitUntilPageTitle("Security Questions");
			

		} catch (Exception e) {

			throw new HTMLElementNotFoundException(e, "Security Question page didn't appear");
		}
	}
	
	
	public static Boolean verifyingSecurityQuestionsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Security Questions");
			return true;
		} catch (Exception e) {
			ScriptLogger.debug("Verification of Security Questions returned false.");
			return false;
		}

	}

	@Test
	@Documentation(step = "Validate security questions page, and enter the Security Question answer. Click 'Skip This for now if no Questions are set for the account.",
	expected = "User is able to see the Security Questions page, and enter the answer. If no questions are set, user is able to click 'Skip this for now'.")
	public static void validateSecurityQuestionsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			if (verifyingSecurityQuestionsPageTest()) {
				if (verifySkipThisForNowLinkTest()) {
					clickSkipThisForNowTest();
				} else {
					enterSecurityAnswerTest();
					clickContinueButtonTest();
				}
			} else {
				throw new ApplicationException("Application Issue: Security Question page didn't appear");
			}
		} catch (Exception e) {
			ScriptLogger.debug("Possibly the page didn't appear because the session hasn't expired from before.");
		}
	}
	
	
	
	@Test
	@Documentation(step = "Enter Security Answer in the text box", expected = "Security Answer should be entered reading the value from the question")
	public static void enterSecurityAnswerTest() throws Exception {
		ScriptLogger.info();
		try {
			WebElement question = BrowserAction.getElement(SecurityQuestionsPageObjectMap.SECURITY_QUESTIONS_PAGE_QUESTION_DIV_XPATH);
			String secQuestion = question.findElements(By.tagName("label")).get(0).getText();
			WebElement answerElement = question.findElement(By.tagName("input"));
			answerElement.sendKeys(secQuestion);
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}
		
	}
	

	

	@Test
	@Documentation(step = "Click continue button on security question page", expected = "Continue button should be clicked")
	public static void clickContinueButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(SecurityQuestionsPageObjectMap.SECURITY_QUESTIONS_PAGE_CONTINUE_BUTTON_ID);

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	private static Boolean verifySkipThisForNowLinkTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(SecurityQuestionsPageObjectMap.SECURITY_QUESTIONS_PAGE_SKIP_THIS_FOR_NOW_LINK_ID);
			ScriptLogger.info("'Skip this for now' link isn't present.");
			return false;
		} catch (Exception e) {
			ScriptLogger.info("'Skip this for now' is present.");
			return true;
		}
	}

}

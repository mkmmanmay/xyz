package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.objectmap.EmailPageObjectMap;


public class EmailPageTest {
	 
	// ------------------- MAILINATOR RELATED ------------------
	// -------------------------- START ------------------------
	@Test
	@Parameters("mailId")
	@Documentation(step = "Verify the page opened when clicking on 'Add a manager' in employer's workroom.", expected = "Able to verify.")
	public static void enterMailIdTest(String mailId) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_FIELD_ID, mailId);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Go!' button.", expected = "Able to click.")
	public static void clickGoTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_GO_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");	
		}
	}
	
	@Test
	@Documentation(step = "Verify mailinator inbox loaded.", expected = "Able to verify.")
	public static void verifyMailinatorInboxTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			try {
				BrowserWait.waitUntilElementIsDisplayed(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_ODD_ROW_XPATH);
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_EVEN_ROW_XPATH);
			}
		} catch (Exception e) {
			ScriptLogger.debug("There are no mails in the inbox.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'You're Invited!' subject line.", expected = "Able to click.")
	public static void clickYoureInvitedTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> oddRow = BrowserAction.getElements(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_ODD_ROW_XPATH);
			List<WebElement> evenRow = BrowserAction.getElements(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_EVEN_ROW_XPATH);
			if(oddRow.size()> evenRow.size()){
			for (int i = 0; i < oddRow.size(); i++) {
				int j=1;
				if(oddRow.get(i+(j*2)).getText().equals("You're invited!")) {
					oddRow.get(i+(j*2)).click();		
					break;
				}
				
				j++;
			}} else {
				for (int i = 0; i < evenRow.size(); i++) {
					int j=1;
					if(evenRow.get(i+(j*2)).getText().equals("You're invited!")) {
						evenRow.get(i+(j*2)).click();	
						break;
					}
					j++;
				}
			}
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Accept' button.", expected = "Able to click.")
	public static void clickAcceptBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToFrame("publicshowmaildivcontent");
			WebElement acceptbtn = BrowserAction.getElement(EmailPageObjectMap.EMAIL_PAGE_MAILINATOR_INBOX_YOURE_INVITED_EMAIL_ACCEPT_BUTTON_XPATH);
			acceptbtn.click();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");	
		}
	}
	
	@Test
	@Parameters("pageTitle")
	@Documentation(step = "Switch to the new tab..", expected = "Successfully switch to new tab.")
	public static void switchToNewTabTest(String pageTitle) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToPageByTitle(pageTitle);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");	
		}
	}
		
}
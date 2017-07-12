package com.guru.testing.page;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.LoginPageObjectMap;

public class LoginPageTest {
	
	
	
	@Test
	@Documentation(step = "Verify the Login page of Guru.", expected = "Login page should appear, and it passes verification.")
	public static void verifyLoginPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Sign In to Your Account - Guru");
			BrowserWait.waitUntilElementIsDisplayed(LoginPageObjectMap.LOGIN_PAGE_CONTENT_DIV_XPATH);
			BrowserWait.waitUntilText("Sign in to Guru");			
			verifyEmailOrUsernameTextTest();
			verifyPasswordTextTest();
			BrowserWait.waitUntilElementIsDisplayed(LoginPageObjectMap.LOGIN_PAGE_SIGN_IN_BUTTON_XPATH);
		} catch (Exception e) {
			throw new  HTMLElementNotFoundException(e,"Login page is elements not loaded in time. ");
		}
	}

	@Test
	@Documentation(step = "Verify 'Email or Username' text is present", expected = "'Email or Username' text should be present")
	public static void verifyEmailOrUsernameTextTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(LoginPageObjectMap.LOGIN_PAGE_EMAIL_USERNAME_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"'Username' Text verification failed");
		}
	}

	@Test
	@Documentation(step = "Verify 'Password' text is present", expected = "'Password' text should be present")
	public static void verifyPasswordTextTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(LoginPageObjectMap.LOGIN_PAGE_PASSWORD_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"'Password' Text verification failed");
		}
	}

	@Test
	@Parameters("username")
	@Documentation(step = "Enter username/email for login.", expected = "User is able to enter username/email in the textbox.")
	public static void enterEmailOrUsernameTest(String emailUsername) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(LoginPageObjectMap.LOGIN_PAGE_EMAIL_VALID_TEXTBOX_ID, emailUsername);
		} catch (Exception e) {
			throw new ScriptException(e);
		}	
	}

	@Test
	@Parameters("password")
	@Documentation(step = "Enter password for login.", expected = "User is able to enter password in the textbox.")
	public static void enterPasswordTest(String password) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(LoginPageObjectMap.LOGIN_PAGE_PASSWORD_VALID_TEXTBOX_ID, password);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}




	@Test
	@Documentation(step = "Click the 'Sign In' button.", expected = "User should be able to click on 'Sign In', and redirected to the next page in login process.")
	public static void clickSignInButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(LoginPageObjectMap.LOGIN_PAGE_SIGN_IN_BUTTON_XPATH);
			/*Thread.sleep(3000);*/
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		/*try {
			BrowserAction.click(LoginPageObjectMap.LOGIN_PAGE_SIGN_IN_BUTTON_XPATH);
		} catch (Exception e) {
			ScriptLogger.debug("Sign In wasn't required to be clicked twice to proceed.");
		}*/
	}
}

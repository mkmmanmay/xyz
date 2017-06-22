package com.guru.testing.page;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.objectmap.AdminLoginPageObjectMap;

public class AdminLoginPageTest {
	
		
	@Test
	@Documentation(step = "Verify the Login page of Admin site.", expected = "Login page should appear, and it passes verification.")
	public static void verifyAdminLoginPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Login");			
			BrowserWait.waitUntilText("ADMINISTRATIVE LOGIN","Username: ","Password: ");
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_USERNAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_PASSWORD_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_LOGIN_BUTTON_ID);
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Test
	@Parameters("username")
	@Documentation(step = "Enter Admin username", expected = "Admin username should be entered in the text box")
	public static void enterUsernameTest(String username) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_USERNAME_TEXTBOX_ID,username);
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Test
	@Parameters("password")
	@Documentation(step = "Enter Admin password", expected = "Admin password should be entered in the text box")
	public static void enterPasswordTest(String password) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_PASSWORD_TEXTBOX_ID,password);
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Test
	@Documentation(step = "Click Login", expected = "Login should be clicked")
	public static void clickLoginTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_LOGIN_BUTTON_ID);
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	

}

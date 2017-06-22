package com.guru.testing.page;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.testing.objectmap.AdminLoginPageObjectMap;

public class AdminLoginPageTest {
	
	public static void verifyAdminLoginPage() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Login");			
			BrowserWait.waitUntilText("ADMINISTRATIVE LOGIN", 30);
			BrowserWait.waitUntilText("Username: ","Password: ");
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_USERNAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_PASSWORD_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_LOGIN_BUTTON_ID);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
		
	public static void enterUsername(String username) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_USERNAME_TEXTBOX_ID,username);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	
	public static void enterPassword(String password) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_PASSWORD_TEXTBOX_ID,password);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static void clickLogin() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminLoginPageObjectMap.ADMIN_LOGIN_PAGE_LOGIN_BUTTON_ID);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	

}

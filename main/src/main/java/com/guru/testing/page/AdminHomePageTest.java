package com.guru.testing.page;


import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.objectmap.AdminHomePageObjectMap;

public class AdminHomePageTest {
	
		
	@Test
	@Documentation(step = "Verify the Login page of Admin site.", expected = "Login page should appear, and it passes verification.")
	public static void verifyAdminHomePage() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com Admin Area");
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK, 30);
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CREATE_NEW_TEST_USERS_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_PAYROLL_SUMMARY_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_ACCEPT_APPROVE_PAYMENTS_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_LOGOUT_PLINK);
			
			//TODO need to add more validations here.
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Click CRM-Account Search Link.", expected = "Able to click")
	public static void clickCRMAccountSearch() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "click 'Create New Test Users'.", expected = "Able to Click.")
	public static void clickCreateNewTestUsersTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CREATE_NEW_TEST_USERS_PLINK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "click 'Payroll Summary'.", expected = "Able to Click.")
	public static void clickPayrollSummaryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_PAYROLL_SUMMARY_PLINK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "click 'AcceptApprove Payments'.", expected = "Able to Click.")
	public static void clickAcceptApprovePaymentsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_ACCEPT_APPROVE_PAYMENTS_PLINK);	
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static void clickTaskManagerMonitor() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_TASK_MANAGER_MONITOR_PLINK);	
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Test
	@Documentation(step = "click 'Logout'.", expected = "Able to Click.")
	public static void clickLogoutTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_LOGOUT_PLINK);	
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	
	

}

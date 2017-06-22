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
	public static void verifyAdminHomePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com Admin Area");
			BrowserWait.waitUntilElementIsDisplayed(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK);
			//TODO need to add more validations here.
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	@Test
	@Documentation(step = "Verify the Login page of Admin site.", expected = "Login page should appear, and it passes verification.")
	public static void clickCRMAccountSearch() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminHomePageObjectMap.ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK);
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	

}

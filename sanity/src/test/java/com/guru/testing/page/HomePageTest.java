package com.guru.testing.page;

import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.testng.Documentation;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.HomePageObjectMap;

public class HomePageTest {

	@Test
	@Documentation(step = "Verify the Guru application Homepage.", expected = "Homepage verification should pass.")
	public static void verifyHomePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru - Hire Quality Freelancers And Find Freelance Jobs");
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(CommonObjectMap.COMMON_GURU_LOGO_1_ID);
			BrowserWait.waitUntilElementIsDisplayed(HomePageObjectMap.HOME_PAGE_POST_A_JOB_TOP_NAV_BUTTON_ID);
		} catch (Exception e) {
			ScriptLogger.debug("Verification of Home Page failed.");
			throw new  HTMLElementNotFoundException(e,"Homepage elemets not found");
		}
	}
	
	@Test
	@Documentation(step = "Click Post a Job in top panel", expected = "Post A Job should be clicked, and successfully redirected.")
	public  static void clickPostAJobTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(HomePageObjectMap.HOME_PAGE_POST_A_JOB_TOP_NAV_BUTTON_ID);
			BrowserAction.click(HomePageObjectMap.HOME_PAGE_POST_A_JOB_TOP_NAV_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Find a Guru button on top Nav not found");
		}
	}

	@Test
	@Documentation(step = "Click Find a guru in top panel", expected = "Find a Guru should be clicked, and successfully redirected.")
	public  static void clickFindAGuruTopNavTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(HomePageObjectMap.HOME_PAGE_FIND_A_GURU_TOP_NAV_BUTTON_ID);
			BrowserAction.click(HomePageObjectMap.HOME_PAGE_FIND_A_GURU_TOP_NAV_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Find a Guru button on top Nav not found");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Sign In' button in the top navigation of Guru Homepage.", expected = "User is able to click the 'Sign In' button.")
	public static  void clickSignInTopNavTest() throws Exception {

		try {
			ScriptLogger.info();
			BrowserAction.click(HomePageObjectMap.HOME_PAGE_SIGN_IN_TOP_NAV_BUTTON_PLINK);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Test
	@Documentation(step = "Click Find a Job in top panel", expected = "Find a Job should be clicked, and successfully redirected.")
	public  static void clickFindAJobTopNavTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(HomePageObjectMap.HOME_PAGE_FIND_A_JOB_TOP_NAV_BUTTON_ID);
			BrowserAction.click(HomePageObjectMap.HOME_PAGE_FIND_A_JOB_TOP_NAV_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Find a Job button on top Nav not found");
		}
	}

}

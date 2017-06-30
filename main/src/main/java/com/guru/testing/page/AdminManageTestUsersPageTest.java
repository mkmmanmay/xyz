package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
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
import com.guru.testing.objectmap.AdminManageTestUsersPageObjectMap;

public class AdminManageTestUsersPageTest {
	
	@Test
	@Documentation(step = "Verify Manage Test Users Page.", expected = "Able to verify.")
	public static void verifyManageTestUsersPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_CREATE_EMPLOYER_ACCOUNT_BUTTON_XPATH, 25);
			BrowserWait.waitUntilElementIsDisplayed(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_CREATE_FREELANCER_ACCOUNT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_BACK_TO_ADMIN_MENU_LINK_PLINK);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, " One of more element necessary for page verification didn't appear; a possible Application issue. Verify screenshot.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Create Employer Account' button.", expected = "Able to click.")
	public static void clickCreateEMPAccountBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_CREATE_EMPLOYER_ACCOUNT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Couldn't click. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Create Freelancer Account' button.", expected = "Able to click.")
	public static void clickCreateFLAccountBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_CREATE_FREELANCER_ACCOUNT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Couldn't click. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Freelancer created successfully.", expected = "Able to verify.")
	public static void verifyFLUserCreationSuccessTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_NEW_USER_CREATED_SUCCESS_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Couldn't verify successful user creation. The Toast message mayn't have appeared. Possible Application issue.");
		}
	}
	
	@Test
	@Parameters("index")
	@Documentation(step = "Verify Freelancer created successfully.", expected = "Able to verify.")
	public static void goToInfoPageByIndexTest(int index) throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(10000);
			List<WebElement> row = BrowserAction.getElements(AdminManageTestUsersPageObjectMap.ADMIN_MANAGE_USERS_PAGE_USERS_LIST_ROWS_XPATH);
			List<WebElement> columns = row.get(index).findElements(By.tagName("td"));
			columns.get(3).click();
		} catch (Exception e) {
			throw new ApplicationException("Couldn't click on 'Info Page' link against user.");
		}
	}
	
	@Test
	@Documentation(step = "Switch handle to new tab", expected = "Able to switch to new handle.")
	public static void switchToNewTabTest() throws Exception {
		ScriptLogger.info();
		try {
			/*List<String> tabs = new ArrayList<String>(WebDriverAction.getDriver().getWindowHandles());
			WebDriverAction.getDriver().switchTo().window(tabs.get(1));*/
			for(String winHandle : WebDriverAction.getDriver().getWindowHandles()){
				WebDriverAction.getDriver().switchTo().window(winHandle);
			}
			System.out.println("Current page is: " +WebDriverAction.getDriver().getTitle());
		} catch (Exception e) {
			throw new ScriptException("Wasn't able to switch to new tab.");
		}
	}
	
}

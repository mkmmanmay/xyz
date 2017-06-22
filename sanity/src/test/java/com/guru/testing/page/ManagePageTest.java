package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.EditProfilePageObjectMap;
import com.guru.testing.objectmap.ManagePageObjectMap;
import com.guru.testing.objectmap.WorkroomPageObjectMap;

public class ManagePageTest {
	
	// ------------ MY MANAGERS TAB RELATED ------------
	// ---------------------- START --------------------
	
	@Test
	@Documentation(step = "Verify 'My Managers' tab under Manage tab.", expected = "Able to verify.")
	public static void verifyMyManagersPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("View Team Members - Guru");
			BrowserWait.waitUntilText("Manage", 30);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_TEAM_LIST_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_ADD_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step = "click dropdown toggle on first Manager role appearing", expected = "Able to verify.")
	public static void clickFirstManagerDropdownTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> roles = BrowserAction.getElements(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_TILES_TEXT_XPATH);
			int index = 0;
			for (int i = 0; i < roles.size(); i++) {
				if(roles.get(i).findElement(By.cssSelector(".memberRole")).getText().equals("Manager")) {
					WebDriverAction.hoverOverElement(roles.get(i), WebDriverAction.ACTION_STYLE_WEBDRIVER);
					Thread.sleep(2000);
					roles.get(i).findElement(By.xpath("//a[@class='module_btn secondary_btn dropdown-toggle']")).click();
					break;
				} else {
					index++;
				}
			}
			/*System.out.println(index);
			
			List<WebElement> dropdown = BrowserAction.getElements(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_DROPDOWN_TOGGLE_XPATH);
			BrowserAction.click(dropdown.get(index+1)); */// Minus one because owner tile has no dropdown.
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step = "click dropdown toggle on first Manager role appearing", expected = "Able to verify.")
	public static void clickRemoveInDropdownTest() throws Exception {
		ScriptLogger.info();
		String attr = null;
		try {
			BrowserAction.click(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_DROPDOWN_MENU_REMOVE_BUTTON_XPATH);
			do {
				attr = BrowserWait.getElement(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_SUCCESSFULLY_REMOVED_TOAST_MESSAGE_XPATH).getAttribute("style");
			} while(!attr.contains("display: none"));
			//BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_MY_MANAGERS_SUB_TAB_SUCCESSFULLY_REMOVED_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.")	;	
		}
	}
	
	// ------------------------- END ---------------------
	
	@Test
	@Documentation(step = "Verify the page opened when clicking on 'Add a manager' in employer's workroom.", expected = "Able to verify.")
	public static void verifyAddAManagerEMPPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Invite Team Members");
			BrowserWait.waitUntilText("Enter email address:", 30);
			BrowserWait.waitUntilText("Select role:");
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_EMAIL_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_SELECT_ROLE_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_ADD_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_CANCEL_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters("firstEmail")
	@Documentation(step = "Enter email address.", expected = "Able to enter data.")
	public static void enterFirstEmailTest(String firstEmail) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_FIRST_EMAIL_ADDRESS_ROW_XPATH, firstEmail);
			BrowserAction.getElement(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_FIRST_EMAIL_ADDRESS_ROW_XPATH).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");	
		}
	}
	
	@Test
	@Parameters("firstRole")
	@Documentation(step = "Select role corresponding to the first email address row.", expected = "Able to select.")
	public static void selectFirstRoleTest(String firstRole) throws Exception {
		ScriptLogger.info();
		try {
			Select role = new Select(BrowserAccess.getElement(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_FIRST_ROLE_DROPDOWN_XPATH)); 
			role.selectByVisibleText(firstRole);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter. Could also be a locator issue.");	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Add' button.", expected = "Able to click.")
	public static void clickAddTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_ADD_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_BUILD_MY_TEAM_BUTTON_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_LEAVE_THIS_TEAM_LINK_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");	
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Request Pending' text appears against the team member tile.", expected = "Able to verify.")
	public static void verifyRequestPendingTextTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> textElement = BrowserAction.getElements(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_TEXT_UNDER_INDIVIDUAL_SCREEN_ICONS_XPATH);
			for(int i = 0; i < textElement.size(); i++) {
				if(textElement.get(i).getText().equals("Request Pending")) {
					break;
				}
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Request pending text wasn't found. It's possible HTML/UI error, or an application issyue; investigate.");	
		}
	}
}

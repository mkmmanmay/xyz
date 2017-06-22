package com.guru.testing.page;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.helpers.WindowHandler;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.AdminCRMPageObjectMap;

public class AdminCRMPageTest {
	public static final String PAGE_ID=AdminCRMPageTest.class.getName();
	private static String WINDOW_HANDLE=null;
		
	@Test
	@Documentation(step = "Verfy Admin CRM account page", expected = "Admin CRM page should be verified")
	public static void verifyCRMAccountSearchPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Customer Relations Management - Account Search");
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_INPUT_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_SEARCHBY_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_INPUT_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_SEARCHBY_DROPDOWN_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"CRM Account page elements not loaded");
		}
	}
	
	
	@Test
	@Parameters("searchKeyword")
	@Documentation(step = "Enter the keyword in employer search textbox", expected = "Search keyword should be entered in the employer's search textbox")
	public static void enterEmpSearchKeywordTest(String searchKeyword) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_INPUT_TEXTBOX_XPATH, searchKeyword);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("searchKeyword")
	@Documentation(step = "Enter the keyword in freelancer's search textbox", expected = "Search keyword should be entered in the freelancer's search textbox")
	public static void enterFLSearchKeywordTest(String searchKeyword) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_INPUT_TEXTBOX_XPATH, searchKeyword);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("username")
	@Documentation(step = "Enter the email in freelancer's search textbox,select email option,click FL search and verify search results", expected = "Email should be entered in the freelancer's search textbox, email option should be selected, search should be clicked and Frrelancwer history page should have the email id")
	public static void searchFLByEmailTest(String username) throws Exception {
		ScriptLogger.info();
		try {
			enterFLSearchKeywordTest(username);
			selectFLSearchbyTest("Email");
			clickFLSearchTest();
			verifyFLSearchResultsTest(username);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Parameters("searchEmpBy")
	@Documentation(step = "Select searchBy option for emp option", expected = "Searchby option should be selected for emp")
	public static void selectEmpSearchbyTest(String searchEmpBy) throws Exception {
		ScriptLogger.info();
		try {
			Select select=new Select(BrowserAction.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_SEARCHBY_DROPDOWN_XPATH));
			select.selectByVisibleText(searchEmpBy);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("searchFLBy")
	@Documentation(step = "Select searchBy option for FL option", expected = "Searchby option should be selected for FL")
	public static void selectFLSearchbyTest(String searchFLBy) throws Exception {
		ScriptLogger.info();
		try {
			Select select=new Select(BrowserAction.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_SEARCHBY_DROPDOWN_XPATH));
			select.selectByVisibleText(searchFLBy);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Search button for Employer", expected = "Employer's search button should be clicked")
	public static void clickEmpSearchTest() throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_SEARCH_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Search button for Freelancer", expected = "Freelancer's search button should be clicked")
	public static void clickFLSearchTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_SEARCH_BUTTON_XPATH);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_SEARCH_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("searchKeyword")
	@Documentation(step = "Verify search results after search is clicked for employer", expected = "Employer History page should be loaded and searched keyword should be present for employer")
	public static void verifyEmpSearchResultsTest(String searchKeyword) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Employer History");
			BrowserWait.waitUntilText("Customer Relations Management - Employer History",searchKeyword);
			BrowserWait.waitUntilText("Name / Contact Info","IDs / Sign in Info","Account Status","Employer Statistics","Reward Program","Promo History");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Employer History page is not loaded");
		}
	}
	
	@Test
	@Parameters("searchKeyword")
	@Documentation(step = "Verify search results after search is clicked for freelancer", expected = "Employer History page should be loaded and searched keyword should be present for freelancer")
	public static void verifyFLSearchResultsTest(String searchKeyword) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Pro History");
			BrowserWait.waitUntilText("Customer Relations Management - Professional History",searchKeyword);
			BrowserWait.waitUntilText("Name / Contact Info","IDs / Sign in Info","Account Status","Pro Statistics");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Employer History page is not loaded");
		}
	}
		
	@Test
	@Documentation(step = "Click Go to Account link", expected = "'Go to Account' link should be clicked")
	public static void gotoAccountTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_GO_TO_ACCOUNT_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}	
	
	@Test
	@Documentation(step = "Switch to account page and verify having dashboard", expected = "Control should be shifted to ")
	public static void switchToAccountPageTest() throws Exception {
		ScriptLogger.info();
		switchToThisWindow();
		DashboardPageTest.switchToThisWindow();
		try {
			//BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_WIDGET_PANE_2_ID,10);
			BrowserWait.waitUntilText("Dashboard");
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
	
	@Test
	@Documentation(step = "Click Membership Tab for a user", expected = "membership tab should be clicked")
	public static void clickMembershipTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_TAB_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Parameters("membershipType")
	@Documentation(step = "Select Membership Type as provided", expected = "Given membership type should be selected as provided")
	public static void selectMembershipTypeTest(String membershipType) throws Exception {
		ScriptLogger.info();
		try {
			Select select=new Select(BrowserAction.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_TYPE_DROPDOWN_XPATH));
			select.selectByVisibleText(membershipType);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Parameters("membershipDuration")
	@Documentation(step = "Select Membership Duration as provided", expected = "Given membership duration should be selected as provided")
	public static void selectMembershipDurationTest(String membershipDuration) throws Exception {
		ScriptLogger.info();
		try {
			Select select=new Select(BrowserAction.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_DURATION_DROPDOWN_XPATH));
			select.selectByVisibleText(membershipDuration);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test	
	@Documentation(step = "Click Upgrade membership button", expected = "Upgrade membership button should be clicked")
	public static void clickUpgradeMembershipTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_UPGRADE_BUTTON_XPATH);
			BrowserWait.waitUntilText("! SUCCESS","Downgrade membership successfully");
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test	
	@Parameters("currentMembership")
	@Documentation(step = "Verify current membership on the memebrship tab page", expected = "Membership type should be same as provided")
	public static void verifyCurrentMembershipTest(String currentMembership) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText(currentMembership);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	

	@Test	
	@Documentation(step = "Verify Membership page for a user", expected = "Membership page should be verified")
	public static void verifyMembershipPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Membership History","Adjust bids from account (-ve values allowed)","Change Membership Level");
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_TYPE_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_DURATION_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_MEMBERSHIP_UPGRADE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}	
	
	
	public static void switchToThisWindow() throws Exception{
		ScriptLogger.info();
		try{
			if(WINDOW_HANDLE==null){
				WINDOW_HANDLE=WindowHandler.getWindowHandle(PAGE_ID);
			}
			WebDriverAction.getDriver().switchTo().window(WINDOW_HANDLE);
			WebDriverAction.getDriver().manage().window().maximize();

		}catch(Exception e){
			throw new ScriptException(e);
		}
	}
	

}

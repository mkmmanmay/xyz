package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.helpers.WindowHandler;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.AdminCRMPageObjectMap;

public class AdminCRMPageTest {
	public static final String PAGE_ID=AdminCRMPageTest.class.getName();
	private static String WINDOW_HANDLE=null;
	public static String userID;
	public static String userEmail;
		
	@Test
	@Documentation(step = "Verfy Admin CRM account page", expected = "Admin CRM page should be verified")
	public static void verifyCRMAccountSearchPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Customer Relations Management - Account Search");
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_INPUT_TEXTBOX_XPATH, 30);
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
			BrowserWait.waitUntilText("Customer Relations Management - Employer History",searchKeyword, 30);
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
			BrowserWait.waitUntilText("Customer Relations Management - Professional History",searchKeyword, 30);
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
			BrowserWait.waitUntilText("Dashboard");
		} catch (Exception e) {
			throw new ApplicationException("Neither 'Dashboard' or 'Contact info' page appeared after clicking 'Go to Account'.");
		}
		
		
	}
	
	@Test
	@Documentation(step = "Click General Info Tab for a user", expected = " 'General Info' tab should be clicked")
	public static void clickGeneralInfoTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_GENERAL_INFO_TAB_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Retrieve Guru/EMP ID from the CRM page.", expected = "Able to retrieve data.")
	public static void getUserIDTest() throws Exception {
		ScriptLogger.info();
		try {
			userID = BrowserAccess.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_USER_ID_XPATH).getText();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Retrieve Guru/EMP email id from the CRM page.", expected = "Able to retrieve data.")
	public static void getEmailIDTest() throws Exception {
		ScriptLogger.info();
		try {
			userEmail = BrowserAccess.getElement(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_USER_EMAIL_XPATH).getText();
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
	@Documentation(step = "Click Payment Tab for a user", expected = "Payment tab should be clicked")
	public static void clickPaymentTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_PAYMENT_TAB_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Payment/W-9 Tab for a user", expected = "Payment/W-9 tab should be clicked")
	public static void clickPaymentW9TabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_PAYMENT_W9_TAB_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click View E-check Accounts for a user", expected = " View E-check Accounts should be clicked")
	public static void clickViewECheckAccountsFLTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_VIEW_ECHECK_ACCOUNTS_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_FL_VIEW_ECHECK_ACCOUNTS_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click View E-check Accounts for an EMP", expected = " View E-check Accounts should be clicked")
	public static void clickViewECheckAccountsEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_VIEW_ECHECK_ACCOUNTS_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_VIEW_ECHECK_ACCOUNTS_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click View Credit cards for a user", expected = " View E-check Accounts should be clicked")
	public static void clickViewCreditCardsEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_VIEW_CREDIT_CARDS_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_EMP_VIEW_CREDIT_CARDS_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click View Wire Transfer Accounts for a user", expected = " View Wire Transfer Accounts should be clicked")
	public static void clickViewWireTransferAccountsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VIEW_WIRE_TRANSFER_ACCOUNTS_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VIEW_WIRE_TRANSFER_ACCOUNTS_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click View Payoneer Account for a user", expected = "It should be clicked")
	public static void clickViewPayoneerAccountTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VIEW_PAYONEER_ACCOUNTS_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VIEW_PAYONEER_ACCOUNTS_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click 'Verify' for a FL", expected = " 'Verify' should be clicked.")
	public static void clickVerifyECheckFLTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		try {
			BrowserWait.waitUntilText("Verified", 10);
		} catch (Exception e) {
			throw new ApplicationException("'verified' text didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Verify' for a EMP", expected = " 'Verify' should be clicked.")
	public static void clickVerifyECheckEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			Alert alert = BrowserAction.switchToAlertBox();
			alert.accept();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		try {
			BrowserWait.waitUntilText("Verified", 10);
		} catch (Exception e) {
			throw new ApplicationException("'verified' text didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Verify' for a user", expected = " 'Verify' should be clicked.")
	public static void clickVerifyWireTransferTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			Alert alert = BrowserAction.switchToAlertBox();
			alert.accept();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		try {
			BrowserWait.waitUntilText("Verified", 15);
		} catch (Exception e) {
			throw new ApplicationException("'verified' text didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Verify' for a user", expected = " 'Verify' should be clicked.")
	public static void clickVerifyCreditCardsEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			List<WebElement> verifyLinks = BrowserAccess.getElements(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
			int size = verifyLinks.size();
			for(int i = 0; i < size; i++) {
				BrowserAction.click(AdminCRMPageObjectMap.ADMIN_CRM_PAGE_VERIFY_PLINK);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		try {
			BrowserWait.waitUntilText("Expires", 15);
		} catch (Exception e) {
			throw new ApplicationException("'Expires' text didn't appear.");
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
			BrowserWait.waitUntilText("Membership History","Adjust bids from account (-ve values allowed)","Change Membership Level", 30);
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
	
	@Test
	@Documentation(step = "Switch handle to new tab", expected = "Able to switch to new handle.")
	public static void switchToNewTabTest() throws Exception {
		ScriptLogger.info();
		try {
			AdminManageTestUsersPageTest.switchToNewTabTest();
		} catch (Exception e) {
			throw new ScriptException("Wasn't able to switch to new tab.");
		}
	}

}

package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminLoginPageTest;
import com.guru.testing.page.LaunchApplicationPageTest;

public class DebitFundsFromCRM {
	
	@Test(alwaysRun = true)
	@Parameters("url")
	@Documentation(step="Launch Admin site." , expected = "Able to launch URL.")
	public static void launchAdminSiteTest(String url) throws Exception {
		LaunchApplicationPageTest.navigateToUrlTest(url);
	}
	
	@Test(dependsOnMethods="launchAdminSiteTest", priority = 1)
	@Documentation(step="Verify Admin Login page.", expected="Textboxes, and other elements of the Login page should load.")
	public static void verifyAdminLoginPageTest() throws Exception{
		AdminLoginPageTest.verifyAdminLoginPage();
	}

	@Test(dependsOnMethods="launchAdminSiteTest", priority = 2)
	@Parameters({"adminUsername", "adminPassword"})
	@Documentation(step="Login to Admin by given credentials.", expected="Should be able to login.")
	public static void loginToAdminTest(String username, String password) throws Exception{
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
		AdminLoginPageTest.clickLogin();
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 3)
	@Documentation(step="Verify Admin Home page after Login.", expected="Able to verify.")
	public static void verifyAdminHomePageTest() throws Exception{
		AdminHomePageTest.verifyAdminHomePage();
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 4)
	@Documentation(step="Click on 'CRM - Account Search' link in the Home page.", expected="Should be able to click.")
	public static void goToCRMPageTest() throws Exception{
		AdminHomePageTest.clickCRMAccountSearch();
	}
	
	@Test(dependsOnMethods="goToCRMPageTest", priority = 5)
	@Documentation(step="Verify Account Search page.", expected="Elements of the CRM page should load properly.")
	public static void verifyCRMPageTest() throws Exception{
		AdminCRMPageTest.verifyCRMAccountSearchPageTest();
	}
	
	@Test(dependsOnMethods="goToCRMPageTest", priority = 6)
	@Parameters({"userType", "searchKeyword", "searchBy"})
	@Documentation(step="Enter User Type and Keyword for search.", expected="Able to enter data according to user type: Freelancer or Employer")
	public static void enterUserAndSearchTest(String userType, String searchKeyword, String searchBy) throws Exception{
		AdminCRMPageTest.enterSearchKeywordTest(userType, searchKeyword);
		AdminCRMPageTest.selectSearchByTest(userType, searchBy);
	}
	
	@Test(dependsOnMethods="enterUserAndSearchTest", priority = 7)
	@Parameters({"userType", "searchKeyword"})
	@Documentation(step="Verify search results after searching.", expected="Able to verify.")
	public static void verifySearchResultTest(String userType, String searchKeyword) throws Exception{
		AdminCRMPageTest.clickSearchBtnTest(userType);
		AdminCRMPageTest.verifySearchResultsTest(userType, searchKeyword);
	}
	
	@Test(dependsOnMethods="enterUserAndSearchTest", priority = 8)
	@Parameters({"userType"})
	@Documentation(step="Go to the Payments tab with 'Credit' and 'Debit' link in it.", expected="Navigation to the Payments tab is successfully completed.")
	public static void navigateToCreditDebitTest(String userType) throws Exception{
		if(userType.contains("Freelancer")) {
			AdminCRMPageTest.clickPaymentW9TabTest();
		} else if(userType.contains("Employer")) {
			AdminCRMPageTest.clickPaymentTabTest();
		}
	}
	
	@Test(dependsOnMethods="navigateToCreditDebitTest", priority = 9)
	@Parameters({"userType"})
	@Documentation(step="Click on 'Debit ____ account', where the ____ is either Pro or Emp.", expected="Able to click link based on user type.")
	public static void goToDebitOptionTest(String userType) throws Exception{
		AdminCRMPageTest.clickDebitAccountTest(userType);
	}
	
	@Test(dependsOnMethods="goToDebitOptionTest", priority = 10)
	@Parameters({"debitAmount", "debitNote"})
	@Documentation(step="Enter Amount to debit, and a note against the debit amount.", expected="Able to enter the information.")
	public static void enterAmountDetailsTest(String debitAmount, String debitNote) throws Exception{
		AdminCRMPageTest.enterDebitAmountTest(debitAmount);
		AdminCRMPageTest.enterDebitNoteTest(debitNote);
	}
	
	@Test(dependsOnMethods="enterAmountDetailsTest", priority = 11)
	@Documentation(step="Click 'Debit Account Now', and verify the debit was successful.", expected="Debit account should be successful.")
	public static void clickDebitAccountNowTest() throws Exception{
		AdminCRMPageTest.clickDebitAccountNowTest();
	}
	
}

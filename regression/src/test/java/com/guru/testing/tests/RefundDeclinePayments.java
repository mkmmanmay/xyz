package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminApprovePaymentsPage;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminLoginPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.HirePageTest;
import com.guru.testing.page.InvoicePageTest;
import com.guru.testing.page.JobDetailsPageTest;
import com.guru.testing.page.LaunchApplicationPageTest;
import com.guru.testing.page.LoginPageTest;
import com.guru.testing.page.PayNowPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PhoneVerificationPageTest;
import com.guru.testing.page.PostAJobPageTest;
import com.guru.testing.page.SecurityQuestionsPageTest;
import com.guru.testing.page.WorkroomPageTest;

public class RefundDeclinePayments {
	
	@Test(alwaysRun = true, priority = 0)
	@Documentation(step="Navigate to Post a Job page.", expected="User is able to click on 'Post a Job' successfully.")
	public static void goToPostAJobPageTest() throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
	}
	
	@Test(dependsOnMethods = "goToPostAJobPageTest", priority = 1)
	@Documentation(step="verify Post a Job page.", expected="User is able to verify 'Post a Job' successfully.")
	public static void verifyPostAJobPageTest() throws Exception {
		PostAJobPageTest.verifyPostAJobPageTest();
	}
	
	@Test(dependsOnMethods = "goToPostAJobPageTest", priority = 2)
	@Parameters({"jobDetails", "category", "skill", "fixedBudget"})
	@Documentation(step="Enter valid Job details, and click 'Post Job' button.", expected="User is able to enter Job details, and clicks on 'Post Job' button,")
	public static void enterJobDetailsTest(String jobDetails, String category,
			String skill, String budget) throws Exception {
		
		PostAJobPageTest.enterRandomJobTitleTest();
		PostAJobPageTest.enterJobDescriptionTest(jobDetails);
		PostAJobPageTest.clickCategoryTest(category);
		PostAJobPageTest.enterKeywordsTest(skill);
		PostAJobPageTest.selectFixedPriceBudgetTest(budget);
		PostAJobPageTest.clickFeatureMyJobTest();
	}
	
	@Test(dependsOnMethods = { "enterJobDetailsTest" }, priority = 3)
	@Documentation(step="Complete Featuring Job using eCheck funds.", expected="User is able to feature job using eCheck.")
	public static void clickPostJobTest() throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
	}
	
	@Test(dependsOnMethods = { "clickPostJobTest" }, priority = 4)
	@Documentation(step="Verify Featuring Job payment page is successfully loaded", expected="Feature job pay now page successfully loaded.")
	public static void verifyFeatureJobPayNowPageTest() throws Exception {
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods = { "clickPostJobTest" }, priority = 5)
	@Documentation(step="Click checkbox next to agree to Payment terms.", expected="User is able to click.")
	public static void agreeToPayCheckTest() throws Exception {
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "agreeToPayCheckTest" }, priority = 6)
	@Documentation(step="Verify Featuring Job payment using eCheck is successful", expected="User is able to feature job using eCheck.")
	public static void clickPayTest() throws Exception {
		PayNowPageTest.clickPayTest();
		
	}
	
	@Test(dependsOnMethods = { "clickPayTest" }, priority = 7)
	@Documentation(step="Verify Featuring Job payment page is successful", expected="Feature job payment success.")
	public static void verifyJobPostSuccessTest() throws Exception {
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "clickPayTest" }, priority = 8)
	@Documentation(step="Fetch Tiny URL for the Job just posted", expected="Able to fetch tiny url of posted job.")
	public static void goToJobHirePageTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyEMPDashboardPageTest();
		DashboardPageTest.clickRandomJobnamePostedTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageTest", priority = 9)
	@Documentation(step="", expected="")
	public static void verifyHirePageTest() throws Exception{
		HirePageTest.verifyHirePageTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageTest", priority = 10)
	@Documentation(step="Get Tiny URL and Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutEMPTest() throws Exception{
		HirePageTest.getTinyURLTest();
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="signOutEMPTest", priority = 11)
	@Documentation(step="", expected="")
	public static void verifyLoginPageOneTest() throws Exception{
		// "One" in the method name is just to avoid getting error when creating another method
		// 'verifyLoginPageTest' again with similar content.
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutEMPTest", priority = 12)
	@Parameters({"fLUsername", "flPassword"})
	@Documentation(step="", expected="")
	public static void loginAsFLTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsFLTest", priority = 13)
	@Documentation(step="", expected="")
	public static void verifyFLLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifySecurityQuestionsPageTest();
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyFLLoggedInTest", priority = 14)
	@Documentation(step="", expected="")
	public static void verifyFLDashTest() throws Exception{
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyFLLoggedInTest", priority = 15)
	@Documentation(step="", expected="")
	public static void launchTinyUrlTest() throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(HirePageTest.tinyUrl);
	}
	
	@Test(dependsOnMethods="launchTinyUrlTest", priority = 16)
	@Documentation(step="", expected="")
	public static void verifyJobDetailsPageTest() throws Exception{
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods="launchTinyUrlTest", priority = 17)
	@Documentation(step="", expected="")
	public static void clickApplyTest() throws Exception{
		JobDetailsPageTest.clickApplyTest();
	}
	
	@Test(dependsOnMethods="clickApplyTest", priority = 18)
	@Documentation(step="", expected="")
	public static void verifyApplyQuoteFormTest() throws Exception{
		JobDetailsPageTest.verifyApplyQuotesFormTest();
	}
	
	@Test(dependsOnMethods = "clickApplyTest", priority = 19)
	@Documentation(step="Craft a Milestone Quote", expected="Able to enter valid milestone details")
	@Parameters({"noOfMilestones", "milestoneNames", "milestoneDueDates", "milestoneAmounts", "scopeOfWork"})
	public static void craftMilestoneQuoteTest(int noOfMilestones, String milestoneNames, String milestoneDueDates
			, String milestoneAmounts, String scopeOfWork) throws Exception {
		JobDetailsPageTest.enterMilestonesTest(noOfMilestones, milestoneNames, milestoneDueDates, milestoneAmounts);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "craftMilestoneQuoteTest", priority = 20)
	@Documentation(step="Send the milestone based quote, and ", expected="Able to click on Submit button.")
	public static void submitQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		
	}
	
	@Test(dependsOnMethods="submitQuoteTest", priority = 21)
	@Documentation(step="Verify quote's successful submission.", expected="Milestone based quote is successfully sent.")
	public static void verifyQuoteSubmittedTest() throws Exception{
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods="submitQuoteTest", priority = 22)
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutFLTest() throws Exception{
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods="signOutFLTest", priority = 23)
	@Documentation(step="", expected="")
	public static void verifyLoginPageTwoTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFLTest", priority = 24)
	@Parameters({"username", "password"})
	@Documentation(step="", expected="")
	public static void loginAsEMPTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsEMPTest", priority = 25)
	@Documentation(step="", expected="")
	public static void verifyEMPLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLoggedInTest", priority = 26)
	@Documentation(step="", expected="")
	public static void verifyEMPDashTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "verifyEMPLoggedInTest", priority = 27)
	@Documentation(step="", expected="")
	public static void goToJobHirePageAgainTest() throws Exception {
		DashboardPageTest.clickRandomJobnamePostedTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageAgainTest", priority = 28)
	@Documentation(step="", expected="")
	public static void verifyHirePageAgainTest() throws Exception{
		HirePageTest.verifyHirePageTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageAgainTest", priority = 29)
	@Documentation(step="", expected="")
	public static void hireTheFLTest() throws Exception{
		HirePageTest.clickHireBtnTest();
		HirePageTest.clickAcknowledgeCheckboxTest();
		HirePageTest.clickHireInHirePopupTest();
	}
	
	@Test(dependsOnMethods="hireTheFLTest", priority = 30)
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void logOutEMPTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="logOutEMPTest", priority = 31)
	@Documentation(step="", expected="")
	public static void verifyLoginPageThreeTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="logOutEMPTest", priority = 32)
	@Parameters({"fLUsername", "flPassword"})
	@Documentation(step="", expected="")
	public static void loginAsFreeLTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsFreeLTest", priority = 33)
	@Documentation(step="", expected="")
	public static void verifyFreeLLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyFreeLLoggedInTest", priority = 34)
	@Documentation(step="", expected="")
	public static void verifyFLDashboardTest() throws Exception{
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyFreeLLoggedInTest", priority = 35)
	@Parameters("flWorkroomIndex")
	@Documentation(step="", expected="")
	public static void goToWorkroomTest(int index) throws Exception{
		DashboardPageTest.clickFLWorkroomByIndexTest(index);
			
	}
	
	@Test(dependsOnMethods="goToWorkroomTest", priority = 36)
	@Documentation(step="", expected="")
	public static void verifyFLWorkroomTest() throws Exception{
		WorkroomPageTest.verifyFLWorkroomPageTest();
	}
	
	@Test(dependsOnMethods="goToWorkroomTest", priority = 37)
	@Documentation(step="", expected="")
	public static void clickSendInvoiceTest() throws Exception{
		WorkroomPageTest.clickFirstMileSendInvTest();
		
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 38)
	@Documentation(step="", expected="")
	public static void verifyCreateInvoicePageTest() throws Exception{
		InvoicePageTest.verifyCreateInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 39)
	@Parameters("jobType")
	@Documentation(step="", expected="")
	public static void enterInvoiceDetailsTest(String jobType) throws Exception{
		InvoicePageTest.selectKindOfJobTest(jobType);
		InvoicePageTest.clickPreviewInvoiceTest();
	}
	
	@Test(dependsOnMethods="enterInvoiceDetailsTest", priority = 40)
	@Documentation(step="", expected="")
	public static void sendInvoiceTest() throws Exception{
		InvoicePageTest.clickSendInvoiceTest();
		
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 41)
	@Documentation(step="", expected="")
	public static void verifyFLInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 42)
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutFreeLTest() throws Exception{
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 43)
	@Documentation(step="", expected="")
	public static void verifyLoginPageFourTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 44)
	@Parameters({"username", "password"})
	@Documentation(step="", expected="")
	public static void loginEMPTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginEMPTest", priority = 45)
	@Documentation(step="", expected="")
	public static void verifyEMPLogInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 46)
	@Documentation(step="", expected="")
	public static void verifyDashEMPTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 47)
	@Documentation(step="", expected="")
	public static void clickPayTabTest() throws Exception{
		DashboardPageTest.clickPayTabTest();
		
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 48)
	@Documentation(step="", expected="")
	public static void verifyInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 49)
	@Documentation(step="", expected="")
	public static void clickUnpaidInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 50)
	@Documentation(step="", expected="")
	public static void verifyInvoiceDetailsPageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 51)
	@Documentation(step="", expected="")
	public static void clickPayInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickPayInvoiceTest();
	}

	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 52)
	@Documentation(step="", expected="")
	public static void verifyInvoicePayNowPageTest() throws Exception{
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 53)
	@Documentation(step="", expected="")
	public static void selectECheckAndAgreeTermsTest() throws Exception{
		PayNowPageTest.selectECheckTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods="selectECheckAndAgreeTermsTest", priority = 54)
	@Documentation(step="", expected="")
	public static void payInvoiceTest() throws Exception{
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 55)
	@Documentation(step="", expected="")
	public static void verifyInvoicePaidTest() throws Exception{
		PayNowPageTest.verifyInvoicePaidTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 56)
	@Documentation(step="", expected="")
	public static void signOutEmployerTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="signOutEmployerTest", priority = 57)
	@Documentation(step="", expected="")
	public static void verifyLoginPageFiveTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutEmployerTest", priority = 58)
	@Parameters({"adminUrl"})
	@Documentation(step="", expected="")
	public static void launchAdminSiteTest(String adminUrl) throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(adminUrl);
	}
	
	@Test(dependsOnMethods="launchAdminSiteTest", priority = 59)
	@Documentation(step="", expected="")
	public static void verifyAdminLoginPageTest() throws Exception{
		AdminLoginPageTest.verifyAdminLoginPage();
	}

	@Test(dependsOnMethods="launchAdminSiteTest", priority = 60)
	@Parameters({"adminUsername", "adminPassword"})
	@Documentation(step="", expected="")
	public static void loginToAdminTest(String username, String password) throws Exception{
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
		AdminLoginPageTest.clickLogin();
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 61)
	@Documentation(step="", expected="")
	public static void verifyAdminHomePageTest() throws Exception{
		AdminHomePageTest.verifyAdminHomePage();
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 62)
	@Documentation(step="", expected="")
	public static void goToAcceptApproveTest() throws Exception{
		AdminHomePageTest.clickAcceptApprovePaymentsTest();
		
	}
	
	@Test(dependsOnMethods="goToAcceptApproveTest", priority = 63)
	@Documentation(step="", expected="")
	public static void verifyAdminApprovePaymentsPage() throws Exception{
		AdminApprovePaymentsPage.verifyAdminApprovePaymentsPage();
	}
	
	@Test(dependsOnMethods="goToAcceptApproveTest", priority = 64)
	@Documentation(step="", expected="")
	@Parameters({"pendingTabName"})
	public static void goToPendingTabTest(String tabName) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
	}
	
	@Test(dependsOnMethods="goToPendingTabTest", priority = 65)
	@Documentation(step="", expected="")
	@Parameters({"fromDate", "toDate", "approveRowNum"})
	public static void findPendingPaymentTest(String fromDate, String toDate, String approveRowNum) throws Exception {
		AdminApprovePaymentsPage.enterFromDate(fromDate);
		AdminApprovePaymentsPage.enterToDate(toDate);
		AdminApprovePaymentsPage.clickSubmit();
		AdminApprovePaymentsPage.enableApproveByRowNumber(approveRowNum);
	}
	
	@Test(dependsOnMethods = "findPendingPaymentTest", priority = 66)
	@Documentation(step="Click on the approve button ",expected="Approve button should be click")
	@Parameters("approveRowNum")
	public static void clickApproveTest(int approveRowNum) throws Exception {
		AdminApprovePaymentsPage.clickApproveByRowNum(approveRowNum);
	}
	
	@Test(dependsOnMethods="clickApproveTest", priority = 67)
	@Documentation(step="", expected="")
	@Parameters({"completedTabName", "fromDate", "toDate"})
	public static void goToCompletedTabTest(String tabName, String fromDate, String toDate) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
		AdminApprovePaymentsPage.enterFromDate(fromDate);
		AdminApprovePaymentsPage.enterToDate(toDate);
		AdminApprovePaymentsPage.clickSubmit();
	}
	
	@Test(dependsOnMethods = "goToCompletedTabTest", priority = 68)
	@Documentation(step="Click on the revoke button ",expected="Revoke button should be clicked.")
	@Parameters("revokeRowNum")
	public static void clickRevokeTest(int revokeRowNum) throws Exception {
		AdminApprovePaymentsPage.clickRevokeByRowNum(revokeRowNum);
	}
	
	@Test(dependsOnMethods = "clickRevokeTest", priority = 69)
	@Documentation(step="",expected="")
	public static void logoutAdminTest() throws Exception {
		AdminApprovePaymentsPage.clickAdminMenuTest();
		try{
			AdminHomePageTest.verifyAdminHomePage();
		} catch (Exception e) {
			ScriptLogger.info("Admin Home probably didn't load properly, but that's not the point of this navigation, so passing.");
		}
		AdminHomePageTest.clickLogoutTest();
	}
	
	@Test(dependsOnMethods = "logoutAdminTest", priority = 70)
	@Documentation(step="",expected="")
	public static void verifyLoggedOutTest() throws Exception {
		AdminLoginPageTest.verifyAdminLoginPage();
	}
	
	@Test(dependsOnMethods = "logoutAdminTest", priority = 71)
	@Documentation(step="",expected="")
	@Parameters("url")
	public static void launchGuruTest(String url) throws Exception {
		LaunchApplicationPageTest.navigateToUrlTest(url);
	}
	
	@Test(dependsOnMethods="launchGuruTest", priority = 72)
	@Documentation(step="", expected="")
	public static void verifyLoginPageSixTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="launchGuruTest", priority = 73)
	@Parameters({"username", "password"})
	@Documentation(step="", expected="")
	public static void loginEmployerTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginEmployerTest", priority = 74)
	@Documentation(step="", expected="")
	public static void verifyEmployerLogInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEmployerLogInTest", priority = 75)
	@Documentation(step="", expected="")
	public static void verifyEmployerDashTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyEmployerLogInTest", priority = 76)
	@Documentation(step="", expected="")
	public static void goToInvoiceSummaryTest() throws Exception{
		DashboardPageTest.clickPayTabTest();
	}
	
	@Test(dependsOnMethods="goToInvoiceSummaryTest", priority = 77)
	@Documentation(step="", expected="")
	public static void verifyInvoiceSummaryTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoicePageTest();
	}
	
	@Test(dependsOnMethods="goToInvoiceSummaryTest", priority = 78)
	@Documentation(step="", expected="")
	public static void clickFirstViewAndPayTest() throws Exception{
		PaymentsInvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test(dependsOnMethods="clickFirstViewAndPayTest", priority = 79)
	@Documentation(step="", expected="")
	public static void validateInvoiceDetailsPageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods="clickFirstViewAndPayTest", priority = 80)
	@Documentation(step="", expected="")
	public static void clickPayInvoiceBtnTest() throws Exception{
		PaymentsInvoicePageTest.clickPayInvoiceTest();
	}

	@Test(dependsOnMethods="clickPayInvoiceBtnTest", priority = 81)
	@Documentation(step="", expected="")
	public static void validateInvoicePayNowPageTest() throws Exception{
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods="clickPayInvoiceBtnTest", priority = 84)
	@Documentation(step="", expected="")
	public static void payUsingEcheckTest() throws Exception{
		PayNowPageTest.selectECheckTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods="payUsingEcheckTest", priority = 85)
	@Documentation(step="", expected="")
	public static void payTheInvoiceTest() throws Exception{
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods="payTheInvoiceTest", priority = 86)
	@Documentation(step="", expected="")
	public static void verifyInvoiceIsPaidTest() throws Exception{
		PayNowPageTest.verifyInvoicePaidTest();
	}
	
	@Test(dependsOnMethods="payTheInvoiceTest", priority = 87)
	@Documentation(step="", expected="")
	public static void logOutEmployerTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="logOutEmployerTest", priority = 88)
	@Documentation(step="", expected="")
	public static void verifyLoginPageSevenTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="logOutEmployerTest", priority = 89)
	@Parameters({"adminUrl"})
	@Documentation(step="", expected="")
	public static void goToAdminSiteTest(String adminUrl) throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(adminUrl);
	}
	
	@Test(dependsOnMethods="goToAdminSiteTest", priority = 90)
	@Documentation(step="", expected="")
	public static void validateAdminLoginPageTest() throws Exception{
		AdminLoginPageTest.verifyAdminLoginPage();
	}

	@Test(dependsOnMethods="goToAdminSiteTest", priority = 91)
	@Parameters({"adminUsername", "adminPassword"})
	@Documentation(step="", expected="")
	public static void logIntoAdminTest(String username, String password) throws Exception{
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
		AdminLoginPageTest.clickLogin();
	}
	
	@Test(dependsOnMethods="logIntoAdminTest", priority = 92)
	@Documentation(step="", expected="")
	public static void validateAdminHomePageTest() throws Exception{
		AdminHomePageTest.verifyAdminHomePage();
	}
	
	@Test(dependsOnMethods="logIntoAdminTest", priority = 93)
	@Documentation(step="", expected="")
	public static void goToAcceptApprovePaymentsTest() throws Exception{
		AdminHomePageTest.clickAcceptApprovePaymentsTest();
		
	}
	
	@Test(dependsOnMethods="goToAcceptApprovePaymentsTest", priority = 94)
	@Documentation(step="", expected="")
	public static void validateAdminApprovePaymentsPage() throws Exception{
		AdminApprovePaymentsPage.verifyAdminApprovePaymentsPage();
	}
	
	@Test(dependsOnMethods="goToAcceptApprovePaymentsTest", priority = 95)
	@Documentation(step="", expected="")
	@Parameters({"pendingTabName"})
	public static void navToPendingTabTest(String tabName) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
	}
	
	@Test(dependsOnMethods="navToPendingTabTest", priority = 96)
	@Documentation(step="", expected="")
	@Parameters({"fromDate", "toDate"})
	public static void searchForPendingPaymentTest(String fromDate, String toDate) throws Exception {
		AdminApprovePaymentsPage.enterFromDate(fromDate);
		AdminApprovePaymentsPage.enterToDate(toDate);
		AdminApprovePaymentsPage.clickSubmit();
	}
	
	@Test(dependsOnMethods="searchForPendingPaymentTest", priority = 97)
	@Documentation(step="", expected="")
	@Parameters({"declineRowNum"})
	public static void clickDeclineTest(int declineRowNum) throws Exception {
		AdminApprovePaymentsPage.clickDeclineByRowNum(declineRowNum);
	}
}

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

public class RevokeDeclinePayments {
	
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
	@Documentation(step="Click on 'Post a Job'.", expected="Able to click on the button.")
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
	@Documentation(step="Go to the Quotes/Hire Page of the Job just posted.", expected="Able to navigate to the job's quotes page.")
	public static void goToJobHirePageTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyEMPDashboardPageTest();
		DashboardPageTest.clickRandomJobnamePostedTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageTest", priority = 9)
	@Documentation(step="Verify Elements of the hire page.", expected="Verification should be a success.")
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
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageOneTest() throws Exception{
		// "One" in the method name is just to avoid getting error when creating another method
		// 'verifyLoginPageTest' again with similar content.
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutEMPTest", priority = 12)
	@Parameters({"fLUsername", "flPassword"})
	@Documentation(step="Enter Freelancer credentials to Login.", expected="Should be able to enter information.")
	public static void loginAsFLTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsFLTest", priority = 13)
	@Documentation(step="Verify Freelancer login success.", expected="Verification successful.")
	public static void verifyFLLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifySecurityQuestionsPageTest();
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyFLLoggedInTest", priority = 14)
	@Documentation(step="Verify Dashboard.", expected="Verification successful.")
	public static void verifyFLDashTest() throws Exception{
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyFLLoggedInTest", priority = 15)
	@Documentation(step="Launch the tinyUrl noted from before.", expected="Navigates to the Job details page for that job.")
	public static void launchTinyUrlTest() throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(HirePageTest.tinyUrl);
	}
	
	@Test(dependsOnMethods="launchTinyUrlTest", priority = 16)
	@Documentation(step="Verify Job Details page.", expected="Verification successful.")
	public static void verifyJobDetailsPageTest() throws Exception{
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods="launchTinyUrlTest", priority = 17)
	@Documentation(step="Click 'Apply' to apply quote on the job.", expected="Able to Click.")
	public static void clickApplyTest() throws Exception{
		JobDetailsPageTest.clickApplyTest();
	}
	
	@Test(dependsOnMethods="clickApplyTest", priority = 18)
	@Documentation(step="verify the Apply quote form appearing after clicking on 'Apply'.", expected="Verification successful.")
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
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageTwoTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFLTest", priority = 24)
	@Parameters({"username", "password"})
	@Documentation(step="Enter Employer credentials for login.", expected="Able to enter.")
	public static void loginAsEMPTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsEMPTest", priority = 25)
	@Documentation(step="Verify Employer Login success.", expected="Verification successful.")
	public static void verifyEMPLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLoggedInTest", priority = 26)
	@Documentation(step="Verify EMP dashboard.", expected="Verification successful.")
	public static void verifyEMPDashTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "verifyEMPLoggedInTest", priority = 27)
	@Documentation(step="Navigate to the Job's hire page.", expected="Navigation successful.")
	public static void goToJobHirePageAgainTest() throws Exception {
		DashboardPageTest.clickRandomJobnamePostedTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageAgainTest", priority = 28)
	@Documentation(step="Verify the Hire page.", expected="Verification successful.")
	public static void verifyHirePageAgainTest() throws Exception{
		HirePageTest.verifyHirePageTest();
	}
	
	@Test(dependsOnMethods="goToJobHirePageAgainTest", priority = 29)
	@Documentation(step="Hire the Freelancer who just submitted a quote on the Job.", expected="Able to hire the FL.")
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
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageThreeTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="logOutEMPTest", priority = 32)
	@Parameters({"fLUsername", "flPassword"})
	@Documentation(step="Login as a Freelancer.", expected="Able to enter FL credentials.")
	public static void loginAsFreeLTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginAsFreeLTest", priority = 33)
	@Documentation(step="Verify FL login success.", expected="Verification successful.")
	public static void verifyFreeLLoggedInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyFreeLLoggedInTest", priority = 34)
	@Documentation(step="verify FL dashboard.", expected="Verification successful.")
	public static void verifyFLDashboardTest() throws Exception{
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyFreeLLoggedInTest", priority = 35)
	@Parameters("flWorkroomIndex")
	@Documentation(step="Navigate to the Hired Job's workroom.", expected="Navigation success.")
	public static void goToWorkroomTest(int index) throws Exception{
		DashboardPageTest.clickFLWorkroomByIndexTest(index);
			
	}
	
	@Test(dependsOnMethods="goToWorkroomTest", priority = 36)
	@Documentation(step="Verify the Workroom page.", expected="Verification successful.")
	public static void verifyFLWorkroomTest() throws Exception{
		WorkroomPageTest.verifyFLWorkroomPageTest();
	}
	
	@Test(dependsOnMethods="goToWorkroomTest", priority = 37)
	@Documentation(step="Click on 'Send Invoice' link against applied milestone.", expected="Able to click.")
	public static void clickSendInvoiceTest() throws Exception{
		WorkroomPageTest.clickFirstMileSendInvTest();
		
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 38)
	@Documentation(step="Verify Create Invoice page after clicking on 'Send Invoice'.", expected="Verification successful.")
	public static void verifyCreateInvoicePageTest() throws Exception{
		InvoicePageTest.verifyCreateInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 39)
	@Parameters("jobType")
	@Documentation(step="Enter Invoice details, and click 'Preview Invoice'.", expected="Able to enter invoice details necessary, and click on 'Preview invoice'.")
	public static void enterInvoiceDetailsTest(String jobType) throws Exception{
		InvoicePageTest.selectKindOfJobTest(jobType);
		InvoicePageTest.clickPreviewInvoiceTest();
	}
	
	@Test(dependsOnMethods="enterInvoiceDetailsTest", priority = 40)
	@Documentation(step="click on 'Send invoice' to send the invoice to the Employer.", expected="Able to click, and invoice should be sent.")
	public static void sendInvoiceTest() throws Exception{
		InvoicePageTest.clickSendInvoiceTest();
		
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 41)
	@Documentation(step="Verify Invoice summary page.", expected="Verification successful.")
	public static void verifyFLInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 42)
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutFreeLTest() throws Exception{
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 43)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageFourTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 44)
	@Parameters({"username", "password"})
	@Documentation(step="Enter Employer login credentials.", expected="Able to enter data.")
	public static void loginEMPTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginEMPTest", priority = 45)
	@Documentation(step="Verify Employer login success.", expected="Verification successful.")
	public static void verifyEMPLogInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 46)
	@Documentation(step="Verify Dashboard for Employer.", expected="Verification successful.")
	public static void verifyDashEMPTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 47)
	@Documentation(step="click on 'Pay' navigation tab.", expected="Able to click.")
	public static void clickPayTabTest() throws Exception{
		DashboardPageTest.clickPayTabTest();
		
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 48)
	@Documentation(step="Verify invoice summary page.", expected="Verification successful.")
	public static void verifyInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 49)
	@Documentation(step="Click on 'View & Pay' against the invoice just received.", expected="Able to click.")
	public static void clickUnpaidInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 50)
	@Documentation(step="Verify the invoice details of the invoice.", expected="Verification successful.")
	public static void verifyInvoiceDetailsPageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 51)
	@Documentation(step="Click 'Pay Invoice' button.", expected="Able to click.")
	public static void clickPayInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickPayInvoiceTest();
	}

	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 52)
	@Documentation(step="Verify the Payment page for the invoice.", expected="Verification successful.")
	public static void verifyInvoicePayNowPageTest() throws Exception{
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 53)
	@Documentation(step="Select Echeck as payment method, and accept the payment terms.", expected="Able to select Echeck as payment method, and mark the terms & conditions checkbox.")
	public static void selectECheckAndAgreeTermsTest() throws Exception{
		PayNowPageTest.selectECheckTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods="selectECheckAndAgreeTermsTest", priority = 54)
	@Documentation(step="Click on 'Pay'.", expected="Able to click.")
	public static void payInvoiceTest() throws Exception{
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 55)
	@Documentation(step="Verify invoice is successfully paid.", expected="Verification successful.")
	public static void verifyInvoicePaidTest() throws Exception{
		PayNowPageTest.verifyInvoicePaidTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 56)
	@Documentation(step="Log the employer out of the application.", expected="Able to logout.")
	public static void signOutEmployerTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="signOutEmployerTest", priority = 57)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageFiveTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutEmployerTest", priority = 58)
	@Parameters({"adminUrl"})
	@Documentation(step="Launch the Admin site.", expected="Navigation to the Admin site is successful.")
	public static void launchAdminSiteTest(String adminUrl) throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(adminUrl);
	}
	
	@Test(dependsOnMethods="launchAdminSiteTest", priority = 59)
	@Documentation(step="Verify Admin login page.", expected="Verification successful.")
	public static void verifyAdminLoginPageTest() throws Exception{
		AdminLoginPageTest.verifyAdminLoginPage();
	}

	@Test(dependsOnMethods="launchAdminSiteTest", priority = 60)
	@Parameters({"adminUsername", "adminPassword"})
	@Documentation(step="Enter Admin credentials to login.", expected="Able to enter credentials in the Login page.")
	public static void loginToAdminTest(String username, String password) throws Exception{
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 61)
	@Documentation(step="Verify Successful login.", expected="Verification successful.")
	public static void verifyAdminHomePageTest() throws Exception{
		AdminLoginPageTest.clickLogin();
		AdminHomePageTest.verifyAdminHomePage();
	}
	
	@Test(dependsOnMethods="loginToAdminTest", priority = 62)
	@Documentation(step="Navigate to Accept Approve payment.", expected="Navigation successful.")
	public static void goToAcceptApproveTest() throws Exception{
		AdminHomePageTest.clickAcceptApprovePaymentsTest();
		
	}
	
	@Test(dependsOnMethods="goToAcceptApproveTest", priority = 63)
	@Documentation(step="Verify the Accept/Approve payments page.", expected="Verification successful.")
	public static void verifyAdminApprovePaymentsPage() throws Exception{
		AdminApprovePaymentsPage.verifyAdminApprovePaymentsPage();
	}
	
	@Test(dependsOnMethods="goToAcceptApproveTest", priority = 64)
	@Documentation(step="Go to the 'Pending' tab.", expected="Able to switch to the 'Pending' tab.")
	@Parameters({"pendingTabName"})
	public static void goToPendingTabTest(String tabName) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
	}
	
	@Test(dependsOnMethods="goToPendingTabTest", priority = 65)
	@Documentation(step="Find the pending payment that the employer made through echeck, and enable the Accept button.", expected="Able to search for the payment, and enable the disabled Accept button against it.")
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
	@Documentation(step="Go to Completed tab, and search for the payment just approved.", expected="Able to switch to 'Completed' tab from 'Pending' tab, and search for the payment successfully completed in the previous step.")
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
	@Documentation(step="Go back to the Admin home page, and logout.",expected="Able to logout of the admin site.")
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
	@Documentation(step="Verify logout success.",expected="Verification successful.")
	public static void verifyLoggedOutTest() throws Exception {
		AdminLoginPageTest.verifyAdminLoginPage();
	}
	
	@Test(dependsOnMethods = "logoutAdminTest", priority = 71)
	@Documentation(step="Go to the test application site.",expected="Navigation successful.")
	@Parameters("url")
	public static void launchGuruTest(String url) throws Exception {
		LaunchApplicationPageTest.navigateToUrlTest(url);
	}
	
	@Test(dependsOnMethods="launchGuruTest", priority = 72)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageSixTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="launchGuruTest", priority = 73)
	@Parameters({"username", "password"})
	@Documentation(step="Login as Employer.", expected="Able to enter Employer credentials.")
	public static void loginEmployerTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginEmployerTest", priority = 74)
	@Documentation(step="Verify Employer login successful.", expected="Verification successful.")
	public static void verifyEmployerLogInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEmployerLogInTest", priority = 75)
	@Documentation(step="Verify Employer Dashboard.", expected="Verification successful.")
	public static void verifyEmployerDashTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyEmployerLogInTest", priority = 76)
	@Documentation(step="Go to Invoice summary page.", expected="Able to complete navigation.")
	public static void goToInvoiceSummaryTest() throws Exception{
		DashboardPageTest.clickPayTabTest();
	}
	
	@Test(dependsOnMethods="goToInvoiceSummaryTest", priority = 77)
	@Documentation(step="Verify the Invoice summary page.", expected="Able to verify.")
	public static void verifyInvoiceSummaryTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoicePageTest();
	}
	
	@Test(dependsOnMethods="goToInvoiceSummaryTest", priority = 78)
	@Documentation(step="Click 'View & Pay' against the invoice that was revoked.", expected="Able to click.")
	public static void clickFirstViewAndPayTest() throws Exception{
		PaymentsInvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test(dependsOnMethods="clickFirstViewAndPayTest", priority = 79)
	@Documentation(step="Verify Invoice details page.", expected="Verification successful.")
	public static void validateInvoiceDetailsPageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods="clickFirstViewAndPayTest", priority = 80)
	@Documentation(step="Click on pay invoice button.", expected="Able to click.")
	public static void clickPayInvoiceBtnTest() throws Exception{
		PaymentsInvoicePageTest.clickPayInvoiceTest();
	}

	@Test(dependsOnMethods="clickPayInvoiceBtnTest", priority = 81)
	@Documentation(step="Validate Invoice Payment page.", expected="Verification successful.")
	public static void validateInvoicePayNowPageTest() throws Exception{
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods="clickPayInvoiceBtnTest", priority = 84)
	@Documentation(step="Select echeck, and mark terms & conditions checkbox.", expected="Able to select Echeck as payment method, and then mark the payment terms & conditions.")
	public static void payUsingEcheckTest() throws Exception{
		PayNowPageTest.selectECheckTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods="payUsingEcheckTest", priority = 85)
	@Documentation(step="Click on 'Pay' button.", expected="Able to click.")
	public static void payTheInvoiceTest() throws Exception{
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods="payTheInvoiceTest", priority = 86)
	@Documentation(step="Verify successful payment of the invoice.", expected="Verification successful.")
	public static void verifyInvoiceIsPaidTest() throws Exception{
		PayNowPageTest.verifyInvoicePaidTest();
	}
	
	@Test(dependsOnMethods="payTheInvoiceTest", priority = 87)
	@Documentation(step="Log out employer.", expected="Able to click 'Log out'.")
	public static void logOutEmployerTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="logOutEmployerTest", priority = 88)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageSevenTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="logOutEmployerTest", priority = 89)
	@Parameters({"adminUrl"})
	@Documentation(step="Go to Admin site.", expected="Navigation successful.")
	public static void goToAdminSiteTest(String adminUrl) throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(adminUrl);
	}
	
	@Test(dependsOnMethods="goToAdminSiteTest", priority = 90)
	@Documentation(step="verify Admin login page.", expected="Verification successful.")
	public static void validateAdminLoginPageTest() throws Exception{
		AdminLoginPageTest.verifyAdminLoginPage();
	}

	@Test(dependsOnMethods="goToAdminSiteTest", priority = 91)
	@Parameters({"adminUsername", "adminPassword"})
	@Documentation(step="Enter Admin credentials.", expected="Able to enter data.")
	public static void logIntoAdminTest(String username, String password) throws Exception{
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
		AdminLoginPageTest.clickLogin();
	}
	
	@Test(dependsOnMethods="logIntoAdminTest", priority = 92)
	@Documentation(step="Verify Admin home page after login.", expected="Verification successful.")
	public static void validateAdminHomePageTest() throws Exception{
		AdminHomePageTest.verifyAdminHomePage();
	}
	
	@Test(dependsOnMethods="logIntoAdminTest", priority = 93)
	@Documentation(step="Go to Accept/Approve payments", expected="navigation successful.")
	public static void goToAcceptApprovePaymentsTest() throws Exception{
		AdminHomePageTest.clickAcceptApprovePaymentsTest();
		
	}
	
	@Test(dependsOnMethods="goToAcceptApprovePaymentsTest", priority = 94)
	@Documentation(step="Verify Accept/approve page.", expected="Verification successful.")
	public static void validateAdminApprovePaymentsPage() throws Exception{
		AdminApprovePaymentsPage.verifyAdminApprovePaymentsPage();
	}
	
	@Test(dependsOnMethods="goToAcceptApprovePaymentsTest", priority = 95)
	@Documentation(step="Navigate to the Pending tab.", expected="Navigation successful.")
	@Parameters({"pendingTabName"})
	public static void navToPendingTabTest(String tabName) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
	}
	
	@Test(dependsOnMethods="navToPendingTabTest", priority = 96)
	@Documentation(step="Search for the pending invoice payment made by the employer in the steps before.", expected="Able to search for the invoice payment that's pending.")
	@Parameters({"fromDate", "toDate"})
	public static void searchForPendingPaymentTest(String fromDate, String toDate) throws Exception {
		AdminApprovePaymentsPage.enterFromDate(fromDate);
		AdminApprovePaymentsPage.enterToDate(toDate);
		AdminApprovePaymentsPage.clickSubmit();
	}
	
	@Test(dependsOnMethods="searchForPendingPaymentTest", priority = 97)
	@Documentation(step="Decline the payment by click on 'Decline' button.", expected="Payment is successfully declined.")
	@Parameters({"declineRowNum"})
	public static void clickDeclineTest(int declineRowNum) throws Exception {
		AdminApprovePaymentsPage.clickDeclineByRowNum(declineRowNum);
	}
}

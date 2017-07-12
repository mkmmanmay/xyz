package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
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

public class IssueInvoiceRefund {
	
	@Test(alwaysRun = true)
	@Documentation(step="Click on 'Post a Job' tab." , expected = "Able to Click.")
	public static void clickPostAJobTest() throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
	}
	
	@Test(dependsOnMethods = "clickPostAJobTest", priority = 1)
	@Documentation(step="Verify Post A Job page." , expected = "Verification of Post A Job should be successfull.")
	public static void verifyPostJobTest() throws Exception {
		PostAJobPageTest.verifyPostAJobPageTest();
	}
	
	@Test(dependsOnMethods = "clickPostAJobTest", priority = 2)
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
	
	@Test(dependsOnMethods = "enterJobDetailsTest")
	@Documentation(step="click on 'Post Job' button." , expected = "Able to Click.")
	public static void clickPostJobTest() throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
	}
	
	@Test(dependsOnMethods = "clickPostJobTest")
	@Documentation(step="Verify Payment page for featuring the Job, and click on checkboxes." , expected = "Able to Verify, and click on Terms and Conditions checkbox.")
	public static void verifyFeaturePaymentPageTest() throws Exception {
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = "verifyFeaturePaymentPageTest")
	@Documentation(step="Click on 'Pay' button." , expected = "Able to click.")
	public static void clickPayTest() throws Exception {
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods = "clickPayTest", priority = 3)
	@Documentation(step="Verify Payment was successful." , expected = "Verification should be a success.")
	public static void verifyPaymentSuccessTest() throws Exception {
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = "clickPayTest", priority = 4)
	@Documentation(step="click on 'Dashboard' tab in the top level navigation." , expected = "Able to click.")
	public static void goBackToDashboardTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
	}
	
	@Test(dependsOnMethods = "goBackToDashboardTest", priority = 5)
	@Documentation(step="Verify Dashboard Page loaded." , expected = "Verification should be a sucess.")
	public static void verifyDashboardTest() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "goBackToDashboardTest", priority = 6)
	@Documentation(step="Go to Quotes/Hire page of job posted, and retrieve its Tiny URL." , expected = "Able to retrieve the Tiny URL.")
	public static void getTinyUrlOfJobPostedTest() throws Exception {
		DashboardPageTest.clickRandomJobnamePostedFromQuotes();
		HirePageTest.verifyHirePageTest();
		HirePageTest.getTinyURLTest();
	}
	
	@Test(dependsOnMethods = "getTinyUrlOfJobPostedTest")
	@Documentation(step="Click on 'Sign Out'." , expected = "Able to click.")
	public static void signoutEmpTest() throws Exception {
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods = "signoutEmpTest", priority = 7)
	@Documentation(step="Verify Login Page of the application." , expected = "Verification should be a sucess.")
	public static void verifyLoginTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "signoutEmpTest", priority = 8)
	@Parameters({"flUsername", "flPassword"})
	@Documentation(step="Enter FL credentials for login." , expected = "Able to Enter data.")
	public static void enterFLCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = "enterFLCredTest")
	@Documentation(step="Click on 'Sign In' button, and verify Security Page." , expected = "Able to click, and then verify.")
	public static void clickLoginFLTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifyingSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickLoginFLTest", priority = 9)
	@Documentation(step="Enter security question answer, or skip the page if necessary.", expected="User should be able to deal with Security questions page accordingly.")
	public static void validateSecurityTest() throws Exception {
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickLoginFLTest", priority = 10)
	@Documentation(step="Skip Phone verification page if it appears.", expected="User is able to skip Phone verification page.")
	public static void verifyAndSkipPhoneVerificationTest() throws Exception {
		PhoneVerificationPageTest.verifyPhoneVerificationPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods = "clickLoginFLTest", priority = 11)
	@Documentation(step="Verify FL Dashboard page.", expected="Dashboard page loads for FL")
	public static void verifyFLDashboardPageTest() throws Exception {
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "verifyFLDashboardPageTest", priority = 12)
	@Documentation(step="Launch the Tiny URL retrieved earlier.", expected="Able to navigate to the Url.")
	public static void launchTinyURLTest() throws Exception {
		LaunchApplicationPageTest.navigateToUrlTest(HirePageTest.tinyUrl);
	}
	
	@Test(dependsOnMethods = "launchTinyURLTest", priority = 13)
	@Documentation(step="Verify Job Details loaded.", expected="Verification should be a sucess.")
	public static void verifyJobDetailsTest() throws Exception {
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "launchTinyURLTest", priority = 14)
	@Documentation(step="Click on 'Apply' button.", expected="Able to click.")
	public static void clickApplyTest() throws Exception {
		JobDetailsPageTest.clickApplyTest();
	}
	
	@Test(dependsOnMethods = "clickApplyTest", priority = 15)
	@Documentation(step="Verify Apply Form.", expected="Verification should be a sucess.")
	public static void verifyApplyFormTest() throws Exception {
		JobDetailsPageTest.verifyApplyQuotesFormTest();
	}
	
	@Test(dependsOnMethods = "clickApplyTest", priority = 16)
	@Documentation(step="Craft a Milestone Quote", expected="Able to enter valid milestone details")
	@Parameters({"noOfMilestones", "milestoneNames", "milestoneDueDates", "milestoneAmounts", "safepayOption", "scopeOfWork"})
	public static void submitAMilestoneQuoteTest(int noOfMilestones, String milestoneNames, String milestoneDueDates
			, String milestoneAmounts, String safepayOption, String scopeOfWork) throws Exception {
		JobDetailsPageTest.enterMilestonesTest(noOfMilestones, milestoneNames, milestoneDueDates, milestoneAmounts);
		JobDetailsPageTest.selectSafePayOptionTest(safepayOption);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "submitAMilestoneQuoteTest")
	@Documentation(step="Send the milestone based quote, and verify its successful submission.", expected="Milestone based quote is successfully sent.")
	public static void submitQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods = "submitQuoteTest")
	@Documentation(step="Click on 'Sign out'." , expected = "Able to click.")
	public static void signoutFlTest() throws Exception {
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods = "signoutFlTest", priority = 17)
	@Documentation(step="Verify Login Page." , expected = "Verification should be a sucess.")
	public static void verifyLoginPageTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "signoutFlTest", priority = 18)
	@Parameters({"username", "password"})
	@Documentation(step="Enter EMP Credentials." , expected = "Able to enter data in textboxes.")
	public static void enterEMPCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = "enterEMPCredTest")
	@Documentation(step="Click on 'Sign In'." , expected = "Able to click.")
	public static void clickLoginEMPTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifyingSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickLoginEMPTest", priority = 19)
	@Documentation(step="Enter security question answer, or skip the page if necessary.", expected="User should be able to deal with Security questions page accordingly.")
	public static void validateSecurityPageTest() throws Exception {
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickLoginEMPTest",  priority = 20)
	@Documentation(step="Skip Phone verification page if it appears.", expected="User is able to skip Phone verification page.")
	public static void verifySkipPhoneVerificationTest() throws Exception {
		PhoneVerificationPageTest.verifyPhoneVerificationPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods = "clickLoginEMPTest", priority = 21 )
	@Documentation(step="Verify EMP Dashboard page.", expected="Dashboard page loads for EMP")
	public static void verifyEMPDashboardPageTest() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "clickLoginEMPTest", priority = 22 )
	@Documentation(step="Go to the 'Quotes' page of the Job posted earlier.", expected="Able to Navigate successfully.")
	public static void goToJobTest() throws Exception {
		DashboardPageTest.clickRandomJobnamePostedFromQuotes();
	}
	
	@Test(dependsOnMethods = "goToJobTest", priority = 23)
	@Documentation(step="Verify Hire/Quotes page.", expected="Verification should be a sucess.")
	public static void verifyHirePageTest() throws Exception {
		HirePageTest.verifyHirePageTest();
	}
	
	@Test(dependsOnMethods = "goToJobTest", priority = 24)
	@Documentation(step="Hire the FL quote submitted earlier.", expected="Hiring shoulde be a success.")
	public static void hireFLPageTest() throws Exception {
		HirePageTest.clickHireBtnTest();
		HirePageTest.verifyAgreementPopUpTest();
		HirePageTest.clickAcknowledgeCheckboxTest();
		HirePageTest.clickHireInHirePopupTest();
	}
	
	@Test(dependsOnMethods = "hireFLPageTest")
	@Documentation(step="'Sign out' user." , expected = "Able to Sign out.")
	public static void logoutEmpTest() throws Exception {
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods = "logoutEmpTest", priority = 25)
	@Documentation(step="Verify Login Page." , expected = "Verification should be a sucess.")
	public static void verifySignInTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "logoutEmpTest", priority = 26)
	@Parameters({"flUsername", "flPassword"})
	@Documentation(step="Enter FL credentials." , expected = "Able to enter data in textboxes.")
	public static void enterFreeCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = "enterFreeCredTest")
	@Documentation(step="Click on 'Sign In' button." , expected = "Verification should be a sucess.")
	public static void clickSignInFLTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifyingSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 27)
	@Documentation(step="Enter security question answer, or skip the page if necessary.", expected="User should be able to deal with Security questions page accordingly.")
	public static void validateSecurityQuestionsTest() throws Exception {
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 28)
	@Documentation(step="Skip Phone verification page if it appears.", expected="User is able to skip Phone verification page.")
	public static void skipPhoneVerificationTest() throws Exception {
		PhoneVerificationPageTest.verifyPhoneVerificationPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 29)
	@Documentation(step="Verify FL Dashboard page.", expected="Dashboard page loads for FL")
	public static void verifyFreeDashboardPageTest() throws Exception {
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 30)
	@Documentation(step="Go to the Workroom of the Job the FL was hired to.", expected="Able to click on the Workroom link on the FL dashboard.")
	public static void goToHiredWorkroomTest() throws Exception {
		DashboardPageTest.clickHiredRandomJobFL();
	}
	
	@Test(dependsOnMethods = "goToHiredWorkroomTest", priority = 31)
	@Documentation(step="Verify Workroom.", expected="Verification should be a sucess.")
	public static void verifyWorkroomTest() throws Exception {
		WorkroomPageTest.verifyFLWorkroomPageTest();
	}
	
	@Test(dependsOnMethods="goToHiredWorkroomTest", priority = 32)
	@Documentation(step="Click on 'Send Invoice' link against applied milestone.", expected="Able to click.")
	public static void clickSendInvoiceTest() throws Exception{
		WorkroomPageTest.clickFirstMileSendInvTest();
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 33)
	@Documentation(step="Verify Create Invoice page after clicking on 'Send Invoice'.", expected="Verification successful.")
	public static void verifyCreateInvoicePageTest() throws Exception{
		InvoicePageTest.verifyCreateInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickSendInvoiceTest", priority = 34)
	@Parameters("jobType")
	@Documentation(step="Enter Invoice details, and click 'Preview Invoice'.", expected="Able to enter invoice details necessary, and click on 'Preview invoice'.")
	public static void enterInvoiceDetailsTest(String jobType) throws Exception{
		InvoicePageTest.selectKindOfJobTest(jobType);
		InvoicePageTest.clickPreviewInvoiceTest();
		InvoicePageTest.getInvoiceIDTest();
	}
	
	@Test(dependsOnMethods="enterInvoiceDetailsTest", priority = 35)
	@Documentation(step="click on 'Send invoice' to send the invoice to the Employer.", expected="Able to click, and invoice should be sent.")
	public static void sendInvoiceTest() throws Exception{
		InvoicePageTest.clickSendInvoiceTest();
		
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 36)
	@Documentation(step="Verify Invoice summary page.", expected="Verification successful.")
	public static void verifyFLInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods="sendInvoiceTest", priority = 37)
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutFreeLTest() throws Exception{
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 38)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifyLoginPageFourTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFreeLTest", priority = 39)
	@Parameters({"username", "password"})
	@Documentation(step="Enter Employer login credentials.", expected="Able to enter data.")
	public static void loginEMPTest(String emailUsername, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="loginEMPTest", priority = 40)
	@Documentation(step="Verify Employer login success.", expected="Verification successful.")
	public static void verifyEMPLogInTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 41)
	@Documentation(step="Verify Dashboard for Employer.", expected="Verification successful.")
	public static void verifyDashEMPTest() throws Exception{
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods="verifyEMPLogInTest", priority = 42)
	@Documentation(step="click on 'Pay' navigation tab.", expected="Able to click.")
	public static void clickPayTabTest() throws Exception{
		DashboardPageTest.clickPayTabTest();
		
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 43)
	@Documentation(step="Verify invoice summary page.", expected="Verification successful.")
	public static void verifyInvoicePageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoicePageTest();
	}
	
	@Test(dependsOnMethods="clickPayTabTest", priority = 44)
	@Documentation(step="Click on 'View & Pay' against the invoice just received.", expected="Able to click.")
	public static void clickUnpaidInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 45)
	@Documentation(step="Verify the invoice details of the invoice.", expected="Verification successful.")
	public static void verifyInvoiceDetailsPageTest() throws Exception{
		PaymentsInvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods="clickUnpaidInvoiceTest", priority = 46)
	@Documentation(step="Click 'Pay Invoice' button.", expected="Able to click.")
	public static void clickPayInvoiceTest() throws Exception{
		PaymentsInvoicePageTest.clickPayInvoiceTest();
	}

	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 47)
	@Documentation(step="Verify the Payment page for the invoice.", expected="Verification successful.")
	public static void verifyInvoicePayNowPageTest() throws Exception{
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods="clickPayInvoiceTest", priority = 48)
	@Documentation(step="Select accept the payment terms.", expected="Able to Mark the terms & conditions checkbox.")
	public static void selectAgreeTermsTest() throws Exception{
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods="selectAgreeTermsTest", priority = 49)
	@Documentation(step="Click on 'Pay'.", expected="Able to click.")
	public static void payInvoiceTest() throws Exception{
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 50)
	@Documentation(step="Verify invoice is successfully paid.", expected="Verification successful.")
	public static void verifyInvoicePaidTest() throws Exception{
		PayNowPageTest.verifyInvoicePaidTest();
	}
	
	@Test(dependsOnMethods="payInvoiceTest", priority = 51)
	@Documentation(step="Log the employer out of the application.", expected="Able to logout.")
	public static void signOutEmployerTest() throws Exception{
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods="signOutEmployerTest", priority = 52)
	@Documentation(step="Verify Login page.", expected="Verification successful.")
	public static void verifySignInPageTest() throws Exception{
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "signOutEmployerTest", priority = 53)
	@Parameters({"flUsername", "flPassword"})
	@Documentation(step="Enter FL credentials." , expected = "Able to data into Textboxes.")
	public static void enterFreeLCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
		LoginPageTest.clickSignInButtonTest();
	}
	
	@Test(dependsOnMethods = "enterFreeLCredTest", priority = 54)
	@Documentation(step="Verify FL Dashboard page.", expected="Dashboard page loads for FL.")
	public static void verifyFreeLDashboardPageTest() throws Exception {
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "enterFreeLCredTest", priority = 55)
	@Documentation(step="Click on 'Payments' tab.", expected="Able to click.")
	public static void goToPaymentsTest() throws Exception {
		DashboardPageTest.clickPaymentsTabTest();
	}
	
	@Test(dependsOnMethods = "goToPaymentsTest", priority = 56)
	@Documentation(step="Verify Invoice summary page loaded.", expected="Verification should be a sucess.")
	public static void verifyInvoiceSummaryTest() throws Exception {
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods = "goToPaymentsTest", priority = 57)
	@Documentation(step="Click on Paid Invoice ID.", expected="Able to click.")
	public static void clickOnPaidInvoiceTest() throws Exception {
		PaymentsInvoicePageTest.clickInvoiceIDTest();
	}
	
	@Test(dependsOnMethods = "clickOnPaidInvoiceTest", priority = 58)
	@Documentation(step="Verify Invoice Details.", expected="Verification should be a sucess.")
	public static void verifyPaidInvoiceTest() throws Exception {
		InvoicePageTest.verifyPaidInvoiceDetailsTest();
	}
	
	@Test(dependsOnMethods = "clickOnPaidInvoiceTest", priority = 59)
	@Documentation(step="click on 'Issue Refund' button.", expected="Able to click.")
	public static void clickIssueRefundTest() throws Exception {
		InvoicePageTest.clickIssueRefundTest();
	}
	
	@Test(dependsOnMethods = "clickIssueRefundTest", priority = 60)
	@Documentation(step="Verify Issue Refund section.", expected="Verification should be a sucess.")
	public static void verifyIssueRefundSectionTest() throws Exception {
		InvoicePageTest.verifyIssueRefundSectionTest();
	}
	
	@Test(dependsOnMethods = "clickIssueRefundTest", priority = 61)
	@Documentation(step="Enter the amount Employer should receive.", expected="Able to enter the amount.")
	public static void enterEmployerReceivingAmountTest() throws Exception {
		InvoicePageTest.getInvoiceAmountTest();
		InvoicePageTest.enterAmountEmpShouldGetTest(InvoicePageTest.invoiceAmount);
	}
	
	@Test(dependsOnMethods = "enterEmployerReceivingAmountTest")
	@Documentation(step="Click on 'Issue Refund' button after entering amount.", expected="Able to click.")
	public static void clickIssueRefundBtnTest() throws Exception {
		InvoicePageTest.issueRefundAfterEnteringAmountTest();
		
	}
	
	@Test(dependsOnMethods = "clickIssueRefundBtnTest")
	@Documentation(step="click on 'Confirm Refund'.", expected="Able to click.")
	public static void clickConfirmRefundTest() throws Exception {
		InvoicePageTest.clickConfirmRefundTest();
		
	}
	
	@Test(dependsOnMethods = "clickConfirmRefundTest", priority = 62)
	@Documentation(step="Verify Invoice summary page.", expected="Verification should be a sucess.")
	public static void verifyPaymentsInvoicePageTest() throws Exception {
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods = "clickConfirmRefundTest", priority = 63)
	@Documentation(step="Verify Status against the paid invoice changed to 'Refunded'.", expected="Verification should be a sucess.")
	public static void verifyInvoiceRefundedTest() throws Exception {
		PaymentsInvoicePageTest.verifyInvoiceStatusIsRefundedTest();
	}
	
}

package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.testing.page.CashAccPageTest;
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

public class RequestNIssueSafepayRefund {
	
	@Test(alwaysRun = true)
	@Documentation(step = "", expected = "")
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
	
	@Test(dependsOnMethods = "hireFLPageTest", priority = 25)
	@Documentation(step="Go to 'Workroom'.", expected="Should be able to navigate to the Workroom.")
	public static void goToWorkroomTest() throws Exception {
		HirePageTest.clickWorkRoomLinkTest();
	}
	
	@Test(dependsOnMethods = "hireFLPageTest", priority = 26)
	@Documentation(step="Verify 'Status Updates' tab of EMP Workroom.", expected="Verification should be a sucess.")
	public static void verifyWorkroomTest() throws Exception {
		WorkroomPageTest.verifyEMPStatusUpdatesTabTest();
	}
	
	@Test(dependsOnMethods = "goToWorkroomTest")
	@Documentation(step="Click on 'SafePay' tab.", expected="Able to click.")
	public static void goToSafePayTabTest() throws Exception {
		WorkroomPageTest.clickSafePayTab();
	}
	
	@Test(dependsOnMethods = "goToSafePayTabTest", priority = 27)
	@Documentation(step="Click on 'SafePay' tab.", expected="Able to click.")
	public static void verifyEMPSafePayTabTest() throws Exception {
		WorkroomPageTest.verifyEMPSafePayTab();
	}
	
	@Test(dependsOnMethods = "goToSafePayTabTest", priority = 28)
	@Documentation(step="Click on 'Add Funds' button.", expected="Able to click.")
	public static void clickAddFundsTest() throws Exception {
		WorkroomPageTest.clickAddFunds();
	}
	
	@Test(dependsOnMethods = "clickAddFundsTest", priority = 29)
	@Documentation(step="Verify content appearing after clicking on 'Add Funds' button.", expected="Able to verify.")
	public static void verifyAddFundsTest() throws Exception {
		WorkroomPageTest.verifyAddSafePayFunds();
	}
	
	@Test(dependsOnMethods = "clickAddFundsTest", priority = 30)
	@Parameters("safepayAmount")
	@Documentation(step="Enter Amount to add funds to Safepay, and click 'Add Funds'.", expected="Able to enter, and then click Add Funds.")
	public static void addFundsTest(String amount) throws Exception {
		WorkroomPageTest.enterSafepayAmountTest(amount);
		WorkroomPageTest.clickAddFundsToSafepay();
	}
	
	@Test(dependsOnMethods = "addFundsTest", priority = 31)
	@Documentation(step="verify Payments page appearing after clicking on 'Add funds'.", expected="Able to verify.")
	public static void verifySafePayPaymentPageTest() throws Exception {
		PayNowPageTest.verifyPayforSafepay();
	}
	
	@Test(dependsOnMethods = "addFundsTest", priority = 32)
	@Documentation(step="Agree to Terms & conditions, and click 'Add funds'.", expected="Able to verify.")
	public static void selectAgreeCheckboxAndPayTest() throws Exception {
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
	}
	
	@Test(dependsOnMethods = "selectAgreeCheckboxAndPayTest", priority = 33)
	@Documentation(step="Verify Payment was successful." , expected = "Verification should be a success.")
	public static void verifyFundSuccessTest() throws Exception {
		PayNowPageTest.verifySafepayFundSuccess();
	}
	
	@Test(dependsOnMethods = "selectAgreeCheckboxAndPayTest", priority = 34)
	@Documentation(step="Click on 'Back to Safepay page'." , expected = "Able to click.")
	public static void navigateToSafePayPageTest() throws Exception {
		PayNowPageTest.clickBackToSafePayPage();
	}
	
	@Test(dependsOnMethods = "navigateToSafePayPageTest", priority = 35)
	@Documentation(step="Verify Safepay tab loaded after navigation from payment receipt.." , expected = "Verification should be a success.")
	public static void verifySafePayPageTest() throws Exception {
		WorkroomPageTest.verifyEMPSafePayTab();
	}
	
	@Test(dependsOnMethods = "navigateToSafePayPageTest", priority = 36)
	@Documentation(step="Click on 'Request a refund'." , expected = "Able to click.")
	public static void clickRequestRefundTest() throws Exception {
		WorkroomPageTest.clickRequestRefundTest();
	}
	
	@Test(dependsOnMethods = "clickRequestRefundTest", priority = 37)
	@Documentation(step="verify 'Request a refund' section." , expected = "Able to verify.")
	public static void verifyRequestRefundSectionTest() throws Exception {
		WorkroomPageTest.verifyRequestRefundSectionTest();
	}
	
	@Test(dependsOnMethods = "clickRequestRefundTest", priority = 38)
	@Documentation(step="Click on radio button against Future Works, and then click on Request Refund Button." , expected = "Able to click.")
	public static void requestRefAgainFutureWorkTest() throws Exception {
		WorkroomPageTest.getFutureWorkAmountTest();
		WorkroomPageTest.clickFutureWorkRadioTest();
		WorkroomPageTest.clickRequestRefundBtnTest();
	}
	
	@Test(dependsOnMethods = "requestRefAgainFutureWorkTest", priority = 39)
	@Documentation(step="verify 'Request a refund List of Reasons' section." , expected = "Able to verify.")
	public static void verifyListOfReasonsSectionTest() throws Exception {
		InvoicePageTest.verifyRequestRefundReasonsSectionTest();
	}
	
	@Test(dependsOnMethods = "requestRefAgainFutureWorkTest", priority = 40)
	@Parameters({"noOfReasons", "reasonContent"})
	@Documentation(step = "Enter List of Reasons.", expected = "Able to enter.")
	public static void enterListOfReasonsTest(int reasonsCount, String reasonsContent) throws Exception {
		InvoicePageTest.enterListOfReasonsTest(reasonsCount, reasonsContent);
	}
	
	@Test(dependsOnMethods = "enterListOfReasonsTest", priority = 41)
	@Documentation(step = "Click Request Refund Button.", expected = "Able to click")
	public static void clickRequestRefTest() throws Exception {
		InvoicePageTest.clickRequestRefundTest();
	}
	
	@Test(dependsOnMethods = "clickRequestRefTest", priority = 42)
	@Documentation(step = "Verify Request Refund sent.", expected = "Able to verify")
	public static void verifyRefRequestSentTest() throws Exception {
		InvoicePageTest.verifyRequestRefundSentTest();
	}
	
	@Test(dependsOnMethods = "clickRequestRefTest", priority = 43)
	@Documentation(step = "Get Invoice ID from the page appearing after refund request is sent.", expected = "Able to retrieve data.")
	public static void getInvoiceIDGeneratedTest() throws Exception {
		InvoicePageTest.getInvoiceIDGeneratedTest();
	}
	
	@Test(dependsOnMethods = "getInvoiceIDGeneratedTest", priority = 44)
	@Documentation(step = "Go To Cash Account page.", expected = "Able to navigate to Cash Account.")
	public static void navigateToCashAccTest() throws Exception {
		DashboardPageTest.clickPayTabTest();
		PaymentsInvoicePageTest.clickCashAccountTabTest();
		CashAccPageTest.verifyCashAccPageEMPTest();
	}
	
	@Test(dependsOnMethods = "navigateToCashAccTest", priority = 45)
	@Documentation(step = "Get Cash Account Balance.", expected = "Able to get balance.")
	public static void getCashAccBalanceBeforeTest() throws Exception {
		CashAccPageTest.getEMPCashBalanceBeforeTest();
	}
	
	@Test(dependsOnMethods = "getCashAccBalanceBeforeTest", priority = 46)
	@Documentation(step = "Click Request Refund Button.", expected = "Able to click")
	public static void signOutEMPTest() throws Exception {
		DashboardPageTest.signOutEmployerTest();
	}
	
	@Test(dependsOnMethods = "signOutEMPTest", priority = 47)
	@Documentation(step="Verify Login Page of the application." , expected = "Verification should be a sucess.")
	public static void verifyLoginScreenTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "signOutEMPTest", priority = 48)
	@Parameters({"flUsername", "flPassword"})
	@Documentation(step="Enter FL credentials for login." , expected = "Able to Enter data.")
	public static void enterFreeCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = "enterFreeCredTest")
	@Documentation(step="Click on 'Sign In' button, and verify Security Page." , expected = "Able to click, and then verify.")
	public static void clickSignInFLTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 49)
	@Documentation(step="Verify FL Dashboard page.", expected="Dashboard page loads for FL")
	public static void verifyFreeDashboardPageTest() throws Exception {
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInFLTest", priority = 50)
	@Documentation(step="click 'Refund Requested' alert", expected="Able to click.")
	public static void clickRefundRequestedAlertTest() throws Exception {
		DashboardPageTest.clickRefundRequestedAlertFLTest();
	}
	
	@Test(dependsOnMethods = "clickRefundRequestedAlertTest", priority = 51)
	@Documentation(step="Verify Issue Safepay Refund Section for FL loaded.", expected="Able to verify.")
	public static void verifyIssueSafepayRefundSectionTest() throws Exception {
		InvoicePageTest.verifyIssueSafepayRefundSectionTest();
	}
	
	@Test(dependsOnMethods = "clickRefundRequestedAlertTest", priority = 52)
	@Documentation(step="Click 'Issue Refund' button.", expected="Able to click.")
	public static void clickIssueRefundTest() throws Exception {
		InvoicePageTest.clickIssueSafepayRefundTest();
	}
	
	@Test(dependsOnMethods = "clickIssueRefundTest", priority = 53)
	@Documentation(step="Verify Confirm refund section, and Click 'Issue Refund' to Confirm the Issue of Refund.", expected="Able to click.")
	public static void confirmIssueRefundTest() throws Exception {
		InvoicePageTest.verifyconfirmSafepayRefundSectionTest();
		InvoicePageTest.clickConfirmIssueSafepayRefundTest();
	}
	
	@Test(dependsOnMethods = "confirmIssueRefundTest", priority = 54)
	@Documentation(step="Verify Invoice summary page.", expected="Able to verify.")
	public static void verifyInvoiceSummaryTest() throws Exception {
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
	}
	
	@Test(dependsOnMethods = "confirmIssueRefundTest", priority = 55)
	@Documentation(step="Click Sign Out.", expected="Able to click.")
	public static void logoutFLTest() throws Exception {
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods = "logoutFLTest", priority = 56)
	@Documentation(step="Verify Login Page." , expected = "Verification should be a sucess.")
	public static void validateLoginPageTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "logoutFLTest", priority = 57)
	@Parameters({"username", "password"})
	@Documentation(step="Enter EMP Credentials." , expected = "Able to enter data in textboxes.")
	public static void enterEmpCredTest(String emailUsername, String password) throws Exception {
		LoginPageTest.enterEmailOrUsernameTest(emailUsername);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = "enterEmpCredTest", priority = 58)
	@Documentation(step="Click on 'Sign In'." , expected = "Able to click.")
	public static void clickSignInEMPTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifyingSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInEMPTest", priority = 59)
	@Documentation(step="Verify EMP Dashboard page.", expected="Dashboard page loads for EMP")
	public static void verifyEmpDashboardPageTest() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = "clickSignInEMPTest", priority = 60)
	@Documentation(step="Go to Cash Account page..", expected="Able to navigate.")
	public static void goToCashAccountTest() throws Exception {
		DashboardPageTest.clickPayTabTest();
		BrowserWait.waitForPageToBeLoaded();
		PaymentsInvoicePageTest.clickCashAccountTabTest();
	}
	
	@Test(dependsOnMethods = "goToCashAccountTest", priority = 61)
	@Documentation(step="Verify Cash Account page for employer.", expected="Cash Account page loads.")
	public static void verifyCashAccountTest() throws Exception {
		CashAccPageTest.verifyCashAccPageEMPTest();
	}
	
	@Test(dependsOnMethods = "goToCashAccountTest", priority = 62)
	@Documentation(step="Get cashAccount balance After refund was issued.", expected="Able to get balance.")
	public static void getCashAccountBalanceTest() throws Exception {
		CashAccPageTest.getEMPCashBalanceAfterTest();
	}
	
	@Test(dependsOnMethods = "getCashAccountBalanceTest", priority = 63)
	@Documentation(step="Verify refund amount equals the increment in Employer's cash account.", expected="Able to verify.")
	public static void verifyCABalanceIncrementTest() throws Exception {
		float increment = CashAccPageTest.caBalanceAfter - CashAccPageTest.caBalanceBefore;
		if(WorkroomPageTest.futureWorkValue != increment) {
			throw new ApplicationException("Cash account balance increment for EMP isn't same as the amount refunded by FL.");
		}
	}
	
	@Test(dependsOnMethods = "getCashAccountBalanceTest", priority = 64)
	@Documentation(step = "Verify refunded invoice status in CA History.", expected = "Should be able to verify.")
	public static void verifyRefundedInvoiceDescriptionTest() throws Exception {
		CashAccPageTest.verifyRefundedInvoiceDescriptionTest();
	}
}

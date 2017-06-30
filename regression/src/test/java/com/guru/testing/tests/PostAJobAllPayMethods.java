package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.EMPPaymentPageTest;
import com.guru.testing.page.PayNowPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;
import com.guru.testing.page.PostAJobPageTest;

public class PostAJobAllPayMethods {
	
	@Test(alwaysRun = true)
	@Documentation(step="Navigate to Post a Job page.", expected="User is able to click on 'Post a Job' successfully.")
	public static void goToPostAJobPageTest() throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
	}
	
	@Test(dependsOnMethods = "goToPostAJobPageTest", priority = 1)
	@Documentation(step="verify Post a Job page.", expected="Verification successful.")
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
	
	@Test(dependsOnMethods = { "enterJobDetailsTest" })
	@Documentation(step="Complete Featuring Job using Cash Account funds.", expected="User is able to feature job using Cash Account funds.")
	public static void payUsingCATest() throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.clickUseCAfunds();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		
	}
	
	@Test(dependsOnMethods = { "payUsingCATest" })
	@Documentation(step="Verify Featuring Job payment using CA is successful", expected="User is able to feature job using Cash Account funds.")
	public static void verifyJobPostSuccessCATest() throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "verifyJobPostSuccessCATest" })
	@Parameters({"jobDetails", "category", "skill", "fixedBudget"})
	@Documentation(step="Go to Post a Job page again.", expected="User is able to navigate to Post a Job page.")
	public static void postJobCCTest(String jobDetails, String category,
			String skill, String budget) throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
		PostAJobPageTest.verifyPostAJobPageTest();
		PostAJobPageTest.enterRandomJobTitleTest();
		PostAJobPageTest.enterJobDescriptionTest(jobDetails);
		PostAJobPageTest.clickCategoryTest(category);
		PostAJobPageTest.enterKeywordsTest(skill);
		PostAJobPageTest.selectFixedPriceBudgetTest(budget);
		PostAJobPageTest.clickFeatureMyJobTest();
		
	}
	
	@Test(dependsOnMethods = { "postJobCCTest" })
	@Parameters({"cardNumber", "month", "year", "cvv", "address"})
	@Documentation(step="Complete Featuring Job by adding Credit card to the account.", expected="User is able to feature Job using Credit Card funds.")
	public static void payUsingCCTest(String cardNumber, String month, String year, String cvv, String address) throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.clickPayWithCCTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.enterStreetAddressTest(address);
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "payUsingCCTest" })
	@Documentation(step="Verify Featuring Job payment using CC is successful", expected="User is able to feature job using Credit Card.")
	public static void verifyJobPostSuccessCCTest() throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "verifyJobPostSuccessCCTest" })
	@Parameters({"jobDetails", "category", "skill", "fixedBudget"})
	@Documentation(step="Go to Post a Job page again.", expected="User is able to navigate to Post a Job page.")
	public static void postJobPaypalTest(String jobDetails, String category,
			String skill, String budget) throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
		PostAJobPageTest.verifyPostAJobPageTest();
		PostAJobPageTest.enterRandomJobTitleTest();
		PostAJobPageTest.enterJobDescriptionTest(jobDetails);
		PostAJobPageTest.clickCategoryTest(category);
		PostAJobPageTest.enterKeywordsTest(skill);
		PostAJobPageTest.selectFixedPriceBudgetTest(budget);
		PostAJobPageTest.clickFeatureMyJobTest();
		
	}
	
	@Test(dependsOnMethods = { "postJobPaypalTest" })
	@Parameters({"paypalId", "paypalPass"})
	@Documentation(step="Complete featuring job by adding Paypal to the account. Verify Paypal adds as a Primary method.", expected="User is able to feature Job using Paypal. Paypal is now Primary method.")
	public static void payUsingPaypalTest(String paypalId, String paypalPass) throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.selectAddPaypalTest();
		ThirdPartyPageTest.verifyPaypalPageTest();
		ThirdPartyPageTest.enterPaypalUserIdTest(paypalId);
		ThirdPartyPageTest.enterPaypalPasswordTest(paypalPass);
		ThirdPartyPageTest.clickPaypalLoginBtnTest();
		ThirdPartyPageTest.verifyBillingAgreementTest();
		ThirdPartyPageTest.clickAgreeAndContinuePaypalTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaypalIsPrimaryTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		
	}
	
	@Test(dependsOnMethods = { "payUsingPaypalTest" })
	@Documentation(step="Verify Featuring Job payment using CC is successful", expected="User is able to feature job using Credit Card.")
	public static void verifyJobPostSuccessPaypalTest() throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "verifyJobPostSuccessPaypalTest" })
	@Parameters({"jobDetails", "category", "skill", "fixedBudget"})
	@Documentation(step="Go to Post a Job page again.", expected="User is able to navigate to Post a Job page.")
	public static void postJobAddedCCTest(String jobDetails, String category,
			String skill, String budget) throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
		PostAJobPageTest.verifyPostAJobPageTest();
		PostAJobPageTest.enterRandomJobTitleTest();
		PostAJobPageTest.enterJobDescriptionTest(jobDetails);
		PostAJobPageTest.clickCategoryTest(category);
		PostAJobPageTest.enterKeywordsTest(skill);
		PostAJobPageTest.selectFixedPriceBudgetTest(budget);
		PostAJobPageTest.clickFeatureMyJobTest();
	}
	
	@Test(dependsOnMethods = { "postJobAddedCCTest" })
	@Parameters({"ccMethod"})
	@Documentation(step="Complete Featuring Job by using previously added Credit card.", expected="User is able to feature job using Credit card.")
	public static void payUsingAddedCCTest(String ccMethod) throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(ccMethod);
		PayNowPageTest.selectCCTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "payUsingAddedCCTest" })
	@Documentation(step="Complete Featuring Job by using previously added Credit card.", expected="User is able to feature job using Credit card.")
	public static void completeAddedCCPaymentTest() throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "completeAddedCCPaymentTest" })
	@Parameters({"jobDetails", "category", "skill", "fixedBudget"})
	@Documentation(step="Go to Post a Job page again.", expected="User is able to navigate to Post a Job page.")
	public static void postJobAddedPaypalTest(String jobDetails, String category,
			String skill, String budget) throws Exception {
		DashboardPageTest.clickPostAJobTopNavTest();
		PostAJobPageTest.verifyPostAJobPageTest();
		PostAJobPageTest.enterRandomJobTitleTest();
		PostAJobPageTest.enterJobDescriptionTest(jobDetails);
		PostAJobPageTest.clickCategoryTest(category);
		PostAJobPageTest.enterKeywordsTest(skill);
		PostAJobPageTest.selectFixedPriceBudgetTest(budget);
		PostAJobPageTest.clickFeatureMyJobTest();
	}
	
	@Test(dependsOnMethods = { "postJobAddedPaypalTest" })
	@Parameters({"paypalMethod"})
	@Documentation(step="Complete featuring job by added Paypal account. ", expected="User is able to feature job using Paypal added to their account.")
	public static void payUsingAddedPayPalTest(String paypalMethod) throws Exception {
		PostAJobPageTest.clickPostJobButtonTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(paypalMethod);
		PayNowPageTest.selectPaypalTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyJobPostedTest();
	}
	
	@Test(dependsOnMethods = { "payUsingAddedPayPalTest" })
	@Documentation(step="Remove all payment methods from the user's account.", expected="User is able to remove all payment methods.")
	public static void removePaymentsTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyEMPDashboardPageTest();
		DashboardPageTest.clickPayTabTest();
		PaymentsInvoicePageTest.verifyInvoicePageTest();
		EMPPaymentPageTest.clickEMPPaymentMethodsTabTest();
		EMPPaymentPageTest.verifyEMPPaymentsPageTest();
		EMPPaymentPageTest.removeAllPayMethodsTest();
		DashboardPageTest.clickDashboardTopNavTest();
	}
	
}

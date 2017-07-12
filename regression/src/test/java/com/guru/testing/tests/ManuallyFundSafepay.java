package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.objectmap.PayNowPageObjectMap;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminTaskEnginePage;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PayNowPageTest;
import com.guru.testing.page.WorkroomPageTest;

public class ManuallyFundSafepay {

	@Test(alwaysRun = true)
	@Documentation(step = "Click Safepay on the left side", expected = "Safepay section should be loaded")
	public static void clickSafePayTabTest() throws Exception {
		WorkroomPageTest.clickSafePayTab();
		WorkroomPageTest.verifyEMPSafePayTab();

	}

	@Test(dependsOnMethods = "clickSafePayTabTest")
	@Documentation(step = "Click Add funds button on Safepay", expected = "Verify Safepay section loads adding funds area")
	public static void clickAddFundsTest() throws Exception {
		WorkroomPageTest.clickAddFunds();
		WorkroomPageTest.verifyAddSafePayFunds();

	}

	@Test(dependsOnMethods = "clickAddFundsTest")
	@Documentation(step = "Enter amount in the add funds text box", expected = "Enter the safepay amount")
	@Parameters("amount")
	public static void enterAmountTest(String amount) throws Exception {
		WorkroomPageTest.enterSafepayAmountTest(amount);

	}

	@Test(dependsOnMethods = "enterAmountTest")
	@Documentation(step = "Click Add funds button again", expected = "Add funds is clicked")
	public static void clickAddSafepayFundsTest() throws Exception {
		WorkroomPageTest.clickAddFundsToSafepay();
	}

	@Test(dependsOnMethods = "clickAddSafepayFundsTest")
	@Documentation(step = "Verify and Select payment method and click Agree to pay checkbox", expected = "Payment method should be selected and Agree to pay checkbox should be clicked")
	@Parameters("paymentType")
	public static void selectPaymentMethodTest(String paymentType) throws Exception {
		PayNowPageTest.verifyPaymentMethodTest(paymentType);
		PayNowPageTest.payByPaymentMethod(paymentType);
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}

	@Test(dependsOnMethods = "selectPaymentMethodTest")
	@Documentation(step = "Click Pay button", expected = "Pay button should be clicked")
	public static void clickPayNowTest() throws Exception {
		PayNowPageTest.clickPayTest();
	}

	@Test(dependsOnMethods = "clickPayNowTest")
	@Documentation(step = "Verify Safepay fund payment", expected = "Safepay fund payment should be success")
	@Parameters()
	public static void verifySafePayPaidTest() throws Exception {
		PayNowPageTest.verifySafepayFundSuccess();
	}

	@Test(dependsOnMethods = "verifySafePayPaidTest")
	@Documentation(step = "Click Back to Safepay link", expected = "Verify Employer's Safepay section is loaded in the workroom")
	public static void clickBackToSafePayPageTest() throws Exception {
		PayNowPageTest.clickBackToSafePayPage();
		WorkroomPageTest.verifyEMPSafePayTab();

	}

	@Test(dependsOnMethods = "clickBackToSafePayPageTest")
	@Documentation(step = "Verify amount is added to safepay", expected = "The latest transaction should be of the safepay")
	@Parameters({ "autoFund", "amount", "paymentType" })
	public static void verifyAmountIsAddedTest(Boolean autoFund, Float amount, String paymentType) throws Exception {
		WorkroomPageTest.verifyLatestSafepayTransaction(autoFund, amount, paymentType);

	}

}

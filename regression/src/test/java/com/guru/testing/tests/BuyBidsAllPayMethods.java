package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.BidsPageTest;
import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PayNowPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class BuyBidsAllPayMethods {
	
	@Test(alwaysRun = true)
	@Documentation(step="Navigate to Buy Bids page.", expected="User is able to click on 'Buy Bids' successfully.")
	public static void goToBuyBidsPageTest() throws Exception {
		DashboardPageTest.clickFLOwnerDropdownOptionsTest();
		DashboardPageTest.clickBuyBidsTest();
	}
	
	@Test(dependsOnMethods = { "goToBuyBidsPageTest" })
	@Documentation(step="Verify Buy Bids page, and choose to Buy more bids.", expected="Buy bids page loads, and user is able to click 'Buy more bids'.")
	public static void buyBidsCATest() throws Exception {
		BidsPageTest.verifyBidsPageTest();
		BidsPageTest.getBidsCountBeforeTest();
		BidsPageTest.clickBuyMoreBidsTest();
	}
	
	@Test(dependsOnMethods = { "buyBidsCATest" })
	@Parameters("bidsAdded")
	@Documentation(step="Complete Bids purchase using Cash Account funds, and go back to Bids page.", expected="User is able to buy bids using Cash Account funds.")
	public static void payUsingCATest(int bidsAdded) throws Exception {
		BidsPageTest.clickAddBidsTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.clickUseCAfunds();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyBidPurchaseSuccessTest(bidsAdded);
	}
	
	@Test(dependsOnMethods = { "payUsingCATest" })
	@Parameters("bidsAdded")
	@Documentation(step="Choose to Buy more bids once again.", expected="User is able to choose to Buy more bids again.")
	public static void buyBidsCCTest(int extraBids) throws Exception {
		PayNowPageTest.clickBacktoBidsTest();
		BidsPageTest.verifyBidsPageTest();
		BidsPageTest.getBidsCountAfterTest();
		BidsPageTest.compareBidsCountTest(extraBids);
		BidsPageTest.getBidsCountBeforeTest();
		BidsPageTest.clickBuyMoreBidsTest();
	}
	
	@Test(dependsOnMethods = { "buyBidsCCTest" })
	@Parameters({"bidsAdded", "cardNumber", "month", "year", "cvv"})
	@Documentation(step="Complete bids purchase by adding Credit card to the account.", expected="User is able to buy bids using Credit Card funds.")
	public static void payUsingCCTest(int bidsAdded, String cardNumber, String month, String year, String cvv) throws Exception {
		BidsPageTest.clickAddBidsTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.clickPayWithCCTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyBidPurchaseSuccessTest(bidsAdded);
		
	}
	
	@Test(dependsOnMethods = { "payUsingCCTest" })
	@Parameters("bidsAdded")
	@Documentation(step="Choose to Buy more bids once again.", expected="User is able to choose to Buy more bids again.")
	public static void buyBidsPaypalTest(int extraBids) throws Exception {
		PayNowPageTest.clickBacktoBidsTest();
		BidsPageTest.verifyBidsPageTest();
		BidsPageTest.getBidsCountAfterTest();
		BidsPageTest.compareBidsCountTest(extraBids);
		BidsPageTest.getBidsCountBeforeTest();
		BidsPageTest.clickBuyMoreBidsTest();
		
	}
	
	@Test(dependsOnMethods = { "buyBidsPaypalTest" })
	@Parameters({"paypalId", "paypalPass"})
	@Documentation(step="Complete bids purchase by adding Paypal to the account. Verify Paypal adds as a Primary method.", expected="User is able to buy bids using Paypal. Paypal is now Primary method.")
	public static void payUsingPaypalTest(String paypalId, String paypalPass) throws Exception {
		BidsPageTest.clickAddBidsTest();
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
	@Parameters({"bidsAdded"})
	@Documentation(step="Complete bids purchase by adding Paypal to the account. Verify Paypal adds as a Primary method.", expected="User is able to buy bids using Paypal. Paypal is now Primary method.")
	public static void completePaypalPaymentTest(int extraBids) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyBidPurchaseSuccessTest(extraBids);
		PayNowPageTest.clickBacktoBidsTest();
		BidsPageTest.getBidsCountAfterTest();
		BidsPageTest.compareBidsCountTest(extraBids);
	}
	
	@Test(dependsOnMethods = { "completePaypalPaymentTest" })
	@Parameters({"ccMethod"})
	@Documentation(step="Complete bids purchase by using previously added Credit card.", expected="User is able to buy bids using Credit card.")
	public static void payUsingAddedCCTest(String ccMethod) throws Exception {
		BidsPageTest.getBidsCountBeforeTest();
		BidsPageTest.clickBuyMoreBidsTest();
		BidsPageTest.clickAddBidsTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(ccMethod);
		PayNowPageTest.selectCCTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "payUsingAddedCCTest" })
	@Parameters({"bidsAdded"})
	@Documentation(step="Complete bids purchase by using previously added Credit card.", expected="User is able to buy bids using Credit card.")
	public static void completeAddedCCPaymentTest(int bidsAdded) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyBidPurchaseSuccessTest(bidsAdded);
	}
	
	@Test(dependsOnMethods = { "completeAddedCCPaymentTest" })
	@Parameters({"bidsAdded"})
	@Documentation(step="Navigate back to Bids page, and opt to buy more bids.", expected="Able to click on 'Buy More Bids'.")
	public static void addMoreBidsUsingPaypalTest(int extraBids) throws Exception {
		PayNowPageTest.clickBacktoBidsTest();
		BidsPageTest.verifyBidsPageTest();
		BidsPageTest.getBidsCountAfterTest();
		BidsPageTest.compareBidsCountTest(extraBids);
		BidsPageTest.getBidsCountBeforeTest();
		BidsPageTest.clickBuyMoreBidsTest();
	}
	
	@Test(dependsOnMethods = { "addMoreBidsUsingPaypalTest" })
	@Parameters({"bidsAdded", "paypalMethod"})
	@Documentation(step="Complete bids purchase by added Paypal account. ", expected="User is able to buy bids using Paypal.")
	public static void payUsingAddedPayPalTest(int bidsAdded, String paypalMethod) throws Exception {
		BidsPageTest.clickAddBidsTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(paypalMethod);
		PayNowPageTest.selectPaypalTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyBidPurchaseSuccessTest(bidsAdded);
	}
	
	@Test(dependsOnMethods = { "payUsingAddedPayPalTest" })
	@Parameters("bidsAdded")
	@Documentation(step="Remove all payment methods from the user's account.", expected="User is able to remove all payment methods.")
	public static void removePaymentsTest(int extraBids) throws Exception {
		PayNowPageTest.clickBacktoBidsTest();
		BidsPageTest.verifyBidsPageTest();
		BidsPageTest.getBidsCountAfterTest();
		BidsPageTest.compareBidsCountTest(extraBids);
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyFLDashboardPageTest();
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.removeAllPayMethodsTest();
		DashboardPageTest.clickDashboardTopNavTest();
	}
}

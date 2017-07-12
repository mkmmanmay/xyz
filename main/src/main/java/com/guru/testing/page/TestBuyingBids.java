package com.guru.testing.page;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBuyingBids {

	
	@Test(alwaysRun=true )
	@Parameters({"username", "password"})
	public static void loginTest(String email, String password) throws Exception {
		
			LoginPageTest.verifyLoginPageTest();
			LoginPageTest.enterEmailOrUsernameTest(email);
			LoginPageTest.enterPasswordTest(password);
			LoginPageTest.clickSignInButtonTest();
		
	}
	
	@Test(dependsOnMethods = { "loginTest" })
	public static void securityTest() {
		try {
			SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=4, dependsOnMethods = { "securityTest" })
	public static void phoneTest() {
		try {
			PhoneVerificationPageTest.verifyPhoneVerificationPageTest();
			PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=5, dependsOnMethods = { "phoneTest" })
	public static void dashboardTest() {
		try {
			DashboardPageTest.verifyFLDashboardPageTest();
			DashboardPageTest.clickFLOwnerDropdownOptionsTest();
			DashboardPageTest.clickBuyBidsTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=5, dependsOnMethods = { "dashboardTest" })
	public static void buyBidsTest() {
		try {
			BidsPageTest.verifyBidsPageTest();
			BidsPageTest.getBidsCountBeforeTest();
			BidsPageTest.clickBuyMoreBidsTest();
			BidsPageTest.clickAddBidsTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=6, dependsOnMethods = { "buyBidsTest" })
	@Parameters({"cardNumber", "month", "year", "cvv", "bidsAdded"})
	public static void makePaymentTest(String number, String month, String year, String cvv, int bidsAdded) {
		try {
			PayNowPageTest.clickPayWithCCTest();
			PayNowPageTest.enterCCNumberTest(number);
			PayNowPageTest.selectMonthTest(month);
			PayNowPageTest.selectYearTest(year);
			PayNowPageTest.enterCVVTest(cvv);
			PayNowPageTest.selectAgreeToPayCheckboxTest();
			PayNowPageTest.clickPayTest();
			PayNowPageTest.verifyBidPurchaseSuccessTest(bidsAdded);
			PayNowPageTest.clickBacktoBidsTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=7, dependsOnMethods = { "makePaymentTest" })
	@Parameters("bidsAdded")
	public static void verifyBidsAddedTest(int bids) {
		try {
			BidsPageTest.verifyBidsPageTest();
			BidsPageTest.getBidsCountAfterTest();
			BidsPageTest.compareBidsCountTest(bids);
			BidsPageTest.clickPaymentsTabBidsPageTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=8, dependsOnMethods = { "verifyBidsAddedTest" })
	@Parameters({ "cardType", "bidsAdded" })
	public static void verifyCAEntryTest(String type, String bids) {
		try {
			CashAccPageTest.clickCashAccTabTest();
			CashAccPageTest.verifyCashAccPageFLTest();
			CashAccPageTest.verifyTransactionsTest(bids);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=9, dependsOnMethods = { "verifyCAEntryTest" })
	@Parameters("ccLastDigits")
	public static void removePaymentTest(String ccLastDigits) {
		try {
			PaymentsTransferPageTest.clickTransferMethodsTabTest();
			PaymentsTransferPageTest.verifyTransferMethodsPageTest();
			PaymentsTransferPageTest.clickRemoveCCTest(ccLastDigits);
			PaymentsTransferPageTest.clickConfirmRemoveTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

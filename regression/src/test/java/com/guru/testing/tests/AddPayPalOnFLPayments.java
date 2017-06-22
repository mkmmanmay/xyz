package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddPayPalOnFLPayments {
	
	@Test(alwaysRun=true )
	@Parameters({"paypalId", "paypalPass"})
	public static void selectAddPayPal(String paypalId, String paypalPass) throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add PayPal");
		ThirdPartyPageTest.verifyPaypalPageTest();
		ThirdPartyPageTest.enterPaypalUserIdTest(paypalId);
		ThirdPartyPageTest.enterPaypalPasswordTest(paypalPass);
		ThirdPartyPageTest.clickPaypalLoginBtnTest();
		ThirdPartyPageTest.verifyBillingAgreementTest();
		ThirdPartyPageTest.clickAgreeAndContinuePaypalTest();
		
	}
	
	@Test(dependsOnMethods = {"selectAddPayPal"})
	public static void verifyPaypalAccAdded(String paypalId) throws Exception {
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.verifyPayPalAddedTest(paypalId);
	}
}

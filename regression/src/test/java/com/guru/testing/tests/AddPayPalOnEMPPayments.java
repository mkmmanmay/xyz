package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.EMPPaymentPageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddPayPalOnEMPPayments {
	
	@Test(alwaysRun=true )
	@Parameters({"paypalId", "paypalPass"})
	public static void selectAddPayPal(String paypalId, String paypalPass) throws Exception {
		EMPPaymentPageTest.choosePaymentToAddTest("Add PayPal");
		ThirdPartyPageTest.verifyPaypalPageTest();
		ThirdPartyPageTest.enterPaypalUserIdTest(paypalId);
		ThirdPartyPageTest.enterPaypalPasswordTest(paypalPass);
		ThirdPartyPageTest.clickPaypalLoginBtnTest();
		ThirdPartyPageTest.verifyBillingAgreementTest();
		ThirdPartyPageTest.clickAgreeAndContinuePaypalTest();
		
	}
	
	@Test(dependsOnMethods = {"selectAddPayPal"})
	public static void verifyPaypalAccAdded(String paypalId) throws Exception {
		EMPPaymentPageTest.verifyEMPPaymentsPageTest();
		PaymentsTransferPageTest.verifyPayPalAddedTest(paypalId);
	}
}

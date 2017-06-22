package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.EMPPaymentPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddCreditCardsEMPPayments {
	@Test(alwaysRun=true )
	@Parameters({"visaNumber", "visaMonth", "visaYear", "visaCVV", "address"})
	public static void addVISA(String cardNumber, String month, String year, String cvv, String address) throws Exception {
		EMPPaymentPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.enterStreetAddressTest(address);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyVisaCCAddedTest();
	}
	
	@Test
	@Parameters({"mcNumber", "mcMonth", "mcYear", "mcCVV", "address"})
	public static void addMasterCard(String cardNumber, String month, String year, String cvv, String address) throws Exception {
		EMPPaymentPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.enterStreetAddressTest(address);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyMasterCardCCAddedTest();
	}
	
	@Test
	@Parameters({"amexNumber", "amexMonth", "amexYear", "amexCVV", "address"})
	public static void addAMEX(String cardNumber, String month, String year, String cvv, String address) throws Exception {
		EMPPaymentPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.enterStreetAddressTest(address);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyAMEXCCAddedTest();
	}
	
	@Test
	@Parameters({"title"})
	public static void verifyCreditCards(String title) throws Exception {
		CommonPageTest.closeCurrentWindow();
		CommonPageTest.switchToPageByTitleTest(title);
		AdminCRMPageTest.clickPaymentTabTest();
		AdminCRMPageTest.clickViewCreditCardsEMPTest();
		AdminCRMPageTest.clickVerifyCreditCardsEMPTest();
		AdminCRMPageTest.clickGeneralInfoTabTest();
		AdminCRMPageTest.gotoAccountTest();
		CommonPageTest.switchToNewTabTest();
		
	}
	
	@Test
	public static void verifyCreditCardsAdded() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
		DashboardPageTest.clickPayTabTest();
		PaymentsInvoicePageTest.verifyInvoicePageTest();
		EMPPaymentPageTest.clickEMPPaymentMethodsTabTest();
		EMPPaymentPageTest.verifyEMPPaymentsPageTest();
		EMPPaymentPageTest.verifyVISAVerifiedTest();
		EMPPaymentPageTest.verifyMasterCardVerifiedTest();
		EMPPaymentPageTest.verifyAMEXVerifiedTest();
	}
}

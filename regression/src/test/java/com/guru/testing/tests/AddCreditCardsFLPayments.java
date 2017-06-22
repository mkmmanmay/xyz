package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.PaymentsTransferPageTest;

public class AddCreditCardsFLPayments {

	@Test(alwaysRun=true )
	@Parameters({"visaNumber", "visaMonth", "visaYear", "visaCVV"})
	public static void addVISA(String cardNumber, String month, String year, String cvv) throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyVisaCCAddedTest();
	}
	
	@Test
	@Parameters({"mcNumber", "mcMonth", "mcYear", "mcCVV"})
	public static void addMasterCard(String cardNumber, String month, String year, String cvv) throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyMasterCardCCAddedTest();
	}
	
	@Test
	@Parameters({"amexNumber", "amexMonth", "amexYear", "amexCVV"})
	public static void addAMEX(String cardNumber, String month, String year, String cvv) throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add Credit Card");
		PaymentsTransferPageTest.verifyCreditCardPopupTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PaymentsTransferPageTest.clickAddCreditCardTest();
		PaymentsTransferPageTest.verifyAMEXCCAddedTest();
	}
}

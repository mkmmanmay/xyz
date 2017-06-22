package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.testng.Documentation;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.EMPPaymentPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;

public class AddAllEMPPaymentMethods {
			
	@Test(alwaysRun=true )
	@Documentation(step="Go to the Employer's payment page, and verify the same.", expected="Should be able to navigate to the Payments page, verify the same.")
	public static void goToEMPPaymentsTest() throws Exception {
		DashboardPageTest.clickPayTabTest();
		PaymentsInvoicePageTest.verifyInvoicePageTest();
		EMPPaymentPageTest.clickEMPPaymentMethodsTabTest();
		EMPPaymentPageTest.verifyEMPPaymentsPageTest();
	}
		
	@Test(dependsOnMethods = { "goToEMPPaymentsTest" })
	@Documentation(step="Add Bank account to the employer's payment methods, entering all valid details. Verify it from admin side, and check it's reflected on the UI"
	, expected="Bank Account should be added to the Employer's list of payment methods.")
	@Parameters({"accountHolderName", "routingNumber", "accountNumber", "environment", "title" })
	public static void addBankAccountEMPTest(String accountHolderName, String routingNumber, String accountNumber, String environment, String title) throws Exception {
		AddBankAccountOnEMPPayments.selectAddBankAccount(accountHolderName, routingNumber, accountNumber);	
		AddBankAccountOnEMPPayments.verifyBankAcc(environment, title);
		AddBankAccountOnEMPPayments.verifyBankAccVerified();
	}
		
	@Test(dependsOnMethods = { "addBankAccountEMPTest" })
	@Documentation(step="Add Paypal to the employer's payment methods, entering all valid details. Check it's reflected as added on the Payments page."
	, expected="Paypal should be added to the Employer's list of payment methods.")
	@Parameters({"paypalId", "paypalPass"})
	public static void addPaypalTestFL(String paypalId, String paypalPass) throws Exception {
		AddPayPalOnEMPPayments.selectAddPayPal(paypalId, paypalPass);
		AddPayPalOnEMPPayments.verifyPaypalAccAdded(paypalId);
	}
		
	@Test(dependsOnMethods = { "addPaypalTestFL" })
	@Documentation(step="Add all types of Credit card to the employer's payment methods, entering all valid details. Verify it from admin side, and check it's reflected on the UI"
	, expected="Credit cards should be added to the Employer's list of payment methods.")
	@Parameters({"title", "visaNumber", "visaMonth", "visaYear", "visaCvv", "address", "mcNumber", "mcMonth", "mcYear", "mcCvv", 
		"amexNumber", "amexMonth", "amexYear", "amexCvv"})
	public static void addCreditCardsFLTest(String title, String visaNumber, String visaMonth, String visaYear, String visaCvv, String address,
		String mcNumber, String mcMonth, String mcYear, String mcCvv,
		String amexNumber, String amexMonth, String amexYear, String amexCvv) throws Exception {
		AddCreditCardsEMPPayments.addVISA(visaNumber, visaMonth, visaYear, visaCvv, address);
		AddCreditCardsEMPPayments.addMasterCard(mcNumber, mcMonth, mcYear, mcCvv, address);
		AddCreditCardsEMPPayments.addAMEX(amexNumber, amexMonth, amexYear, amexCvv, address);		
		AddCreditCardsEMPPayments.verifyCreditCards(title);
		AddCreditCardsEMPPayments.verifyCreditCardsAdded();
	}	
}



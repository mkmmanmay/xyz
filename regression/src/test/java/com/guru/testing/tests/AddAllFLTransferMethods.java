package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddAllFLTransferMethods {
		
	@Test(alwaysRun=true )
	public static void goToFLPaymentsTest() throws Exception {
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
	}
	
	/*@Test(dependsOnMethods = { "goToFLPaymentsTest" })
	@Parameters({"accountHolderName", "routingNumber", "accountNumber", "environment", "title" })
	public static void addBankAccountFLTest(String accountHolderName, String routingNumber, String accountNumber, String environment, String title) throws Exception {
		AddBankAccountOnFLPayments.selectAddBankAccount(accountHolderName, routingNumber, accountNumber);	
		AddBankAccountOnFLPayments.verifyBankAcc(environment, title);
		AddBankAccountOnFLPayments.verifyBankAccVerified();
	}*/
	/*
	@Test(dependsOnMethods = { "goToFLPaymentsTest" })
	@Parameters({"paypalId", "paypalPass"})
	public static void addPaypalTestFL(String paypalId, String paypalPass) throws Exception {
		AddPayPalOnFLPayments.selectAddPayPal(paypalId, paypalPass);
		AddPayPalOnFLPayments.verifyPaypalAccAdded(paypalId);
	}*/
	
	/*@Test(dependsOnMethods = { "goToFLPaymentsTest" })
	@Parameters({"accountID", "swiftID", "prefCurrency", "title"})
	public static void addWireTransferTestFL(String accountID, String swiftID, String prefCurrency, String title) throws Exception {
		AddWireTransferOnFLPayments.selectAddWireTransfer();
		AddWireTransferOnFLPayments.fillWireAccDetails(accountID, swiftID, prefCurrency);
		AddWireTransferOnFLPayments.verifyWireTransferAcc(title);
		AddWireTransferOnFLPayments.verifyWireTransferAdded();
	}*/
	
	/*@Test(dependsOnMethods = { "goToFLPaymentsTest" })
	@Parameters({"firstName", "lastName", "email", "birthMonth", "birthYear", "country", "payoneerAddress", "city", "zip", "phoneNo",
		"payoneerPass", "securityAns", "idNumber", "payoneerApproveUrl", "title"})
	public static void addPayoneerTestFL(String firstName, String lastName, String email, String birthMonth, String birthYear, 
			 String country, String payoneerAddress, String city, String zip, String phoneNo, String pass, String securityAns
			 , String idNumber, String title, String payoneerApproveUrl) throws Exception {
		AddPayoneerOnFLPayments.selectAddPayoneer();
		AddPayoneerOnFLPayments.enterPayoneerPersonalDetails(firstName, lastName, birthMonth, birthYear);
		AddPayoneerOnFLPayments.enterPayoneerContactDetails(country, payoneerAddress, city, zip, phoneNo);
		AddPayoneerOnFLPayments.enterPayoneerSecurityDetails(pass, securityAns);
		AddPayoneerOnFLPayments.finalizePayoneerDetails(idNumber);
		AddPayoneerOnFLPayments.verifyPayoneerMethod(title, payoneerApproveUrl);
		AddPayoneerOnFLPayments.verifyPayoneerIsAdded();
	}*/
	
	@Test(dependsOnMethods = { "goToFLPaymentsTest" })
	@Parameters({"visaNumber", "visaMonth", "visaYear", "visaCvv", "mcNumber", "mcMonth", "mcYear", "mcCvv", 
		"amexNumber", "amexMonth", "amexYear", "amexCvv"})
	public static void addCreditCardsFLTest(String visaNumber, String visaMonth, String visaYear, String visaCvv,
			String mcNumber, String mcMonth, String mcYear, String mcCvv,
			String amexNumber, String amexMonth, String amexYear, String amexCvv) throws Exception {
		AddCreditCardsFLPayments.addVISA(visaNumber, visaMonth, visaYear, visaCvv);
		AddCreditCardsFLPayments.addMasterCard(mcNumber, mcMonth, mcYear, mcCvv);
		AddCreditCardsFLPayments.addAMEX(amexNumber, amexMonth, amexYear, amexCvv);
		
	}
	
}

package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddPayoneerOnFLPayments {
	
	@Test(alwaysRun=true )
	public static void selectAddPayoneer() throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add Payoneer");
		ThirdPartyPageTest.verifyPayoneerPageTest();
		ThirdPartyPageTest.selectPrepaidMasterCardRadioTest();
		ThirdPartyPageTest.clickSignUpPayoneerTest();
		
	}
	
	@Test(dependsOnMethods = {"selectAddPayoneer"})
	@Parameters({"firstName", "lastName", "birthMonth", "birthYear"})
	public static void enterPayoneerPersonalDetails(String firstName, String lastName, String birthMonth, String birthYear) throws Exception {
		ThirdPartyPageTest.verifyPrepaidCardSetupPersonalPageTest();
		ThirdPartyPageTest.enterPayoneerFirstNameTest(firstName);
		ThirdPartyPageTest.enterPayoneerLastNameTest(lastName);
		ThirdPartyPageTest.enterPayoneerEmailTest();
		ThirdPartyPageTest.enterPayoneerRetypeEmailTest();
		ThirdPartyPageTest.clickDateOfBirthTextboxTest();
		ThirdPartyPageTest.selectBirthMonthTest(birthMonth);
		ThirdPartyPageTest.selectBirthYearTest(birthYear);
		ThirdPartyPageTest.clickDateOfBirthTest();
		ThirdPartyPageTest.clickNextGettingStartedPageTest();
	}
	
	@Test(dependsOnMethods = {"enterPayoneerPersonalDetails"})
	@Parameters({"country", "payoneerAddress", "city", "zip", "phoneNo"})
	public static void enterPayoneerContactDetails(String country, String payoneerAddress, String city, String zip, String phoneNo) throws Exception {
		ThirdPartyPageTest.verifyPrepaidCardSetupContactPageTest();
		ThirdPartyPageTest.selectPayoneerCountryTest(country);
		ThirdPartyPageTest.enterPayoneerAddressTest(payoneerAddress);
		ThirdPartyPageTest.enterPayoneerCityTest(city);
		ThirdPartyPageTest.enterPayoneerZipCodeTest(zip);
		ThirdPartyPageTest.enterPayoneerPhoneNoTest(phoneNo);
		ThirdPartyPageTest.clickNextContactDetailsPageTest();
	}
	
	@Test(dependsOnMethods = {"enterPayoneerContactDetails"})
	@Parameters({"pass", "securityAns"})
	public static void enterPayoneerSecurityDetails(String pass,String securityAns) throws Exception {
		ThirdPartyPageTest.verifyPrepaidCardSetupSecurityPageTest();
		ThirdPartyPageTest.enterPayoneerPasswordTest(pass);
		ThirdPartyPageTest.enterPayoneerRetypePasswordTest(pass);
		ThirdPartyPageTest.selectPayoneerSecurityQuestionTest();
		ThirdPartyPageTest.enterPayoneerSecurityAnsTest(securityAns);
		ThirdPartyPageTest.clickNextSecurityDetailsPageTest();
	}
	
	@Test(dependsOnMethods = {"enterPayoneerSecurityDetails"})
	@Parameters({"idNumber"})
	public static void finalizePayoneerDetails(String idNumber) throws Exception {
		ThirdPartyPageTest.verifyCardSetupAlmostDonePageTest();
		ThirdPartyPageTest.enterPayoneerIDNumberTest(idNumber);
		ThirdPartyPageTest.checkAllCheckboxesPayoneerTest();
		ThirdPartyPageTest.clickPayoneerOrderButtonTest();
		ThirdPartyPageTest.verifyPayoneerOrderSuccessTest();
		
	}
	
	@Test(dependsOnMethods = {"finalizePayoneerDetails"})
	@Parameters({"title", "payoneerApproveUrl"})
	public static void verifyPayoneerMethod(String title, String payoneerApproveUrl) throws Exception {
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.verifyAddPayoneerPendingTest();
		PaymentsTransferPageTest.launchPayoneerVerifyURLTest(payoneerApproveUrl);
		CommonPageTest.closeCurrentWindow();
		CommonPageTest.switchToPageByTitleTest(title);
		AdminCRMPageTest.gotoAccountTest();
		CommonPageTest.switchToNewTabTest();
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = {"verifyPayoneerMethod"})
	public static void verifyPayoneerIsAdded() throws Exception {
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.verifyPayoneerVerifiedTest();
	}
}

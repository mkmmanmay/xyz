package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminPayrollSummaryPageTest;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.EMPPaymentPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddBankAccountOnEMPPayments {
	
	@Test(alwaysRun=true )
	@Parameters({"accountHolderName", "routingNumber", "accountNumber"})
	public static void selectAddBankAccount(String accountHolderName, String routingNumber, String accountNumber) throws Exception {
		EMPPaymentPageTest.choosePaymentToAddTest("Add Bank Account");
		PaymentsTransferPageTest.verifyAddBankAccountPopupTest();
		PaymentsTransferPageTest.enterAccountHolderNameTest(accountHolderName);
		PaymentsTransferPageTest.enterRoutingNumberTest(routingNumber);
		PaymentsTransferPageTest.enterAccountNumberTest(accountNumber);
		PaymentsTransferPageTest.enterConfirmAccountNumberTest(accountNumber);
		PaymentsTransferPageTest.clickAddBankAccountBtnTest();
		PaymentsTransferPageTest.verifyAddBankAccountProcessingTest();
	}
	
	@Test
	@Parameters({"adminEnv", "title"})
	public static void verifyBankAcc(String env, String title) throws Exception {
		CommonPageTest.launchAdminSiteTest(env);
		AdminHomePageTest.verifyAdminHomePage();
		AdminHomePageTest.clickPayrollSummaryTest();
		AdminPayrollSummaryPageTest.verifyPayrollSummaryPageTest();
		AdminPayrollSummaryPageTest.clickDirectDepositLinkTest();
		AdminPayrollSummaryPageTest.verifyDirectDepositDetailsTest();
		AdminPayrollSummaryPageTest.clickGenerateCSVBtnTest();
		AdminPayrollSummaryPageTest.verifyCSVGenerateSuccessTest();
		CommonPageTest.switchToPageByTitleTest(title);
		AdminCRMPageTest.clickPaymentTabTest();
		AdminCRMPageTest.clickViewECheckAccountsEMPTest();
		AdminCRMPageTest.clickVerifyECheckEMPTest();
		AdminCRMPageTest.clickGeneralInfoTabTest();
		AdminCRMPageTest.gotoAccountTest();
		AdminCRMPageTest.switchToNewTabTest();
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
	@Test(dependsOnMethods = {"verifyBankAcc"})
	public static void verifyBankAccVerified() throws Exception {
		DashboardPageTest.clickPayTabTest();
		PaymentsInvoicePageTest.verifyInvoicePageTest();
		EMPPaymentPageTest.clickEMPPaymentMethodsTabTest();
		EMPPaymentPageTest.verifyEMPPaymentsPageTest();
		PaymentsTransferPageTest.verifyAddBankAccountVerifiedTest();
	}
}

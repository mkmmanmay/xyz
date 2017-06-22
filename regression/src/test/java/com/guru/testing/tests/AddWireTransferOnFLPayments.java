package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class AddWireTransferOnFLPayments {
	
	@Test(alwaysRun=true )
	public static void selectAddWireTransfer() throws Exception {
		PaymentsTransferPageTest.clickAddTransferDropdownTest();
		PaymentsTransferPageTest.choosePaymentToAddTest("Add Wire Transfer");
		PaymentsTransferPageTest.verifyWireTransferAddFormTest();
	}
	
	@Test
	@Parameters({"accountID", "swiftID", "prefCurrency" })
	public static void fillWireAccDetails(String accountID, String swiftID, String prefCurrency) throws Exception {
		PaymentsTransferPageTest.selectPreferredCurrencyTest(prefCurrency);
		PaymentsTransferPageTest.enterWireAccountIDTest(accountID);
		PaymentsTransferPageTest.enterSwiftIDTest(swiftID);
		PaymentsTransferPageTest.clickLookupOneTest();
		PaymentsTransferPageTest.clickIAgreeCheckboxTest();
		PaymentsTransferPageTest.clickIAuthorizeCheckboxTest();
		PaymentsTransferPageTest.clickAddWireTransferBtnTest();
		PaymentsTransferPageTest.verifyWireTransferPendingTest();
		CommonPageTest.closeCurrentWindow();
		
	}
	
	@Test(dependsOnMethods = { "fillWireAccDetails" })
	@Parameters("title")
	public static void verifyWireTransferAcc(String title) throws Exception {
		CommonPageTest.switchToPageByTitleTest(title);
		AdminCRMPageTest.clickPaymentW9TabTest();
		AdminCRMPageTest.clickViewWireTransferAccountsTest();
		AdminCRMPageTest.clickVerifyWireTransferTest();
		AdminCRMPageTest.clickGeneralInfoTabTest();
		AdminCRMPageTest.gotoAccountTest();
		CommonPageTest.switchToNewTabTest();
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods = { "verifyWireTransferAcc" })
	public static void verifyWireTransferAdded() throws Exception {
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.verifyWireTransferVerifiedTest();
	}
	
}

package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.CashAccPageTest;
import com.guru.testing.page.DashboardPageTest;

public class WithdrawFundsFromFLCashAccount {
	private static Float  CASH_ACCOUNT_BALANCE=(float) 0.00;
	//private static Float E_CHECK_AMOUNT=(float) 0.00;
	//private static Float WIRE_TRANSFER_AMOUNT=(float) 0.00;
	//private static Float PAYPAL_AMOUNT=(float) 0.00;
	
	@Test(alwaysRun=true )
	@Documentation(step="Click Withdraw link on the dashboard",expected="Verify Withraw pop up is loaded")
	public static void clickWithdrawLinkTest() throws Exception {
		CASH_ACCOUNT_BALANCE=DashboardPageTest.getCashAccountBalance();
		DashboardPageTest.clickWithdrawLink();
		CashAccPageTest.verifyWithdrawCashPopUp();
	}
	
	@Test(dependsOnMethods = "clickWithdrawLinkTest")	
	@Parameters({"eCheckAmount","option1","eCheckRowNum"})
	@Documentation(step="Enter Amount and Select E check option in the withdrawal pop up",expected="Verify no fee is charged")
	public static void enterAmountSelectEcheckVerifyNoFeeTest(Float eCheckAmount, String option1, int eCheckRowNum) throws Exception {
		CashAccPageTest.enterAmountByRow(eCheckAmount, eCheckRowNum);	
		CashAccPageTest.selectSendToOptionAs(option1, eCheckRowNum);
		CashAccPageTest.verifyNoWithdrawalFee(eCheckRowNum);
	}
	
	@Test(dependsOnMethods = "enterAmountSelectEcheckVerifyNoFeeTest")
	@Documentation(step="Click + Withdraw to another account link",expected="Link should be clicked")
	public static void clickWithdrawToAnotherAccountTest() throws Exception {
		CashAccPageTest.clickWithdrawToAnotherAccount();
	}
	
	@Test(dependsOnMethods = "clickWithdrawToAnotherAccountTest")
	@Parameters({"payPalAmount","option2","payPalRowNum"})
	@Documentation(step="Enter Amount and Select Paypal option in the withdrawal pop up",expected="Verify no fee is charged")
	public static void selectPaypalVerifyNoFeeTest(Float payPalAmount,String option2, int payPalRowNum) throws Exception {
		CashAccPageTest.enterAmountByRow(payPalAmount,payPalRowNum);	
		CashAccPageTest.selectSendToOptionAs(option2,payPalRowNum);
		CashAccPageTest.verifyNoWithdrawalFee(payPalRowNum);
	}
	
	@Test(dependsOnMethods = "selectPaypalVerifyNoFeeTest")
	@Documentation(step="Click + Withdraw to another account link",expected="Link should be clicked")
	public static void clickWithdrawToAnotherAccount2Test() throws Exception {
		CashAccPageTest.clickWithdrawToAnotherAccount();
	}
	
	@Test(dependsOnMethods = "clickWithdrawToAnotherAccount2Test")
	@Parameters({"wireTransferAmount","option3","wireTransferRowNum"})
	@Documentation(step="Enter Amount and Select wire transfer option in the withdrawal pop up",expected="Verify no fee is charged")
	public static void selectWireTransferVerifyFeeTest(Float wireTransferAmount,String option3, int wireTransferRowNum) throws Exception {
		CashAccPageTest.enterAmountByRow(wireTransferAmount,wireTransferRowNum);	
		CashAccPageTest.selectSendToOptionAs(option3,wireTransferRowNum);
		CashAccPageTest.verifyWireTransferWithdrawalFee(wireTransferRowNum);
	}
	
	@Test(dependsOnMethods = "selectWireTransferVerifyFeeTest")
	@Documentation(step="Click Withdraw button and confirm again in the pop up",expected="Money should be withdrawn")
	public static void withdrawFundsTest() throws Exception {
		CashAccPageTest.clickWithdrawInPopUp();
		CashAccPageTest.clickWithdrawInPopUp();
	}

	@Test(dependsOnMethods = "withdrawFundsTest")
	@Parameters({"eCheckAmount","payPalAmount","wireTransferAmount"})
	@Documentation(step="Verify Cash Account balance on Cash Account page",expected="It should be same as deducted")
	public static void verifyCashAccountBalanceTest(Float eCheckAmount, Float payPalAmount, Float wireTransferAmount) throws Exception {
		CASH_ACCOUNT_BALANCE=(float) (CASH_ACCOUNT_BALANCE-(eCheckAmount+payPalAmount+wireTransferAmount));
		CashAccPageTest.verifyCashAccountBalanceOnPage(CASH_ACCOUNT_BALANCE);
	}

}

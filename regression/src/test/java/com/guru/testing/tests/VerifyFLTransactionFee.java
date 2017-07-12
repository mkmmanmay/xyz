package com.guru.testing.tests;

import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;

public class VerifyFLTransactionFee {
	

	
	@Test(alwaysRun=true )
	@Documentation(step="",expected="")
	public static void verifyMembershipTest() throws Exception {
		
	}
	
	@Test(dependsOnMethods = "clickWithdrawLinkTest")	
	@Documentation(step="",expected="")
	public static void enterAmountSelectEcheckVerifyNoFeeTest() throws Exception {
		
	}
	
	@Test(dependsOnMethods = "enterAmountSelectEcheckVerifyNoFeeTest")
	@Documentation(step="",expected="")
	public static void clickWithdrawToAnotherAccountTest() throws Exception {
		
	}
	
	@Test(dependsOnMethods = "clickWithdrawToAnotherAccountTest")
	@Documentation(step="",expected="")
	public static void selectPaypalVerifyNoFeeTest() throws Exception {
		
	}
	
	
}

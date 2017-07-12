package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.WorkroomPageTest;

public class PayInvoice {	

	
	@Test(alwaysRun=true )
	@Parameters("agreementType")
	@Documentation(step="",expected="")
	public static void verifyStatusUpdatesPageTest(String agreementType) throws Exception {
		WorkroomPageTest.verifyFLWorkroomByAgreement(agreementType);
	}
	
	@Test(dependsOnMethods = "clickWithdrawLinkTest")	
	@Parameters("agreementType")
	@Documentation(step="",expected="")
	public static void raiseInvoiceByAgreementTypeTest(String agreementType) throws Exception {
	WorkroomPageTest.raiseInvoiceByAgreementTypeTest(agreementType);	
	}
	
	@Test(dependsOnMethods = "enterAmountSelectEcheckVerifyNoFeeTest")
	@Documentation(step="",expected="")
	public static void getInvoiceAmountTest() throws Exception {
		WorkroomPageTest.getOutstandingInvAmountTest();
	}
	
}

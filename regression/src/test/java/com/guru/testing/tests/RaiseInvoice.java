package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.WorkroomPageTest;

public class RaiseInvoice {	

	
	@Test(alwaysRun=true )
	@Parameters("agreementType")
	@Documentation(step="",expected="")
	public static void raiseInvoiceByAgreementTypeTest(String agreementType) throws Exception {
	WorkroomPageTest.raiseInvoiceByAgreementTypeTest(agreementType);	
	}
	
	@Test(dependsOnMethods = "raiseInvoiceByAgreementTypeTest")
	@Documentation(step="",expected="")
	public static void getInvoiceAmountTest() throws Exception {
		WorkroomPageTest.getOutstandingInvAmountTest();
	}
	
}

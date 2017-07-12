package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminTaskEnginePage;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.WorkroomPageTest;

public class VerifyEmpFundsInSafepay {
	@Test(alwaysRun = true)
	@Documentation(step = "Click Safepay on the left side", expected = "Safepay section should be loaded")
	public static void clickSafePayTabTest() throws Exception {
		WorkroomPageTest.clickSafePayTab();
		WorkroomPageTest.verifyEMPSafePayTab();

	}
	
	@Test(dependsOnMethods = "clickBackToSafePayPageTest")
	@Documentation(step = "Verify amount is added to safepay", expected = "The latest transaction should be of the safepay")
	@Parameters({ "autoFund", "amount", "paymentType" })
	public static void verifyAmountIsAddedTest(Boolean autoFund, Float amount, String paymentType) throws Exception {
		WorkroomPageTest.verifyLatestSafepayTransaction(autoFund, amount, paymentType);

	}
	

}

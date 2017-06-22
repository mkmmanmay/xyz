package com.guru.testing.tests;

import org.testng.annotations.Test;

import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class Test1 {
	
	@Test
	public static void removeAllTest () throws Exception {
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.removeAllPayMethodsTest();
	}
}

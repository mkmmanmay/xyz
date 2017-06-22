package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminManageTestUsersPageTest;
import com.guru.testing.page.DashboardPageTest;

public class CreateNewEMP {
	@Test(alwaysRun = true)
	public static void goToCreateNewUsersTest() throws Exception {
		AdminHomePageTest.clickCreateNewTestUsersTest();
	}
	
	@Test(dependsOnMethods = { "goToCreateNewUsersTest" })
	@Parameters("index")
	public static void createEMPUserTest(int index) throws Exception {
		AdminManageTestUsersPageTest.verifyManageTestUsersPageTest();
		AdminManageTestUsersPageTest.clickCreateEMPAccountBtnTest();
		AdminManageTestUsersPageTest.goToInfoPageByIndexTest(index);
		AdminManageTestUsersPageTest.switchToNewTabTest();
	}
	
	@Test(dependsOnMethods = { "createEMPUserTest" })
	public static void goToAccountTest() throws Exception {
		AdminCRMPageTest.getUserIDTest();
		AdminCRMPageTest.getEmailIDTest();
		AdminCRMPageTest.gotoAccountTest();
		AdminCRMPageTest.switchToNewTabTest();
	}
	
	@Test(dependsOnMethods = { "goToAccountTest" })
	public static void goToEMPDashboard() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
	
}

package com.guru.testing.tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminManageTestUsersPageTest;
import com.guru.testing.page.DashboardPageTest;

public class CreateNewFL {

	@Test(alwaysRun = true)
	public static void goToCreateNewUsersTest() throws Exception {
		AdminHomePageTest.clickCreateNewTestUsersTest();
	}
	
	@Test(dependsOnMethods = { "goToCreateNewUsersTest" })
	@Parameters("index")
	public static void createFLUserTest(int index) throws Exception {
		AdminManageTestUsersPageTest.verifyManageTestUsersPageTest();
		AdminManageTestUsersPageTest.clickCreateFLAccountBtnTest();
		AdminManageTestUsersPageTest.goToInfoPageByIndexTest(index);
		AdminManageTestUsersPageTest.switchToNewTabTest();
	}
	
	@Test(dependsOnMethods = { "createFLUserTest" })
	public static void goToAccountTest() throws Exception {
		AdminCRMPageTest.getUserIDTest();
		AdminCRMPageTest.getEmailIDTest();
		AdminCRMPageTest.gotoAccountTest();
		AdminCRMPageTest.switchToNewTabTest();
	}
	
	@Test(dependsOnMethods = { "goToAccountTest" })
	@Parameters("address")
	public static void addContactInfoTest(@Optional("Delhi") String address) throws Exception {
		DashboardPageTest.verifyEnterContactInfoPageTest();
		DashboardPageTest.enterAddressTest(address);
		DashboardPageTest.clickContinueBtnTest();
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
}

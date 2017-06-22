package com.guru.testing.tests;

import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.LoginPageTest;

public class FLLogout {
	
	@Test(alwaysRun=true )
	@Documentation(step="Click on Logout to close user's session.", expected="Able to click 'Logout'.")
	public static void clickLogoutFLTest() throws Exception {
		DashboardPageTest.signOutFlTest();
	}
	
	@Test(dependsOnMethods = { "clickLogoutFLTest" })
	@Documentation(step="Verify Login page.", expected="Able to verify Login page.")
	public static void clickSignInTest() throws Exception {
		LoginPageTest.verifyLoginPageTest();
	}
	
	
}

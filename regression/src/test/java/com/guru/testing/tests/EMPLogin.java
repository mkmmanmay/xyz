package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.LoginPageTest;
import com.guru.testing.page.PhoneVerificationPageTest;
import com.guru.testing.page.SecurityQuestionsPageTest;

public class EMPLogin {
	
	
	@Test(alwaysRun=true )
	@Documentation(step="Verify login page and enter username and password", expected="Username and password should be entered")
	@Parameters({"username", "password"})
	public static void enterUsernameAndPasswordTest(String email, String password) throws Exception {
		LoginPageTest.verifyLoginPageTest();
		LoginPageTest.enterEmailOrUsernameTest(email);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods = { "enterUsernameAndPasswordTest" })
	@Documentation(step="Click Sign in", expected="User shouold be logged in and security question page should be loaded")
	public static void clickSignInTest() throws Exception {
		LoginPageTest.clickSignInButtonTest();
		SecurityQuestionsPageTest.verifyingSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = { "clickSignInTest" })
	@Documentation(step="Enter security question answer, or skip the page if necessary.", expected="User should be able to deal with Security questions page accordingly.")
	public static void validateSecurityTest() throws Exception {
		SecurityQuestionsPageTest.validateSecurityQuestionsPageTest();
	}
	
	@Test(dependsOnMethods = { "validateSecurityTest" })
	@Documentation(step="Skip Phone verification page if it appears.", expected="User is able to skip Phone verification page.")
	public static void verifyAndSkipPhoneVerificationTest() throws Exception {
		PhoneVerificationPageTest.verifyPhoneVerificationPageTest();
		PhoneVerificationPageTest.verifySkipThisForNowLinkTest();
	}
	
	@Test(dependsOnMethods = { "verifyAndSkipPhoneVerificationTest" })
	@Documentation(step="VerifyEmp Dashboard page.", expected="Dashboard page loads for emp")
	public static void verifyDashboardPageTest() throws Exception {
		DashboardPageTest.verifyEMPDashboardPageTest();
	}
}

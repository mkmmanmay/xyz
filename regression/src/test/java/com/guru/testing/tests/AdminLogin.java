package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;

import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminLoginPageTest;

public class AdminLogin {
	
	
	@Test(alwaysRun=true)
	@Documentation(step = "Verify the Login page of Admin site.", expected = "Login page should appear, and it passes verification.")
	public static void verifyAdminLoginPageTest() throws Exception {
		AdminLoginPageTest.verifyAdminLoginPage();
	}
	
	
	@Test(dependsOnMethods = "verifyAdminLoginPageTest")
	@Parameters({"username","password"})
	@Documentation(step = "Enter Admin username and password", expected = "Admin username and password should be entered in the text box")
	public static void enterUsernamePasswordTest(String username, String password) throws Exception {
		AdminLoginPageTest.enterUsername(username);
		AdminLoginPageTest.enterPassword(password);
	}
	
	
	@Test(dependsOnMethods = "enterUsernamePasswordTest")
	@Documentation(step = "Click Login", expected = "Login should be clicked")
	public static void clickLoginTest() throws Exception {
		AdminLoginPageTest.clickLogin();
		AdminHomePageTest.verifyAdminHomePage();
		
	}
	


}

package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminCRMPageTest;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminLoginPageTest;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.ThirdPartyPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.LaunchApplicationPageTest;
import com.guru.testing.page.LoginPageTest;
import com.guru.testing.page.MembershipPageTest;
import com.guru.testing.page.PayNowPageTest;
import com.guru.testing.page.PaymentsInvoicePageTest;
import com.guru.testing.page.PaymentsTransferPageTest;

public class UpgradeMemAllPayMethods {
	
	@Test(alwaysRun = true)
	@Parameters("currentMembership")
	@Documentation(step="Navigate to Upgrade Membership page by clicking on Upgrade.", expected="User is able to click on 'Upgrade' successfully.")
	public static void goToUpgradeMemPageTest(String currentMembership) throws Exception {
		DashboardPageTest.verifyCurrentMembershipTest(currentMembership);
		DashboardPageTest.clickUpgradeTest();
		MembershipPageTest.verifyMembershipPageTest();
	}
	
	@Test(dependsOnMethods = "goToUpgradeMemPageTest")
	@Parameters({"currentMembership", "firstUpgrade", "paymentMethod"})
	@Documentation(step="Upgrade to 'Basic+' membership plan.", expected="User is able to click on 'Select' against Basic+ successfully.")
	public static void upgradeUsingCATest(String currentMembership, String firstUpgrade, String paymentMethod) throws Exception {
		MembershipPageTest.verifyCurrentMembershipTest(currentMembership);
		MembershipPageTest.selectMembershipByNameTest(firstUpgrade);
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(paymentMethod);
		
	}
	
	@Test(dependsOnMethods = "upgradeUsingCATest")
	@Parameters({"firstUpgrade"})
	@Documentation(step="Upgrade to 'Basic+' membership plan.", expected="User is able to click on 'Select' against Basic+ successfully.")
	public static void payUsingCATest(String firstUpgrade) throws Exception {
		PayNowPageTest.clickUseCAfunds();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyMembershipInvoiceTest(firstUpgrade);
	}
	
	@Test(dependsOnMethods = "payUsingCATest")
	@Parameters({"firstUpgrade"})
	@Documentation(step="Navigate back to Membership page, and verify Membership upgraded to Basic+", expected="User is able to navigate back to Membership page, and verifies memberships upgraded successfully.")
	public static void upgradeUsingCCTest(String firstUpgrade) throws Exception {
		PayNowPageTest.clickBacktoMembershipTest();
		MembershipPageTest.verifyCurrentMembershipTest(firstUpgrade);
		
	}
	
	@Test(dependsOnMethods = "upgradeUsingCCTest")
	@Parameters({"secondUpgrade", "cardNumber", "month", "year", "cvv"})
	@Documentation(step="Upgrade to 'Professional' membership plan. Add Credit Card in the process", expected="User is able to click on 'Select' against Professional successfully, and enters Card details in the form.")
	public static void addCCTest(String secondUpgrade, String cardNumber, String month, String year, String cvv) throws Exception {
		MembershipPageTest.selectMembershipByNameTest(secondUpgrade);
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.clickPayWithCCTest();
		PaymentsTransferPageTest.enterCCNumberTest(cardNumber);
		PaymentsTransferPageTest.selectExpiryMonthTest(month);
		PaymentsTransferPageTest.selectExpiryYearTest(year);
		PaymentsTransferPageTest.enterCVVTest(cvv);
		PayNowPageTest.uncheckAutoUpgradeIfCheckedTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
		
	}
	
	@Test(dependsOnMethods = "addCCTest")
	@Parameters({"secondUpgrade"})
	@Documentation(step="Click 'Pay' to finish payment of membership upgrade using Credit card.", expected="User is able to click on 'Pay', and payment is successful.")
	public static void payUsingCCTest(String secondUpgrade) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyMembershipInvoiceTest(secondUpgrade);
	}
	
	@Test(dependsOnMethods = "payUsingCCTest")
	@Parameters({"secondUpgrade"})
	@Documentation(step="Navigate back to Membership page, and verify Membership upgraded to Professional", expected="User is able to navigate back to Membership page, and verifies memberships upgraded successfully.")
	public static void upgradeUsingPaypalTest(String secondUpgrade) throws Exception {
		PayNowPageTest.clickBacktoMembershipTest();
		MembershipPageTest.verifyCurrentMembershipTest(secondUpgrade);
		
	}
	
	@Test(dependsOnMethods = "upgradeUsingPaypalTest")
	@Parameters({"thirdUpgrade"})
	@Documentation(step="Upgrade to 'Business' membership plan.", expected="User is able to click 'Select' against Business membership.")
	public static void selectAddPaypalTest(String thirdUpgrade) throws Exception {
		MembershipPageTest.selectMembershipByNameTest(thirdUpgrade);
		PayNowPageTest.verifyPayNowPageTest();
	}
	
	@Test(dependsOnMethods = "selectAddPaypalTest")
	@Parameters({"paypalId", "paypalPass"})
	@Documentation(step="Add Paypal to complete payment.", expected="User is able to add Paypal during the payment process.")
	public static void finishPaypalAdditionTest(String paypalId, String paypalPass) throws Exception {
		PayNowPageTest.selectAddPaypalTest();
		ThirdPartyPageTest.verifyPaypalPageTest();
		ThirdPartyPageTest.enterPaypalUserIdTest(paypalId);
		ThirdPartyPageTest.enterPaypalPasswordTest(paypalPass);
		ThirdPartyPageTest.clickPaypalLoginBtnTest();
		ThirdPartyPageTest.verifyBillingAgreementTest();
	}
	
	@Test(dependsOnMethods = "finishPaypalAdditionTest")
	@Documentation(step="Verify Paypal is added as primary, and continue to make payment.", expected="Paypal is added as payment method.")
	public static void payUsingPaypalTest() throws Exception {
		ThirdPartyPageTest.clickAgreeAndContinuePaypalTest();
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaypalIsPrimaryTest();
		PayNowPageTest.uncheckAutoUpgradeIfCheckedTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = "payUsingPaypalTest")
	@Parameters({"thirdUpgrade"})
	@Documentation(step="Verify Payment through paypal is successfully made.", expected="User is shown a Payment receipt for successful payment of membership upgrade.")
	public static void verifyPaypalPaySuccessTest(String thirdUpgrade) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyMembershipInvoiceTest(thirdUpgrade);
	}
	
	@Test(dependsOnMethods = "verifyPaypalPaySuccessTest")
	@Parameters({"thirdUpgrade"})
	@Documentation(step="Navigate back to membership page, and verify Membership is upgrade.", expected="User is able to verify that their membership is upgraded.")
	public static void verifyMembershipUpgradedTest(String thirdUpgrade) throws Exception {
		PayNowPageTest.clickBacktoMembershipTest();
		MembershipPageTest.verifyMembershipPageTest();
		MembershipPageTest.verifyCurrentMembershipTest(thirdUpgrade);
	}
	
	@Test(dependsOnMethods = "verifyMembershipUpgradedTest")
	@Documentation(step="Log out from the application.", expected="User is able to logout from the application.")
	public static void logoutUserTest() throws Exception {
		DashboardPageTest.signOutFlTest();
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "logoutUserTest")
	@Parameters({"adminUrl", "adminUser", "adminPass"})
	@Documentation(step="Log in to the admin site.", expected="Able to login to the admin site.")
	public static void goToAdminSiteTest(String url, String adminUser, String adminPass) throws Exception {
		LaunchApplicationPageTest.navigateToUrlTest(url);
		AdminLoginPageTest.verifyAdminLoginPage();
		AdminLoginPageTest.enterUsername(adminUser);
		AdminLoginPageTest.enterPassword(adminPass);
	}
	
	@Test(dependsOnMethods = "goToAdminSiteTest")
	@Parameters({"username"})
	@Documentation(step="Go to the user's account in the CRM page.", expected="Able to find the user's account in the CRM page.")
	public static void goToAdminCRMTest(String username) throws Exception {
		AdminLoginPageTest.clickLogin();
		AdminHomePageTest.verifyAdminHomePage();
		AdminHomePageTest.clickCRMAccountSearch();
		AdminCRMPageTest.verifyCRMAccountSearchPageTest();
		AdminCRMPageTest.searchFLByEmailTest(username);
	}
	
	@Test(dependsOnMethods = "goToAdminCRMTest")
	@Parameters({"membershipType", "membershipDuration"})
	@Documentation(step="Downgrade the user's membership back to Basic.", expected="Able to downgrade membership successfully.")
	public static void downgradeMembershipTest(String membershipType, String membershipDuration) throws Exception {
		AdminCRMPageTest.clickMembershipTabTest();
		AdminCRMPageTest.verifyMembershipPageTest();
		AdminCRMPageTest.selectMembershipTypeTest(membershipType);
		AdminCRMPageTest.selectMembershipDurationTest(membershipDuration);
		AdminCRMPageTest.clickUpgradeMembershipTest();
		AdminCRMPageTest.verifyCurrentMembershipTest(membershipType);
	}
	
	@Test(dependsOnMethods = "downgradeMembershipTest")
	@Parameters({"membershipType"})
	@Documentation(step="Verify the membership downgrade is a success.", expected="Current membership of the user could be verified from their dashboard.")
	public static void verifyMembershipResetTest(String membershipType) throws Exception {
		AdminCRMPageTest.gotoAccountTest();
		CommonPageTest.switchToNewTabTest();
		DashboardPageTest.verifyFLDashboardPageTest();
		DashboardPageTest.verifyCurrentMembershipTest(membershipType);
	}
	
	@Test(dependsOnMethods = "verifyMembershipResetTest")
	@Parameters("currentMembership")
	@Documentation(step="", expected="")
	public static void navigateToMembershipPageTest(String currentMembership) throws Exception {
		DashboardPageTest.clickUpgradeTest();
		MembershipPageTest.verifyMembershipPageTest();
		MembershipPageTest.verifyCurrentMembershipTest(currentMembership);
	}
	
	@Test(dependsOnMethods = "navigateToMembershipPageTest")
	@Parameters({"firstUpgrade", "ccMethod"})
	@Documentation(step="", expected="")
	public static void payUsingAddedCCTest(String firstUpgrade, String ccMethod) throws Exception {
		MembershipPageTest.selectMembershipByNameTest(firstUpgrade);
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(ccMethod);
		PayNowPageTest.selectCCTest();
		PayNowPageTest.uncheckAutoUpgradeIfCheckedTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "payUsingAddedCCTest" })
	@Parameters("firstUpgrade")
	@Documentation(step="", expected="")
	public static void completeAddedCCPaymentTest(String firstUpgrade) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyMembershipInvoiceTest(firstUpgrade);
	}
	
	@Test(dependsOnMethods = { "completeAddedCCPaymentTest" })
	@Parameters({"firstUpgrade"})
	@Documentation(step="", expected="")
	public static void upgradeUsingAddedPaypalTest(String firstUpgrade) throws Exception {
		PayNowPageTest.clickBacktoMembershipTest();
		MembershipPageTest.verifyMembershipPageTest();
		MembershipPageTest.verifyCurrentMembershipTest(firstUpgrade);
	}
	
	@Test(dependsOnMethods = { "upgradeUsingAddedPaypalTest" })
	@Parameters({"secondUpgrade", "paypalMethod"})
	@Documentation(step="", expected="")
	public static void payUsingAddedPaypalTest(String secondUpgrade, String paypalMethod) throws Exception {
		MembershipPageTest.selectMembershipByNameTest(secondUpgrade);
		PayNowPageTest.verifyPayNowPageTest();
		PayNowPageTest.verifyPaymentMethodTest(paypalMethod);
		PayNowPageTest.selectPaypalTest();
		PayNowPageTest.uncheckAutoUpgradeIfCheckedTest();
		PayNowPageTest.selectAgreeToPayCheckboxTest();
	}
	
	@Test(dependsOnMethods = { "payUsingAddedPaypalTest" })
	@Parameters("secondUpgrade")
	@Documentation(step="", expected="")
	public static void completeAddedPaypalPaymentTest(String secondUpgrade) throws Exception {
		PayNowPageTest.clickPayTest();
		PayNowPageTest.verifyMembershipInvoiceTest(secondUpgrade);
	}
	
	@Test(dependsOnMethods = "completeAddedPaypalPaymentTest")
	@Parameters({"secondUpgrade"})
	@Documentation(step="Navigate back to membership page, and verify Membership is upgrade.", expected="User is able to verify that their membership is upgraded.")
	public static void verifyUpgradedMembershipTest(String secondUpgrade) throws Exception {
		PayNowPageTest.clickBacktoMembershipTest();
		MembershipPageTest.verifyMembershipPageTest();
		MembershipPageTest.verifyCurrentMembershipTest(secondUpgrade);
	}
	
	@Test(dependsOnMethods = "verifyUpgradedMembershipTest")
	@Documentation(step="Remove all payment methods.", expected="User is able to remove payment methods added to their account.")
	public static void removePaymentMethodsTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyFLDashboardPageTest();
		DashboardPageTest.clickPaymentsTabTest();
		PaymentsInvoicePageTest.verifyFLInvoicePageTest();
		PaymentsTransferPageTest.clickTransferMethodsTabTest();
		PaymentsTransferPageTest.verifyTransferMethodsPageTest();
		PaymentsTransferPageTest.removeAllPayMethodsTest();
	}
	
	@Test(dependsOnMethods = "removePaymentMethodsTest")
	@Documentation(step="Log out from the application.", expected="User is able to logout from the application.")
	public static void signOutUserTest() throws Exception {
		DashboardPageTest.signOutFlTest();
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods = "signOutUserTest")
	@Parameters({"title"})
	@Documentation(step="Navigate back to the admin site.", expected="Able to switch to admin site.")
	public static void navigateToAdminSiteTest(String title) throws Exception {
		CommonPageTest.closeCurrentWindow();
		CommonPageTest.switchToPageByTitleTest(title);
	}
	
	@Test(dependsOnMethods = "navigateToAdminSiteTest")
	@Parameters({"membershipType", "membershipDuration"})
	@Documentation(step="Downgrade the user's membership back to Basic.", expected="Able to downgrade membership successfully.")
	public static void downgradeUserMembershipTest(String membershipType, String membershipDuration) throws Exception {
		AdminCRMPageTest.selectMembershipTypeTest(membershipType);
		AdminCRMPageTest.selectMembershipDurationTest(membershipDuration);
		AdminCRMPageTest.clickUpgradeMembershipTest();
		AdminCRMPageTest.verifyCurrentMembershipTest(membershipType);
	}
	
	@Test(dependsOnMethods = "downgradeUserMembershipTest")
	@Parameters({"membershipType"})
	@Documentation(step="Verify the membership downgrade is a success.", expected="Current membership of the user could be verified from their dashboard.")
	public static void verifyMembershipDowngradedTest(String membershipType) throws Exception {
		AdminCRMPageTest.gotoAccountTest();
		CommonPageTest.switchToNewTabTest();
		DashboardPageTest.verifyFLDashboardPageTest();
		DashboardPageTest.verifyCurrentMembershipTest(membershipType);
	}
}

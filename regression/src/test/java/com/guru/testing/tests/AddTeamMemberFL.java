package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.CommonPageTest;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.EmailPageTest;
import com.guru.testing.page.LaunchApplicationPageTest;
import com.guru.testing.page.LoginPageTest;
import com.guru.testing.page.ManagePageTest;
import com.guru.testing.page.SwitchBoardPageTest;
import com.guru.testing.page.WorkroomPageTest;

public class AddTeamMemberFL {
	
	public static String[] email;
	
	@Test(alwaysRun=true)
	@Parameters({"index"})
	@Documentation(step="Navigation to a workroom in from the FL's dashboard.", expected="FL is able to navigate from Dashboard to respective workroom.")
	public static void goToAWorkroomTest(int index) throws Exception{
		DashboardPageTest.clickFLWorkroomByIndex(index);
		WorkroomPageTest.verifyFLWorkroomPageTest();
	}
	
	@Test(dependsOnMethods="goToAWorkroomTest")
	@Parameters({"userEmails", "userRoles"})
	@Documentation(step="Go to 'My Team' tab in workroom, and send team member invites for two users: one with Consultant and other with Manager roles.", expected="Able to select roles and send email invites for adding members to team.")
	// userEmails and userRoles should be separated by a hyphen ( - )
	public static void addTeamMemberTest(String userEmails, String userRoles) throws Exception{
		WorkroomPageTest.clickMyTeamTabTest();
		WorkroomPageTest.verifyMyTeamPageTest();
		WorkroomPageTest.clickBuildMyTeamTest();
		WorkroomPageTest.verifyInviteTeamMembersFLTest();
		WorkroomPageTest.enterTeamMemberInfoFLTest(userEmails, userRoles);
	}
	
	@Test(dependsOnMethods="addTeamMemberTest")
	@Documentation(step="Verify that the invitation was successfully sent.", expected="Able to verify.")
	public static void verifyRequestSentTest() throws Exception{
		WorkroomPageTest.clickAddTeamMemberFLTest();
		WorkroomPageTest.verifyMyTeamPageTest();
		WorkroomPageTest.verifyInvitationSentFLTest();
	}
	
	@Test(dependsOnMethods="verifyRequestSentTest")
	@Parameters({"emailUrl", "userEmails"})
	@Documentation(step="Navigate to the first user's email inbox. ", expected="Navigation to user's inbox successful.")
	public static void navigateToInboxOneTest(String emailUrl, String userEmails) throws Exception{
		email = userEmails.split("-");
		DashboardPageTest.signOutFlTest();
		LoginPageTest.verifyLoginPageTest();
		LaunchApplicationPageTest.navigateToUrlTest(emailUrl);
		EmailPageTest.enterMailIdTest(email[0]);
		EmailPageTest.clickGoTest();
		EmailPageTest.verifyMailinatorInboxTest();
		EmailPageTest.clickYoureInvitedTest();
	}
	
	@Test(dependsOnMethods="navigateToInboxOneTest")
	@Parameters({"pageTitle", "password"})
	@Documentation(step="Accept the invitation in the User's email.", expected="User clicks on Accept button in their email, and they are navigated to login page of Guru application.")
	public static void acceptInviteOneTest(String pageTitle, String password) throws Exception{
		EmailPageTest.clickAcceptBtnTest();
		CommonPageTest.switchToPageByTitleTest(pageTitle);
		LoginPageTest.verifyLoginPageTest();
		LoginPageTest.enterEmailOrUsernameTest(email[0]);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="AcceptInviteOneTest")
	@Documentation(step="Verify Switchboard for the first user appears after they login.", expected="Switchboard appears once the user logs into the application.")
	public static void verifySwitchBoardOneTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		SwitchBoardPageTest.verifySwitchBoardPageTest();
		SwitchBoardPageTest.clickSettingIconTest();
		
	}
	
	@Test(dependsOnMethods="verifySwitchBoardOneTest")
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutFirstMemberTest() throws Exception{
		SwitchBoardPageTest.clickSignOutTest();
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutFirstMemberTest")
	@Parameters({"emailUrl"})
	@Documentation(step="Navigate to the second user's email inbox. ", expected="Navigation to user's inbox successful.")
	public static void navigateToInboxTwoTest(String emailUrl) throws Exception{
		LaunchApplicationPageTest.navigateToUrlTest(emailUrl);
		EmailPageTest.enterMailIdTest(email[1]);
		EmailPageTest.clickGoTest();
		EmailPageTest.verifyMailinatorInboxTest();
		EmailPageTest.clickYoureInvitedTest();
	}
	
	@Test(dependsOnMethods="navigateToInboxTwoTest")
	@Parameters({"pageTitle", "password"})
	@Documentation(step="Accept the invitation in the User's email.", expected="User clicks on Accept button in their email, and they are navigated to login page of Guru application.")
	public static void AcceptInviteTwoTest(String pageTitle, String password) throws Exception{
		EmailPageTest.clickAcceptBtnTest();
		CommonPageTest.switchToPageByTitleTest(pageTitle);
		LoginPageTest.verifyLoginPageTest();
		LoginPageTest.enterEmailOrUsernameTest(email[1]);
		LoginPageTest.enterPasswordTest(password);
	}
	
	@Test(dependsOnMethods="AcceptInviteTwoTest")
	@Documentation(step="Verify Switchboard for the second user appears after they login.", expected="Switchboard appears once the user logs into the application.")
	public static void verifySwitchBoardTwoTest() throws Exception{
		LoginPageTest.clickSignInButtonTest();
		SwitchBoardPageTest.verifySwitchBoardPageTest();
		SwitchBoardPageTest.clickSettingIconTest();	
	}
	
	@Test(dependsOnMethods="verifySwitchBoardTwoTest")
	@Documentation(step="Sign out the user from the application.", expected="Successfully signed out.")
	public static void signOutSecondMemberTest() throws Exception{
		SwitchBoardPageTest.clickSignOutTest();
		LoginPageTest.verifyLoginPageTest();
	}
	
	@Test(dependsOnMethods="signOutSecondMemberTest")
	@Parameters({"username", "password"})
	@Documentation(step="Login using the parent user from which the invitation was sent initially.", expected="Login successfully done.")
	public static void loginFLTest(String username, String password) throws Exception{
		LoginPageTest.enterEmailOrUsernameTest(username);
		LoginPageTest.enterPasswordTest(password);
		LoginPageTest.clickSignInButtonTest();
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
	@Test(dependsOnMethods="loginFLTest")
	@Parameters({"index"})
	@Documentation(step="Go to the workroom the team members were added from initially.", expected="Navigation to the workroom successful.")
	public static void goToAWorkroomAgainTest(int index) throws Exception{
		DashboardPageTest.clickFLWorkroomByIndex(index);
		WorkroomPageTest.verifyFLWorkroomPageTest();
	}
	
	@Test(dependsOnMethods="goToAWorkroomAgainTest")
	@Parameters("teamScreenNames")
	@Documentation(step="Verify Team Members successfully added.", expected="Team members are successfully added to the workroom.")
	public static void verifyTeamMembersAddedTest(String teamScreenNames) throws Exception{
		WorkroomPageTest.clickMyTeamTabTest();
		WorkroomPageTest.verifyMyTeamPageTest();
		WorkroomPageTest.verifyTeamMembersAddedTest(teamScreenNames);
	}
	
	@Test(dependsOnMethods="verifyTeamMembersAddedTest")
	@Documentation(step="Remove the team members from the user's account by going to 'Manage Team' from dashboard.", expected="Removal success.")
	public static void removeMembersAddedTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyFLDashboardPageTest();
		DashboardPageTest.clickManageTeamTest();
		ManagePageTest.verifyFLManageTeamPageTest();
		ManagePageTest.clickFirstConsultantDropdownTest();
		ManagePageTest.clickRemoveInDropdownTest();
		ManagePageTest.clickFirstManagerDropdownTest();
		ManagePageTest.clickRemoveInDropdownTest();
	}

	@Test(dependsOnMethods="removeMembersAddedTest")
	@Documentation(step="Go back to the user's dashboard.", expected="Navigation to the dashboard successful.")
	public static void goBacktoDashboardTest() throws Exception {
		DashboardPageTest.clickDashboardTopNavTest();
		DashboardPageTest.verifyFLDashboardPageTest();
	}
	
}

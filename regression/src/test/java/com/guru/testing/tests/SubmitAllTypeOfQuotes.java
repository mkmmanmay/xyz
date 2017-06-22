package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.FindJobsPageTest;
import com.guru.testing.page.JobDetailsPageTest;

public class SubmitAllTypeOfQuotes {
  
	@Test(alwaysRun = true)
	@Documentation(step="Navigate to the Find Jobs page.", expected="Navigation to the Find Jobs page is successful.")
	public static void navigateToFindJobsTest() throws Exception {
		DashboardPageTest.clickSearchIconTopPanelTest();
		FindJobsPageTest.verifyFindJobsPageTest();
	}
	
	@Test(dependsOnMethods = "navigateToFindJobsTest")
	@Documentation(step="Click on 'Apply' button corresponding to the first job.", expected="Clicking on Apply navigates the user to the Job Details page.")
	@Parameters("jobIndex")
	public static void goToFirstJobTest(int jobIndex) throws Exception {
		FindJobsPageTest.applyJobByIndexTest(jobIndex);
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "goToFirstJobTest")
	@Documentation(step="Craft a Milestone Quote", expected="Able to enter valid milestone details")
	@Parameters({"noOfMilestones", "milestoneNames", "milestoneDueDates", "milestoneAmounts", "safepayOption", "scopeOfWork"})
	public static void craftFirstQuoteTest(int noOfMilestones, String milestoneNames, String milestoneDueDates
			, String milestoneAmounts, String safepayOption, String scopeOfWork) throws Exception {
		JobDetailsPageTest.clickApplyTest();
		JobDetailsPageTest.verifyApplyQuotesFormTest();
		JobDetailsPageTest.enterMilestonesTest(noOfMilestones, milestoneNames, milestoneDueDates, milestoneAmounts);
		JobDetailsPageTest.selectSafePayOptionTest(safepayOption);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
		JobDetailsPageTest.clickAcceptManuallyTest();
	}
	
	@Test(dependsOnMethods = "craftFirstQuoteTest")
	@Documentation(step="Send the milestone based quote, and verify its successful submission.", expected="Milestone based quote is successfully sent.")
	public static void submitFirstQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods = "submitFirstQuoteTest")
	@Documentation(step="Navigate to the Find Jobs Page again.", expected="Navigation is successful, and Find Jobs page loads.")
	public static void goToFindJobsTest() throws Exception {
		DashboardPageTest.clickSearchIconTopPanelTest();
		FindJobsPageTest.verifyFindJobsPageTest();
	}
	
	@Test(dependsOnMethods = "goToFindJobsTest")
	@Documentation(step="Go to the second Job in the list.", expected="Clicking on Apply navigates the user to the Job Details page.")
	@Parameters("jobIndex")
	public static void goToSecondJobTest(int jobIndex) throws Exception {
		FindJobsPageTest.applyJobByIndexTest(jobIndex);
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "goToSecondJobTest")
	@Documentation(step="Craft an Hourly Based Quote", expected="Able to enter valid Hourly based quote details")
	@Parameters({"secondAgreement", "hours", "rate", "scopeOfWork" })
	public static void craftSecondQuoteTest(String agreement, String hours, String rate, String scopeOfWork) throws Exception {
		JobDetailsPageTest.clickApplyTest();
		JobDetailsPageTest.verifyApplyQuotesFormTest();
		JobDetailsPageTest.selectAgreementTypeTest(agreement);
		JobDetailsPageTest.enterHoursPerWeekTest(hours);
		JobDetailsPageTest.enterRateTest(rate);
		JobDetailsPageTest.setLastDateInPopupTest();
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "craftSecondQuoteTest")
	@Documentation(step="Send the hourly based quote, and verify its successful submission.", expected="Hourly based quote is successfully sent.")
	public static void submitSecondQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods = "submitSecondQuoteTest")
	@Documentation(step="Navigate to the Find Jobs Page again.", expected="Navigation is successful, and Find Jobs page loads.")
	public static void switchToFindJobsTest() throws Exception {
		DashboardPageTest.clickSearchIconTopPanelTest();
		FindJobsPageTest.verifyFindJobsPageTest();
	}
	
	@Test(dependsOnMethods = "switchToFindJobsTest")
	@Documentation(step="Go to the Third Job in the list.", expected="Clicking on Apply navigates the user to the Job Details page.")
	@Parameters("jobIndex")
	public static void goToThirdJobTest(int jobIndex) throws Exception {
		FindJobsPageTest.applyJobByIndexTest(jobIndex);
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "goToThirdJobTest")
	@Documentation(step="Craft a Recurring based Quote", expected="Able to enter valid Recurring based quote details")
	@Parameters({"thirdAgreement", "noOfRecurring", "recurringDescs", "recurringDurations", "recurringRates", "recurringDueDates", "scopeOfWork"})
	public static void craftThirdQuoteTest(String agreement, int noOfRecurring, String recurringDescs, 
			String recurringDurations, String recurringRates, String recurringDueDates, String scopeOfWork) throws Exception {
		JobDetailsPageTest.clickApplyTest();
		JobDetailsPageTest.verifyApplyQuotesFormTest();
		JobDetailsPageTest.selectAgreementTypeTest(agreement);
		JobDetailsPageTest.enterRecurringDataTest(noOfRecurring, recurringDescs, recurringDurations, recurringRates, recurringDueDates);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "craftThirdQuoteTest")
	@Documentation(step="Send the Recurring based quote, and verify its successful submission.", expected="Recurring based quote is successfully sent.")
	public static void submitThirdQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods = "submitThirdQuoteTest")
	@Documentation(step="Navigate to the Find Jobs Page again.", expected="Navigation is successful, and Find Jobs page loads.")
	public static void moveToFindJobsTest() throws Exception {
		DashboardPageTest.clickSearchIconTopPanelTest();
		FindJobsPageTest.verifyFindJobsPageTest();
	}
	
	@Test(dependsOnMethods = "moveToFindJobsTest")
	@Documentation(step="Go to the fourth Job in the list.", expected="Clicking on Apply navigates the user to the Job Details page.")
	@Parameters("jobIndex")
	public static void goToFourthJobTest(int jobIndex) throws Exception {
		FindJobsPageTest.applyJobByIndexTest(jobIndex);
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "goToFourthJobTest")
	@Documentation(step="Craft a Task based Quote", expected="Able to enter valid Task based quote details")
	@Parameters({"fourthAgreement", "scopeOfWork"})
	public static void craftFourthQuoteTest(String agreement, String scopeOfWork) throws Exception {
		JobDetailsPageTest.clickApplyTest();
		JobDetailsPageTest.verifyApplyQuotesFormTest();
		JobDetailsPageTest.selectAgreementTypeTest(agreement);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "craftFourthQuoteTest")
	@Documentation(step="Send the Task based quote, and verify its successful submission.", expected="Task based quote is successfully sent.")
	public static void submitFourthQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
	
	@Test(dependsOnMethods = "submitFourthQuoteTest")
	@Documentation(step="Navigate to the Find Jobs Page again.", expected="Navigation is successful, and Find Jobs page loads.")
	public static void navToFindJobsTest() throws Exception {
		DashboardPageTest.clickSearchIconTopPanelTest();
		FindJobsPageTest.verifyFindJobsPageTest();
	}
	
	@Test(dependsOnMethods = "navToFindJobsTest")
	@Documentation(step="Go to the fifth Job in the list.", expected="Clicking on Apply navigates the user to the Job Details page.")
	@Parameters("jobIndex")
	public static void goToFifthJobTest(int jobIndex) throws Exception {
		FindJobsPageTest.applyJobByIndexTest(jobIndex);
		JobDetailsPageTest.verifyJobDetailsPageTest();
	}
	
	@Test(dependsOnMethods = "goToFifthJobTest")
	@Documentation(step="Craft a Task Placeholder bid", expected="Able to craft a placeholder bid.")
	@Parameters({"fifthAgreement", "scopeOfWork"})
	public static void craftFifthQuoteTest(String agreement, String scopeOfWork) throws Exception {
		JobDetailsPageTest.clickApplyTest();
		JobDetailsPageTest.verifyApplyQuotesFormTest();
		JobDetailsPageTest.selectAgreementTypeTest(agreement);
		JobDetailsPageTest.enterScopeOfWorkTest(scopeOfWork);
	}
	
	@Test(dependsOnMethods = "craftFifthQuoteTest")
	@Documentation(step="Send the Placeholder bid, and verify its successful submission.", expected="Placeholder Bid is successfully sent.")
	public static void submitFifthQuoteTest() throws Exception {
		JobDetailsPageTest.clickToSubmitQuoteTest();
		JobDetailsPageTest.verifyQuoteSubmittedTest();
	}
}

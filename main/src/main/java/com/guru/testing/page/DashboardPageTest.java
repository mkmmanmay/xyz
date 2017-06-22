package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.helpers.WindowHandler;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.framework.testing.selenium.WebDriverWaits;
import com.guru.testing.objectmap.DashboardPageObjectMap;

public class DashboardPageTest {
	public static final String PAGE_ID=DashboardPageTest.class.getName();
	private static String WINDOW_HANDLE=null;
	private static int msgCountBefore = 0;
	private static int msgCountAfter = 0;
	public static String jobWorkroomName = null;
	public static float CASH_ACCOUNT_BALANCE;
	
	@Test
	@Documentation(step = "Verify the Dashboard page for Freelancer's login.", expected = "Dashboard page for Freelancer login should appear.")
	public static void verifyFLDashboardPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			try {
				BrowserWait.waitUntilPageTitle("Dashboard - Freelancers - Guru");
				
			} catch (Exception e) {
				BrowserWait.waitUntilPageTitle("Edit Services - Build Profile - Freelancers - Guru");
			}
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_DASHBOARD_TAB_XPATH);		
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_LEADS_TAB_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_QUOTES_TAB_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_JOBS_TAB_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_PAYMENTS_TAB_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_MESSAGES_TAB_XPATH);
				
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"All required elements on Dashboard page didnot load");
		}
	}
	
	@Test
	@Documentation(step = "Launch Tiny URL for job.", expected = "Job page should open.")
	public static void launchTinyURLTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.openBrowser(HirePageTest.tinyUrl);
		} catch (Exception e) {
			throw new ScriptException("Unable to launch tiny url.");
		}
	}
	
	
	@Test
	@Documentation(step = "Verify the Dashboard page for Employer's login.", expected = "Dashboard page for Employer login should appear.")
	public static void verifyEMPDashboardPageTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Dashboard - Employers - Guru");
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_DASHBOARD_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_WIDGET_PANE_ID);			
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_POST_A_JOB_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_HIRE_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_MANAGE_TAB_XPATH);
			try {
				BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_PAY_TAB_XPATH);
			} catch (Exception e) {
				ScriptLogger.debug("Pay tab not there; possible this is not a 'Owner' role login."); 
			}
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_MESSAGES_TAB_XPATH);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "All required Elements on Employer Dashboard page didnot load ");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Manage Team' on the Dashboard..", expected = "Able to click.")
	public static void clickManageTeamTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_MANAGE_TEAM_PLINK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 'Manage Team'.");
		}
	}

	@Test
	@Parameters("workroomIndex")
	@Documentation(step = "Click an active workroom.", expected = "Able to click.")
	public static void clickEMPWorkroomByIndexTest(int index) throws Exception {		
		ScriptLogger.info();
		try {
			List<WebElement> workrooms = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_WORKROOM_EMP_JOBS_LIST_XPATH);
			workrooms.get(index).findElement(By.tagName("a")).click();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}

	@Test
	@Parameters("workroomIndex")
	@Documentation(step = "Click first active workroom.", expected = "Able to click.")
	public static void clickFLWorkroomByIndexTest(int index) throws Exception {		
		ScriptLogger.info();
		try {
			List<WebElement> workrooms = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_WORKROOM_FL_JOBS_LIST_XPATH);
			workrooms.get(index-1).findElement(By.tagName("a")).click();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Parameters("jobName")
	@Documentation(step = "Click on the job." , expected = "Able to click.")
	public static void clickJobUnderQuotesTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_JOBS_LIST_XPATH);
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(name)) {
					WebDriverAction.click(job);
					break;
				} else {
					ScriptLogger.debug("Still searching...");
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. ");
		}
	}
	
	@Test
	@Parameters("workroomIndex")
	@Documentation(step = "Get name of the workroom by its index." , expected = "Able to retrieve data.")
	public static void getEMPWorkroomJobNameByIndex(int index) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> workrooms = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_WORKROOM_EMP_JOBS_LIST_XPATH);
			jobWorkroomName = workrooms.get(index-1).findElement(By.tagName("a")).getText();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the job name randomly generated and posted.." , expected = "Able to click.")
	public static void clickRandomJobnameWorkroomTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_WORKROOM_EMP_JOBS_LIST_XPATH);
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(PostAJobPageTest.RANDOM_JOB_TITLE)) {
					WebDriverAction.click(job);
					break;
				} else {
					ScriptLogger.debug("Still searching...");
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the job name randomly generated and posted.." , expected = "Able to click.")
	public static void clickRandomJobnamePostedTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_JOBS_LIST_XPATH);
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(PostAJobPageTest.RANDOM_JOB_TITLE)) {
					WebDriverAction.click(job);
					break;
				} else {
					ScriptLogger.debug("Still searching...");
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the job name randomly generated in which acceptance is pending on fl side.." , expected = "Able to click.")
	public static void clickAcceptRandomJobHireFLTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_CURRENT_JOBS_PENDING_ACCEPTANCE_JOBS_CONTAINER_XPATH);
			int index=0;
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(PostAJobPageTest.RANDOM_JOB_TITLE)) {
					break;
				} else {
					index++;
				}
			}
			jobList.get(index).findElement(By.cssSelector(".module_btn.primary_btn")).click();
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. ");
		}
	}
	
	@Test
	@Documentation(step = "Click on the job name randomly generated and posted.." , expected = "Able to click.")
	public static void clickFLWorkroomByNameTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_CURRENT_JOBS_HIRED_IN_JOB_NAMES_XPATH);
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(jobWorkroomName)) {
					WebDriverAction.click(job);
					break;
				} else {
					ScriptLogger.debug();
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. ");
		}
	}
	
	@Test
	@Documentation(step = "Click on the job name randomly generated and posted.." , expected = "Able to click.")
	public static void clickHiredRandomJobFLTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_CURRENT_JOBS_HIRED_IN_JOB_NAMES_XPATH);
			for(WebElement el : jobList) {
				WebElement job = el.findElement(By.tagName("a"));
				String jobName = job.getText();
				if(jobName.equalsIgnoreCase(PostAJobPageTest.RANDOM_JOB_TITLE)) {
					WebDriverAction.click(job);
					break;
				} else {
					ScriptLogger.debug();
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. ");
		}
	}
	
	@Test
	@Documentation(step = "Click 'My Managers' link in the EMP Dashboard page..", expected = "Jobs tab should be clicked")
	public static void clickMyManagersLinkTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_MY_MANAGERS_PLINK);			
		} catch (Exception e) {
			throw new ScriptException("Either Locator issue, or Selenium click issue. If neither, it's an application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click Jobs tab top panel on the FL side.", expected = "Jobs tab should be clicked")
	public static void clickJobsTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_JOBS_TAB_XPATH);			
		} catch (Exception e) {
			throw new ScriptException("Either Locator issue, or Selenium click issue. If neither, it's an application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click Search icon in top panel.", expected = "The search icon is clicked, and redirected to respective page.")
	public static void clickSearchIconTopPanelTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_TOP_SEARCH_ICON_ID);			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Search Icon");
		}
	}
	
	@Test
	@Documentation(step = "Click Post a Job in Top Nav.", expected = "Post a job is clicked")
	public static void clickPostAJobTopNavTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_POST_A_JOB_TAB_ID);			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Post a Job tab");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Dashboard' in top navigation panel.", expected = "The Dashboard tab is clicked, and redirected to respective page.")
	public static void clickDashboardTopNavTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_DASHBOARD_TAB_XPATH);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Dashboard Top tab not loaded");
		}
		
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_DASHBOARD_TAB_XPATH);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Pay tab top panel.", expected = "Pay tab should be clicked")
	public static void clickPayTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_PAY_TAB_XPATH);			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Pay Tab was not clicked");
		}
	}
	
	@Test
	@Documentation(step = "Click Payments tab top panel for an employer", expected = "Payments tab should be clicked")
	public static void clickPaymentsTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_PAYMENTS_TAB_XPATH);			
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: Pay Tab was not clicked");
		}
	}
	@Test
	@Documentation(step = "Click Sign Out for Employer on top right", expected = "Sign Out should be clicked")
	public static void signOutEmployerTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.refresh();
			BrowserAction.switchToDefaultContent();
			Thread.sleep(3000);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_SIGN_OUT_XPATH);
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_SIGN_OUT_XPATH);
			/*WebElement signoutbtn = BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_SIGN_OUT_XPATH);	
			signoutbtn.click();	*/
		} catch (Exception e) {
			throw new ScriptException(" Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click Sign Out for a Freelancer on top right", expected = "Sign Out should be clicked")
	public static void signOutFlTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.refresh();
			BrowserAction.switchToDefaultContent();
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_SIGN_OUT_XPATH);			
		} catch (Exception e) {
			throw new ScriptException(" Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Freelancer' image icon in the top right corner to get dropdown options.", expected = "User is able to click their image icon in the top right corner.")
	public static void clickFLOwnerDropdownOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_ICON_BUTTON_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_PANE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Application Issue: FL owner dropdown is not loaded");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Edit profile' link in the dropdown options.", expected = "User is able to click Edit Profile")
	public static void clickEditProfileTest() throws Exception {

		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_EDIT_PROFILE_LINK_ID); 
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Buy Bids' link in the dropdown options.", expected = "User is able to click Buy bids")
	public static void clickBuyBidsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_BUY_BIDS_LINK_ID); 
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	

	@Test
	@Parameters("currentMembership")
	@Documentation(step = "verifyCurrentMembershipTest", expected = "")
	public static void verifyCurrentMembershipTest(String currentMembership) throws Exception {
		ScriptLogger.info();
		String membership= currentMembership+" Member";
			if(!membership.equalsIgnoreCase(BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_MEMBERSHIP_TYPE_ID).getText())){
				throw new ApplicationException("Expected Membership: "+currentMembership + ""+ "Actual Membership="+BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_MEMBERSHIP_TYPE_ID).getText());
			}
		
	}
	
	@Test
	@Documentation(step = "clickUpgradeTest", expected = "")
	public static void clickUpgradeTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_MEMBERSHIP_UPGRADE_LINK_ID); 
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "clickMembershipInDropdownOptionsTest", expected = "")
	public static void clickMembershipInDropdownOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_MEMBERSHIP_LINK_ID); 
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "clickFLQuotesTabTest", expected = "")
	public static void clickFLQuotesTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_FL_QUOTES_TAB_XPATH); 
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "selectLatestJobQuoteTest", expected = "")
	public static void selectLatestJobQuoteTest() throws Exception {
		selectJobQuoteByIndexTest(1);

	}
	
	@Test
	@Parameters("quoteIndex")
	@Documentation(step = "selectJobQuoteByIndexTest", expected = "")
	public static void selectJobQuoteByIndexTest(int index) throws Exception {
		try {

			List<WebElement> list = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_EMP_QUOTE_PLINK);
			list.remove(0);
			list.get(index - 1).click();

		} catch (Exception e) {
			throw new ScriptException(e);
		}

	}


	@Test
	@Documentation(step = "verifyHiredInPostedJobTest", expected = "")
	public static void verifyHiredInPostedJobTest() throws Exception {
		ScriptLogger.info();
		try {			
			WebDriverWaits.waitUntilElementIsDisplayed(By.partialLinkText(PostAJobPageTest.RANDOM_JOB_TITLE));
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// ------------------------ ALERTS SECTION EMP -----------------------
	// ---------------------------- START --------------------------------
	@Test
	@Documentation(step = "Verify 'Agreement Pending' alert appeared in the Alerts section", expected = "Able to verify.")
	public static void verifyAgreementPendingAlertTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> alerts = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_ALERT_SECTION_ALERT_NAMES_XPATH);
			for(WebElement el : alerts) {
				WebElement name = el.findElement(By.tagName("strong"));
				String alertType = name.getText();
				if(alertType.equalsIgnoreCase("Agreement Pending")) {
					break;
				} else {
					throw new ApplicationException("Agreement Pending alert on EMP side didn't appear.");
				}
			}
		} catch (Exception e) {
			throw new ApplicationException("Refer to method in class for possible exception reason.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Agreement Pending' alert appeared in the Alerts section", expected = "Able to Click.")
	public static void clickAgreementPendingAlertTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> alerts = BrowserAction.getElements(DashboardPageObjectMap.DASHBOARD_PAGE_ALERT_SECTION_ALERT_NAMES_XPATH);
			int index=0;
			for(WebElement el : alerts) {
				WebElement name = el.findElement(By.tagName("strong"));
				String alertType = name.getText();
				if(alertType.equalsIgnoreCase("Agreement Pending")) {
					break;
				} else {
					index++;
				}
			}
			alerts.get(index).click();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	
	// --------------- UNREAD MESSAGES COUNT RELATED ----------------------
	// --------------------------- START ----------------------------------
	
	@Test
	@Documentation(step = "Get Unread Messages count before", expected = "Able to get count of unread messages.")
	public static void getMsgsCountBeforeTest() throws Exception {
		ScriptLogger.info();
		try {
			try{
				BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_MESSAGES_TOP_NAV_COUNT_ID).isDisplayed();
				String count = BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_MESSAGES_TOP_NAV_COUNT_ID).getText();
				msgCountBefore = Integer.parseInt(count);
			} catch (Exception e) {
				msgCountBefore = 0;
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Get Messages count after", expected = "Able to get count of unread messages.")
	public static void getMsgsCountAfterTest() throws Exception {
		ScriptLogger.info();
		try {
			if(BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_MESSAGES_TOP_NAV_COUNT_ID).isDisplayed()) {
				String count = BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_MESSAGES_TOP_NAV_COUNT_ID).getText();
				msgCountAfter = Integer.parseInt(count);
			} else {
				msgCountAfter = 0;
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify unread Messages count remain unchanged.", expected = "Unread Messages count should remain unchanged.")
	public static void verifyCountUnchangedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!Integer.valueOf(msgCountBefore).equals(Integer.valueOf(msgCountAfter))){
				throw new ApplicationException("Unread Messages count changed even without adding a testimonial");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("countIncreaseBy")
	@Documentation(step = "Verify Unread Messages count increased.", expected = "Unread Messages count should increase.")
	public static void verifyCountIncreasedTest(int increase) throws Exception {
		ScriptLogger.info();
		try {
			if(!(msgCountAfter - msgCountBefore == increase)){
				throw new ApplicationException("Unread Messages count didn't increase even after sending new message from FL.");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	@Test
	@Documentation(step = "Verify unread Messages count decreased.", expected = "Unread Messages count should decrease.")
	public static void verifyCountDecreasedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!(msgCountBefore > msgCountAfter)){
				throw new ApplicationException("Unread Messages count didn't decrease even after reading all or some of the unread messages.");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// ----------------------------- END ----------------------------------
	
	// --------------- ENTER CONTACT INFORMATION PAGE ----------------------
	// ----------------------------- START ---------------------------------
	
	@Test
	@Documentation(step = "Verify the Dashboard page for Employer's login.", expected = "Dashboard page for Employer login should appear.")
	public static void verifyEnterContactInfoPageTest() throws Exception {		
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Dashboard - Freelancers - Guru");
			BrowserWait.waitUntilText("Enter Contact Information");
			BrowserWait.waitUntilText("This is kept confidential and used for billing so you can get paid!");
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ADDRESS_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CITY_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CITY_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_COUNTRY_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_COUNTRY_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_STATE_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_STATE_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ZIP_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ZIP_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_TIME_ZONE_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_TIME_ZONE_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CONTINUE_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for ENTER CONTACT INFORMATION page verification didn't appear; a possible Application issue. Verify screenshot.");
		}
	}
	
	@Test
	@Parameters("address")
	@Documentation(step = "Enter Search Address.", expected = "Able to enter")
	public static void enterAddressTest(String address) throws Exception {		
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXTBOX_XPATH, address);
			BrowserAccess.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXTBOX_XPATH).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter data in text box.");
		}
	}
	
	@Test
	@Documentation(step = "Click Continue button in the Contact Information page.", expected = "Able to click.")
	public static void clickContinueBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CONTINUE_BUTTON_XPATH); 
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to click on Continue button.");
		}
	}
	
	// ----------------------------- END ----------------------------------
	
	public static void switchToThisWindow() throws Exception{
		ScriptLogger.info();
		try{
			if(WINDOW_HANDLE==null){
				WINDOW_HANDLE=WindowHandler.getWindowHandle(PAGE_ID);
			}
			WebDriverAction.getDriver().switchTo().window(WINDOW_HANDLE);
			WebDriverAction.getDriver().manage().window().maximize();

		}catch(Exception e){
			throw new ScriptException(e);
		}
	}

	public static float getCashAccountBalance() throws Exception {
		ScriptLogger.info();
		DashboardPageTest.clickDashboardTopNavTest();
		try {
			CASH_ACCOUNT_BALANCE=(CommonPageTest.getAmount(BrowserAction.getElement(DashboardPageObjectMap.DASHBOARD_PAGE_CASH_ACCOUNT_LINK_XPATH),""));		
					return CASH_ACCOUNT_BALANCE;		
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to get cash account balance on dashboard page");
		}
		
		
	}

	public static void clickWithdrawLink() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_CASH_ACCOUNT_WITHDRAW_PLINK);			
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to click withdraw link on dashboard");
		}
		
		
	}
		
}

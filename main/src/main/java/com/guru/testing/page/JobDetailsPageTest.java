package com.guru.testing.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.helpers.FileHandler;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.framework.testing.selenium.WebDriverWaits;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.JobDetailsPageObjectMap;
import com.guru.testing.objectmap.WorkroomPageObjectMap;


public class JobDetailsPageTest {
	
	@Test
	@Documentation(step = "Verify Job Details Page.", expected = "Able to verify.")
	public static void verifyJobDetailsPageTest() throws Exception {
		ScriptLogger.info();
			verifyJobDetailsLeftPaneTest();
			verifyJobDetailsApplyPaneTest();
			verifyEmpStatsTest();
			verifySimilarJobsTest();
			verifyShareUrlTest();
	}
		
	@Test
	@Documentation(step = "Verify Share URL section.", expected = "Able to verify.")	
	public static void verifyShareUrlTest() throws Exception {		
		BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_SHARE_LINK_SECTION_ID);
		BrowserWait.waitUntilText("Share This Job"); 
		BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_TINY_URL_ID);		
	}

	@Test
	@Documentation(step = "Verify Similar Jobs Section.", expected = "Able to verify.")
	public static void verifySimilarJobsTest() throws Exception {
		BrowserWait.waitUntilText("Similar Jobs"); 
		BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_SIMILAR_JOBS_SECTION_ID);
		
	}


	@Test
	@Documentation(step = "Verify Employer Stats section.", expected = "Able to verify.")
	public static void verifyEmpStatsTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_EMPLOYER_STATS_DIV_ID);
			BrowserWait.waitUntilText("Paid","Feedback","Unpaid Invoices","Paid Job","Amount Paid / Job");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_EMPLOYER_AVATAR_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_EMPLOYER_NAME_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_EMPLOYER_LOCATION_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Emp Stats section elements are not loaded ");
		}
		
	}

	@Test
	@Documentation(step = "Verify Job Details Apply Pane.", expected = "Able to verify.")
	public static void verifyJobDetailsApplyPaneTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_NOW_SECTION_ID);			
			BrowserWait.waitUntilText("Apply Now!","How well you match this job is determined by the contents of");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_YOUR_PROFILE_PLINK);
			BrowserWait.waitUntilText(". The more keyword-rich ");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_SERVICES_AND_WORK_COLLECTION_PLINK);
			BrowserWait.waitUntilText("you have, the better your chances!");	
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_BUTTON_ID);	
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Apply Section elements are not loaded");
		}
		
	}

	@Test
	@Documentation(step = "Verify Job Details Left side pane.", expected = "Able to verify.")
	public static void verifyJobDetailsLeftPaneTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_JOB_DETAILS_LEFT_PANE_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_JOB_TITLE_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_FAVORITE_HEART_ICON_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_EXPIRES_ON_ID);
			BrowserWait.waitUntilText("Job Details");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_TOTAL_QUOTES_ID);
			BrowserWait.waitUntilText("Budget","Exposure"); 
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_QUOTES_COUNT_TOP_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_SKILLS_LIST_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_JOB_DESCRIPTION_XPATH);			
			BrowserWait.waitUntilText("Ask a question about this job");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_ASK_QUESTION_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLICATION_DETAILS_SECTION_ID);
			BrowserWait.waitUntilText("Quotes","Premium","Invited","Hired","Invited- Not Applied");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_QUOTES_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_QUOTES_COUNT_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_PREMIUN_QUOTES_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_PREMIUM_QUOTES_COUNT_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_INVITED_APPLICANTS_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_INVITED_APPLICANTS_COUNT_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_HIRED_COUNT_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_INVITED_NOT_APPLIED_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_INVITED_NOT_APPLIED_COUNT_BOTTOM_SPAN_ID);
			BrowserWait.waitUntilText("Job ID:");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_REPORT_PROJECT_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Job Details Left Pane elements are not loaded not loaded");
		}
	}

	@Test
	@Documentation(step = "Click 'Apply' button to open the Apply form.", expected = "Able to click.")
	public static void clickApplyTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_BUTTON_ID);
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to click Apply Button");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Apply quotes form section.", expected = "Able to verify.")
	public static void verifyApplyQuotesFormTest() throws Exception {
		ScriptLogger.info();
		verifyJobDetailsLeftPaneTest();		
		
		try {
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_RIGHT_PANE_ID, 10);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_HELP_QUESTION_BUTTON_ID);
			BrowserWait.waitUntilText("Craft Your Quote");
			BrowserWait.waitUntilText("I will bill my employer for:");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_TYPE_OF_CONTRACT_XPATH);
			BrowserWait.waitUntilText("Milestones","Name/Description","Due Date","Amount");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_FIRST_MILESTONE_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_DUE_DATE_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_AMOUNT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ADD_A_MILESTONE_LINK_ID);			
			BrowserWait.waitUntilText("Choose your SafePay and autopay requirements below.");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_FUND_NEXT_MILESTONE_ENABLE_AUTOPAY_RADIO_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_RADIO_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_ID);
			BrowserWait.waitUntilText("Payment Schedule - invoices will be paid within:");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_PAYMENT_SCHEDULE_DROPDOWN_XPATH);
			BrowserWait.waitUntilText("Protection Summary");
			BrowserWait.waitUntilText("The employer will manually pay invoices sent by the guru.");
			BrowserWait.waitUntilText("I will provide Status Updates:");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_STATUS_UPDATES_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_SCOPE_OF_WORK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_BOLD_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ITALIC_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_UNDERLINE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_BUTTON_ID);
			BrowserWait.waitUntilText("Automatically accept if hired before:");
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_AUTO_ACCEPT_RADIO_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_AUTO_ACCEPT_DATE_INPUT_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ACCEPT_MANUALLY_RADIO_BUTTON_ID);
			
			try {
				BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_UPGRADE_MEMBERSHIP_OPTION_SECTION_XPATH);
				BrowserWait.waitUntilText("Upgrade Membership to Send a Premium Quote","Premium quotes are only available to Professional, Business and Executive members.");
				
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_SEND_PREMIUM_QUOTE_OPTION_SECTION_XPATH);
				BrowserWait.waitUntilText("Get noticed! Send a Premium Quote.");
				BrowserWait.waitUntilText("Upgrade your proposal to send it straight to the top of the stack!");
			} 
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_PREMIUM_QUOTE_CHECKBOX_ID);
			try {
				BrowserWait.waitUntilText("No Matching Skills Found","There are no matching skill tags in your profile.","now to strengthen your proposal.","Save quote as a template");
			} catch (Exception e) {
				BrowserWait.waitUntilText("Matching Skills");
				BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MATCHING_SKILLS_ICON_XPATH);
			}	
			
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_SAVE_AS_TEMPLATE_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_APPLY_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_CANCEL_BUTTON_XPATH);
			
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Apply To job form section is not verified elements are not loaded");
		}
		verifyEmpStatsTest();
	}
	
	@Test
	@Parameters("agreementType")
	@Documentation(step = "Select the Type of Billing from the dropdown options.", expected = "Able to select options from the dropdown list.")
	public static void selectBillEmployerByTest(String type) throws Exception {
		ScriptLogger.info();
		WorkroomPageTest.selectBillEmployerByTest(type);
	}

	@Test
	@Parameters({"noOfMilestones","milestoneNames","milestoneDueDates","milestoneAmounts"})
	@Documentation(step = "Enter Milestone data.", expected = "Able to enter.")
	public static void enterMilestonesTest(int noOfMilestones,String milestoneNames, String milestoneDueDates,String milestoneAmounts) throws Exception {
		ScriptLogger.info();
		
		
			if(noOfMilestones>1){
			String[] mNames=StringUtils.splitDataBySymbol(milestoneNames, "|");
			String[] mDueDates=StringUtils.splitDataBySymbol(milestoneDueDates, "|");
			String[] mAmounts=StringUtils.splitDataBySymbol(milestoneAmounts, "|");
			if(noOfMilestones!=mNames.length ||noOfMilestones!=mDueDates.length || noOfMilestones!=mAmounts.length){
				throw new ScriptException("Data Issue: Milestone data is insufficient. Milestone Count:"+noOfMilestones+" Milestone Name Count:"+mNames.length+" Milestone Due Date Count:"+mDueDates.length+" Milestone Amounts Count:"+mAmounts.length);
			}
			else{
				try {
					int i;
					for(i=0;i<=noOfMilestones;i++){
						
						String milestoneEle="milestoneNameInput"+i;
						WebDriverAction.enterFieldValue(By.id(milestoneEle),mNames[i]);
						WebElement element=BrowserAction.getElements(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_DUE_DATE_ID).get(i);
						element.click();
						setDueOrEndDate(mDueDates[i],i);						
						WebElement element2=BrowserAction.getElements(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_AMOUNT_XPATH).get(i);
						WebDriverAction.enterFieldValue(element2,mAmounts[i]);
						if(noOfMilestones!=0){
							BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ADD_A_MILESTONE_LINK_ID);
							
						}
						else{
							break;
						}
						noOfMilestones--;
						
					}
					} catch (Exception e) {
					throw new ScriptException(e);
				}
			}
			
		}
		else if (noOfMilestones==1){
			BrowserAction.enterFieldValue(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_FIRST_MILESTONE_ID,milestoneNames);
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_DUE_DATE_ID);
			setDueOrEndDate(milestoneDueDates,0);
			BrowserAction.enterFieldValue(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_AMOUNT_XPATH,milestoneAmounts);
			noOfMilestones--;
		}
	}
	
	@Test
	@Parameters("safepayOption")
	@Documentation(step = "", expected = "")
	public static void selectSafePayOptionTest(String safepayOption) throws Exception {
		ScriptLogger.info();
		try {
			switch (safepayOption) {
			case "FUND_NEXT_MILESTONE_AND_ENABLE_AUTOPAY":
				if(!BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_FUND_NEXT_MILESTONE_ENABLE_AUTOPAY_RADIO_ID).isSelected()){
					BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_FUND_NEXT_MILESTONE_ENABLE_AUTOPAY_RADIO_ID);
				}
				
				break;
				
			case "AUTOPAY_ONLY":
				if(!BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_RADIO_ID).isSelected()){
					BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_RADIO_ID);
				} 		
				break;
				
			case "MANUAL_PAYMENTS":
				if(!BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_ID).isSelected()){
					BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_ID);
				}		
				break;

			default:
				break;
			}

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("paymentSchedule")
	@Documentation(step = "", expected = "")
	public static void selectPaymentScheduleTest(String paymentSchedule) throws Exception {
		ScriptLogger.info();

		try {
			Select select= new Select(BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_PAYMENT_SCHEDULE_DROPDOWN_XPATH));
			select.selectByVisibleText(paymentSchedule);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("statusUpdates")
	@Documentation(step = "", expected = "")
	public static void selectStatusUpdatesOptionTest(String statusUpdates) throws Exception {
		ScriptLogger.info();

		try {
			Select select= new Select(BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_STATUS_UPDATES_DROPDOWN_XPATH));
			select.selectByVisibleText(statusUpdates);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("scopeOfWork")
	@Documentation(step = "", expected = "")
	public static void enterScopeOfWorkTest(String scopeOfWork) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.scrollWindow(0,4000);
			BrowserAction.enterFieldValue(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_SCOPE_OF_WORK_XPATH,scopeOfWork);
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to enter Scope of Work.");
		}
	}
	
	@Test
	@Parameters("autoAcceptDate")
	@Documentation(step = "", expected = "")
	public static void setAcceptAutomaticallyDateTest(String autoAcceptDate) throws Exception {
		ScriptLogger.info();
		setAutoAcceptDate(autoAcceptDate);		
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAcceptManuallyTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ACCEPT_MANUALLY_RADIO_BUTTON_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAttachFilesTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_ID);
			BrowserWait.waitUntilText("Attach Work From Your...");
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyAttachFilesPopUpTest() throws Exception {
		ScriptLogger.info();
		try {
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickComputerTabOnAttachFilesTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_PANE_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("morethan10MBFile")
	@Documentation(step = "", expected = "")
	public static void addMoreThan10MBFileTest(String morethan10MBFile) throws Exception {
		ScriptLogger.info();
		addFilesTest(morethan10MBFile);
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickSelectFilesToUploadTest() throws Exception {
		ScriptLogger.info();
		
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_SELECT_FILES_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
	
	@Test
	@Parameters("files")
	@Documentation(step = "", expected = "")
	public static void addFilesTest(String files) throws Exception {
		ScriptLogger.info();
		FileHandler.uploadFilesFromPath(files,"|");
	}
	
	@Test
	@Parameters("errorMsg")
	@Documentation(step = "", expected = "")
	public static void verifyErrorMsgTest(String errorMsg) throws Exception {
		ScriptLogger.info();
		Thread.sleep(5000);
		String webMessage = BrowserAction.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_ERR_MSG_SPAN_XPATH).getText();
		if (!webMessage.contains(errorMsg)) {
			throw new ApplicationException(
					"Application Issue: Message Expected:-" + errorMsg + " Actual Message:-" + webMessage);
		}
	}
	
	@Test
	@Parameters("files")
	@Documentation(step = "", expected = "")
	public static void addValidFilesTest(String files) throws Exception {
		ScriptLogger.info();
		clickSelectFilesToUploadTest();
		FileHandler.uploadFilesFromPath(files, "|");
		waitTillUploadFinished();
		Thread.sleep(4000);
		String attr = BrowserWait.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_PROGRESS_BAR_XPATH).getAttribute("style");
		if (!attr.contains("display: none")) {
			throw new Exception("File was uploaded, but thumbnail after successful upload didn't appear.");
		}

		}
	
	private static void waitTillUploadFinished() throws Exception {
		ScriptLogger.info();
		String attr = null;
		do {
		attr = BrowserWait.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_UPLOAD_PROGRESS_BAR_XPATH).getAttribute("aria-valuenow");
		} while (Integer.parseInt(attr)!=100);
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickFinishedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_FINISHED_BUTTON_XPATH);

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("portfolioName")
	@Documentation(step = "", expected = "")
	public static void verifyPortfolioIsPresentTest(String portfolioName) throws Exception {
		ScriptLogger.info();
		try {

				String xpathExpression="//div[@class='title ng-binding'][contains(text(),'"+portfolioName+"')]";
				WebDriverWaits.waitUntilElementIsDisplayed(By.xpath(xpathExpression),5);
				//WebDriverAction.getElement(By.xpath(xpathExpression));
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickToSubmitQuoteTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_JOB_APPLY_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException(e, "Unale to click on 'Apply' to submit crafted quote.");
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyQuoteSubmittedTest() throws Exception {
		ScriptLogger.info();
		try {
			verifyJobDetailsLeftPaneTest();
			verifyEmpStatsTest();
			verifySimilarJobsTest();
			verifyShareUrlTest();			
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLIED_SENT_DATE_TIME_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLIED_EDIT_QUOTE_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLIED_VIEW_QUOTE_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLIED_WATCH_FOR_RESPONSES_PLINK);
			BrowserWait.waitUntilText("Submitted");
			} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to verify the submission of the quote.");
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void clickQuotesTabTest() throws Exception {
		ScriptLogger.info();
		DashboardPageTest.clickFLQuotesTabTest();
	}
	
	
	private static void setDueOrEndDate(String dateExp,int calenderWebElementNum) throws Exception {
		List< WebElement> elements=new ArrayList<WebElement>();
		WebElement headRow= BrowserAction.getElements(CommonObjectMap.CALENDAR_DATE_PICKER_TABLE_XPATH).get(calenderWebElementNum).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
		elements=headRow.findElements(By.tagName("th"));
		try {
			int year=0;
			int month=00;
			int day=00;
			
			if(dateExp!=null){
				
				String[] date = dateExp.split("-");
				day = Integer.parseInt(date[0]);
				month = Integer.parseInt(date[1]);
				year = Integer.parseInt(date[2]);				
				 List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
				 boolean dateNotFound=true;
				 
				while(dateNotFound)
				  { 
					String[] webElement=elements.get(1).getText().split(" ");
				   
					String monthWebElement =webElement[0];
					
					String yearWebElement =webElement[1];
					  
				   if(monthList.indexOf(monthWebElement)+1== month && (year == Integer.parseInt(yearWebElement)))
				   {
					   int i=0;
						int j=41;
						if(calenderWebElementNum>0){
							i=calenderWebElementNum+(calenderWebElementNum-1)*40;
							j=calenderWebElementNum+calenderWebElementNum*40;
						}
						
											
						List <WebElement> datePicker = BrowserAction.getElements(CommonObjectMap.CALENDAR_DATE_PICKER_DATE_CELL_XPATH);
						for (int k = i; k <= j; k++) {
							 
								 
								 if(datePicker.get(k).getText()!=null){
								   if (Integer.parseInt(datePicker.get(k).getText())==(day)){
									   datePicker.get(k).click();
								    break;
								   }
								  }
						 
						}

				    dateNotFound = false;
				   }
				  
				   else if(monthList.indexOf(monthWebElement)+1 < month && (year == Integer.parseInt(yearWebElement)) || year > Integer.parseInt(yearWebElement))
				   {				
				    elements.get(2).findElement(By.tagName("button")).click();
				  }
				 
				   else if(monthList.indexOf(monthWebElement)+1 > month && (year == Integer.parseInt(yearWebElement)) || year < Integer.parseInt(yearWebElement))
				   {
					   elements.get(0).findElement(By.tagName("button")).click();
				   }
				  }			
				}
				
				
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}
		
	}
	
	
	private static void setAutoAcceptDate(String dateExp) throws Exception {
		List< WebElement> elements=new ArrayList<WebElement>();		
		List<WebElement> list=BrowserAction.getElements(CommonObjectMap.CALENDAR_DATE_PICKER_TABLE_XPATH);
		int size=list.size();
		WebElement headRow= list.get(size-1).findElement(By.tagName("thead")).findElement(By.tagName("tr"));
		elements=headRow.findElements(By.tagName("th"));
		try {
			int year=0;
			int month=00;
			int day=00;
			
			if(dateExp!=null){
				
				String[] date = dateExp.split("-");
				day = Integer.parseInt(date[0]);
				month = Integer.parseInt(date[1]);
				year = Integer.parseInt(date[2]);				
				 List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
				 boolean dateNotFound=true;
				 
				while(dateNotFound)
				  { 
					String[] webElement=elements.get(1).getText().split(" ");
				   
					String monthWebElement =webElement[0];
					
					String yearWebElement =webElement[1];
					  
				   
				   if(monthList.indexOf(monthWebElement)+1== month && (year == Integer.parseInt(yearWebElement)))
				   {
					   //Click on the day when month and year are matching
					   int i=0;
						int j=41;					
						i=size+(size-1)*40;
						j=size+size*40;						
						List <WebElement> datePicker = BrowserAction.getElements(CommonObjectMap.CALENDAR_DATE_PICKER_DATE_CELL_XPATH);
						for (int k = i; k <= j; k++) {
							 
								 
								 if(datePicker.get(k).getText()!=null){
								   if (Integer.parseInt(datePicker.get(k).getText())==(day)){
									   datePicker.get(k).click();
								    break;
								   }
								  }
						}
				    dateNotFound = false;
				   }
				  
				   else if(monthList.indexOf(monthWebElement)+1 < month && (year == Integer.parseInt(yearWebElement)) || year > Integer.parseInt(yearWebElement))
				   {
				
				    elements.get(2).findElement(By.tagName("button")).click();
				    
				   }
				 
				   else if(monthList.indexOf(monthWebElement)+1 > month && (year == Integer.parseInt(yearWebElement)) || year < Integer.parseInt(yearWebElement))
				   {
				   
					   elements.get(0).findElement(By.tagName("button")).click();
				   }
				  }			
				}				
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}
		
	}
	
	
	@Test
	@Parameters("agreementType")
	@Documentation(step = "Select the Agreement type from the dropdown options.", expected = "Able to select option from the dropdown list.")
	public static void selectAgreementTypeTest(String agreement) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_I_WILL_BILL_MY_EMPLOYER_DROPDOWN_XPATH)); 
			select.selectByVisibleText(agreement);
		} catch (Exception e) {
			throw new ApplicationException("Unable to select Billing type; either it's a dropdown error, or parameter passed wasn't correct.");
		}
	}
	
	// ----------------- HOURLY QUOTE ------------------
	// ---------------------- START --------------------
	@Test
	@Parameters("hoursPerWeek")
	@Documentation(step = "Enter Hours per week in the textbox.", expected = "Able to enter.")
	public static void enterHoursPerWeekTest(String hours) throws Exception {
		ScriptLogger.info();
		WorkroomPageTest.enterHoursPerWeekTest(hours);
	}
	
	@Test
	@Parameters("rate")
	@Documentation(step = "Enter rate in the Rate textbox field.", expected = "Able to enter.")
	public static void enterRateTest(String rate) throws Exception {
		ScriptLogger.info();
		WorkroomPageTest.enterRateTest(rate);
	}
	
	@Test
	@Documentation(step = "Select the last date on the calendar popup.", expected = "Able to select.")
	public static void setLastDateInPopupTest() throws Exception {
		ScriptLogger.info();
		WorkroomPageTest.setLastDateInPopupTest();
	}
	// --------------------- END -----------------------
	// ----------------- RECURRING QUOTE ---------------
	// ---------------------- START --------------------
	@Test
	@Parameters({"noOfRecurring", "recurringDescs", "recurringDurations", "recurringRates", "recurringDueDates"})
	@Documentation(step = "Enter Hours per week in the textbox.", expected = "Able to enter.")
	public static void enterRecurringDataTest(int noOfRecurring, String recurringDescs, String recurringDurations, String recurringRates, String recurringDueDates) throws Exception {
		ScriptLogger.info();
		try {
			String[] desc = StringUtils.splitDataBySymbol(recurringDescs, "|");
			String[] duration = StringUtils.splitDataBySymbol(recurringDurations, "|");
			String[] rate = StringUtils.splitDataBySymbol(recurringRates, "|");
			String[] dueDates=StringUtils.splitDataBySymbol(recurringDueDates, "|");
			
			int size = desc.length;
			if(noOfRecurring == 1) {
				WebElement textBox = WebDriverAction.getDriver().findElement(By.id("rpDescriptionInput0"));
				textBox.sendKeys(desc);
				Select select = new Select(WebDriverAction.getDriver().findElement(By.xpath("//select[@ng-model='schedule.rpFrequency']")));
				select.selectByVisibleText(duration[0]);
				WebElement rateBox = WebDriverAction.getDriver().findElement(By.xpath("//select[@ng-model='schedule.rpAmount']"));
				rateBox.sendKeys(rate);
				setDueOrEndDate(recurringDueDates, 0);
			}
			else if(noOfRecurring > 1 && noOfRecurring <= 4) {
				for(int i=0; i<size; i++) {
					WebElement textBox = WebDriverAction.getDriver().findElement(By.id("rpDescriptionInput"+i));
					textBox.sendKeys(desc[i]);
					List<WebElement> durationSelect = WebDriverAction.getDriver().findElements(By.xpath("//select[@ng-model='schedule.rpFrequency']"));
					Select select = new Select(durationSelect.get(i));
					select.selectByVisibleText(duration[i]);
					List <WebElement> rateBox = WebDriverAction.getDriver().findElements(By.xpath("//input[@ng-model='schedule.rpAmount']"));
					rateBox.get(i).sendKeys(rate[i]);
					// setDueOrEndDate(dueDates[i],i); // --- GIVES ARRAY INDEX OUT OF BOUND EXCEPTION
					List<WebElement> calendars = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_ENTRYBOX_XPATH);
					calendars.get(i).click();
					List<WebElement> lastDate = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_POP_UP_LAST_DATE_XPATH);
					lastDate.get(i).click();
					if(i!=3 && i<(size-1)) {
					BrowserAction.click(JobDetailsPageObjectMap.JOB_DETAILS_PAGE_APPLY_FORM_ADD_ANOTHER_RECURRING_PAYMENT_ID);
					}
				}
			}
		} catch (Exception e) {
			throw new ScriptException("Possible logic error in enter values into Recurring form.");
		}
	}
	
}

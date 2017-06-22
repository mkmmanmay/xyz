package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.HirePageObjectMap;
import com.guru.testing.objectmap.PostAJobPageObjectMap;
import com.guru.testing.objectmap.QuotesPageObjectMap;
import com.guru.testing.objectmap.WorkroomPageObjectMap;

public class HirePageTest {
		
	public static String tinyUrl;
	public static String RANDOM_MESSAGE;
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyHirePageTest() throws Exception {
		ScriptLogger.info();
		try {			
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_TAB_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POSTINGS_TAB_ID);
			BrowserWait.waitUntilText("Quote Type");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ALL_QUOTES_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_HIRED_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_PREMIUN_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_FIXED_PRICE_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_HOURLY_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_PLACEHOLDER_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_CONTACTED_ID);
			BrowserWait.waitUntilText("Skills");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ALL_SKILLS_ID);
			BrowserWait.waitUntilText("Location");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ANY_LOCATION_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_CITY_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ZIP_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_COUNTRY_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_REGION_ID);
			BrowserWait.waitUntilText("Feedback");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ANY_STAR_RATINGS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_5_STARS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_4_STARS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_3_STARS_ID);
			BrowserWait.waitUntilText("Reviews");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_ANY_REVIEWS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_3_PLUS_REVIEWS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_10_PLUS_REVIEWS_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_REFINE_BY_50PLUS_REVIEWS_ID);
			BrowserWait.waitUntilText("Share this job");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_TINY_URL_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_INVITE_FREELANCERS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_MIDDLE_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_SEARCH_TEXTBOX_ID);
			BrowserWait.waitUntilText("Sort by:");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_SORT_BY_DROPDOWN_ID);
			BrowserWait.waitUntilText("All Quotes");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_SELECT_ALL_CHECKBOX_ID);
			try {
				BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_FL_QUOTES_XPATH); 
				BrowserWait.waitUntilText("Skills underlined in blue match your job posting.");
			} catch (Exception e) {
				ScriptLogger.debug("No quotes submitted for this job.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Emp Hire page elements not loaded");
		}
	}
	
	@Test
	@Documentation(step="Click on 'All Quotes' checkbox submitted to Job, in the Hire Page." , expected="Able to click.")
	public static void clickAllQuotesCheckboxTest() throws Exception {
		ScriptLogger.info();
		try {
			WebElement allQuote = BrowserAction.getElement(HirePageObjectMap.HIRE_PAGE_QUOTES_ALL_QUOTES_CHECKBOX_XPATH);
			allQuote.click();
		} catch (Exception e) {
			throw new ScriptException("Possible errors: there's a locator/selenium issue with clicking. Or application issue. Evaluate.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'Send Message' button in the Hire Page." , expected="Able to click.")
	public static void clickSendMessageBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_XPATH, 15);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_SEND_MESSAGE_LABEL_ID);
		} catch (Exception e) {
			throw new ScriptException("Possible errors: Send Message was disabled, Selenium couldn't click, or locator issue. Evaluate.");
		}
	}
	
	@Test
	@Documentation(step="Verify Message sent successfully." , expected="Able to verify.")
	public static void verifyMessageSentTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_MESSAGE_SENT_TOAST_MESSAGE_XPATH, 30);
			BrowserWait.waitUntilElementIsNotDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_MESSAGE_SENT_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Possible errors: Toast message confirmation didn't appear; or a locator issue.");
		}
	}
	
	@Test
	@Parameters("quoteNumber")
	@Documentation(step="Click on a Quote submitted to Job, in the Hire Page." , expected="Able to click.")
	public static void clickAQuoteByIndexTest(int number) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> quotes = BrowserAction.getElements(HirePageObjectMap.HIRE_PAGE_FL_QUOTES_XPATH);
			quotes.get(number-1).click();
		} catch (Exception e) {
			throw new ScriptException("Possible errors: there are no quotes, index out of bounds (script logic), or there's a locator/selenium issue with clicking. Or application issue. Evaluate.");
		}
	}
	
	@Test
	@Documentation(step="Verify Quote of a Hired Freelancer opened after clicking on it." , expected="Able to verify.")
	public static void verifyHiredQuoteOpenedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_FL_QUOTE_OPENED_VIEW_QUOTE_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_LEFT_PANEL_SECTION_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID); // Message textbox are common.
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_HIRED_FL_QUOTE_DELETE_ICON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_HIRED_FL_QUOTE_OPENED_END_DISCUSSION_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);

		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary didn't load at all, or in time during execution. Possible Application issue, or the fact that the quote viewed isn't of a Hired FL.");
		}
	}
	
	@Test
	@Parameters("messageText")
	@Documentation(step="Enter some message text in the textbox.", expected="Able to enter data.")
	public static void enterMessageTest(String text) throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(4000); // Waiting for a bit.
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID, text);
			BrowserAccess.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ScriptException("Unable to enter data in the textbox field. Possible locator issue.");
		}
		if(!isSendMessageEnabledTest() == true) {
				throw new ApplicationException("Send Message button wasn't enabled even after entering text.");
		}
	}
	
	@Test
	@Documentation(step="Enter some random message text in the textbox.", expected="Able to enter data.")
	public static void enterRandomMessageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(2000); // Waiting for a bit.
			RANDOM_MESSAGE="Random Message " + StringUtils.generateRandomString(5);
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID, RANDOM_MESSAGE);
			BrowserAccess.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID).sendKeys(Keys.TAB);
			if(!isSendMessageEnabledTest() == true) {
					throw new ApplicationException("Send Message button wasn't enabled even after entering text.");
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to enter data in the textbox field. Possible locator issue. Or Send Message wasn't enabled after entering text. Possible Application issue.");
		}
	}
	
	protected static Boolean isSendMessageEnabledTest() throws Exception {
		Boolean flag = false;
		try {
			flag = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH).isEnabled();
		} catch (Exception e) {
			throw new ScriptException("Couldn't check the state of the button.");
		}
		return flag;
	}
	
	@Test
	@Documentation(step = "Click on 'Send Message' Button.", expected = "User is able to click.")
	public static void clickSendMessageTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH, 30);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH);
			Thread.sleep(5000); // To wait until message is sent.
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	

	@Test
	@Documentation(step = "Verify the Random Message sent appears in the Message thread.", expected = "Able to verify.")
	public static void verifyRandomMessageInThreadTest() throws Exception {
		ScriptLogger.info();	
		try {
				String lastMsg = BrowserAction.getElement(HirePageObjectMap.HIRE_PAGE_FL_QUOTE_OPENED_LAST_MESSAGE_XPATH).getText();
				if(!lastMsg.equals(RANDOM_MESSAGE)) {
					throw new ApplicationException("Possible errors: Last Message sent wasn't the last message in the thread; or possible, message never got sent");
				}
			
		} catch (Exception e) {
			ScriptLogger.debug("There are no messages in the thread.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Back' button to go back to Quotes list.", expected = "Able to click.")
	public static void clickBackInOpenedQuoteTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_FL_QUOTE_OPENED_BACK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_FL_QUOTES_XPATH, 10);
		} catch (Exception e) {
			throw new ScriptException(e);
			
		}
	}
	
	// ------------------------- FILE ATTACHMENT RELATED -----------
	// ------------------------  START  -------------------------------
	@Test
	@Documentation(step = "Click on 'Work room' link.", expected = "User is able to click.")
	public static void clickAttachFilesTest() throws Exception {
		ScriptLogger.info();	
		try {
			try {
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			} catch (Exception e) {
				throw new HTMLElementNotFoundException(e, "Attach files was invisible/disbaled, or this is possible locator issue.");
			}
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			try {
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
			} catch (Exception e) {
				throw new HTMLElementNotFoundException(e, "Attach files popup didn't appear, or there's a locator issue.");
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step="Click on Select Files button.", expected="User is able to click.")
	public static void clickSelectFilesTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_SELECT_FILES_ID);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_SELECT_FILES_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Parameters("path")
	@Documentation(step="Upload a file for the portfolio", expected="File is uploaded successfully")
	public static void uploadFileTest(String filePath) throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(8000);
			FileHandler.uploadFilesFromPath(filePath, "|");	
			try{ 
				waitTillUploadFinished();
				Thread.sleep(4000);
				String attr = BrowserWait.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_UPLOAD_PROGRESS_BAR_XPATH).getAttribute("style");
				if(!attr.contains("display: none")) {
					throw new Exception("File was uploaded, but thumbnail after successful upload didn't appear.");
				}
			} catch (Exception e) {
				ScriptLogger.debug("File size limit exceeded, that's why it doesn't go through the entire upload process.");
			}
			
		} catch (Exception e) {
			throw new ScriptException("Failed uploading using robot class. Script logic error.");
		}
	}
	
	protected static void waitTillUploadFinished() throws Exception {
		ScriptLogger.info();
		String attr = null;
		do {
		attr = BrowserWait.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_UPLOAD_PROGRESS_BAR_XPATH).getAttribute("aria-valuenow");
		} while (Integer.parseInt(attr)!=100);
	}
	
	@Test
	@Documentation(step = "Click on 'Finished' Button in Attach Files popup.", expected = "User is able to click.")
	public static void clickFinishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_DISABLED_XPATH, 30);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	// ------------------ END -------------------
	
	@Test
	@Parameters("flIndex")
	@Documentation(step = "", expected = "")
	public static void clickHireInQuotesByIndexTest(int flIndex) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> elements= BrowserAction.getElements(HirePageObjectMap.HIRE_PAGE_HIRE_FL_BUTTON_XPATH);
			elements.get(flIndex).click();
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyMilestoneAgreementPopUpTest() throws Exception {
		ScriptLogger.info();
		
			
			verifyAgreementPopUpTest();
		try {		
				//TODO text
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Milestone Pop up is not verified");
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyAgreementPopUpTest() throws Exception {
		ScriptLogger.info();
		try {		
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_MODAL_DIV_XPATH);
			BrowserWait.waitUntilText("Work Room");
			BrowserWait.waitUntilText("Do you want to use the agreement submitted with the quote?","Yes - approve the agreement","No - request that the guru revises agreement");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_YES_APPROVE_AGREEMENT_RADIO_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_NO_REVISE_AGREEMENT_RADIO_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_ACKNOWLEDGEMENT_CHECKBOX_ID);	
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_HIRE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_CANCEL_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Agreement Pop up elements is are not loaded");
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void selectAgreementAckCheckboxTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_POP_UP_ACKNOWLEDGEMENT_CHECKBOX_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickHireInAgreementTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_POP_UP_HIRE_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new ScriptException(e);
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyFLHiredTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToDefaultContent();
			BrowserWait.waitUntilText("Hired");
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Hired text not found");
			
		}
	}
	
	// ----------------------- QUOTES PAGE, under HIRE ---------------
		
	@Test
	@Documentation(step = "Verify if 'Quotes' page loaded.", expected = "'Quotes' page for the user should load.")
	public static void verifyQuotesPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com - View Quotes");
			BrowserWait.waitUntilText("Quote Type");
			BrowserWait.waitUntilText("Skills");
			BrowserWait.waitUntilText("Location");
			BrowserWait.waitUntilText("Feedback");
			BrowserWait.waitUntilText("Reviews");
			BrowserWait.waitUntilText("Share ");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_LEFT_PANEL_SECTION_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SECTION_OF_JOB_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SORT_BY_DROPDOWN_ID);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEARCH_TEXTBOX_ID);
			try {
				BrowserWait.waitUntilElementIsNotDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEARCH_FREELANCERS_BUTTON_XPATH);
			} catch (Exception e) {
				ScriptLogger.info("There are quotes applied to the job, so the Search Freelancer button doesn't appear.");
			}
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step="", expected="")
	public static void verifyQuotesHirePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com - Hire");
			BrowserWait.waitUntilTextVisible("Hire", "Display");
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_POST_MY_JOB_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Failed to verify Quotes page because one or more of verifications failed.");
		}
	}
	
	
	@Test
	@Documentation(step="", expected="")
	public static void clickMyGurusTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_MYGURUS_TAB_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Failed to click, either element wasn't present or was disabled. ");
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyHirePageHiredGurusTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("My Gurus - Guru.com");
			BrowserWait.waitUntilText("Hire", "Filter by Type", "Add Gurus", "All Gurus", "Hired Gurus");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Failed to verify Hire Page's Hired Guru section." );
		}
	}
	
	@Test
	@Documentation(step="", expected="")
	public static void clickFLNameTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_MYGURUS_FL_ON_ROW2_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Make Announcement' link.", expected = "User is able to click.")
	public static void clickMakeAnnouncementLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_XPATH);
			} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Parameters("announcementText")
	@Documentation(step="Enter random announcement text in the textbox.", expected="Able to enter data")
	public static void enterAnnouncementTest(String text) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_WRITE_ANNOUNCEMENT_TEXTBOX_ID);
			BrowserAction.enterFieldValue(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_WRITE_ANNOUNCEMENT_TEXTBOX_ID, text);
		} catch (Exception e) {
			throw new ScriptException("Unable to enter data in the textbox field. Possible locator issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Make Announcement' button.", expected = "User is able to click.")
	public static void clickMakeAnnouncementBtnTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_MAKE_ANNOUNCEMENT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsNotDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_SENT_TOAST_MESSAGE_XPATH);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Possible it was unable to click 'Make Announcement', or perhaps it's toast message confirmation locator issue");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Hire' Button.", expected = "User is able to click.")
	public static void clickHireBtnTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_QUOTES_FIRST_HIRE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_POP_UP_AFTER_CLICKING_HIRE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'I acknowledge' checkbox.", expected = "User is able to click.")
	public static void clickAcknowledgeCheckboxTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_POP_UP_TERMS_CONDITIONS_CHECKBOX_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Hire' button in popup appearing when clicking on hire next to a quote.", expected = "User is able to click.")
	public static void clickHireInHirePopupTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_POP_UP_HIRE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_HIRED_SECTION_AGAINST_QUOTE_XPATH, 60);
			BrowserAction.switchToDefaultContent();
			BrowserAction.refresh();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Work room' link.", expected = "User is able to click.")
	public static void clickWorkRoomLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.switchToDefaultContent();
			BrowserAction.refresh();
			BrowserAction.click(HirePageObjectMap.HIRE_PAGE_QUOTES_WORKROOM_LINK_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Get tiny url of the job posted." , expected = "Able to retrive the tinyURL.")
	public static void getTinyURLTest() throws Exception {
		ScriptLogger.info();
		try {
			tinyUrl = BrowserAction.getElementAttributeValue(HirePageObjectMap.HIRE_PAGE_QUOTES_TINY_URL_TEXT_CONTAINER_ID, "value");
			BrowserAction.refresh();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	

}

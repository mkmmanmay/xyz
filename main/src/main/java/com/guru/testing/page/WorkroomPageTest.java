package com.guru.testing.page;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.HirePageObjectMap;
import com.guru.testing.objectmap.ManagePageObjectMap;
import com.guru.testing.objectmap.WorkroomPageObjectMap;

public class WorkroomPageTest {
	
	private static int countBeforePublic = 0;
	private static int countAfterPublic = 0;
	private static int countBeforePrivate = 0;
	private static int countAfterPrivate = 0;
	public static int recipientCount = 0;
	public static int tokenCountInPopUp = 0;
	public static double invoiceAmount;
	public static String randomName = null;
	public static String lastDayOfMonthClicked = null;
	public static int inviteSize;
	public static float futureWorkValue = 0;
	/*
	@Test
	@Documentation(step = "Verify if 'Workroom' page on the EMP side loaded.", expected = "'Workroom' page for the user should load.")
	public static void verifyEMPWorkroomPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Hired Gurus");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_JOB_HIRED_GURUS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_CHATS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_TASKS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			//BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_RIGHT_COLUMN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);
			//BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_JOB_ADD_A_MANAGER_PLINK);
			BrowserWait.waitUntilText("Add Gurus");
			BrowserWait.waitUntilText("My Managers");
			BrowserWait.waitUntilText("Outstanding Invoices");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}*/
	
	@Test
	@Documentation(step = "Verify Job title in workroom.", expected = "Able to verify.")
	public static void verifyJobNameByTokenTest() throws Exception {
		ScriptLogger.info();
		String jobTitle = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_JOB_TITLE_XPATH).getText();
		if (!jobTitle.equals(PostAJobPageTest.RANDOM_TOKEN)) {
			throw new ApplicationException("Job Title doesn't match the job title clicked on the dashboard workroom section.");
		} else {
			ScriptLogger.info("Job Title verified.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Workroom' page on the EMP side loaded.", expected = "'Workroom' page for the user should load.")
	public static void verifyFLWorkroomPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Freelancer");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_EMPLOYER_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_CHATS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_TASKS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_TRACK_TIME_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_MY_TEAM_TAB_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters("guruNumber")
	@Documentation(step="Click on a Guru tile in the EMP workroom." , expected="Able to click.")
	public static void clickAGuruByIndexTest(int number) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> guru = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_HIRED_GURU_TILES_IN_WORKROOM_XPATH);
			guru.get(number-1).click();
		} catch (Exception e) {
			throw new ScriptException("Possible errors: there are no quotes, index out of bounds (script logic), or there's a locator/selenium issue with clicking. Or application issue. Evaluate.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Random Message sent appears in the Message thread.", expected = "Able to verify.")
	public static void verifyRandomMessageInThreadTest() throws Exception {
		ScriptLogger.info();	
		try {
				String lastMsg = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_LAST_MESSAGE_XPATH).getText();
				if(!lastMsg.equals(HirePageTest.RANDOM_MESSAGE)) {
					throw new ApplicationException("Possible errors: Last Message sent wasn't the last message in the thread; or possible, message never got sent");
				}
			
		} catch (Exception e) {
			ScriptLogger.debug("There are no messages in the thread.");
		}
	}
	
	@Test
	@Documentation(step = "Get the amount on the outstanding invoice.", expected = "Able to retrieve data.")
	public static void getOutstandingInvAmountTest() throws Exception {
		try {
			WebElement invoiceList = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_RIGHT_COLUMN_OUTSTANDING_INVOICE_TEXT_XPATH);
			String amountText = invoiceList.getText();
			invoiceAmount = Double.parseDouble(StringUtils.stringBetween(amountText, "$", " due", 1));			
		} catch (Exception e) {
			throw new ScriptException("Unable to retrive data.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Message All' button of the EMP workroom page.", expected = "Able to click.")
	public static void clickMessageAllEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_XPATH, 15); // Locator same as in hire page.
			BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_SEND_MESSAGE_LABEL_ID); // Locator same as in hire page.
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}	
	
	@Test
	@Documentation(step = "Click on 'Recipients...' button on the Send Message Popup of the EMP's workroom page.", expected = "Able to click.")
	public static void clickRecipientsSendMsgPopupEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}	

	@Test
	@Documentation(step = "Click on 'All' option from the Receipients Dropdown.", expected = "Able to click.")
	public static void getAllRecipientsCountTest() throws Exception {
		try {
			WebElement allRecipients = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_BUTTON_DROPDOWN_ALL_OPTION_XPATH);
			String recipCount = allRecipients.getText();
			recipientCount = Integer.parseInt(StringUtils.stringBetween(recipCount, "All (", ")", 1));
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'All' option from the Receipients Dropdown.", expected = "Able to click.")
	public static void clickRecipientsAllEMPTest() throws Exception {
		try {
			WebElement allReceipients = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_BUTTON_DROPDOWN_ALL_OPTION_XPATH);
			allReceipients.click();
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_TOKEN_XPATH);
			} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'All' option from the Receipients Dropdown.", expected = "Able to click.")
	public static void getRecipientsTokenCountTest() throws Exception {
		try {
			List<WebElement> Recipients = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_TOKEN_XPATH);
			tokenCountInPopUp = Recipients.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'All' option from the Receipients Dropdown.", expected = "Able to click.")
	public static void verifyAllRecipientsAddedTest() throws Exception {
		try {

			if(!(tokenCountInPopUp == recipientCount)) {
				throw new ApplicationException("Workroom Participant count differs from the number of tokens appearing in Send Message Popup after click 'All' in Recipients.");
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to verify.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Add a manager' link in the My managers section of the workroom page.", expected = "Able to click.")
	public static void clickAddAManagerTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_JOB_ADD_A_MANAGER_PLINK);		
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}	
	
	@Test
	@Documentation(step = "Click on 'Public Files' link in the workroom page.", expected = "Able to click.")
	public static void clickPublicFilesLinkEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Public Files' popup loaded.", expected = "Should be able to verify.")
	public static void verifyPublicFilesPopupEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_PUBLIC_PRIVATE_FILES_POPUP_ID, 15);
			BrowserWait.waitUntilText("Public Files");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_PUBLIC_POPUP_ADD_FILES_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_SELECT_ALL_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_DOWNLOAD_BUTTON_XPATH);
			try {
				String disabled = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_BUTTON_XPATH).getAttribute("disabled");
			} catch (Exception e) {
				throw new ApplicationException("Copy button isn't disabled by default.");
			}
			try {
				String disabled = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_DOWNLOAD_BUTTON_XPATH).getAttribute("disabled");
			} catch (Exception e) {
				throw new ApplicationException("Download button isn't disabled by default.");
			}
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_CLOSE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters("fileNames")
	@Documentation(step = "Verify if file name in the first Pagination of the popup opened.", expected = "Should be able to verify.")
	public static void verifyFileInPopupTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			/*List<WebElement> files = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_FILE_NAME_TEXT_IN_LIST_XPATH);
			for(int i = 0; i < files.size(); i++) {
				if(files.get(i).getText() == fileName)
			}*/
			String[] strings = name.split("-");
			int size = strings.length, i, j;
			List<WebElement> files = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_FILE_NAME_TEXT_IN_LIST_XPATH);
			int noOfFiles = files.size();
			for ( i = 0; i < size; i++) {
				for (j = 0; j < noOfFiles; j++) {
					String text = files.get(j).getText();
					if (strings[i].equals(text)) {
						break;
					} 
				}
				if (j==noOfFiles) {
					ScriptLogger.debug("No file match.");
				}
			}
			
		} catch (Exception e) {
			throw new ScriptException("Unable to verify file name in the list; either there are was such file uploaded at all; or an application issue.")	;	
		}
	}
	
	@Test
	@Parameters("filesCheck")
	@Documentation(step = "Verify if file name in the first Pagination of the popup opened.", expected = "Should be able to verify.")
	public static void clickCheckboxAgainstFileTest(String check) throws Exception {
		ScriptLogger.info();
		try {
			String[] strings = check.split("-");
			int size = strings.length;
			List<WebElement> files = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_FILES_IN_LIST_XPATH);
			int noOfFiles = files.size();
			int j=0;
			for (int i = 0; i < size; i++) {
				do {
					try {
						String text = files.get(j).findElement(By.tagName("strong")).getText();
						if (strings[i].equals(text)) {
							List<WebElement> checkboxes = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_CHECKBOX_XPATH);
							checkboxes.get(j).click();
							break;
						}
					} catch (Exception e) {
						j++;
					}
				} while (j < noOfFiles);
			}
			
		} catch (Exception e) {
			throw new ScriptException("Unable to verify file name in the list; Or there was a issue with clicking on it. Maybe Application or selenium issue.")	;	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Copy' button.", expected = "Able to click.")
	public static void clickCopyInFilePopupEMPTest() throws Exception {
		try {
			
			String disabled = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_DOWNLOAD_BUTTON_XPATH).getAttribute("disabled");
			if (disabled == null) {
				BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_BUTTON_XPATH);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			throw new ApplicationException("Unable to click.");
		}
	}
	
	@Test
	@Parameters("copyToOptions")
	@Documentation(step = "Verify if 'Private Files' popup loaded.", expected = "Should be able to verify.")
	public static void verifyCopyToOptionsEMPTest(String copy) throws Exception {
		ScriptLogger.info();
		try {
			
			String[] strings = copy.split("-");
			int size = strings.length;
			List<WebElement> files = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_LIST_NAMES_XPATH);
			int noOfFiles = files.size();
			int j=0;
			for (int i = 0; i < size; i++) {
				do {
					try {
						String text = files.get(j).getText();
						if (strings[i] == text) {
							j++;
							break;
						} else {
							j++;
						}
					} catch (Exception e) {
						j++;
					}
				} while (j < noOfFiles);
			}
		} catch (Exception e) {
			throw new ApplicationException("Either Private Files or Everyone in Work Room not listed in Copy To options.")	;	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Private Files' checkbox to copy a file to Private files.", expected = "Able to click.")
	public static void clickPrivateFilesCheckboxEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_PRIVATE_FILES_CHECKBOX_ID);		
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Copy after checking a location to copy the selected files to.", expected = "Able to click.")
	public static void clickCopyAfterCopyToFromListEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_COPY_BUTTON_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_SUCCESSFUL_COPY_TOAST_MESSAGE_XPATH, 10);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Close' button to close file popup.", expected = "Able to click.")
	public static void clickCloseFilePopupEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_FILES_POPUP_CLOSE_BUTTON_XPATH);	
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_PUBLIC_PRIVATE_FILES_POPUP_ID, 10);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Private Files' link in the workroom page.", expected = "Able to click.")
	public static void clickPrivateFilesLinkEMPTest() throws Exception {
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);		
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Private Files' popup loaded.", expected = "Should be able to verify.")
	public static void verifyPrivateFilesPopupEMPTest() throws Exception {
		ScriptLogger.info();
		try {
			// TO ADD MORE VALIDATIONS
			
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_PUBLIC_PRIVATE_FILES_POPUP_ID, 15);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters("guruHandlingEmp")
	@Documentation(step = "Verify if outstanding invoice amount shown on Emp side is equivalent to invoice created on FL side + charges.", expected = "Able to verify")
	public static void verifyOutstandingInvAmountTest(String handlingFee) throws Exception {
		// FL creates an invoice and sends it to the emp. This invoice appears in the workroom
		// under Outstanding invoices section with Guru charges added to it.
		ScriptLogger.info();
		try {
			Double handlingFees = Double.parseDouble(handlingFee);
			Double calculateInvAmount = (InvoicePageTest.invTotal*(100+handlingFees))/100;
			DecimalFormat df = new DecimalFormat("0.##");
			String actInvAmount = df.format(calculateInvAmount);
			Double actualInvAmount = Double.parseDouble(actInvAmount);
			if(!(actualInvAmount == invoiceAmount)) {
				throw new ApplicationException("Invoice amount on EMP side doesn't match the invoice amount sent from FL side + handling fees.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Employer' Tab.", expected = "User is able to click.")
	public static void clickEmployerTabTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_EMPLOYER_TAB_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Parameters("messageText")
	@Documentation(step="Enter some message text in the textbox.", expected="Able to enter data.")
	public static void enterMessageTest(String text) throws Exception {
		ScriptLogger.info();
		HirePageTest.enterMessageTest(text);
	}
	
	@Test
	@Documentation(step="Enter some random message text in the textbox.", expected="Able to enter data.")
	public static void enterRandomMessageTest() throws Exception {
		ScriptLogger.info();
		HirePageTest.enterRandomMessageTest();
	}
	
	@Test
	@Documentation(step="Verify Message sent successfully." , expected="Able to verify.")
	public static void verifyMessageSentTest() throws Exception {
		ScriptLogger.info();
		try {
			try {
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_MESSAGE_SENT_TOAST_MESSAGE_XPATH);
				BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_MESSAGE_ALL_MESSAGE_SENT_TOAST_MESSAGE_XPATH);
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_MESSAGE_SENT_TOAST_MESSAGE_XPATH, 30);
				BrowserWait.waitUntilElementIsNotDisplayed(HirePageObjectMap.HIRE_PAGE_QUOTES_SEND_MESSAGE_MESSAGE_SENT_TOAST_MESSAGE_XPATH);
			}
		} catch (Exception e) {
			throw new ApplicationException("Possible errors: Toast message confirmation didn't appear; or a locator issue.");
		}
	}
	
	protected static Boolean isSendMessageEnabledTest() throws Exception {
		Boolean flag = false;
		try {
			flag = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH).isEnabled();
		} catch (Exception e) {
			ScriptLogger.debug("Couldn't check the state of the button.");
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
	@Documentation(step = "Click on 'All Hired Gurus' Button in EMP workroom.", expected = "User is able to click.")
	public static void clickAllHiredGurusTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_BACK_TO_ALL_HIRED_GURUS_NAVIGATION_AT_TOP_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	// ---------------- FL SIDE STATUS UPDATES RELATED ------------
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step = "Verify if 'Status Updates' tab on the FL side loaded.", expected = "'Workroom' page for the user should load.")
	public static void verifyFLStatusUpdatesTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_MESSAGE_TEXTBOX_ID, 30);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_EMPLOYER_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_CHATS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_TASKS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_TRACK_TIME_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_MY_TEAM_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);
			try{
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_CONTAINER_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_FIRST_MILESTONE_SEND_INVOICE_LINK_XPATH);
			} catch (Exception e) {
				ScriptLogger.info("Two Possibilities: Not a milestone based workroom to validate Send invoice link; or Agreement is under pending acceptance or was rejected.");
			}
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_TAB_XPATH);
			BrowserWait.waitUntilText("Keep your employer up-to-date.");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear; or a possible Application issue. Verify screenshot.")	;	
		}
		
	}
	
	// ---------------- EMP SIDE STATUS UPDATES RELATED ------------
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step = "Verify if 'Status Updates' tab on the EMP side loaded.", expected = "'Workroom' page for the user should load.")
	public static void verifyEMPStatusUpdatesTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_MESSAGE_TEXTBOX_ID, 30);
			try{
			    BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_CONTAINER_XPATH);
			} catch (Exception e) {
				ScriptLogger.info("Not a milestone based workroom to validate Milestone panel.");
			}
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_PURCHASE_ORDER_NUMBER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Send Invoice' link against first Milestone.", expected = "Able to click.")
	public static void clickFirstMileSendInvTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_FIRST_MILESTONE_SEND_INVOICE_LINK_XPATH, 30);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_STATUS_UPDATES_FIRST_MILESTONE_SEND_INVOICE_LINK_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	// ------------------------------ END ---------------------------
	
	// ---------------------- EMP & FL SIDE SAFEPAY RELATED --------------
	// ----------------------------- START --------------------------
	
	@Test
	@Documentation(step = "Click on 'Safe Pay' Navigation tab.", expected = "User is able to click.")
	public static void clickSafePayTab() throws Exception {
		// Common for both EMP and FL
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Safe Pay' Navigation tab for EMP Workroom.", expected = "User is able to verify.")
	public static void verifyEMPSafePayTab() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("SafePay Account ", 30);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "SafePay Account header text didn't appear.");
		}
		try {
			BrowserWait.waitUntilText("Add Funds to SafePay");
		} catch (Exception e) {
			ScriptLogger.debug("Add Funds to SafePay text didn't appear; it's possible that there's a pending Safepay fund request, either due to the agreement or a request from the Freelancer.");
		}
		try {
			BrowserWait.waitUntilText("Transaction History");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_SAFEPAY_TAB_SAFEPAY_DETAILS_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Safe Pay' Navigation tab for FL workroom.", expected = "User is able to verify.")
	public static void verifyFLSafePayTabTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("SafePay Account ", "Request funds from your employer", "Transaction History");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_SAFEPAY_TAB_SAFEPAY_DETAILS_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_SAFEPAY_REQUEST_FUNDS_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Add Funds' button.", expected = "User is able to click.")
	public static void clickAddFunds() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_VALID_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Parameters("safepayAmount")
	@Documentation(step = "Enter Amount in 'Amount to add to SafePay' textbox", expected = "User is able to enter data.")
	public static void enterSafepayAmountTest(String amount) throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000); // waiting until the amount textbox is autofilled.
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_VALID_XPATH);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_VALID_XPATH, amount);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Add Funds' button under the Add funds to Safepay section.", expected = "User is able to click.")
	public static void clickAddFundsToSafepay() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_UNDER_ADD_FUNDS_TO_SAFEPAY_SECTION_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Request a Refund' link under the Add funds to Safepay section.", expected = "User is able to click.")
	public static void clickRequestRefundTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_LINK_PLINK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 'Request a Refund'.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Request a Refund' section.", expected = "User is able to verify.")
	public static void verifyRequestRefundSectionTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("Request a Refund", 30);
			BrowserWait.waitUntilText("SafePay funds for future work", 30);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to verify 'Request a Refund' section.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_FUTURE_WORK_TEXT_XPATH);
		} catch(Exception e) {
			ScriptLogger.debug("There's no Safepay fund for future Work.");
		}
	}
	
	@Test
	@Documentation(step = "click on 'SafePay funds for future work' radio.", expected = "User is able to click.")
	public static void clickFutureWorkRadioTest() throws Exception {
		ScriptLogger.info();	
		String text = null;
		try {
			text = BrowserAccess.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_FUTURE_WORK_TEXT_XPATH).getText();
		} catch (Exception e) {
			throw new ScriptException("Unable to retrieve text from the radio label.");
		}
		try {
			if (text.equals("SafePay funds for future work")) {
				BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_FUTURE_WORK_TEXT_XPATH);
			} else {
				ScriptLogger.debug("Safepay funds for future work text not found.");
			}
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'SafePay funds for Future Work'.");
		}
	}
	
	@Test
	@Documentation(step = "get Refund amount against Future Work.", expected = "User is able to retrieve data..")
	public static void getFutureWorkAmountTest() throws Exception {
		ScriptLogger.info();	
		String text = null;
		
		try {
			text = BrowserAccess.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_FUTURE_WORK_AMOUNT_XPATH).getText();
		} catch (Exception e) {
			throw new ApplicationException("Unable to get amount against 'SafePay funds for Future Work'.");
		}
		int indexOfDollar = text.indexOf("$");
		futureWorkValue = Float.valueOf(text.substring(indexOfDollar+1));
	}
	
	@Test
	@Documentation(step = "click on 'Request Refund' button.", expected = "User is able to click.")
	public static void clickRequestRefundBtnTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_REQUEST_A_REFUND_REQUEST_REFUND_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'Request Refund' Button.");
		}
		
	}

	
	// ------------------------------ END -------------------------
	
	
	// ------------------ CHARACTER LIMIT TEST ---------------------
	// ------------------------ START --------------------------
	
	private static int getCharCountTest(Object locator) throws Exception {
		ScriptLogger.info();
		int length = 0;
		try {
			length = BrowserAction.getElement(locator).getText().length(); // if getText() doesn't work, try getValue()
			return length;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Test
	@Parameters("charLimit")
	@Documentation(step = "Verify character limit of textbox.", expected = "Able to verify.")
	public static void verifyMsgCharLimitTest(int limit) throws Exception {
		ScriptLogger.info();
		int length = 0;
		try {
			length = getCharCountTest(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		if (!(length <= limit)) {
			throw new ApplicationException("Application issue: Textbox is accepting more than character limit set for it.");
		}
		
	}
	
	// ------------------------ END -------------------------------
	
	// ---------------------- TASKS TAB RELATED --------------------
	// ------------------------  START  ----------------------------
	
	@Test
	@Documentation(step="Click on 'Tasks' tab of Workroom.", expected="User is able to click.")
	public static void clickTasksTabTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_TASKS_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Tasks' page loaded.", expected = "'Tasks' page for the user should load.")
	public static void verifyTasksPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Tasks");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_CONTAINER_XPATH, 20);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_SEARCH_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_INCOMPLETE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_COMPLETE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_ASSIGNED_TO_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_TAGGED_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_NEW_TASK_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_ASSIGN_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_MARK_AS_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_SORT_BY_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_CHATS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_TASKS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);
			try {
				BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_CREATE_A_TASK_LINK_XPATH);
			} catch (Exception e) {
				ScriptLogger.info("There are exisiting tasks.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step="Click on 'New Task' button in the Tasks tab of the Workroom.", expected="User is able to click.")
	public static void clickNewTaskBtnTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_NEW_TASK_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Tasks' page loaded. Also verify Create Task button is disabled by default, and notifications checkbox is checked by default.", expected = "'Tasks' page for the user should load.")
	public static void verifyCreateTaskWindowTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_BACK_BUTTON_XPATH, 15);
			BrowserWait.waitUntilText("Create New Task");
			BrowserWait.waitUntilText("Name this task");
			BrowserWait.waitUntilText("Describe this task");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_TASK_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DESCRIBE_TASK_TEXTAREA_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			BrowserWait.waitUntilText("Assign to");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_SOMEONE_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_TO_ME_LINK_XPATH);
			BrowserWait.waitUntilText("Add Participants");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ADD_EVERYONE_IN_WORKROOM_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ENTER_SOMEONES_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CREATE_TASK_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CANCEL_BUTTON_XPATH);
			BrowserWait.waitUntilText("Due date");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DUE_DATE_CALENDAR_CONTROL_BOX_XPATH);
			BrowserWait.waitUntilText("Tags");
			BrowserWait.waitUntilText("Notifications");
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
		try {
			String state = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CREATE_TASK_BUTTON_XPATH).getAttribute("disabled");
		} catch (Exception e) {
			throw new ApplicationException("'Create Task' button is enabled by default, which is not correct.");
		}
			String state = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_NOTIFICATION_CHECKBOX_ID).getAttribute("class");
			if(!state.contains("ng-not-empty")) {
				throw new ApplicationException("Notifications checkbox is not 'checked' by default.");
			}
		
	}
	
	@Test
	@Parameters("taskName")
	@Documentation(step = "Enter name of New task in the 'Name this task' textbox.", expected = "Able to enter.")
	public static void enterTaskNameTest(String name) throws Exception {
		// For both FL & EMP
		ScriptLogger.info();
		randomName = name+" "+StringUtils.generateRandomString(3);
		try {
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_TASK_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_TASK_NAME_TEXTBOX_ID, randomName);
		} catch (Exception e) {
			throw new ApplicationException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Parameters("taskDescription")
	@Documentation(step = "Enter description of New task in the 'Describe this task' textbox.", expected = "Able to enter.")
	public static void enterTaskDescriptionTest(String desc) throws Exception {
		// for both FL & EMP
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DESCRIBE_TASK_TEXTAREA_XPATH);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DESCRIBE_TASK_TEXTAREA_XPATH, desc+" "+StringUtils.generateRandomString(3));
		} catch (Exception e) {
			throw new ApplicationException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	@Test
	@Documentation(step="Click on 'Assign to me' link in the Creat New Task.", expected="User is able to click.")
	public static void clickAssignToMeTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_TO_ME_LINK_XPATH);
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_TO_ME_LINK_XPATH, 20);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click; or perhaps condition after clicking weren't met.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGNED_TO_ME_ICON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Self-assigning didn't work.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'Add Everyone in Work Room' link in the Creat New Task.", expected="User is able to click, and everyone in the workroom is added.")
	public static void clickAddEveryoneTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ADD_EVERYONE_IN_WORKROOM_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_PARTICIPANT_TOKEN_IN_ADD_PARTICIPANTS_BOX_XPATH, 20);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click; or perhaps condition after clicking weren't met.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ADD_EVERYONE_IN_WORKROOM_ADDED_RECEIPENTS_TOKEN_IN_TEXTBOX_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Adding everyone didn't work, because tokens didn't appear.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'Create Task' button in the 'Create New Task' form.", expected="User is able to click")
	public static void clickCreateTaskTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		if(!BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CREATE_TASK_BUTTON_XPATH).isEnabled()) {
			throw new ApplicationException("Create Task isn't enabled.");
		}
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CREATE_TASK_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click.");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify Task created after filling Create new task with valid data.", expected = "Verifying task created should be done.")
	public static void verifyTaskCreatedTest() throws Exception {
		ScriptLogger.info();
		String name;
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ALL_TASKS_BUTTON_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_TASK_HEADER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_NAME_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_TAG_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_MARK_COMPLETE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ADD_DUE_DATE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ASSIGNEE_DROPDOWN_XPATH);
			BrowserWait.waitUntilText("Task Messages");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_REPLY_BUTTON_XPATH);
			BrowserWait.waitUntilText("Participants");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_PARTICIPANTS_SECTION_ADD_LINK_XPATH);
			BrowserWait.waitUntilText("Task History");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_VIEW_ENTIRE_HISTORY_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_MESSAGE_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_NOTIFICATION_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_SEND_MESSAGE_BUTTON_XPATH);
			name = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_NAME_XPATH).getText();
			
		} catch (Exception e) {
			throw new ApplicationException("Possible the task was never created; or post creation validations weren't successful. Verify.");
		}
		if(!name.equals(randomName)) {
			throw new ApplicationException("Task name entered during creation isn't the same as the Task created.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'Add Due Date' button in the Task detail page.", expected="User is able to click")
	public static void clickAddDueDateTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ADD_DUE_DATE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
		
	}
	
	@Test
	@Documentation(step="Click on 'Add Due Date' button in the Task detail page.", expected="User is able to click")
	public static void clickLastDateAsTaskDueDateTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_DUE_DATE_CALENDAR_LAST_DATE_IN_POP_UP_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step="Click on Last date of the current month in the calendar picker.", expected="User is able to click")
	public static void selectLastDayOfMonthTest() throws Exception {
		// FOR BOTH EMP & FL
		ScriptLogger.info();
		try {
			String current = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_DUE_DATE_CALENDAR_HEADER_XPATH).getText();
			String[] parts = current.split(" ");
			String month = parts[0];
			String mon = null;
			String year = parts[1];
			String day = null;
			switch(month) {
			case "January":
				mon = "Jan";
				day="31";
				break;
			case "February":
				mon = "Feb";
				if(Integer.parseInt(year)% 4 == 0) {
					day="29";
					break;
				} else {
					day="28";
					break;
				}
			case "March":
				mon = "Mar";
				day="31";
				break;
			case "April":
				mon = "Apr";
				day="30";
				break;
			case "May":
				mon = "May";
				day="31";
				break;
			case "June":
				mon = "Jun";
				day="30";
				break;
			case "July":
				mon = "Jul";
				day="31";
				break;
			case "August":
				mon = "Aug";
				day="31";
				break;
			case "September":
				mon = "Sep";
				day="30";
				break;
			case "October":
				mon = "Oct";
				day="31";
				break;
			case "November":
				mon = "Nov";
				day="30";
			case "Decemeber":
				mon = "Dec";
				day="31";
				break;
			}
			List<WebElement> columns = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_CALENDAR_PICKER_COLUMNS_XPATH);
			List<WebElement> rows = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_CALENDAR_PICKER_COLUMNS_XPATH).get(0).findElements(By.tagName("td"));
			
			String state;
			
			for(int i = 0; i < columns.size(); i++) {
				for(int j = 0; j < rows.size(); j++) {
					try {
						WebElement column = columns.get(i);
						List<WebElement> rowS = column.findElements(By.tagName("td"));
						WebElement row = rowS.get(j);
						try {
							state = row.findElement(By.tagName("button")).getAttribute("disabled");
						} catch (Exception e) {
							state = null;
						}
						do {
							String date = row.findElement(By.tagName("span")).getText();
							if(date.equals(day)) {
								row.click();
								break;
							} else {
								break;
							}
							
						} while (state==null);
					} catch (Exception e) {
						
					}
				}
			}
			
			lastDayOfMonthClicked = mon+ " " +day+ ", "+year;
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Last day of current month is added as Due date.", expected = "Able to verify.")
	public static void verifyLastDayOfMonthAddedTest() throws Exception {
		ScriptLogger.info();
		String appearingDueDate = null;
		try {
			appearingDueDate = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ADD_DUE_DATE_BUTTON_XPATH).findElement(By.tagName("span")).getText();
		} catch (Exception e) {
			throw new ScriptException("Unable to extract due date String value from the locator. Possible locator issue.");
		}
		if(!appearingDueDate.equals(lastDayOfMonthClicked)) {
			throw new ApplicationException("Date clicked on calendar was: "+lastDayOfMonthClicked+". However Due date appearing is: " +appearingDueDate);
		}
	}
	
	@Test
	@Documentation(step = "Click 'All Tasks' button to go back to Tasks list.", expected = "Able to click.")
	public static void clickAllTasksBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ALL_TASKS_BUTTON_XPATH);			
		} catch (Exception e) {
			throw new ApplicationException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify Task created after filling Create new task with valid data.", expected = "Verifying task created should be done.")
	public static void verifyTaskAddedInTasksListTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> tasks = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_TASKS_TAB_TASKS_IN_LIST_XPATH);
			int noOfTasks = tasks.size();
			for(int i = 0; i < noOfTasks ; i++) {
				WebElement el = tasks.get(i);
				List<WebElement> texts = el.findElements(By.tagName("strong"));
				int size = texts.size();
				for(int j = 0; j < size; j++) {
					if(texts.get(j).getText().equals(randomName)) {
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new ApplicationException("Possible the task was never created; or post creation validations weren't successful. Verify.");
		}
	}
	
	// ------------------------ END -------------------------------
	
	// ------------------------- FILE ATTACHMENT RELATED -----------
	// ------------------------  START  -------------------------------
	@Test
	@Documentation(step = "Click on 'Work room' link.", expected = "User is able to click.")
	public static void clickAttachFilesTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
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
		HirePageTest.uploadFileTest(filePath);
	}
	
	@Test
	@Documentation(step = "Click on 'Finished' Button in Attach Files popup.", expected = "User is able to click.")
	public static void clickFinishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_DISABLED_XPATH, 30);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
			BrowserAction.switchToDefaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step="Verify error message is displayed when file size exceeds 25MB", expected="Verification successfully done.")
	public static void verifyMaxSizeLimitErrorTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACHMENTS_FILE_SIZE_LIMIT_ERROR_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Application issue: didn't throw error when attaching files greater than 25 MB.");
		}
	}
	// -------------------------- END -------------------------------
	
	// ---------------------- FL SIDE AGREEMENT TAB ------------------
	// ----------------------------- START --------------------------
	@Test
	@Documentation(step = "Click on 'Agreement' tab.", expected = "User is able to click.")
	public static void clickAgreementTabTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Agreement' Navigation tab.", expected = "User is able to verify.")
	public static void verifyAgreementTabFLTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_VIEW_AGREEMENT_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_REVIEW_YOUR_SAFEPAY_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_STATUS_UPDATES_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_DISPUTE_RESOLUTION_HEADER_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Agreement' Navigation tab after accepting a Placeholder bid job from the dashboard.", expected = "User is able to verify.")
	public static void verifyAgreementTabAfterPlaceholderTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_REVISE_AGREEMENT_HEADER_TEXT_XPATH, 15);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_PREVIEW_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_PROTECTION_SUMMARY_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_SCOPE_OF_WORK_HEADER_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Edit' button under Agreement tab.", expected = "User is able to click.")
	public static void clickEditTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CONTINUE_BUTTON_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Edit Agreement' popup.", expected = "User is able to verify.")
	public static void verifyEditAgreePopupTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CONTINUE_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CANCEL_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_X_ICON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Continue' button in Edit agreement popup.", expected = "User is able to click.")
	public static void clickContinueEditTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CONTINUE_BUTTON_ID);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Revise Agreement' after clicking on Edit agreement", expected = "User is able to verify.")
	public static void verifyReviseAgreementTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_PREVIEW_BUTTON_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_I_WILL_BILL_MY_EMPLOYER_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_CHOOSE_YOUR_SAFEPAY_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_I_WILL_PROVIDE_STATUS_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_SCOPE_OF_WORK_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_PROTECTION_SUMMARY_HEADER_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Parameters("agreementType")
	@Documentation(step = "Select the Type of Billing from the dropdown options.", expected = "Able to select options from the dropdown list.")
	public static void selectBillEmployerByTest(String type) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_REVISE_AGREEMENT_AGREEMENT_TYPE_DROPDOWN_MENU_XPATH)); 
			select.selectByVisibleText(type);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FL_AGREEMENT_TAB_AGREEMENT_BASED_HEADER_XPATH, 10);
		} catch (Exception e) {
			throw new ApplicationException("Headers Milestones/Team Members/Recurring Payments/Task based agreement depending on agreement selected didn't appear.");
		}
	}
	
	@Test
	@Parameters("hoursPerWeek")
	@Documentation(step = "Enter Hours per week in the textbox.", expected = "Able to enter.")
	public static void enterHoursPerWeekTest(String hours) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_HOURS_PER_WEEK_TEXTBOX_XPATH, 15);
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_HOURS_PER_WEEK_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_HOURS_PER_WEEK_TEXTBOX_XPATH, hours);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Parameters("rate")
	@Documentation(step = "Enter rate in the Rate textbox field.", expected = "Able to enter.")
	public static void enterRateTest(String rate) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_RATE_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_RATE_TEXTBOX_XPATH, rate);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Documentation(step = "Select the last date on the calendar popup.", expected = "Able to select.")
	public static void setLastDateInPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_ENTRYBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_POP_UP_LAST_DATE_XPATH);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_POP_UP_LAST_DATE_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Couldn't set due date; possible date picker pop up locator changed.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Cancel' button in Edit agreement popup.", expected = "User is able to click.")
	public static void clickCancelEditTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CANCEL_BUTTON_ID);
			Thread.sleep(2000);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'X' Icon in Edit agreement popup.", expected = "User is able to click.")
	public static void clickXIconTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_X_ICON_XPATH);
			Thread.sleep(2000);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Preview' Button to preview the agreement details before sending to Employer.", expected = "User is able to click.")
	public static void clickPreviewTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_PREVIEW_BUTTON_XPATH);
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Send to Employer' Button to send the agreement to the employer.", expected = "User is able to click.")
	public static void clickSendToEmpTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH, 15);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_SENT_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Agreement sent success toast message didn't appear. ");
		}
	} 
	
	@Test
	@Documentation(step = "Click on 'Send to Employer' Button to send the agreement to the employer.", expected = "User is able to click.")
	public static void sendRevisedAgreeToEmpTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH, 15);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_CONFIRM_CONTINUE_BUTTON_XPATH, 15);
			/*Alert alert = BrowserAction.switchToAlertBox();
			alert.accept();*/
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_CONFIRM_CONTINUE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_SENT_TOAST_MESSAGE_XPATH, 15);
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap. Or it's possible subsequent validations post clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Pending Acceptance' in Agreement status", expected = "User is able to verify.")
	// HAPPENS BOTH FOR FL & EMP
	public static void verifyPendingAgreementTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_AGREEMENT_STATUS_XPATH,30);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Pending Agreement' tab on the EMP side. ", expected = "User is able to verify.")
	public static void verifyPendingAgreementTabEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_AGREEMENT_STATUS_XPATH,30);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_THE_NAVIGATION_TAB_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_DECLINE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_EFFECTIVE_DATE_CALENDAR_FIELD_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	// ------------------------------ END -----------------------------
	
	// ------------------------ CHAT SECTION -------------------------
	// --------------------------- START -----------------------------
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void clickChatsTabTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_TAB_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyChatsTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyDefaultChatroomTest() throws Exception {
		ScriptLogger.info();	
try {
			
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_DIV_XPATH, 30);
			BrowserWait.waitUntilText("No recent chats found.", "Chats");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_CREATE_NEW_CHAT_PLUS_ICON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for Chats page verification didn't appear.")	;	
		}
		
		/*if(!getReceivingNotificationCheckbox()){
			throw new ApplicationException("Recieve Notification is not checked by default");
		}
		
		if(getChatRoomCountTest()!=1){
			throw new ApplicationException("Default Chatroom is not present");
		}*/
	}
	private static int getChatRoomCountTest() throws Exception {
		List<WebElement> element;
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_CHATROOM_LIST_XPATH);
			element=BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_CHATROOM_LIST_XPATH);
			return element.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get; possible locator or selenium issue. If not, possible application issue");
		}	
	}

	private  static Boolean  getReceivingNotificationCheckbox() throws Exception {
		Boolean isChecked=false;
		WebElement element;
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_RECIEVING_NOTIFICATION_CHECKBOX_ID);
			element=BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_PAGE_RECIEVING_NOTIFICATION_CHECKBOX_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to get; possible locator or selenium issue. If not, possible application issue");
		}
		
		if(element.isSelected()){
			isChecked=true;
		}
		
		return isChecked;
		
		
	}

	@Test
	@Documentation(step = "", expected = "")
	
	public static void enterRandomChatMsgTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	
	public static void clickSendTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyRandomChatMsgTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}

	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyAttachPopUpTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	

	@Test
	@Documentation(step = "", expected = "")
	
	public static void addValidFilesTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyAttachmentPostedTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyViewAttachmentButtonCountTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void clickPlusForNewChatTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyCreateNewChatPopUpTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void enterChatNameTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void clickAddEveryoneInWorkRoomTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyEveryoneAddedTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void clickCreateNewChatTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	
	public static void verifyNewChatRoomTest() throws Exception {
		ScriptLogger.info();	
		try {
		} catch (Exception e) {
			
		}
	}
	
	@Test
	@Documentation(step = "Get file counter against Public in Chats tab, and verify against counter in File Folders.", expected = "Able to get data, and verify.")
	public static void verifyPublicFileCountInChatTest() throws Exception {
		ScriptLogger.info();
		int countPublic;
		try {
			String pub = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_TAB_PUBLIC_COUNTER_XPATH).getText();
			String counterPub = pub.substring(pub.indexOf("(") + 1, pub.indexOf(")"));
			countPublic = Integer.parseInt(counterPub);
		} catch (Exception e) {
			throw new ScriptException("Unable to retrieve data from the page.");
		}
		if(!(countPublic == countAfterPublic)) {
			throw new ApplicationException("Count of Public files in File Folders doesn't match with count in Chats tab.");
		}
	}
	
	@Test
	@Documentation(step = "Get file counter against Private in Chats tab, and verify against counter in File Folders.", expected = "Able to get data, and verify.")
	public static void verifyPrivateFileCountInChatTest() throws Exception {
		ScriptLogger.info();
		int countPrivate;
		try {
			String pri = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_CHATS_TAB_PRIVATE_COUNTER_XPATH).getText();
			String counterPri = pri.substring(pri.indexOf("(") + 1, pri.indexOf(")"));
			countPrivate = Integer.parseInt(counterPri);
		} catch (Exception e) {
			throw new ScriptException("Unable to retrieve data from the page.");
		}
		if(!(countPrivate == countAfterPrivate)) {
			throw new ApplicationException("Count of Private files in File Folders doesn't match with count in Chats tab.");
		}
	}
	
	
	// ---------------------------- END ------------------------------
	
	// ----------------------- EMP SIDE AGREEMENT TAB ------------------
	// ------------------------------ START  ---------------------------
	
	@Test
	@Documentation(step = "Click on 'Agreement' tab.", expected = "User is able to click.")
	public static void clickAgreementTabEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Agreement' tab.", expected = "User is able to click.")
	public static void clickPendingAgreementTabEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_THE_NAVIGATION_TAB_ID, 10);
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_AGREEMENT_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; either it's selenium issue, or a different locator was given in objectmap.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Status Updates' Navigation tab.", expected = "User is able to verify.")
	public static void verifyStatusTabEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_STATUS_UPDATES_TAB_HEADER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	
	@Test
	@Documentation(step = "Verify 'Agreement' Navigation tab.", expected = "User is able to verify.")
	public static void verifyAgreementTabEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_AGREEMENT_DETAILS_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_AGREEMENT_STATUS_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_VIEW_AGREEMENT_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_REVIEW_YOUR_SAFEPAY_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_STATUS_UPDATES_HEADER_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_DISPUTE_RESOLUTION_HEADER_TEXT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Accept' & 'Decline' button in Agreement Navigation tab for pending agreement.", expected = "User is able to verify.")
	public static void verifyAcceptDeclineBtnTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_DECLINE_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Accept' button in Agreement Navigation tab for pending agreement.", expected = "User is able to click.")
	public static void clickAcceptTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_BUTTON_DISABLED_XPATH, 15);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the Checkbox to accept terms of accepting agreement in the popup.", expected = "User is able to click.")
	public static void clickTermsCheckboxTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_POPUP_CHECKBOX_ID);
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Accept Agreement' button in Review your payment protection terms popup after appearing clicking 'Accept'.", expected = "User is able to click.")
	public static void clickAcceptAgreementTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_BUTTON_ENABLED_XPATH);
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_DECLINE_BUTTON_XPATH, 15);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Decline' button in Agreement Navigation tab for pending agreement.", expected = "User is able to click.")
	public static void clickDeclineTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_DECLINE_BUTTON_XPATH);
			BrowserWait.waitUntilText("Declining This Agreement?", 15);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_CONFIRM_DECLINE_AGREEMENT_BUTTON_ID, 15);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Decline Agreement' button in Agreement Navigation tab for pending agreement, after initially clicking 'Decline'.", expected = "User is able to click.")
	public static void clickDeclineAgreementTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_CONFIRM_DECLINE_AGREEMENT_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_CONFIRM_DECLINE_AGREEMENT_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	// ------------------------------ END ----------------------------
	
	// --------------------- FILE FOLDERS TAB ------------------------
	// ---------------------------- START ----------------------------
	@Test
	@Documentation(step = "Click 'File Folders' tab in EMP Workroom navigation.", expected = "User is able to click.")
	public static void clickFileFoldersEMPTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'File Folders' tab in FL Workroom navigation.", expected = "User is able to click.")
	public static void clickFileFoldersFLTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "verify 'File Folders' tab in Workroom navigation.", expected = "User is able to verify.")
	public static void verifyFileFoldersTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilPageTitle("Guru.com - Files");
			BrowserWait.waitUntilText("Public Files");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_RIGHT_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_SEARCH_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_SORT_BY_DROPDOWN_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_JOB_MESSAGES_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_TASKS_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_CHAT_TAB_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_ADD_FILES_BUTTON_XPATH);
			try {
				WebElement publicFiles = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_TAB_XPATH).findElement(By.tagName("a"));
				if(!publicFiles.getAttribute("class").contains("active")) {
					throw new ApplicationException("Public Files isn't selected by default.");
				}
			} catch (Exception e) {
				throw new ScriptException(e);
			}
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary didn't load at all, or in time during execution. Possible Application issue.");
		}
		
	}
	
	
	@Test
	@Documentation(step = "Click 'Add Files' button in File Folders Navigation of Workroom.", expected = "User is able to click.")
	public static void clickAddFilesFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_ADD_FILES_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID, 10);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Add files pop up opened on clicking Add files in Public files tab.", expected = "User is able to verify.")
	public static void verifyAddFilesPopupPublicFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_PRIVATE_FILES_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_SELECT_FILES_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_CANCEL_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Get file counter on the Public tab before performing an action.", expected = "User is able to get data.")
	public static void getFileCountBeforePublicFFTest() throws Exception {
		ScriptLogger.info();	
		try {				
			String s = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_COUNTER_XPATH).getText();
			String counter = s.substring(s.indexOf("(") + 
					1, s.indexOf(")"));
			countBeforePublic = Integer.parseInt(counter);
		} catch (Exception e) {
			countBeforePublic = 0;
			ScriptLogger.debug("There are no files in the list.");
		}
	}
	
	@Test
	@Documentation(step = "Get file counter on the Public tab before performing an action.", expected = "User is able to get data.")
	public static void getFileCountAfterPublicFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			String s = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_COUNTER_XPATH).getText();
			String counter = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
			countAfterPublic = Integer.parseInt(counter);
		} catch (Exception e) {
			countAfterPublic = 0;
			ScriptLogger.debug("Possibly, no operation was performed.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the counter against public files increased.", expected = "User is able to verify.")
	public static void verifyPublicFileCounterIncreasedTest() throws Exception {
		ScriptLogger.info();	
		try {
			if(!(countAfterPublic > countBeforePublic)) {
				throw new ApplicationException("Counter didn't increase; either this is an application issue, or the script failed to upload the file.");
			}
		} catch (Exception e) {
			throw new ScriptException("Possible application issue of files not getting added. If you've observed");
		}
	}
	
	@Test
	@Parameters("filenames")
	@Documentation(step = "verify 'File Folders' tab in Workroom navigation.", expected = "User is able to verify.")
	public static void verifyFileAddedPublicFFTest(String filenames) throws Exception {
		ScriptLogger.info();	
		try {
			String[] strings = filenames.split("-");
			int size = strings.length;
			List<WebElement> files = BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_PUBLIC_FILE_TITLES_IN_LIST_XPATH);
			int noOfFiles = files.size();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < noOfFiles; j++) {
					String text = files.get(j).findElement(By.tagName("strong")).getText();
					if (strings[i].equals(text)) {

						break;
					}
				}
			}
		} catch (Exception e) {
			throw new ScriptException("Possible application issue of files not getting added. If you've observed");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Private Files' tab under the File folders navigation tab in workroom.", expected = "User is able to click.")
	public static void clickPrivateFilesTabFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_TAB_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}

	@Test
	@Documentation(step = "verify 'Private Files' tab in File Folders navigation.", expected = "User is able to verify.")
	public static void verifyPrivateFilesTabFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_ADD_FILES_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DELETE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DOWNLOAD_BUTTON_XPATH);
			try {
				String disabled = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DELETE_BUTTON_XPATH).getAttribute("disabled");
			} catch (Exception e) {
				throw new ApplicationException("Delete button isn't disabled by default.");
			}
			try {
				String disabled = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DOWNLOAD_BUTTON_XPATH).getAttribute("disabled");
			} catch (Exception e) {
				throw new ApplicationException("Download button isn't disabled by default.");
			}
			try {
				WebElement privateFiles = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_TAB_XPATH).findElement(By.tagName("a"));
				if(!privateFiles.getAttribute("class").contains("active")) {
					throw new ApplicationException("Private Files isn't selected even after clicking on the tab.");
				}
			} catch (Exception e) {
				throw new ScriptException(e);
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary didn't load at all, or in time during execution. Possible Application issue.");
		}
	}
	

	@Test
	@Documentation(step = "Verify Add files pop up opened on clicking Add files in Private files tab.", expected = "User is able to verify.")
	public static void verifyAddFilesPopupPrivateFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_PUBLIC_FILES_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_SELECT_FILES_ID);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_ATTACH_FILES_POPUP_CANCEL_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Get file counter on the Public tab before performing an action.", expected = "User is able to get data.")
	public static void getFileCountBeforePrivateFFTest() throws Exception {
		ScriptLogger.info();	
		try {				
			String s = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_COUNTER_XPATH).getText();
			String counter = s.substring(s.indexOf("(") + 1, s.indexOf(")"));

			countBeforePrivate = Integer.parseInt(counter);
		} catch (Exception e) {
			countBeforePrivate = 0;
			ScriptLogger.debug("There are no files in the list.");
		}
	}
	
	@Test
	@Documentation(step = "Get file counter on the Public tab before performing an action.", expected = "User is able to get data.")
	public static void getFileCountAfterPrivateFFTest() throws Exception {
		ScriptLogger.info();	
		try {
			String s = BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_COUNTER_XPATH).getText();
			String counter = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
			countAfterPrivate = Integer.parseInt(counter);
		} catch (Exception e) {
			countAfterPrivate = 0;
			ScriptLogger.debug("Possibly, no operation was performed.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the counter against public files increased.", expected = "User is able to verify.")
	public static void verifyPrivateFileCounterIncreasedTest() throws Exception {
		ScriptLogger.info();	
		try {
			if(!(countAfterPrivate > countBeforePrivate)) {
				throw new ApplicationException("Counter didn't increase; either this is an application issue, or the script failed to upload the file.");
			}
		} catch (Exception e) {
			throw new ScriptException("Possible application issue of files not getting added. If you've observed");
		}
	}

	public static void verifySafepayTransactionByDate(String date,Float amount, String paymentMethod) throws Exception {
		
	}
	public static void verifyLatestSafepayTransaction(Boolean autoFund,Float amount, String paymentMethod) throws Exception {
		
		ScriptLogger.info();
		try {		
			BrowserWait.waitUntilElementIsNotDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_NOT_FUNDED_BANNER_ICON_XPATH);
			List <WebElement> trElement=BrowserAction.getElements(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_TRANSACTION_HISTORY_TABLE_XPATH);
			String transactionRemarks=trElement.get(1).getText();
			String dateElementText=trElement.get(0).getText();
			WebElement amountElement=trElement.get(2);
		
					switch (paymentMethod) {
					case "CASH_ACCOUNT":
						if(!verifyDateAsToday(dateElementText)){
							throw new ApplicationException("Date of transaction is is mismatch");
						}
						if(!verifyEmpTransactionWithFeeOnPage(amountElement, amount)){
							throw new ApplicationException("Amount is mismatch");
						}						
						if(autoFund&&!transactionRemarks.equals("Funds Automatically Added - Cash Account")){
							throw new ApplicationException("Funds not added automatically");
						}						
						else if(!autoFund&&!transactionRemarks.equals("Funds Added - Cash Account")){
							throw new ApplicationException("Funds not added");
						}

						break;
					case "CREDIT_CARD":
						if(!verifyDateAsToday(dateElementText)){
							throw new ApplicationException("Date of transaction is is mismatch");
						}
						
						if(!verifyEmpTransactionWithFeeOnPage(amountElement, amount)){
							throw new ApplicationException("Amount is mismatch");
						}
						
						if(autoFund){
							
						if(!(transactionRemarks.equals("Funds Automatically Added - Visa (1111)")||transactionRemarks.equals("Funds Automatically Added - Amex (8431)")||transactionRemarks.equals("Funds Automatically Added - Amex (0005)")||transactionRemarks.equals("Funds Automatically Added - Master (5100)"))){
							throw new ApplicationException("Funds not added automatically");
						}
						}
						
						else if(!(transactionRemarks.equals("Funds Added - Visa (1111)")||transactionRemarks.equals("Funds Added - Amex (8431)")||transactionRemarks.equals("Funds Added - Amex (0005)")||transactionRemarks.equals("Funds Added - Master (5100)"))){
							
							throw new ApplicationException("Funds not added");
						}
						
						
						break;
						
						
					case "PAY_PAL":
						//TODO Check what text is shown in autofund
						
						amount=(float) (amount+amount*2.5/100);
						BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_TRANSACTION_HISTORY_PENDING_AMOUNT_NOTE_XPATH);
						String pendingTransactionText=BrowserAction.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_TRANSACTION_HISTORY_PENDING_AMOUNT_NOTE_XPATH).getText();
						int precision = 100;
						amount= (float) (Math.floor(amount * precision +.5)/precision);
						DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
						Date date = new Date();
						String todaysDate=dateFormat.format(date);
					
						
						String genericPayPalText="PayPal is verifying the transaction - look for an updated SafePay balance by";
						String genericPaymentMadeText="You made a payment of $";
						
						if(!(pendingTransactionText.contains(genericPaymentMadeText)&&pendingTransactionText.contains(amount.toString())&&pendingTransactionText.contains(todaysDate)&&pendingTransactionText.contains(genericPayPalText))){
							throw new ApplicationException("Funds not added");
						}
						break;
						
					case "E Check":
						break;
						//TODO Other methods
					default:
						break;
					
				}
			
			
			
		
			
		} catch (Exception e) {
			throw new ScriptException("");
		}
		
		
	}
	
	/*SELECT FILES AND UPLOADING, and CLICKING ON FINISHED IS A COMMON METHOD PREVIOUSLY USED.*/
	
	// ---------------------------- END ------------------------------
	
	public static Boolean verifyEmpTransactionWithFeeOnPage(WebElement element, Float amount) {
		ScriptLogger.info();
		Boolean flag=false;
		try {	
			Float amountElement=CommonPageTest.getAmount(element, "");			
			Float transactionFee=(float) (amount*(2.5/100));
			amount=amount+transactionFee;
			int precision = 100;
			amount= (float) (Math.floor(amount * precision +.5)/precision);
			
			if(amount.compareTo(amountElement)!=0){
				throw new ApplicationException("Expected Amount: $"+amount+"Actual amount: $ "+amountElement);
			}
			flag=true;
		} catch (Exception e) {
			
		}
		return flag;
		
	}

	// ------------------- MY TEAM TAB RELATED -----------------------
	// -------------------------- START ------------------------------
	@Test
	@Documentation(step="Click on 'My Team' tab of Workroom.", expected="User is able to click.")
	public static void clickMyTeamTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_FL_JOB_MY_TEAM_TAB_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'My Team' tab.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'My Team' page loaded.", expected = "'My Team' page for the user should load.")
	public static void verifyMyTeamPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Team");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_MY_TEAM_TAB_BUILD_MY_TEAM_BUTTON_XPATH, 30);
			BrowserWait.waitUntilText("My Team");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_MY_TEAM_TAB_LEAVE_THIS_TEAM_LINK_XPATH);
			BrowserWait.waitUntilText("'s Team (Employer)");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_MY_TEAM_TAB_MEMBER_ICONS_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for My Team page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step="Click on 'Build My Team' button in My Team tab of Workroom.", expected="User is able to click.")
	public static void clickBuildMyTeamTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_MY_TEAM_TAB_BUILD_MY_TEAM_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'Build My Team' button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Invite Team Members' page loaded.", expected = "'Invite Team Members' page for the user should load.")
	public static void verifyInviteTeamMembersFLTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Invite Team Members");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_ADD_TEAM_MEMBER_BUTTON_XPATH, 30);
			BrowserWait.waitUntilText("Add Team Members");
			BrowserWait.waitUntilText("Role", "Identity");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_INVITE_FORM_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_ADD_ANOTHER_PERSON_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_CANCEL_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for My Team page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters({"userEmails", "userRoles"})
	@Documentation(step = "Enter Team Member roles & emails respectively.", expected = "Able to enter data.")
	public static void enterTeamMemberInfoFLTest(String userEmails, String userRoles) throws Exception {
		ScriptLogger.info();
		WebElement selectElement, textboxElement;
		// TODO: making this compatible for "Billable Only" role. Currently, it's not.
		try {
			String[] emails = userEmails.split("-");
			String[] roles = userRoles.split("-");
			inviteSize = emails.length;
			if(inviteSize <= 2) {
				for(int i = 0; i < inviteSize; i++) {
					selectElement = WebDriverAction.getDriver().findElement(By.xpath("//div[@class='emailList ']//div[contains(@id, 'flTeam_"+(i+1)+"')]//div//select"));
					Select select = new Select(selectElement);
					select.selectByVisibleText(roles[i]);
					textboxElement = WebDriverAction.getDriver().findElement(By.xpath("//div[@class='emailList ']//div[contains(@id, 'flTeam_"+(i+1)+"')]//input[contains(@id,'FlEmail')]"));
					textboxElement.sendKeys(emails[i]);
				}
			} else if(inviteSize > 2) {
				int clicks = inviteSize - 2;
				for(int j = 0; j < clicks; j++){
					BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_ADD_ANOTHER_PERSON_PLINK);
					Thread.sleep(2000);
					BrowserWait.waitForPageToBeLoaded();
					BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_ADD_TEAM_MEMBER_BUTTON_XPATH);
				}
				for(int i = 0; i < inviteSize; i++) {
					selectElement = WebDriverAction.getDriver().findElement(By.xpath("//div[@class='emailList ']//div[contains(@id, 'flTeam_"+(i+1)+"')]//div//select"));
					Select select = new Select(selectElement);
					select.selectByVisibleText(roles[i]);
					textboxElement = WebDriverAction.getDriver().findElement(By.xpath("//div[@class='emailList ']//div[contains(@id, 'flTeam_"+(i+1)+"')]//input[contains(@id,'FlEmail')]"));
					textboxElement.sendKeys(emails[i]);
				}
			} else {
				ScriptLogger.debug("Unable to send data for role selection, and email entry.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for My Team page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step="Click on 'Add Team Member' button in the Add Team Members page.", expected="User is able to click.")
	public static void clickAddTeamMemberFLTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(WorkroomPageObjectMap.WORKROOM_PAGE_INVITE_TEAM_MEMBERS_ADD_TEAM_MEMBER_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'Build My Team' button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if Team member invitation successfully sent by seeing.", expected = "Able to verify.")
	public static void verifyInvitationSentFLTest() throws Exception {
		ScriptLogger.info();
		int pending = 0;
		try {
			List<WebElement> textElement = BrowserAction.getElements(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_TEXT_UNDER_INDIVIDUAL_SCREEN_ICONS_XPATH);
			for(int i = 0; i < textElement.size(); i++) {
				if(textElement.get(i).getText().equals("Request Pending")) {
					pending++;
				}
			}
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Request pending text wasn't found. It's possible HTML/UI error, or an application issyue; investigate.");	
		}
		if(!(pending == inviteSize)) {
			throw new ApplicationException("Number of requests sent didn't match number of Requests Pending.");
		}
	}
	
	@Test
	@Parameters("teamScreenNames")
	@Documentation(step = "Verify team member(s) added into My Team of the Freelancer", expected = "Able to verify.")
	public static void verifyTeamMembersAddedTest(String teamScreenNames) throws Exception {
		ScriptLogger.info();
		int count=0, i,j;
		Boolean flag=false;
		String[] username = teamScreenNames.split("-");
		try {
			List<WebElement> textElement = BrowserAction.getElements(ManagePageObjectMap.MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_MEMBER_NAME_XPATH);
			for ( i = 0; i < username.length; i++) {
				for (j = 0; j < textElement.size(); j++) {
					String text = textElement.get(j).getText();
					if (username[i].equals(text)) {
						flag = true;
						break;
					} 
				}
				/*if (j==textElement.size()) {
					ScriptLogger.debug("Screen Name not found in team.");
					
				}*/
				if(!flag) {
					throw new ApplicationException("Team member not found in team.");
				}
			}
			
			
		} catch (Exception e) {
			throw new ApplicationException(e, "");	
		}
		
	}
	// --------------------------- END -------------------------------

	public static void verifyEmpWorkroomByAgreement(String agreementType)throws Exception {
		ScriptLogger.info();
		try {
			
		} catch (Exception e) {
			throw new Exception();	
		}
		
	}

	public static void raiseInvoiceByAgreementTypeTest(String agreementType) throws Exception{
		ScriptLogger.info();
		try {
			
		} catch (Exception e) {
			throw new Exception();	
		}
		
	}

	public static void verifyFLWorkroomByAgreement(String agreementType) throws Exception{
		ScriptLogger.info();
		try {
			
		} catch (Exception e) {
			throw new Exception();	
		}
		
	}

	public static void verifyAddSafePayFunds() throws Exception{
		
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("We charge a 2.5% handling fee for all payment methods. However, use one of our preferred payment methods (check, bank account, wire transfer) and we’ll kick the 2.5% back to you… plus an extra 1%!", 15);
			
			BrowserWait.waitUntilText("Amount to add to SafePay");
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_VALID_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_UNDER_ADD_FUNDS_TO_SAFEPAY_SECTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(WorkroomPageObjectMap.WORKROOM_PAGE_EMP_SAFEPAY_CANCEL_BUTTON_UNDER_ADD_FUNDS_TO_SAFEPAY_SECTION_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Safepay fund page elements did not load properly.");	
		}
	}

	
	
	private static boolean verifyDateAsToday(String dateElementText){
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		String todaysDate=dateFormat.format(date);
		if(!todaysDate.equalsIgnoreCase(dateElementText)){
			return false;
		}
		else{
			return true;
		}
	}
		

}

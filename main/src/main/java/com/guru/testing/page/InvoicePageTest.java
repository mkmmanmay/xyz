package com.guru.testing.page;

import java.util.List;

import javax.script.ScriptException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.InvoicePageObjectMap;

public class InvoicePageTest {
	
	public static double price;
	public static double invTotal;
	public static String invoiceID;
	public static String invoiceAmount;
	public static int refundInvoiceID;
	
	@Test
	 @Documentation(step = "Verify the Invoice page", expected = "Invoice Page should be loaded")
	 public static void verifyInvoicePageTest() throws Exception {
	  
	  ScriptLogger.info();
	  try {
	   BrowserWait.waitForPageToBeLoaded();
	   try {   
	    BrowserWait.waitUntilPageTitle("Invoices - Employers - Guru");
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_EMP_PAYMENT_METHODS_TAB_PLINK); 
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_EMP_1099_REPORTS_TAB_PLINK); 
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_EMP_TRANSACTION_REPORTS_TAB_PLINK); 
	    
	   } catch (Exception e) {
	    BrowserWait.waitUntilPageTitle("Guru.com - Manage Invoices");
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_TRANSFER_METHODS_TAB_PLINK); 
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_1099_TAX_FORM_TAB_PLINK);
	    BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_TRANSACTION_TAB_PLINK);
	   }
	   
	   BrowserWait.waitUntilText("Payments");
	   BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_TAB_PLINK);
	   BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_SECTION_BODY_ID); 
	   BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FEEDBACK_TAB_PLINK);   
	   BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CASH_ACCOUNT_PLINK);     
	   BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_TABLE_ID);
	   
	  

	  } catch (Exception e) {
	   throw new HTMLElementNotFoundException(e,"One of more element necessary for page verification didn't appear.");
	  }
	 }
	
	@Test
	 @Documentation(step = "Click Transaction Tab on payments page", expected = "Transactions Tab Under Payments page should be clicked.")
	 public static void clickTransactionsTabTest() throws Exception {
	  
	  ScriptLogger.info();
	  try {
	   BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_EMP_TRANSACTION_REPORTS_TAB_PLINK);
	   
	  } catch (Exception e) {
	   throw new ScriptException(e);
	  }
	 }
	 
	 
	 @Test
	 @Documentation(step = "Click FreelancerTransaction Tab on payments page", expected = "Transactions Tab Under Payments page should be clicked.")
	 public static void clickFLTransactionsTabTest() throws Exception {
	  
	  ScriptLogger.info();
	  try {
	   BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_FL_TRANSACTION_TAB_PLINK);
	   
	  } catch (Exception e) {
	   throw new ScriptException(e);
	  }
	 }
	 
	 
	 @Test
	 @Documentation(step = "Click Emp 1099 Reports on payments page", expected = "Emp's 1099 Reports Under Payments page should be clicked.")
	 public static void click1099ReportsTabTest() throws Exception {
	  
	  ScriptLogger.info();
	  try {
	   BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_EMP_1099_REPORTS_TAB_PLINK);
	   
	  } catch (Exception e) {
	   throw new ScriptException(e);
	  }
	 }
	 
	 @Test
	 @Documentation(step = "Click FL 1099 Reports on payments page", expected = "Fl 1099 Tax Forms Under Payments page should be clicked.")
	 public static void clickFL1099TaxFormsTabTest() throws Exception {
	  
	  ScriptLogger.info();
	  try {
	   BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_FL_1099_TAX_FORM_TAB_PLINK);
	   
	  } catch (Exception e) {
	   throw new ScriptException(e);
	  }
	 }
	
	// ---------------------- METHODS RELATED TO VIEW & PAY INVOICES ---------------
	// --------------------------------- START -------------------------------------
	
	@Test
	@Documentation(step = "Click On the first View & Pay, or unpaid invoice.", expected = "Able to click.")
	public static void clickFirstUnpaidInvTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_FIRST_VIEW_AND_PAY_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify invoice details", expected = "Able to verify.")
	public static void verifyInvoiceDetailsTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_BACK_TO_ALL_INVOICES_TOGGLE_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_PRINT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_PAY_INVOICE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_BODY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_INVOICE_TOTAL_AMOUNT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for Invoice detail verification didn't load. Possible Build/Application issue.");
		}
		try {
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_DISPUTE_BUTTON_XPATH);
		} catch (Exception e) {
			ScriptLogger.debug("Invoice not safepay secured, so dispute button didn't appear");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify Paid invoice details", expected = "Able to verify.")
	public static void verifyPaidInvoiceDetailsTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_BACK_TO_ALL_INVOICES_TOGGLE_XPATH, 30);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_PRINT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_ISSUE_REFUND_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_ARCHIVE_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_BODY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_INVOICE_TOTAL_AMOUNT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for Invoice detail verification didn't load. Possible Build/Application issue.");
		}
		
	}
	
	@Test
	@Documentation(step = "Click on 'Issue Refund'.", expected = "Able to click.")
	public static void clickIssueRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_ISSUE_REFUND_BUTTON_XPATH);
			Thread.sleep(2000);
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click Issue Refund; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Issue Refund' section.", expected = "Able to verify.")
	public static void verifyIssueRefundSectionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilText("Issue a refund to", 30);
			BrowserWait.waitUntilText("Max. Available For Refund:", "Employer Should Receive");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_EMPLOYER_SHOULD_RECEIVE_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_ISSUE_REFUND_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for Issue Refund section verification didn't load. Possible Build/Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Get Invoice amount shown in the right side panel of the Issue refund section.", expected = "Able to get data.")
	public static void getInvoiceAmountTest() throws Exception {
		ScriptLogger.info();
		try {
			String amount = BrowserAccess.getElement(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_INVOICE_AMOUNT_TEXT_XPATH).getText();
			invoiceAmount = amount.substring(amount.indexOf("$")+1, amount.length());
		} catch (Exception e) {
			throw new ApplicationException("Unable to find Invoice amount in Issue Refund section.");
		}
	}
	
	@Test
	@Parameters("empReceives")
	@Documentation(step = "Enter Invoice amount in Employer should receive Textbox.", expected = "Able to enter Data.")
	public static void enterAmountEmpShouldGetTest(String empReceives) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_EMPLOYER_SHOULD_RECEIVE_TEXTBOX_XPATH, empReceives);
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter data in the 'Employer should receive' textbox.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Issue Refund'.", expected = "Able to click.")
	public static void issueRefundAfterEnteringAmountTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_ISSUE_REFUND_BUTTON_XPATH);
			Thread.sleep(2000);
			
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Issue Refund; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Confirm Refund'.", expected = "Able to click.")
	public static void clickConfirmRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_CONFIRM_REFUND_BUTTON_XPATH, 20);
		} catch (Exception e1) {
			throw new ApplicationException("ConFirm Refund couldn't not be located on the site.");
		}
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_REFUND_SECTION_CONFIRM_REFUND_BUTTON_XPATH);
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Confirm Refund.");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify 'Issue Refund' section.", expected = "Able to verify.")
	public static void verifyIssueSafepayRefundSectionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilText("The Employer has requested a refund for the reasons listed below. To avoid having the funds automatically refunded, either issue or dispute the refund by", 30);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_ISSUE_REFUND_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_DISPUTE_REFUND_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for Issue Refund section verification didn't load. Possible Build/Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Issue Refund' button.", expected = "Able to click.")
	public static void clickIssueSafepayRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_ISSUE_REFUND_BUTTON_XPATH);	
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 'Issue refund' Button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Confirm Refund' section.", expected = "Able to verify.")
	public static void verifyconfirmSafepayRefundSectionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Confirm Refund", 30);
			BrowserWait.waitUntilText("All refunds are final. Guru.com cannot recover refunded payments.");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_CONFIRM_ISSUE_REFUND_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for Confirm Issue Refund section verification didn't load. Possible Build/Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Issue Refund' to Confirm the Issue of Refund.", expected = "Able to click.")
	public static void clickConfirmIssueSafepayRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_CONFIRM_ISSUE_REFUND_BUTTON_XPATH);	
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 'Issue refund' Button.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Issue Refund' section.", expected = "Able to click.")
	public static void verifyRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_ISSUE_SAFEPAY_REFUND_ISSUE_REFUND_BUTTON_XPATH);	
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 'Issue refund' Button.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Pay Invoice'.", expected = "Able to click.")
	public static void clickPayInvoiceTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_PAY_INVOICE_BUTTON_XPATH);
			Thread.sleep(2000);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Unable to click Pay Invoice; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Get the invoice total amount from Invoice details.", expected = "Able to get the amount.")
	public static void getInvoiceTotalAmountTest() throws Exception {
		ScriptLogger.info();
		try {
			String total = BrowserAction.getElement(InvoicePageObjectMap.INVOICE_PAGE_INVOICE_DETAILS_INVOICE_TOTAL_AMOUNT_XPATH).getText();
			String amount = total.substring(total.lastIndexOf("$")+1);
			price = Double.valueOf(amount);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	// ------------------ SENDING INVOICE -------------------
	// ---------------------- START -------------------------
	
	@Test
	@Documentation(step = "Verify the Create Invoice page", expected = "Invoice Page should be loaded")
	public static void verifyCreateInvoicePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Create Invoice");
			BrowserWait.waitUntilText("Payments");
			BrowserWait.waitUntilText("Bill to:");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_INVOICE_BUILDER_SECTION_ID);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_INVOICE_CALCULATION_ID);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_INVOICE_DETAILS_TOTAL_ID);
			BrowserWait.waitUntilText("Notes and attachments");
			BrowserWait.waitUntilText("What kind of job is this?");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_WHAT_KIND_OF_JOB_IS_THIS_DROPDOWN_SELECT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FEEDBACK_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_TRANSFER_METHODS_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CASH_ACCOUNT_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_TRANSACTION_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_FL_1099_TAX_FORM_TAB_PLINK);
		

		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"One of more element necessary for page verification didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Get the invoice total amount from Invoice calculation.", expected = "Able to get the amount.")
	public static void copyInvTotalOnCreateInvTest() throws Exception {
		ScriptLogger.info();
		try {
			String total = BrowserAction.getElement(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_INVOICE_DETAILS_TOTAL_ID).getText();
			String amount = total.substring(total.lastIndexOf("$")+1);
			invTotal = Double.valueOf(amount);
		} catch (Exception e) {
			throw new ScriptException("Unable to retrieve invoice amount data.");
		}
	}
	
	@Test
	@Parameters("jobType")
	@Documentation(step = "Select what kind of job is this.", expected = "Able to select")
	public static void selectKindOfJobTest(String jobType) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_WHAT_KIND_OF_JOB_IS_THIS_DROPDOWN_SELECT_XPATH)); 
			select.selectByVisibleText(jobType);
		} catch (Exception e) {
			throw new ApplicationException("Unable to select type of job while creating invoice.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Preview Invoice.", expected = "Able to click.")
	public static void clickPreviewInvoiceTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_BUTTON_XPATH);
			Thread.sleep(2000);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_PREVIEW_HEADER_ID);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Get Invoice ID in the Preview Invoice section.", expected = "Able to retrieve.")
	public static void getInvoiceIDTest() throws Exception {
		ScriptLogger.info();
		try {
			invoiceID = BrowserAction.getElement(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_INVOICE_ID_TEXT_XPATH).getText();
		} catch (Exception e) {
			throw new ApplicationException("Invoice ID wasn't listed in the Preview. Also possible, data couldn't be retrieved. Cross-verify.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Send Invoice.", expected = "Able to click.")
	public static void clickSendInvoiceTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_SEND_INVOICE_BUTTON_ID);
			Thread.sleep(2000);
			
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue. Or perhaps the elements after clicking didn't appear.");
		}
	}
	
	// -------------- REQUEST A REFUND REASONS SECTION --------------
	// ---------------------------- START ---------------------------
	@Test
	@Documentation(step = "Verify the Request a Refund List of Reasons section.", expected = "The section should load.")
	public static void verifyRequestRefundReasonsSectionTest() throws Exception {
		ScriptLogger.info();
		int size = 0;
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilText("Request a Refund", 30);
			BrowserWait.waitUntilText("List your reasons for requesting a refund. Attach evidence that supports your position...");
			BrowserWait.waitUntilText("List of Reasons");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_ADD_MORE_REASONS_BTN_ID);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REQUEST_REFUND_BTN_ID);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_CANCEL_BTN_ID);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REASONS_TEXTBOXES_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"One of more element necessary for Request a Refund List of Reasons section verification didn't appear.");
		}
		try {
			List<WebElement> textarea = BrowserAccess.getElements(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REASONS_TEXTBOXES_XPATH);
			size = textarea.size();
		} catch (Exception e) {
			ScriptLogger.debug("Unable to get size of textboxes in the List of Reasons section.");
		}
		if(size!=3) {
			throw new ApplicationException("Number of Textboxes for 'List of Reasons' isn't 3.");
		}
	}
	
	@Test
	@Parameters({"noOfReasons", "reasonContent"})
	@Documentation(step = "Enter List of Reasons.", expected = "Able to enter.")
	public static void enterListOfReasonsTest(int reasonsCount, String reasonContent) throws Exception {
		ScriptLogger.info();
		String[] reasons = reasonContent.split("-");
		int size = 0;
		try {
			if(reasonsCount <= 3) {
				List<WebElement> textarea = BrowserAccess.getElements(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REASONS_TEXTBOXES_XPATH);
				size = reasons.length;
				for(int i = 0; i < size; i++) {
					textarea.get(i).sendKeys(reasons[i]);
				}
			} else if (reasonsCount > 3) {
				for(int j = 0; j < reasonsCount - 3; j++) {
					BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_ADD_MORE_REASONS_BTN_ID);
					Thread.sleep(1000);
				}
				List<WebElement> textarea = BrowserAccess.getElements(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REASONS_TEXTBOXES_XPATH);
				size = reasons.length;
				for(int i = 0; i < size; i++) {
					textarea.get(i).sendKeys(reasons[i]);
				}
			}
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter list of Reasons.");
		}
	}
	
	@Test
	@Documentation(step = "Click Request Refund Button.", expected = "Able to click")
	public static void clickRequestRefundTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SECTION_REQUEST_REFUND_BTN_ID);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Request Refund Button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Request Refund with List of Reasons sent.", expected = "Able to verify.")
	public static void verifyRequestRefundSentTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilText("Your request for a refund of", 30);
			BrowserWait.waitUntilText("was sent to", "They have through", "to either issue the refund or dispute your request. If they do not respond by the deadline, we will automatically issue the refund to your cash account.");
			BrowserWait.waitUntilText("If your guru disputes your request, the");
			BrowserWait.waitUntilText("process will begin. We will email you when a response is received or once the funds have been added to your cash account.");
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SENT_SECTION_EDIT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SENT_SECTION_CANCEL_BUTTON_XPATH);
			BrowserWait.waitUntilText("Listed Reasons");
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Request Refund Button.");
		}
	}
	
	@Test
	@Documentation(step = "Get the Invoice ID generated after the request for refund is sent successfully.", expected = "Able to retrieve the ID.")
	public static void getInvoiceIDGeneratedTest() throws Exception {
		ScriptLogger.info();
		try {
			String invoiceText = BrowserAccess.getElement(InvoicePageObjectMap.INVOICE_PAGE_REQUEST_REFUND_SENT_SECTION_INVOICE_ID_TEXT_XPATH).getText();
			int indexOfColon = invoiceText.indexOf(':');
			String after = invoiceText.substring(indexOfColon + 1);
			refundInvoiceID = Integer.parseInt(after.trim());
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Request Refund Button.");
		}
	}
	
	// ----------------------------- END ------------------------------
		
}

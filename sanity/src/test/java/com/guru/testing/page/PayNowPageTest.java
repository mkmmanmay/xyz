package com.guru.testing.page;

import java.util.List;

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
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.constants.PaymentTransferMethods;
import com.guru.testing.objectmap.DashboardPageObjectMap;
import com.guru.testing.objectmap.PayNowPageObjectMap;

public class PayNowPageTest {
	
	public static float funds;
	private static Boolean isPayMethod=false;
	
	@Test
	@Documentation(step = "Verify Pay Now page", expected = "Pay now page should be verified")
	public static void verifyPayNowPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_DIV_XPATH, 30);
			Thread.sleep(5000);
			BrowserWait.waitUntilText("Apply your available funds", 10);
			BrowserWait.waitUntilText("Cash Account");
			BrowserWait.waitUntilText("Amount Due");
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_AGREE_TO_PAY_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_BUTTON_DISABLED_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
		
	@Test
	@Parameters("selectMembership")
	@Documentation(step = "Verify payment page for purchase membership", expected = "Purchase membership payment page should be verified")
	public static void verifyMembershipPaymentPageTest(String selectMembership) throws Exception {
		ScriptLogger.info();
		try {			
			verifyPayNowPageTest();			
			BrowserWait.waitUntilText("Purchase Membership");
			BrowserWait.waitUntilText(selectMembership+" Membership");
			BrowserWait.waitUntilText("Automatically renew my membership.","You can stop ");
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_AUTO_RENEWAL_HELP_NAV_PLINK);
			BrowserWait.waitUntilText("at any time");
			BrowserWait.waitUntilText("I agree to the payment");
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_TERMS_AND_CONDITIONS_HELP_NAV_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_AUTO_RENEW_CHECKBOX_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// -------------------- TO DO -------------------------
	@Test
	@Parameters("paymentMethod")
	@Documentation(step = "Verify payment method is present", expected = "Payment method provided should be present")
	public static void verifyPaymentMethodTest(String paymentMethod) throws Exception {
		ScriptLogger.info();
		try {
			if (!"CASH_ACCOUNT".equals(paymentMethod)){
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SELECT_PAYMENT_METHOD_CHANGE_BUTTON_XPATH);
				
			} else {
				BrowserWait.waitUntilText("Cash Account");
				isPayMethod=true;
			}
			
			
			switch (paymentMethod) {
			case "AMERICAN_EXPRESS":	
				BrowserWait.waitUntilText(PaymentTransferMethods.AMERICAN_EXPRESS.getValue());
				BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_AMERICAN_EXPRESS_LOGO_XPATH);
				isPayMethod=true;
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CANCEL_BUTTON_AFTER_CLICKING_CHANGE_XPATH);
				break;
				
			case "CREDIT_CARD":
				List<WebElement> thElements = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_ROWS_APPEARING_ON_CLICKING_CHANGE_XPATH);
				try {
					int index=0;
					for(WebElement el : thElements) {
						if(el.findElement(By.tagName("p")).getText().equalsIgnoreCase("Visa - 1111")) {
							isPayMethod=true;
							break;
						} else {
							index++;
						}
					}	
					
				} catch (Exception e) {
					
					int index=0;
					for(WebElement el : thElements) {
						if(el.findElement(By.tagName("p")).getText().equalsIgnoreCase("Master Card - 5100")) {
							isPayMethod=true;
							break;
						} else {
							index++;
						}
					}	
					
				}
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CANCEL_BUTTON_AFTER_CLICKING_CHANGE_XPATH);		
				break;
			
			case "PAY_PAL":
				List<WebElement> elements = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_ROWS_APPEARING_ON_CLICKING_CHANGE_XPATH);
				int index = 0;
				for(WebElement el : elements) {
					if(el.findElement(By.tagName("p")).getText().equalsIgnoreCase("gurucomdev_per@gmail.com")) {
						isPayMethod=true;
						break;
					} else {
						index++;
					}
					
				}
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CANCEL_BUTTON_AFTER_CLICKING_CHANGE_XPATH);
				break;
			//TODO for other methods as they come
			default:
				break;
			}
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Uncheck auto upgrade checkbox if it is present", expected = "Auto upgrade check box should be unselected if it is already checked")
	public static void uncheckAutoUpgradeIfCheckedTest() throws Exception {
		ScriptLogger.info();
		try {
			
			if(BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_AUTO_RENEW_CHECKBOX_ID).isSelected()){
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_AUTO_RENEW_CHECKBOX_ID);
			}
			verifyAutoUpgradeMembershipIsUncheckedTest();
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify Auto Upgradeembership checkbox is unchecked", expected = "Auto Upgrade Membership checkbox should be Unchecked")
	public static void verifyAutoUpgradeMembershipIsUncheckedTest() throws Exception {
		ScriptLogger.info();
		try {
			
			if(BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_AUTO_RENEW_CHECKBOX_ID).isSelected()){
				throw new ApplicationException("Auto Upgrade checkbox is not deselected");
			}
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Select Agree to pay Chechbox", expected = "Agree to pay check box should be selected")
	public static void selectAgreeToPayCheckboxTest() throws Exception {
		ScriptLogger.info();
		try {
			
			if(!BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_AGREE_TO_PAY_CHECKBOX_ID).isSelected()){
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_AGREE_TO_PAY_CHECKBOX_ID);
			}
			else{
				throw new ApplicationException("Agree to pay checkbox is already selected");
			}			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Pay button", expected = "Pay Button should be clicked")
	public static void clickToPayTest() throws Exception {
		ScriptLogger.info();
		BrowserAction.switchToDefaultContent();
		if(isPayMethod){
			try {
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_BUTTON_ENABLED_XPATH);
				BrowserWait.waitForPageToBeLoaded();
				
			} catch (Exception e) {
				throw new ScriptException(e);
			}
		}
		else{
			throw new ApplicationException("The payment method was not found.");
		}
		
	}
	
	
	@Test
	@Documentation(step = "Click Pay button", expected = "Pay Button should be clicked")
	public static void clickPayTest() throws Exception {
		ScriptLogger.info();
			try {
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_BUTTON_ENABLED_XPATH);
				BrowserWait.waitForPageToBeLoaded();
				
			} catch (Exception e) {
				throw new ScriptException(e);
			}	
		
	}
	
	
	
	
	@Test
	@Parameters("membership")
	@Documentation(step = "Verify Membership invoice", expected = "Membership invoice should be verified")
	public static void verifyMembershipInvoiceTest(String mem) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Payment Receipt","Expires on","Thank you for your purchase! We sent a copy of your receipt to ");
			BrowserWait.waitUntilText("Transaction ID:","Payment made");			
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PRINT_RECEIPT_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_BACK_TO_MEMBERSHIP_PAGE_PLINK);
			String membership=mem+" Membership";
			BrowserWait.waitUntilText(membership);
			BrowserWait.waitUntilText("Existing Membership");
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Go to FL Dashboard page", expected = "Dashboard link on the FL page should be clicked")
	public static void goToFLDashboardPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(DashboardPageObjectMap.DASHBOARD_PAGE_DASHBOARD_TAB_XPATH);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click 'Pay with Credit Card' option; only appears when no credit card is added to the account.", expected = "Able to click.")
	public static void clickPayWithCCTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_NUMBER_TEXTBOX_XPATH, 10);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("cardNumber")
	@Documentation(step = "Enter card number", expected = "Able to enter number in textbox field.")
	public static void enterCCNumberTest(String number) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_NUMBER_TEXTBOX_XPATH, number);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("month")
	@Documentation(step = "Select exp. month from drop-down.", expected = "Able to select.")
	public static void selectMonthTest(String month) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_EXP_MONTH_DROPDOWN_XPATH)); 
			select.selectByVisibleText(month);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("year")
	@Documentation(step = "Select exp. year from drop-down.", expected = "Able to select.")
	public static void selectYearTest(String year) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_EXP_YEAR_DROPDOWN_XPATH)); 
			select.selectByVisibleText(year);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("cvv")
	@Documentation(step = "Enter CVV number", expected = "Able to enter number in textbox field.")
	public static void enterCVVTest(String cvv) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_CVV_TEXTBOX_XPATH, cvv);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("bidsAdded")
	@Documentation(step = "Verify payment for bids successful", expected = "Able to verify.")
	public static void verifyBidPurchaseSuccessTest(int bidsAdded) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Payment Receipt", 60);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PRINT_RECEIPT_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_TRANSACTION_ID_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_BACK_TO_BIDS_PAGE_PLINK);
			if(!BrowserWait.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_BIDS_ITEM_DESCRIPTION_XPATH).getText().equalsIgnoreCase(bidsAdded+" Bids")) {
				throw new ScriptException("Possible error in logic for comparing Bid purchase description. Cross-verify.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more of the elements required for verification/validation wasn't successful.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Back to bids page' link in the payment receipt place", expected = "Able to click.")
	public static void clickBacktoBidsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_BACK_TO_BIDS_PAGE_PLINK);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// ----------- PAY NOW FOR FEATURING JOB --------------
	// ----------------------- START ----------------------
	@Test
	@Documentation(step = "Verify Pay Now page for Featuring a Job", expected = "Pay now page should be verified")
	public static void verifyPayForFeaturingJobTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Make Payment - Guru.com");
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_DIV_XPATH, 30);
			BrowserWait.waitUntilText("Apply your available funds","Amount Due","Cash Account","Select a payment method");	
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary didn't load at all, or in time during execution. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Use' link to pay using CA Funds", expected = "Able to click 'Use'.")
	public static void clickUseCAfunds() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> use = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_USE_CASH_ACCOUNT_XPATH);
			if(use.size() > 1) {
				use.get(1).click();
				BrowserWait.waitUntilElementIsNotDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_PAYMENT_METHOD_AREA_XPATH);
			} else {
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_USE_CASH_ACCOUNT_XPATH);
				BrowserWait.waitUntilElementIsNotDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_PAYMENT_METHOD_AREA_XPATH);
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the user has 0 CA funds, or has funds but 'Use' link still not showing. Cross-verify.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Featured Job is posted.", expected = "Verification success.")
	public static void verifyJobPostedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com - Post Project Confirmation", 60);
			BrowserWait.waitUntilText("Post a Job - Your job has been posted!", 60);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_GURU_RECOMMENDED_PLINK, 60);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_PAYMENT_RECEIPT_PLINK, 60);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_SEARCH_AND_INVITE_GURUS_BUTTON_XPATH, 60);
		} catch (Exception e) {
			throw new ApplicationException("Job posted message didn't appear. Check if it's an application issue.");
		}
	}
	
	// --------------------------------- END ---------------------------
	
	// --------------------------- PAY NOW FOR INVOICE ------------------
	// --------------------------- START ---------------------------------
	@Test
	@Documentation(step = "Verify Pay Now page for Invoice Payment.", expected = "Pay now page should be verified")
	public static void verifyPayforInvoiceTest() throws Exception {
		ScriptLogger.info();
		try {
			verifyPayNowPageTest();			
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CHECKBOX_RELATED_TEXT_CONTAINER_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}

	
	@Test
	@Parameters("subtractOriginalBy")
	@Documentation(step = "Edit pre-filled Safepay funds by a given amount.", expected = "Able to edit.")
	public static void editSafePayFundsTest(int subtract) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_TEXTBOX_XPATH);
			String amountFromSafePay = String.valueOf(InvoicePageTest.price - subtract);
			BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amountFromSafePay);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Parameters("safepayAmount")
	@Documentation(step = "Enter Safepay amount.", expected = "Able to enter data.")
	public static void enterSafepayAmountTest(String amount) throws Exception {
		ScriptLogger.info();
		try {
			try {
				BrowserAction.clickAndClear(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_TEXTBOX_XPATH);
				BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amount);
			} catch (Exception e) {
				BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amount);
			}
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Documentation(step = "Clear Safepay funds in the Pay Now page.", expected = "Able to clear the Safepay textbox.")
	public static void clearSafePayFundsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_TEXTBOX_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Couldn't click & clear field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Parameters("subtractOriginalBy")
	@Documentation(step = "Edit pre-filled CA funds when clicked on 'Use' link by a given amount.", expected = "Able to edit.")
	public static void editCAFundsTest(int subtract) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_TEXTBOX_XPATH);
			String amountFromCA = String.valueOf(InvoicePageTest.price - subtract);
			BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amountFromCA);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Parameters("caAmount")
	@Documentation(step = "Enter Safepay amount.", expected = "Able to enter data.")
	public static void enterCAAmountTest(String amount) throws Exception {
		ScriptLogger.info();
		try {
			try {
				BrowserAction.clickAndClear(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_TEXTBOX_XPATH);
				BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amount);
			} catch (Exception e) {
				BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_BLANK_TEXTBOX_XPATH).sendKeys(amount);
			}
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field values; possible selenium or locator or script logic issue.");
		}
	}
	
	@Test
	@Documentation(step = "Select Credit Card as payment method.", expected = "Able to Select Credit card.")
	public static void selectCCTest() throws Exception {
		ScriptLogger.info();
		try {
			String method = BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_A_PAYMENT_SELECTED_METHOD_NAME_XPATH).getText();
			switch (method) {
			case "gurucomdev_biz@gmail.com":
			case "gurucomdev_per@gmail.com":
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SELECT_PAYMENT_METHOD_CHANGE_BUTTON_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_YOUR_PAYMENT_METHOD_CONTAINER_APPEARING_ON_CLICKING_CHANGE_XPATH);
				List<WebElement> thElements = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_ROWS_APPEARING_ON_CLICKING_CHANGE_XPATH);
				int index=0;
				for(WebElement el : thElements) {
					if(el.findElement(By.tagName("p")).getText().equalsIgnoreCase("Visa - 1111")) {
						break;
					} else {
						index++;
					}
				}
				List<WebElement> paymentOptions = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_SELECT_BUTTONS_XPATH);
				paymentOptions.get(index).click();
				break;
				
			case "Visa - 1111":	
				
				break;
				
			default:
				break;
			}
		} catch (Exception e) {
			throw new ScriptException("Possible error in Script logic.");
		}
	}
	
	@Test
	@Documentation(step = "Select Paypal as payment method.", expected = "Able to Select Paypal.")
	public static void selectPaypalTest() throws Exception {
		ScriptLogger.info();
		try {
			String method = BrowserAction.getElement(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_A_PAYMENT_SELECTED_METHOD_NAME_XPATH).getText();
			switch (method) {
			case "Visa - 1111":
				BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SELECT_PAYMENT_METHOD_CHANGE_BUTTON_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SELECT_YOUR_PAYMENT_METHOD_CONTAINER_APPEARING_ON_CLICKING_CHANGE_XPATH);
				List<WebElement> thElements = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_ROWS_APPEARING_ON_CLICKING_CHANGE_XPATH);
				int index = 0;
				for(WebElement el : thElements) {
					if(el.findElement(By.tagName("p")).getText().equalsIgnoreCase("gurucomdev_per@gmail.com")) {
						break;
					} else {
						index++;
					}
					
				}
				List<WebElement> paymentOptions = BrowserAction.getElements(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_METHOD_SELECT_BUTTONS_XPATH);
				paymentOptions.get(index).click();
				break;
				
			case "gurucomdev_per@gmail.com":	
				
				break;
				
			default:
				break;
			}
		} catch (Exception e) {
			throw new ScriptException("Possible error in Script logic.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Invoice payment was successful.", expected = "Successfully verified.")
	public static void verifyInvoicePaidTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_TRANSACTION_ID_TEXT_XPATH, 60);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PRINT_RECEIPT_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SUCCESS_PAGE_BACK_TO_MANAGE_INVOICE_PAGE_PLINK);
			Thread.sleep(3000);
			BrowserWait.waitUntilText("Payment Receipt", "Thank you for your payment! We sent a copy of your receipt to");
			BrowserWait.waitUntilText("I authorize Guru.com to release payment to ", "I also acknowledge that Guru.com is not an agent of ", "and invoice payments are final and non-recoverable.");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue. Or possible wait until text didn't succeed.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Back to Manage Invoice' link.", expected = "Able to click.")
	public static void clickBackToInvoiceTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_INVOICE_PAYMENT_SUCCESS_PAGE_BACK_TO_MANAGE_INVOICE_PAGE_PLINK);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	// --------------------------------- END ---------------------------
	
	// ------------------- PAY NOW FOR SAFEPAY FUNDING ------------------
	// ------------------------------ START -----------------------------
	
	@Test
	@Documentation(step = "Verify Pay Now page for Safepay.", expected = "Pay now page should be verified")
	public static void verifyPayforSafepayTest() throws Exception {
		ScriptLogger.info();
		try {
			verifyPayNowPageTest();			
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Verify payment for Safepay succeeded.", expected = "Payment success should be verified.")
	public static void verifySafepayFundSuccessTest() throws Exception {
		ScriptLogger.info();
		try {		
			BrowserWait.waitUntilText("Payment Receipt", 30);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SAFEPAY_FUNDED_SUCCESS_PAGE_THANK_YOU_STATEMENT_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_TRANSACTION_ID_TEXT_XPATH, 60);			
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAYMENT_RECEIPT_DIV_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PRINT_RECEIPT_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_SAFEPAY_FUNDED_SUCCESS_PAGE_BACK_TO_SAFEPAY_PAGE_PLINK);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary to be loaded didn't load. Possible Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Back to SafePay page' link.", expected = "Able to click.")
	public static void clickBackToSafePayPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PayNowPageObjectMap.PAY_NOW_PAGE_SAFEPAY_FUNDED_SUCCESS_PAGE_BACK_TO_SAFEPAY_PAGE_PLINK);
		} catch (Exception e) {
			throw new ScriptException("Unable to click; possible locator or selenium issue. If not, possible application issue.");
		}
	}
	
	// --------------------------- END --------------------------------
	
}

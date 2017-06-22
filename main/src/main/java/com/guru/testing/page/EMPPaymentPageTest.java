package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.guru.testing.objectmap.EMPPaymentPageObjectMap;
import com.guru.testing.objectmap.PaymentsInvoicePageObjectMap;
import com.guru.testing.objectmap.PaymentsTransferPageObjectMap;

public class EMPPaymentPageTest {
	
	@Test
	@Documentation(step = "Click Payment Methods Tab on Employer payments page", expected = "Payment Methods tab should be clicked.")
	public static void clickEMPPaymentMethodsTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_PAYMENT_METHODS_TAB_PLINK);
			
		} catch (Exception e) {
			throw new ApplicationException("Unable click Payment Methods Tab.");
		}
	}

	@Test
	@Documentation(step = "Verify the Payment Methods page for Employer.", expected = "Payment Methods page Page should be loaded.")
	public static void verifyEMPPaymentsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Manage Payment Methods - Guru.com");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_CASH_ACCOUNT_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_TRANSACTION_REPORTS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_1099_REPORTS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FEEDBACK_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_XPATH, 30);
			try{
				BrowserWait.waitUntilText("Add a transfer method");
				BrowserWait.waitUntilText("Earn 3.5% cash back!");
				BrowserWait.waitUntilText("When you pay by check, bank account or wire transfer, we’ll kick the 2.5% handling fee back to you, plus an extra 1% cash back as a thank you!");
				BrowserWait.waitUntilElementIsDisplayed(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_METHODS_EMP_CAN_ADD_XPATH);
			} catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_PAYMENT_METHODS_ADDED_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_ADD_PAYMENT_METHOD_DROPDOWN_XPATH);
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for EMP Payment Methods page verification didn't appear; a possible Application issue. ");
		}
		
	}
	
	@Test
	@Documentation(step = "click 'Add Payment Method' dropdown.", expected = "Should be able to click.")
	public static void clickAddPaymentDropdownTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_ADD_PAYMENT_METHOD_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Parameters("paymentType")
	@Documentation(step = "Select payment type from 'Add Payment Method' dropdown.", expected = "Should be able to select.")
	public static void choosePaymentToAddTest(String type) throws Exception {
		ScriptLogger.info();
		Boolean flag; int size;
		try {
			try {
				BrowserWait.waitUntilElementIsDisplayed(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_METHODS_EMP_CAN_ADD_XPATH, 10);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
			if(flag) {
				List<WebElement> options = BrowserAccess.getElements(EMPPaymentPageObjectMap.EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_METHODS_EMP_CAN_ADD_XPATH);
				size = options.size();
				for (int i = 0; i < size; i++) {
					String title = options.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
					if(type.contains(title)) {
						options.get(i).findElement(By.tagName("a")).click();
						break;
					}
				}
			}
			else {
				clickAddPaymentDropdownTest();
				PaymentsTransferPageTest.choosePaymentToAddTest(type);
			}
		} catch (Exception e) {
			throw new ScriptException("Couldn't select the desired payment Method.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the VISA CC is added and verified.", expected = "Able to verify.")
	public static void verifyVISAVerifiedTest() throws Exception {
		ScriptLogger.info();
		int size; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH, 10);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (int i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("Visa")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector(".subtext.ng-binding")).getText().contains("Expires")) {
					throw new ApplicationException("VISA isn't in verified state.");
				}
			}
		}
	}
	
	@Test
	@Documentation(step = "Verify the Master Card CC is added and verified.", expected = "Able to verify.")
	public static void verifyMasterCardVerifiedTest() throws Exception {
		ScriptLogger.info();
		int size; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH, 10);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (int i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("MasterCard")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector(".subtext.ng-binding")).getText().contains("Expires")) {
					throw new ApplicationException("Master Card isn't in verified state.");
				}
			}
		}
	}
	
	@Test
	@Documentation(step = "Verify the Master Card CC is added and verified.", expected = "Able to verify.")
	public static void verifyAMEXVerifiedTest() throws Exception {
		ScriptLogger.info();
		int size; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH, 10);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (int i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("American Express")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector(".subtext.ng-binding")).getText().contains("Expires")) {
					throw new ApplicationException("AMEX isn't in verified state.");
				}
			}
		}
	}
	
	// ----------------------- REMOVE ALL METHODS ----------------------
	// --------------------------- START -------------------------------
	@Test
	@Documentation(step = "Remove all payment methods added.", expected = "Able to remove payment methods.")
	public static void removeAllPayMethodsTest() throws Exception {
		PaymentsTransferPageTest.removeAllPayMethodsTest();
	}
	// --------------------------- END -------------------------------
}

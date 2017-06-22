package com.guru.testing.page;

import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.testing.objectmap.PaymentsInvoicePageObjectMap;

public class PaymentsInvoicePageTest {
	
	
	@Test
	@Documentation(step = "Verify the Invoice page", expected = "Invoice Page should be loaded")
	public static void verifyInvoicePageTest() throws Exception {
		
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Invoices - Employers - Guru");
			BrowserWait.waitUntilText("Payments");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TABLE_ID);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_BODY_ID);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FEEDBACK_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_PAYMENT_METHODS_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_CASH_ACCOUNT_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_TRANSACTION_REPORTS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_1099_REPORTS_PLINK);	
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Unable to find Invoice page");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Invoice page", expected = "Invoice Page should be loaded")
	public static void verifyFLInvoicePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Guru.com - Manage Invoices");
			BrowserWait.waitUntilText("Payments");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_BODY_ID);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FEEDBACK_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FL_TRANSFER_METHODS_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_CASH_ACCOUNT_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FL_1099_TAX_FORMS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FL_TRANSACTIONS_PLINK);		
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TABLE_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Unable to verify Invoice page");
		}
	}
	
	
	@Test
	@Documentation(step = "Click Transaction Tab on payments page", expected = "Transactions Tab Under Payments page should be clicked.")
	public static void clickTransactionsTabTest() throws Exception {
		
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_TRANSACTION_REPORTS_PLINK);
			
		} catch (Exception e) {
			throw new ApplicationException("Unable click Transactions Tab");
		}
	}
	
	
	@Test
	@Documentation(step = "Click 1099 Reports on payments page", expected = "1099 Reports Under Payments page should be clicked.")
	public static void click1099ReportsTabTest() throws Exception {
		
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_1099_REPORTS_PLINK);
			
		} catch (Exception e) {
			throw new ApplicationException("Unable to click 1099 Reports Tab");
		}
	}
	
	// ---------------------- METHODS RELATED TO VIEW & PAY INVOICES ---------------
	// --------------------------------- START -------------------------------------
		
	@Test
	@Documentation(step = "Click On the first View & Pay, or unpaid invoice.", expected = "Able to click.")
	public static void clickFirstUnpaidInvTest() throws Exception {
		ScriptLogger.info();
		InvoicePageTest.clickFirstUnpaidInvTest();
	}
	
	@Test
	@Documentation(step = "Verify invoice details", expected = "Able to verify.")
	public static void verifyInvoiceDetailsTest() throws Exception {
		ScriptLogger.info();
		InvoicePageTest.verifyInvoiceDetailsTest();
	}
	
	@Test
	@Documentation(step = "Click on 'Pay Invoice;.", expected = "Able to click.")
	public static void clickPayInvoiceTest() throws Exception {
		ScriptLogger.info();
		InvoicePageTest.clickPayInvoiceTest();
	}
	
	@Test
	@Documentation(step = "Get the invoice total amount from Invoice details.", expected = "Able to get the amount.")
	public static void getInvoiceTotalAmountTest() throws Exception {
		ScriptLogger.info();
		InvoicePageTest.getInvoiceTotalAmountTest();
	}
		
	// --------------------------------- END -------------------------------------
}

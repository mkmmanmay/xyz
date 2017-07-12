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
			BrowserWait.waitUntilText("Payments", 30);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_BODY_ID);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_FEEDBACK_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_PAYMENT_METHODS_TAB_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_CASH_ACCOUNT_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_TRANSACTION_REPORTS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_1099_REPORTS_PLINK);	
			BrowserWait.waitUntilElementIsDisplayed(PaymentsInvoicePageObjectMap.PAYMENTS_INVOICE_PAGE_INVOICE_TABLE_ID);
		

		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Unable to find Invoice page");
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
	
	
		
}

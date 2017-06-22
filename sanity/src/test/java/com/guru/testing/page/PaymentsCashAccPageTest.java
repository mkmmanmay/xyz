package com.guru.testing.page;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.PaymentsCashAccPageObjectMap;

public class PaymentsCashAccPageTest {
	
	@Test
	@Documentation(step = "click 'Cash Account' tab.", expected = "Should be able to click.")
	public static void clickCashAccTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(CommonObjectMap.COMMON_GURU_PAYMENTS_PAGE_CASH_ACCOUNT_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Cash Account page for Freelancer.", expected = "Cash Account page should  appear.")
	public static void verifyCashAccPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilTextVisible("Balance:" );
			BrowserWait.waitUntilElementIsDisplayed(PaymentsCashAccPageObjectMap.PAYMENTS_PAGE_CASH_ACCOUNT_WITHDRAW_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to find verify Transfer Methods page");
		}
	}
	
	// METHODS THAT CORRESPOND TO VERIFYNG CA HISTORY AFTER MAKING BIDS PURCHASE
	@Test
	@Parameters({"cardType", "bidsAdded"})
	@Documentation(step = "Verify top two transactions shown in CA history.", expected = "Should be able to verify.")
	public static void verifyTransactionsTest(String cardType, String bids) throws Exception {
		ScriptLogger.info();
		try {
			String row1 = BrowserAction.getElement(PaymentsCashAccPageObjectMap.PAYMENTS_PAGE_CASH_ACCOUNT_DESCRIPTION_ROW1_XPATH).getText();
			Thread.sleep(3000);
			String row2 = BrowserAction.getElement(PaymentsCashAccPageObjectMap.PAYMENTS_PAGE_CASH_ACCOUNT_DESCRIPTION_ROW2_XPATH).getText();
			Thread.sleep(3000);
			if(!(row1.equalsIgnoreCase("Payment for "+bids+" bids") && row2.equalsIgnoreCase("Transfer from "+cardType+" for "+bids+" bids"))) {
				throw new ApplicationException("Cash Account history description doesn't match with what was expected");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to find verify Transfer Methods page");
		}
	}
	

}
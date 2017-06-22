package com.guru.testing.page;

import javax.script.ScriptException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.testing.objectmap.BidsPageObjectMap;
import com.guru.testing.objectmap.PayNowPageObjectMap;


public class BidsPageTest {
	
	private static int beforeCount = 0; 
	private static int afterCount = 0; 
	
	@Test
	@Documentation(step = "Verify the Bids page for Freelancer.", expected = "Bids page should  appear.")
	public static void verifyBidsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Bids - Build Profile - Freelancers - Guru");
			BrowserWait.waitUntilElementIsDisplayed(BidsPageObjectMap.BIDS_PAGE_SUMMARY_PANEL_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(BidsPageObjectMap.BIDS_PAGE_BUY_MORE_BIDS_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(BidsPageObjectMap.BIDS_PAGE_TOTAL_BIDS_AVAILABLE_ID);
			BrowserWait.waitUntilElementIsDisplayed(BidsPageObjectMap.BIDS_PAGE_VIEW_LAST_100_BIDS_LINK_ID);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to verify Bids page");
		}
	}
	
	private static int gettingBidsCountTest() throws Exception {
		ScriptLogger.info();
		int availableBids = 0;
		try {
			String bidsInfo = BrowserWait.getElement(BidsPageObjectMap.BIDS_PAGE_TOTAL_BIDS_AVAILABLE_ID).getText();
			String numberOnly= bidsInfo.replaceAll("[^0-9]", "");
			availableBids = Integer.parseInt(numberOnly);
			return availableBids;
		} catch (Exception e) {
			throw new ScriptException("Error in script logic. Or the data wasn't displayed in the Guru site.");
		}
	}
	
	@Test
	@Documentation(step = "Get count of bids currently available", expected = "Able to get initial count.")
	public static void getBidsCountBeforeTest() throws Exception {
		ScriptLogger.info();
		try {
			beforeCount = gettingBidsCountTest();
		} catch (Exception e) {
			throw new ScriptException("Unable to get Bids count.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Buy More Bids' button.", expected = "Able to click.")
	public static void clickBuyMoreBidsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(BidsPageObjectMap.BIDS_PAGE_BUY_MORE_BIDS_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(BidsPageObjectMap.BIDS_PAGE_BID_PLANS_PANEL_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to click; either element not visible/is disabled, or the subsequent options didn't appear after clicking it.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Add Bids' button.", expected = "Able to click.")
	public static void clickAddBidsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(BidsPageObjectMap.BIDS_PAGE_BID_PLANS_PANEL_ADD_BIDS_BUTTON_ID);
			Thread.sleep(4000);
			BrowserWait.waitUntilElementIsDisplayed(PayNowPageObjectMap.PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_BUTTON_XPATH, 30);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to click; either element not visible/is disabled, or the subsequent options didn't appear after clicking it.");
		}
	}
	
	@Test
	@Documentation(step = "Get count of bids currently available", expected = "Able to get count.")
	public static void getBidsCountAfterTest() throws Exception {
		ScriptLogger.info();
		try {
			afterCount = gettingBidsCountTest();
		} catch (Exception e) {
			throw new ScriptException("Unable to get Bids count.");
		}
	}
	
	@Test
	@Parameters("bidsAdded")
	@Documentation(step = "Compare bids count before with bids count after.", expected = "After should be more if additional bids were purchased.")
	public static void compareBidsCountTest(int extraBids) throws Exception {
		ScriptLogger.info();
		try {
			int difference = afterCount - beforeCount;
			if(!(difference == extraBids)) {
				throw new ApplicationException("Bid increase count didn't match with extra bids purchased.");
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to compare Bids.");
		}
	}
	
	@Test
	@Parameters("bidsSpent")
	@Documentation(step = "Compare bids count after they were spent to existing.", expected = "After should be more if additional bids were purchased.")
	public static void compareBidsCountAfterSpentTest(int bidsSpent) throws Exception {
		ScriptLogger.info();
		try {
			int difference =  beforeCount-afterCount;
			
			if(!(difference == bidsSpent)) {
	throw new ApplicationException("Total number of Bids not increased with Count of new bids purchased.");
			}
		} catch (Exception e) {
			throw new ScriptException("Unable to compare Bids.");
		}
	}
	
	
	
	
	@Test
	@Documentation(step = "Click Payments tab top panel for an employer", expected = "Payments tab should be clicked")
	public static void clickPaymentsTabBidsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(BidsPageObjectMap.BIDS_PAGE_PAYMENT_NAVIGATION_TAB_ID);			
		} catch (Exception e) {
			throw new ScriptException("Pay Tab was not clicked; either it wasn't clickable, or locator issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click Payments tab top panel for an employer", expected = "Payments tab should be clicked")
	public static void verifyOrAddSufficientBidsTest() throws Exception {
		//TODO
		ScriptLogger.info();
		if(beforeCount<6){	
			PayNowPageTest.selectAgreeToPayCheckboxTest();
			PayNowPageTest.clickToPayTest();
			PayNowPageTest.verifyBidPurchaseSuccessTest(12);
			PayNowPageTest.clickBacktoBidsTest();

		}
			
		}
	
}

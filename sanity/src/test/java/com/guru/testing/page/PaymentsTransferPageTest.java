package com.guru.testing.page;

import java.util.List;

import javax.script.ScriptException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.PaymentsTransferPageObjectMap;

public class PaymentsTransferPageTest {
	
	@Test
	@Documentation(step = "click 'Transfer Methods' tab.", expected = "Should be able to click.")
	public static void clickTransferMethodsTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(CommonObjectMap.COMMON_GURU_PAYMENTS_PAGE_TRANSFER_METHODS_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Transfer Methods page for Freelancer.", expected = "Transfer Methods page should  appear.")
	public static void verifyTransferMethodsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilTextVisible("Withdraw with: ", 30);
			BrowserWait.waitUntilTextVisible("Bank account", "PayPal", "Wire Transfer", "Payoneer" );
			BrowserWait.waitUntilTextVisible(" Pay with: ", "Bank account", "Credit card", "PayPal");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to find verify Transfer Methods page");
		}
	}
	
	@Test
	@Parameters("ccLastDigits")
	@Documentation(step = "click 'Remove' link against a credit card.", expected = "Should be able to click.")
	public static void clickRemoveCCTest(String ccLastDigits) throws Exception {
		ScriptLogger.info();
		try {
			WebElement element=BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_METHODS_LIST_XPATH);
		List<WebElement> elements=element.findElements(By.xpath("//h3[class='identityName ng-binding']"));
		int cardPositionFound=0;
		for (WebElement webElement : elements) {
			if(!webElement.getText().contains(ccLastDigits)){
				cardPositionFound++;
				
			}
			else{
				break;
			}
		}
		
		
		WebElement removeElementToBeClicked=element.findElements(By.xpath("//a[contains(text(), 'Remove')]")).get(cardPositionFound);
		removeElementToBeClicked.click();
		
		
			
		} catch (Exception e) {
			throw new ScriptException("Couldn't click; or the element was invisible/disabled.");
		}
	}

	@Test
	@Documentation(step = "click 'Remove Transfer Method' in the confirmation dialog box.", expected = "Should be able to click.")
	public static void clickConfirmRemoveTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CONFIRM_REMOVE_XPATH);
			BrowserWait.waitUntilTextVisible("Add a transfer method", 30);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click; or the element was invisible/disabled. Or Remove was unsuccessful.");
		}
	}
	
	// ----------------------- REMOVE ALL METHODS ----------------------
	// --------------------------- START -------------------------------
	@Test
	@Documentation(step = "Remove all payment methods added.", expected = "Able to remove payment methods.")
	public static void removeAllPayMethodsTest() throws Exception {
		ScriptLogger.info();
		int j, k;
		try {
			List<WebElement> remove = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_REMOVE_LINK_XPATH);
			int size = remove.size();
			j = size;
			for(int i = 0; i < size; i++) {
				remove.get(i).click();
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CONFIRM_REMOVE_XPATH);
				BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CONFIRM_REMOVE_XPATH);
				do {
					try{
						List<WebElement> remove1 = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_REMOVE_LINK_XPATH);
						k = remove1.size();
					} catch (Exception e) {
						k = j;
					}
				} while (j == k);
				j--;
			}
		} catch (Exception e) {
			ScriptLogger.debug("No Payment methods added to be removed.");
		}
	}
	// --------------------------- END -------------------------------
}

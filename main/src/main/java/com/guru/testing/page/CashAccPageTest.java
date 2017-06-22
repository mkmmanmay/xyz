package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.CashAccPageObjectMap;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.DashboardPageObjectMap;

public class CashAccPageTest {
	public static Float CASH_ACCOUNT_BALANCE;
	@Test
	@Documentation(step = "click 'Cash Account' tab.", expected = "Should be able to click.")
	public static void clickCashAccTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(CommonObjectMap.COMMON_GURU_PAYMENTS_PAGE_CASH_ACCOUNT_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Cash Account page for Freelancer.", expected = "Cash Account page should  appear.")
	public static void verifyCashAccPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilTextVisible("Balance:" );
			BrowserWait.waitUntilElementIsDisplayed(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to find verify Cash Account page");
		}
	}
	
	// METHODS THAT CORRESPOND TO VERIFYNG CA HISTORY AFTER MAKING BIDS PURCHASE
	@Test
	@Parameters({"bidsAdded"})
	@Documentation(step = "Verify top two transactions shown in CA history.", expected = "Should be able to verify.")
	public static void verifyTransactionsTest(String bids) throws Exception {
		ScriptLogger.info();
		try {
			String row1 = BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_DESCRIPTION_ROW1_XPATH).getText();
			String row2 = BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_DESCRIPTION_ROW2_XPATH).getText();
			if(!(row1.equalsIgnoreCase("Payment for "+bids+" bids") && row2.equalsIgnoreCase("Transfer for "+bids+" bids"))) {
				throw new ApplicationException("Cash Account history description doesn't match with what was expected");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to find verify Transfer Methods page");
		}
	}

	public static void verifyWithdrawCashPopUp() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TABLE_XPATH,10);
			BrowserWait.waitUntilElementIsDisplayed(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TITLE_ID);
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_CLOSE_ICON_XPATH);
			BrowserWait.waitUntilText("$25.00 minimum per transaction.","Withdraw Funds - $","available");
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_AMOUNT_COLUMN_NAME_XPATH);
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_SEND_TO_COLUMN_NAME_XPATH);
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAWAL_FEE_COLUMN_NAME_XPATH);
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAW_BUTTON_DISABLED_XPATH);
			BrowserWait.waitUntilAtLeastOneElementPresent(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_CANCEL_BUTTON_XPATH);
			getCashAccountBalanceInPopUp();
			
				
	} catch (Exception e) {
		throw new HTMLElementNotFoundException(e,"Withdraw Pop up elements not loaded");
	}
		
	}

	public static Float getCashAccountBalanceInPopUp() throws Exception {
		try {
			CASH_ACCOUNT_BALANCE=(CommonPageTest.getAmount(BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TITLE_ID),"available"));	
			return CASH_ACCOUNT_BALANCE;
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to get cash account balance on dashboard page");
		}
			
		
	}

	public static Float getCashAccountBalanceOnPage() throws Exception {
		try {
			CASH_ACCOUNT_BALANCE=(CommonPageTest.getAmount(BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_CASH_ACCOUNT_BALANCE_DIV_XPATH),""));	
			return CASH_ACCOUNT_BALANCE;
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to get cash account balance on dashboard page");
		}
			
		
	}
	
	public static void enterAmountByRow(Float amount, int rowCount) throws Exception {
		ScriptLogger.info();
		
			try{
				String id="amountInput"+(rowCount-1);
				WebElement element=WebDriverAction.getElement(By.id(id));
				String amountToEnter=amount.toString();
				WebDriverAction.click(element,WebDriverAction.ACTION_STYLE_WEBDRIVER,WebDriverAction.ACTION_STYLE_JAVASCRIPT);
				WebDriverAction.enterFieldValue(element, amountToEnter);
				element.sendKeys(Keys.TAB);
			}
			catch (Exception e) {
				throw new ScriptException("Unable to enter funds.");
			}
	}

	public static void selectSendToOptionAs(String option, int rowCount) throws Exception {

		ScriptLogger.info();
		try {
			String locator="(//select[@ng-model='withdraw.destination'])"+"["+rowCount+"]";
			WebElement ele=WebDriverAction.getElement(By.xpath(locator));
			ele.click();			
			String locator1="(//option[@ng-repeat='transferMethod in transferMethods'][contains(text(), '"+option+"')])["+rowCount+"]";
			WebElement ele1=WebDriverAction.getElement(By.xpath(locator1));
			ele1.click();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
	
	public static void verifyNoWithdrawalFee(int rowNum) throws Exception {
		ScriptLogger.info();
		WebElement rowRequired;
		try {
			List <WebElement> rows=BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TABLE_XPATH).findElements(By.tagName("tr"));
			rows.remove(0);
			rowRequired=rows.get(rowNum-1);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
			if(!rowRequired.findElement(By.xpath("//span[@ng-if='feeAmount(withdraw.destination) === 0'][contains(text(), 'No withdrawal fee')]")).isDisplayed()){
				throw new ApplicationException("'No withdrawl fee' element is either not present or change of locator");
			}
		
		
	}

	public static void clickWithdrawToAnotherAccount() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHRAW_TO_ANOTHER_ACCOUNT_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}

	public static void clickWithdrawInPopUp() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAW_BUTTON_XPATH,WebDriverAction.ACTION_STYLE_WEBDRIVER,WebDriverAction.ACTION_STYLE_JAVASCRIPT);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	public static void verifyCashAccountBalanceOnPage(Float balance) throws Exception {
		ScriptLogger.info();
			BrowserAction.switchToDefaultContent();
			if(balance.compareTo(getCashAccountBalanceOnPage())!=0){
				throw new ApplicationException("Balance Expected: $"+balance+" is not present");
				
				
			}
		
		
	}

	public static void verifyWireTransferWithdrawalFee(int wireTransferRowNum) throws Exception {
		ScriptLogger.info();
		WebElement rowRequired;
		try {
			List <WebElement> rows=BrowserAction.getElement(CashAccPageObjectMap.CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TABLE_XPATH).findElements(By.tagName("tr"));
			rows.remove(0);
			rowRequired=rows.get(wireTransferRowNum-1);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
			if(!rowRequired.findElement(By.xpath("//span[@ng-if='feeAmount(withdraw.destination) > 0'][contains(text(), '-$9.00')]")).isDisplayed()){
				throw new ApplicationException("'-$9.00' withdrawl fee element is either not present or change of locator");
			}
		
			
		
		
	}
	

}
package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
			throw new ApplicationException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Transfer Methods page for Freelancer.", expected = "Transfer Methods page should  appear.")
	public static void verifyTransferMethodsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilText("Withdraw with: ", 60);
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
	
	@Test
	@Documentation(step = "click 'Add Transfer Method' dropdown.", expected = "Should be able to click.")
	public static void clickAddTransferDropdownTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_TRANSFER_METHOD_DROPDOWN_BTN_XPATH);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	
	@Test
	@Parameters("paymentType")
	@Documentation(step = "Select payment type from 'Add Transfer Method' dropdown.", expected = "Should be able to select.")
	public static void choosePaymentToAddTest(String type) throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			List<WebElement> pay= BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_TRANSFER_METHOD_DROPDOWN_OPTIONS_XPATH);
			int size = pay.size();
			for(int i = 0; i < size; i++) {
				String paymentName = pay.get(i).findElement(By.tagName("a")).getText();
				if(paymentName.equals(type)) {
					pay.get(i).findElement(By.tagName("a")).click();
					
					break;
				}
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	// -------------- BANK ACCOUNT ---------------
	// ------------------- START ------------------
	@Test
	@Documentation(step = "Verify the Add Bank Account popup.", expected = "Able to verify.")
	public static void verifyAddBankAccountPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Add Bank Account");
			BrowserWait.waitUntilText("Account Type");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_TYPE_DROPDOWN_ID);
			BrowserWait.waitUntilText("Account Holder Name");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_HOLDER_NAME_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Routing Number");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Account Number");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_NUMBER_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Confirm Account Number");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_CONFIRM_ACCOUNT_NUMBER_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ADD_BANK_ACCOUNT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear; a possible Application issue. Verify screenshot.");
		}
	}
	
	@Test
	@Parameters("accountHolderName")
	@Documentation(step = "Enter Account Holder Name in textbox.", expected = "Should be able to enter.")
	public static void enterAccountHolderNameTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_HOLDER_NAME_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_HOLDER_NAME_TEXTBOX_XPATH, name);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter data into the textbox.");
		}
	}
	
	@Test
	@Parameters("routingNumber")
	@Documentation(step = "Enter Routing Number in textbox.", expected = "Should be able to enter.")
	public static void enterRoutingNumberTest(String number) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_TEXTBOX_XPATH, number);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_SUGGESTION_XPATH, 10);
			BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_TEXTBOX_XPATH).sendKeys(Keys.ARROW_DOWN);
			BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ROUTING_NUMBER_TEXTBOX_XPATH).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter data into the textbox.");
		}
	}
	
	@Test
	@Parameters("accountNumber")
	@Documentation(step = "Enter Account Number in textbox.", expected = "Should be able to enter.")
	public static void enterAccountNumberTest(String number) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_NUMBER_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ACCOUNT_NUMBER_TEXTBOX_XPATH, number);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter data into the textbox.");
		}
	}
	
	@Test
	@Parameters("accountNumber")
	@Documentation(step = "Enter account number in Confirm Account number textbox.", expected = "Should be able to enter.")
	public static void enterConfirmAccountNumberTest(String number) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_CONFIRM_ACCOUNT_NUMBER_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_CONFIRM_ACCOUNT_NUMBER_TEXTBOX_XPATH, number);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter data into the textbox.");
		}
	}
	
	@Test
	@Documentation(step = "click 'Add Bank Account Button' dropdown.", expected = "Should be able to click.")
	public static void clickAddBankAccountBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_ADD_BANK_ACCOUNT_POPUP_ADD_BANK_ACCOUNT_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_BANK_ACCOUNT_ADDED_TOAST_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click; or the element was invisible/disabled.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Add Bank Account Processing text.", expected = "Able to verify.")
	public static void verifyAddBankAccountProcessingTest() throws Exception {
		ScriptLogger.info();
		int size; String paymentType;
		List<WebElement> text;
		try {
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
			if(paymentType.equals("Bank Account")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.className("pending")).getText().equals("Processing")) {
					throw new ApplicationException("Bank Account isn't in pending/processing state.");
				}
			}
		}
		
	}
	
	@Test
	@Documentation(step = "Verify the Add Bank Account Verified text.", expected = "Able to verify.")
	public static void verifyAddBankAccountVerifiedTest() throws Exception {
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
			if(paymentType.equals("Bank Account")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector(".subtext.ng-binding")).getText().contains("Verified")) {
					throw new ApplicationException("Bank Account isn't in verified state.");
				}
			}
		}
		
	}
	
	// ------------------ END --------------------
	// ------------------ PAYPAL -----------------
	// ------------------- START -----------------
	@Test
	@Parameters("paypalId")
	@Documentation(step = "Verify the  Paypal Payment method is added.", expected = "Able to verify.")
	public static void verifyPayPalAddedTest(String paypalId) throws Exception {
		ScriptLogger.info();
		Boolean flag = false;
		int size, i; String paymentType;
		List<WebElement> text;
		try {
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals(paypalId)) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			throw new ApplicationException("PayPal method couldn't be added. Cross-verify.");
		}
		
	}
	// ------------------ END --------------------
	
	// ---------------- WIRE TRANSFER -----------------
	// -------------------- START --------------------
	@Test
	@Documentation(step = "Verify the Add Wire Transfer Form.", expected = "Able to verify.")
	public static void verifyWireTransferAddFormTest() throws Exception {
		ScriptLogger.info();
		Boolean check1, check2;
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_PREFERRED_CURRENCY_SELECT_DROPDOWN_XPATH, 10);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_BILLING_ADDRESS_DIV_CONTAINER_XPATH);
			BrowserWait.waitUntilText("Account/IBAN/CLABE");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ACCOUNT_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Beneficiary Bank Information");
			BrowserWait.waitUntilText("Intermediary Bank Information");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_1_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_1_LOOKUP_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_2_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_2_LOOKUP_BUTTON_XPATH);
			BrowserWait.waitUntilText("Additional Notes");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ADDITIONAL_NOTES_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Terms and Conditions");
			BrowserWait.waitUntilText("Guru.com reserves the right to change or cancel the wire transfer receipt option or block users from using it at any time.");
			BrowserWait.waitUntilText("Authorization Confirmation");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AGREE_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AUTHORIZE_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ADD_WIRE_TRANSFER_ACCOUNT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear; a possible Application issue. Verify.");
		}
		try {
			check1 = BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AGREE_CHECKBOX_ID).isSelected();
			check2 = BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AUTHORIZE_CHECKBOX_ID).isSelected();
		} catch (Exception e) {
			throw new ScriptException("Unable to get checkbox state.");
		}
		if ((check1 && check2)) {
			throw new ApplicationException("Checkbox selected by default.");
		}
	}
	
	@Test
	@Parameters("preferredCurrency")
	@Documentation(step = "Verify the Add Bank Account popup.", expected = "Able to verify.")
	public static void selectPreferredCurrencyTest(String prefCurrency) throws Exception {
		ScriptLogger.info();
		try {
			Select select= new Select(BrowserAction.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_PREFERRED_CURRENCY_SELECT_DROPDOWN_XPATH));
			select.selectByVisibleText(prefCurrency);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Preferred currency option wasn't found.");
		}
	}
	
	@Test
	@Parameters("accountID")
	@Documentation(step = "Enter account ID in Account/IBAN/CLABE textbox field.", expected = "Able to enter.")
	public static void enterWireAccountIDTest(String accountID) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ACCOUNT_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ACCOUNT_TEXTBOX_XPATH, accountID);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to enter data into the textbox.");
		}
	}
	
	@Test
	@Parameters("swiftID")
	@Documentation(step = "Enter swift ID in SWIFT/BIC textbox field.", expected = "Able to enter.")
	public static void enterSwiftIDTest(String swiftID) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_1_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_1_TEXTBOX_XPATH, swiftID);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to enter data into the textbox.");
		}
	}
	
	@Test
	@Documentation(step = "Click Lookup against first swift textbox.", expected = "Able to click.")
	public static void clickLookupOneTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_SWIFT_1_LOOKUP_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_BANK_FOUND_AS_PER_SWIFT_XPATH, 15);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to click 'Look up'.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'I have read and agree to the Terms and Conditions listed above.' Checkbox.", expected = "Able to click.")
	public static void clickIAgreeCheckboxTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AGREE_CHECKBOX_ID);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to click 'I have read and agree to the Terms and Conditions listed above.' checkbox.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'I authorize Guru.com to initiate electronic transfers...' Checkbox.", expected = "Able to click.")
	public static void clickIAuthorizeCheckboxTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_I_AUTHORIZE_CHECKBOX_ID);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to click 'I authorize Guru.com to initiate electronic transfers...' checkbox.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Add Wire Transfer Account' button.", expected = "Able to click.")
	public static void clickAddWireTransferBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_WIRE_TRANSFER_ADD_WIRE_TRANSFER_ACCOUNT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException(e, "Wasn't able to click 'Add Wire Transfer Account' button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Add Bank Account Verified text.", expected = "Able to verify.")
	public static void verifyWireTransferPendingTest() throws Exception {
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
			if(paymentType.equals("Bank Account")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector("pending")).getText().equals("Pending Verification")) {
					throw new ApplicationException("Wire Transfer isn't in verified state.");
				}
			}
		}
		
	}
	
	@Test
	@Documentation(step = "Verify the Wire Transfer account Verified.", expected = "Able to verify.")
	public static void verifyWireTransferVerifiedTest() throws Exception {
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
			if(paymentType.equals("Wire Transfer")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElements(By.cssSelector(".subtext.ng-binding")).get(1).getText().contains("Verified")) {
					throw new ApplicationException("Wire Transfer Account isn't in verified state.");
				}
			}
		}
		
	}
	
	// ---------------------- END ----------------------
	
	// --------------------- PAYONEER ------------------
	// ---------------------- START ----------------------
	@Test
	@Documentation(step = "Verify the Add Bank Account Processing text.", expected = "Able to verify.")
	public static void verifyAddPayoneerPendingTest() throws Exception {
		ScriptLogger.info();
		int size; String paymentType;
		List<WebElement> text;
		try {
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
			if(paymentType.equals("Prepaid MasterCard")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.className("pending")).getText().equals("Pending Verification")) {
					throw new ApplicationException("Payoneer isn't in pending/processing state.");
				}
			}
		}
		try {
			BrowserWait.waitUntilText("Payoneer is processing your request.");
		} catch(Exception e) {
			throw new ApplicationException("Payoneer is in Pending verification state, but the text expected in the payment title isn't coming.");
		}
	}
	
	@Test
	@Parameters({"payoneerApproveUrl"})
	@Documentation(step = "", expected = "")
	public static void launchPayoneerVerifyURLTest(String url) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.openBrowser(url+AdminCRMPageTest.userID);
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new ScriptException("Unable to launch Payoneer Approve URL.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Payoneer account is verified.", expected = "Able to verify.")
	public static void verifyPayoneerVerifiedTest() throws Exception {
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
			if(paymentType.equals("Wire Transfer")) {
				if(!text.get(i).findElement(By.className("avatarinfo")).findElement(By.cssSelector(".subtext.ng-binding")).getText().contains("Verified")) {
					throw new ApplicationException("Payoneer isn't in verified state.");
				}
			}
		}
		
	}
	
	// ---------------------- END ----------------------
	
	// -------------- BANK ACCOUNT ---------------
	// ------------------- START ------------------
	
	@Test
	@Documentation(step = "Verify Credit add popup.", expected = "Able to verify.")
	public static void verifyCreditCardPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CONTAINER_XPATH, 5);
			BrowserWait.waitUntilText("Add Credit Card");
			BrowserWait.waitUntilText("Card Number");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CARD_NUMBER_TEXTBOX_XPATH);
			BrowserWait.waitUntilText("Expiration Date");
			BrowserWait.waitUntilText("Security Code");
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_MONTH_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_YEAR_DROPDOWN_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SECURITY_CODE_TEXTBOX_XPATH);
			try {
				BrowserWait.waitUntilText("Name on Card");
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_NAME_ON_CARD_TEXTBOX_XPATH);
				BrowserWait.waitUntilText("Country");
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_COUNTRY_DROPDOWN_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_STREET_ADDRESS_TEXTBOX_XPATH);
				BrowserWait.waitUntilText("City");
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CITY_TEXTBOX_XPATH);
				BrowserWait.waitUntilText("State");
				BrowserWait.waitUntilText("ZIP");
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_STATE_DROPDOWN_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_ZIP_TEXTBOX_XPATH);
			} catch (Exception e) {
				ScriptLogger.debug("Address info in the user's profile is set already in their profile page.");
				BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_BILLING_AND_STREET_ADDRESS_BOX_XPATH);
			}
			
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_ADD_CREDIT_CARD_BUTTON_XPATH);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for verification of Credit card popup didn't appear; a possible Application issue.");
		}
	}
	
	@Test
	@Parameters("cardNumber")
	@Documentation(step = "Enter Credit card number.", expected = "Able to enter number.")
	public static void enterCCNumberTest(String cardNumber) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CARD_NUMBER_TEXTBOX_XPATH, cardNumber);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter Card number into the textbox.");
		}
	}
	
	@Test
	@Parameters("expiryMonth")
	@Documentation(step = "Select Month of expiry.", expected = "Able to select.")
	public static void selectExpiryMonthTest(String month) throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(3000);
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_MONTH_DROPDOWN_XPATH, 10);
			Select select = new Select(BrowserAccess.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_MONTH_DROPDOWN_XPATH));
			select.selectByVisibleText(month);
		} catch (Exception e) {
			throw new ApplicationException("Unable to select from month dropdown.");
		}
	}
	
	@Test
	@Parameters("expiryYear")
	@Documentation(step = "Select Year of expiry", expected = "Able to select.")
	public static void selectExpiryYearTest(String year) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_YEAR_DROPDOWN_XPATH, 10);
			Select select = new Select(BrowserAccess.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SELECT_YEAR_DROPDOWN_XPATH));
			select.selectByVisibleText(year);
		} catch (Exception e) {
			throw new ApplicationException("Unable to select from year dropdown.");
		}
	}
	
	@Test
	@Parameters("cvv")
	@Documentation(step = "Enter CVV code in textbox.", expected = "Able to enter.")
	public static void enterCVVTest(String cvv) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_SECURITY_CODE_TEXTBOX_XPATH, cvv);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter cvv into the textbox.");
		}
	}
	
	@Test
	@Parameters("streetAddress")
	@Documentation(step = "Enter street address in textbox.", expected = "Able to enter.")
	public static void enterStreetAddressTest(String address) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_STREET_ADDRESS_TEXTBOX_XPATH, 10);
			BrowserAction.clickAndClear(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_STREET_ADDRESS_TEXTBOX_XPATH);
			BrowserAction.enterFieldValue(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_STREET_ADDRESS_TEXTBOX_XPATH, address);
			BrowserAccess.getElement(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_STREET_ADDRESS_TEXTBOX_XPATH).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter street address into the textbox.");
		}
	}
	
	@Test
	@Documentation(step = "click on 'Add Credit Card' button.", expected = "Able to enter.")
	public static void clickAddCreditCardTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_ADD_CREDIT_CARD_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click Add Credit card button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the VISA Creditcard method is added.", expected = "Able to verify.")
	public static void verifyVisaCCAddedTest() throws Exception {
		ScriptLogger.info();
		Boolean flag = false;
		int size, i; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CONTAINER_XPATH);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("Visa")) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			throw new ApplicationException("VISA couldn't be added. Cross-verify.");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify the Master Card Creditcard method is added.", expected = "Able to verify.")
	public static void verifyMasterCardCCAddedTest() throws Exception {
		ScriptLogger.info();
		Boolean flag = false;
		int size, i; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CONTAINER_XPATH);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("MasterCard")) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			throw new ApplicationException("Master Card couldn't be added. Cross-verify.");
		}
		
	}
	
	@Test
	@Documentation(step = "Verify the AMEX Creditcard method is added.", expected = "Able to verify.")
	public static void verifyAMEXCCAddedTest() throws Exception {
		ScriptLogger.info();
		Boolean flag = false;
		int size, i; String paymentType;
		List<WebElement> text;
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_CREDIT_CARD_POPUP_CONTAINER_XPATH);
			text = BrowserAccess.getElements(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_PAY_METHODS_INFO_XPATH);
			size = text.size();
		} catch (Exception e) {
			throw new ScriptException("Unable to get payment methods added.");
		}
		for (i = 0 ; i < size ; i++) {
			try{
				paymentType = text.get(i).findElement(By.className("avatar")).findElement(By.tagName("img")).getAttribute("title");
			} catch (Exception e) {
				throw new ScriptException("Unable to get payment title.");
			}
			if(paymentType.equals("American Express")) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			throw new ApplicationException("AMEX couldn't be added. Cross-verify.");
		}
	}
	
	// ----------------------- REMOVE ALL METHODS ----------------------
	// --------------------------- START -------------------------------
	@Test
	@Documentation(step = "Remove all payment methods added.", expected = "Able to remove payment methods.")
	public static void removeAllPayMethodsTest() throws Exception {
		ScriptLogger.info();
		BrowserWait.waitUntilElementIsDisplayed(PaymentsTransferPageObjectMap.PAYMENTS_PAGE_TRANSFER_METHODS_REMOVE_LINK_XPATH, 10);
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

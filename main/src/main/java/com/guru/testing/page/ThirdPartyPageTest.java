package com.guru.testing.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.testing.objectmap.ThirdPartyPageObjectMap;

public class ThirdPartyPageTest {
	
	public static int loginType;
	
	// --------------- PAYPAL PAGE ---------------
	// ------------------ START ------------------
	@Test
	@Documentation(step = "Verify Paypal Login Page.", expected = "Able to verify.")
	public static void verifyPaypalPageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			BrowserWait.waitForPageToBeLoaded();
			BrowserAction.switchToFrame("injectedUl");
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_EMAIL_TEXTBOX_XPATH, 60);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_PASSWORD_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_LOGIN_BUTTON_ID);
			loginType = 1;
		} catch (Exception e) {
			// For the second kind of login prompt from paypal Sandbox side.
			
			BrowserAction.click(ThirdPartyPageObjectMap.PAYPAL_PAGE_LOAD_LOGIN_PAGE_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_EMAIL_TEXTBOX_XPATH, 15);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_PASSWORD_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_BUTTON_ID);
			loginType = 2;
		}
	}
	
	@Test
	@Parameters("paypalId")
	@Documentation(step = "Enter Paypal user Id on paypal login page.", expected = "Able to enter data.")
	public static void enterPaypalUserIdTest(String paypalId) throws Exception {
		ScriptLogger.info();
		try{
			if(loginType == 1){
				BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYPAL_PAGE_EMAIL_TEXTBOX_XPATH);
				BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYPAL_PAGE_EMAIL_TEXTBOX_XPATH, paypalId);
			} else if (loginType == 2) {
				BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_EMAIL_TEXTBOX_XPATH);
				BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_EMAIL_TEXTBOX_XPATH, paypalId);
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter paypal Id.");
		}
	}
	
	@Test
	@Parameters("paypalPass")
	@Documentation(step = "Enter Paypal password on paypal login page.", expected = "Able to enter data.")
	public static void enterPaypalPasswordTest(String paypalPass) throws Exception {
		ScriptLogger.info();
		try {
			if(loginType == 1){
				BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYPAL_PAGE_PASSWORD_TEXTBOX_XPATH);
				BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYPAL_PAGE_PASSWORD_TEXTBOX_XPATH, paypalPass);
			} else if (loginType == 2) {
				BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_PASSWORD_TEXTBOX_XPATH);
				BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_PASSWORD_TEXTBOX_XPATH, paypalPass);
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't enter paypal password.");
		}
	}
	
	@Test
	@Documentation(step = "Click login button on the paypal login page.", expected = "Able to click.")
	public static void clickPaypalLoginBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			if(loginType == 1){
				BrowserAction.click(ThirdPartyPageObjectMap.PAYPAL_PAGE_LOGIN_BUTTON_ID);
				BrowserWait.waitUntilElementIsNotDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_LOGIN_MAIN_PAGE_DISABLED_DUE_TO_PROCESSING_LOGIN_XPATH, 30);
			} else if (loginType == 2) {
				BrowserAction.click(ThirdPartyPageObjectMap.PAYPAL_PAGE_TYPE_2_LOGIN_BUTTON_ID);
				BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_TYPE_2_LOGIN_AGREE_AND_CONTINUE_BUTTON_ID, 30);
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click 'Login' button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Paypal Billing Agreement ", expected = "Able to click.")
	public static void verifyBillingAgreementTest() throws Exception {
		ScriptLogger.info();
		try {
			if(loginType == 1){
				Thread.sleep(8000);
				BrowserWait.waitForPageToBeLoaded();
				BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_AGREE_AND_CONTINUE_BUTTON_ID, 30);
			} else if (loginType == 2) {
				Thread.sleep(8000);
				BrowserWait.waitForPageToBeLoaded();
				BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_TYPE_2_LOGIN_AGREE_AND_CONTINUE_BUTTON_ID, 30);
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "billing Agreement page not found.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Agree & continue' button in the Billing agreement page.", expected = "Able to click.")
	public static void clickAgreeAndContinuePaypalTest() throws Exception {
		ScriptLogger.info();
		try {
			if(loginType == 1){
				BrowserWait.waitForPageToBeLoaded();
				BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_AGREE_AND_CONTINUE_BUTTON_ID, 30);
				Thread.sleep(5000);
				BrowserAction.click(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_AGREE_AND_CONTINUE_BUTTON_ID);
				Thread.sleep(5000);
			} else if (loginType == 2) {
				BrowserWait.waitForPageToBeLoaded();
				BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_TYPE_2_LOGIN_AGREE_AND_CONTINUE_BUTTON_ID, 30);
				Thread.sleep(5000);
				BrowserAction.click(ThirdPartyPageObjectMap.PAYPAL_PAGE_BILLING_AGREEMENT_TYPE_2_LOGIN_AGREE_AND_CONTINUE_BUTTON_ID);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Couldn't click 'Agree & Continue' button.");
		}
	}
	// ------------------PAYPAL END --------------------
	
	// --------------- PAYONEER PAGE ---------------
	// -------------------- START -------------------
	
	@Test
	@Documentation(step = "Verify Payoneer SignUp Page.", expected = "Able to verify.")
	public static void verifyPayoneerPageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_CONTAINER_ID, 20);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_ALREADY_HAVE_AN_ACCOUNT_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_SERVICES_CONTAINER_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_PREPAID_MASTER_CARD_RADIO_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_BANK_TRANSFERS_RADIO_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_CONTAINER_SIGN_UP_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "click 'Prepaid MasterCard card' radio button.", expected = "Able to click.")
	public static void selectPrepaidMasterCardRadioTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_PREPAID_MASTER_CARD_RADIO_BUTTON_XPATH);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "click 'Sign up' button.", expected = "Able to click.")
	public static void clickSignUpPayoneerTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_SIGNUP_OPTIONS_CONTAINER_SIGN_UP_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Prepaid Card Setup' Personal Details SignUp Page.", expected = "Able to verify.")
	public static void verifyPrepaidCardSetupPersonalPageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_TITLE_XPATH, 10);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_FIRST_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_LAST_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_EMAIL_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_EMAIL_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_DATE_OF_BIRTH_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PERSONAL_DETAILS_NEXT_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerFirstName")
	@Documentation(step = "Enter Payoneer First Name in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerFirstNameTest(String firstName) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_FIRST_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_FIRST_NAME_TEXTBOX_ID, firstName);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerLastName")
	@Documentation(step = "Enter Payoneer LAst Name in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerLastNameTest(String lastName) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_LAST_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_LAST_NAME_TEXTBOX_ID, lastName);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Enter Payoneer Email in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerEmailTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_EMAIL_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_EMAIL_TEXTBOX_ID, AdminCRMPageTest.userEmail);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Enter Payoneer Email in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerRetypeEmailTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_EMAIL_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_EMAIL_TEXTBOX_ID, AdminCRMPageTest.userEmail);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on Date of Birth textbox.", expected = "Able to click.")
	public static void clickDateOfBirthTextboxTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_DATE_OF_BIRTH_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_MONTH_DROPDOWN_XPATH);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerBirthMonth")
	@Documentation(step = "Select Month of birth.", expected = "Able to select.")
	public static void selectBirthMonthTest(String birthMonth) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_MONTH_DROPDOWN_XPATH));
			select.selectByVisibleText(birthMonth);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerBirthYear")
	@Documentation(step = "Select Month of birth.", expected = "Able to select.")
	public static void selectBirthYearTest(String birthYear) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_YEAR_DROPDOWN_XPATH));
			select.selectByVisibleText(birthYear);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on Date of Birth from the calendar box.", expected = "Able to click.")
	public static void clickDateOfBirthTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_SECOND_ROW_FIRST_DATE_XPATH);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Next' button.", expected = "Able to click.")
	public static void clickNextGettingStartedPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PERSONAL_DETAILS_NEXT_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Prepaid Card Setup' Contact Details SignUp Page.", expected = "Able to verify.")
	public static void verifyPrepaidCardSetupContactPageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ADDRESS_LINE1_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CITY_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ZIP_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PHONE_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CONTACT_DETAILS_NEXT_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerCountry")
	@Documentation(step = "Select Country.", expected = "Able to select.")
	public static void selectPayoneerCountryTest(String country) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_COUNTRY_DROPDOWN_XPATH));
			select.selectByVisibleText(country);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerAddress")
	@Documentation(step = "Enter Payoneer Address in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerAddressTest(String address) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ADDRESS_LINE1_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ADDRESS_LINE1_ID, address);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerCity")
	@Documentation(step = "Enter Payoneer Address in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerCityTest(String city) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CITY_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CITY_TEXTBOX_ID, city);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerZip")
	@Documentation(step = "Enter Payoneer Zip/Postal code in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerZipCodeTest(String zip) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ZIP_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ZIP_TEXTBOX_ID, zip);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerPhoneISDCode")
	@Documentation(step = "Select ISD Country Code.", expected = "Able to select.")
	public static void selectISDCodeTest(String phoneISDCode) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ISD_CODE_DROPDOWN_ID));
			select.selectByVisibleText(phoneISDCode);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerPhoneNo")
	@Documentation(step = "Enter Payoneer Zip/Postal code in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerPhoneNoTest(String phoneNo) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PHONE_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PHONE_TEXTBOX_ID, phoneNo);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Next' button.", expected = "Able to click.")
	public static void clickNextContactDetailsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CONTACT_DETAILS_NEXT_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Prepaid Card Setup' Security Details SignUp Page.", expected = "Able to verify.")
	public static void verifyPrepaidCardSetupSecurityPageTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(5000);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_USERNAME_TEXTBOX_ID, 10);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PASSWORD_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_PASSWORD_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_ANSWER_TEXTBOX_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerPassword")
	@Documentation(step = "Enter Payoneer Password in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerPasswordTest(String pass) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PASSWORD_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PASSWORD_TEXTBOX_ID, pass);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerPassword")
	@Documentation(step = "Enter Payoneer Password in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerRetypePasswordTest(String pass) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_PASSWORD_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_PASSWORD_TEXTBOX_ID, pass);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Select Security Question.", expected = "Able to select.")
	public static void selectPayoneerSecurityQuestionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_QUESTIONS_DROPDOWN_ID);
			BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_QUESTIONS_DROPDOWN_ID).sendKeys(Keys.ARROW_DOWN);
			BrowserAccess.getElement(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_QUESTIONS_DROPDOWN_ID).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerSecurityAns")
	@Documentation(step = "Enter Payoneer Zip/Postal code in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerSecurityAnsTest(String securityAns) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_ANSWER_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_ANSWER_TEXTBOX_ID, securityAns);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Next' button.", expected = "Able to click.")
	public static void clickNextSecurityDetailsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_DETAILS_NEXT_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify 'Prepaid Card Setup' Security Details SignUp Page.", expected = "Able to verify.")
	public static void verifyCardSetupAlmostDonePageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			Thread.sleep(5000);
			BrowserAction.switchToFrame("iframMR");
			//BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_TYPE_DROPDOWN_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_NUMBER_TEXTBOX_ID);
			//BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_COUNTRY_OF_ISSUE_DROPDOWN_ID);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX1_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX2_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX3_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_BUTTON_ID);
		} catch (Exception e) {
			//throw new Exception(e);
		}
	}
	
	@Test
	@Parameters("payoneerIDNumber")
	@Documentation(step = "Enter ID Number in textbox.", expected = "Able to enter data.")
	public static void enterPayoneerIDNumberTest(String idNumber) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_NUMBER_TEXTBOX_ID);
			BrowserAction.enterFieldValue(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_NUMBER_TEXTBOX_ID, idNumber);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Check all checkboxes to agree with terms and condition.", expected = "Able to click.")
	public static void checkAllCheckboxesPayoneerTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(2000);
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX1_XPATH);
			Thread.sleep(3000);
			//Thread.sleep(2000);
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX2_XPATH);
			Thread.sleep(2000);
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX3_XPATH);
			Thread.sleep(2000);
		} catch (Exception e) {
			//throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Order' button.", expected = "Able to click.")
	public static void clickPayoneerOrderButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_BUTTON_ID);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test
	@Documentation(step = "Enter ID Number in textbox.", expected = "Able to enter data.")
	public static void verifyPayoneerOrderSuccessTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_SUCCESS_CONGRATULATIONS_XPATH, 20);
			BrowserWait.waitUntilElementIsDisplayed(ThirdPartyPageObjectMap.PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_SUCCESS_REVIEW_IN_PROCESS_XPATH);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}

package com.guru.testing.page;

import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.objectmap.PhoneVerificationPageObjectMap;

public class PhoneVerificationPageTest {

	@Test
	@Documentation(step = "Verify if 'Phone Verification' page appeared.", expected = "Phone verification page should appear only if phone number wasn't already added to the account.")
	public static void verifyPhoneVerificationPageTest() throws Exception {
		try {
			ScriptLogger.info();
			BrowserWait.waitUntilPageTitle("Verify your phone number - Guru");
			
		} catch (Exception e) {
			ScriptLogger.debug("Verification of Phone Verification page returned false.");
			// throw new Exception(); Add this depending on behavior. If it should appear, then uncomment the throw statement.
		}
	}

	@Test
	@Documentation(step = "Verify Phone Verification appeared or not", expected = "Return true if phone verification appeared else false")
	public static Boolean didPhoneVerificationPageAppearTest() throws Exception {
		Boolean flag = null;
		try {
			BrowserWait.waitUntilPageTitle("Verify your phone number - Guru");
			flag = true;
		} catch (Exception e) {
			ScriptLogger.info("The Phone verification page didn't appear. Skipping to further verifications.");
			flag = false;
		}
		return flag;
	}

	@Test
	@Documentation(step = "If Phone Verification page appeared, check if 'Skip this for now' is present. Click it, if it is present.", 
					expected = "User is able to click 'Skip this for now' to skip Phone verification process.")
	public static void verifySkipThisForNowLinkTest() throws Exception {
		if (didPhoneVerificationPageAppearTest()) {
			ScriptLogger.info();
			try {
				BrowserWait.waitUntilElementIsDisplayed(PhoneVerificationPageObjectMap.PHONE_VERIFICATION_PAGE_SKIP_THIS_FOR_NOW_LINK_ID);
				ScriptLogger.info("'Skip this for now' link is present.");
				clickSkipThisForNowTest();
			} catch (Exception e) {
				ScriptLogger.debug("'Skip this for now' link isn't present.");
				// throw new Exception();
			}
		}
	}
	private static void clickSkipThisForNowTest() throws Exception {
		try {
			ScriptLogger.info();
			BrowserAction.click(PhoneVerificationPageObjectMap.PHONE_VERIFICATION_PAGE_SKIP_THIS_FOR_NOW_LINK_ID);
		} catch (Exception e) {
			ScriptLogger.debug("Couldn't click 'Skip this for now'. Test case will fail.");
			throw new Exception();
		}
	}

}

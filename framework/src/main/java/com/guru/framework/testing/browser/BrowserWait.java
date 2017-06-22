package com.guru.framework.testing.browser;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.guru.framework.testing.selenium.WebDriverWaits;

public class BrowserWait extends BrowserAccess{
	
	/**
	 * Wait until elements are displayed
	 * @param Object
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilElementIsDisplayed(final Object... locator)
			throws Exception {
		for (Object each : locator) {
		
			WebDriverWaits.waitUntilElementIsDisplayed(getLocator(each));
		}		
	}

	/**
	 * Wait until elements are displayed
	 * @param WebElement
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilElementIsDisplayed(final WebElement e1)	throws Exception {		
		WebDriverWaits.waitUntilElementIsDisplayed(e1);		
	}
	
	/**
	 * Wait until elements are displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilElementIsDisplayed(final Object locator, final int waitTime) throws Exception {		
		
		WebDriverWaits.waitUntilElementIsDisplayed(getLocator(locator), waitTime);
		
	}

	/**
	 * Wait until elements are not displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilElementIsNotDisplayed(final Object... locator)
			throws Exception {
		for (Object each : locator) {
			
			WebDriverWaits.waitUntilElementIsNotDisplayed(getLocator(each));
		}
	}
	
	/**
	 * Wait until elements are not displayed
	 * @param WebElement
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilElementIsNotDisplayed(final WebElement e1)
			throws Exception {
		WebDriverWaits.waitUntilElementIsNotDisplayed(e1);
	}

	/**
	 * Wait until element is not displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */	
	public static void waitUntilElementIsNotDisplayed(final Object locator, final int waitTime) throws Exception {
	
		WebDriverWaits.waitUntilElementIsNotDisplayed(getLocator(locator), waitTime);
	}

	/**
	 * Wait until more than one elements are present
	 * @param Object
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilMoreThanOneElementPresent(final Object... locator) throws Exception {
		for (Object each : locator) {
			
			WebDriverWaits.waitUntilMoreThanOneElementPresent(getLocator(each));
		}
	}
	
	/**
	 * Wait until more than one elements are present
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilMoreThanOneElementPresent(final Object locator,final int waitTime) throws Exception {
		
		WebDriverWaits.waitUntilMoreThanOneElementPresent(getLocator(locator), waitTime);
	}

	/**
	 * Wait until specified numbers of elements are present
	 * @param locator
	 * @param count
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilCountOfElementsPresent(final Object locator,
			final int count) throws Exception {
		//ScriptLogger.debug("Waiting for "+count+" instances of element to present: \"[Locator = {"+ObjectMapHelper.getLocatorName(locator)+ ": "+locator+ "}]\"" );		
		WebDriverWaits.waitUntilCountOfElementsPresent(getLocator(locator), count);
	}
	
	/**
	 * Wait until specified numbers of elements are present
	 * @param locator
	 * @param count
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilCountOfElementsPresent(final Object locator,
			final int count, final int waitTime) throws Exception {
		WebDriverWaits.waitUntilCountOfElementsPresent(getLocator(locator), count, waitTime);
	}
	
	
	/**
	 * Wait until at least one element is present
	 * @param Object
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilAtLeastOneElementPresent(final Object... locator) throws Exception {
		for (Object each : locator) {
			
			WebDriverWaits.waitUntilAtLeastOneElementPresent(getLocator(each));
		}
	}
	
	/**
	 * Wait until more than one elements are present
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilAtLeastOneElementPresent(final Object locator,final int waitTime) throws Exception {
		
		WebDriverWaits.waitUntilAtLeastOneElementPresent(getLocator(locator), waitTime);
	}
	

	/**
	 * Wait for page title to change as specified
	 * @param Page title
	 * @throws Exception
	 * @author ISharma
	 */
	public static void waitUntilPageTitle(final String title) throws Exception {
		WebDriverWaits.waitUntilPageTitle(title);		
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilPageTitle(final String title, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilPageTitle(title, time);
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @throws Exception
	 */
	public static void waitUntilPageTitleChanges(final String title)
			throws Exception {
		WebDriverWaits.waitUntilPageTitleChanges(title);
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @param time
	 * @throws Exception
	 */	
	public static void waitUntilPageTitleChanges(final String title,
			final int time) throws Exception {
	
		WebDriverWaits.waitUntilPageTitleChanges(title, time);
	}
	
	/**
	 * Wait until specified texts appear
	 * @param text
	 * @throws Exception
	 */	
	public static void waitUntilText(final String... text) throws Exception {
		for (String each : text) {			
			WebDriverWaits.waitUntilText(each);
		}
	}
	
	/**
	 * Wait until specified text appear
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilText(final String text, final int time)
			throws Exception {
			WebDriverWaits.waitUntilText(text, time);
	}
	
	/**
	 * Wait until specified text is not present
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilNotText(final String... text) throws Exception {
		for (String each : text) {
		
			WebDriverWaits.waitUntilNotText(each);
		}
	}
	
	/**
	 * Wait until specified text is not present
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilNotText(final String text, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilNotText(text, time);
	}

	public static void waitUntilAttributeHasValue(final Object locator,
			final String attribute) throws Exception {
		WebDriverWaits.waitUntilAttributeHasValue(
				getLocator(locator), attribute);
	}
	public static void waitUntilAttributeHasValue(final Object locator,
			final String attribute, final int time) throws Exception {
		WebDriverWaits.waitUntilAttributeHasValue(
				getLocator(locator), attribute, time);
	}

	/**
	 * Wait until specified texts are visible
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilTextVisible(each);
		}
	}
	
	/**
	 * Wait until specified partial texts are visible
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilPartialTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilPartialTextVisible(each);
		}
	}


	/**
	 * Wait until specified text is visible
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilTextVisible(final String text, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilTextVisible(text, time);
	}

	public static void waitUntilTextVisible(final String text, final int time, final boolean partialMatch) throws Exception {
		WebDriverWaits.waitUntilTextVisible(text, time, partialMatch);
	}

	/**
	 * Wait until specified texts are not visible
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilNotTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilNotTextVisible(each);
		}
	}

	
	public static void waitUntilNotTextVisible(final String text, final int time)
			throws Exception {
		WebDriverWaits.waitUntilNotTextVisible(text, time);
	}

	public static void waitUntilNotTextVisible(final String text,
			final int time, final boolean partialMatch) throws Exception {
		WebDriverWaits.waitUntilNotTextVisible(text, time, partialMatch);
	}
	
	/* Added for implementing language localization starts*/
	public static void waitUntilText(final Object... locator) throws Exception {
		for (Object each : locator) {
			String str = BrowserAccess.getLocalizationText(each);
			WebDriverWaits.waitUntilText(str);

		}
	}

	public static void waitUntilText(final Object locator, final int time)
			throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilText(str, time);
	}

	public static void waitUntilNotText(final Object... locator)
			throws Exception {
		for (Object each : locator) {
			String str = BrowserAccess.getLocalizationText(each);
			WebDriverWaits.waitUntilNotText(str);

		}
	}

	public static void waitUntilNotText(final Object locator, final int time)
			throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilNotText(str, time);
	}

	public static void waitUntilTextVisible(final Object... locator)
			throws Exception {
		for (Object each : locator) {
			String str = BrowserAccess.getLocalizationText(each);
			WebDriverWaits.waitUntilTextVisible(str);

		}
	}

	public static void waitUntilTextVisible(final Object locator, final int time)
			throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilTextVisible(str, time);
	}

	public static void waitUntilTextVisible(final Object locator,
			final int time, final boolean partialMatch) throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilTextVisible(str, time, partialMatch);
	}

	public static void waitUntilNotTextVisible(final Object... locator)
			throws Exception {
		for (Object each : locator) {
			String str = BrowserAccess.getLocalizationText(each);
			WebDriverWaits.waitUntilNotTextVisible(str);

		}
	}

	public static void waitUntilNotTextVisible(final Object locator,
			final int time) throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilNotTextVisible(str, time);
	}

	public static void waitUntilNotTextVisible(final Object locator,
			final int time, final boolean partialMatch) throws Exception {
		String str = BrowserAccess.getLocalizationText(locator);
		WebDriverWaits.waitUntilNotTextVisible(str, time, partialMatch);
	}
	
	public static void waitForPageToBeLoaded() throws Exception {
		WebDriverWaits.waitForWaitPageToBeLoaded();
	}
	
	public static void waitUntilNewWindowIsLoaded(final List<String> existingWindowHandles) throws Exception {
		WebDriverWaits.waitUntilNewWindowIsLoaded(existingWindowHandles);
	}

	 
}

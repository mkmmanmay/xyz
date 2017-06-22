package  com.guru.framework.testing.browser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.guru.framework.testing.selenium.WebDriverAsserts;



public class BrowserAssert extends BrowserAccess{
	
	/* Added for implementing language localization starts*/
	/**
	 * Asserts that all texts are present on the current page
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllTextPresent(final Object... locator)
			throws Exception {
		ArrayList<String> allText = new ArrayList<String>();
		for (Object each : locator) {
			allText.add (BrowserAccess.getLocalizationText(each));
		}
		assertAllTextPresent(allText);
		allText = null;
	}
	/* Added for implementing language localization ends*/
	

	/**
	 * Asserts that all texts are present on the current page
	 * @param texts
	 * @throws Exception
	 */
	public static void assertAllTextPresent(final String... texts) throws Exception {
		assertAllTextPresent(Arrays.asList(texts));
	}
	
	/**
	 * Asserts that all texts are present on the current page
	 * @param texts
	 * @throws Exception
	 */
	public static void assertAllTextPresent(final Collection<String> texts) throws Exception {
		WebDriverAsserts.assertAllTextPresent(texts);
		
	}

	/**
	 * Asserts that element matching the locator is disabled
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsDisabled(final Object locator) throws Exception {
		WebDriverAsserts.assertAllElementsDisabled(getLocator(locator));
		
	}

	/**
	 * Asserts that element matching the locator is disabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementDisabled(final Object... locators) throws Exception {
		assertElementDisabled(Arrays.asList(locators));
	}
	
	/**
	 * Asserts that all elements matching the locator are disabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementDisabled(final Collection<Object> locators) throws Exception {
		for (Object each : locators){
			WebDriverAsserts.assertElementDisabled(getLocator(each));
			
		}
	}
	
	/**
	 * Asserts that element matching the locator is enabled
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsEnabled(final Object locator) 	throws Exception {
		WebDriverAsserts.assertAllElementsEnabled(getLocator(locator));
		
	}

	/**
	 * Asserts that all elements matching the locator are enabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementEnabled(final Object... locators) throws Exception {
		assertElementEnabled(Arrays.asList(locators));
		
	}
	
	/**
	 * Asserts that all elements matching the locator are enabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementEnabled(final Collection<Object> locators) throws Exception {
		for (Object each : locators){
			WebDriverAsserts.assertElementEnabled(getLocator(each));
			
		}
	}
	
	/**
	 * Asserts that all elements matching the locator are present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsPresent(final Object... locators) 	throws Exception {
		assertElementIsPresent(Arrays.asList(locators));
		
	}
	
	
	/**
	 * Asserts that all elements matching the locator are present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsPresent(final Collection<Object> locators) 	throws Exception {
		for (Object each : locators){
			WebDriverAsserts.assertElementIsPresent(getLocator(each));
			
		}
	}

	/**
	 * Asserts that all elements matching the locator are not present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotPresent(final Object... locators) throws Exception {
		assertElementIsNotPresent(Arrays.asList(locators));
	}
	
	/**
	 * Asserts that all elements matching the locator are not present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotPresent(final Collection<Object> locators) throws Exception {
		for (Object each : locators){
			WebDriverAsserts.assertElementIsNotPresent(getLocator(each));
			
		}
	}
		
	/**
	 * Asserts that all elements matching the locator are displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsDisplayed(final Object... locators)	throws Exception {
		assertElementIsDisplayed(Arrays.asList(locators));
	}
	
	/**
	 * Asserts that all elements matching the locator are displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsDisplayed(final Collection<Object> locators)	throws Exception {
		for (Object each : locators)
		{
			WebDriverAsserts.assertElementIsDisplayed(getLocator(each));
			
		}
	}

	/**
	 * Asserts that all elements matching the locator are not displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotDisplayed(final Object... locators) throws Exception {
		assertElementIsNotDisplayed(Arrays.asList(locators));
	}
	
	/**
	 * Asserts that all elements matching the locator are not displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotDisplayed(final Collection<Object> locators) throws Exception {
		for (Object each : locators){
			WebDriverAsserts.assertElementIsNotDisplayed(getLocator(each));
			
		}
	}

	/**
	 * Asserts that the element matching the locator is displayed
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsDisplayed(final Object locator) throws Exception {
		WebDriverAsserts.assertAllElementsDisplayed(getLocator(locator));
		
	}
	
	/**
	 * Asserts that the element matching the locator is not displayed
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsNotDisplayed(final Object locator) throws Exception {
		WebDriverAsserts.assertAllElementsNotDisplayed(getLocator(locator));
		
	}
	
	/**
	 * Asserts that the element matching the locator is present but not displayed; fails on the first visible element
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsPresentAndNotDisplayed(final Object locator) throws Exception {
		WebDriverAsserts.assertAllElementsPresentAndNotDisplayed(getLocator(locator));
		
	}	


	
	
	
}

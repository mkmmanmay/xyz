package com.guru.framework.testing.selenium;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Contains WebDriver assertions, each of them throws an exception if not true
 * @author Isha Sharma
 *
 */
public class WebDriverAsserts extends WebDriverAccess {
	
	// Asserts that all texts are present on the current page
	public static void assertAllTextPresent(String ... texts) throws Exception {
		assertAllTextPresent(Arrays.asList(texts));
	}
	
	public static void assertAllTextPresent(Collection<String> texts) throws Exception {
		String pageSource = driver.getPageSource();
		for(String each : texts) {
			if(!pageSource.contains(each))
				throw new Exception("Text=" + each + " is not present");
		}			
	}
	
	// Asserts that an element is disabled
	public static void assertElementDisabled(final By locator) throws Exception{
		WebElement element = driver.findElement(locator);		
		if(element == null)
			throw new Exception("Element not found with locator " + locator);
		String disabled = element.getAttribute("disabled");
		String aria = element.getAttribute("aria-disabled");
		if("disabled".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(aria))
			return;
			throw new Exception("Element is not disabled with locator " + locator);
	}
	
	// Asserts that an element is enabled
	public static void assertElementEnabled(final By locator) throws Exception{
		try { 	assertElementDisabled( locator);	}
		catch(Exception e) { return;}
		throw new Exception("Element is not enabled with locator " + locator);
	}
	
	// Asserts that elements are enabled
	public static void assertElementsEnabled(By ... locators) throws Exception {	
		assertElementsEnabled(Arrays.asList(locators));
	}
	
	public static void assertElementsEnabled(Collection<By> locators) throws Exception {	
		for(By each : locators) {
				assertElementEnabled(each);
		}
	}
	
	// Asserts that elements are disabled
	public static void assertElementsDisabled(By ... locators) throws Exception {	
		assertElementsDisabled(Arrays.asList(locators));
	}
	public static void assertElementsDisabled(Collection<By> locators) throws Exception {	
		for(By each : locators) {
				assertElementDisabled(each);
		}
	}
	
	// Asserts that all elements matching the locator are disabled
	public static void assertAllElementsDisabled(final By locator) throws Exception{
		List<WebElement> elements = driver.findElements(locator);
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + locator);
		boolean result = true;		
		for(int i = 0; i < elements.size() && result; i++) {
			String disabled = elements.get(i).getAttribute("disabled");
			String aria = elements.get(i).getAttribute("aria-disabled");
			if("disabled".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(aria))
				continue;
			result = false;
		}
		if(!result)
			throw new Exception("Not all elements are disabled with locator " + locator);
	}

	// Asserts that all elements matching the locator are enabled
	public static void assertAllElementsEnabled(final By locator) throws Exception{
		List<WebElement> elements = driver.findElements(locator);
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + locator);
		boolean result = true;		
		for(int i = 0; i < elements.size() && result; i++) {
			String disabled = elements.get(i).getAttribute("disabled");
			String aria = elements.get(i).getAttribute("aria-disabled");
			if(isEmpty(disabled) && isEmpty(aria))
				continue;
			if("enabled".equalsIgnoreCase(disabled) || "false".equalsIgnoreCase(disabled) || "false".equalsIgnoreCase(aria))
				continue;
			result = false;
		}
		if(!result)
			throw new Exception("Not all elements are enabled with locator " + locator);
	}
	
	// Asserts that elements are not present
	public static void assertElementIsNotPresent(final By locator) throws Exception {
		int size =0;
		try { size = driver.findElements(locator).size();	}
		catch(Exception e) { 	}		
		if(size > 0)
			throw new Exception ("Unexpectedly found an element: " + locator);
	}

	// Asserts that elements are not present
	public static void assertElementIsPresent(final By locator) throws Exception {
			int size = driver.findElements(locator).size();
			if(size == 0)
				throw new Exception ("Did not find an element: " + locator);
		}
	
	
	// Asserts that ALL elements are displayed, fails on the first hidden element
	public static void assertAllElementsDisplayed(final By locator) throws Exception {
		List<WebElement> elements = driver.findElements(locator);
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + locator);
		for(int i = 0; i < elements.size(); i++) {
			if(!elements.get(i).isDisplayed()) {
				throw new Exception("Element is not displayed with locator=" + locator + ", index=" + i);
			}
		}		
	}
	
	// Asserts that ALL elements are not displayed (or not present), fails on the first visible element
	public static void assertAllElementsNotDisplayed(final By locator) throws Exception {
		List<WebElement> elements = driver.findElements(locator);
		if(elements == null || elements.size() == 0)
			return;
		for(int i = 0; i < elements.size(); i++) {
			if(elements.get(i).isDisplayed()) {
				throw new Exception("Element is displayed with locator=" + locator + ", index=" + i);
			}
		}	
	}
	
	// Asserts that ALL elements are present and not displayed, fails on the first visible element
		public static void assertAllElementsPresentAndNotDisplayed(final By locator) throws Exception {
			List<WebElement> elements = driver.findElements(locator);
			if(elements == null || elements.size() == 0)
				throw new Exception("Elements not found with locator " + locator);
			for(int i = 0; i < elements.size(); i++) {
				if(elements.get(i).isDisplayed()) {
					throw new Exception("Element is displayed with locator=" + locator + ", index=" + i);
				}
			}	
		}
		
	/**
	 * 
	 * @param locator
	 * @throws Exception If element is not present or is not displayed
	 */

	public static void assertElementIsNotVisible(final By locator) throws Exception {
		try {
			assertElementIsPresent(locator);				
		}
		catch(Exception e) { return;}
		if(driver.findElement(locator).getAttribute("style").toLowerCase().contains("display: none"))	
			return;
		throw new Exception("The element is visible");
	}
	public static void assertElementIsDisplayed(final By locator) throws Exception{
		WebElement element = driver.findElement(locator);	
		if(!element.isDisplayed())
			throw new Exception("Did not display Search Toolbar");	
	}
	
	public static void assertElementIsDisplayed(WebElement element) throws Exception{
		if(!element.isDisplayed())
			throw new Exception("Did not display Search Toolbar");	
	}
	public static void assertElementIsNotDisplayed(final By locator) throws Exception{
		WebElement element = driver.findElement(locator);	
		if(element.isDisplayed())
			throw new Exception("Did not hide Search Toolbar");	
	}
	public static void assertElementIsNotDisplayed(WebElement element) throws Exception{
		if(element.isDisplayed())
			throw new Exception("Did not display Search Toolbar");	
	}
	
	
	public static void assertElementIsSelected(final By locator) throws Exception{		
		assertElementIsSelected(driver.findElement(locator));
	}
	
	public static void assertElementIsSelected(WebElement element) throws Exception {
		if(!element.isSelected())
			throw new Exception("Element is not selected");
	}
	
	public static void assertElementIsNotSelected(final By locator) throws Exception{		
		assertElementIsNotSelected(driver.findElement(locator));
	}
	
	public static void assertElementIsNotSelected(WebElement element) throws Exception {
		if(element.isSelected())
			throw new Exception("Element is selected");
	}
	
	// Asserts that ALL elements are selected, fails on the first selected element
		public static void assertAllElementsSelected(final By locator) throws Exception {
			List<WebElement> elements = driver.findElements(locator);
			if(elements == null || elements.size() == 0)
				throw new Exception("Elements not found with locator " + locator);
			for(int i = 0; i < elements.size(); i++) {
				if(!elements.get(i).isSelected()) {
					throw new Exception("Element is not selected with locator=" + locator + ", index=" + i);
				}
			}		
		}
		
		// Asserts that all elements are not selected (or not present), fails on the first selected element
		public static void assertAllElementsNotSelected(final By locator) throws Exception {
			List<WebElement> elements = driver.findElements(locator);
			if(elements == null || elements.size() == 0)
				return;
			for(int i = 0; i < elements.size(); i++) {
				if(elements.get(i).isSelected()) {
					throw new Exception("Element is selected with locator=" + locator + ", index=" + i);
				}
			}	
		}
	
	
	public static boolean isEmpty(String input) {
		return input == null || input.trim().length()== 0;
	}
	
	
}

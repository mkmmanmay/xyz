package com.guru.framework.testing.selenium;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.guru.framework.testing.utils.objects.StringUtils;



public class WebDriverAccess extends BaseWebDriver {
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Class<?> getObjectMapClass()  {
		return objectMapClass;
	}	
	
	/* Added for implementing language localization */
	public static Class<?> getLocalizationClass() {
		return localizationClass;
	}
	
	public static WebElement getElement(final By locator) throws Exception {
		return driver.findElement(locator);
	}	
	
	public static List<WebElement> getElements(final By locator) throws Exception {
		return driver.findElements(locator);
	}
	
	public static String getElementInnerHtml(final By locator)  throws Exception {
		return getElementInnerHtml(driver.findElement(locator)); 
	}
	
	public static String getElementInnerHtml(final WebElement el)  throws Exception {
		return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", el);
	}
	
	public static String getElementAttributeValue(By locator, String attribute) throws Exception {
		 return driver.findElement(locator).getAttribute(attribute);
	}
	
	public static String getElementText(final By locator, boolean... js)  throws Exception {
		return getElementText(driver.findElement(locator), js); 
	}
	
	public static String getElementText(final WebElement el, boolean... js)  throws Exception {
		if(js.length == 0 || js[0]) {	// default is JavaScript
			if(browser.equalsIgnoreCase("ie"))
				return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerText;", el);
			else
				return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].textContent;", el);
		}
		return el.getText();
	}
	
	public static List<String> getElementsText(By locator, boolean... js)  throws Exception {
		return getElementsText(driver.findElements(locator), js); 
	}	
	
	public static List<String> getElementsText(List<WebElement> elements, boolean... js) throws Exception {
		List<String> result = new ArrayList<String>();
		for(WebElement each : elements)
			result.add(getElementText(each, js).trim());
		return result;
	}
	
	public static String getPageTitle() throws Exception {
		return driver.getTitle();
	}
	
	public static String getWindowHandle() throws Exception {
		return driver.getWindowHandle();
	}
	
	public static Set<String> getWindowHandles() throws Exception {
		return driver.getWindowHandles();
	}
	
	
	/**
	 * Gets all options for a dropdown menu.
	 * @param locator locator for the dropdown menu.
	 * @return void
	 */
	public static List<WebElement> getDropDownOptions(By locator) {
		Select select = new Select(driver.findElement(locator));
		return select.getOptions();
	}
	
	
	
	public static String removeAttribute(final By locator, String...js)  throws Exception {
		return removeAttribute(driver.findElement(locator)); 
	}
	/**
	 * Remove an attribute
	 * @param Web element, Attribute, Value
	 * @return void
	 */
	public static String removeAttribute(final WebElement el,String...js) {
		return (String)((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('"+js[0]+"','"+js[1]+"')", el);
		
		
	}
	


}

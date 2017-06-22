package com.guru.framework.testing.selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverWaits extends WebDriverAccess {

/*********************** Wait until elements are displayed **********************/
	public static void waitUntilElementIsDisplayed(final By... locator) {
		for(By each: locator)
			waitUntilElementIsDisplayed(each, waitTime);
	}

	public static void waitUntilElementIsDisplayed(final WebElement... elements) {
		for(WebElement each : elements)
			waitUntilElementIsDisplayed(each, waitTime);
	}
	
	public static void waitUntilElementIsDisplayed(final By locator, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					WebElement element = d.findElement(locator);
					return Boolean.valueOf(element != null	&& element.isDisplayed());
				} catch (Exception e) {		return Boolean.valueOf(false); 	}
			}
		});
	}
		
	public static void waitUntilElementIsDisplayed(final WebElement element, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf(null != element && element.isDisplayed());
			}			
		});
	}
		
	/*********************** Wait until elements are not displayed **********************/
	
	public static void waitUntilElementIsNotDisplayed(final By... locator) {
		for(By each: locator)
			waitUntilElementIsNotDisplayed(each, waitTime);
	}
	
	public static void waitUntilElementIsNotDisplayed(final WebElement... element) {
		for(WebElement each: element)
			waitUntilElementIsNotDisplayed(each, waitTime);
	}
	
	public static void waitUntilElementIsNotDisplayed(final By locator, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					WebElement element = d.findElement(locator);
					return Boolean.valueOf( null == element || !element.isDisplayed());
				} catch (Exception e) { return Boolean.valueOf(true);		}
			}
		});
	}

	public static void waitUntilElementIsNotDisplayed(final WebElement element, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return Boolean.valueOf( null == element 	|| !element.isDisplayed());
			}			
		});
	}
		
	/*********************** Wait until at least that many elements are present **********************/
	
	
	public static void waitUntilAtLeastCountOfElementsPresent(final By locator, int count) {
		waitUntilAtLeastCountOfElementsPresent(locator, count, waitTime);
	}
	
	public static void waitUntilAtLeastCountOfElementsPresent(final By locator, final int count, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					List<WebElement> elements = d.findElements(locator);
					return Boolean.valueOf(elements.size() >= count);
				} catch (Exception e) {	 return Boolean.valueOf(false);	}				
			}
		});
	}
	
/*********************** Wait until at most that many elements are present **********************/
	
	
	public static void waitUntilAtMostCountOfElementsPresent(final By locator, int count) {
		waitUntilAtMostCountOfElementsPresent(locator, count, waitTime);
	}
	
	public static void waitUntilAtMostCountOfElementsPresent(final By locator, final int count, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					List<WebElement> elements = d.findElements(locator);
					return Boolean.valueOf(elements.size() <= count);
				} catch (Exception e) {	 return Boolean.valueOf(false);	}				
			}
		});
	}
	
	
/*********************** Wait until exactly that many elements are present **********************/
	
	
	public static void waitUntilCountOfElementsPresent(final By locator, int count) {
		waitUntilCountOfElementsPresent(locator, count, waitTime);
	}
	
	public static void waitUntilCountOfElementsPresent(final By locator, final int count, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					List<WebElement> elements = d.findElements(locator);
					return Boolean.valueOf(elements.size() == count);
				} catch (Exception e) {	 return Boolean.valueOf(false);	}				
			}
		});
	}
	
	
	/*********************** Wait until more than one element are present **********************/
	public static void waitUntilMoreThanOneElementPresent(final By... locator) {
		for(By each: locator)
			waitUntilMoreThanOneElementPresent(each, waitTime);
	}

	public static void waitUntilMoreThanOneElementPresent(final By locator,	int time) {
		waitUntilAtLeastCountOfElementsPresent(locator, 2, time);
	}

	/*********************** Wait until at least one element are present **********************/
	public static void waitUntilAtLeastOneElementPresent(final By... locator) {
		for(By each: locator)
			waitUntilAtLeastOneElementPresent(each, waitTime);
	}

	public static void waitUntilAtLeastOneElementPresent(final By locator,	int time) {
		waitUntilAtLeastCountOfElementsPresent(locator, 1, time);
	}
	
	
	/*********************** Wait until specified page title **********************/
	
	public static void waitUntilPageTitle(final String title) {
		waitUntilPageTitle(title, waitTime);
	}

	public static void waitUntilPageTitle(final String title, int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(d.getTitle().trim().equals(title)); }
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	
	/*********************** Wait until specified page title changes**********************/	

	public static void waitUntilPageTitleChanges(final String title) {
		waitUntilPageTitleChanges(title, waitTime);
	}

	public static void waitUntilPageTitleChanges(final String title, int time)	{
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {				
				try {	return Boolean.valueOf(!d.getTitle().trim().equals(title)); }
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	 
	
	/*********************** Wait until specified text is present **********************/	
	
	public static void waitUntilText(final String... text)  {
		for(String each: text)
			waitUntilText(each, waitTime);
	}

	public static void waitUntilText(final String text,	int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(d.getPageSource().contains(text)); }
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	
	/*********************** Wait until specified text is not present **********************/	
	
	public static void waitUntilNotText(final String... text) throws Exception {
		for(String each: text)
			waitUntilNotText(each, waitTime);
	}

	public static void waitUntilNotText(final String text,	int time) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(!d.getPageSource().contains(text)); }
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	
	/*********************** Wait until an attribute has a value**********************/	
	
	public static void waitUntilAttributeHasValue(final By locator, final String attribute) {
		waitUntilAttributeHasValue(locator, attribute, waitTime);
	}

	public static void waitUntilAttributeHasValue(final By locator, final String attribute, int time) { 	
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(d.findElement(locator).getAttribute(attribute).length() > 0);
				} catch (Exception e) {		return Boolean.valueOf(false);	}
			}
		});
	}
	
	public static void waitUntilAttributeHasValue(final WebElement element, final String attribute) {
		waitUntilAttributeHasValue(element, attribute, waitTime);
	}
	
	public static void waitUntilAttributeHasValue(final WebElement element, final String attribute, int time) { 	
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(element.getAttribute(attribute).length() > 0);
				} catch (Exception e) {		return Boolean.valueOf(false);	}
			}
		});
	}
	
/*********************** Wait until an attribute contains a value**********************/	
	
	public static void waitUntilAttributeContainsValue(final By locator, final String attribute, final String value) {
		waitUntilAttributeContainsValue(locator, attribute, value, waitTime);
	}

	public static void waitUntilAttributeContainsValue(final By locator, final String attribute, final String value, int time) { 	
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	
					String attributeValue = d.findElement(locator).getAttribute(attribute);
					return Boolean.valueOf(attributeValue.contains(value));
				} catch (Exception e) {		return Boolean.valueOf(false);	}
			}
		});
	}
	
	public static void waitUntilAttributeContainsValue(final WebElement element, final String attribute, final String value) {
		waitUntilAttributeContainsValue(element, attribute, value, waitTime);
	}
	
	public static void waitUntilAttributeContainsValue(final WebElement element, final String attribute, final String value,  int time) { 	
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	
					String attributeValue = element.getAttribute(attribute);
					return Boolean.valueOf(attributeValue.contains(value));
				} catch (Exception e) {		return Boolean.valueOf(false);	}
			}
		});
	}
	
/*********************** Wait until an element matches text**********************/	
	
	public static void waitUntilElementTextMatches(final By locator, String regex) {
		waitUntilElementTextMatches(locator, regex, waitTime);
	}

	public static void waitUntilElementTextMatches(final By locator, String regex, int time) { 	
		waitUntilElementTextMatches(driver.findElement(locator), regex, waitTime);
	}
	
	public static void waitUntilElementTextMatches(final WebElement element, String regex) {
		waitUntilElementTextMatches(element, regex, waitTime);
	}
	
	public static void waitUntilElementTextMatches(final WebElement element, final String text, int time) { 
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {	return Boolean.valueOf(element.getText().matches(text));
				} catch (Exception e) {		return Boolean.valueOf(false);	}
			}
		});
	}
	
	
	

    /*********************** Wait until specified text is SHOWN **********************/	
	
	public static void waitUntilTextVisible(final String... text)  {
		for(String each: text)
			waitUntilTextVisible(each, waitTime);
	}

	public static void waitUntilTextVisible(final String text,	int time) {
		waitUntilTextVisible(text, time, false);
	}
	
	public static void waitUntilTextVisible(final String text,	final int time, final boolean partialMatch) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try 
				{
					//WebElement element = d.findElement(By.xpath("//*[text()=\"" + text + "\"]"));
					List<WebElement> elements = null;
					if (partialMatch == true)
					{
						elements = d.findElements(By.xpath("//*[contains(text()=\"" + text + "\")]"));						                          
					}
					else 
					{
						elements = d.findElements(By.xpath("//*[text()=\"" + text + "\"]"));	
					}
					
					if (elements.size() == 0 )
					{
						return false;
					}
					for(int i=0 ; i<elements.size();i++)
					{
						 if (elements.get(i).isDisplayed())
						 {
							 return true;
						 }
					}
					return false;
				}
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	/*********************** Wait until specified text is not SHOWN **********************/	
	
	public static void waitUntilNotTextVisible(final String... text) throws Exception {
		for(String each: text)
			waitUntilNotTextVisible(each, waitTime);
	}

	public static void waitUntilNotTextVisible(final String text,	int time) {
		waitUntilNotTextVisible(text, time, false);
	}
	
	public static void waitUntilNotTextVisible(final String text,	final int time, final boolean partialMatch) {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try 
				{
					WebElement element = null;
					if (partialMatch == true)
					{
						element = d.findElement(By.xpath("//*[contains(text()=\"" + text + "\")]"));	
					}
					else
					{
						element = d.findElement(By.xpath("//*[text()=\"" + text + "\"]"));
					}
					
					return Boolean.valueOf(element == null	|| !element.isDisplayed());
				}
				catch(Exception e) { return Boolean.valueOf(false); }
			}
		});
	}
	
	public static void waitUntilNewWindowIsLoaded(final List<String> existingWindowHandles){
		
		(new WebDriverWait(driver,waitTime)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {       
				   Set<String> windowHandles=d.getWindowHandles();
				   windowHandles.removeAll(existingWindowHandles);
				   return windowHandles.iterator().hasNext();
			}
		});
		
	}
	
	public static void waitForWaitPageToBeLoaded() {
		new WebDriverWait(WebDriverAction.getDriver(), waitTime).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try{
					JavascriptExecutor jse=(JavascriptExecutor)WebDriverAction.getDriver();
					String documentState=((String)jse.executeScript("return document.readyState"));
					System.out.println(documentState);
					return documentState.equalsIgnoreCase("complete");
				}catch(Exception e){
					return Boolean.valueOf(false);
				}
				
			}
		});
	}
	
	public static void waitForAlertBox() {
		new WebDriverWait(WebDriverAction.getDriver(),waitTime).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try{
					d.switchTo().alert();
				    return Boolean.valueOf(true);
				}
				catch(Exception e){return Boolean.valueOf(false);}
			}
		});
	}
	
	public static void waitUntilAlertBoxIsClosed() {
		new WebDriverWait(WebDriverAction.getDriver(),waitTime).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try{
					d.switchTo().alert();
				    return Boolean.valueOf(false);
				}
				catch(Exception e){return Boolean.valueOf(true);}
			}
		});
	}
	
	public static void waitForElementToBeUsed(final By locator) {
		(new WebDriverWait(driver, waitTime)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					WebElement element = d.findElement(locator);
					element.getText();
					return Boolean.valueOf(true);
				} catch (Exception e) {	return Boolean.valueOf(false); 	}
			}
		});
	}

	public static void waitUntilPartialTextVisible(final String... text) {
		for (String each : text) {
			waitUntilPartialTextVisible(each, waitTime);
		}
	}

	public static void waitUntilPartialTextVisible(final String text, final int time) {
		waitUntilTextVisible(text, time, true);
	}

}

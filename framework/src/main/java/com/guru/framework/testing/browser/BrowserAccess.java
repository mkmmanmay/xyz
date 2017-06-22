package  com.guru.framework.testing.browser;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ResolveLocatorException;
import com.guru.framework.testing.selenium.WebDriverAccess;
import com.guru.framework.testing.selenium.WebDriverAction;



public class BrowserAccess {
		
	public static WebElement getElement(final Object locator) throws Exception {
		return WebDriverAccess.getElement(getLocator(locator));
	}

	public static List<WebElement> getElements(final Object locator)
			throws Exception {
		return WebDriverAccess.getElements(getLocator(locator));
	}

	public static String getElementInnerHtml(final Object locator)
			throws Exception {
		return WebDriverAccess.getElementInnerHtml(getLocator(locator));
	}

	public static String getElementAttributeValue(final Object locator,
			final String attribute) throws Exception {
		return WebDriverAccess.getElement(getLocator(locator)).getAttribute(
				attribute);
	}

	public static String getElementText(final Object locator,
			final boolean... js) throws Exception {
		return WebDriverAccess.getElementText(getLocator(locator), js);
	}

	public static List<String> getElementsText(final Object locator,
			final boolean... js) throws Exception {
		return WebDriverAccess.getElementsText(getLocator(locator), js);
	}
		
	public static String getPageTitle()  throws Exception {
		return WebDriverAccess.getPageTitle();
	}
	
	public static String getWindowHandle()  throws Exception {
		return WebDriverAccess.getWindowHandle();
	}
	
	public static Set<String> getWindowHandles()  throws Exception {
		return WebDriverAccess.getWindowHandles();
	}
	
	/**
	 * Resolve the enum and returns the text message 
	 * @param elementName
	 * @return
	 * @throws Exception
	 * @author ISharma
	 */
	/* Added for implementing language localization */
	public static String getLocalizationText(final Object elementName) throws Exception {
		
		final Field field = WebDriverAccess.getLocalizationClass().getField(
				elementName.toString());
		final Class<?> clazz = field.getClass();
		final String str = field.get(clazz).toString();
		return str;
	
	}
	
	
	
	/**
	 * Resolves the element name (Enum) to By type
	 * @author ISharma
	 * @param elementName
	 * @throws Exception
	 * @return By
	 */
	public static By getLocator(final Object elementName) throws Exception {
		if (elementName instanceof Enum) {
			return getLocator(((Enum<?>) elementName).name(), elementName.toString());
		} else {
			final Field field = WebDriverAccess.getObjectMapClass().getField(elementName.toString());
			final Class<?> clazz = field.getClass();
			final String str = field.get(clazz).toString();

			return getLocator(elementName.toString(), str);
		}
	}

	/**
	 * Resolves the Enum to convert it to Selenium's native By type
	 * @author ISharma
	 * @param elementName
	 *            Enum name, For ex: GOOGLE_SEARCH_ID
	 * @param elementValue
	 *            Enum value, For ex: gsearch
	 * 
	 * @throws ResolveLocatorException
	 *             Throws exception if the Enum name does not end with any of
	 *             the predefined method locator type
	 * @return By            
	 */
	public static By getLocator(final String elementName, final String elementValue) throws Exception {
		if (elementName.endsWith("_ID")) {
			return By.id(elementValue);
		} else if (elementName.endsWith("_NAME")) {
			return By.name(elementValue);
		} else if (elementName.endsWith("_CLASS")) {
			return By.className(elementValue);
		} else if (elementName.endsWith("_CSS")) {
			return By.cssSelector(elementValue);
		} else if (elementName.endsWith("_LINK")) {
			return By.linkText(elementValue);
		} else if (elementName.endsWith("_PLINK")) {
			return By.partialLinkText(elementValue);
		} else if (elementName.endsWith("_TAG")) {
			return By.tagName(elementValue);
		} else if (elementName.endsWith("_XPATH")) {
			return By.xpath(elementValue);
		}
		throw new ResolveLocatorException("Unable to handle the locator type: " + elementName+ ". Locator name should end with _ID/_NAME/" + "_CLASS/_CSS/_LINK/_PLINK/_TAG/_XPATH");
	}

	/*
	 * Using property file
	 * 
	 * public static By getLocator(String elementName) throws Exception {
	 * 
	 * return ObjectMapHelperTemp.getLocator(elementName);
	 * 
	 * }
	 
		
	public static By getLocator(final Class<?> iface, String elementName) throws Exception {
		
		Field field = iface.getField(elementName);
		Class<?> clazz = field.getClass();
		String str = field.get(clazz).toString();
		
		if(elementName.endsWith("_ID"))						return By.id(str);
		else if(elementName.endsWith("_NAME"))		return By.name(str);
		else if(elementName.endsWith("_CLASS"))		return By.className(str);
		else if(elementName.endsWith("_CSS"))			return By.cssSelector(str);
		else if(elementName.endsWith("_LINK"))			return By.linkText(str);
		else if(elementName.endsWith("_PLINK"))		return By.partialLinkText(str);
		else if(elementName.endsWith("_TAG"))			return By.tagName(str);
		else if(elementName.endsWith("_XPATH"))		return By.xpath(str);
		throw new Exception ("Element locator label =" + elementName);			
	}*/
	

	/**
	 * Scroll the page to specified offset
	 * 
	 * @param attribute
	 *            
	 * @param value
	 * @return 
	 *           
	 * @throws Exception
	 */
	public static String removeAttribute(final Object locator,final String attribute, final String value) throws Exception {
		return WebDriverAccess.removeAttribute(getLocator(locator), attribute, value);
	}
}

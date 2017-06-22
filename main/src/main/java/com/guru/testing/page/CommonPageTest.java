package com.guru.testing.page;

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
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.CommonObjectMap;

public class CommonPageTest {
	
	public static int loginType;
	@Test
	@Documentation(step = "Close current tab.", expected = "Able to close current tab.")
	public static void closeCurrentWindow() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.closeActiveWindow();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Switch handle to new tab", expected = "Able to switch to new handle.")
	public static void switchToNewTabTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToNewTab();
		} catch (Exception e) {
			throw new ScriptException("Wasn't able to switch to new tab.");
		}
	}
	
	@Test
	@Parameters("title")
	@Documentation(step = "Switch handle to new tab", expected = "Able to switch to new handle.")
	public static void switchToPageByTitleTest(String title) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToPageByTitle(title);
		} catch (Exception e) {
			throw new ScriptException("Wasn't able to switch to page with title: " +title);
		}
	}
	
	@Test
	@Parameters("environment")
	@Documentation(step = "Launch Admin site.", expected = "Able to launch.")
	public static void launchAdminSiteTest(String env) throws Exception {
		ScriptLogger.info();
		try {
			if(env.equalsIgnoreCase("qa")) {
				BrowserAction.openBrowser("https://qa-admin.guru.com/admin");
			} else if (env.equalsIgnoreCase("live")) {
				BrowserAction.openBrowser("https://admin.guru.com/admin");
			} else if (env.equalsIgnoreCase("qa2")) {
				BrowserAction.openBrowser("https://qa2.guru.com/admin");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public static Float getAmount(WebElement element,String endString) throws Exception {
		ScriptLogger.info();
		try {
			String text=element.getText().trim();
			return(Float.parseFloat((StringUtils.stringBetween(text,"$",endString,1).replace(",", ""))));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}

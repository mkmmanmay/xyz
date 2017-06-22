package com.guru.testing.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.helpers.ObjectMapHelper;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.selenium.BaseWebDriver;
import com.guru.framework.testing.testng.Documentation;

public class LaunchApplication extends BaseWebDriver {

	@BeforeClass
	@Documentation(step = "Load object maps", expected = "Object map configuration should be loaded")
	public static void loadObjectMaps() throws Exception {
		ScriptLogger.info();
		ObjectMapHelper.loadObjectMaps();

	}

	@Test
	@Parameters("url")
	@Documentation(step = "Launch application url in browser", expected = "Browser should be launched with the given url")
	public static void navigateToUrlTest(String url) throws Exception {
	//	ObjectMapHelper.loadObjectMaps();
		BrowserAction.openBrowser(url);
		ScriptLogger.info("Navigating to: " + url);
		BrowserWait.waitForPageToBeLoaded();
	}

}

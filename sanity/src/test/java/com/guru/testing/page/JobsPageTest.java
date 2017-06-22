package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.DashboardPageObjectMap;
import com.guru.testing.objectmap.JobsPageObjectMap;

public class JobsPageTest {
	
	@Test
	@Documentation(step = "Verify if 'Jobs' page loaded.", expected = "'Jobs' page for the FL should load.")
	public static void verifyJobsPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Manage Jobs - Guru");
			BrowserWait.waitUntilText("Jobs", 30);
			BrowserWait.waitUntilElementIsDisplayed(JobsPageObjectMap.JOBS_PAGE_RESULTS_CONTROL_TAB_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Parameters("jobName")
	@Documentation(step = "Click on the job in the Jobs page by Job name" , expected = "Able to click.")
	public static void clickJobByNameTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> jobList = BrowserAction.getElements(JobsPageObjectMap.JOBS_PAGE_JOB_NAME_XPATH);
			for(WebElement el : jobList) {
				String jobName = el.getText();
				if(jobName.equalsIgnoreCase(name)) {
					WebDriverAction.click(el);
					break;
				} else {
					ScriptLogger.debug("No job name by the given parameter was found.");
				}
			}
		}  catch (Exception e) {
			throw new ScriptException("Unable to click; possible error in Script logic itself.");
		}
	}
}

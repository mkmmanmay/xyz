package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.objectmap.SwitchBoardPageObjectMap;

public class SwitchBoardPageTest {
	 
	@Test
	@Documentation(step = "Verify the page opened when clicking on 'Add a manager' in employer's workroom.", expected = "Able to verify.")
	public static void verifySwitchBoardPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilPageTitle("Switch Accounts - Guru");
			BrowserWait.waitUntilText("I want to use Guru as…" , 30);
			BrowserWait.waitUntilElementIsDisplayed(SwitchBoardPageObjectMap.SWITCHBOARD_PAGE_OWNER_TILE_CLASS_XPATH);
			try {
				BrowserWait.waitUntilElementIsDisplayed(SwitchBoardPageObjectMap.SWITCHBOARD_PAGE_MEMBER_TILE_CLASS_XPATH);
			} catch (Exception e) {
				ScriptLogger.debug("No roles except owner in the switchboard.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One of more element necessary for page verification didn't appear.")	;	
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Manager' role tile.", expected = "Able to click.")
	public static void clickFirstManagerRoleTileTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> roles = BrowserAction.getElements(SwitchBoardPageObjectMap.SWITCHBOARD_PAGE_MEMBER_TILE_ROLE_TEXT_XPATH);
			for (int i = 0; i < roles.size(); i++) {
				if(roles.get(i).getText().equals("Manager")) {
					roles.get(i).click();
				}
			}
		} catch (Exception e) {
			throw new ScriptException("Possible selenium was unable to click, maybe due to locator issue or script logic issue, or there was no such role.");	
		}
	}
}

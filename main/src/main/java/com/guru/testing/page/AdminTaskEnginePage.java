package com.guru.testing.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.testing.objectmap.AdminTaskEnginePageObjectMap;

public class AdminTaskEnginePage {
	
	public static void verifyAdminTaskEnginePage() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Task Manager Monitor","Task Engines");
			BrowserWait.waitUntilElementIsDisplayed(AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_ADMIN_MENU_PLINK);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Admin Task Engine page is not loaded");
		}
	}
	
	
	public static void startAndPollTaskById(String taskId) throws Exception {
		ScriptLogger.info();
		BrowserAction.switchToDefaultContent();
		switch(taskId){
		case "56": startAndPollTask("56",AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_56_XPATH,AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_56_IN_PROGRESS_XPATH);
		break;
		case "40": startAndPollTask("40",AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_40_XPATH,AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_40_IN_PROGRESS_XPATH);
			break;
		case "36": startAndPollTask("36",AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_36_XPATH,AdminTaskEnginePageObjectMap.ADMIN_TASK_ENGINE_PAGE_TASK_36_IN_PROGRESS_XPATH);
		break;
		default: break;
		
		}
	}
	
	public static void startAndPollTask(String taskId,AdminTaskEnginePageObjectMap startLocator,AdminTaskEnginePageObjectMap inProgressLocator ) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.scrollWindow(500,4000);
			BrowserAction.click(startLocator);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Admin Task Engine page is not loaded");
		}
		acceptTaskAlert(taskId);
		BrowserAction.refresh();
		try{
			BrowserWait.waitUntilElementIsDisplayed(inProgressLocator);
		}catch (Exception e) {
			BrowserAction.refresh();
		}
		pollTaskTillComplete(taskId,startLocator,inProgressLocator);
	}
	
	
	private static void pollTaskTillComplete(String string, AdminTaskEnginePageObjectMap adminTaskLocator,AdminTaskEnginePageObjectMap inProgressLocator) throws Exception{
		ScriptLogger.info();
		try {
			while(BrowserAction.getElement(inProgressLocator)!=null){
				Thread.sleep(5000);
				BrowserAction.refresh();
			}		
			
		} catch (NoSuchElementException  e) {
			BrowserAction.getElement(adminTaskLocator);
		}
		
	}

	public static void acceptTaskAlert(String taskId) throws Exception {
		ScriptLogger.info();
		Thread.sleep(5000);
			Alert alert=BrowserAction.switchToAlertBox();
				if(!alert.getText().contains("Task "+ taskId +" scheduled to start.")){
					throw new ApplicationException("Alert is not present");
				}
				else{
					alert.accept();
				}
	}
	
	

}

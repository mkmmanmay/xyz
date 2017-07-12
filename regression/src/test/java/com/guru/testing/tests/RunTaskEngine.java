package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminHomePageTest;
import com.guru.testing.page.AdminTaskEnginePage;


public class RunTaskEngine {
	
	
	@Test(alwaysRun=true )
	@Documentation(step="",expected="")
	public static void clickTaskManagerMonitorTest() throws Exception {
		AdminHomePageTest.clickTaskManagerMonitor();
		AdminTaskEnginePage.verifyAdminTaskEnginePage();		
	}
	

	
	@Test(dependsOnMethods="clickTaskManagerMonitorTest")
	@Parameters("taskId")
	@Documentation(step="",expected="")
	public static void runTaskAndPollTillFinishedTest(String taskId) throws Exception {
		AdminTaskEnginePage.startAndPollTaskById(taskId);		
	}
	
	
	
	
	

}

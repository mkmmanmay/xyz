package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.testing.page.WorkroomPageTest;

public class CreateTask {
	
	@Test(alwaysRun = true)
	public static void goToTaskTabTest() throws Exception {
		WorkroomPageTest.clickTasksTabTest();
		WorkroomPageTest.verifyTasksPageTest();

	}
	
	@Test(dependsOnMethods = "goToTaskTabTest" )
	public static void clickCreateTaskTest() throws Exception {
		WorkroomPageTest.clickCreateTaskTest();
		
	}
	
	@Test(dependsOnMethods = "clickCreateTaskTest" )
	public static void goToAccountTest() throws Exception {
		WorkroomPageTest.clickNewTaskBtnTest();
		WorkroomPageTest.verifyCreateTaskWindowTest();

	}
	
	@Test(dependsOnMethods = "goToAccountTest" )
	@Parameters({"taskName","taskDescription"})
	public static void enterTaskDetailsTest(String taskName, String taskDescription) throws Exception {
		WorkroomPageTest.enterTaskNameTest(taskName);
		WorkroomPageTest.enterTaskDescriptionTest(taskDescription);
		WorkroomPageTest.clickAssignToMeTest();
		
	}
	
	
	@Test(dependsOnMethods = "enterTaskDetailsTest" )
	public static void createTaskTest() throws Exception {
		WorkroomPageTest.clickCreateTaskTest();
		WorkroomPageTest.verifyTaskCreatedTest();
	}
	
	
}

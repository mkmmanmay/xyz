package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.DashboardPageTest;
import com.guru.testing.page.WorkroomPageTest;

public class OpenEmpWorkroomByIndex {
	
	@Test(alwaysRun = true)
	@Documentation(step = "Open Employer workroom of a job by index", expected = "Verify Status Update page is loaded for Employer")
	@Parameters("jobIndex")
	public static void openWorkroomTest(int jobIndex) throws Exception {
		DashboardPageTest.clickEMPWorkroomByIndex(jobIndex);
		WorkroomPageTest.verifyEMPStatusUpdatesTabTest();

	}

}

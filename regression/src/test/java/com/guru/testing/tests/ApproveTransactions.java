package com.guru.testing.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.testing.page.AdminApprovePaymentsPage;
import com.guru.testing.page.AdminHomePageTest;

public class ApproveTransactions {
	
	@Test(alwaysRun=true )
	@Documentation(step="Click Accept/Approve Payments link on admion homepage",expected="Link should be clicked")
	public static void clickAcceptApprovePaymentsTest() throws Exception {
		AdminHomePageTest.clickAcceptApprovePaymentsTest();
		AdminApprovePaymentsPage.verifyAdminApprovePaymentsPage();
	}
	
	@Test(dependsOnMethods = "clickAcceptApprovePaymentsTest")
	@Documentation(step="Click tab on manage transactions pages",expected="Tab should be clicked")
	@Parameters("tabName")
	public static void clickTabTest(String tabName) throws Exception {
		AdminApprovePaymentsPage.clickTab(tabName);
	}
	
	@Test(dependsOnMethods = "clickTabTest")
	@Documentation(step="Selected drop down options of type",expected="Type should be selected ")
	@Parameters({"type","paymentType"})
	public static void selectTypeTest(String type,String paymentType) throws Exception {
		AdminApprovePaymentsPage.selectType(type);
		if(type.equals("COMPLETED")){
			AdminApprovePaymentsPage.selectPaymentType(paymentType);
		}
	}
	
	@Test(dependsOnMethods = "selectTypeTest")
	@Documentation(step="Enter serachtext, from date and to date",expected="Search criteria should be entered")
	@Parameters({"searchText","fromDate","toDate"})
	public static void enterSearchCriteriaTest(String searchText,String fromDate, String toDate) throws Exception {
		//AdminApprovePaymentsPage.enterSearchId(searchText);
		AdminApprovePaymentsPage.enterFromDate(fromDate);
		AdminApprovePaymentsPage.enterToDate(toDate);
	}
	
	@Test(dependsOnMethods = "enterSearchCriteriaTest")
	@Documentation(step="Click Submit",expected="Data should be loaded")
	public static void clickSubmitTest() throws Exception {		
		//AdminApprovePaymentsPage.clickSubmit();
	}

	
	@Test(dependsOnMethods = "clickSubmitTest")
	@Documentation(step="Select the row number and enable the approve button ",expected="approve button should be enabled")
	@Parameters("approveRowNum")
	public static void enableApproveByRowNumberTest(String approveRowNum) throws Exception {
		AdminApprovePaymentsPage.enableApproveByRowNumber(approveRowNum);
	}
	
	@Test(dependsOnMethods = "enableApproveByRowNumberTest")
	@Documentation(step="Click on the approve button ",expected="Approve button should be click")
	@Parameters("approveRowNum")
	public static void clickApproveByRowNumTest(int approveRowNum) throws Exception {
		AdminApprovePaymentsPage.clickApproveByRowNum(approveRowNum);
	}
	
	

}

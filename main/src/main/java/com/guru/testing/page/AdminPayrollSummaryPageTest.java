package com.guru.testing.page;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.testing.objectmap.AdminPayrollSummaryPageObjectMap;

public class AdminPayrollSummaryPageTest {
	
	@Test
	@Documentation(step = "Verify the Payroll summary page of Admin site.", expected = "Able to verify.")
	public static void verifyPayrollSummaryPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Payroll Summary");
			BrowserWait.waitUntilText("Payroll Summary", 30);
			BrowserWait.waitUntilElementIsDisplayed(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_DIRECT_DEPOSIT_LINK_PLINK);
			//TODO need to add more validations here.
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to verify Payroll summary page.");
		}
	}
	
	@Test
	@Documentation(step = "click Direct Deposit.", expected = "Able to click.")
	public static void clickDirectDepositLinkTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_DIRECT_DEPOSIT_LINK_PLINK);
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'Direct Deposit' link.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the Direct Deposit page of Admin site.", expected = "Able to verify.")
	public static void verifyDirectDepositDetailsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com");
			BrowserWait.waitUntilText("Direct Deposit", 30);
			BrowserWait.waitUntilElementIsDisplayed(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_BUTTON_XPATH);
			//TODO need to add more validations here.
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Unable to verify Direct Deposit page.");
		}
	}
	
	@Test
	@Documentation(step = "click Generate CSV Button", expected = "Able to click.")
	public static void clickGenerateCSVBtnTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_BUTTON_XPATH);
			Alert alert = BrowserAction.switchToAlertBox();
			alert.accept();
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ApplicationException("Unable to click on 'Generate CSV' button.");
		}
	}
	
	@Test
	@Documentation(step = "Verify the CSV successfully generated..", expected = "Able to verify.")
	public static void verifyCSVGenerateSuccessTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com");
			BrowserWait.waitUntilText("The file is successfully generated.", 30);
			BrowserWait.waitUntilElementIsDisplayed(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_SUCCESS_DOWNLOAD_FILE_LINK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminPayrollSummaryPageObjectMap.ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_SUCCESS_BACK_TO_DIRECT_DEPOSIT_LINK_PLINK);
			BrowserAction.closeActiveWindow();
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to verify successful generation of CSV.");
		}
	}
}

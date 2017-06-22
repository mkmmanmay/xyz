package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAccess;
import com.guru.testing.constants.ApprovePaymentTypes;
import com.guru.testing.objectmap.AdminApprovePaymentsPageObjectMap;
import com.guru.testing.objectmap.CommonObjectMap;

public class AdminApprovePaymentsPage {
	
		
	public static void verifyAdminApprovePaymentsPage() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Guru.com - Manage Transactions");
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_ADMIN_MENU_PLINK, 10);
			BrowserWait.waitUntilText("Accept/Approve Transactions");
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_TAB_SELECTED_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_TAB_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_INVOICE_LIST_TABLE_ID, 60);
			
			//TODO need to add more validations here.
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Approve Payments page is not loaded");
		}
	}
	

	public static void clickTab(String tabName) throws Exception {
		ScriptLogger.info();
		try {		
			
			switch (tabName) {
			case "UNPAID":
				BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_TAB_PLINK);
				BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_TAB_SELECTED_XPATH,10);
				
				
				break;
			case "PENDING":
				BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_TAB_PLINK);
				BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_TAB_SELECTED_XPATH,10);
				BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_INVOICE_LIST_TABLE_ID, 90);
				
				break;
			case "COMPLETED":
				BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_TAB_PLINK);
				BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_TAB_SELECTED_XPATH,10);
				BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_INVOICE_LIST_TABLE_ID, 90);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			throw new ApplicationException(e, "Tab name "+tabName+" is not loaded");
		}
	}
	
	public static void selectType(String type) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TYPE_DROPDOWN_XPATH,10);
			WebElement typeDropdown=BrowserAction.getElement(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TYPE_DROPDOWN_XPATH);
					typeDropdown.click();
			WebElement element=BrowserAction.getElement(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TYPE_LIST_XPATH);
			switch (type) {
			case "INVOICE":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.INVOICE.getValue())).click();
				
				break;
			case "SAFEPAY":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.SAFEPAY.getValue())).click();				
				break;
				
			case "CASH_ACCOUNT":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.CASH_ACCOUNT.getValue())).click();
				
				break;
			case "FEATURED_JOB":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.FEATURED_JOB.getValue())).click();
				
				break;
			case "MEMBERSHIP":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.MEMBERSHIP.getValue())).click();
				
				break;
			case "SKILL_TEST":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.SKILL_TEST.getValue())).click();
				
				break;
			case "BID_PAX":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.BID_PAX.getValue())).click();
				
				break;
			case "CASH_ACCOUNT_EMP":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.CASH_ACCOUNT_EMP.getValue())).click();
				
				break;
			case "CASH_ACCOUNT_FL":
				element.findElement(By.partialLinkText(ApprovePaymentTypes.CASH_ACCOUNT_FL.getValue())).click();

				break;
				
			default:
				break;
			}
			
		} catch (Exception e) {
			throw new ApplicationException(e, "Type name"+type+"is not loaded");
		}
	}

	public static void enterSearchId(String searchText) throws ScriptException {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_SEARCH_TEXTBOX_ID);
			BrowserAction.enterFieldValue(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_SEARCH_TEXTBOX_ID,searchText);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}


	public static void enterFromDate(String fromDate) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_FROM_DATE_ID);
			BrowserAction.enterFieldValue(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_FROM_DATE_ID,fromDate);
			BrowserAction.getElement(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_FROM_DATE_ID).sendKeys(Keys.TAB);

		} catch (Exception e) {
			throw new ScriptException(e);
		} 
	}


	public static void enterToDate(String toDate) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TO_DATE_ID);
			BrowserAction.enterFieldValue(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TO_DATE_ID,toDate);
			BrowserAction.getElement(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_TO_DATE_ID).sendKeys(Keys.TAB);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}	
	}


	public static void clickSubmit() throws ScriptException {
		ScriptLogger.info();
		try {
			BrowserAction.click(CommonObjectMap.COMMON_INPUT_SUBMIT_BUTTON_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
	
	public static void clickAdminMenuTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_ADMIN_MENU_PLINK);
		} catch (Exception e) {
			throw new ApplicationException(e, "Unable to click on 'Admin Menu'.");
		}
		
	}


	public static void enableApproveByRowNumber(String approveRowNum) throws Exception {
		ScriptLogger.info();		
		try {
			List <WebElement> elements=BrowserAction.getElements(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_ACCEPT_APPROVE_BUTTON_XPATH);
			WebElement ele=elements.get(0);
			WebDriverAccess.removeAttribute(ele,"disabled", "disabled");
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}


	public static void selectPaymentType(String paymentType) {
		// TODO Auto-generated method stub
		
	}


	public static void clickApproveByRowNum(int approveRowNum) throws Exception {
		List <WebElement> elements=BrowserAction.getElements(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_ACCEPT_APPROVE_BUTTON_ENABLED_XPATH);
		WebElement ele=elements.get(approveRowNum);
		ele.click();
		BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_APPROVED_TOAST_MESSAGE_XPATH);
		Thread.sleep(2000);
	}
	
	public static void clickRevokeByRowNum(int revokeRowNum) throws Exception {
		List <WebElement> elements=BrowserAction.getElements(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_REVOKE_BUTTON_XPATH);
		WebElement ele=elements.get(revokeRowNum);
		ele.click();
		BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_POPUP_XPATH);
		BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_REVOKE_BUTTON_XPATH);
		BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_REVOKED_TOAST_MESSAGE_XPATH);
		Thread.sleep(2000);
	}
	
	public static void clickDeclineByRowNum(int declineRowNum) throws Exception {
		List <WebElement> elements=BrowserAction.getElements(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_DECLINE_BUTTON_XPATH);
		WebElement ele=elements.get(declineRowNum);
		ele.click();
		BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_POPUP_XPATH);
		BrowserAction.click(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_DECLINE_BUTTON_XPATH);
		BrowserWait.waitUntilElementIsDisplayed(AdminApprovePaymentsPageObjectMap.ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_DECLINED_TOAST_MESSAGE_XPATH);
		Thread.sleep(2000);
	}
	
	
	
	
}
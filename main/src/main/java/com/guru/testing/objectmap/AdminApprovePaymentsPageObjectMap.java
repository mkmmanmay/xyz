package com.guru.testing.objectmap;

public enum AdminApprovePaymentsPageObjectMap {
	
	
	ADMIN_APPROVE_PAYMENTS_PAGE_ADMIN_MENU_PLINK("Admin Menu"),
	
	ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_TAB_PLINK("UnPaid"),
	ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_TAB_PLINK("Pending"),
	ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_TAB_PLINK("Completed"),
	ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_INVOICE_LIST_TABLE_ID("invoiceList"),
	ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_INVOICE_LIST_TABLE_ID("PendingList"),
	ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_INVOICE_LIST_TABLE_ID("PendingList"),
	ADMIN_APPROVE_PAYMENTS_PAGE_UNPAID_TAB_SELECTED_XPATH("//li[@class='tab active']//a[contains(text(), 'UnPaid')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_PENDING_TAB_SELECTED_XPATH("//li[@class='tab active']//a[contains(text(), 'Pending')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_COMPLETED_TAB_SELECTED_XPATH("//li[@class='tab active']//a[contains(text(), 'Completed')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_TYPE_DROPDOWN_XPATH("//span[@class='active ng-binding']"),
	ADMIN_APPROVE_PAYMENTS_PAGE_ACCEPT_APPROVE_BUTTON_XPATH("//input[@class='module_btn primary_btn ng-scope'][@disabled='disabled']"),
	ADMIN_APPROVE_PAYMENTS_PAGE_ACCEPT_APPROVE_BUTTON_ENABLED_XPATH("//input[@class='module_btn primary_btn ng-scope']"),
	ADMIN_APPROVE_PAYMENTS_PAGE_TYPE_LIST_XPATH("//ul[@class='module_list dropdown-menu']"),
	ADMIN_APPROVE_PAYMENTS_PAGE_FROM_DATE_ID("txtFromDate"),
	ADMIN_APPROVE_PAYMENTS_PAGE_TO_DATE_ID("txtToDate"),
	ADMIN_APPROVE_PAYMENTS_PAGE_SEARCH_TEXTBOX_ID("searchText"),
	
	ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_APPROVED_TOAST_MESSAGE_XPATH("//p[contains(@class, 'module_toast')][contains(text(), 'Payment approved')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_DECLINE_BUTTON_XPATH("//a[contains(text(), 'Decline')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_DECLINE_BUTTON_XPATH("//button[contains(text(), 'Decline')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_DECLINED_TOAST_MESSAGE_XPATH("//p[contains(@class, 'module_toast')][contains(text(), 'Payment declined')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_REVOKE_BUTTON_XPATH("//a[contains(text(), 'Revoke')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_POPUP_XPATH("//div[@class='modal-content']"),
	ADMIN_APPROVE_PAYMENTS_PAGE_CONFIRM_REVOKE_BUTTON_XPATH("//button[contains(text(), 'Revoke')]"),
	ADMIN_APPROVE_PAYMENTS_PAGE_PAYMENT_REVOKED_TOAST_MESSAGE_XPATH("//p[contains(@class, 'module_toast')][contains(text(), 'Payment revoked')]"),
	;

	
	
	
	
	;
	
	
	private final String value;
	AdminApprovePaymentsPageObjectMap(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

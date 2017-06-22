package com.guru.testing.objectmap;

public enum AdminManageTestUsersPageObjectMap {
	
	ADMIN_MANAGE_USERS_PAGE_CREATE_EMPLOYER_ACCOUNT_BUTTON_XPATH("//a[contains(text(), 'Create Employer Account')]"),
	ADMIN_MANAGE_USERS_PAGE_CREATE_FREELANCER_ACCOUNT_BUTTON_XPATH("//a[contains(text(), 'Create Freelancer Account')]"),
	ADMIN_MANAGE_USERS_PAGE_BACK_TO_ADMIN_MENU_LINK_PLINK("Admin Menu"),
	ADMIN_MANAGE_USERS_PAGE_NEW_USER_CREATED_SUCCESS_TOAST_MESSAGE_XPATH("//p[@class='module_toast toast_show']"),
	ADMIN_MANAGE_USERS_PAGE_USERS_LIST_ID("invoiceList"),
	ADMIN_MANAGE_USERS_PAGE_USERS_LIST_ROWS_XPATH("//table[@id='invoiceList']//tbody//tr"),
	
	;
	private final String value;
	AdminManageTestUsersPageObjectMap(final String value) {
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

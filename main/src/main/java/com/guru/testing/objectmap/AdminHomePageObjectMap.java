package com.guru.testing.objectmap;

public enum AdminHomePageObjectMap {
	
	ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK("CRM - Account Search"),
	ADMIN_HOME_PAGE_CREATE_NEW_TEST_USERS_PLINK("Create New Test Users"),
	ADMIN_HOME_PAGE_PAYROLL_SUMMARY_PLINK("Payroll Summary"),
	ADMIN_HOME_PAGE_ACCEPT_APPROVE_PAYMENTS_PLINK("Accept/Approve Payments (Echeck/Check)"),
	ADMIN_HOME_PAGE_TASK_MANAGER_MONITOR_PLINK("Task Manager Monitor"),	
	ADMIN_HOME_PAGE_LOGOUT_PLINK("Logout"),
	;
	
	
	private final String value;
	AdminHomePageObjectMap(final String value) {
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

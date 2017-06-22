package com.guru.testing.objectmap;

public enum AdminCRMPageObjectMap {
	
	ADMIN_CRM_PAGE_FL_INPUT_TEXTBOX_XPATH("(//input[@name='keyword'])[1]"),
	ADMIN_CRM_PAGE_FL_SEARCHBY_DROPDOWN_XPATH("(//select[@name='searchby'])[1]"),
	ADMIN_CRM_PAGE_FL_SEARCH_BUTTON_XPATH("(//input[@type='submit'][@value='Search'])[1]"),
	ADMIN_CRM_PAGE_EMP_INPUT_TEXTBOX_XPATH("(//input[@name='keyword'])[2]"),
	ADMIN_CRM_PAGE_EMP_SEARCHBY_DROPDOWN_XPATH("(//select[@name='searchby'])[2]"),
	ADMIN_CRM_PAGE_EMP_SEARCH_BUTTON_XPATH("(//input[@type='submit'][@value='Search'])[2]"),

	ADMIN_CRM_PAGE_GO_TO_ACCOUNT_PLINK("Go to Account"),
	ADMIN_CRM_PAGE_GENERAL_INFO_TAB_PLINK("General Info"),
	ADMIN_CRM_PAGE_MEMBERSHIP_TAB_PLINK("Membership"),
	ADMIN_CRM_PAGE_MEMBERSHIP_TYPE_DROPDOWN_XPATH("//select[@name='lstMembershipType']"),
	ADMIN_CRM_PAGE_MEMBERSHIP_DURATION_DROPDOWN_XPATH("//select[@name='lstMembershipDuration']"),
	ADMIN_CRM_PAGE_MEMBERSHIP_UPGRADE_BUTTON_XPATH("//input[@name='btnChangeMembershipLevel']"),
	
	;
	
	
	private final String value;
	AdminCRMPageObjectMap(final String value) {
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

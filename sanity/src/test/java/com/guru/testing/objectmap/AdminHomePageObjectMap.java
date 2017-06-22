package com.guru.testing.objectmap;

public enum AdminHomePageObjectMap {
	
	ADMIN_HOME_PAGE_CRM_ACCOUNT_SEARCH_PLINK("CRM - Account Search"),

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

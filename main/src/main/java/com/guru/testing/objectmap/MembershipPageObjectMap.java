package com.guru.testing.objectmap;

public enum MembershipPageObjectMap {
	
	
	
	MEMBERSHIP_PAGE_DIV_ID("ctl00_ctl00_guB_guB_divPanel"),
	MEMBERSHIP_PAGE_PURCHASE_DIV_ID("purchMembership"),
	MEMBERSHIP_PAGE_SELECT_MEMBERSHIP_DIV_XPATH("//div[@class='memTableContainerDiv']"),
	MEMBERSHIP_PAGE_MEMBERSHIP_SELECTION_OPTIONS_XPATH("//div[@class='memTableContainerDiv']//tr[2]//td");	
	
	private final String value;
	MembershipPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum PhoneVerificationPageObjectMap {
	
	PHONE_VERIFICATION_PAGE_SKIP_THIS_FOR_NOW_LINK_ID("ctl00_ContentPlaceHolder1_aSkip");
	
	private final String value;
	PhoneVerificationPageObjectMap(final String value) {
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

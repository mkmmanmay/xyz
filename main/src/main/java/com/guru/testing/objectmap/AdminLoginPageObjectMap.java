package com.guru.testing.objectmap;

public enum AdminLoginPageObjectMap {
	
	ADMIN_LOGIN_PAGE_USERNAME_TEXTBOX_ID("txtUsername"),
	ADMIN_LOGIN_PAGE_PASSWORD_TEXTBOX_ID("txtPassword"),
	ADMIN_LOGIN_PAGE_LOGIN_BUTTON_ID("btnLogin"),
	;
	
	
	private final String value;
	AdminLoginPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum LoginPageObjectMap {
	
	LOGIN_PAGE_SIGN_IN_BUTTON_ID("ctl00_ContentPlaceHolder1_btnLoginAccount_btnLoginAccount_Button"),
	LOGIN_PAGE_EMAIL_USERNAME_TEXT_XPATH("//label[contains(text(),'Email or Username')]"),
	LOGIN_PAGE_PASSWORD_TEXT_XPATH("//label[contains(text(),'Password')]"),
	LOGIN_PAGE_EMAIL_VALID_TEXTBOX_ID("ctl00_ContentPlaceHolder1_ucLogin_txtUserName_txtUserName_TextBox"),
	LOGIN_PAGE_PASSWORD_VALID_TEXTBOX_ID("ctl00_ContentPlaceHolder1_ucLogin_txtPassword_txtPassword_TextBox"),

	LOGIN_PAGE_CONTENT_DIV_XPATH("//div[@class='loginLeft']");
	
	private final String value;
	LoginPageObjectMap(final String value) {
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

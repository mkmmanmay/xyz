package com.guru.testing.objectmap;

public enum CommonObjectMap {
	COMMON_GURU_LOGO_1_ID("topnav-gurulogo"),
	COMMON_GURU_LOGO_2_ID("f-topnav-logo-in"),
	COMMON_GURU_LOGO_3_ID("e-topnav-logo-in"),	
	
	COMMON_GURU_FL_SIGNOUT_ID("f-topnav-signout-in"),
	
	// SKILL CATEGORIES
	
	COMMON_GURU_SKILL_WEB_SOFTWARE_IT_PLINK("Web, Software & IT "),
	COMMON_GURU_SKILL_DESIGN_ART_MULTIMEDIA_PLINK("Design, Art & Multimedia "),
	COMMON_GURU_SKILL_WRITING_TRANSLATION_PLINK("Writing & Translation "),
	COMMON_GURU_SKILL_SALES_MARKETING_PLINK("Sales & Marketing "),
	COMMON_GURU_SKILL_OTHER_PLINK("Other "),
	COMMON_GURU_SKILL_ADMIN_SUPPORT_PLINK("Admin Support "),
	COMMON_GURU_SKILL_ENGINEERING_ARCHITECTURE_PLINK("Engineering & Architecture "),
	COMMON_GURU_SKILL_MANAGEMENT_FINANCE_PLINK("Management & Finance "),
	COMMON_GURU_SKILL_LEGAL_PLINK("Legal "),
	
	// FL Payments page sub tabs
	COMMON_GURU_PAYMENTS_PAGE_TRANSFER_METHODS_XPATH("//a[contains(text(), 'Transfer Methods')]"),
	COMMON_GURU_PAYMENTS_PAGE_CASH_ACCOUNT_XPATH("(//a[contains(text(), 'Cash Account')])[2]"),
	
	//Save button
	COMMON_SAVE_BUTTON_XPATH("//input[@type='submit'][@value='Save']"),
	
	//Social Login icons
	COMMON_PAGE_FACEBOOK_ICON_CSS("a.socLogin-btn.socLogin-btn_fb"),
	COMMON_PAGE_LINKEDIN_ICON_CSS("a.socLogin-btn.socLogin-btn_lnkin"),
	COMMON_PAGE_GOOGLE_ICON_CSS("a.socLogin-btn.socLogin-btn_google"),
		
	// FACEBOOK PAGE LOCATORS
	COMMON_FACEBOOK_EMAIL_OR_PHONE_TEXTBOX_ID("email"),
	COMMON_FACEBOOK_PASSWORD_TEXTBOX_ID("pass"),
	COMMON_FACEBOOK_LOGIN_BUTTON_ID("loginbutton"),
		
	// LINKED IN PAGE LOCATORS
	COMMON_LINKEDIN_EMAIL_OR_PHONE_TEXTBOX_NAME("session_key"),
	COMMON_LINKEDIN_PASSWORD_TEXTBOX_NAME("session_password"),
	COMMON_LINKEDIN_ALLOW_ACCESS_BUTTON_NAME("authorize"),
		
	// GOOGLE PLUS PAGE LOCATORS
	COMMON_GOOGLE_EMAIL_TEXTBOX_ID("Email"),
	COMMON_GOOGLE_NEXT_BUTTON_ID("next"),
	COMMON_GOOGLE_PASSWORD_TEXTBOX_ID("Passwd"),
	COMMON_GOOGLE_SIGN_IN_BUTTON_ID("signIn"),
	COMMON_GOOGLE_ALLOW_BUTTON_ID("submit_approve_access"),
	
	//Calendar
	CALENDAR_DATE_PICKER_TABLE_XPATH("//div[@ng-switch='datepickerMode']"),
	CALENDAR_DATE_PICKER_DATE_CELL_XPATH("//td[contains(@ng-repeat,'dt in row')][@role='gridcell']"),	
	
	//
	
	COMMON_INPUT_SUBMIT_BUTTON_XPATH("//input[@value='Submit']")	;
	
	private final String value;
	CommonObjectMap(final String value) {
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

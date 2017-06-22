package com.guru.testing.objectmap;

public enum ThirdPartyPageObjectMap {
	
	// PAYPAL PAGE
	PAYPAL_PAGE_LOAD_LOGIN_PAGE_ID("loadLogin"),
	PAYPAL_PAGE_EMAIL_TEXTBOX_XPATH("//div[@id='login_emaildiv']//input[@id='email']"),
	PAYPAL_PAGE_EMAIL_TEXTBOX_ID("email"),
	PAYPAL_PAGE_TYPE_2_LOGIN_EMAIL_TEXTBOX_XPATH("//div[@id='loginBox']//input[@id='login_email']"),
	PAYPAL_PAGE_PASSWORD_TEXTBOX_XPATH("//div[@id='login_passworddiv']//input[@id='password']"),
	PAYPAL_PAGE_TYPE_2_LOGIN_PASSWORD_TEXTBOX_XPATH("//div[@id='loginBox']//input[@id='login_password']"),
	PAYPAL_PAGE_LOGIN_BUTTON_ID("btnLogin"),
	PAYPAL_PAGE_TYPE_2_LOGIN_BUTTON_ID("submitLogin"),
	PAYPAL_PAGE_LOGIN_MAIN_PAGE_DISABLED_DUE_TO_PROCESSING_LOGIN_XPATH("//div[@id='main'][@aria-disabled='true']"),
	PAYPAL_PAGE_BILLING_AGREEMENT_AGREE_AND_CONTINUE_BUTTON_ID("confirmButtonTop"),
	PAYPAL_PAGE_BILLING_AGREEMENT_TYPE_2_LOGIN_AGREE_AND_CONTINUE_BUTTON_ID("continue"),
	
	// PAYONEER PAGE
	PAYONEER_PAGE_SIGNUP_OPTIONS_CONTAINER_ID("services"),
	PAYONEER_PAGE_SIGNUP_OPTIONS_ALREADY_HAVE_AN_ACCOUNT_LINK_ID("haveAccountLink"),
	PAYONEER_PAGE_SIGNUP_OPTIONS_SERVICES_CONTAINER_XPATH("//div[@class='services-container']"),
	PAYONEER_PAGE_SIGNUP_OPTIONS_PREPAID_MASTER_CARD_RADIO_BUTTON_XPATH("//div[@class='services-container']//div[@class='field radio-buttons']//div[@id='payoutMethods']//label[@payoneer='Checkable']//span[@class='service-title']//span[contains(text(), 'Prepaid MasterCard')]"),
	PAYONEER_PAGE_SIGNUP_OPTIONS_BANK_TRANSFERS_RADIO_BUTTON_XPATH("//div[@class='services-container']//div[@class='field radio-buttons']//div[@id='payoutMethods']//label[@payoneer='Checkable']//span[@class='service-title']//span[contains(text(), 'Bank Transfers')]"),
	PAYONEER_PAGE_SIGNUP_OPTIONS_CONTAINER_SIGN_UP_BUTTON_ID("SignUpButton"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_TITLE_XPATH("//div[@class='title'][contains(text(), 'Prepaid Card Setup')]"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_FIRST_NAME_TEXTBOX_ID("txtFirstName"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_LAST_NAME_TEXTBOX_ID("txtLastName"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_EMAIL_TEXTBOX_ID("txtEmail"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_EMAIL_TEXTBOX_ID("txtRetypeEmail"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_DATE_OF_BIRTH_TEXTBOX_XPATH("(//input[@payoneer='DateTimePicker'])[2]"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_MONTH_DROPDOWN_XPATH("//select[@class='ui-datepicker-month']"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_YEAR_DROPDOWN_XPATH("//select[@class='ui-datepicker-year']"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CALENDAR_SECOND_ROW_FIRST_DATE_XPATH("//table[@class='ui-datepicker-calendar']//tbody//tr[2]//td[1]"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PERSONAL_DETAILS_NEXT_BUTTON_ID("PersonalDetailsButton"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_COUNTRY_DROPDOWN_XPATH("//div[@class='field field-select']//select[@id='ddlResidencyCountries']"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ADDRESS_LINE1_ID("txtAddress1"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CITY_TEXTBOX_ID("txtCity"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ZIP_TEXTBOX_ID("txtZip"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ISD_CODE_DROPDOWN_ID("AccountPhoneNumber_iso2"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PHONE_TEXTBOX_ID("AccountPhoneNumber_num"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_CONTACT_DETAILS_NEXT_BUTTON_ID("ContactDetailsButton"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_USERNAME_TEXTBOX_ID("txtUserName"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_PASSWORD_TEXTBOX_ID("tbPassword"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_RETYPE_PASSWORD_TEXTBOX_ID("tbRetypePassword"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_QUESTIONS_DROPDOWN_ID("ddlSecurityQuestions"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_ANSWER_TEXTBOX_ID("tbSecurityAnswer"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_SECURITY_DETAILS_NEXT_BUTTON_ID("AccountDetailsButton"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_TYPE_DROPDOWN_ID("ddlIdentityDocTypes"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ID_NUMBER_TEXTBOX_ID("txtCollectForeignId"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_COUNTRY_OF_ISSUE_DROPDOWN_ID("ddlIssueCountry"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX1_XPATH("//div[@id='sdCardReg']/div[1]/div[1]/label"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX2_XPATH("//div[@id='sdCardReg']/div[2]/div[1]"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_I_AGREE_CHECKBOX3_XPATH("//div[@id='sdCardReg']/div[3]/div[1]"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_BUTTON_ID("btnSubmit"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_SUCCESS_CONGRATULATIONS_XPATH("//div[@class='title optional conf-default'][contains(text(), 'Congratulations!']"),
	PAYONEER_PAGE_PREPAID_CARD_SET_UP_PAGE_ORDER_SUCCESS_REVIEW_IN_PROCESS_XPATH("//span[@class='name'][contains(text(), 'Review > In Process')]"),

	
	
	;
	
	private final String value;
	ThirdPartyPageObjectMap(final String value) {
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

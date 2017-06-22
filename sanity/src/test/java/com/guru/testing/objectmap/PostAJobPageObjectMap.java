package com.guru.testing.objectmap;

public enum PostAJobPageObjectMap {
	
	POST_A_JOB_PAGE_FIRST_PANE_ID("primaryFields"), 
	POST_A_JOB_PAGE_FIND_A_GURU_TOP_NAV_ID("hdrkeyword"), 
	POST_A_JOB_PAGE_HEADER_XPATH("//h1[contains(text(), 'Post a Job')]"), 
	POST_A_JOB_PAGE_JOBTITLE_MIN_CHAR_CHECK_ID("titleMin"),
	POST_A_JOB_PAGE_JOBTITLE_TEXTBOX_VALID_CSS("input[id='ctl00_guB_ucPostProject_txtPT_txtPT_TextBox'][class='txtInput']"),
	POST_A_JOB_PAGE_JOBTITLE_TEXTBOX_INVALID_CSS("input[id='ctl00_guB_ucPostProject_txtPT_txtPT_TextBox'][class='invalid txtInput']"),
	POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_VALID_ID("ctl00_guB_ucPostProject_txtPD_txtPD_TextBox"), 
	POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_INVALID_CSS("textarea[id='ctl00_guB_ucPostProject_txtPD_txtPD_TextBox'][class='invalid txtInput']"),
	POST_A_JOB_PAGE_ADD_FILES_ID("btnAddWork"),
	POST_A_JOB_PAGE_ADD_FILE_IN_ADDFILES_DIALOG_POPUP_ID("selectFilesCaption"),
	POST_A_JOB_PAGE_FILE_UPLOAD_WARNING_CLASS("module_callout callout-small callout-warning"),
	POST_A_JOB_PAGE_CATEGORIES_XPATH("//ul[@id='categoryList']//li//a//p[@class='title']"),
	POST_A_JOB_PAGE_CATEGORY_SELECTED_XPATH("//li[@class='selected']"),
	POST_A_JOB_PAGE_WEBCATEGORY_XPATH("//p[contains(text(), 'Web, Software & IT')]"),
	POST_A_JOB_PAGE_WEBCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Web, Software & IT')]"),
	POST_A_JOB_PAGE_DESIGNCATEGORY_XPATH("//p[contains(text(), 'Design, Art & Multimedia')]"),
	POST_A_JOB_PAGE_DESIGNCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Design, Art & Multimedia')]"),
	POST_A_JOB_PAGE_WRITINGCATEGORY_XPATH("//p[contains(text(), 'Writing & Translation')]"),
	POST_A_JOB_PAGE_WRITINGCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Writing & Translation')]"),
	POST_A_JOB_PAGE_SALESCATEGORY_XPATH("//p[contains(text(), 'Sales & Marketing')]"),
	POST_A_JOB_PAGE_SALESCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Sales & Marketing')]"),
	POST_A_JOB_PAGE_ADMINCATEGORY_XPATH("//p[contains(text(), 'Admin Support')]"),
	POST_A_JOB_PAGE_ADMINCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Admin Support')]"),
	POST_A_JOB_PAGE_MANAGEMENTCATEGORY_XPATH("//p[contains(text(), 'Management & Finance')]"),
	POST_A_JOB_PAGE_MANAGEMENTCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Management & Finance')]"),
	POST_A_JOB_PAGE_LEGALCATEGORY_XPATH("//p[contains(text(), 'Legal')]"),
	POST_A_JOB_PAGE_LEGALCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Legal')]"),
	POST_A_JOB_PAGE_ENGINEERINGCATEGORY_XPATH("//p[contains(text(), 'Engineering & Architecture')]"),
	POST_A_JOB_PAGE_ENGINEERINGCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Engineering & Architecture')]"),
	POST_A_JOB_PAGE_ANYCATEGORY_XPATH("//p[contains(text(), 'Any Category')]"),
	POST_A_JOB_PAGE_ANYCATEGORY_SELECTED_XPATH("//li[@class='selected']//p[contains(text(), 'Any Category')]"),
	POST_A_JOB_PAGE_MATCHEDSKILLS_ID("divMatchedSkills"),
	POST_A_JOB_PAGE_SUGGESTED_SKILL_TOKEN_CLASS("token-input-token"),
	POST_A_JOB_PAGE_SKILL_AUTOCOMPLETE_BOX_LOOKING_FOR_SKILL_TEXT_XPATH("div[@class='token-input-dropdown']//p[contains(text(), 'Looking for that skill...')]"),
	POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_VALID_ID("token-input-ctl00_guB_ucPostProject_txtSkills_txtSkills_TextBox"),
	POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_INVALID_CSS("ul[class='token-input-list invalid'] input[id='token-input-ctl00_guB_ucPostProject_txtSkills_txtSkills_TextBox']"),
	POST_A_JOB_PAGE_WORLDWIDE_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblLocationType_rblLocationType_RadioButton_0"),
	POST_A_JOB_PAGE_COUNTRY_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblLocationType_rblLocationType_RadioButton_1"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_PARENT_ID("ctl00_guB_ucPostProject_txtCountry"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_CHILD_ID("token-input-ctl00_guB_ucPostProject_txtCountry_txtCountry_TextBox"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_TOKEN_CLASS("token-input-token"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_DROPDOWN_XPATH("(//div[@class='token-input-dropdown'])[2]"),
	POST_A_JOB_PAGE_COUNTRY_AUTOCOMPLETE_BOX_LOOKING_FOR_COUNTRY_TEXT_XPATH("div[@class='token-input-dropdown']//p[contains(text(), 'Looking for that country...')]"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_DROPDOWN_NAMES_ID("ulAutoList"),
	POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_TOKEN_DELETE_CLASS("token-input-delete-token"),
	POST_A_JOB_PAGE_CITY_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblLocationType_rblLocationType_RadioButton_2"),
	POST_A_JOB_PAGE_CITY_TEXTBOX_PARENT_ID("ctl00_guB_ucPostProject_txtCity"),
	POST_A_JOB_PAGE_CITY_TEXTBOX_CHILD_ID("token-input-ctl00_guB_ucPostProject_txtCity_txtCity_TextBox"),
	POST_A_JOB_PAGE_CITY_TEXTBOX_CITY_TOKEN_CLASS("token-input-token"),
	POST_A_JOB_PAGE_CITY_AUTOCOMPLETE_BOX_LOOKING_FOR_CITY_TEXT_XPATH("div[@class='token-input-dropdown']//p[contains(text(), 'Looking for that city...')]"),
	POST_A_JOB_PAGE_CITY_TEXTBOX_WRAPPER_ID("cityWrapper"),
	POST_A_JOB_PAGE_CITY_TEXTBOX_CITY_TOKEN_DELETE_CLASS("token-input-delete-token"),
	POST_A_JOB_PAGE_ZIPCODE_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblLocationType_rblLocationType_RadioButton_3"),
	POST_A_JOB_PAGE_ZIPCODE_WITHINRANGE_LISTBOX_ID("ctl00_guB_ucPostProject_ddlMile_ddlMile_Select"),
	POST_A_JOB_PAGE_ZIPCODE_TEXTBOX_ID("ctl00_guB_ucPostProject_txtZipCode_txtZipCode_DefaultText"),
	POST_A_JOB_PAGE_FIXEDPRICE_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblBudgetType_rblBudgetType_RadioButton_0"),
	POST_A_JOB_PAGE_HOURLY_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblBudgetType_rblBudgetType_RadioButton_1"),
	POST_A_JOB_FIXEDPRICE_BUDGET_LISTBOX_ID("ctl00_guB_ucPostProject_ddlBudget_ddlBudget_Select"),
	POST_A_JOB_JOB_DURATION_LISTBOX_ID("ctl00_guB_ucPostProject_ddlDuration_ddlDuration_Select"),
	POST_A_JOB_HOURS_PER_WEEK_LISTBOX_ID("ctl00_guB_ucPostProject_ddlHrWk_ddlHrWk_Select"),
	POST_A_JOB_MIN_RATE_PERHOUR_TEXTBOX_ID("ctl00_guB_ucPostProject_txtMinRate_txtMinRate_TextBox"),
	POST_A_JOB_MAX_RATE_PERHOUR_TEXTBOX_ID("ctl00_guB_ucPostProject_txtMaxRate_txtMaxRate_TextBox"),
	POST_A_JOB_PAGE_EXPOSURE_MAX_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblPrivacySetting_rblPrivacySetting_RadioButton_0"),
	POST_A_JOB_PAGE_EXPOSURE_LIMITED_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblPrivacySetting_rblPrivacySetting_RadioButton_1"),
	POST_A_JOB_PAGE_EXPOSURE_NONE_RADIOBUTTON_ID("ctl00_guB_ucPostProject_rblPrivacySetting_rblPrivacySetting_RadioButton_2"),
	POST_A_JOB_PAGE_FEATURE_MY_JOB_CHECKBOX_ID("ctl00_guB_chkfeatureJob"),
	POST_A_JOB_PAGE_REHIRE_BUTTON_LINK("Rehire"),
	POST_A_JOB_PAGE_DEADLINE_CALENDAR_BOX_ID("ctl00_guB_txtCloseDate_txtCloseDate_TextBox"),
	POST_A_JOB_PAGE_DEADLINE_CALENDAR_BOX_DATEPICKER_ID("ui-datepicker-div"),
	POST_A_JOB_PAGE_DEADLINE_CALENDAR_BOX_DATE_XPATH("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr[4]/td[3]/a"),
	POST_A_JOB_PAGE_DEADLINE_CALENDAR_TEXTBOX_VALID_CSS("input[id='ctl00_guB_txtCloseDate_txtCloseDate_TextBox'][class='txtInput']"),
	POST_A_JOB_PAGE_DEADLINE_CALENDAR_TEXTBOX_INVALID_CSS("input[id='ctl00_guB_txtCloseDate_txtCloseDate_TextBox'][class='invalid txtInput']"),
	POST_A_JOB_PAGE_POST_JOB_BUTTON_ID("ctl00_guB_btnPostProject"),
	
	// Options which only appears when you've not signed in, but do it from the post a job page itself
	POST_A_JOB_PAGE_EMAIL_OR_USERNAME_TEXTBOX_ID("ctl00_guB_ucLogin_txtUserName_txtUserName_TextBox"),
	POST_A_JOB_PAGE_PASSWORD_TEXTBOX_ID("ctl00_guB_ucLogin_txtPassword_txtPassword_TextBox"),
	
	POST_A_JOB_PAGE_SIGN_IN_TO_POST_SOCIAL_SIGNIN_RADIO_BUTTON_ID("ctl00_guB_rblUnsignedUser_rblUnsignedUser_RadioButton_2"),
	POST_A_JOB_PAGE_AFTER_SIGNING_IN_CONTINUE_BUTTON_IN_GET_MORE_QUOTES_DIALOG_BOX_XPATH("//div[@class='modal-footer']//button[@class='module_btn primary_btn']"),
	
	POST_A_JOB_GET_MORE_QUOTES_POPUP_FEATURE_MY_JOB_RADIO_ID("jobFeatured"),

	
	;
	private final String value;
	PostAJobPageObjectMap(final String value) {
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

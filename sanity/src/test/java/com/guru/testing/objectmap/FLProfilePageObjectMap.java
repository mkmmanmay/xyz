package com.guru.testing.objectmap;

public enum FLProfilePageObjectMap {
	
	FL_PROFILE_PAGE_PROFILE_PIC_XPATH("//div[@class='profile-pic']"),
	FL_PROFILE_PAGE_PORTFOLIO_TAB_XPATH("//ul[@class='clearfix']//li[2]"),
	FL_PROFILE_PAGE_PORTFOLIO_TAB_ADD_A_WORK_COLLECTION_LINK_XPATH("//a[contains(text(), 'Add a Work Collection')]"),
	FL_PROFILE_PAGE_PORTFOLIO_TAB_FIRST_PORTFOLIO_XPATH("//ul[@id='projectsList']//li[1]//a[@class='openpopup']"),
	
	// -------- WHEN EMP VISITS FL PROFILE -------
	
	FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_A_JOB_ALREADY_POSTED_DROPDOWN_ID("ctl00_ctl00_guB_guB_ddlProjects_ddl"),
	FL_PROFILE_PAGE_OVERVIEW_GET_A_QUOTE_BUTTON_XPATH("//div[@class='innerModule']//div[@class='control-group inviteSendPrimaryBtn']//input[@value='Get a Quote']"),
	FL_PROFILE_PAGE_SEND_A_MESSAGE_UNDER_GET_A_QUOTE_ID("ctl00_ctl00_guB_guB_txtMessage"),
	FL_PROFILE_PAGE_GET_A_QUOTE_SUCCESS_TOAST_MESSAGE_XPATH("//div[@class='popMsg']//p[contains(text(), 'Success! We have sent your Invitation to the Freelancer.')]"),
	;
	
	private final String value;
	FLProfilePageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum HirePageObjectMap {
	
	HIRE_PAGE_QUOTES_TAB_XPATH("//a[contains(text(), 'Quotes')]"),
	HIRE_PAGE_POSTINGS_TAB_ID("aPost"),
	HIRE_PAGE_REFINE_BY_ALL_QUOTES_ID("lnkAllQuotes"),
	HIRE_PAGE_REFINE_BY_HIRED_ID("leftNavCnt_3"),
	HIRE_PAGE_REFINE_BY_PREMIUN_ID("leftNavCnt_1"),
	HIRE_PAGE_REFINE_BY_FIXED_PRICE_ID("leftNavCnt_4"),
	HIRE_PAGE_REFINE_BY_HOURLY_ID("leftNavCnt_5"),
	HIRE_PAGE_REFINE_BY_PLACEHOLDER_ID("leftNavCnt_6"),
	HIRE_PAGE_REFINE_BY_CONTACTED_ID("leftNavCnt_5"),
	HIRE_PAGE_REFINE_BY_ALL_SKILLS_ID("lnkAllSkills"),
	HIRE_PAGE_REFINE_BY_ANY_LOCATION_ID("lnkAnyLocation"),
	HIRE_PAGE_REFINE_BY_CITY_ID("lnkcity"),
	HIRE_PAGE_REFINE_BY_ZIP_ID("lnkZip"),
	HIRE_PAGE_REFINE_BY_COUNTRY_ID("lnkCountry"),
	HIRE_PAGE_REFINE_BY_REGION_ID("lnkRegion"),
	HIRE_PAGE_REFINE_BY_ANY_STAR_RATINGS_ID("lnkRStarsAny"),
	HIRE_PAGE_REFINE_BY_5_STARS_ID("lnkR5Stars"),
	HIRE_PAGE_REFINE_BY_4_STARS_ID("lnkR4Stars"),
	HIRE_PAGE_REFINE_BY_3_STARS_ID("lnkR3ars"),
	HIRE_PAGE_REFINE_BY_ANY_REVIEWS_ID("lnkRevAny"),
	HIRE_PAGE_REFINE_BY_3_PLUS_REVIEWS_ID("lnkRev3"),
	HIRE_PAGE_REFINE_BY_10_PLUS_REVIEWS_ID("lnkRev10"),
	HIRE_PAGE_REFINE_BY_50PLUS_REVIEWS_ID("lnkRev50"),
	HIRE_PAGE_TINY_URL_ID("url"),
	HIRE_PAGE_INVITE_FREELANCERS_LINK_ID("lnkInviteFreelancers"),
	HIRE_PAGE_QUOTES_MIDDLE_DIV_ID("QuotesControllerEmp"),
	HIRE_PAGE_SEARCH_TEXTBOX_ID("searchText"),
	HIRE_PAGE_SORT_BY_DROPDOWN_ID("spnt"),
	HIRE_PAGE_SELECT_ALL_CHECKBOX_ID("selectAll"),
	HIRE_PAGE_FL_QUOTES_LIST_XPATH("//li[contains(@class, 'quoteHeader ng-scope')]"), 
	HIRE_PAGE_HIRE_FL_BUTTON_XPATH("//button[@class='module_btn primary_btn small_btn'][contains(text(),'Hire')]"),
	HIRE_PAGE_FL_QUOTES_XPATH("//div[@id='QuotesControllerEmp']//ul[@class='module_list tight quotes ng-scope']//li[contains(@class, 'quoteHeader ng-scope')]"),
	HIRE_PAGE_FL_QUOTE_OPENED_VIEW_QUOTE_PLINK("View Quote"),
	HIRE_PAGE_HIRED_FL_QUOTE_DELETE_ICON_XPATH("//a[@title='Discard Message']"),
	HIRE_PAGE_HIRED_FL_QUOTE_OPENED_END_DISCUSSION_PLINK("End discussion"),
	HIRE_PAGE_FL_QUOTE_OPENED_BACK_PLINK("Back"),
	
	//Hire Pop up
	HIRE_PAGE_POP_UP_MODAL_DIV_XPATH("//div[@ng-app='guru.empQuotes.controller']"),
	HIRE_PAGE_POP_UP_YES_APPROVE_AGREEMENT_RADIO_BUTTON_ID("approve"),
	HIRE_PAGE_POP_UP_NO_REVISE_AGREEMENT_RADIO_BUTTON_ID("nochange"),
	HIRE_PAGE_POP_UP_ACKNOWLEDGEMENT_CHECKBOX_ID("chkTerm"),	
	HIRE_PAGE_POP_UP_HIRE_BUTTON_XPATH("//input[@ng-click='AwardProject()']"),
	HIRE_PAGE_POP_UP_HIRE_BUTTON_DISABLED_XPATH("//input[@ng-click='AwardProject()'][@disabled='disabled']"),
	HIRE_PAGE_POP_UP_CANCEL_BUTTON_XPATH("//input[@ng-click='cancel()']"),
	HIRE_PAGE_POP_UP_AFTER_CLICKING_HIRE_BUTTON_XPATH("//div[@class='modal-content ng-scope']"),
	HIRE_PAGE_POP_UP_TERMS_CONDITIONS_CHECKBOX_ID("chkTerm"),
	//HIRE_PAGE_POP_UP_HIRE_BUTTON_XPATH("//input[@value='Hire']"),
	
	
	// -------------- QUOTES PAGE ---------------
	HIRE_PAGE_MYGURUS_TAB_XPATH("//a[@href='/emp/MyGurus.aspx']"),
	HIRE_PAGE_QUOTES_POST_MY_JOB_BUTTON_XPATH("//a[@href='/emp/postproject.aspx']"),
	HIRE_PAGE_QUOTES_ALL_QUOTES_CHECKBOX_XPATH("//label[@for='selectAll']"),
	HIRE_PAGE_QUOTES_SORT_BY_DROPDOWN_ID("spnt"),
	HIRE_PAGE_QUOTES_SEARCH_TEXTBOX_ID("searchText"),
	HIRE_PAGE_QUOTES_SEARCH_FREELANCERS_BUTTON_XPATH("//a[@class='module_btn primary_btn'][@href='/d/freelancers/']"),
	HIRE_PAGE_MYGURUS_FL_ON_ROW2_XPATH("//li[@id='myFreeRow1']//div//strong"),
	HIRE_PAGE_QUOTES_SEND_MESSAGE_BUTTON_XPATH("//button[contains(text(), 'Send Message')]"),
	HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_XPATH("//div[@class='modal-content ng-scope']"),
	HIRE_PAGE_QUOTES_SEND_MESSAGE_MESSAGE_SENT_TOAST_MESSAGE_XPATH("//p[@class='module_toast toast_show'][contains(text(), 'Message sent.')]"),
	HIRE_PAGE_QUOTES_SEND_MESSAGE_POPUP_SEND_MESSAGE_LABEL_ID("tempLabel"),
	HIRE_PAGE_FL_QUOTE_OPENED_LAST_MESSAGE_XPATH("//ul[@id='messages-thread']//li[@class='projMsg-thread-msg ng-scope projMsg-thread-msg_open projMsg-thread-msg_last']//pre"),
	HIRE_PAGE_QUOTES_FIRST_HIRE_BUTTON_XPATH("(//button[@class='module_btn primary_btn small_btn'])[1]"),	
	HIRE_PAGE_QUOTES_HIRED_SECTION_AGAINST_QUOTE_XPATH("//div[@class='quoteHeader-hired ng-scope']"),
	HIRE_PAGE_QUOTES_WORKROOM_LINK_XPATH("//a[contains(text(), 'Work Room')]"),	
	HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_LINK_XPATH("//a[contains(text(), 'Make Announcement')]"),
	HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_XPATH("//div[@class='modal-content']"),
	HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_WRITE_ANNOUNCEMENT_TEXTBOX_ID("announcement"),
	HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_POPUP_MAKE_ANNOUNCEMENT_BUTTON_XPATH("//input[@value='Make Announcement']"),
	HIRE_PAGE_QUOTES_MAKE_ANNOUNCEMENT_SENT_TOAST_MESSAGE_XPATH("//p[contains(text(), 'Announcement Sent!')]"),
	HIRE_PAGE_QUOTES_TINY_URL_TEXT_CONTAINER_ID("url"),
	HIRE_PAGE_QUOTES_SECTION_OF_JOB_ID("QuotesControllerEmp"),
	HIRE_PAGE_QUOTES_LEFT_PANEL_SECTION_ID("switchPanel"),	
	
	;
	
	private final String value;
	HirePageObjectMap(final String value) {
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

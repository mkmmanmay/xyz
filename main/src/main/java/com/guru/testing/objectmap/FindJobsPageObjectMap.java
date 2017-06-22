package com.guru.testing.objectmap;

public enum FindJobsPageObjectMap {
	
	FIND_JOBS_PAGE_REFINEMENTS_DIV_ID("switchPanel"),
	FIND_JOBS_PAGE_SEARCH_RESULTS_DIV_ID("results"),
	FIND_JOBS_PAGE_PAGINATION_UL_ID("ctl00_guB_ulpaginate"),
	FIND_JOBS_PAGE_SEARCH_JOBS_TEXT_BOX_ID("ctl00_guB_txtKeyWord"),
	FIND_JOBS_PAGE_SEARCH_ICON_ID("aSearch"),
	FIND_JOBS_PAGE_HOURLY_REFINEMENT_PAGE_RESULTS_HEADER_XPATH("//div[contains(text(), 'Hourly jobs')]"),
	FIND_JOBS_PAGE_FIXED_PRICE_REFINEMENT_PAGE_RESULTS_HEADER_XPATH("//div[contains(text(), 'Fixed price jobs')]"),
	FIND_JOBS_PAGE_HOURLY_REFINEMENT_PAGE_RESULTS_HOURLY_ATTRIBUTE_XPATH("//ul[@class='services']//strong[contains(text(), 'Hourly')]"),
	FIND_JOBS_PAGE_FIXED_PRICE_REFINEMENT_PAGE_RESULTS_FIXED_PRICE_ATTRIBUTE_XPATH("//ul[@class='services']//strong[contains(text(), 'Fixed Price')]"),	
	FIND_JOBS_PAGE_REFINE_BY_PANEL_XPATH("//ul[@class='searchRefinement searchList']"),
	FIND_JOBS_PAGE_ALL_APPLY_BUTTONS_XPATH("//a[@class='btnGreenFlat'][contains(text(),'Apply')]"),
	
	// FOR PROJECT URL EXTRACTION OF FIRST SEARCH RESULT
	FIND_JOBS_PAGE_FIRST_SEARCH_RESULT_CLASSNAME_XPATH("//div[@class='selectIndivServ']"),
	FIND_JOBS_PAGE_SEARCH_RESULT_AFTER_SEARCHING_PARTICULAR_JOB_ID_XPATH("//h2[@class='servTitle']"),
	
	// SAVE SEARCH
	FIND_JOBS_PAGE_SAVE_SEARCH_BUTTON_XPATH("//a[@class ='btnGrayFlat' and text()='Save Search']"),
	FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_BOX_XPATH("//div[@id='inviteModal']"),
	FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID("txtsave"),
	FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_SAVE_BUTTON_ID("btnSave"),
	FIND_JOBS_PAGE_SAVED_SEARCHES_DROPDOWN_ID("ctl00_guB_ddlSavedSeaches"),
	FIND_JOBS_PAGE_RENAME_LINK_XPATH("//div[@id='ctl00_guB_svdSearches'][@class='pnlSs']//a[@id='aRename']"),
	FIND_JOBS_PAGE_DELETE_LINK_XPATH("//div[@id='ctl00_guB_svdSearches'][@class='pnlSs']//a[@id='aDelete']"),
	FIND_JOBS_PAGE_DELETE_SAVED_SEARCH_BUTTON_ID("btnSave"),
	FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_CANCEL_BUTTON_XPATH("//button[@class='module_btn secondary_btn']"),
	
	// BUDGET TYPE RADIO BUTTONS
	FIND_JOBS_PAGE_BUDGET_TYPE_ALL_JOBS_RADIO_BUTTON_ID("ctl00_guB_radBud_0"),
	FIND_JOBS_PAGE_BUDGET_TYPE_HOURLY_RADIO_BUTTON_ID("ctl00_guB_radBud_1"),
	FIND_JOBS_PAGE_BUDGET_TYPE_FIXED_PRICE_RADIO_BUTTON_ID("ctl00_guB_radBud_2"),
	
	// Sorting options
	FIND_JOBS_PAGE_SORT_BY_DROPDOWN_ID("ctl00_guB_ddlSorts"),
	
	// SHOW ONLY Category CHECKBOXES
	FIND_JOBS_PAGE_FEATURED_JOBS_CHECKBOX_ID("ctl00_guB_chkFeatured"),
	FIND_JOBS_PAGE_HAS_VERIFIED_PAYMENT_METHOD_CHECKBOX_ID("ctl00_guB_chkVerified"),
	
	// HIDE CATEGORY CHECBOXES
	FIND_JOBS_PAGE_JOBS_I_HAVE_VIEWED_CHECKBOX_ID("ctl00_guB_chkViewed"),
	FIND_JOBS_PAGE_JOBS_I_HAVE_APPLIED_TO_CHECKBOX_ID("ctl00_guB_chkApplied"),

	
	;
	
	private final String value;
	FindJobsPageObjectMap(final String value) {
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

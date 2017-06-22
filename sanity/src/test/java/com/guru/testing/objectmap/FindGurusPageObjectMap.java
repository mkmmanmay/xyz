package com.guru.testing.objectmap;

public enum FindGurusPageObjectMap {
	FIND_GURUS_PAGE_REFINEMENTS_DIV_ID("switchPanel"),
	FIND_GURUS_PAGE_SEARCH_RESULTS_DIV_ID("results"),
	FIND_GURUS_PAGE_POST_A_JOB_FREE_PLINK("Post a Job (FREE)"),	
	FIND_GURUS_PAGE_SELECT_ALL_CHECKBOX_ID("selectAll"),	
	FIND_GURUS_PAGE_GET_QUOTES_TOP_BUTTON_ID("inviteSelected"),
	FIND_GURUS_PAGE_SORTING_OPTIONS_DROPDOWN_ID("ctl00_guB_ddlSorts"),
	FIND_GURUS_PAGE_FIND_A_GURU_LEFT_TAB_XPATH("//a[@href='/d/freelancers/']"),
	FIND_GURUS_PAGE_FIND_AND_HIRE_TALENTED_GURUS_TEXT_XPATH("//h1[contains(text(),'Find & Hire Talented Gurus')]"),
	
	
	//Service List related objectmaps
	FIND_GURUS_PAGE_SERVICES_LIST_PANE_ID("serviceList"),
	FIND_GURUS_PAGE_SERVICES_LIST_COUNTRY_TEXT_XPATH("//p[@class ='countryInfo']"),
	FIND_GURUS_PAGE_SERVICES_LIST_PAGINATION_PANE_ID("ctl00_guB_ulpaginate"),
	
	//Refinements
	FIND_GURUS_PAGE_REFINE_CATEGORY_PANE_ID("ctl00_guB_category"),
	FIND_GURUS_PAGE_REFINE_LOCATION_PANE_ID("location"),
	FIND_GURUS_PAGE_REFINE_LOCATION_LINKS_DRILLDOWN_XPATH("//a[@class='drillDown']"),
	
	FIND_GURUS_PAGE_REFINE_SHOW_ONLY_PANE_ID("ctl00_guB_Ul1"),
	FIND_GURUS_PAGE_REFINE_SERVICES_WITH_PORTFOLIO_CHECKBOX_ID("ctl00_guB_chkPortfolio"),	
	FIND_GURUS_PAGE_REFINE_FEEDBACK_PANE_ID("ctl00_guB_feedback"),
	FIND_GURUS_PAGE_REFINE_REVIEWS_PANE_ID("ctl00_guB_reviews"),
	FIND_GURUS_PAGE_REFINE_RATE_PER_HOUR_PANE_ID("ctl00_guB_rate"),
	FIND_GURUS_PAGE_REFINE_MIN_BUDGET_TEXTBOX_ID("ctl00_guB_txtminBud"),
	FIND_GURUS_PAGE_REFINE_MAX_BUDGET_TEXTBOX_ID("ctl00_guB_txtmaxBud"),
	FIND_GURUS_PAGE_REFINE_BUDGET_GO_BUTTON_ID("btnBud"),
	FIND_GURUS_PAGE_REFINE_SKILLS_DROPDOWN_ID("ctl00_guB_ddlSkills"),
	FIND_GURUS_PAGE_REFINE_COUNTRY_LINK_XPATH("//a[contains(text(), 'Country')]"),
	//FIND_GURUS_PAGE_REFINE_COUNTRY_LINK_PLINK("Country"),
	FIND_GURUS_PAGE_REFINE_COUNTRY_DROPDOWN_ID("ctl00_guB_ddlCountry"),
	FIND_GURUS_PAGE_REFINE_CLEAR_ALL_PLINK("Clear All"),
	FIND_GURUS_PAGE_REFINE_CATEGORY_COUNT_XPATH("//span[@class='totalNumber']"),	
	FIND_GURUS_PAGE_REFINE_MY_GURUS_PANE_ID("ctl00_guB_liFavs"),
	FIND_GURUS_PAGE_REFINE_MY_GURUS_CHECKBOX_ID("ctl00_guB_chkFavourite"),
	
	FIND_GURUS_GET_A_QUOTE_BUTTON_XPATH("//ul[@id='serviceList']//li[@class='serviceItem clearfix']//a[contains(text(), 'Get a Quote')]"),
	
	
	;
	
	private final String value;
	FindGurusPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum DashboardPageObjectMap {
	
	//DASHBOARD_PAGE_DASHBOARD_TAB_ID("e-topnav-dash-in"), old locator till 01-03-2017
	//DASHBOARD_PAGE_EMP_DASHBOARD_TAB_ID("ctl00_ctl20_navDashboard"),old locator till 01-03-2017
	DASHBOARD_PAGE_POST_A_JOB_TAB_ID("ctl00_ctl10_navPostjob"),
	DASHBOARD_PAGE_EMP_HIRE_TAB_ID("ctl00_ctl20_empHire"),
	DASHBOARD_PAGE_FL_MANAGE_TEAM_PLINK("Manage Team"),
	
	// ---- CONTACT INFORMATION PAGE ----
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ADDRESS_CONTAINER_XPATH("//div[@class='checkerContainer']"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXT_XPATH("//label[contains(text(), 'Search Address')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_SEARCH_ADDRESS_TEXTBOX_XPATH("//input[@placeholder='Enter a location']"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CITY_TEXT_XPATH("//label[contains(text(), 'City')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CITY_TEXTBOX_XPATH("//input[contains(@name, 'City_TextBox')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_COUNTRY_TEXT_XPATH("//label[contains(text(), 'Country')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_COUNTRY_DROPDOWN_XPATH("//select[contains(@id, 'Country_Select')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_STATE_TEXT_XPATH("//label[contains(text(), 'State')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_STATE_DROPDOWN_XPATH("//select[contains(@id, 'State_Select')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ZIP_TEXT_XPATH("//label[contains(text(), 'ZIP')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_ZIP_TEXTBOX_XPATH("//input[contains(@name, 'PostalCode_TextBox')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_TIME_ZONE_TEXT_XPATH("//label[contains(text(), 'Time Zone')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_TIME_ZONE_DROPDOWN_XPATH("//select[contains(@id, 'TimeZone_Select')]"),
	DASHBOARD_PAGE_CONTACT_INFORMATION_PAGE_CONTINUE_BUTTON_XPATH("//input[contains(@id, 'Submit_Button')]"),
	
	//Tab locators
	DASHBOARD_PAGE_DASHBOARD_TAB_XPATH("//a[@title='Dashboard']"),
	DASHBOARD_PAGE_FL_LEADS_TAB_XPATH("//span[contains(text(), 'Leads')]"),
	DASHBOARD_PAGE_FL_QUOTES_TAB_XPATH("//span[contains(text(), 'Quotes')]"),
	DASHBOARD_PAGE_FL_JOBS_TAB_XPATH("//span[contains(text(), 'Jobs')]"),
	DASHBOARD_PAGE_FL_PAYMENTS_TAB_XPATH("//span[contains(text(), 'Payments')]"),
	DASHBOARD_PAGE_FL_MESSAGES_TAB_XPATH("//a[contains(text(), 'Messages')]"),
	DASHBOARD_PAGE_EMP_POST_A_JOB_TAB_XPATH("//strong[contains(text(), 'Post a Job')]"),
	DASHBOARD_PAGE_EMP_HIRE_TAB_XPATH("//span[contains(text(), 'Hire')]"),
	DASHBOARD_PAGE_EMP_MANAGE_TAB_XPATH("//span[contains(text(), 'Manage')]"),
	DASHBOARD_PAGE_EMP_PAY_TAB_XPATH("//span[contains(text(), 'Pay')]"),
	DASHBOARD_PAGE_EMP_MESSAGES_TAB_XPATH("//a[@title='Messages']"),	
	DASHBOARD_PAGE_WIDGET_PANE_ID("mainPage"),
	DASHBOARD_PAGE_WIDGET_PANE_2_ID("main"),
	DASHBOARD_PAGE_TOP_SEARCH_ICON_ID("searchBtnTop"),	
	DASHBOARD_PAGE_EMP_MY_MANAGERS_PLINK("My Managers"),	
	DASHBOARD_PAGE_EMP_QUOTE_PLINK("Quote"),	
	DASHBOARD_PAGE_FL_SERVICES_DASHBOARD_TAB_ID("ctl00_ctl00_ctl21_navDashboard"),	
	DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_PANE_XPATH("//ul[@class='dropdown-menu xtraNavOps pull-right']"),	
	DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_BUY_BIDS_LINK_ID("f-topnav-buy-bids-in"),
	DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_ICON_BUTTON_ID("f-topnav-user-icon-in"),
	DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_EDIT_PROFILE_LINK_ID("f-topnav-edit-profile-in"),
	DASHBOARD_PAGE_FL_OWNER_OPTIONS_DROPDOWN_MEMBERSHIP_LINK_ID("f-topnav-membership-in"),
	DASHBOARD_PAGE_FL_OWNER_MEMBERSHIP_TYPE_ID("ctl00_guB_ctl00_divMemNameForOwner"),
	DASHBOARD_PAGE_FL_MEMBERSHIP_UPGRADE_LINK_ID("ctl00_guB_ctl00_aUpgrade"),
	
	//Signout locators
	DASHBOARD_PAGE_EMP_SIGN_OUT_ID("e-topnav-signout-in"),
	DASHBOARD_PAGE_FL_SIGN_OUT_ID("f-topnav-signout-in"),
	DASHBOARD_PAGE_SIGN_OUT_XPATH("//header[@class='globalNav']//li[@class='headLink']//a[contains(text(), 'Sign Out')]"),
	//withdraw
	DASHBOARD_PAGE_CASH_ACCOUNT_LINK_XPATH("//a[@href='/pro/cashaccount/'][@class='breadLink']"),
	DASHBOARD_PAGE_CASH_ACCOUNT_WITHDRAW_PLINK("withdraw"),
	
	
	// ---------- QUOTES SECTION EMP DASHBOARD --------------
	DASHBOARD_PAGE_EMP_JOBS_LIST_XPATH("//section[@id='hire']//ul[@id='hireList']//li"),
	
	// ---------- WORKROOM SECTION EMP DASHBOARD --------------
	DASHBOARD_PAGE_WORKROOM_EMP_JOBS_LIST_XPATH("//section[@id='manage']//ul[@id='manageList']//li"),
	
	// ---------- WORKROOM SECTION FL DASHBOARD --------------
	DASHBOARD_PAGE_WORKROOM_FL_JOBS_LIST_XPATH("//ul[@id='manageprojectList']//div[@class='rhythmMargin']//h3"),
	
	// ------------- MESSAGES TAB ----------------------------
	DASHBOARD_PAGE_MESSAGES_TOP_NAV_COUNT_ID("msgAlert"),
	
	// ------------------ CURRENT JOBS FL -------------------------
	DASHBOARD_PAGE_CURRENT_JOBS_PENDING_ACCEPTANCE_JOBS_CONTAINER_XPATH("//li[@class='award-pending']//div[@class='module_box']"),
	DASHBOARD_PAGE_CURRENT_JOBS_HIRED_IN_JOB_NAMES_XPATH("//ul[@id='manageprojectList']//div[@class='rhythmMargin']//h3"),
	
	// -------------------- ALERTS SECTION EMP -----------------
	DASHBOARD_PAGE_ALERT_SECTION_ALERT_NAMES_XPATH("//ul[@class='module_list tight alertList']//p[@class='identityName']"),
	;


	private final String value;
	DashboardPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum Reports1099PageObjectMap {
	
	//Prior year dropdown
	REPORTS_1099_PAGE_PRIOR_YEAR_DROPDOWN_XPATH("//div[@class='dropdown filterDD']//a[@class='dropToggle']"),
	REPORTS_1099_PAGE_SELECTED_YEAR_DROPDOWN_XPATH("//div[@class='dropdown filterDD']//a[@class='dropToggle']"),
	REPORTS_1099_PAGE_PRIOR_YEAR_OPEN_DROPDOWN_XPATH("//div[@class='dropdown filterDD open']//a[@class='dropToggle'][@aria-expanded='true']"),
	REPORTS_1099_PAGE_ALL_YEARS_IN_DROPDOWN_XPATH("//a[@ng-click='vm.changeYear(year)']"),
	REPORTS_1099_PAGE_SELECTED_YEAR_OPEN_DROPDOWN_XPATH("//a[@ng-click='vm.changeYear(year)'][@class='ng-binding active']"),
	
	//Page body and table
	REPORTS_1099_PAGE_NO_REPORT_TEXT_XPATH("//p[@class='copy ng-binding']"),
	REPORTS_1099_PAGE_NO_REPORT_NOT_OPTED_NAVIGATION_PLINK("opted into our 1099 service."),
	
	REPORTS_1099_PAGE_COMMON_DATA_TABLE_XPATH("//div[@class='rhythmMargin4  ng-scope']"),
	REPORTS_1099_PAGE_US_GURU_DATA_TABLE_XPATH("//div[@ng-if='vm._1099ReportList_US_NonGurus.length && vm.loading === false']"),
	REPORTS_1099_PAGE_NON_US_GURU_DATA_TABLE_XPATH("//div[@ng-if='vm._1099ReportList_ServiceNotRequested.length && vm.loading === false']"),
	REPORTS_1099_PAGE_NOT_REQUESTED_DATA_TABLE_XPATH("//div[@ng-if='vm._1099ReportList_US_Gurus.length && vm.loading === false']"),
	
	//print
	REPORTS_1099_PAGE_PRINT_BUTTON_XPATH("//button[@class='module_btn secondary_btn lonely_btn']"),
	REPORTS_1099_PAGE_PRINT_WINDOW_ID("print-header"),	
	
	//Download
	REPORTS_1099_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH("//a[@class='dropToggle'][contains(text(),'Download')]"),
	REPORTS_1099_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH("//div[@class='dropdown filterDD ng-scope open']"),
	REPORTS_1099_PAGE_DOWNLOAD_PDF_OPTION_XPATH("//a[contains(text(),'Download PDF')]"),
	REPORTS_1099_PAGE_DOWNLOAD_CSV_OPTION_XPATH("//a[contains(text(),'Download CSV')]"),
	
	
	;
		
	private final String value;
	Reports1099PageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum TransactionsPageObjectMap {
	
	//Calendar locators	
	TRANSACTIONS_PAGE_DATE_RANGE_OPTION_XPATH("//a[@class='dropToggle ng-binding'][contains(text(),'Date Range:')]"),
	TRANSACTIONS_PAGE_DATE_RANGE_TEXT_XPATH("(//span[@class='active ng-binding'])[1]"),
	TRANSACTIONS_PAGE_CALENDAR_OPEN_DROPDOWN_XPATH("//div[@class='dropdown filterDD open']//a[@class='dropToggle ng-binding'][@aria-expanded='true']"),
	TRANSACTIONS_PAGE_CALENDAR_FILTER_BUTTON_XPATH("//div[@class='dropdown filterDD open']//button[@class='module_btn primary_btn ng-binding']"),
	TRANSACTIONS_PAGE_CALENDAR_FROM_INPUT_BOX_XPATH("(//div[@class='form-control-group stacked verytight'])[1]"),
	TRANSACTIONS_PAGE_CALENDAR_TO_INPUT_BOX_XPATH("(//div[@class='form-control-group stacked verytight'])[2]"),
	TRANSACTIONS_PAGE_CALENDAR_WIDGET_TO_FROM_WIDGET_TABLE_XPATH("//table[@ng-switch-when='day']"),
	TRANSACTIONS_PAGE_CALENDAR_WIDGET_DAY_CELL_XPATH("//td[@ng-repeat='dt in row track by dt.date'][@role='gridcell']"),	
	
	
	//Reporting By Locators
	TRANSACTIONS_PAGE_REPORTING_BY_OPTION_XPATH("//a[@class='dropToggle'][contains(text(),'Reporting By:')]"),
	TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_GURU_APPLIED_XPATH("//span[@class='active ng-binding'][contains(text(),'Guru')]"),
	TRANSACTIONS_PAGE_REPORTING_BY_JOB_OPTION_XPATH("//a[contains(text(),'Job')]"),
	TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_JOB_APPLIED_XPATH("//span[@class='active ng-binding'][contains(text(),'Job')]"),
	TRANSACTIONS_PAGE_CALENDAR_OR_REPORTING_BY_OPEN_DROPDOWN_XPATH("//div[@class='dropdown filterDD open']"),
	
	//Download locators
	TRANSACTIONS_PAGE_DOWNLOAD_DROPDOWN_OPTION_XPATH("//a[@class='dropToggle'][contains(text(),'Download')]"),	
	TRANSACTIONS_PAGE_DOWNLOAD_OPEN_DROPDOWN_XPATH("//div[@class='dropdown filterDD ng-scope open']"),
	TRANSACTIONS_PAGE_DOWNLOAD_PDF_OPTION_XPATH("//a[contains(text(),'Download PDF')]"),
	TRANSACTIONS_PAGE_DOWNLOAD_CSV_OPTION_XPATH("//a[contains(text(),'Download CSV')]"),
	TRANSACTIONS_PAGE_EMP_RESULTS_TABLE_XPATH("//table[@class='module_table tight stripes invoiceList ng-scope']"),
	TRANSACTIONS_PAGE_FL_RESULTS_TABLE_XPATH("//table[@class='module_table module_box tight rhythmMargin2 invoiceList ng-scope']"),
	TRANSACTIONS_PAGE_EMP_INVOICE_ID_PLINK("Invoice ID:"),	
	TRANSACTIONS_PAGE_FL_INVOIDCE_ID_XPATH("//a[contains(@ng-href,'/payments/invoices/')]"),
	
	TRANSACTIONS_PAGE_PRINT_BUTTON_XPATH("//button[@class='module_btn secondary_btn lonely_btn']"),	
	
	TRANSACTIONS_PAGE_FEATURED_JOB_RECIEPT_PLINK("Featured Job Receipt"),
	
	//print window
	TRANSACTIONS_PAGE_PRINT_WINDOW_ID("print-header"),	
	
	//misc
	TRANSACTIONS_PAGE_GURU_OR_JOB_ID_XPATH("//p[@class='subtext ng-binding']"),	
	TRANSACTIONS_PAGE_NO_DATA_TRANSACTION_TEXT_XPATH("//p[@class='copy ng-binding']"),
	
	//Payment method
	TRANSACTIONS_PAGE_DEFAULT_REPORTING_BY_PAYMENT_METHOD_APPLIED_XPATH("//span[@class='active ng-binding'][contains(text(),'Payment Method')]"),
	TRANSACTIONS_PAGE_REPORTING_BY_PAYMENT_METHOD_OPTION_XPATH("//a[@role='button'][contains(text(),'Payment Method')]"),
	TRANSACTIONS_PAGE_REPORTING_BY_PAYMENT_METHOD_TYPE_TEXT_XPATH("//p[@class='identityName']"),
	
	//Employer
	TRANSACTIONS_PAGE_REPORTING_BY_EMPLOYER_OPTION_XPATH("//a[@role='button'][contains(text(),'Employer')]"),
	;
		
	private final String value;
	TransactionsPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;


public enum QuotesPageObjectMap {
	//Quotes page
	
	QUOTES_PAGE_QUOTES_IN_NEGOTIATON_ID("negotiate_tab"),
	QUOTES_PAGE_SORT_BY_FILTER_ID("spnt"),
	QUOTES_PAGE_ALL_QUOTES_ID("sent_tab"),
	QUOTES_PAGE_ARCHIVED_QUOTES_TAB_ID("archived_tab"),
	QUOTES_PAGE_MY_QUOTE_TEMPLATES_LEFT_TAB_PLINK("My Quote Templates"),
	QUOTES_PAGE_SEARCH_TEXTBOX_ID("searchText"),
	QUOTES_PAGE_SORT_BY_FILTER_XPATH("//div[@class='module_box box_NoPadding rhythmMargin2']"),
	QUOTES_PAGE_MANAGE_BIDS_PLINK("Manage bids"),
	QUOTES_PAGE_JOB_NAME_XPATH("//a[@class='quoteHeader-identity-link ng-binding']"),
	
	
	
	/*
	QUOTES_PAGE_ALL_QUOTES_LEFT_OPTION_ID("sent_tab"),
	QUOTES_PAGE_LIST_XPATH("//ul[@class='module_list tight ng-scope show']"),
	QUOTES_PAGE_QUOTE_LIST_ELEMENT_XPATH("//li[@ng-repeat='quote in data.quotes']"),
	*/

	//When individual quote is opened	
	QUOTES_PAGE_OPEN_QUOTE_DIV_XPATH("//div[@class='cta']"),
	QUOTES_PAGE_OPEN_QUOTE_BACK_BUTTON_XPATH("//a[@ng-click='switchTab(filter);']"),	
	QUOTES_PAGE_OPEN_QUOTE_ARCHIVE_BUTTON_XPATH("//button[@ng-click='quoteDetails.archive(data.quoteHeader.QuoteID)']"),	
	QUOTES_PAGE_OPEN_QUOTE_MAKE_MY_JOB_BUTTON_XPATH("//button[@data-toggle='makeMyJob']"),
	QUOTES_PAGE_OPEN_QUOTE_MIDDLE_DIV_XPATH("//div[@class='module_box box_NoPadding rhythmMargin qDetail']"),
	QUOTES_PAGE_OPEN_QUOTE_AGREEMENT_DIV_XPATH("//div[@class='qDetail-agreement-data ng-scope']"),
	QUOTES_PAGE_OPEN_QUOTE_EDIT_QUOTE_BUTTON_XPATH("//a[@class='module_btn primary_btn lonely_btn ng-scope'][contains(text(), 'Edit Quote')]"),
	QUOTES_PAGE_OPEN_QUOTE_HIDE_QUOTE_PLINK("Hide Quote"),
	QUOTES_PAGE_MESSAGE_THREAD_LIST_XPATH("//ul[@class='projMsg-thread module_list tight']"),
	QUOTES_PAGE_MESSAGE_TEXT_ELEMENT_XPATH("//pre[@class='projMsg-thread-message ng-binding']"),
	;


	private final String value;
	QuotesPageObjectMap(final String value) {
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

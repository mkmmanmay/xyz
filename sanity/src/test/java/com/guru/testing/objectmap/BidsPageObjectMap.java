package com.guru.testing.objectmap;

public enum BidsPageObjectMap {
	
	BIDS_PAGE_MIDDLE_DIV_ID("bidOvw"),
	BIDS_PAGE_TOTAL_BIDS_AVAILABLE_ID("totalBids"),
	BIDS_PAGE_BUY_MORE_BIDS_BUTTON_ID("addBids"),
	BIDS_PAGE_BID_PLANS_PANEL_ID("bidPlan"),
	BIDS_PAGE_BID_PLANS_PANEL_ADD_BIDS_BUTTON_ID("addBidbtn"),
	BIDS_PAGE_BID_USAGE_PANEL_ID("chartContainerbid"),
	BIDS_PAGE_SUMMARY_PANEL_XPATH("//ul[@class='clearfix bidStats']"),
	BIDS_PAGE_PAYMENT_NAVIGATION_TAB_ID("ctl00_ctl00_ctl10_navPaymentsBtn"),
	BIDS_PAGE_VIEW_LAST_100_BIDS_LINK_ID("showBidHistory"),
	
	
	;
	
	private final String value;
	BidsPageObjectMap(final String value) {
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

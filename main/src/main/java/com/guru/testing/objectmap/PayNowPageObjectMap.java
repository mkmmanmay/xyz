package com.guru.testing.objectmap;

public enum PayNowPageObjectMap {
	
	PAY_NOW_PAGE_DIV_XPATH("//div[@class='hasAnimation hasFade in']"),
	PAY_NOW_PAGE_PAYMENT_RECEIPT_DIV_XPATH("//div[@class='layout-right-aside hasAnimation hasTransform hasFade in']"),
	PAY_NOW_PAGE_AUTO_RENEWAL_HELP_NAV_PLINK("auto-renewal"),
	PAY_NOW_PAGE_TERMS_AND_CONDITIONS_HELP_NAV_PLINK("terms and conditions"),
	PAY_NOW_PAGE_AUTO_RENEW_ONE_CHECKBOX_ID("autoRenew1"),
	PAY_NOW_PAGE_AUTO_RENEW_CHECKBOX_ID("autoRenew"),
	PAY_NOW_PAGE_AGREE_TO_PAY_CHECKBOX_ID("iagree"),
	PAY_NOW_PAGE_USE_CASH_ACCOUNT_XPATH("//a[contains(text(), 'Use')]"),
	PAY_NOW_PAGE_AMERICAN_EXPRESS_LOGO_XPATH("//img[@alt='American Express']"),
	PAY_NOW_PAGE_CASH_ACCOUNT_LOGO_XPATH("//img[@class='paymethodSprite sprite_large cashaccount_large']"),
	PAY_NOW_PAGE_SELECT_PAYMENT_METHOD_AREA_XPATH("//h2[@class='secondaryHeading ng-binding']"),
	PAY_NOW_PAGE_PAY_BUTTON_DISABLED_XPATH("//button[@class='module_btn primary_btn payBtn ng-binding'][@disabled='disabled']"),
	PAY_NOW_PAGE_PAY_BUTTON_ENABLED_XPATH("//button[@class='module_btn primary_btn payBtn ng-binding']"),
	PAY_NOW_PAGE_PRINT_RECEIPT_PLINK("Print receipt"),
	PAY_NOW_PAGE_BACK_TO_MEMBERSHIP_PAGE_PLINK("Back to Membership page"),
	PAY_NOW_PAGE_PAY_WITH_CREDIT_CARD_BUTTON_XPATH("//label[@for='paywithcc']"),
	
	
	// --------- BIDS PURCHASE CONFIRMATION PAGE ----------
	
	PAY_NOW_PAGE_PAYMENT_RECEIPT_BACK_TO_BIDS_PAGE_PLINK("Back to bids page"),
	PAY_NOW_PAGE_PAYMENT_TRANSACTION_ID_TEXT_XPATH("//p[contains(text(), 'Transaction ID:')]"),
	PAY_NOW_PAGE_PAYMENT_BIDS_ITEM_DESCRIPTION_XPATH("//table[@class='module_table rhythmMargin greyTop']//tbody[2]//tr[1]//td[1]"),
	
	// ------ JOB POSTED CONFIRMATION PAGE ----------------
	
	PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_GURU_RECOMMENDED_PLINK("Guru Recommended."),
	PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_PAYMENT_RECEIPT_PLINK("payment receipt"),
	PAY_NOW_PAGE_JOB_POSTED_CONFIRMATION_SEARCH_AND_INVITE_GURUS_BUTTON_XPATH("//a[@class='module_btn secondary_btn']"),
	
	// ---------------- SAFEPAY CONFIRMATION PAGE -----------------
	PAY_NOW_PAGE_SAFEPAY_FUNDED_SUCCESS_PAGE_BACK_TO_SAFEPAY_PAGE_PLINK("Back to SafePay page"),
	PAY_NOW_PAGE_SAFEPAY_FUNDED_SUCCESS_PAGE_THANK_YOU_STATEMENT_CONTAINER_XPATH("//p[@class='copy']"),
	
	// ---------- INVOICE PAYMENT --------------------------
	PAY_NOW_PAGE_INVOICE_PAYMENT_CHECKBOX_RELATED_TEXT_CONTAINER_XPATH("//div[@class='iagreeBox module_box invalid']"), // 'invalid' when checkbox isn't ticked.
	PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_TEXTBOX_XPATH("//input[@class='niceInput prepend amount cashLdInput ng-pristine ng-valid']"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_SAFEPAY_FUNDS_BLANK_TEXTBOX_XPATH("//input[@class='niceInput prepend amount cashLdInput ng-valid ng-dirty']"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_SUCCESS_PAGE_BACK_TO_MANAGE_INVOICE_PAGE_PLINK("Back to Manage Invoice"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_TEXTBOX_XPATH("//input[@class='ng-pristine ng-valid niceInput prepend amount cashLdInput']"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_CASH_ACCOUNT_FUNDS_BLANK_TEXTBOX_XPATH("//input[@class='ng-valid niceInput prepend amount cashLdInput ng-dirty']"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_SELECT_PAYMENT_METHOD_CHANGE_BUTTON_XPATH("//a[contains(text(), 'Change')]"),
	PAY_NOW_PAGE_INVOICE_PAYMENT_CANCEL_BUTTON_AFTER_CLICKING_CHANGE_XPATH("//button[contains(text(), 'Cancel')]"),
	
	// ------------------ SELECT A PAYMENT METHOD ---------------
	PAY_NOW_PAGE_SELECT_A_PAYMENT_SELECTED_METHOD_NAME_XPATH("//div[@class='module_avatar ng-scope']//p[@class='identityName ng-binding']"),
	PAY_NOW_PAGE_SELECT_YOUR_PAYMENT_METHOD_CONTAINER_APPEARING_ON_CLICKING_CHANGE_XPATH("//div[@class='form-control-group hasAnimation hasTransform hasFade in']"),
	PAY_NOW_PAGE_PAYMENT_METHOD_ROWS_APPEARING_ON_CLICKING_CHANGE_XPATH("//li[@class='clearfix ng-scope']"),
	PAY_NOW_PAGE_PAYMENT_METHOD_SELECT_BUTTONS_XPATH("//li[@class='clearfix ng-scope']//button[@class='pull-right module_btn primary_btn ng-scope']"),
	
	
	;
	
	
	private final String value;
	PayNowPageObjectMap(final String value) {
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

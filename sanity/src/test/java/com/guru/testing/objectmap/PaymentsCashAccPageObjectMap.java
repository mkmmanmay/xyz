package com.guru.testing.objectmap;

public enum PaymentsCashAccPageObjectMap {
	
	PAYMENTS_PAGE_CASH_ACCOUNT_WITHDRAW_BUTTON_XPATH("//button[@class='module_btn secondary_btn']"),
	PAYMENTS_PAGE_CASH_ACCOUNT_DESCRIPTION_ROW1_XPATH("(//table[@id='cashHistory']//tbody[2]//tr//td[@width='70%'])[1]"),
	PAYMENTS_PAGE_CASH_ACCOUNT_DESCRIPTION_ROW2_XPATH("(//table[@id='cashHistory']//tbody[2]//tr//td[@width='70%'])[2]"),
	;
	
	private final String value;
	PaymentsCashAccPageObjectMap(final String value) {
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

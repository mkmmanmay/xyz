package com.guru.testing.objectmap;

public enum CashAccPageObjectMap {
	
	CASH_ACCOUNT_PAGE_WITHDRAW_BUTTON_XPATH("//button[@class='module_btn secondary_btn']"),
	CASH_ACCOUNT_PAGE_DESCRIPTION_ROW1_XPATH("(//table[@id='cashHistory']//tbody[2]//tr[1]//td[@width='60%'])[1]"),
	CASH_ACCOUNT_PAGE_DESCRIPTION_ROW2_XPATH("(//table[@id='cashHistory']//tbody[2]//tr[2]//td[@width='60%'])[1]"),
	;
	
	private final String value;
	CashAccPageObjectMap(final String value) {
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

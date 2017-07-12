package com.guru.testing.objectmap;

public enum CashAccPageObjectMap {
	
	CASH_ACCOUNT_PAGE_WITHDRAW_BUTTON_XPATH("//button[@class='module_btn secondary_btn']"),
	CASH_ACCOUNT_PAGE_DESCRIPTION_ROW1_XPATH("(//table[@id='cashHistory']//tbody[2]//tr[1]//td[@width='60%'])[1]"),
	CASH_ACCOUNT_PAGE_DESCRIPTION_ROW2_XPATH("(//table[@id='cashHistory']//tbody[2]//tr[2]//td[@width='60%'])[1]"),
	CASH_ACCOUNT_PAGE_CASH_ACCOUNT_BALANCE_DIV_XPATH("//div[@class='pull-right-absolute']//span[@class='ng-binding']"),
	
	//Withdraw amount from cash account
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_DIV_XPATH("//div[@class='modal-content ng-scope']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TABLE_XPATH("//table[@class='module_table rhythmMargin lined tight ng-scope']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_AMOUNT_COLUMN_NAME_XPATH("//label[contains(text(), 'Amount')]"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_SEND_TO_COLUMN_NAME_XPATH("//label[contains(text(), 'Send To')]"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAWAL_FEE_COLUMN_NAME_XPATH("//label[contains(text(), 'Withdrawal fee')]"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAW_BUTTON_XPATH("//button[@class='module_btn primary_btn ng-binding']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHDRAW_BUTTON_DISABLED_XPATH("//button[@class='module_btn primary_btn ng-binding'][@disabled='disabled']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_CANCEL_BUTTON_XPATH("//button[@ng-click='cancel()'][@class='module_btn secondary_btn']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_CLOSE_ICON_XPATH("//button[@ng-click='cancel()'][@class='close']"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_TITLE_ID("addWorkLabel"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_WITHRAW_TO_ANOTHER_ACCOUNT_PLINK("+ Withdraw to another account"),
	CASH_ACCOUNT_PAGE_WITHDRAW_POP_UP_SEND_TO_DROPDOWN_XPATH("//select[@ng-model='withdraw.destination']"),
	
	// ------------- EMP CASH ACCOUNT -----------------
	CASH_ACCOUNT_PAGE_EMP_TYPE_DROPDOWN_XPATH("(//a[@class='dropToggle']//span[contains(@class, 'active')])[1]"),
	CASH_ACCOUNT_PAGE_EMP_DATE_DROPDOWN_XPATH("(//a[@class='dropToggle']//span[contains(@class, 'active')])[2]"),
	CASH_ACCOUNT_PAGE_EMP_ADD_FUNDS_BUTTON_XPATH("//button[contains(text(), ' Add Funds ')]"),
	CASH_ACCOUNT_PAGE_EMP_BALANCE_TEXT_XPATH("//div[@class='pull-right-absolute']//span"),
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

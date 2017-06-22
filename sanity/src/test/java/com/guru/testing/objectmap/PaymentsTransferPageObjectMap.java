package com.guru.testing.objectmap;

public enum PaymentsTransferPageObjectMap {
	
	PAYMENTS_PAGE_TRANSFER_METHODS_REMOVE_LINK_XPATH("//a[contains(text(), 'Remove')]"),
	PAYMENTS_PAGE_TRANSFER_METHODS_CONFIRM_REMOVE_XPATH("//input[@value='Remove Transfer Method']"),
	PAYMENTS_PAGE_TRANSFER_METHODS_METHODS_LIST_XPATH("(//ul[@class='paymethods'])[3]"),
	
	;
	
	private final String value;
	PaymentsTransferPageObjectMap(final String value) {
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

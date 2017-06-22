package com.guru.testing.objectmap;

public enum EMPPaymentPageObjectMap {
	
	EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_XPATH("//div[@ng-app='guruPaymentMethods']"),
	EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_METHODS_EMP_CAN_ADD_XPATH("//ul[@class='module_list tight']//li"),
	EMP_PAYMENT_METHOD_PAGE_PAYMENT_CONTAINER_LIST_OF_PAYMENT_METHODS_ADDED_XPATH("//ul[@class='paymethods']//li[contains(@class, 'method')]"),
	EMP_PAYMENT_METHOD_PAGE_ADD_PAYMENT_METHOD_DROPDOWN_XPATH("//button[contains(text(), 'Add Payment Method')]"),
	;
	private final String value;
	EMPPaymentPageObjectMap(final String value) {
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

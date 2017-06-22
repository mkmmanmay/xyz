package com.guru.testing.constants;

public enum PaymentTransferMethods {
	CASH_ACCOUNT("Cash Account"),
	AMERICAN_EXPRESS("American Express"),
	CREDIT_CARD("Credit Card"),
	BANK_ACCOUNT("Bank Account"),
	WIRE_TRANSFER("Wire Transfer"),
	PAY_PAL("PayPal"),
	SAFEPAY("SafePay"),
	E_CHECK("E-check"),
	CHECK("Check"),

	
	;

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private PaymentTransferMethods(String value) {
		this.value=value;
	}
	
}

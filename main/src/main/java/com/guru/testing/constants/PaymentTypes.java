package com.guru.testing.constants;

public enum PaymentTypes {
	
	
	ALL("All"),
	CHECK("Check"),
	CREDIT_CARD("Credit Card"),
	E_CHECK("E-Check"),
	WIRE_TRANSFER("Wire Transfer"),
	CASH_ACCOUNT("Cash Account"),
	SAFEPAY_FUND("SafePay Fund"),
	PAYPAL("PayPal"),
	
	;
	private String value;
	
	public String getValue() {
		return value;
	}
	private PaymentTypes(String value) {
		this.value=value;
	}
	
}

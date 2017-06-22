package com.guru.testing.constants;

public enum SafepayAutopayOptions {
	FUND_NEXT_MILESTONE_AND_ENABLE_AUTOPAY("Fund next milestone & enable autopay"),
	AUTOPAY_ONLY("Autopay only"),
	MANUAL_PAYMENTS("Manual payments");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private SafepayAutopayOptions(String value) {
		this.value=value;
	}
	
	

}

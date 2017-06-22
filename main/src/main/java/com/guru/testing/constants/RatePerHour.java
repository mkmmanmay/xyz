package com.guru.testing.constants;

public enum RatePerHour {
	
	ANY_RATE("Any Rate"),
	RATE_0_TO_25_DOLLARS("$0 - $25"),
	RATE_25_TO_50_DOLLARS("$25 - $50"),
	RATE_50_TO_100_DOLLARS("$50 - $100"),
	RATE_100_TO_200_DOLLARS("$100 - $200"),
	RATE_200_DOLLARS_PLUS("$200+");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private RatePerHour(String value) {
		this.value=value;
	}
	
	

}

package com.guru.testing.constants;

public enum Reviews {
	ANY_REVIEWS("Any Reviews"),
	REVIEWS_3_PLUS("3+ Reviews"),
	REVIEWS_10_PLUS("10+ Reviews"),
	REVIEWS_20_PLUS("20+ Reviews"),
	REVIEWS_50_PLUS("50+ Reviews");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private Reviews(String value) {
		this.value=value;
	}
	
	

}

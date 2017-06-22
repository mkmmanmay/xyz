package com.guru.testing.constants;

public enum FeedbackStarRating {
	ANY_STAR_RATINGS("Any Star Ratings"),
	STAR_5("5 Stars"),
	STAR_4_PLUS("4+ Stars"),
	STAR_3_PLUS("3+ Stars");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private FeedbackStarRating(String value) {
		this.value=value;
	}
	
	

}

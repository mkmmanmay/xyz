package com.guru.testing.constants;

public enum SortOptionsFindGurus {
	RELEVANCE("Relevance"),
	TOTAL_EARNINGS_HIGHEST_FIRST("Total Earnings - Highest First"),
	REVIEW_HIGHEST_FIRST("Reviews - Highest First"),
	RATE_HIGHEST_FIRST("Rate - Highest First"),
	RATE_LOWEST_FIRST("Rate - Lowest First"),
	BUDGET_LOWEST_FIRST("Budget - Lowest First"),
	BUDGET_HIGHEST_FIRST("Budget - Highest First");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private SortOptionsFindGurus(String value) {
		this.value=value;
	}
	
	

}

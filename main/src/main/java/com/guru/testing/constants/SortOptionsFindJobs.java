package com.guru.testing.constants;

public enum SortOptionsFindJobs {
	
	NEWEST("Newest"),
	OLDEST("Oldest"),
	EXPIRING_SOON("Expiring Soon"),
	BUDGET_HIGHEST_FIRST("Budget – Highest First"),
	BUDGET_LOWEST_FIRST("Budget – Lowest First"),
	HOURLY_RATE_HIGHEST_FIRST("Hourly Rate – Highest First"),
	HOURLY_RATE_LOWEST_FIRST("Hourly Rate – Lowest First")
	
	;

	private String value;
	
	public String getValue() {
		return value;
	}
	private SortOptionsFindJobs(String value) {
		this.value=value;
	}
	
	
}

package com.guru.testing.constants;

public enum SavedSearches {
	
	SELECT_ONE("Select One");
	
	private String value;
	
	public String getValue() {
		return value;
	}
	private SavedSearches(String value) {
		this.value=value;
	}
}

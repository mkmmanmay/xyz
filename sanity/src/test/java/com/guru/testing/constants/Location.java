package com.guru.testing.constants;

public enum Location {
	
	ANY_LOCATION("Any Location"),
	CITY_STATE("City, State"),
	ZIP("ZIP"),
	COUNTRY("Country"),
	REGION("Region");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private Location(String value) {
		this.value=value;
	}
	
	

}

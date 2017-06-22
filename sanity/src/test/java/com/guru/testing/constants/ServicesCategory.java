package com.guru.testing.constants;

public enum ServicesCategory {
	CATEGORY("Category"),
	ANY_CATEGORY("Any Category"),	
	ADMIN_SUPPORT("Admin Support"),
	DESIGN_ART_MULTIMEDIA("Design, Art & Multimedia"),
	ENGINEERING_AND_ARCHITECTURE("Engineering & Architecture"),
	LEGAL("Legal"),
	MANAGEMENT_AND_FINANCE("Management & Finance"),
	OTHER("Other"),
	SALES_AND_MARKETING("Sales & Marketing"),
	WEB_SOFTWARE_AND_IT("Web, Software & IT"),
	WRITING_AND_TRANSLATION("Writing & Translation");

	
	private String value;
	
	public String getValue() {
		return value;
	}
	private ServicesCategory(String value) {
		this.value=value;
	}
	
}

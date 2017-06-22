package com.guru.testing.objectmap;

public enum JobsPageObjectMap {
	
	JOBS_PAGE_RESULTS_CONTROL_TAB_XPATH("//div[@class='module_pageControls']"),
	JOBS_PAGE_JOB_NAME_XPATH("//a[@class='ng-scope ng-binding']"),
	
	;


	private final String value;
	JobsPageObjectMap(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}

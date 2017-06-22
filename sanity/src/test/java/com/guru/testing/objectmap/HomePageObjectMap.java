package com.guru.testing.objectmap;

public enum HomePageObjectMap {

	
	HOME_PAGE_POST_A_JOB_TOP_NAV_BUTTON_ID("topnav-postjob"),
	HOME_PAGE_FIND_A_GURU_TOP_NAV_BUTTON_ID("topnav-findservices"),	
	HOME_PAGE_SIGN_IN_TOP_NAV_BUTTON_PLINK("Sign in"),
	HOME_PAGE_FIND_A_JOB_TOP_NAV_BUTTON_ID("topnav-findjobs"),
	;
	
	
	 private final String value;   
    
    HomePageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum AdminPayrollSummaryPageObjectMap {
	
	ADMIN_PAYROLL_SUMMARY_PAGE_DIRECT_DEPOSIT_LINK_PLINK("Direct Deposit"),
	ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_BUTTON_XPATH("//input[@value='Generate CSV']"),
	ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_SUCCESS_DOWNLOAD_FILE_LINK_PLINK("Download the file!"),
	ADMIN_PAYROLL_SUMMARY_PAGE_GENERATE_CSV_SUCCESS_BACK_TO_DIRECT_DEPOSIT_LINK_PLINK("Back to Direct Deposit List"),
	;
	private final String value;
	AdminPayrollSummaryPageObjectMap(final String value) {
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

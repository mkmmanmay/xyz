package com.guru.testing.constants;

public enum ApprovePaymentTypes {
	INVOICE("Invoice"),
	SAFEPAY("Safepay"),
	CASH_ACCOUNT("Cash Account"),
	FEATURED_JOB("Featured Job"),
	MEMBERSHIP("Membership"),
	SKILL_TEST("Skill Test"),
	BID_PAX("Bid Pax"),
	CASH_ACCOUNT_EMP("Cash Account (Employer)"),
	CASH_ACCOUNT_FL("Cash Account (Freelancer)"),
	
	;
	private String value;
	
	public String getValue() {
		return value;
	}
	private ApprovePaymentTypes(String value) {
		this.value=value;
	}
	
}

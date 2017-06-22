package com.guru.testing.objectmap;

public enum EmailPageObjectMap {
	
	// -------------- MAILINATOR RELATED ---------------
	EMAIL_PAGE_MAILINATOR_INBOX_FIELD_ID("inboxfield"),
	EMAIL_PAGE_MAILINATOR_GO_BUTTON_XPATH("//button[contains(text(), 'Go!')]"),
	EMAIL_PAGE_MAILINATOR_INBOX_ODD_ROW_XPATH("//div[contains(@class, 'oddrow_public')]//div[@class='innermail ng-binding']"),
	EMAIL_PAGE_MAILINATOR_INBOX_EVEN_ROW_XPATH("//div[contains(@class, 'evenrow1')]//div[@class='innermail ng-binding']"),
	EMAIL_PAGE_MAILINATOR_INBOX_YOURE_INVITED_EMAIL_ACCEPT_BUTTON_XPATH("//a[contains(text(), ' Accept ')]"),
	;
	
	
	private final String value;
	EmailPageObjectMap(final String value) {
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

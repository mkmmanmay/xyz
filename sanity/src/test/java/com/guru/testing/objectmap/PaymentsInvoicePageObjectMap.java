package com.guru.testing.objectmap;

public enum PaymentsInvoicePageObjectMap {
	
	PAYMENTS_INVOICE_PAGE_INVOICE_TAB_PLINK("Invoices"),
	PAYMENTS_INVOICE_PAGE_INVOICE_BODY_ID("manageInvoice"),
	PAYMENTS_INVOICE_PAGE_FEEDBACK_TAB_PLINK("Feedback"),
	PAYMENTS_INVOICE_PAGE_PAYMENT_METHODS_TAB_PLINK("Payment Methods"),
	PAYMENTS_INVOICE_PAGE_CASH_ACCOUNT_PLINK("Cash Account"),
	PAYMENTS_INVOICE_PAGE_TRANSACTION_REPORTS_PLINK("Transaction Reports"),
	PAYMENTS_INVOICE_PAGE_1099_REPORTS_PLINK("1099 Reports"),
	PAYMENTS_INVOICE_PAGE_INVOICE_TABLE_ID("invoiceList");	

	
	private final String value;
	PaymentsInvoicePageObjectMap(final String value) {
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

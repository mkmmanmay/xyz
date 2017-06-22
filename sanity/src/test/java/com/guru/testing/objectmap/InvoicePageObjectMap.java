package com.guru.testing.objectmap;

public enum InvoicePageObjectMap {
	
	INVOICE_PAGE_INVOICE_TAB_PLINK("Invoices"),
	INVOICE_PAGE_INVOICE_SECTION_BODY_ID("manageInvoice"),
	INVOICE_PAGE_FEEDBACK_TAB_PLINK("Feedback"), 
	INVOICE_PAGE_CASH_ACCOUNT_PLINK("Cash Account"), 
	INVOICE_PAGE_INVOICE_TABLE_ID("invoiceList"),
	INVOICE_PAGE_EMP_TRANSACTION_REPORTS_TAB_PLINK("Transaction Reports"),
	INVOICE_PAGE_EMP_1099_REPORTS_TAB_PLINK("1099 Reports"),
	INVOICE_PAGE_EMP_PAYMENT_METHODS_TAB_PLINK("Payment Methods"),
	INVOICE_PAGE_FL_TRANSFER_METHODS_TAB_PLINK("Transfer Methods"),
	INVOICE_PAGE_FL_1099_TAX_FORM_TAB_PLINK("1099 Tax Forms"),
	INVOICE_PAGE_FL_TRANSACTION_TAB_PLINK("Transactions"),
	
	// -------- VIEW & PAY --------
	
	INVOICE_PAGE_FIRST_VIEW_AND_PAY_XPATH("(//table[@id='invoiceList']//a[@class=' module_btn secondary_btn'])[1]"),
	INVOICE_PAGE_SECOND_VIEW_AND_PAY_XPATH("(//table[@id='invoiceList']//a[@class=' module_btn secondary_btn'])[2]"),
	INVOICE_PAGE_THIRD_VIEW_AND_PAY_XPATH("(//table[@id='invoiceList']//a[@class=' module_btn secondary_btn'])[3]"),
	
	// ----------- INVOICE DETAILS --------------
	INVOICE_PAGE_INVOICE_DETAILS_BODY_XPATH("//div[@class='an-invoice module_box customInvoice']"),
	INVOICE_PAGE_INVOICE_DETAILS_BACK_TO_ALL_INVOICES_TOGGLE_XPATH("//a[@class='module_btn secondary_btn cta']"),
	INVOICE_PAGE_INVOICE_DETAILS_DISPUTE_BUTTON_XPATH("//button[contains(text(), 'Dispute')]"),
	INVOICE_PAGE_INVOICE_DETAILS_PRINT_BUTTON_XPATH("//button[contains(text(), 'Print')]"),
	INVOICE_PAGE_INVOICE_DETAILS_PAY_INVOICE_BUTTON_XPATH("//button[contains(text(), 'Pay Invoice')]"),
	INVOICE_PAGE_INVOICE_DETAILS_INVOICE_TOTAL_AMOUNT_XPATH("//li[@class='grandTotal']//div[@id='txtInvoiceTotalView']"),
	
	// ------------------ SEND INVOICE ----------
	INVOICE_PAGE_CREATE_INVOICE_INVOICE_BUILDER_SECTION_ID("invoiceBuilder"),
	INVOICE_PAGE_CREATE_INVOICE_INVOICE_CALCULATION_ID("totalCalculation1"),
	INVOICE_PAGE_CREATE_INVOICE_INVOICE_DETAILS_TOTAL_ID("txtInvoiceTotal"),
	INVOICE_PAGE_CREATE_INVOICE_WHAT_KIND_OF_JOB_IS_THIS_DROPDOWN_SELECT_XPATH("//select[contains(@id, 'ddlInvocieCategory_Select')]"),
	INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_BUTTON_XPATH("//a[contains(text(), 'Preview Invoice')]"),
	INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_PREVIEW_HEADER_ID("previewHeader"),
	INVOICE_PAGE_CREATE_INVOICE_PREVIEW_INVOICE_SEND_INVOICE_BUTTON_ID("SendInvoiceMS"),
	
	;	

	
	private final String value;
	InvoicePageObjectMap(final String value) {
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

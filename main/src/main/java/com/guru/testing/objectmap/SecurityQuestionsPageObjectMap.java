package com.guru.testing.objectmap;

public enum SecurityQuestionsPageObjectMap {
	
	SECURITY_QUESTIONS_PAGE_TEST1_TEXT_XPATH("//label[contains(text(),'test1')]"),
	SECURITY_QUESTIONS_PAGE_TEST2_TEXT_XPATH("//label[contains(text(),'test2')]"),
	SECURITY_QUESTIONS_PAGE_TEST3_TEXT_XPATH("//label[contains(text(),'test3')]"),
	SECURITY_QUESTIONS_PAGE_QUESTION_DIV_XPATH("//div[@class='SeqQuestion']"),
	SECURITY_QUESTIONS_PAGE_CONTINUE_BUTTON_ID("ctl00_ContentPlaceHolder1_ucSqAnswer_btnSave_btnSave_Button"),
	SECURITY_QUESTIONS_PAGE_SKIP_THIS_FOR_NOW_LINK_ID("ctl00_ContentPlaceHolder1_ucSq_aSkip"),
	SECURITY_QUESTIONS_PAGE_QUESTION2_LABEL_XPATH("//div[@class='control-group clearfix']//label[contains(text(),'Question #2')]"),
	SECURITY_QUESTIONS_PAGE_ANSWER_SECURITY_QUESTION_VALID_TEXTBOX_NAME("ctl00$ContentPlaceHolder1$ucSqAnswer$txtAns1$txtAns1_TextBox"),
	SECURITY_QUESTIONS_PAGE_REMEMBER_THIS_COMPUTER_CHECKBOX_ID("ctl00_ContentPlaceHolder1_ucSqAnswer_chkRem_chkRem_CheckBox");

	
	private final String value;
	SecurityQuestionsPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum JobDetailsPageObjectMap {
	
	JOB_DETAILS_PAGE_JOB_DETAILS_TEXT_XPATH("//h2[contains(text(), 'Job Details')]"),
	
	JOB_DETAILS_PAGE_SIMILAR_JOBS_HEADER_TEXT_XPATH("//p[contains(text(), 'Similar Jobs')]"),
	JOB_DETAILS_PAGE_SHARE_THIS_JOB_HEADER_TEXT_XPATH("//p[contains(text(), 'Share This Job')]"),

	JOB_DETAILS_PAGE_MILESTONE1_AMOUNT_TEXTBOX_XPATH("//input[@class='ng-pristine ng-valid niceInput prepend amount']"),
	JOB_DETAILS_PAGE_APPLY_BUTTON_XPATH("//button[contains(text(), 'Apply')]"),		
	JOB_DETAILS_PAGE_PROPOSAL_SENT_SECTION_BOX_XPATH("//section[@class='proposalSent rhythmMargin']"),
	
	JOB_DETAILS_PAGE_APPLY_FORM_ADD_ANOTHER_RECURRING_PAYMENT_ID("createnewschedule"),
	
	//Attach Files modal window

	JOB_DETAILS_PAGE_AUTOMATICALLY_ACCEPT_IF_HIRED_BEFORE_TEXT_XPATH("//header[contains(text(), 'Automatically accept if hired before:')]"),
	JOB_DETAILS_PAGE_SCOPE_OF_WORK_HEADER_TEXT_XPATH("//header[@class='cpsection-title clearfix']"),
	JOB_DETAILS_PAGE_UPGRADE_MEMBERSHIP_TO_SEND_PREMIUM_QUOTE_TEXT_XPATH("//header[contains(text(), 'Upgrade Membership to Send a Premium Quote')]"),
	JOB_DETAILS_PAGE_FUND_NEXT_MILESTONE_TEXT_XPATH("//span[contains(text(), 'Fund next milestone & enable autopay')]"),
	JOB_DETAILS_PAGE_AUTOPAY_ONLY_RADIO_BUTTON_XPATH("//label[@for='spAutoPayOnly']"),
	JOB_DETAILS_PAGE_MANUAL_PAYMENTS_RADIO_BUTTON_XPATH("//label[@for='spNo']"),

	
	//Apply Job form
	
	JOB_DETAILS_PAGE_APPLY_JOB_FUND_NEXT_MILESTONE_ENABLE_AUTOPAY_ID("spBoth"),
	JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_ID("spAutoPayOnly"),
	JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_ID("spNo"),	
	
	JOB_DETAILS_PAGE_NO_MATCHING_SKILLS_TEXT_HEADER_XPATH("//header[contains(text(), 'No Matching Skills Found')]"),
	JOB_DETAILS_PAGE_MATCHING_SKILLS_TEXT_HEADER_XPATH("//header[contains(text(), 'Matching Skills')]"),

	
	JOB_DETAILS_PAGE_JOB_TITLE_ID("ctl00_guB_hTitleAndAddtoWatchSec"),
	JOB_DETAILS_PAGE_FAVORITE_HEART_ICON_ID("ctl00_guB_iconHeart"),
	JOB_DETAILS_PAGE_BACK_TO_SEARCH_LINK_ID("ctl00_guB_lnkGoBackTip"),	
	JOB_DETAILS_PAGE_BACK_TO_SEARCH_REFINEMENT_SUBLINK_ID("ctl00_guB_lnkcatSearchUrl"),
		
	JOB_DETAILS_PAGE_EXPIRES_ON_ID("ctl00_guB_divDuratoinLeft"),
	JOB_DETAILS_PAGE_JOB_DETAILS_LEFT_PANE_ID("mainLeft"),
	JOB_DETAILS_PAGE_TOTAL_QUOTES_ID("liTotalProposal"),
	JOB_DETAILS_PAGE_QUOTES_COUNT_TOP_SPAN_ID("snpProposalCount"),
	JOB_DETAILS_PAGE_SKILLS_LIST_ID("ctl00_guB_ucProjectDetail_ulSkills"),
	JOB_DETAILS_PAGE_JOB_DESCRIPTION_XPATH("//section[@itemprop='experienceRequirements']"),
	JOB_DETAILS_PAGE_ASK_QUESTION_DIV_ID("ctl00_guB_ucProjectDetail_divProjQusetionAnswers"),
	JOB_DETAILS_PAGE_ASK_QUESTION_TEXT_AREA_ID("reply"),
	JOB_DETAILS_PAGE_APPLICATION_DETAILS_SECTION_ID("applicantsSec"),
	JOB_DETAILS_PAGE_QUOTES_BOTTOM_SPAN_ID("spnTotalApplicant"),
	JOB_DETAILS_PAGE_QUOTES_COUNT_BOTTOM_SPAN_ID("spnAllPropoCount"),
	JOB_DETAILS_PAGE_PREMIUN_QUOTES_BOTTOM_SPAN_ID("spnPremiumApplicant"),
	JOB_DETAILS_PAGE_PREMIUM_QUOTES_COUNT_BOTTOM_SPAN_ID("spnPremiumPropoCount"),
	JOB_DETAILS_PAGE_INVITED_APPLICANTS_BOTTOM_SPAN_ID("spnInvitedApplicant"),
	JOB_DETAILS_PAGE_INVITED_APPLICANTS_COUNT_BOTTOM_SPAN_ID("spnInvitedCount"),	
	JOB_DETAILS_PAGE_HIRED_COUNT_BOTTOM_SPAN_ID("spnAwardedCount"),
	JOB_DETAILS_PAGE_INVITED_NOT_APPLIED_BOTTOM_SPAN_ID("spnInvitedNotApplied"),
	JOB_DETAILS_PAGE_INVITED_NOT_APPLIED_COUNT_BOTTOM_SPAN_ID("spnInvitedNtAppCount"),
	JOB_DETAILS_PAGE_REPORT_PROJECT_ID("ctl00_guB_ucProjectDetail_dvlinkReportProject"),
	JOB_DETAILS_PAGE_APPLY_NOW_SECTION_ID("ctl00_guB_submitContainer"),
	JOB_DETAILS_PAGE_YOUR_PROFILE_PLINK("your profile"),
	JOB_DETAILS_PAGE_SERVICES_AND_WORK_COLLECTION_PLINK("services and work collections"),
	JOB_DETAILS_PAGE_APPLY_BUTTON_ID("ctl00_guB_btnSubmit"),
	JOB_DETAILS_PAGE_EMPLOYER_STATS_DIV_ID("empStats"),
	JOB_DETAILS_PAGE_EMPLOYER_AVATAR_ID("ctl00_guB_dvEmployerImage"),
	JOB_DETAILS_PAGE_EMPLOYER_NAME_XPATH("//h3[@class='identityName']"),
	JOB_DETAILS_PAGE_EMPLOYER_LOCATION_ID("ctl00_guB_divEmpLoc"),
	JOB_DETAILS_PAGE_SIMILAR_JOBS_SECTION_ID("similarProjects"),
	JOB_DETAILS_PAGE_SHARE_LINK_SECTION_ID("shareIt"),
	JOB_DETAILS_PAGE_TINY_URL_ID("url"),
	JOB_DETAILS_PAGE_NEXT_JOB_NAVIGATOR_ID("lnkNextNav"),
	JOB_DETAILS_PAGE_ACCEPT_MANUALLY_RADIO_BUTTON_ID("manualAcceptRadio"),
	JOB_DETAILS_PAGE_I_WILL_BILL_MY_EMPLOYER_DROPDOWN_XPATH("//div[@class='cpsection first']//select[@class='niceInput auto ng-pristine ng-valid']"),
	
	JOB_DETAILS_PAGE_MILESTONE1_TEXTBOX_ID("milestoneNameInput0"),
	JOB_DETAILS_PAGE_MILESTONE1_DUE_DATE_TEXTBOX_ID("blurMileStoneDate"),
	JOB_DETAILS_PAGE_MILESTONE1_DUE_DATE_POP_UP_LAST_DATE_XPATH("//div[@class='msFormatDate']//ul//table//tbody//tr[6]//td[8]"),
	
	
	 JOB_DETAILS_PAGE_CHOOSE_YOUR_SAFEPAY_TEXT_XPATH("//h3[contains(text(), 'Choose your SafePay and autopay requirements below.')]"),
	 
	 JOB_DETAILS_PAGE_EMPLOYER_INFO_DIV_ID("empStats"),
	
	//Apply Job form
	JOB_DETAILS_PAGE_APPLY_JOB_RIGHT_PANE_ID("mainAside"),
	JOB_DETAILS_PAGE_APPLY_JOB_HELP_QUESTION_BUTTON_ID("helpToggle"),
	JOB_DETAILS_PAGE_APPLY_TYPE_OF_CONTRACT_XPATH("//select[@ng-model='agreementData.jobType']"),
	JOB_DETAILS_PAGE_APPLY_FIRST_MILESTONE_ID("milestoneNameInput0"),
	JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_DUE_DATE_ID("blurMileStoneDate"),
	JOB_DETAILS_PAGE_APPLY_JOB_MILESTONE_AMOUNT_XPATH("//input[@ng-model='milestone.msAmount']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ADD_A_MILESTONE_LINK_ID("createnewmilestone"),	
	JOB_DETAILS_PAGE_APPLY_JOB_FUND_NEXT_MILESTONE_ENABLE_AUTOPAY_RADIO_ID("spBoth"),
	 JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_RADIO_ID("spAutoPayOnly"),
	 JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_ID("spNo"), 
	/*JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_XPATH("//label[@for='spNo']"),
	JOB_DETAILS_PAGE_APPLY_JOB_AUTOPAY_ONLY_RADIO_XPATH("//label[@for='spAutoPayOnly']"),
	JOB_DETAILS_PAGE_APPLY_JOB_MANUAL_PAYMENTS_RADIO_XPATH("//label[@for='spNo']"),*/
	JOB_DETAILS_PAGE_APPLY_JOB_PAYMENT_SCHEDULE_DROPDOWN_XPATH("//select[@ng-model='agreementData.invoiceGrace']"),
	JOB_DETAILS_PAGE_APPLY_JOB_STATUS_UPDATES_DROPDOWN_XPATH("//select[@ng-model='agreementData.statusFreq']"),
	JOB_DETAILS_PAGE_APPLY_JOB_SCOPE_OF_WORK_XPATH("//div[@class='fr-element fr-view']"),
	JOB_DETAILS_PAGE_APPLY_JOB_BOLD_BUTTON_XPATH("//i[@class='fa fa-bold']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ITALIC_BUTTON_XPATH("//i[@class='fa fa-italic']"),
	JOB_DETAILS_PAGE_APPLY_JOB_UNDERLINE_BUTTON_XPATH("//i[@class='fa fa-underline']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_BUTTON_ID("attachBtn"),
	JOB_DETAILS_PAGE_APPLY_JOB_AUTO_ACCEPT_RADIO_BUTTON_ID("autoAcceptRadio"),
	JOB_DETAILS_PAGE_APPLY_JOB_AUTO_ACCEPT_DATE_INPUT_TEXTBOX_ID("autoAcceptDatePick"),
	JOB_DETAILS_PAGE_APPLY_JOB_SEND_PREMIUM_QUOTE_OPTION_SECTION_XPATH("//label[@class='premiumProposal clearfix ng-scope']"),
	JOB_DETAILS_PAGE_APPLY_JOB_UPGRADE_MEMBERSHIP_OPTION_SECTION_XPATH("//div[@class='premiumProposalWrap clearfix disabled  ng-scope']"),
	JOB_DETAILS_PAGE_APPLY_JOB_DATE_PICKER_OPEN_XPATH("//ul[@ng-change='dateSelection()']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ACCEPT_MANUALLY_RADIO_BUTTON_ID("manualAcceptRadio"),
	JOB_DETAILS_PAGE_APPLY_JOB_PREMIUM_QUOTE_CHECKBOX_ID("checkMark2"),
	JOB_DETAILS_PAGE_APPLY_JOB_MATCHING_SKILLS_ICON_XPATH("//div[@class='skillIcon']"),
	JOB_DETAILS_PAGE_APPLY_JOB_SAVE_AS_TEMPLATE_LINK_XPATH("//a[@name='saveAsTemplate']"),
	JOB_DETAILS_PAGE_APPLY_JOB_APPLY_BUTTON_XPATH("//button[@ng-click='submitProposal()']"),
	JOB_DETAILS_PAGE_APPLY_JOB_CANCEL_BUTTON_XPATH("//a[@ng-click='closeSubmitContainer()']"),
	JOB_DETAILS_PAGE_APPLIED_WATCH_FOR_RESPONSES_PLINK("responses"),
	JOB_DETAILS_PAGE_APPLIED_SEND_MESSAGE_TO_EMPLOYER_ID("btnSendMessage"),
	JOB_DETAILS_PAGE_APPLIED_SENT_DATE_TIME_ID("pSentDate"),
	JOB_DETAILS_PAGE_APPLIED_VIEW_QUOTE_LINK_ID("btnToggleProposal"),
	JOB_DETAILS_PAGE_APPLIED_EDIT_QUOTE_BUTTON_ID("edit_btn"),
		
	//Attach Files modal window
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_ID("attachmentsModal"),	
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_ID("computerId"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_PANE_ID("fileupload"),	
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_COMPUTER_TAB_SELECT_FILES_ID("selectFilesCaption"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_ERR_MSG_SPAN_XPATH("//span[@ng-show='isErrorExists']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_FINISHED_BUTTON_XPATH("//input[@value='Finished']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_CANCEL_BUTTON_XPATH("//input[@value='Cancel']"),
	JOB_DETAILS_PAGE_APPLY_JOB_ATTACH_WORK_MODAL_PROGRESS_BAR_XPATH("//div[@role='progressbar']"),
		
	
		;
		
	
	private final String value;
	JobDetailsPageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum WorkroomPageObjectMap {
	
	WORKROOM_PAGE_EMP_JOB_HIRED_GURUS_TAB_XPATH("//a[contains(text(), 'Hired Gurus')]"),
	WORKROOM_PAGE_JOB_PUBLIC_FILES_PLINK("Public Files"),
	WORKROOM_PAGE_JOB_PRIVATE_FILES_PLINK("Private Files"),
	WORKROOM_PAGE_EMP_JOB_ADD_A_MANAGER_PLINK("+ Add a Manager"),
	WORKROOM_PAGE_EMP_JOB_TITLE_XPATH("//div[@class='module_headerCrumb']//h1"),
	WORKROOM_PAGE_EMP_BACK_TO_ALL_HIRED_GURUS_NAVIGATION_AT_TOP_XPATH("//header[@class='module_pageControls']//a[@class='module_btn secondary_btn']"),
	WORKROOM_PAGE_EMP_HIRED_GURU_TILES_IN_WORKROOM_XPATH("//section[@class='left-col']//ul[contains(@class, 'grid_list')]//li"),
	WORKROOM_PAGE_EMP_MESSAGE_ALL_BUTTON_XPATH("//button[@class='module_btn secondary_btn lonely_btn'][contains(text(), ' Message All')]"),
	WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_BUTTON_XPATH("//button[@class='module_btn secondary_btn'][contains(text(), 'Recipients...')]"),
	WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_BUTTON_DROPDOWN_ALL_OPTION_XPATH("//ul[@class='module_list  dropdown-menu tagDropDownList']//li//a"),
	WORKROOM_PAGE_EMP_MESSAGE_ALL_SEND_MESSAGE_POPUP_RECEIPENTS_TOKEN_XPATH("//div[@class='niceInput m-recipients-input ng-scope']//div[contains(@class, 'm-recipients-input-chip')]"),
	WORKROOM_PAGE_FL_JOB_EMPLOYER_TAB_XPATH("//ul[@class='module_tabs']//a[contains(text(), 'Employer')]"),
	WORKROOM_PAGE_JOB_CHATS_TAB_XPATH("//a[contains(text(), 'Chats')]"),
	WORKROOM_PAGE_JOB_TASKS_TAB_XPATH("//a[contains(text(), 'Tasks')]"),
	WORKROOM_PAGE_JOB_FILE_FOLDERS_TAB_XPATH("//a[contains(text(), 'File Folders')]"),
	WORKROOM_PAGE_FL_JOB_TRACK_TIME_TAB_XPATH("//a[contains(text(), 'Track Time')]"),
	WORKROOM_PAGE_FL_JOB_MY_TEAM_TAB_XPATH("//a[contains(text(), 'My Team')]"),
	
	WORKROOM_PAGE_EMP_SAFEPAY_TAB_XPATH("//nav[@class='left-col']//ul//li[3]"),
	
	WORKROOM_PAGE_EMP_LAST_MESSAGE_XPATH("//ul[@id='messages-thread']//li[@class='projMsg-thread-msg ng-scope projMsg-thread-msg_closed projMsg-thread-msg_last']//pre"),
	WORKROOM_PAGE_EMP_MESSAGE_ALL_MESSAGE_SENT_TOAST_MESSAGE_XPATH("//p[@class='module_toast toast_top toast_show'][contains(text(), 'Message sent.')]"),
	//CHATS:-
	WORKROOM_PAGE_CHATS_TAB_XPATH("//a[contains(text(), 'Chats')]"),
	WORKROOM_PAGE_CHATS_PAGE_DIV_XPATH("//div[@class='layout-right-aside layout-right-aside_largeLeft chatPage']"),
	WORKROOM_PAGE_CHATS_PAGE_PARTICIPANTS_LINK_XPATH("//a[@role='combobox']"),
	WORKROOM_PAGE_CHATS_PAGE_CHAT_TEXTAREA__XPATH("//textarea[@title='Press Enter to send your message (Shift+Enter for line break)']"),
	WORKROOM_PAGE_CHATS_PAGE_ATTACH_FILES_BUTTON_ID("attachBtn"),
	WORKROOM_PAGE_CHATS_PAGE_SEND_CHAT_BUTTON_XPATH("//i[@title='Send']"),
	WORKROOM_PAGE_CHATS_PAGE_RECIEVING_NOTIFICATION_CHECKBOX_ID("notification"),
	WORKROOM_PAGE_CHATS_PAGE_RIGHT_PANE_XPATH("//chat-navigation[@company-id='companyId']"),
	WORKROOM_PAGE_CHATS_PAGE_CREATE_NEW_CHAT_PLUS_ICON_XPATH("//i[@title='Create New Chat']"),
	WORKROOM_PAGE_CHATS_PAGE_CHATROOM_LIST_XPATH("//chat-navigation[@company-id='companyId']//ul[1]//li"),
	
	WORKROOM_PAGE_EMP_PUBLIC_PRIVATE_FILES_POPUP_ID("firstModal"), /* Same pop up id for both Private & Public.*/
	WORKROOM_PAGE_EMP_PUBLIC_POPUP_ADD_FILES_BUTTON_XPATH("//button[@title='Add Files To Public Folder']"),
	WORKROOM_PAGE_EMP_FILES_POPUP_COPY_BUTTON_XPATH("//button[contains(text(), 'Copy')]"),
	WORKROOM_PAGE_EMP_FILES_POPUP_DOWNLOAD_BUTTON_XPATH("//button[contains(text(), 'Download')]"),
	WORKROOM_PAGE_EMP_FILES_POPUP_SELECT_ALL_CHECKBOX_ID("chkSelectAll"),
	WORKROOM_PAGE_EMP_FILES_POPUP_CLOSE_BUTTON_XPATH("//input[@value='Close']"),
	WORKROOM_PAGE_EMP_FILES_POPUP_FILES_IN_LIST_XPATH("//ul[@class='module_list tight rhythmMargin']//li"),
	WORKROOM_PAGE_EMP_FILES_POPUP_CHECKBOX_XPATH("//input[contains(@id, 'select')][@type='checkbox']"),
	WORKROOM_PAGE_EMP_FILES_POPUP_FILE_NAME_TEXT_IN_LIST_XPATH("//ul[@class='module_list tight rhythmMargin']//li//strong"),
	WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_LIST_NAMES_XPATH("//ul[@class='module_list tight rhythmMargin']//li//strong"),
	WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_PRIVATE_FILES_CHECKBOX_ID("select-personalFolder"),
	WORKROOM_PAGE_EMP_FILES_POPUP_COPY_TO_COPY_BUTTON_XPATH("//input[@value='Copy']"),
	WORKROOM_PAGE_EMP_FILES_POPUP_SUCCESSFUL_COPY_TOAST_MESSAGE_XPATH("//p[@class='module_toast toast_show'][contains(text(), 'successfully copied')]"),
	WORKROOM_PAGE_EMP_PURCHASE_ORDER_NUMBER_XPATH("//a[contains(text(), '+Purchase Order Number')]"),
	
	// ----------------- WORKROOM ---------------
	WORKROOM_PAGE_EMP_RIGHT_COLUMN_XPATH("//aside[@class='right-col']"),
	WORKROOM_PAGE_EMP_RIGHT_COLUMN_OUTSTANDING_INVOICE_TEXT_XPATH("//p[@class='subtext']//span[@class='ng-binding']"),
	
	// --------------- STATUS UPDATES TAB EMP ---------
	WORKROOM_PAGE_STATUS_UPDATES_TAB_XPATH("//nav[@class='left-col']//ul//li[1]"),	
	WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_CONTAINER_XPATH("//div[@ng-controller='milestoneCtrl']"),
	WORKROOM_PAGE_STATUS_UPDATES_RIGHT_PANEL_MESSAGE_TEXTBOX_ID("reply"),
	WORKROOM_PAGE_STATUS_UPDATES_FIRST_MILESTONE_SEND_INVOICE_LINK_XPATH("(//a[contains(text(), 'Send invoice')])[1]"),
	
	
	// ----------- SAFEPAY TAB ---------
	WORKROOM_PAGE_SAFEPAY_TAB_SAFEPAY_DETAILS_SECTION_XPATH("//div[@class='module_box box_NoPadding']"),
	WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_XPATH("//a[contains(text(), 'Add Funds')]"),
	WORKROOM_PAGE_FL_SAFEPAY_REQUEST_FUNDS_BUTTON_XPATH("//a[contains(text(), 'Request Funds')]"),
	WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_VALID_XPATH("//input[@ng-model='requestAmountInput']"), // prefilled with amount more than 0
	WORKROOM_PAGE_AMOUNT_TO_ADD_TEXTBOX_INVALID_XPATH("//input[@class='niceInput prepend amount auto ng-dirty ng-invalid ng-invalid-required']"),
	WORKROOM_PAGE_EMP_SAFEPAY_ADD_FUNDS_BUTTON_UNDER_ADD_FUNDS_TO_SAFEPAY_SECTION_XPATH("//button[contains(text(), 'Add Funds')]"),
	
	// --------------- AGREEMENT FL ----------
	WORKROOM_PAGE_FL_AGREEMENT_TAB_AGREEMENT_BASED_HEADER_XPATH("//header[@class='cpsection-title']"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_VIEW_AGREEMENT_HEADER_TEXT_XPATH("//h2[contains(text(), 'View Agreement')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_REVIEW_YOUR_SAFEPAY_HEADER_TEXT_XPATH("//h3[contains(text(), 'Review your SafePay and autopay requirements below.')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH("//h3[contains(text(), 'Payment Schedule - invoices will be paid within:')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_STATUS_UPDATES_HEADER_TEXT_XPATH("//h3[contains(text(), 'Status updates will be provided:')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_DISPUTE_RESOLUTION_HEADER_TEXT_XPATH("//h3[contains(text(), 'Dispute Resolution')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_REVISE_AGREEMENT_HEADER_TEXT_XPATH("//h3[contains(text(), 'Revise Agreement')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_MILESTONES_HEADER_TEXT_XPATH("//header[contains(text(), 'Milestones')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_CHOOSE_YOUR_SAFEPAY_HEADER_TEXT_XPATH("//h3[contains(text(), 'Choose your SafePay and autopay requirements below.')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_PROTECTION_SUMMARY_HEADER_TEXT_XPATH("//h3[contains(text(), 'Protection Summary')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_I_WILL_PROVIDE_STATUS_HEADER_TEXT_XPATH("//header[contains(text(), 'I will provide Status Updates:')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_SCOPE_OF_WORK_HEADER_TEXT_XPATH("//h3[contains(text(), 'Scope of work:')]"),
	WORKROOM_PAGE_FL_AGREEMENT_TAB_I_WILL_BILL_MY_EMPLOYER_HEADER_TEXT_XPATH("//header[contains(text(), 'I will bill my employer for:')]"),
	
	
	
	WORKROOM_PAGE_AGREEMENT_TAB_XPATH("//nav[@class='left-col']//ul//li[2]"),
	WORKROOM_PAGE_AGREEMENT_TAB_EDIT_BUTTON_XPATH("//input[@value='Edit']"),
	WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CONTINUE_BUTTON_ID("pEditAgreement"),
	WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_CANCEL_BUTTON_ID("pCancelPopup"),
	WORKROOM_PAGE_AGREEMENT_TAB_EDIT_AGREEMENT_POPUP_X_ICON_XPATH("(//div[@class='modal-header']//button[@class='close'])[2]"),
	WORKROOM_PAGE_AGREEMENT_TAB_REVISE_AGREEMENT_AGREEMENT_TYPE_DROPDOWN_MENU_XPATH("//select[contains(@class, 'niceInput auto ng-pristine')]"),
	WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_HOURS_PER_WEEK_TEXTBOX_XPATH("//input[@ng-model='member.teamMaxHrs']"),
	WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_RATE_TEXTBOX_XPATH("//input[@ng-model='member.teamRate']"),
	WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_ENTRYBOX_XPATH("//input[@class='niceInput prepend date']"),
	WORKROOM_PAGE_AGREEMENT_TAB_HOURLY_BILLING_END_DATE_POP_UP_LAST_DATE_XPATH("//div[contains(@class, 'uib-daypicker')]//table//tbody//tr[6]//td[7]"),
	WORKROOM_PAGE_AGREEMENT_TAB_PREVIEW_BUTTON_XPATH("//input[@value='Preview']"),
	WORKROOM_PAGE_AGREEMENT_TAB_PREVIEW_AGREEMENT_CONTAINER_ID("previewData"),
	WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_BUTTON_XPATH("//input[@value='Send to Employer']"),
	WORKROOM_PAGE_AGREEMENT_TAB_SEND_TO_EMPLOYER_CONFIRM_CONTINUE_BUTTON_XPATH("//button[contains(text(), 'Continue')]"),
	WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_SENT_TOAST_MESSAGE_XPATH("//p[@class='module_toast toast_top toast_show']"),
	WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_AGREEMENT_STATUS_XPATH("//span[@class='module_badge badge_large  badge_pending multiple_agreements']"),
	WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_THE_NAVIGATION_TAB_XPATH("//span[@class='notification module_badge hide show badge_pending']"),
	WORKROOM_PAGE_AGREEMENT_TAB_AGREEMENT_PENDING_STATE_IN_THE_NAVIGATION_TAB_ID("lnkNewAgreement"),
	
	// ----------------- AGREEMENT EMP --------
	WORKROOM_PAGE_EMP_STATUS_UPDATES_TAB_HEADER_XPATH("//header[contains(@class, 'module_box_header_filled module_box_header_filled_table')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_VIEW_AGREEMENT_HEADER_TEXT_XPATH("//h2[contains(text(), 'View Agreement')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_REVIEW_YOUR_SAFEPAY_HEADER_TEXT_XPATH("//h3[contains(text(), 'Review your SafePay and autopay requirements below.')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PAYMENT_SCHEDULE_HEADER_TEXT_XPATH("//h3[contains(text(), 'Payment Schedule - invoices will be paid within:')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_STATUS_UPDATES_HEADER_TEXT_XPATH("//h3[contains(text(), 'Status updates will be provided:')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_DISPUTE_RESOLUTION_HEADER_TEXT_XPATH("//h3[contains(text(), 'Dispute Resolution')]"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_AGREEMENT_DETAILS_CONTAINER_XPATH("//section[@class='right-col']//div[@class='hide ng-scope show']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_AGREEMENT_STATUS_DROPDOWN_XPATH("//span[@role='combobox']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_BUTTON_XPATH("//input[@value='Accept']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_DECLINE_BUTTON_XPATH("//input[@value='Decline']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_BUTTON_DISABLED_XPATH("//button[@class='module_btn primary_btn'][@disabled='disabled']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_BUTTON_ENABLED_XPATH("//div[@class='modal-footer ng-scope']//button[@class='module_btn primary_btn']"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_ACCEPT_AGREEMENT_POPUP_CHECKBOX_ID("chkTerm"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_CONFIRM_DECLINE_AGREEMENT_BUTTON_ID("btnDeclineAgreeemnt"),
	WORKROOM_PAGE_EMP_AGREEMENT_TAB_PENDING_AGREEMENT_CONFIRM_DECLINE_AGREEMENT_TOAST_MESSAGE_XPATH("//p[contains(text(), 'Agreement declined')]"),
	WORKROOM_PAGE_AGREEMENT_TAB_EFFECTIVE_DATE_CALENDAR_FIELD_XPATH("//input[@ng-model='agreementData.effectiveDate']"),
	
	// ----------- MESSAGES ------------
	WORKROOM_PAGE_JOB_WRITE_A_MESSAGE_TEXTBOX_ID("reply"),
	WORKROOM_PAGE_JOB_SEND_MESSAGE_BUTTON_XPATH("//button[@class='module_btn primary_btn ng-binding']"),
	WORKROOM_PAGE_JOB_ATTACH_FILES_ID("attachBtn"),
	WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_ID("attachmentsModal"),
	WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_PRIVATE_FILES_TAB_PLINK("Private Files"),
	WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_PUBLIC_FILES_TAB_PLINK("Public Files"),
	WORKROOM_PAGE_JOB_ATTACH_FILES_POPUP_SELECT_FILES_ID("selectFilesCaption"),
	WORKROOM_PAGE_FILE_UPLOAD_PROGRESS_BAR_XPATH("//div[@role='progressbar']"),
	WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_XPATH("//input[@value='Finished']"),
	WORKROOM_PAGE_ATTACH_FILES_POPUP_CANCEL_BUTTON_XPATH("//input[@value='Cancel']"),
	WORKROOM_PAGE_ATTACH_FILES_POPUP_FINISHED_BUTTON_DISABLED_XPATH("//input[@value='Finished'][@disabled='disabled']"),
	WORKROOM_PAGE_ATTACH_FILES_POPUP_PRIVATE_FILES_TAB_XPATH("//li[@id='prevProposalId']//a[contains(text(), 'Private Files')]"),
	WORKROOM_PAGE_ATTACH_FILES_POPUP_COMPUTER_TAB_XPATH("//li[@id='computerId']//a[contains(text(), 'Computer')]"),
	WORKROOM_PAGE_ATTACHMENTS_FILE_SIZE_LIMIT_ERROR_XPATH("//div[@id='afileupload']//span[@class='callout-title ng-binding']"),
	
	// ------------------ CHAT -------------------------
	WORKROOM_PAGE_CHATS_TAB_PUBLIC_COUNTER_XPATH("//personal-folder-directive[@type='Shared']//span[@class='lightGrey']"),
	WORKROOM_PAGE_CHATS_TAB_PRIVATE_COUNTER_XPATH("//personal-folder-directive[@type='Private']//span[@class='lightGrey']"),
	
	//--------------------- TASKS -------------------------
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_CONTAINER_XPATH("//div[@class='module_pageControls']"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_XPATH("//div[@class='layout-full-page']"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_ASSIGNED_TO_DROPDOWN_XPATH("//button[@class='dropToggle'][contains(text(), 'Assigned to:')]"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_ASSIGN_DROPDOWN_XPATH("//button[@class='module_btn secondary_btn medium_btn'][contains(text(), 'Assign')]"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_SEARCH_TEXTBOX_ID("searchText"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_INCOMPLETE_BUTTON_XPATH("//button[contains(text(), 'Incomplete')]"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_COMPLETE_BUTTON_XPATH("//button[@class='module_btn white_btn medium_btn'][2]"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_TAGGED_DROPDOWN_XPATH("//button[@class='dropToggle'][contains(text(), 'Tagged:')]"),
	WORKROOM_PAGE_TASKS_TAB_PAGE_CONTROLS_NEW_TASK_BUTTON_XPATH("//div[@class='module_pageControls']//a[@href='./create']"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_MARK_AS_DROPDOWN_XPATH("//button[contains(text(), 'Mark as')]"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_SORT_BY_DROPDOWN_XPATH("//button[contains(text(), 'Sort by:')]"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_CONTAINER_CREATE_A_TASK_LINK_XPATH("//a[contains(text(), 'Create a task ')]"),
	
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_BACK_BUTTON_XPATH("//div[@class='module_pageControls']//a[@ng-href='./']"),	
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_TASK_NAME_TEXTBOX_ID("task-name"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DESCRIBE_TASK_TEXTAREA_XPATH("//textarea[contains(@class, 'niceInput rhythmMargin0')]"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_SOMEONE_DROPDOWN_XPATH("//span[contains(text(), 'Assign someone')]"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGN_TO_ME_LINK_XPATH("//a[contains(text(), 'Assign to me')]"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ASSIGNED_TO_ME_ICON_XPATH("//button[@ng-click='getAllAssignees()']//i"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ADD_EVERYONE_IN_WORKROOM_LINK_XPATH("//button[contains(text(), 'Add Everyone in Work Room')]"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ADD_EVERYONE_IN_WORKROOM_ADDED_RECEIPENTS_TOKEN_IN_TEXTBOX_XPATH("//div[@class='m-recipients-input-chip']"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_ENTER_SOMEONES_NAME_TEXTBOX_ID("tokenInput"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CREATE_TASK_BUTTON_XPATH("//button[contains(text(), 'Create Task')]"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_CANCEL_BUTTON_XPATH("//div[@class='form-control-group-buttons']//a[@ng-href='./']"),
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_DUE_DATE_CALENDAR_CONTROL_BOX_XPATH("//div[@ng-model='dueDate']"),
	
	WORKROOM_PAGE_TASKS_TAB_NOTIFICATION_CHECKBOX_ID("notification"),
	
	WORKROOM_PAGE_TASKS_TAB_CREATE_NEW_TASK_PARTICIPANT_TOKEN_IN_ADD_PARTICIPANTS_BOX_XPATH("//div[@class='m-recipients-input-chip']"),
	
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ALL_TASKS_BUTTON_XPATH("//a[@class='module_btn secondary_btn'][@href='./']"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_TASK_HEADER_XPATH("//div[@class='task-data']"),
	WORKROOM_PAGE_TASKS_TAB_TASK_NAME_XPATH("//div[@class='task-data']//p[@class='task-title']//strong"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_TAG_BUTTON_XPATH("//div[@class='dropdown']//button[contains(@class, 'module_btn white_btn small_btn')]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_MARK_COMPLETE_BUTTON_XPATH("//button[@title='Mark Complete']"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ADD_DUE_DATE_BUTTON_XPATH("//button[@class='task-actionBtn']"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_PARTICIPANTS_SECTION_ADD_LINK_XPATH("//aside[@class='right-col']//a[contains(text(), 'Add')]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_ASSIGNEE_DROPDOWN_XPATH("//div[@class='dropdown dropdown_inline']//button[contains(@class, 'module_btn task-actionBtn')]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_MESSAGE_TEXTBOX_ID("sendTaskMsg"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_REPLY_BUTTON_XPATH("//label[@for='sendTaskMsg']"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_SEND_MESSAGE_BUTTON_XPATH("//button[contains(text(), 'Send Message')]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_VIEW_ENTIRE_HISTORY_LINK_XPATH("//aside[@class='right-col']//a[contains(text(), 'View entire history')]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_DUE_DATE_CALENDAR_LAST_DATE_IN_POP_UP_XPATH("//div[@class='uib-daypicker']//table//tbody//tr[6]//td[7]"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_CALENDAR_PICKER_XPATH("//div[@class='uib-daypicker']//table//tbody"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_CALENDAR_PICKER_COLUMNS_XPATH("//div[@class='uib-daypicker']//table//tbody//tr"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_DUE_DATE_CALENDAR_HEADER_XPATH("//button[@class='module_btn date_btn uib-title']//strong"),
	WORKROOM_PAGE_TASKS_TAB_TASK_DETAIL_PAGE_DUE_DATE_ADDED_XPATH("//button[@class='task-actionBtn']//i[@ng-if='hasDuedate===true']"),
	WORKROOM_PAGE_TASKS_TAB_TASKS_IN_LIST_XPATH("//ul[@class='module_list tight topPadding0']//li//div[@class='task clearfix']"),
	
	
	// ----------------- FILE FOLDERS -------------------
	WORKROOM_PAGE_FILE_FOLDERS_TAB_RIGHT_SECTION_XPATH("//section[contains(@class, 'right-col')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_SECTION_XPATH("//aside[contains(@class, 'left-col')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_SEARCH_TEXTBOX_ID("searchText"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_SORT_BY_DROPDOWN_ID("spnt"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_TAB_XPATH("//nav[@class='module_sideNavigation']//li[1]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PUBLIC_FILES_COUNTER_XPATH("//nav[@class='module_sideNavigation']//li[1]//span[@ng-if='menuItem.menuCount']"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_TAB_XPATH("//nav[@class='module_sideNavigation']//li[2]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_COUNTER_XPATH("//nav[@class='module_sideNavigation']//li[2]//span[@ng-if='menuItem.menuCount']"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DELETE_BUTTON_XPATH("//button[contains(text(), 'Delete')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_PRIVATE_FILES_DOWNLOAD_BUTTON_XPATH("//button[contains(text(), 'Download')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_JOB_MESSAGES_TAB_XPATH("//nav[@class='module_sideNavigation']//li[3]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_TASKS_TAB_XPATH("//nav[@class='module_sideNavigation']//li[4]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_LEFT_NAVIGATION_PANEL_CHAT_TAB_XPATH("//nav[@class='module_sideNavigation']//li[5]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_ADD_FILES_BUTTON_XPATH("//button[contains(@class, 'module_btn primary_btn medium_btn lonely_btn')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_PUBLIC_FILES_IN_LIST_XPATH("//ul[@class='module_list tight topPadding0']//li[contains(@class, 'clearfix')]"),
	WORKROOM_PAGE_FILE_FOLDERS_TAB_PUBLIC_FILE_TITLES_IN_LIST_XPATH("//ul[@class='module_list tight topPadding0']//li[contains(@class, 'clearfix')]//p[@class='list_title']"),
	;


	private final String value;
	WorkroomPageObjectMap(final String value) {
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

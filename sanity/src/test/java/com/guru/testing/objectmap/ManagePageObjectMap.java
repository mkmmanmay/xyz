package com.guru.testing.objectmap;

public enum ManagePageObjectMap {
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_EMAIL_SECTION_XPATH("//div[contains(@class, 'addTeamColumn1')]"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_SELECT_ROLE_XPATH("//div[contains(@class, 'addTeamColumn2')]"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_ADD_BUTTON_XPATH("//input[@value='Add Team Member']"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_CANCEL_BUTTON_XPATH("//input[@value='Cancel']"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_FIRST_EMAIL_ADDRESS_ROW_XPATH("//input[contains(@id, 'txtEmail_1_txtEmail_1_TextBox')]"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_FIRST_ROLE_DROPDOWN_XPATH("//select[contains(@id, 'ddlRole_1_ddlRole_1_Select')]"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_BUILD_MY_TEAM_BUTTON_XPATH("//a[@data-toggle='dropdown'][@class='dropToggle module_btn primary_btn']"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_LEAVE_THIS_TEAM_LINK_XPATH("//span[contains(@id, 'removeMyselftLink')]"),
	MANAGE_PAGE_ADD_A_MANAGER_IN_JOB_PAGE_MY_TEAM_PAGE_TEXT_UNDER_INDIVIDUAL_SCREEN_ICONS_XPATH("//p[contains(@class, 'txt')]"),
	
	// ---------- MY MANAGERS TAB ----------------
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_ADD_BUTTON_ID("Invite"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_TEAM_LIST_CONTAINER_XPATH("//div[@class='teamPage clearfix']"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_TILES_TEXT_XPATH("//div[@class='teamPage clearfix']//li"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_ROLES_TEXT_XPATH("//div[@class='teamPage clearfix']//li//span[@class='memberRole']"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_DROPDOWN_TOGGLE_XPATH("//a[@class='module_btn secondary_btn dropdown-toggle']"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_MEMBER_DROPDOWN_MENU_REMOVE_BUTTON_XPATH("//a[@class='removeTeam']"),
	MANAGE_PAGE_MY_MANAGERS_SUB_TAB_SUCCESSFULLY_REMOVED_TOAST_MESSAGE_XPATH("//span[@class='popMsg'][contains(text(), ' has been removed.')]"),
	;
	
	
	private final String value;
	ManagePageObjectMap(final String value) {
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

package com.guru.testing.objectmap;

public enum SwitchBoardPageObjectMap {
	
	SWITCHBOARD_PAGE_OWNER_TILE_CLASS_XPATH("//li[@class='members ownerTop']"),
	SWITCHBOARD_PAGE_MEMBER_TILE_CLASS_XPATH("//li[@class='members']"),
	SWITCHBOARD_PAGE_MEMBER_TILE_ROLE_TEXT_XPATH("//li[@class='members']//p//span[@class='darker']"),
	SWITCHBOARD_PAGE_SETTINGS_DROPDOWN_TOP_ICON_XPATH("//a[contains(@class, 'dropdown-toggle')]"),
	SWITCHBOATD_PAGE_SETTINGS_DROPDOWN_SIGNOUT_BUTTON_XPATH("//a[contains(text(), 'Sign Out')]"),
	;
	
	
	private final String value;
	SwitchBoardPageObjectMap(final String value) {
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

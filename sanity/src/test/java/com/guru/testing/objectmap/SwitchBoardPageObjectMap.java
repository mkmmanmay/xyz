package com.guru.testing.objectmap;

public enum SwitchBoardPageObjectMap {
	
	SWITCHBOARD_PAGE_OWNER_TILE_CLASS_XPATH("//li[@class='members ownerTop']"),
	SWITCHBOARD_PAGE_MEMBER_TILE_CLASS_XPATH("//li[@class='members']"),
	SWITCHBOARD_PAGE_MEMBER_TILE_ROLE_TEXT_XPATH("//li[@class='members']//p//span[@class='darker']"),
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

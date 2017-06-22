package com.guru.testing.objectmap;

public enum AdminTaskEnginePageObjectMap {
	
	
	ADMIN_TASK_ENGINE_PAGE_ADMIN_MENU_PLINK("admin menu"),
	ADMIN_TASK_ENGINE_PAGE_TASK_40_XPATH("//input[@value='Start'][@id='ctl00_plcMainRegion_tasksGroup_ctl29_taskAction']"),
	ADMIN_TASK_ENGINE_PAGE_TASK_40_IN_PROGRESS_XPATH("//input[@value='Force Stop'][@id='ctl00_plcMainRegion_tasksGroup_ctl29_taskAction']"),
	ADMIN_TASK_ENGINE_PAGE_TASK_36_XPATH("//input[@value='Start'][@id='ctl00_plcMainRegion_tasksGroup_ctl28_taskAction']"),
	ADMIN_TASK_ENGINE_PAGE_TASK_36_IN_PROGRESS_XPATH("//input[@value='Force Stop'][@id='ctl00_plcMainRegion_tasksGroup_ctl28_taskAction']"),
	ADMIN_TASK_ENGINE_PAGE_TASK_56_XPATH("//input[@value='Start'][@id='ctl00_plcMainRegion_tasksGroup_ctl41_taskAction']"),
	ADMIN_TASK_ENGINE_PAGE_TASK_56_IN_PROGRESS_XPATH("//input[@value='Force Stop'][@id='ctl00_plcMainRegion_tasksGroup_ctl41_taskAction']"),
	
	;
	
	
	private final String value;
	AdminTaskEnginePageObjectMap(final String value) {
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

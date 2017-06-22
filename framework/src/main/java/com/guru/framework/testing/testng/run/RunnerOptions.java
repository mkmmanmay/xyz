package com.guru.framework.testing.testng.run;

public enum RunnerOptions {
	
	PROPERTY_SUITE_TEMPLATE("suite-template"),
	PROPERTY_SUITE_STRING("suite-string"),
	PROPERTY_SUITE_NAMING_PARAMETER("suite-name-parameter"),
	PROPERTY_TEST_NAMING_PARAMETER("test-name-parameter"),
	PROPERTY_DELIMITER("delimiter"),
	PROPERTY_TEST_INCLUDE("test-include"),
	PROPERTY_TEST_EXCLUDE("test-exclude"),
	PROPERTY_OUTPUT_DIRECTORY("output-directory"),
	PROPERTY_LISTENER_ADD("listener-add"),
	PROPERTY_LISTENER_REMOVE("listener-remove"),
	PROPERTY_SUITE_STRATEGY("suite-strategy"),
	PROPERTY_TEST_STRATEGY("test-strategy"),
	PROPERTY_BUILD_PRINT("print"),
	PROPERTY_RUNNER_SINGLE("runner-single"),
	PROPERTY_BUILD_SCOPE("build"),
	PROPERTY_SUITE_NAME_PARAMETER_CONCAT("suite-name-parameter-concat");
	
	private final String value;
	private RunnerOptions(final String s) {value = s;}
	public String toString() { return value;}
	public String getValue() { return value; }
	
	public static RunnerOptions getValueOf(final String val) {
		for(RunnerOptions option : RunnerOptions.values())
			{if(option.getValue().equalsIgnoreCase(val))
				{return option;}}
		return null;
	}
}

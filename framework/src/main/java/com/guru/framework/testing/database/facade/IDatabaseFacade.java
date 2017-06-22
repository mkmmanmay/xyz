package com.guru.framework.testing.database.facade;

import com.guru.framework.testing.utils.objects.value.DataTable;

/**
 * Common interface for all database facades
 * @author Isha Sharma
 * @version 1.0.0
 */

public interface IDatabaseFacade {
	
	public enum PROPERTY_KEY {
		TEMPLATES("templates"), 
		DATA("data"), 
		CONFIGURATION("configuration"), 
		ASSERTIONS("assertions");
		private final String value;
		PROPERTY_KEY(String value) {
			this.value = value;
		}

		String getValue() {
			return this.value;
		}
	}
	
	
	
	// Stored Procedure syntax choices
	static String ORACLE_STORE_PROC_TEMPLATE = "begin StoreProcCall; end;";
	static String GENERIC_STORE_PROC_TEMPLATE = "{ call ? :=StoreProcCall }";
	

	void close() throws Throwable;	
	
	DataTable executeQuery(final String query, final String ...values) throws Throwable;
	int executeUpdateQuery(final String query, final String ...values) throws Throwable;

	
	
}

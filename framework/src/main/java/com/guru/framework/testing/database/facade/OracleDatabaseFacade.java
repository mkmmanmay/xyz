package com.guru.framework.testing.database.facade;


import java.util.Map;
import java.util.logging.Logger;


import com.guru.framework.testing.database.objects.StoredProcedure;

import com.guru.framework.testing.utils.objects.value.DataTable;

public final class OracleDatabaseFacade extends PooledDatabaseFacade{
	private static final Logger logger = Logger.getLogger(OracleDatabaseFacade.class.getName());
	
	// default Oracle driver
	public static final String DEFAULT_ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	
	public static final String SCHEMA_KEY = "Schema";
	public static final String CATEGORY_KEY = "Category"; 
	
	private static Map<String, StoredProcedure> metaDataProp;
	
	
	//public static final String DEFAULT_ORACLE_URI = "jdbc:oracle:thin:@cmfalgadtdb03.comfin.ge.com:1521:ge_tflt2";	
	//public static final String DEFAULT_ORACLE_URI = "jdbc:oracle:thin:@cmfalgaqqdb03.comfin.ge.com:1521:ge_qflt2";

	// 
	static final String COLUMN_NAME = "COLUMN_NAME";
	static final String COLUMN_TYPE = "COLUMN_TYPE";
	static final String DATA_TYPE = "DATA_TYPE";
	static final String TYPE_NAME = "TYPE_NAME";
	static final String NULLABLE = "NULLABLE";
	static final String SEQUENCE = "SEQUENCE";
	@Override
	public DataTable executeQuery(String query, String... values) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int executeUpdateQuery(String query, String... values) throws Throwable {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

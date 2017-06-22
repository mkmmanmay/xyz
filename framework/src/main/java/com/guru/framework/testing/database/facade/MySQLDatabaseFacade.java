package com.guru.framework.testing.database.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.guru.framework.testing.database.objects.ParameterMetadata;
import com.guru.framework.testing.utils.objects.SimpleStringCipher;
import com.guru.framework.testing.utils.objects.value.DataTable;
import com.guru.framework.testing.utils.objects.value.KeyValuePair;




public abstract class MySQLDatabaseFacade extends PooledDatabaseFacade{
	private static final Logger logger = Logger.getLogger(MySQLDatabaseFacade.class.getName());
	
	// default Oracle driver
	public static final String DEFAULT_ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	static final String COLUMN_NAME = "COLUMN_NAME";
	static final String COLUMN_TYPE = "COLUMN_TYPE";
	static final String DATA_TYPE = "DATA_TYPE";
	static final String TYPE_NAME = "TYPE_NAME";
	static final String NULLABLE = "NULLABLE";
	static final String SEQUENCE = "SEQUENCE";
	private static Hashtable<String,MySQLDatabaseFacade> factories = new Hashtable<String,MySQLDatabaseFacade>();
	
	// Mapping of Oracle types
	private static HashMap<Integer, Integer> hmTypes = new HashMap<Integer, Integer>();	
	static {		
		
		
	/*	TODO issues with the dependency https://blogs.oracle.com/dev2dev/entry/oracle_maven_repository_instructions_for
	 * 
	 * hmTypes.put(new Integer(Types.BINARY), new Integer(OracleTypes.BINARY));
		hmTypes.put(new Integer(Types.BOOLEAN), new Integer(OracleTypes.BOOLEAN));
		hmTypes.put(new Integer(Types.VARCHAR), new Integer(OracleTypes.VARCHAR));
		hmTypes.put(new Integer(Types.CHAR), new Integer(OracleTypes.CHAR));
		*/
	}
	
	protected MySQLDatabaseFacade(){
		
	}

	public static MySQLDatabaseFacade getFactory(String schemaName) throws Exception, Throwable
	{
		if (factories.containsKey(schemaName))
		{
			return (factories.get(schemaName));
		}
		MySQLDatabaseFacade factory =MySQLDatabaseFacade.getInstance("FactoryDB is not setup");
		/*= MySQLDatabaseFacade.getInstance("com.mysql.jdbc.Driver", 
				"jdbc:mysql://" + dbIPAddress + ":3306/" + schemaName, 
				dbLogin, 
				SimpleStringCipher.decrypt(dbPassword));
		factories.put(schemaName, factory);*/
		return factory;
	}
	
	private static MySQLDatabaseFacade getInstance(String string) {
		
		return null;
	}

	/*public static void setDBPassword(String newPassword) {
		dbPassword = newPassword;
	}	
	*/
	
}

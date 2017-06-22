package com.guru.framework.testing.database.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.guru.framework.testing.utils.objects.TestProperties;
import com.guru.framework.testing.utils.objects.value.Cell;
import com.guru.framework.testing.utils.objects.value.Column;
import com.guru.framework.testing.utils.objects.value.DataTable;
import com.guru.framework.testing.utils.objects.value.Row;
import com.guru.framework.testing.utils.objects.value.TextValue;
import com.guru.framework.testing.utils.objects.value.Value;
import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public abstract class PooledDatabaseFacade implements IDatabaseFacade {
	
	protected static TestProperties testProperties;
	
	protected PoolingDataSource dataSource = null;
	
	protected static Logger logger = Logger.getLogger(OracleDatabaseFacade.class.getName());
	static { logger.setLevel(Level.FINEST); }
	
	// Connection pool defaults
	public static final int DEFAULT_POOL_MAX_ACTIVE = 8;
	public static final int DEFAULT_POOL_MAX_IDLE = 8;
	public static final int DEFAULT_POOL_MIN_IDLE = 0;
	public static final long DEFAULT_POOL_MAX_WAIT = -1L;	
	public static final boolean DEFAULT_POOL_READ_ONLY = false;
	public static final boolean DEFAULT_POOL_AUTOCOMMIT = true;

	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close() throws Throwable {
		// do nothing at this time
	}


	// set's up connection pool parameters
	protected static void setPoolParameters(final GenericObjectPool pool, final int... poolParams) {		
		pool.setMaxActive(DEFAULT_POOL_MAX_ACTIVE);
		pool.setMaxIdle(DEFAULT_POOL_MAX_IDLE);
		pool.setMinIdle(DEFAULT_POOL_MIN_IDLE);
		pool.setMaxWait(DEFAULT_POOL_MAX_WAIT);		
		switch(poolParams.length) {
			case 1: pool.setMaxActive(poolParams[0]); break;
			case 2: pool.setMaxActive(poolParams[0]); pool.setMaxIdle(poolParams[1]); break;
			case 3: pool.setMaxActive(poolParams[0]); pool.setMaxIdle(poolParams[1]); pool.setMinIdle(poolParams[2]);break;
			case 4: pool.setMaxActive(poolParams[0]); pool.setMaxIdle(poolParams[1]); pool.setMinIdle(poolParams[2]); pool.setMaxWait(poolParams[3]); break;
		}
	}
	
	protected DataTable getDataTableFromResultSet(final ResultSet rs) throws Throwable{
		final ResultSetMetaData rsmd = rs.getMetaData(); 
		final int colCount = rsmd.getColumnCount();
		final DataTable dt = new DataTable();
		for(int i = 1; i<=colCount; i++)
		{
			final Column cd = new Column(rsmd.getColumnName(i), ValueType.TEXT, rsmd.getColumnLabel(i));
			dt.addColumn(cd);
		}
		//rs.setFetchSize(100);
		while(rs.next()){
			Row r = new Row(colCount);
			for (int i=1; i<=colCount; i++){
				Value v;
				if(rs.getString(i) == null)
				{
					v = Value.getEmptyValueFromType(Value.ValueType.TEXT);
				}else{
					v = TextValue.getInstance(rs.getString(i));
				}
	//			System.out.println(v);
				final Cell c = new Cell(v);
				r.addCell(c);
			}
			dt.addRow(new Row(r));
			r = null;
		}
		
		return dt;
	}
}

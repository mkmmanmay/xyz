package com.guru.framework.testing.database.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a result set
 * @author Isha Sharma
 * @version 1.0.0
 *
 */
public class SQLResultSet{
	private static final Logger logger = Logger.getLogger(SQLResultSet.class.getName());
	
	private String rsName;
	private Map<String, List<Object>> rsBody;
	
	/**
	 * Default constructor
	 */
	public SQLResultSet() {
		setBody(null);
	}
	
	/**
	 * Create an empty named <code>ResulSet</code>
	 * @param rsName A name for the result set
	 */
	public SQLResultSet(final String rsName)  {
		setName(rsName);
		setBody(null);
	}
	
	/**
	 * Create an not named <code>ResulSet</code>
	 * @param rsBody A body for the result set
	 */
	public SQLResultSet( final Map<String, List<Object>> rsBody)  {
		setName(null);
		setBody(rsBody);
	}
	
	/**
	 * Copy constructor<code>ResulSet</code> 
	 * @param rsName A name for the result set
	 * @param rsBody A name for the result set
	 */
	public SQLResultSet(final String rsName, final Map<String, List<Object>> rsBody) {
		setName(rsName);
		setBody(rsBody);
	}
	
	/**
	 * Mutator method for the result set name
	 * @param rsName A name of the result set
	 */
	protected void setName(final String rsName) { 
		this.rsName = rsName;
	}
	
	/**
	 * Mutator method for the result set body, if <code>rsrBody</code> is null, assigns an empty <code>HashMap</code>
	 * @param rsBody A body of the result set
	 */
	protected  void setBody(final Map<String, List<Object>> rsBody)  { 
		if (null == rsBody) { this.rsBody = new HashMap<String, List<Object>>();	}
		else { this.rsBody = rsBody; }
	}
	
	/**
	 * Accessor method to the result set name
	 * @return A name of the result set
	 */
	public String getName() {
		return this.rsName;
	}
	
	/**
	 * Accessor method to the result set body
	 * @return A body of the result set
	 */
	public Map<String, List<Object>> getBody() {
		return this.rsBody;
	}
	
	/**
	 * Accessor method to a result set data value by  column name and 0-based row index
	 * @param columnName Name of the column in the result set
	 * @param row 0-based result set row number
	 * @return A value in the specified result set cell or null if it is the null result set
	  * @throws IllegalArgumentException If the column with <code>columnName</code> does not exist 
	  * 				 IndexOutOfBoundsException If <code>row < 0</code> or <code> row</code> is beyond the result set last row 
	 */
	public Object getDataValue(final String columnName, final int row) {		
		 if(!hasColumn(columnName) ) { throw new IllegalArgumentException("Non-existing column name=" + columnName); }	
		 return rsBody.get(columnName).get(row);
	}
	
	/**
	 * Accessor method to a result set value by column 0-based index and 0-based row index
	 * @param col 0-based result set column number
	 * @param row 0-based result set row number
	 * @return A value in the specified result set cell 
	 * 	@IndexOutOfBoundsException If <code>row</code> or <code>col</code> is beyond the result set's data range
	 */
	public Object getDataValue(final int col, final int row) {
		final Set<String> set = getColumnNames();
		final String[] x = (String[]) set.toArray(new String[0]);
		return rsBody.get(x[col]).get(row);
	}
	
	/**
	 * Returns a set of column names
	 * @return A set of column names or empty set if there are no columns
	 */
	public Set<String> getColumnNames()	{	
		return rsBody.keySet();	
	}
	
	/**
	 * Returns number of columns in the result set s
	 * @return Count of columns in the result set, 0 if this is a null result set
	 */	
	public int getColumnCount()  {
		return rsBody.size();
	}
	
	/**
	 * Returns number of rows in the result set 
	 * @return Count of rows in the result set, 0 if this is a null result set
	 */
	public int getRowCount() {
		try {	return rsBody.get(getColumnNames().iterator().next()).size(); 	}
		catch (Exception e) {logger.log(Level.SEVERE, e.getMessage());	}
		return 0;
	}
	
	/**
	 * Checks if a column exists with the specified <code>columnName</code> 
	 * @param columnName Name of the column in the result set
	 * @return True if the column exist, false overwise 
	 */
	public boolean hasColumn(final String columnName) {
		return rsBody.containsKey(columnName);
	}	
	
	/**
	 * Verifies if the result set is empty
	 * @return True if there is at least one column in the result set
	 */
	public boolean isEmpty() {
		return rsBody.size() == 0;
	}
	
	/**
	 * Translates column index into column name
	 * @param index An index (0-based) of the column
	 * @return Column name corresponding to the index
	 * @throws IndexOutOfBoundsException when <code>index</code> is out of bounds
	 */
	public String getColumnName(final int index) {
		if(index < 0 || index >= getColumnCount())  { throw new IndexOutOfBoundsException("Invalid column index=" + index); }
		final Set<String> set = getColumnNames();
		final String[] x = (String[]) set.toArray(new String[0]);
		return x[index];
	}
	
}

package com.guru.framework.testing.database.objects;

import java.util.List;
import java.util.Map;



/**
 * Represents a stored procedure cursor
 * @author Isha Sharma
 * @version 1.0.0
 */
public class Cursor extends SQLResultSet {

	@SuppressWarnings("unused")
	private Cursor() {
		this("unanimous");
	}
	
	/**
	 * Create an empty <code>Cursor</code> with an empty <code>HashMap</code> as cursor data
	 * @throws IllegalArgumentException when the name of the cursor is null or empty
	 */
	public Cursor(final String cursorName)  {
		this.setName(cursorName);
		setBody(null);
	}
	
	/**
	 * Create an empty <code>QueryResult</code> with a <code>HashMap</code> as cursor data
	 * @throws IllegalArgumentException when the name of the cursor is null or empty
	 */
	public Cursor(final String cursorName, final Map<String, List<Object>> cursorBody) {
		this.setName(cursorName);
		setBody(cursorBody);
	}
	
	/**
	 * Mutator method for the result set name
	 * @param rsName A name of the result set
	  * @throws IllegalArgumentException If the <code>rsName</code> null or empty
	 */
	protected void setName(final String rsName) { 
		if(null == rsName || rsName.isEmpty()) {throw new IllegalArgumentException("Cursor must be named");}
		super.setName(rsName);
	}
	
	public String print() {
		final StringBuffer sb = new StringBuffer();		
		for(String name: getColumnNames())
			{sb.append(name).append("\t");}
		sb.append("\n");		
		for(int i=0; i < getRowCount(); i++) {
			for(int j = 0; j < getColumnCount(); j++) 
				{sb.append(this.getDataValue(j, i)).append("\t");}
			sb.append("\n");
		}		
		return sb.toString();
}
	
}

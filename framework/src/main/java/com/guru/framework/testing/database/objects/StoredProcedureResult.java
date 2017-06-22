package com.guru.framework.testing.database.objects;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Represents a stored procedure results, both cursors and out parameters
 * @author Isha Sharma
 * @version 1.0.0
 */
public class StoredProcedureResult {
	
	protected Map<String, Cursor> cursors;
	protected Map<String, Object> outParameterValues;

	/**
	 * Create an empty <code>StoredProcedureResult</code>, use a LinkedHashMap 
	 * as container for <code>cursors</code> and <code>outParameterValues</code>
	 */
	public StoredProcedureResult() {
		this.cursors = new LinkedHashMap<String, Cursor>(3);
		this.outParameterValues = new LinkedHashMap<String, Object>(10);
	}
	
	/**
	 * 
	 */
	public StoredProcedureResult(final StoredProcedureResult results) {
		cursors = new HashMap<String, Cursor>();
		outParameterValues = new HashMap<String, Object>();
		
		final Set<String> curNames = results.getCursorNames();
		final Set<String> paramNames = results.getParameterNames();
		
		for(String curName: curNames){
			cursors.put(curName, results.getCursor(curName));
		}
		for(String paramName : paramNames){
			outParameterValues.put(paramName, results.getParameterValue(paramName));
		}
		
	}
	
	/**
	 * Adds a new cursor with its data, null or empty cursor names are not allowed, duplicate cursor names are not allowed
	 * @param curso Non-null cursor to be added to <code>StoredProcedureResult</code>
	 * @throws IllegalArgumentException If the cursor  already exists or if <code>cursor</code> object is null 
	 */
	public void addCursor(final Cursor cursor) {
		if (null == cursor) { throw new IllegalArgumentException("Null cursor object is not allowed");	}
		if (hasCursor(cursor.getName())) {	throw new IllegalArgumentException("Duplicate cursor name is not allowed: " + cursor.getName()); }
		this.cursors.put(cursor.getName(), cursor);
	}
	
	/**
	 * Adds a new cursor with its data, null or empty cursor names are not allowed, duplicate cursor names are not allowed
	 * @param cursorName Non-null cursor name to be added to <code>StoredProcedureResult</code>
	 * @param cursorData Data of the the cursor as List of Objects mapped to Strings
	 * @throws IllegalArgumentException If the cursor with <code>cursorName</code> already exist or if the cursor can not be created
	 */
	public void addCursor(final String cursorName, final Map<String, List<Object>> cursorData) {
		if (hasCursor(cursorName)) {	throw new IllegalArgumentException("Duplicate cursor name is not allowed: " + cursorName); }
		final Cursor cursor = new Cursor(cursorName, cursorData);
		this.cursors.put(cursorName, cursor);
	}

	/**
	 * Adds a new out parameter, null or empty parameter names are not allowed, duplicate parameter names are not allowed
	 * @param paramName Non-null parameter name to be added to <code>StoredProcedureResult</code>
	 * @param paramValue A value of parameter as an Object
	 * @throws IllegalArgumentException If the cursor with <code>paramName</code> already exist or if <code>paramName</code>  is null or empty
	 */
	public void addParameterValue(final String paramName, final Object paramValue) {
		if (null == paramName || paramName.isEmpty()) {	throw new IllegalArgumentException("Null or empty parameter name is not allowed"); }
		if (hasParameter(paramName)) { throw new IllegalArgumentException("Duplicate parameter name is not allowed: " + paramName); }
		this.outParameterValues.put(paramName, paramValue);
	}

	/**
	 * Returns the cursor with the specified <code>cursorName</code>
	 * @param cursorName Name of the cursor to look up in <code>cursors</code>
	 * @return Cursor 
	 * @throws IllegalArgumentException If the cursor with <code>cursorName</code> does not exist 
	 */
	public Cursor getCursor(final String cursorName) {
		if(!hasCursor(cursorName)) { throw new IllegalArgumentException("Cursor does not exist with name=" + cursorName); }		
		return this.cursors.get(cursorName);
	}

	/**
	 * Returns out parameter value for the specified <code>paramName</code>
	 * @param paramName Name of the cursor to look up in <code>outParameterValues</code>
	 * @return Parameter value that matches the specified <code>paramName</code>, possibly null
	 * @throws IllegalArgumentException If the parameter with <code>paramName</code> does not exist 
	 */
	public Object getParameterValue(final String paramName) {
		if(!hasParameter(paramName)) { throw new IllegalArgumentException("Parameter does not exist with name=" + paramName); }		
		return this.outParameterValues.get(paramName);
	}
		
	/**
	 * Returns a set of cursor names
	 * @return A set of cursor names or empty set if there are no cursors
	 */
	public Set<String> getCursorNames()	{	return this.cursors.keySet();	}
	
	/**
	 * Returns a set of parameter names
	 * @return A set of parameter names or empty set if there are no parameters
	 */
	public Set<String> getParameterNames()	{	return this.outParameterValues.keySet();	}
		
	/**
	 * Returns number of cursors in the <code>StoredProcedureResult</code>
	 * @return Number of cursors or 0 if there are no cursors in the <code>StoredProcedureResult</code>
	 */
	public int getCursorCount() { 	return this.cursors.size();	}

	/**
	 * Returns number of parameters in the <code>StoredProcedureResult</code>
	 * @return Number of out parameters or 0 if there are no parameters in the <code>StoredProcedureResult</code>
	 */
	public int getParameterCount() {	return this.outParameterValues.size();	}

	/**
	 * Checks if a cursor with the specified <code>cursorName</code> exists
	 * @param cursorName Name of the cursor
	 * @return True if the cursor exist, false overwise
	 */
	public boolean hasCursor(final String cursorName) {
			return this.cursors.containsKey(cursorName);
	}
	
	/**
	 * Checks if an out parameter with the specified <code>parameterName</code> exists
	 * @param parameterName Name of the out parameter
	 * @return True if the parameter exist, false overwise
	 */
	public boolean hasParameter(final String parameterName) {
			return this.outParameterValues.containsKey(parameterName);
	}		
	
	public String print() {
		final StringBuffer sb = new StringBuffer();
		sb.append("Cursors={");
		for(String name: getCursorNames()) {
			sb.append(name).append("={").append(getCursor(name).print()).append("},");
		}
		sb.append("}");
		sb.append("parameters={");
		for(String name: getParameterNames()) {
			sb.append(name).append("={").append(getParameterValue(name)).append("},");
		}
		sb.append("}");
		return sb.toString();
}
}
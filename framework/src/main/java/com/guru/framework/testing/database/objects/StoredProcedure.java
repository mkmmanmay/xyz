package com.guru.framework.testing.database.objects;


import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Represents a stored procedure definition
 * @author Isha Sharma
 * @version 1.0.0
 */

public class StoredProcedure {

	private static Logger logger = Logger.getLogger(StoredProcedure.class.getName());
	static { 	logger.setLevel(Level.FINEST);	}
	
	private String schema;
	private String catalog;
	private String name;
	
	private Map<String, ParameterMetadata> parameters;
		
	public StoredProcedure()
	{
		schema = new String();
		catalog = new String();
		name = new String();
	}
	
	/**
	 * Constructor 
	 * @param parameters A TreeMap of stored procedure parameters (may be null then an empty parameters will be created)
	 * @param fullName A full stored procedure name that will be parsed into  up to 3 parts
	 * @throws Throwable If it cannot parse full name
	 */
	public StoredProcedure(final Map<String, ParameterMetadata> parameters, final String fullName) throws Throwable {
		final String[] tokens = fullName.toUpperCase().split("\\.");
		switch(tokens.length) {
			case 1: this.schema = null; this.catalog = null; this.name = tokens[0]; break;
			case 2: this.schema = null; this.catalog = tokens[0]; this.name = tokens[1]; break;
			case 3: this.schema = tokens[0]; this.catalog = tokens[1]; this.name = tokens[2]; break;
			default: throw new IllegalArgumentException("Stored procedure fully qualified name must have at most 3 elements:" + fullName); 
		}
		if(null == parameters)	{this.parameters = new TreeMap<String, ParameterMetadata>();}
		else {this.parameters = parameters;}
	}
	
	/**
	 * Constructor
	 * @param parameters A TreeMap of stored procedure parameters (may be null then an empty parameters will be created)
	 * @param schema
	 * @param catalog
	 * @param name
	 * @throws Throwable If schema or catalog or name is null
	 */
	public StoredProcedure(final Map<String, ParameterMetadata> parameters, final String schema, final String catalog, final String name) throws Throwable {
		this.schema = schema.toUpperCase(); 
		this.catalog = catalog.toUpperCase(); 
		this.name = name.toUpperCase();
		if(null == parameters)	{this.parameters = new TreeMap<String, ParameterMetadata>();}
		else {this.parameters = parameters;}
		}
		
	public String getCatalog() { return this.catalog; }
	public String getSchema() { return this.schema; }
	public String getName() { return this.name; }
		
	public int getParameterCount() {
		return this.parameters.size();
	}
	
	// returns sorted parameter keys for a specified type
	public Set<String> getParameterKeys(final int ... paramType ) {
		final Set<String> set  = new LinkedHashSet<String>();
		for(String key: this.parameters.keySet()) {
			for(int i= 0; i < paramType.length; i++)
				{if(this.getParameterMetadata(key).getType() == paramType[i])
					{set.add(key);}}
		}
		return set;
	}
	
	
	public Set<String> getAllParameterKeys() {
		return this.parameters.keySet();
	}
	
	
	public ParameterMetadata getParameterMetadata(final String key) {
		return this.parameters.get(key);
	}
	
	
	public String print() {
		final StringBuffer sb = new StringBuffer();
		sb.append(this.schema).append(".").append(this.catalog).append(".").append(this.name).append("={");
		for(Object key: this.parameters.keySet()) {
			sb.append(key).append("=").append(this.parameters.get(key)).append(",");
		}
		sb.append("}");
		return sb.toString();
	}
	

	
}

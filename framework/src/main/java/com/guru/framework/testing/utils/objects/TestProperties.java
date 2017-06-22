package com.guru.framework.testing.utils.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.guru.framework.testing.objects.exceptions.TestPropertiesException;
import com.guru.framework.testing.utils.objects.value.KeyValuePair;

/**
 * TestProperties represents a configuration structure that is used for tests
 * Internally it is represented as a HashMap where Key is always a String, 
 * and entries can be one of following:
 * 1. String
 * 2. List<String>
 * 3. TestProperties object that satisfies rules 1-3 above
 * @author Isha Sharma
 */


public final class TestProperties {	
	
	private final Map<String, Object> properties;
	
	/**
	 * Create an empty TestProperties
	 */
	public TestProperties(){
		properties = new HashMap<String, Object>();
	}
	
	/**
	 * Copies test properties from a map
	 * @param storage
	 */
	public TestProperties(final Map<String, Object> other) throws TestPropertiesException {
		this();
		if(other == null) {throw new TestPropertiesException("TestProperties can not be set to null");}
		for(String key : other.keySet()) 
			{add(key, other.get(key));	}
	}	
	

	/**
	 * Copy constructor
	 * @param other
	 * @throws TestPropertiesException
	 */
	public TestProperties(final TestProperties other) throws TestPropertiesException {
		this();
		if(other == null) {throw new TestPropertiesException("TestProperties can not be set to null");}
		for(String key : other.getKeys()) 
			{add(key, other.getProperty(key));}
	}
	
	/**
	 * Creates a TestProperties object from an array of KeyValuePair objects that contains other test properties
	 * @param data An array of KeyValuePairs that contains test properties
	 */
	public TestProperties(final KeyValuePair... data) throws TestPropertiesException {
		this();
		if(data.length == 0) {throw new TestPropertiesException("Can not create a TestProperties object from null KeyValuePair array");}
		for(KeyValuePair keyVal : data) 
			{add(keyVal.getKey().toString(), keyVal.getValue());}		
	}
	
	
	@SuppressWarnings({"unchecked" })
	private Object copyProperty(final Object property) throws TestPropertiesException {
		if(property instanceof String) 	{return property;}
		else if(property instanceof List) {
			final List<String> copyList = new ArrayList<String>(((List<?>)property).size());
			copyList.addAll((List<String>)property);
			return copyList;
		}
		else if(property instanceof TestProperties) {
			return new TestProperties((TestProperties)property);
		}	
		throw new TestPropertiesException("Invalid property type=" + property.getClass().getName());
	}
	
	/**
	 * Returns a String TestProperty
	 * @param key
	 * @return
	 * @throws TestPropertiesException
	 */
	public String getStringProperty(final String key) throws TestPropertiesException {
		return (String)getProperty(key, String.class);
	}
	
	/**
	 * Returns an array TestProperty
	 * @param key
	 * @return
	 * @throws TestPropertiesException
	 */
	public String[] getListPropertyAsArray(final String key) throws TestPropertiesException {	
		final List<String> lst  = getListProperty(key);
		String[] result = new String[lst.size()];
		int i=0;
		for(String each:lst)
			{result[i++] = each;}
		return result;
	}
	
	/**
	 * Returns a List TestProperty
	 * @param key
	 * @return
	 * @throws TestPropertiesException
	 */
	@SuppressWarnings("unchecked")
	public List<String> getListProperty(final String key) throws TestPropertiesException {
		if(hasProperty(key)) {
			if(properties.get(key).toString().length() == 0) {
				return new ArrayList<String>();
			}
		}		
		return ( List<String>)getProperty(key, List.class);
	}	
	
	/**
	 * Returns a nested TestProperty
	 * @param key
	 * @return
	 * @throws TestPropertiesException
	 */
	public TestProperties getNestedProperty(final String key) throws TestPropertiesException {
		if(hasProperty(key)) {
			if(properties.get(key).toString().length() == 0) {
				return new TestProperties();
			}
		}		
		return (TestProperties)getProperty(key, TestProperties.class);
	}
	
	
		
	/**
	 * Adds or overrides the existing properties. Package access only because it shall be used only by Factory.
	 * @param key
	 * @param value
	 * @throws TestPropertiesException
	 */
	public void add(final String key, final Object value) throws TestPropertiesException {
		if(value == null) {throw new TestPropertiesException("null TestProperties are not allowed");}
		if(key == null) {throw new TestPropertiesException("null keys are not allowed");}
		properties.put(key, copyProperty(value));
	}
	
	// String property become List<String> property
	// List<String> stays as List<String> property
	// TestProperties property stays as TestProperties property
	@SuppressWarnings("unchecked")
	public void merge(final String key, final Object value) throws TestPropertiesException {
		if(value == null) {throw new TestPropertiesException("null TestProperties are not allowed");}
		if(key == null) {throw new TestPropertiesException("null keys are not allowed");}
		if(!properties.containsKey(key)) {
			add(key, value);
			return;
		}
		final Object p = properties.get(key);		
		if(p instanceof String || p instanceof List) {
			final List<String> newProperty = new ArrayList<String>();
			if(value instanceof TestProperties)
				{throw new TestPropertiesException("Can not merge old property=" + p + " with new property=" + value);}				
			if(p instanceof String) 	{newProperty.add(p.toString());}
			if(p instanceof List) 		{newProperty.addAll((List<String>)p);}				
			if(value instanceof String) {newProperty.add(value.toString());}
			if(value instanceof List) 	{newProperty.addAll((List<String>)value);}
			add(key, newProperty);	
		}
		else { // TestProperties
			if(!(value instanceof TestProperties))
				{throw new TestPropertiesException("Can not merge old property=" + p + " with new property=" + value);}
			final TestProperties toMerge = (TestProperties)value;
			final TestProperties merged = new TestProperties((TestProperties)p);
			for(String k : toMerge.getKeys())
				{merged.merge(k, toMerge.getProperty(key));}
			add(key, merged);
		}		
	}
	
	public TestProperties merge(final TestProperties other) throws TestPropertiesException {
		if(other == null)
			{throw new TestPropertiesException("Can not merge with null properties");}
		for(String key : other.getKeys())
		{
			//System.out.println("Data Merged: Key = " + key + ", Value = " + other.getProperty(key));
			this.merge(key, other.getProperty(key));
		}
		return new TestProperties(this);
	}
	
	/**
	 * Removes the existing property. Package access only because it shall be used only by Factory.
	 * @param value
	 * @throws TestPropertiesException
	 */
	void remove(final String key) throws TestPropertiesException {
		properties.remove(key);
	}
	
	
	
	public String toString() {
		final StringBuffer result = new StringBuffer("{");
		for(String each : properties.keySet()) 			
			{result.append(each).append("=").append(properties.get(each)).append(",");}
		result.append("}");
		return result.toString().replace(",}", "}");		
	}
	
	
	
	/*
	private void validateProperty(Object value) throws TestPropertiesException {
		if(value == null) throw new TestPropertiesException("null TestProperties are not allowed");
		if(value instanceof List) {
			for(Object each: (List<?>)value) {
				if(each == null) throw new TestPropertiesException("null TestProperties entries are not allowed");
				if(!(each instanceof String)) {
					throw new TestPropertiesException("TetsProperties accept only String values, but received: " + each.getClass().getSimpleName());
				}				
			}
		}		
		else if(!(value instanceof String || value instanceof TestProperties)) {
			throw new TestPropertiesException("TestProperties allow only String-based entries, but received: " + value.getClass().getSimpleName());
		}		
	}
	*/
	
	public Object getProperty(final String key) throws TestPropertiesException {
		return getProperty(key, Object.class);
	}
	
	private Object getProperty(final String key, final Class<?> type) throws TestPropertiesException {
		final Object property = properties.get(key);
		if(null == property) 
			{throw new TestPropertiesException("Do not have a  property with a key=" + key);}
		if(!(type.isInstance(property)))
			{throw new TestPropertiesException("Have a property with a key=" + key + 
					", but the property is not an expected instance of " + type.getName() +
					" it is an instance of " + property.getClass().getName());}		
		return copyProperty(property);
	}
	
	public Set<String> getKeys() {
		return this.properties.keySet();
	}
	
	public boolean hasProperty(final String key) {
		return this.properties.containsKey(key);
	}
	
	
	public  Map<String, Object> toMap() throws TestPropertiesException {
		return new TestProperties(this).properties;
	}
	
	public List<KeyValuePair> toKeyValuePairs() throws TestPropertiesException{
		final List<KeyValuePair> list = new ArrayList<KeyValuePair>();		
		for(String key: properties.keySet())
			{list.add(new KeyValuePair(key, getProperty(key)));	}	
		return list;
	}
	
	public KeyValuePair[] toKeyValuePairsArray() throws TestPropertiesException{
		final Set<String> keys = properties.keySet();
		KeyValuePair[] pairs = new KeyValuePair[keys.size()];
		int i = 0;
		for(String key : keys) 
			{pairs[i++] = new KeyValuePair(key, getProperty(key));}
		return pairs;
	}
	
		/**
	public static void main(String... args) throws Exception {
		TestProperties p = new TestProperties();
		
		p.add("TestProperty1", "OldValue1");
		p.add("TestProperty1", "NewValue1");
		p.add("TestProperty2", "NewValue2");
		
		p.add("ArrayTestProperty1", new String[] {"Value1", "Value2", "Value3"});
		p.add("ArrayTestProperty2", new String[] {"Value1", "Value2"});
		p.add("ArrayTestProperty1", new String[] {"Value1", "Value2", "Value4"});
		
		List<String> l = new ArrayList<String>();
		l.add("Value1");
		l.add("Value1");
		l.add("Value2");
		l.add("Value2");
		l.add("Value4");
		l.add("Value5");
		p.add("List Property", l);
		
		TestProperties p2 = new TestProperties();
		p2.add("TestProperty1", "OldValue1");
		p2.add("TestProperty1", "NewValue1");
		p2.add("TestProperty2", "NewValue2");
		p2.add("ArrayTestProperty1", new String[] {"Value1", "Value2", "Value3"});
		p2.add("ArrayTestProperty2", new String[] {"Value1", "Value2"});
		p2.add("ArrayTestProperty1", new String[] {"Value1", "Value2", "Value4"});
		p.add("p2Properties", p2);
		
		System.out.println(p);
		
		p.remove("p2Properties");
		
		System.out.println(p);
	}
	*/
}

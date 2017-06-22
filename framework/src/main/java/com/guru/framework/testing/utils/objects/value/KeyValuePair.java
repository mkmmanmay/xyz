package com.guru.framework.testing.utils.objects.value;

/**
 * 
 * @author Isha Sharma
 * A basic key - value pair, where both keys and values are objects
 */
public class KeyValuePair {

	protected Object key = null;
	protected Object value = null;
	
	public KeyValuePair() {
		setKey(null);
		setValue(null);
	}
	
	public KeyValuePair(final Object key, final Object value) {
		setKey(key);
		setValue(value);
	}
	
	public KeyValuePair(final KeyValuePair other) {
		setKey(other.getKey());
		setValue(other.getValue());
	}

	public Object getKey() 				{ return this.key; }
	public Object getValue() 			{ return this.value; }
	public void setKey(final Object key) 		{ this.key = key; }
	public void setValue(final Object value) 	{ this.value = value; }
	
	
	public boolean equals(final Object object) {
		if (this == object) {return true;}
		if(object == null || !(object instanceof KeyValuePair))	{return false;}
		final KeyValuePair other = (KeyValuePair)object;
		return getKey().equals(other.getKey()) && getValue().equals(other.getValue());
	}
	
	public String toString() {
		return new StringBuffer().append("<").append(key.toString()).append(", ").append(value.toString()).append(">").toString();
	}	
	
}

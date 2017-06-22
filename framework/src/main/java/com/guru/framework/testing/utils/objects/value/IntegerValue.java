package com.guru.framework.testing.utils.objects.value;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class IntegerValue extends Value {

	static IntegerValue EMPTY = new IntegerValue();
	
	protected Integer value = null;
	
	protected IntegerValue() {
		this.value = null;
	}
	
	protected IntegerValue(final int val) {
	    this.value = new Integer(val);
	}		
	
	protected IntegerValue(final Integer input) {
		this.value = new Integer(input);
	}
	
	// copy constructor
	public IntegerValue(final IntegerValue other) {
		if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
		if(!other.isEmpty()) {
			this.value = new Integer(other.getValue());
		}		
	}	
	
	public static IntegerValue getInstance(final String input)  {
		try {	return  ValueFactory.getIntegerInstance(input);}
		catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
	}
	
	
	public Integer getValue()  {
		return this.value;
	}	
	
	public IntegerValue getEmptyValue() {
		return EMPTY;
	}
	
	public ValueType getType() {
		return ValueType.INTEGER;
	}

	@Override
	public int compareTo(final Value other) {
		final int comp = super.compareTo(other);
		if(!(other instanceof IntegerValue)) {return 1;}
		return comp == 0 ? this.value.compareTo(((IntegerValue)other).value) : comp;	
	}	
	
	@Override
	public int hashCode() {
		final int hash = (int) (value.hashCode() ^ (value.hashCode() >>> 32));
		return hash;
	}
	
}

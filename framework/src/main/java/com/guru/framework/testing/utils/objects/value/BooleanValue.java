package com.guru.framework.testing.utils.objects.value;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class BooleanValue extends Value {

	static BooleanValue EMPTY = new BooleanValue();
	static BooleanValue TRUE = new BooleanValue(true);
	static BooleanValue FALSE = new BooleanValue(false);

	protected Boolean value = null;	
	
	protected BooleanValue() {
		this.value = null;
	}
	
	protected BooleanValue(final boolean input) {
		this.value = new Boolean(input);
	}	
	
	public BooleanValue(final BooleanValue other) {
		if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
		if(!other.isEmpty()) {
			this.value = new Boolean(other.getValue());
		}		
	}
	

	public static BooleanValue getInstance(final String input)  {
		try {	return  ValueFactory.getBooleanInstance(input);}
		catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
	}
	

	public Boolean getValue() {
		return this.value;
	}
	
	public BooleanValue getEmptyValue() {
		return EMPTY;
	}
	
	public ValueType getType() {
		return ValueType.BOOLEAN;
	}	
	
	@Override
	public int compareTo(final Value other) {
		final int comp = super.compareTo(other);
		if(!(other instanceof BooleanValue)) {return 1;}
		return comp == 0 ? this.value.compareTo(((BooleanValue)other).value) : comp;	
	}		

}

package com.guru.framework.testing.utils.objects.value;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;


public class NumberValue extends Value {

	static final NumberValue EMPTY = new NumberValue();
	
	protected BigDecimal value = null;	
	
	protected NumberValue() {
	    this.value = null;
	}
	
	protected NumberValue(final long val) {
		this(val, 0);
	}
	
	protected NumberValue(final double val) {
		this(val, 0);
	}
	
	protected NumberValue(final BigDecimal amount) {
		this(amount.doubleValue(), amount.scale());
	}
	
	protected NumberValue(final double val, final int scale) {	
		if(scale < 0) {throw new IllegalArgumentException("Can not set scale " + scale);}
	    this.value = new BigDecimal(val);
	    this.value.setScale(scale, RoundingMode.HALF_UP);	   
	}
	
	public NumberValue(final NumberValue other) throws IllegalArgumentException {
		if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
		if(!other.isEmpty()) {
			this.value = new BigDecimal(other.value.doubleValue());
			this.value.setScale(other.value.scale(), RoundingMode.HALF_UP);	
		}		
	}	
	
	public static NumberValue getInstance(final String input)  {
		try {	return  ValueFactory.getNumberInstance(input);}
		catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
	}
	
		
	 public BigDecimal getValue()  {
		return this.value;
	 }	
	
	 
	 public  NumberValue getEmptyValue() {
			return EMPTY;
		}
		
		public ValueType getType() {
			return ValueType.NUMBER;
		}	
	 
			
	public int compareTo(final Value other) {
		final int comp = super.compareTo(other);		
		if(!(other instanceof NumberValue)) {return 1;}
		return comp == 0 ? this.value.compareTo(((NumberValue)other).value) : comp;	
	}
	
	@Override
	public int hashCode() {
		final int hash = (int) (value.hashCode() ^ (value.hashCode() >>> 32));
		return hash;
	}
	
}

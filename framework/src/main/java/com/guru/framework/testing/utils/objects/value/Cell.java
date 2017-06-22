package com.guru.framework.testing.utils.objects.value;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

/**
 * Represents one cell in the DataTable, stores a Value and formatted value
 * @author Isha Sharma
 *
 */
public class Cell implements Comparable<Cell>{

	protected Value value = null;
	protected String formattedValue = null;
	
	public Cell() {
		this(null, null);
	}

	public Cell(final Value val) {				
		if(null == val)
			{throw new IllegalArgumentException("Can not create a cell with null value");}
		this.value = val;
		if(!val.isEmpty())
			{setFormattedValue(val.getValue().toString());}	
	}

	public Cell(final Value value, final String formattedValue) {
		if(null == value)
			{throw new IllegalArgumentException("Can not create a cell with null value");}
		this.value = value;
		setFormattedValue(formattedValue);
	}		

	public Cell(final Cell other) {
		if(null == other)
			{throw new IllegalArgumentException("Can not copy a null cell");}
		this.value = other.getValue();
		setFormattedValue(other.getFormattedValue());
	}

	public boolean isEmpty() {
		return null == value || value.isEmpty();
	}
	
	public ValueType getType()  { return null == value ? Value.ValueType.UNKNOWN : value.getType(); }
	public Value getValue() 	{ return this.value; }
	public String getFormattedValue() { return this.formattedValue;	}
	
	public void setFormattedValue(final String formattedValue) { this.formattedValue = formattedValue; }

	@Override
	public boolean equals(final Object other) {
		if(other == null || !(other instanceof Cell)) {return false;}
		return this.compareTo((Cell)other) == 0;
	}
	
	@Override
	public String toString() {
		return isEmpty() ? "" : value.toString();
	}
	

	public int compareTo(final Cell other) {
		if(other == null) {return 1;}	
		if (this == other) {return 0;}		
		if(isEmpty()) {return other.isEmpty() ? 0 : -1;}		
		if(other.isEmpty()) {return 1;}
		return this.value.compareTo(other.value);
	}

}

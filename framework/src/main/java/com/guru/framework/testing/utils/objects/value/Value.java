package com.guru.framework.testing.utils.objects.value;

public abstract class Value implements Comparable<Value> {
	
	public enum ValueType {BOOLEAN, INTEGER, NUMBER, MONEY, TEXT, DATE, TIME, DATETIME, UNKNOWN}

		
	public boolean isEmpty() {
		return this == getEmptyValue();
	}
	
	public abstract ValueType getType();	
	public abstract Value getEmptyValue();	
	public abstract Object getValue();
		
	
	public boolean equals(final Object other) {
		return other != null && other instanceof Value && getValue().equals(((Value)other).getValue());
	}

	public String toString() {
		return this  == getEmptyValue() ? "" : getValue().toString();
	}	

	
	public int compareTo(final Value other) {
		if (this == other) {return 0;}
		if(other == null) {return 1;}	
		if(isEmpty()) {return (other).isEmpty() ? 0 : -1;}		
		if(other.isEmpty()) {return 1;}
		return 0;
	}
	 public static ValueType getValueType(final String className){
		 if(className==null)
			 {return ValueType.TEXT;}
		 if("TextValue".equals(className))
			 {return ValueType.TEXT;}
		 if("MoneyValue".equals(className))
			 {return ValueType.MONEY;}
		 if("DateValue".equals(className))
			 {return ValueType.DATE;}
		 if("DateTimeValue".equals(className))
			 {return ValueType.DATETIME;}
		 if("IntegerValue".equals(className))
			 {return ValueType.INTEGER;}
		 if("BooleanValue".equals(className))
			 {return ValueType.BOOLEAN;}
		 return ValueType.TEXT;
	 }
	
	public static Value getEmptyValueFromType(final ValueType type) {
		switch(type) {
			case BOOLEAN: return BooleanValue.EMPTY;
			case INTEGER: return IntegerValue.EMPTY;
			case NUMBER: return NumberValue.EMPTY;
			case MONEY: return MoneyValue.EMPTY;
			case TEXT: return TextValue.EMPTY;
			case DATE: return DateValue.EMPTY;
			case DATETIME: return DateTimeValue.EMPTY;
			case TIME: return TimeValue.EMPTY;
			default: return TextValue.EMPTY;
		}
	}
}

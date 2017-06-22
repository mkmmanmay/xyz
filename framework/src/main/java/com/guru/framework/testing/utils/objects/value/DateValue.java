package com.guru.framework.testing.utils.objects.value;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class DateValue extends Value {
	
	
	 static final DateValue EMPTY = new DateValue();
	 public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	 
	 protected Calendar calendar = null; 
	 
	 protected DateValue() {
		 this.calendar = null;
	 }
	 
	 protected DateValue(final Calendar input) {
		 this(input.get(GregorianCalendar.YEAR), input.get(GregorianCalendar.MONTH), input.get(GregorianCalendar.DAY_OF_MONTH));
	 }
	 
	 protected DateValue(final int year, final int month, final int dayOfMonth) {
		 this.calendar = new GregorianCalendar(year, month, dayOfMonth);
		 if ((calendar.get(GregorianCalendar.YEAR) != year) || (calendar.get(GregorianCalendar.MONTH) != month)  || (calendar.get(GregorianCalendar.DAY_OF_MONTH) != dayOfMonth)) {
			      throw new IllegalArgumentException("Invalid java date (yyyy-MM-dd): "
			          + year + '-' + month + '-' + dayOfMonth);
	      }		
	 }
	 
	 
	 
	 //copy constructor
	 public DateValue(final DateValue other) throws IllegalArgumentException {
			if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
			if(!other.isEmpty()) {
				final Calendar cal = other.calendar;
				this.calendar = new GregorianCalendar(cal.get(GregorianCalendar.YEAR), cal.get(GregorianCalendar.MONTH), cal.get(GregorianCalendar.DAY_OF_MONTH));
			}		
		}	
	 
	 
	 public static DateValue getInstance(final String input) {
		 return getInstance(input, DEFAULT_DATE_FORMAT);
	 }
	 
	 public static DateValue getInstance(final String input, final String... format)  {
			try {	return  ValueFactory.getDateInstance(input, format);}
			catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
		}
	 
	
	 
	 
	 
	 public int getYear()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.YEAR);
	 }
	 
	 public int getMonth()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.MONTH);
	 }
	 public int getDayOfMonth()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.DAY_OF_MONTH);
	 }
	
	 
	 public  DateValue getEmptyValue() {
			return EMPTY;
		}
		
		public ValueType getType() {
			return ValueType.DATE;
		}	
	 
		public int compareTo(final Value other) {
			final int comp = super.compareTo(other);
			if(comp != 0) {return comp;}
			if(!(other instanceof DateValue)) {return 1;}			
			final DateValue otherDate = (DateValue)other;
			return this.calendar.compareTo(otherDate.calendar);
		}


	
	/*
	@Override
	public String toString() {
	    if (isEmpty()) return "";
	    return String.format("%1$d-%2$02d-%3$02d", calendar.get(GregorianCalendar.YEAR), calendar.get(GregorianCalendar.MONTH)+1, calendar.get(GregorianCalendar.DAY_OF_MONTH));
	}
*/

	@Override
	public Calendar getValue() {
		return this.calendar;
	}
	

}

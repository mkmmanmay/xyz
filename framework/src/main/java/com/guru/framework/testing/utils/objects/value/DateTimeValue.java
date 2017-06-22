package com.guru.framework.testing.utils.objects.value;



import java.util.Calendar;
import java.util.GregorianCalendar;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class DateTimeValue extends Value {
	
	static final DateTimeValue EMPTY = new DateTimeValue();
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	
	protected Calendar calendar = null;
	protected TimeValue timeValue = null;
	
	 protected DateTimeValue() {
		 this.calendar = null;
	 }
	 
	 
	 protected DateTimeValue(final Calendar input) {
		 this(input.get(GregorianCalendar.YEAR), 
				 input.get(GregorianCalendar.MONTH), 
				 input.get(GregorianCalendar.DAY_OF_MONTH),
				 input.get(GregorianCalendar.HOUR_OF_DAY),
				 input.get(GregorianCalendar.MINUTE),
				 input.get(GregorianCalendar.SECOND),
				 input.get(GregorianCalendar.MILLISECOND));
	 }
	 
	 
	
	protected DateTimeValue(final int year, final int month, final int dayOfMonth, final int hours, final int minutes, final int seconds, final int milliseconds) {
		 if ((hours >= 24) || (hours < 0)) {throw new IllegalArgumentException("This hours value is invalid: " + hours);}
		 if ((minutes >= 60) || (minutes < 0))  {throw new IllegalArgumentException("This minutes value is invalid: "  + minutes);}
		 if ((seconds >= 60) || (seconds < 0))  {throw new IllegalArgumentException("This seconds value is invalid: " + seconds);}
		 if ((milliseconds >= 1000) || (milliseconds < 0))  {throw new IllegalArgumentException("This milliseconds value is invalid: " + milliseconds);}
		 this.calendar = new GregorianCalendar(year, month, dayOfMonth, hours, minutes, seconds);
		 this.calendar.set(GregorianCalendar.MILLISECOND, milliseconds);
		 if ((calendar.get(GregorianCalendar.YEAR) != year) || (calendar.get(GregorianCalendar.MONTH) != month)  || (calendar.get(GregorianCalendar.DAY_OF_MONTH) != dayOfMonth)) {
		      throw new IllegalArgumentException("Invalid java date (yyyy-MM-dd): "
		          + year + '-' + month + '-' + dayOfMonth);
		 }	
	 }

	
	 //copy constructor
	 public DateTimeValue(final DateTimeValue other) {
			if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
			if(!other.isEmpty()) {
				final Calendar cal = other.calendar;
				this.calendar = new GregorianCalendar(cal.get(GregorianCalendar.YEAR), 
						cal.get(GregorianCalendar.MONTH), 
						cal.get(GregorianCalendar.DAY_OF_MONTH),
						 cal.get(GregorianCalendar.HOUR_OF_DAY),
						  cal.get(GregorianCalendar.MINUTE),
						  cal.get(GregorianCalendar.SECOND));
				this.calendar.set(GregorianCalendar.MILLISECOND, cal.get(GregorianCalendar.MILLISECOND));
			}		
		}	
	
	 public static DateTimeValue getInstance(final String input) {
		 return getInstance(input, "yyyy-MM-dd", "yyyy/MM/dd HH:mm:ss", "MM/dd/yyyy", "M/d/yyyy h:mm",  DEFAULT_DATETIME_FORMAT);
	 }
	 
	 public static DateTimeValue getInstance(final String input, final String... format)  {
			try {	return  ValueFactory.getDateTimeInstance(input, format);}
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
	 
	 public int getHours()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.HOUR_OF_DAY);
	 }
	 
	 public int getMinutes()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.MINUTE);
	 }
	 public int getSeconds()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.SECOND);
	 }
	 public int getMilliseconds()  { 
		 return isEmpty() ? -1 : this.calendar.get(GregorianCalendar.MILLISECOND);
	 }
	
	
	

	 public int compareTo(final Value other) {
		 final int comp = super.compareTo(other);
			if(comp != 0) {return comp;}
			if(!(other instanceof DateTimeValue)) {return 1;}			
			final DateTimeValue otherDate = (DateTimeValue)other;
			return this.calendar.compareTo(otherDate.calendar);
		}


	 public  DateTimeValue getEmptyValue() {
			return EMPTY;
		}
		
		public ValueType getType() {
			return ValueType.DATETIME;
		}	
	
		@Override
		public Calendar getValue() {
			return this.calendar;
		}	
		
		@Override
		public String toString() {
			if(isEmpty()) {return "";}
			String resultDate = String.format("%1$d-%2$02d-%3$02d %4$02d:%5$02d:%6$02d",
					this.getValue().get(GregorianCalendar.YEAR), 
					this.getValue().get(GregorianCalendar.MONTH)+1, 
					this.getValue().get(GregorianCalendar.DAY_OF_MONTH),
					this.getValue().get(GregorianCalendar.HOUR_OF_DAY), 
					this.getValue().get(GregorianCalendar.MINUTE), 
					this.getValue().get(GregorianCalendar.SECOND));
			 if (this.getValue().get(GregorianCalendar.MILLISECOND) > 0) {resultDate += "." + String.format("%1$03d", this.getValue().get(GregorianCalendar.MILLISECOND));} 
			    return resultDate;
		}
	 
	/*	public static void main(String[] args) throws Exception {
			System.out.println(getInstance("2011/05/10 00:00:00").getValue().toString());
			System.out.println(getInstance("2011-11-24").getValue().toString());
			
			System.out.println(ValueFactory.getDateTimeInstance("6/6/2002 0:00", ""));
		}*/

}

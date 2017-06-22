package com.guru.framework.testing.utils.objects.value;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeValue extends Value {
	
	static final TimeValue EMPTY = new TimeValue();
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss.SSS";
	
	 protected Calendar calendar = null; 

	 protected TimeValue() {
		 this.calendar = null;
	 }
	
	 protected TimeValue(final Calendar input) {
		 this(input.get(GregorianCalendar.HOUR_OF_DAY),
				 input.get(GregorianCalendar.MINUTE),
				 input.get(GregorianCalendar.SECOND),
				 input.get(GregorianCalendar.MILLISECOND));
	 }
	
	protected TimeValue(final int hours, final int minutes, final int seconds, final int milliseconds) {			
		 if ((hours >= 24) || (hours < 0)) {throw new IllegalArgumentException("This hours value is invalid: " + hours);}
		 if ((minutes >= 60) || (minutes < 0))  {throw new IllegalArgumentException("This minutes value is invalid: "  + minutes);}
		 if ((seconds >= 60) || (seconds < 0))  {throw new IllegalArgumentException("This seconds value is invalid: " + seconds);}
		 if ((milliseconds >= 1000) || (milliseconds < 0))  {throw new IllegalArgumentException("This milliseconds value is invalid: " + milliseconds);}
		 this.calendar = new GregorianCalendar();
		 this.calendar.set(Calendar.HOUR_OF_DAY, hours);
		 this.calendar.set(Calendar.MINUTE, minutes);
		 this.calendar.set(Calendar.SECOND, seconds);
		 this.calendar.set(Calendar.MILLISECOND, milliseconds);
	 }
	
	
	//copy constructor
		 public TimeValue(final TimeValue other)  {
				if(other == null){ throw new IllegalArgumentException("Can not clone a null value");}
				if(!other.isEmpty()) {
					final Calendar cal = other.calendar;
					 this.calendar = new GregorianCalendar();
					 this.calendar.set(Calendar.HOUR_OF_DAY, cal.get(GregorianCalendar.HOUR_OF_DAY));
					 this.calendar.set(Calendar.MINUTE, cal.get(GregorianCalendar.MINUTE));
					 this.calendar.set(Calendar.SECOND, cal.get(GregorianCalendar.SECOND));
					 this.calendar.set(Calendar.MILLISECOND, cal.get(GregorianCalendar.MILLISECOND));
					 this.calendar = new GregorianCalendar(cal.get(GregorianCalendar.YEAR), cal.get(GregorianCalendar.MONTH), cal.get(GregorianCalendar.DAY_OF_MONTH));
				}		
			}	
		 
		 
		 public static TimeValue getInstance(final String input) {
			 return getInstance(input, DEFAULT_TIME_FORMAT);
		 }
		 
		 public static TimeValue getInstance(final String input, final String... format)  {
				try {	return  ValueFactory.getTimeInstance(input, format);}
				catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
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
				if(!(other instanceof TimeValue)) {return 1;}
				final TimeValue otherDate = (TimeValue)other;
				return this.calendar.compareTo(otherDate.calendar);
			}

	

	 public  TimeValue getEmptyValue() {
			return EMPTY;
		}
		
		public ValueType getType() {
			return ValueType.TIME;
		}	
	
		@Override
		public Calendar getValue() {
			return this.calendar;
		}

}

package com.guru.framework.testing.utils.objects.value;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ValueFactory {
	
	private static final Logger logger = Logger.getLogger(ValueFactory.class.getName());
	
	// not designed for all locales
	public static MoneyValue getMoneyInstance(final String value, final String currencyCode) throws ParseException {
		if(null == value || value.trim().length() == 0) {return MoneyValue.EMPTY;}
		if(value.contains(Currency.getInstance(currencyCode).getSymbol()))		
			{return new MoneyValue(getMoneyFormat(currencyCode).parse(value).doubleValue(), currencyCode);}		
		return new MoneyValue(NumberFormat.getInstance().parse(value).doubleValue(), currencyCode);
	}
		
	public static IntegerValue getIntegerInstance(final String value) throws ParseException {
		if(null == value || value.trim().length() == 0) {return IntegerValue.EMPTY;}
		return new IntegerValue(NumberFormat.getIntegerInstance().parse(value).intValue());		
	}
	
	public static NumberValue getNumberInstance(final String value) throws ParseException {
		if(null == value || value.trim().length() == 0) {return NumberValue.EMPTY;}
		int scale  = 0;
		final int index  = value.indexOf('.');
		if(index >=0)
			{scale  = value.length() - index -1;}
		return new NumberValue(NumberFormat.getInstance().parse(value).doubleValue(), scale);		
	}
	
	
	public static BooleanValue getBooleanInstance(final String value) throws ParseException {
		if(null == value || value.trim().length() == 0) {return BooleanValue.EMPTY;}
		return new BooleanValue(Boolean.parseBoolean(value));		
	}
	
	public static TextValue getTextInstance(final String value) {
		if(null == value || value.trim().length() == 0 || value.trim().equals(".") ) {return TextValue.EMPTY;}
		return new TextValue(value);		
	}
	
	public static DateValue getDateInstance(final String date, final String... formats) throws Exception {
		 if(date == null || date.trim().length() == 0 ) {return DateValue.EMPTY;}		 
		 final Calendar cal = GregorianCalendar.getInstance();
		 if(formats.length == 0) {			
			 cal.setTime(new SimpleDateFormat(DateValue.DEFAULT_DATE_FORMAT).parse(date));
			 return new DateValue(cal);
		 }
		 for(String each : formats) { // attempts to parse date using formats provided
			 try {
				 cal.setTime(new SimpleDateFormat(each).parse(date));
				 return new DateValue(cal);
			 }
			 catch(ParseException pe) {logger.log(Level.SEVERE, pe.getMessage());}
		 }
		 throw new IllegalArgumentException("Unable to parse date " + date);		 
	 }
	
	 public static TimeValue getTimeInstance(final String time, final String... formats) throws Exception {
		 if(time == null || time.trim().length() == 0 ) {return TimeValue.EMPTY;}		 
		 final Calendar cal = GregorianCalendar.getInstance();
		 if(formats.length == 0) {			
			 cal.setTime(new SimpleDateFormat(TimeValue.DEFAULT_TIME_FORMAT).parse(time));
			 return new TimeValue(cal);
		 }
		 for(String each : formats) { // attempts to parse date using formats provided
			 try {
				 cal.setTime(new SimpleDateFormat(each).parse(time));
				 return new TimeValue(cal);
			 }
			 catch(ParseException pe) {logger.log(Level.SEVERE, pe.getMessage());}
		 }
		 throw new Exception("Unable to parse time " + time);		 
	 }
	 
	 public static DateTimeValue getDateTimeInstance(final String time, String... formats) throws Exception {
		 final  String[] defaultDateTimeFormats = {"yyyy-MM-dd", "yyyy/MM/dd HH:mm:ss", "MM/dd/yyyy",  "M/d/yyyy h:mm", "yyyy-MM-dd HH:mm:ss"};
		 
		 if(time == null || time.trim().length() == 0 ) {return DateTimeValue.EMPTY;}		 
		 final Calendar cal = GregorianCalendar.getInstance();
		 if(formats.length == 0 || formats[0] == null || formats[0].trim().length() == 0) {	
			 formats = defaultDateTimeFormats;
	//		 cal.setTime(new SimpleDateFormat(DateTimeValue.DEFAULT_DATETIME_FORMAT).parse(time));
	//		 return new DateTimeValue(cal);
		 }
		 for(String each : formats) { // attempts to parse date using formats provided
			 try {
				 cal.setTime(new SimpleDateFormat(each).parse(time));
				 return new DateTimeValue(cal);
			 }
			 catch(ParseException pe) {logger.log(Level.SEVERE, pe.getMessage());}
		 }
		 throw new Exception("Unable to parse time " + time);		 
	 }
	
	
	public static Value getInstance(final String className, final String value, final String[] formats) throws Exception {
		if(null == className)
			{throw new IllegalArgumentException("Can not instantiate a Value with a null class name");}
		if(className.endsWith(".BooleanValue")) {
			{return ValueFactory.getBooleanInstance(value);}
		}
		if(className.endsWith(".DateValue")) {
			{return ValueFactory.getDateInstance(value, formats);}
		}
		if(className.endsWith(".DateTimeValue")) {
			{return ValueFactory.getDateTimeInstance(value, formats);}
		}
		if(className.endsWith(".IntegerValue")) {
			{return ValueFactory.getIntegerInstance(value);}
		}
		if(className.endsWith(".MoneyValue")) {
			{return ValueFactory.getMoneyInstance(value, "USD");}
		}
		if(className.endsWith(".NumberValue")) {
			{return ValueFactory.getNumberInstance(value);}
		}
		if(className.endsWith(".TextValue")) {
			{return ValueFactory.getTextInstance(value);}
		}
		if(className.endsWith(".TimeValue")) {
			{return ValueFactory.getTextInstance(value);}
		}		
		throw new IllegalArgumentException("Can not instantiate a Value with a class name=" + className);
	}
	 
	
	public static String print(final Value value) throws ParseException {
		if(value == null || value.isEmpty()) {return "";}
		if(value instanceof MoneyValue) {
			final MoneyValue money = (MoneyValue)value;
			return getMoneyFormat(money.getCurrency().getCurrencyCode()).format(money.getValue().doubleValue());
		}
		if(value instanceof IntegerValue) {
			final IntegerValue number = (IntegerValue)value;
			return NumberFormat.getIntegerInstance().format(number.getValue().intValue());
		}		
		if(value instanceof NumberValue) {
			final NumberValue number = (NumberValue)value;
			return getNumberFormat(number.getValue().scale()).format(number.getValue().doubleValue());
		}	
		if(value instanceof DateValue) {
			final DateValue curr = (DateValue)value;
		    return String.format("%1$d-%2$02d-%3$02d", 
		    		curr.getValue().get(GregorianCalendar.YEAR), 
		    		curr.getValue().get(GregorianCalendar.MONTH)+1, 
		    		curr.getValue().get(GregorianCalendar.DAY_OF_MONTH));
		}		
		if(value instanceof TimeValue) {
			final TimeValue curr = (TimeValue)value;
		    String resultTime =  String.format("%1$02d:%2$02d:%3$02d", 
		    		curr.getValue().get(GregorianCalendar.HOUR_OF_DAY), 
		    		curr.getValue().get(GregorianCalendar.MINUTE), 
		    		curr.getValue().get(GregorianCalendar.SECOND));
		    if (curr.getValue().get(GregorianCalendar.MILLISECOND) > 0) {resultTime += "." + String.format("%1$03d", curr.getValue().get(GregorianCalendar.MILLISECOND));} 
		    return resultTime;
		    
		}	
		if(value instanceof DateTimeValue) {
			final DateTimeValue curr = (DateTimeValue)value;
			String resultDate = String.format("%1$d-%2$02d-%3$02d %4$02d:%5$02d:%6$02d",
					curr.getValue().get(GregorianCalendar.YEAR), 
		    		curr.getValue().get(GregorianCalendar.MONTH)+1, 
		    		curr.getValue().get(GregorianCalendar.DAY_OF_MONTH),
		    		curr.getValue().get(GregorianCalendar.HOUR_OF_DAY), 
		    		curr.getValue().get(GregorianCalendar.MINUTE), 
		    		curr.getValue().get(GregorianCalendar.SECOND));
			 if (curr.getValue().get(GregorianCalendar.MILLISECOND) > 0) {resultDate += "." + String.format("%1$03d", curr.getValue().get(GregorianCalendar.MILLISECOND));} 
			    return resultDate;
		}		
		return value.toString();
	}
	
	
	private static NumberFormat getMoneyFormat(final String currencyCode) {
		final NumberFormat nf = NumberFormat.getCurrencyInstance();
		final Currency curr = Currency.getInstance(currencyCode);
		nf.setCurrency( curr );
		nf.setGroupingUsed( true );
		nf.setMaximumFractionDigits( curr.getDefaultFractionDigits() );		
		return nf;
	}
	
	private static NumberFormat getNumberFormat(final int scale) {
		final NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(scale);		
		return nf;
	}
	
	//public static void main (final String[] args) throws Exception {
		//System.out.println(print(getMoneyInstance("$3,234,345.67", "USD")));
		//System.out.println(print(getMoneyInstance("$234,345.67", "USD")));
		//System.out.println(print(getMoneyInstance("234.45", "USD")));
		//System.out.println(print(getMoneyInstance("($2,456.00)", "USD")));
		//System.out.println(print(getMoneyInstance("($0.67)", "USD")));
		//System.out.println(print(getMoneyInstance("-3,234,345.67", "USD")));
		//System.out.println(print(getMoneyInstance("-3,234,345", "USD")));
		//System.out.println(print(getNumberInstance("-3,234,345.57575556")));
		//System.out.println(print(getDateInstance("2101-06-08")));
		//System.out.println(print(getTimeInstance("08:09:02.026")));
		//System.out.println(print(getDateTimeInstance("2011/05/10 00:00:00")));
	
	//}
}

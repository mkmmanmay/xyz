package com.guru.framework.testing.utils.objects;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.guru.framework.testing.logger.ScriptLogger;

public class StringUtils {
	
	
	
	/**
	 * 	
	 * @param source
	 * @param left
	 * @param right
	 * @param index
	 * @return
	 */
    public static String betweenStrings(final String source, final String left, final String right, final int index) {             
        if(source == null || left == null || right == null)
        { throw new IllegalArgumentException("Null input values are not allowed");}
        if(index <= 0)
               {throw new IllegalArgumentException("Negative index is not allowed");}
        if(left.length() == 0 && right.length() == 0)
               {return source;}
        int pos = -1;
        if(left.length() == 0) {
               pos = findNthStringIndex(source, right, index);
               if(pos >= 0)
                     {return source.substring(0, pos);}
               else 
                     {return null;}
        }
        if(right.length() == 0) {
               pos = findNthStringIndex(source, left, index);
               if(pos >= 0)
                     {return source.substring(pos + left.length());}
               else 
                     {return null;}
        }      
        int leftIndex = source.indexOf(left);
        int rightIndex = source.lastIndexOf(right);
      //  System.out.println("Lindex: " + leftIndex + ", Rindex: " + rightIndex);
        if(leftIndex < 0 || rightIndex < 0 || leftIndex >= rightIndex)
               {return null;}
        // we have at least one candidate - keep moving the right first then left
        int cand = rightIndex;
        while(cand > leftIndex) {
               if((cand = source.lastIndexOf(right, cand-1)) > leftIndex)
               { rightIndex = cand;}
        }
        cand = leftIndex;
        while(cand > 0 && cand < rightIndex) {
               if((cand = source.indexOf(left, cand+1)) < rightIndex && cand > 0)
                     {leftIndex = cand;}
        }
     //   System.out.println("Lindex: " + leftIndex + ", Rindex: " + rightIndex);
        if(index == 1) {
               return source.substring(leftIndex + left.length(), rightIndex);                   
        }             
      //  System.out.println(source.substring(rightIndex + right.length()));
        return  betweenStrings(source.substring(rightIndex + right.length()), left, right, index-1);
    }
	
	
    /**
     * 
     * @param source
     * @param left
     * @param right
     * @return
     */
	public static List<String> stringsBetween(final String source, final String left, final String right) {
		final List<String> list = new ArrayList<String>();
		if(source == null || left == null || right == null) {throw new IllegalArgumentException("Null values are not allowed");}
		if((left.length() == 0 && source.indexOf(right) < 0) || (right.length() == 0 && source.indexOf(left) < 0)) {return list;}
		if(left.length() == 0 && right.length() == 0)  {
			list.add(source);
			return list;
		}
		if(left.length() == 0 && source.indexOf(right) >= 0) {
			list.add(source.substring(0, source.indexOf(right)));
			return list;
		}
		if(right.length() == 0 && source.indexOf(left) >= 0) {
			list.add(source.substring(source.indexOf(left) + left.length()));
			return list;
		}		
		
		// find all innermost matches
		int rightIndex = 0, leftIndex = 0;		
		do {
			rightIndex= source.indexOf(right, rightIndex);
			if((leftIndex = source.lastIndexOf(left, rightIndex-1)) >= 0) {				
				list.add(source.substring(leftIndex + left.length(), rightIndex));
			}			
			if(rightIndex >= 0)
				{rightIndex += right.length();}
		} while(rightIndex >= 0);
		
		return list;		
	}
	
	/**
	 * 
	 * @param source
	 * @param left
	 * @param right
	 * @param value
	 * @return
	 */
	public static boolean valuePresent(final String source, final String left, final String right, final String value)
	{
		if(null == source || null == left || null == right)
			{return false;}
		final ArrayList<String> arrVals = (ArrayList<String>)stringsBetween(source, left, right);
		if(arrVals==null || arrVals.size()==0) {return false;}
		for (String val:arrVals){
			if((val==null && value==null)||val.equals(value))	{
				return true;
			}
		}		
		return false;
	}
	
	/**
	 * 
	 * @param source
	 * @param left
	 * @param right
	 * @param index
	 * @return
	 */
	public static String stringBetween(final String source, final String left, final String right, final int index) {
		try {
			return stringsBetween(source, left, right).get(index-1);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int countOccurrences(final String haystack, final char needle) {
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++)   {
	        if (haystack.charAt(i) == needle) {
	             count++;
	        }
	    }
	    return count;
	}
	
	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @param index
	 * @return
	 */
    private static int findNthStringIndex(final String haystack, final String needle, final int index) {
        if(haystack == null || needle == null)
        { throw new IllegalArgumentException("Null input values are not allowed");}
        if(index <= 0)
        { throw new IllegalArgumentException("Negative index is not allowed");}
        int count = 0;
        int pos = -1;
        do {
               pos = haystack.indexOf(needle, pos + 1);
               
        } while(++count < index && pos >= 0);
        
        return pos;
    }
    
    /**
     * 
     * @param source
     * @param elementName
     * @return
     */
    private static String getElementValue(final String source, final String elementName, final int index)
    {
    	final String left = "<"+elementName;
    	final String right = "</" +elementName + ">";
    	
    	String value = betweenStrings(source, left, right, index);
    	if (null == value) {return null;}
    	
    	value = betweenStrings(value, ">", "", 1);
    	return value;
    }
    
    
    /**
     * 
     * @param source
     * @param elementName
     * @param attribute
     * @param index
     * @return
     */
   /* private static String getElementAttributeValue(String source, String elementName, String attribute, int index)
    {
    	String left = "<"+elementName;
    	String right = "</" +elementName + ">";
    	    	
    	String value = betweenStrings(source, left, right, index);
    	if(null == value) return null;
    	
    	left = attribute + "=\"";
    	right= "\"";
    	value = betweenStrings(value, left, right, 1);
    	
    	return value;
    }*/
	
    /**
     * 
     * @param source
     * @param elementName
     * @return
     */
    public static String getFirstValueOfElement(final String source, final String elementName)
    {
    	if(source==null) {return null;}
    	if(elementName==null){ return null;}
    	return getElementValue(source, elementName, 1);
    }
    
    /**
     * 
     * @param source
     * @param elementName
     * @return
     */
    public static String getLastValueOfElement(final String source, final String elementName)
    {
    	if(source==null){ return null;}
    	if(elementName==null){ return null;}
    	return getElementValue(source, elementName, source.lastIndexOf(elementName));
    }
    
    /**
     * 
     * @param source
     * @param elementName
     * @param index
     * @return
     */
    public static String getNthValueOfElement(final String source, final String elementName, final int index)
    {
    	if(source==null) {return null;}
    	if(elementName==null) {return null;}
    	if(index<=0){ return null;}
    	return getElementValue(source, elementName, index);
    }
    
    /**
     * 
     * @param source
     * @param left
     * @param right
     * @param index
     * @return
     */
    public static String getStringBetween(final String source, final String left, final String right, final int index)
    {
    	if(source==null) {return null;}
    	if(left==null) {return null;}
    	if(right==null) {return null;}
    	if(index<=0) {return null;}
    	
    	return betweenStrings(source, left, right, index);
    }
    
    
    /**
	 * Converts a String representing currency value into Float
	 * currency format that allows optional $, optional &quot;-&quot;(MinusSignNegative) 
	 * OR &quot;()&quot; (ParenNegative) but not both, optional cents, and optional commas separating thousands. 
	 * Minus sign can be before or after $, but parens must be outside the $. 
	 * UPDATED: now fails to match a &quot;$&quot; without any further numbers
	 * @param input	String to convert
	 * @return Float representation of currency value
	 * @throws Exception When input can not be converted into Float
	 */
	public static Float fromCurrencyToFloat(final String input) throws Exception {		
		final String currencyRegEx = "^\\$?\\-?([1-9]{1}[0-9]{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\-?\\$?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))$|^\\(\\$?([1-9]{1}\\d{0,2}(\\,\\d{3})*(\\.\\d{0,2})?|[1-9]{1}\\d{0,}(\\.\\d{0,2})?|0(\\.\\d{0,2})?|(\\.\\d{1,2}))\\)$";
		try {
			if(input.matches(currencyRegEx)) {
				String temp = input.replace("$", "").replaceAll("\\,", "");
				if(temp.contains("(")) {
					temp = "-" + temp.replace("(", "").replace(")", "");					
				}
				return Float.valueOf(temp);
			}
		}
		catch(Throwable t) {
			throw new Exception("Can not parse currency value: " + input, t);
		}
		throw new Exception("Can not parse value as currency: " + input);		
	}
	
	/**
	 * Converts a string representing a real number into Double
	 * This matches any real number, with optional decimal point and numbers after the decimal, 
	 * and optional positive (+) or negative (-) designation.
	 * @param input	String to convert
	 * @return Double representation of the real number
	 * @throws Exception When input can not be converted to Double
	 */
	public static Double fromRealToDouble(final String input) throws Exception {
		final String realRegEx = "^[-+]?\\d+(\\.\\d+)?$";
		try {
			if(input.matches(realRegEx)) {
				return Double.valueOf(input);
			}
		}
		catch(Throwable t) {
			throw new Exception("Can not parse real value: " + input, t);
		}
		throw new Exception("Can not parse value as real number: " + input);	
	}	

	/**
     * Simple attempt to parse date or date/time
     * @param candidate
     * @return
     * @throws Exception
     */
     public static Date parseDate(final String candidate, final String...formats) throws Exception {
    	 if(formats.length == 0)	{return new SimpleDateFormat().parse(candidate);}         	
         for(String format : formats) {
             try {  return new SimpleDateFormat(format).parse(candidate); }
             catch(Exception e) { continue; }
         }
         throw new Exception("Can not parse value as date:" + candidate);
     }
     
     /**
      * Split a String in equal parts
      * @param text, size
      * @return List<String>
      * @throws Exception
      */
     public static List<String> splitEqually(final String text, final int size) throws Exception{
    	    // Give the list the right capacity to start with.
    	 final List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

    	    for (int start = 0; start < text.length(); start += size) {
    	        ret.add(text.substring(start, Math.min(text.length(), start + size)));
    	    }
    	    return ret;
    	}
     
     
     
     /**
      * Split a String by symbol provided
      * @param data,symbol
      * @return String[]
      * @throws Exception
      */
     public static String[] splitDataBySymbol(String data,String symbol) throws Exception {
 		String[] array=data.split("\\"+symbol);
 		return array;
 	}
     
     
     /**
      * Generate Random alpha numeric String of provided length
      * @param length
      * @return String
      * @throws Exception
      */
     
     public static String generateRandomString(int len) {

    	String alphaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	 SecureRandom rnd = new SecureRandom();
    	    StringBuilder sb = new StringBuilder( len );
    	    for( int i = 0; i < len; i++ ) 
    	       sb.append( alphaNum.charAt( rnd.nextInt(alphaNum.length()) ) );
    	    return sb.toString();
    	 }
}

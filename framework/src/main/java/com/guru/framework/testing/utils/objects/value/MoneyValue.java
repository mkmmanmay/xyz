package com.guru.framework.testing.utils.objects.value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class MoneyValue extends Value {
		
	private BigDecimal amount = null;
	private Currency currency = null;
	
	static final MoneyValue EMPTY = new MoneyValue();
	public static String DEFAULT_CURRENCY_CODE = "USD";
	
	
	protected MoneyValue() {
		this.amount = null;
		this.currency = null;
	}
	
	protected MoneyValue(final long amount) {
		this(amount, DEFAULT_CURRENCY_CODE);
	}
	
	protected MoneyValue(final long amount, final String currencyCode) {
		this.currency = Currency.getInstance(currencyCode);
		this.amount = BigDecimal.valueOf(amount, currency.getDefaultFractionDigits());
	}
	/*
	protected MoneyValue(BigDecimal amount) {
		this(amount, DEFAULT_CURRENCY_CODE);
	}
	
	protected MoneyValue(BigDecimal amount, String currencyCode) {
//		System.out.println(currencyCode);
		this.currency = Currency.getInstance(currencyCode);
		this.amount = amount;
	}*/
	
	
	protected MoneyValue(final double amount) {
		this(amount, DEFAULT_CURRENCY_CODE);
	}
	
	protected MoneyValue(final double amount, final String currencyCode) {	
		this.currency = Currency.getInstance(currencyCode);
		final BigDecimal bd = BigDecimal.valueOf( amount );
	    this.amount = bd.setScale( currency.getDefaultFractionDigits(), RoundingMode.HALF_DOWN);
	}
	
	public MoneyValue(final MoneyValue other) throws IllegalArgumentException {
		if(other == null) {throw new IllegalArgumentException("Can not clone a null value");}
		if(!other.isEmpty()) {
			this.currency = other.currency;
			this.amount = new BigDecimal(other.amount.doubleValue());
		}		
	}	
		
	public static MoneyValue getInstance(final String input)  {
		try {	return  ValueFactory.getMoneyInstance(input, DEFAULT_CURRENCY_CODE);}
		catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
	}
	
	public static MoneyValue getInstance(final String input, final String currencyCode)  {
		try {	return  ValueFactory.getMoneyInstance(input, currencyCode);	}
		catch(Exception e) {	throw new IllegalArgumentException( "Can not parse input=" + input, e);	}
	}
	
	public BigDecimal getValue() {
		return this.amount;
	}
	
	public Currency getCurrency() {
		return this.currency;
	}
	
	public  MoneyValue getEmptyValue() {
		return EMPTY;
	}
	
	public ValueType getType() {
		return ValueType.MONEY;
	}	
		
	
	public int compareTo(final Value other) {
		final int comp = super.compareTo(other);
		if(comp != 0) {return comp;}
		if(!(other instanceof MoneyValue)) {return 1;}
		final MoneyValue val = (MoneyValue)other;
		if(!this.currency.equals(val.currency)) {return 1;}
		return this.amount.compareTo(val.amount);
	}
	
	@Override
	public int hashCode() {
		final int hash = (int) (amount.hashCode() ^ (amount.hashCode() >>> 32));
		return hash;
	}
	
	
	@Override
	public String toString() {
		if(this.isEmpty()) {return "";}
		return this.amount.toPlainString();
	}
		
}

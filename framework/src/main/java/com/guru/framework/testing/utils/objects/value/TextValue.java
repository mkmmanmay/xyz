package com.guru.framework.testing.utils.objects.value;

public class TextValue extends Value {
	
	 static final TextValue EMPTY = new TextValue();
	 
	 protected String value = null;
	 
	 protected TextValue()  {
	     this("");
	 }
	 
	 protected TextValue(final String input)  { 
	     this.value = input;
	 }
	 
	 public static TextValue getInstance(final String input) {
		return  ValueFactory.getTextInstance(input);
	 }
	
	 public String getValue() {
		 return this.value;
	 }
	 
	 
	public  TextValue getEmptyValue() {
		return EMPTY;
	}
	
	
	public ValueType getType() {
		return ValueType.TEXT;
	}

	@Override
	public int compareTo(final Value other) {
		final int comp = super.compareTo(other);
		if(!(other instanceof TextValue)) {return 1;}
		return comp == 0 ? this.value.compareTo(((TextValue)other).value) : comp;	
	}

	
	public void toUpper() {
		if(!isEmpty())
			{this.value = this.value.toUpperCase();}
	}
	
	public void toLower() {
		if(!isEmpty())
			{this.value = this.value.toLowerCase();}
	}
	
	public static void main(final String[] args) {
		// System.out.println("TextValue.getInstance>>>"+TextValue.getInstance(null).getValue());
	//	 System.out.println("null" + TextValue.getInstance(null));
	//	 System.out.println(TextValue.getInstance("test"));
	}
	
}




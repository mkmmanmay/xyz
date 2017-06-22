package com.guru.framework.testing.utils.objects.value;
import com.guru.framework.testing.utils.objects.value.Value.ValueType;

/**
 * Represents a DataTable with id, type, label, format and TestProperties
 * @author Isha Sharma
 *
 */
public class Column {

	protected String id;
	protected ValueType type;
	protected String label;
	protected String format;

	public Column(final String id, final Value.ValueType type, final String label) {
		this(id, type, label, "");	
	}
	
	public Column(final String id, final Value.ValueType type, final String label, final String format)  {
		if(null == id)		{throw new IllegalArgumentException("Column id is required");}
		if(null == type)	{throw new IllegalArgumentException("Column type is required");}
		this.id = id;
		this.type = type;
		setLabel(label);
		setFormat(format); 	
	}
		

	public Column(final Column other) {
		this(other.getId(), other.getType(), other.getLabel(), other.getFormat());
	}

	public String getId() 				{	return this.id;	}
	public ValueType getType() 			{	return this.type;	}
	public String getLabel() 			{	return this.label;	}
	public String getFormat() 			{	return this.format;	}
		
	public void setLabel(final String label) 	 { 	this.label = label;	}
	public void setFormat(final String format) {	this.format = format; }
	
	// TestProperties are not the part of comparison
	@Override
	public boolean equals(final Object other) {
		if(this == other) {return true;}
		if(other == null) {return false;}
		if(!(other instanceof Column)) {return false;}
		if(!this.id.equals(((Column)other).getId())) {return false;}
		if(!this.type.equals(((Column)other).getType())) {return false;}
		if(!this.label.equals(((Column)other).getLabel())) {return false;}
		if(!this.format.equals(((Column)other).getFormat())) {return false;}
		return true;
	}
	
	 @Override
	 public String toString() {
		 final  StringBuilder sb = new StringBuilder();
	    sb.append("Column = {").append("id=").append(id).append(", type=").append(type.toString());
	    if(label != null) {sb.append(", label=").append(label);}
	    if(format != null)	{sb.append(", format=").append(format);}
	    sb.append("}");
	    return sb.toString();
	  }	  

}

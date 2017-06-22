package com.guru.framework.testing.database.objects;

/**
 * 
 * @author Isha Sharma
 * Value object that represents a database parameter (for example for stored procedures)
 * @version 1.0.0
 */
public class ParameterMetadata implements Comparable<ParameterMetadata> {
		
	private String name;
	private int type;
	private int dataType;
	private String dataTypeName;
	private boolean nullable;
	private int sequence;
		
	public ParameterMetadata(final String name, final int type, final int dataType, final String dataTypeName, final boolean nullable, final int sequence) {
		this.name = name;
		this.type = type;
		this.dataType = dataType;
		this.dataTypeName = dataTypeName;
		this.nullable = nullable;
		this.sequence = sequence;		
	}
	
	public String getName() { return this.name; }
	public int getType() { return this.type; }
	public int getDataType() { return this.dataType; }
	public String getDataTypeName() { return this.dataTypeName; }
	public boolean isNullable() { return this.nullable; }
	public int getSequence() { return this.sequence; }
	
	
	public int compareTo(final ParameterMetadata arg0) {
		return arg0.getSequence() - this.getSequence();
	}
	
	public String print() {
		return new StringBuffer()
			.append("{name=").append(this.getName())
			.append(",type=").append(this.getType())
			.append(",dataType=").append(this.getDataType())
			.append(",dataTypeName=").append(this.getDataTypeName())
			.append(",nullable=").append(this.isNullable())
			.append(",sequence=").append(this.getSequence())
			.append("}").toString();
	}	
}


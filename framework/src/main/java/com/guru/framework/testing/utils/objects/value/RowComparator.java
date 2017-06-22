package com.guru.framework.testing.utils.objects.value;

import java.util.Comparator;


public class RowComparator implements Comparator<Row>{

	public enum SortOrder {
		ASC("ASC"), 
		DESC("DESC");
		private final String value;
		SortOrder(final String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	
	KeyValuePair[] keyVals;
	
	public RowComparator(final KeyValuePair... keyVals){
		for(KeyValuePair each : keyVals) {
			if(!each.getValue().toString().equals(SortOrder.ASC.getValue()) &&  !each.getValue().toString().equals(SortOrder.DESC.getValue()))
				{throw new IllegalArgumentException("Invalid sort order for=" + each);}
		}
		this.keyVals = keyVals;
	}
	
	/**
	 * 
	 */
	public int compare(final Row row1, final Row row2) {
		for (int i=0; i<keyVals.length; i++){
			final KeyValuePair keyVal  = keyVals[i];
			final Value val1 = row1.getCell(Integer.parseInt(keyVal.getKey().toString())).getValue();
			final Value val2 = row2.getCell(Integer.parseInt(keyVal.getKey().toString())).getValue();
			final int comp = val1.compareTo(val2);
			if(comp == 0) {continue;}	
			return keyVal.getValue().toString() == SortOrder.ASC.getValue() ? comp : 0-comp;
		}
		return 0;
	}
}

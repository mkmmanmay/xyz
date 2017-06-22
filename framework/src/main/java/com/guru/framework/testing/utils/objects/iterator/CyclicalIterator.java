/**
 * Returns Rows from the DataTable in a cyclicly order
 * 	
 * @since 0.0.2 Feb 3, 2013
 * @see 
 * @author Isha Sharma
 */
package com.guru.framework.testing.utils.objects.iterator;

import com.guru.framework.testing.utils.objects.value.DataTable;

public class CyclicalIterator extends DataTableIterator {
		
	/**
	 * Instantiates a new cyclicly iterator.
	 *
	 * @param table the table
	 */
	public CyclicalIterator(final DataTable table) {
		super(table);
	}
	
	/**
	 * Instantiates a new cyclical iterator.
	 *
	 * @param table the table
	 * @param iterations the iterations
	 */
	public CyclicalIterator(final DataTable table, final int iterations) {
		super(table, iterations);
	}
	
	@Override
	protected void advanceCurrent() {
		current = current < this.dataTable.getRowCount()-1 ? current+1 : 0;		
	}

}

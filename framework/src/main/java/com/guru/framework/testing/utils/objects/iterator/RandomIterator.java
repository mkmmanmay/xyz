/**
 * Returns random Rows from the DataTable
 * 	
 * @since 0.0.2 Feb 3, 2013
 * @see 
 * @author Mike Yushchenko
 */
package com.guru.framework.testing.utils.objects.iterator;

import java.util.Random;

import com.guru.framework.testing.utils.objects.value.DataTable;

public class RandomIterator extends DataTableIterator {

	/**
	 * Instantiates a new random iterator.
	 *
	 * @param table the data table
	 */
	public RandomIterator(final DataTable table) {
		this(table, table.getRowCount());
	}
	
	/**
	 * Instantiates a new random iterator.
	 *
	 * @param table the data table
	 * @param iterations the iterations
	 */
	public RandomIterator(final DataTable table, final int iterations) {
		super(table, iterations);
		advanceCurrent();
	}
	
	
	@Override
	protected void advanceCurrent() {
		current = (new Random()).nextInt(this.dataTable.getRowCount());		
	}

}

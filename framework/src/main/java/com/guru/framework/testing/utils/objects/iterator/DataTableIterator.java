package com.guru.framework.testing.utils.objects.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.value.Column;
import com.guru.framework.testing.utils.objects.value.DataTable;
import com.guru.framework.testing.utils.objects.value.Row;


// TODO: Auto-generated Javadoc
/**
 * Represents a DataTable Iterator, subclasses of this class should implement <code>advanceCurrent()</code>
 * method according to their iteration startegy
 */
public abstract class DataTableIterator implements Iterator<Row> {
	
	protected DataTable dataTable;	// data table to iterate through
	protected int iterationLimit;	// max number of iterations
	protected int count;			// actual number of performed iterations
	protected int current;			// current row index 
	
	protected DataTableIterator(final DataTable table) {
		this(table, table.getRowCount(), 0);
	}
		
	protected DataTableIterator(final DataTable table, final int limit) {
		this(table, limit, 0);
	}
	
	protected DataTableIterator(final DataTable table, final int limit, final int initialIndex) {
		if(limit < 0)
			{throw new IllegalArgumentException("Invalid iterationLimit (< 0) " + limit);}
		if(table.getRowCount() != 0 && (initialIndex < 0 || initialIndex >= table.getRowCount()))
			{throw new IllegalArgumentException(String.format("Invalid initial row index=%d for row count=%d", initialIndex, table.getRowCount()));}
		this.dataTable = table;
		this.current = initialIndex;
		this.iterationLimit = limit;
	}
	
	/* No-op implementation, remove operation by default is disabled
	 * @see java.util.Iterator#remove()
	 */
	public void remove() { }
	
	/* Returns true if the <code>count</code> is under the <code>iterationLimit</code>, false overwise
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {	
		return this.count < this.iterationLimit;
	}

	
	/* Returns the current Row from the table, increases count by one 
	 * and advances the current pointer to the next Row according t the iteration strategy
	 * @see java.util.Iterator#next()
	 */
	public Row next() {		
		if(!hasNext()) {return null;}
		final Row result  = this.dataTable.getRow(current);
		this.count++;
		advanceCurrent();
		return result;
	}
	
	public void reset() {
		this.count = 0;
		this.current = 0;
	}
	
	/**
	 * Gets the List of column names.
	 *
	 * @return List<String> of column names
	 * @throws DataTableException the data table exception
	 */
	public List<String> getColumnNames() throws DataTableException {
		final List<Column> columns  = this.dataTable.getColumns();
		final List<String> result = new ArrayList<String>();
		for(Column column : columns)
			{result.add(column.getId());}
		return result;
	}
	
	public DataTable getTable() {
		return this.dataTable;
	}
	
	public void setTable(final DataTable other) {
		if(null != other)
			{this.dataTable = other;}
	}
	
	public String toString() {
		return this.getClass().getName() + ": { dataTable:{" + this.dataTable + "}, iterationLimit=" + this.iterationLimit + ", count=" + this.count + ", current=" + this.current + "}"; 
	}

	protected abstract void advanceCurrent();
}

package com.guru.framework.testing.testng.strategies;

import java.util.List;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.iterator.DataTableFilter;
import com.guru.framework.testing.utils.objects.iterator.DataTableIterator;
import com.guru.framework.testing.utils.objects.value.DataTable;


public abstract class AbstractDataTableStrategy implements DataStrategy {

	protected DataTableIterator iterator;
	
	protected AbstractDataTableStrategy() {}	
	
	public DataTableIterator getIterator() {
		return this.iterator;
	}
	
	public void applyFilters(final DataTableFilter... filters) throws DataTableException {
		if(filters.length > 0) {
			DataTable table = this.iterator.getTable();
			for(DataTableFilter filter : filters) {
				table = filter.apply(table);
			}
			this.iterator.setTable(table);
		}
	}
	
	public List<String> getNames() throws DataTableException {
		return this.iterator.getColumnNames();
	}
	
		
	
	
}

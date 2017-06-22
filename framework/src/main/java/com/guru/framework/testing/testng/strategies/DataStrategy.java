/**
 * A common interface for a data iteration strategy
 * 	
 * @since 0.0.2 Feb 3, 2013
 * @see 
 * @author Isha Sharma
 */
package com.guru.framework.testing.testng.strategies;

import java.util.List;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.iterator.DataTableFilter;
import com.guru.framework.testing.utils.objects.iterator.DataTableIterator;




public interface DataStrategy {

	/**
	 * Returns the iterator for the given startegy.
	 *
	 * @return the iterator
	 * @throws Exception the exception
	 */
	public DataTableIterator getIterator() throws DataTableException;
	
	/**
	 * Returns parameter names for the given strategy.
	 *
	 * @return the names
	 * @throws Exception the exception
	 */
	public List<String> getNames() throws DataTableException;
	
	
	public void applyFilters(final DataTableFilter... filters) throws DataTableException;
}

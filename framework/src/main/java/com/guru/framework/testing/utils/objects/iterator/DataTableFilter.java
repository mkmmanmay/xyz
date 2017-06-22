package com.guru.framework.testing.utils.objects.iterator;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.value.DataTable;

public interface DataTableFilter {

	public DataTable apply(final DataTable dataTable) throws DataTableException;
}

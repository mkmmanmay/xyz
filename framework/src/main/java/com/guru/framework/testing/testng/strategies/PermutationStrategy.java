package com.guru.framework.testing.testng.strategies;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.iterator.CyclicalIterator;
import com.guru.framework.testing.utils.objects.value.Cell;
import com.guru.framework.testing.utils.objects.value.Column;
import com.guru.framework.testing.utils.objects.value.DataTable;
import com.guru.framework.testing.utils.objects.value.Row;
import com.guru.framework.testing.utils.objects.value.Value;
import com.guru.framework.testing.utils.objects.value.ValueFactory;

public class PermutationStrategy extends AbstractDataTableStrategy {
	
	protected PermutationStrategy(final DataTable table) {
		this(table, table.getRowCount());
	}
	
	protected PermutationStrategy(final DataTable table, final int limit) {
		this.iterator = new CyclicalIterator(table, limit);
	}
	
	public PermutationStrategy(final Map<String, List<String>> data) throws DataTableException {
		this(buildTableFromMap(data));
	}
	
	public PermutationStrategy(final Map<String, List<String>> data, final int limit) throws DataTableException {
		this(buildTableFromMap(data), limit);
	}
	
	protected static DataTable buildTableFromMap(final Map<String, List<String>> data) throws DataTableException {
		final int noRows = calculateNoIterations(data);
		final DataTable dt = new DataTable();
		for(String columnName : data.keySet())
			{dt.addColumn(new Column(columnName, Value.ValueType.TEXT, columnName));}
		final Set<String> keys = data.keySet();
		for(int j=0; j < noRows; j++) {
			final Row row = new Row(data.size());
			for(String key : keys) {
				final Object[] s = data.get(key).toArray();			
				final Cell cell = new Cell(ValueFactory.getTextInstance(s[j % s.length].toString()));
				row.addCell(cell);
			}
			dt.addRow(row);
		}
		return dt;
	}
	
	
	
	protected static int calculateNoIterations(final Map<String, List<String>> data) {
		if(null == data || data.size() == 0) {return 0;}
		int result  = 1;
		boolean hasValues = false;
		for(List<String> each : data.values()) {
			if(each.size() > 0) {
				result *= each.size();
				hasValues = true;
			}
		}
		return hasValues ? result : 0;
	}	
	
	
	public static void main(final String...args) throws DataTableException {
		final Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("1", Arrays.asList("11", "12", "13"));
		map.put("2", Arrays.asList("21"));
		map.put("3", Arrays.asList("31", "32"));
		
		final PermutationStrategy ps = new PermutationStrategy(map);
		System.out.println(ps.getNames());
		final Iterator<Row> it = ps.getIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
			
	}
		
}

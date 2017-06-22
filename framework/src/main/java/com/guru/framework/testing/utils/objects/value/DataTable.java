package com.guru.framework.testing.utils.objects.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.utils.objects.value.Value.ValueType;

public class DataTable {
	
	protected List<Column> columns;			// column descriptors
	protected Map<String, Integer> columnIdToIndexMap;	// map of column indexes(0-based) to their ids
	protected List<Row> rows;								// rows

	// creates an empty DataTable object
	public DataTable() {
		this.columns = new ArrayList<Column>();
		this.columnIdToIndexMap = new HashMap<String, Integer>();
		this.rows = new ArrayList<Row>();
	}
	
	public DataTable(final int initColumnSize, final int initRowSize) {
		this.columns = new ArrayList<Column>(initColumnSize);
		this.columnIdToIndexMap = new HashMap<String, Integer>(initColumnSize);
		this.rows = new ArrayList<Row>(initRowSize);
	}
	
	// copy constructor
	public DataTable(final DataTable other) throws DataTableException {
		this();
		if(null == other) 
			{throw new IllegalArgumentException("Can not copy a null DataTable");}
		for (Column column : other.getColumns()) 
			{addColumn(new Column(column));}
		for (Row row : other.getRows())
			{addRow(new Row(row));	}
	}
	
	public DataTable(final DataTable other,  final String[] include, final String[] exclude, final KeyValuePair[] columnTypeList) throws Exception {
		this();
        if(null == other) 
            {throw new IllegalArgumentException("Can not copy a null DataTable");}
        if(columnTypeList == null||columnTypeList.length == 0)
		{	       for (Column column : other.getColumns()) 
		{ addColumn(new Column(column));}
	               for (Row row : other.getRows())
	                     {addRow(new Row(row)); }     
	     }
	     else { 
	    	 // convert columns to appropriate types   
	               for (Column column : other.getColumns())  { 
	            	   final Value.ValueType columnValueType = getValueType(column.getLabel(), columnTypeList);
	                     if(columnValueType  == null) {
	                            addColumn(new Column(column));
	                     }
	                     else {
	                    	addColumn(new Column(column.getId(), columnValueType, column.getLabel(), column.getFormat()));        
	                      }
	               }
	               for(Row each : other.getRows()) {
	            	   final Row newRow = new Row();
	                     for(int i=0; i < each.getCellCount(); i++) {
	                            if(other.getColumnByIndex(i).getType()
	                            		.equals(this.getColumnByIndex(i).getType())) {
	                                   newRow.addCell(each.getCell(i));
	                            }
	                            else {     
	                            	final String[] format ={""};
	                            	final  Value newValue = ValueFactory.getInstance(getClassName(this.getColumnByIndex(i).getLabel(),columnTypeList), each.getCell(i).getValue().toString(),format);//getCellformatType(this.getColumnByIndex(i).label,columnTypes) );
	                                   newRow.addCell(new Cell(newValue));  
	                            }
	                     }
	                     addRow(newRow);
	               }
	        }
		
		
        final List<String> incl = (include != null && include.length > 0) ?  Arrays.asList(include) : new ArrayList<String>() ;
        final List<String> excl = (exclude != null && exclude.length > 0) ?  Arrays.asList(exclude) : new ArrayList<String>();
		for(int i=0; i < columns.size(); i++) {
			final String colLabel = getColumnByIndex(i).getLabel();
			if((incl.isEmpty() && excl.contains(colLabel)) ||
			   (!incl.isEmpty() && !incl.contains(colLabel) ||
			   (!incl.isEmpty() && incl.contains(colLabel) && excl.contains(colLabel)))) {
				removeColumn(colLabel);
				i--;
			}			   
		}
	} 

 
 private ValueType getValueType(final String key, final KeyValuePair... columnTypes) throws Exception {
        if(key == null || columnTypes.length == 0)
        { return null;}
        for(KeyValuePair each : columnTypes) {
               if(each.getKey().toString().equalsIgnoreCase(key)) {
            	   final String valueTypeClassName = each.getValue().toString();   
                     return Value.getValueType(valueTypeClassName);
               }
        }
        return null;
 } 
 
 private String getClassName(final String key, final KeyValuePair... columnTypes) throws Exception {
     if(key == null || columnTypes.length == 0)
     { throw new DataTableException("Key doesnot exist") ;}
     for(KeyValuePair each : columnTypes) {
            if(each.getKey().toString().equalsIgnoreCase(key)) {
            	return  "com.ge.capital.rainbow.objects.values." +each.getValue().toString();   
            }
     }
     throw new DataTableException("Key not found "+key) ;
} 
	// Accessors
	// returns a column index by id
	public int getColumnIndex(final String columnId) {
		final Integer index = columnIdToIndexMap.get(columnId);
		return null == index ? -1 : index.intValue();
	}
	
	// returns a deep copy of column descriptions
	public List<Column> getColumns() throws DataTableException {
		final List<Column> newList = new ArrayList<Column>(columns.size());
		for(Column each : columns)
			{newList.add(new Column(each));}
		 return newList;
	}
	
	// returns a deep copy of column cells
	public List<Cell> getColumnCells(final int columnIndex) {
		final List<Cell> colCells = new ArrayList<Cell>(getRowCount());
	    for (Row row : getRows()) {
	      colCells.add(new Cell(row.getCell(columnIndex)));
	    }
	    return colCells;
	 }
	
	public List<Cell> getColumnCells(final String columnId) {
	    return getColumnCells(getColumnIndex(columnId));
	 }
	
	// returns column count
	 public int getColumnCount(){
		  return columns.size();
	 }
	 
	 
	
	// returns a deep copy of column descriptions at specified index
	public Column getColumnByIndex(final int colIndex) throws DataTableException {
		return new Column(columns.get(colIndex));
	}
	
	// returns a deep copy of column descriptions with specified id
	public Column getColumnById(final String columnId) throws DataTableException {
		return new Column(columns.get(getColumnIndex(columnId)));
	}
	

	public List<Value> getColumnDistinctValues(final int columnIndex) {
		final Set<Value> values = new TreeSet<Value>();
	    for (Row row : getRows()) 
	    { values.add(row.getCell(columnIndex).getValue());}
	    return new ArrayList<Value>(values);
	  }
	
	public List<Value> getColumnDistinctValues(final String columnId) {
		return getColumnDistinctValues(getColumnIndex(columnId));
	}
		
	
	public void addRow(final Row row) throws DataTableException {
		if(null == row) 
			{throw new DataTableException("Can not add a null row");}
		final List<Cell> cells = row.getCells();
		if (cells.size() != columns.size()) 
			{throw new DataTableException("Row has " + row.getCells().size() + " cells. Should be of size: " + columns.size());}
		for (int i = 0; i < cells.size(); i++) {
			if (cells.get(i).getType() != columns.get(i).getType())
				{throw new DataTableException("Cell type does not match column type, at index: " + i	+ ". Should be of type: " + columns.get(i).getType().toString());}			
		}	
		rows.add(row);
	}
	
	public void addRows(final List<Row> rowsToAdd) throws DataTableException {
		if(null == rowsToAdd) 
			{throw new DataTableException("Can not add a null list of rows");}
		for (Row row : rowsToAdd) 
			{addRow(row);}
	}
	
	public void setRows(final List<Row> rows) throws DataTableException {
		if(null == rows) 
			{throw new DataTableException("Can not set a null list of rows");}
		clearRows();
	    addRows(rows);
	  }
	
	public void clearRows() {
		this.rows.clear();
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public Row getRow(final int rowIndex) {
		return rows.get(rowIndex);
	}
	
	public int getRowCount() {
		return rows.size();
	}
	
	public Row removeRow(final int index) {
		return rows.remove(index);
	}
	
	
	public Column removeColumn(final int index) {
		if(index < 0 || index >= columns.size())
			{return null;}
		String colId = "";
		try {
			colId = getColumnByIndex(index).getId();
		}
		catch(DataTableException dte) {
			return null;
		}
		// rebuild all rows to remove cells at that index
		final List<Row> newRows = new ArrayList<Row>(rows.size());
		for(int i=0; i < rows.size(); i++) {
			final Row newRow = new Row();
			for(int j=0; j<getColumnCount(); j++) {
				if(j != index)
					{newRow.addCell(new Cell(getCell(i, j)));}
			}
			newRows.add(newRow);
		}
		this.rows = newRows;
		// rebuild columns		
		columnIdToIndexMap.remove(colId);
		final Set<String> keys = columnIdToIndexMap.keySet();
		for(String key : keys) {
			columnIdToIndexMap.put(key, new Integer(columnIdToIndexMap.get(key).intValue() -1));
		}
		return columns.remove(index);
	}
	
	
	public Column removeColumn(final String label) {
		return removeColumn(getColumnIndex(label));
	}
	
	
	public void addColumn(final Column columnDescription) throws DataTableException {
		if(null == columnDescription) 
			{throw new IllegalArgumentException("Can not add a null column");}
		final String columnId = columnDescription.getId();
	    if (columnIdToIndexMap.containsKey(columnId)) 
	      {throw new DataTableException("Column Id [" + columnId + "] already in table description");}	    
	    columnIdToIndexMap.put(columnId, columns.size());
	    columns.add(columnDescription);	
	    for (Row row : rows) {
	      row.addCell(new Cell(Value.getEmptyValueFromType(columnDescription.getType())));
	    }
	  }
	
	public void addColumns(final List<Column> columnsToAdd) throws DataTableException {
		if(null == columnsToAdd) 
			{throw new IllegalArgumentException("Can not add a null list of columns");}
	    for (Column column : columnsToAdd) {
	      addColumn(column);
	    }
	  }
	
	
	
	public Cell getCell(final int rowIndex, final int colIndex) {
	    return getRow(rowIndex).getCell(colIndex);
	}
	
	public Cell setCell(final int rowIndex, final int colIndex, final Cell cell) throws DataTableException, IndexOutOfBoundsException {
		if(null == cell) 
			{throw new IllegalArgumentException("Can not add a null cell");}
		final Row row = rows.get(rowIndex);
		if (!row.getCell(colIndex).getType().equals(cell.getType())) 
			{throw new IllegalArgumentException("New cell value type does not match expected value type." + " Expected type: " + row.getCell(colIndex).getType() + " but was: " + cell.getType().toString());}
		return row.setCell(colIndex, cell);
	}
	
	public Value getValue(final int rowIndex, final int colIndex) {
	    return getCell(rowIndex, colIndex).getValue();
	  }
	
	
	
	public boolean containsColumn(final String columnId) {
		return columnIdToIndexMap.containsKey(columnId);
	}
	
	public boolean containsAllColumnIds(final Collection<String> colIds) {
	    for (String id : colIds) {
	      if (!containsColumn(id))
	        {return false;}
	    }
	    return true;
	  }
	
	
	
	public int getFirstMatchingColumnIndex(final String columnLabel) throws DataTableException {
		for(Column each : getColumns()) {
			if(each.getLabel().equalsIgnoreCase(columnLabel)) {
				return getColumnIndex(each.getId());				
			}
		}
		return -1;		
	}
	
	public int getFirstMatchingRowIndex(final String columnLabel,final String rowValue) throws DataTableException {
		final int columnIndex = getFirstMatchingColumnIndex(columnLabel);
		if(columnIndex != -1) {
			for(int i = 0; i < getRowCount(); i++) {
				if(getRow(i).getCell(columnIndex).getValue().toString().equalsIgnoreCase(rowValue))
					{return i;}
			}
		}
		return -1;
	}
	
	public int getFirstMatchingRowIndex(final KeyValuePair... pairs) throws DataTableException {
		if(pairs.length == 0) {throw new IllegalArgumentException("At least one pair is required");}
		// build column indexes
		int[] indexes = new int[pairs.length];
		int i = 0;
		for(KeyValuePair pair : pairs) {
			indexes[i++] =  getFirstMatchingColumnIndex(pair.getKey().toString());
		}
		
		// find match		
		int rowIndex = 0;
		while(rowIndex < this.getRowCount()) {
			final Row row = this.getRow(rowIndex);
			int col = 0;
			while(col < indexes.length && row.getCell(indexes[col]).getValue().toString().equalsIgnoreCase(pairs[col].getValue().toString()))
				col++;
			if(col == indexes.length)
				{return rowIndex;}	
			rowIndex++;
		}
		return -1;
	}
	
	
	
	  @Override
	  public String toString() {
		  final StringBuilder sb = new StringBuilder();
	    
	    for(Column each : columns) {
	    	sb.append(each.getLabel()).append(",");
	    }
	    if(columns.size() > 0) {
	    	sb.replace(sb.length()-1, sb.length(), "\n");
	    }
	    
	    for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
	    	final Row tableRow = rows.get(rowIndex);
	      for (int cellIndex = 0; cellIndex < tableRow.getCells().size(); cellIndex++) {
	    	  final Cell tableCell = tableRow.getCells().get(cellIndex);
	        sb.append(tableCell.toString());
	        if (cellIndex < tableRow.getCells().size() - 1) {
	          sb.append(",");
	        }
	      }
	      if (rowIndex < rows.size() - 1) {
	        sb.append("\n");
	      }
	    }

	    return sb.toString();
	  }
	  
	  
	  
	  /**
	 * @throws DataTableException **********************************/
	  
	
	  
	  
	  public void sortByLabel(final KeyValuePair... keyVals) throws DataTableException{
		  if(keyVals.length > 0) {
			  KeyValuePair[] newPairs = new KeyValuePair[keyVals.length];
			  for(int i=0; i<keyVals.length; i++) {
				  newPairs[i] = new KeyValuePair(this.getFirstMatchingColumnIndex(keyVals[i].getKey().toString()), keyVals[i].getValue().toString());
			  }
			  sortByIndex(newPairs);
		  }
	  }
	  
	  
	  public void sortByIndex(final KeyValuePair... keyVals){
		  if(keyVals.length > 0)
		  { Collections.sort(this.getRows(), new RowComparator(keyVals));}
	  }
	  
}

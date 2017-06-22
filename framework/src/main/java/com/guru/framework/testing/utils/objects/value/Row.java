package com.guru.framework.testing.utils.objects.value;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents one row in a data table
 * @author Isha Sharma
 *
 */
public class Row {
	
	protected List<Cell> cells;
	
	public Row() {
		this.cells = new ArrayList<Cell>();
	}
	
	public Row(final int initSize) {
		this.cells = new ArrayList<Cell>(initSize);
	}	
	public Row(final Row other)  {
		if(null == other) {throw new IllegalArgumentException("Can not copy a null Row");}
		cells = new ArrayList<Cell>(other.getCells().size());
		for(Cell each: other.getCells())
			{addCell(each);}
	}
	
	public void addCell(final Cell cell) {
		cells.add(new Cell(cell));
	}	
			
	public Cell setCell(final int index, final Cell cell) {
	    return cells.set(index, new Cell(cell));
	}
	
	public int getCellCount() {
		return this.cells.size();
	}
	
	public List<Cell> getCells() {
		final List<Cell> result = new ArrayList<Cell>(cells.size());
	    for(Cell each : cells) 
	    	{result.add(new Cell(each));}
	    return result;
	}

	public Cell getCell(final int index) {
	    return new Cell(cells.get(index));
	}
	
	@Override
	public boolean equals(final Object other) {		
		if(other == null) {return false;}
		if(!(other instanceof Row)) {return false;}
		if(this == other) {return true;}
		if(this.getCellCount() != ((Row)other).getCellCount()){ return false;}		
		for(int i=0; i < this.getCellCount(); i++)
			{if(!this.getCell(i).equals(((Row)other).getCell(i))) 
				{return false;}}
		return true;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for(Cell each : cells) 
			{sb.append(each.toString()).append(" ");}
		return sb.toString();
	}
	
	
}

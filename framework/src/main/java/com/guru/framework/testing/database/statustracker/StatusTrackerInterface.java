package com.guru.framework.testing.database.statustracker;

import java.util.List;

import com.guru.framework.testing.utils.objects.value.DataTable;

public class StatusTrackerInterface {

	public static int getTestHistory(String suiteName, int rows,List<String> runtimedates, List<String> durations,List<String> skips,List<String> passes,
			List<String> fails,List<String> totals,List<String> failedTestNames,List<String> exceptions,List<String> testLists) throws Exception, Throwable
	{
		/*String query = "SELECT * FROM (SELECT * from executions_functional_rainbow where testsuitename = '" + suiteName + "' order by runtimedate desc) a limit " + rows;
		DataTable returnTable = MySQLDatabaseFacade.getFactory("statustracker").executeQuery(query);
	
		int runtimedateRowIndex = returnTable.getColumnIndex("runtimedate");
		int durationRowIndex = returnTable.getColumnIndex("testdurationsecs");
		int skipRowIndex = returnTable.getColumnIndex("numtestsskipped");
		int passRowIndex = returnTable.getColumnIndex("numtestspassed");
		int failRowIndex = returnTable.getColumnIndex("numtestsfailed");
		int totalRowIndex = returnTable.getColumnIndex("numteststotal");
		int failedTestNameRowIndex = returnTable.getColumnIndex("firstfailedtestname");
		int exceptionRowIndex = returnTable.getColumnIndex("firstfailedteststacktrace");
		int testListRowIndex = returnTable.getColumnIndex("testlist");
		
		for (int i = 0; i < returnTable.getRowCount(); i++) 
		{
			runtimedates.add(returnTable.getRow(i).getCell(runtimedateRowIndex).getValue().toString());
			durations.add(returnTable.getRow(i).getCell(durationRowIndex).getValue().toString());
			skips.add(returnTable.getRow(i).getCell(skipRowIndex).getValue().toString());
			passes.add(returnTable.getRow(i).getCell(passRowIndex).getValue().toString());
			fails.add(returnTable.getRow(i).getCell(failRowIndex).getValue().toString());
			totals.add(returnTable.getRow(i).getCell(totalRowIndex).getValue().toString());
			failedTestNames.add(returnTable.getRow(i).getCell(failedTestNameRowIndex).getValue().toString());
			exceptions.add(returnTable.getRow(i).getCell(exceptionRowIndex).getValue().toString());
			testLists.add(returnTable.getRow(i).getCell(testListRowIndex).getValue().toString());
		}
		MySQLDatabaseFacade.getFactory("statustracker").close();
		return  returnTable.getRowCount();*/
		return 0;
	}

	
}

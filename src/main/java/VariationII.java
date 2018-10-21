import org.apache.commons.lang3.RandomStringUtils;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VariationII {
	private static int MIN = 1;
	private static int MAX = 50000;

	private static boolean CREATE_INDEX_A = false;
	private static boolean CREATE_INDEX_B = false;
	private static boolean CREATE_INDEX_A_B = false;

	private static boolean CREATE_TABLE_FLAG = false;
	private static boolean DROP_TABLE_FLAG = false;

	private static boolean INSERT_DATA_FLAG = true;

	private static boolean QUERY_1_FLAG = false;
	private static boolean QUERY_2_FLAG = false;
	private static boolean QUERY_3_FLAG = false;


	/**
	 * @param args the command line arguments
	 */
	public static double run(boolean createTable, boolean insertData, boolean createIndexA, boolean createIndexB,
						   boolean createIndexAB, boolean query1, boolean query2, boolean query3, boolean dropTable){
		String url = "jdbc:sqlite:C:/Users/javie/Documents/Data_Engineering/hw2.db";
		// Load the driver
		try
		{
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Unable to find driver");
			return 0;
		}
		Connection connection = Utils.connect(url);
		if(createTable){
			Utils.createTable(connection);
			Utils.closeConnection(connection);
			return 0;
		}
		if(insertData){
			List<TableRow> rows = generateRows(Utils.NUM_ROWS);
			long startTime = System.nanoTime();
			Utils.insertBatch(connection,rows);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation II took " + seconds + " to insert " + Utils.NUM_ROWS + " rows.");
			Utils.closeConnection(connection);
			return executionTime;
		}
		if(createIndexA){
			Utils.createIndexColumnA(connection);
			Utils.closeConnection(connection);
			return 0;
		}
		if(createIndexB){
			Utils.createIndexColumnB(connection);
			Utils.closeConnection(connection);
			return 0;
		}
		if(createIndexAB){
			Utils.createIndexColumnAB(connection);
			Utils.closeConnection(connection);
			return 0;
		}

		if(query1){
			int numLoops = Utils.columnAVals.length;
			double executionTime = 0.0;
			for(int i = 0; i < numLoops; i++){
				int n = Utils.columnAVals[i];
				long startTime = System.nanoTime();
				Utils.query1(connection,n);

				long endTime = System.nanoTime();
				long t = endTime - startTime;
				executionTime += (double) t;

			}
			executionTime = executionTime / (1.0 * numLoops);
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation II took an average of " + seconds + " to run Query 1");
			Utils.closeConnection(connection);
			return executionTime;

		}
		if(query2){
			int numLoops = Utils.columnBVals.length;
			double executionTime = 0.0;
			for(int i = 0; i < numLoops; i++){
				int n = Utils.columnBVals[i];
				long startTime = System.nanoTime();
				Utils.query2(connection,n);

				long endTime = System.nanoTime();
				long t = endTime - startTime;
				executionTime += (double) t;

			}
			executionTime = executionTime / (1.0 * numLoops);
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation II took an average of " + seconds + " to run Query 2");
			Utils.closeConnection(connection);
			return executionTime;

		}
		if(query3){
			int numLoops = Utils.columnBVals.length;
			double executionTime = 0.0;
			for(int i = 0; i < numLoops; i++){
				int n1 = Utils.columnAVals[i];
				int n2 = Utils.columnBVals[i];
				long startTime = System.nanoTime();
				Utils.query3(connection,n1,n2);

				long endTime = System.nanoTime();
				long t = endTime - startTime;
				executionTime += (double) t;

			}
			executionTime = executionTime / (1.0 * numLoops);
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation II took an average of " + seconds + " to run Query 3");
			Utils.closeConnection(connection);
			return executionTime;

		}
		if(dropTable){
			Utils.dropTable(connection);
			Utils.closeConnection(connection);
			return 0;
		}
		return 0;
	}

	// generate the rows such that the primary key value is chosen at random,
	// without replacement, from the integers.
	private static List<TableRow> generateRows(int batchSize){
		int numRows = batchSize;
		int min = MIN;
		int max = MAX;
		List<Integer> keys= new ArrayList<Integer>();
		for(int i = 0; i < numRows; i++){
			keys.add(i);
		}
		// Randomize the keys
		Collections.shuffle(keys);

		Random r = new Random();
		List<TableRow> rows = new ArrayList<TableRow>();
		for (int i = 0; i < numRows; i++){

			int key = keys.get(i);
			TableRow row = new TableRow();
			row.theKey = key;
			row.columnA = r.nextInt((max - min) + 1) + min;
			row.columnB = r.nextInt((max - min) + 1) + min;
			row.filler = RandomStringUtils.randomAlphabetic(246);
			rows.add(row);
		}

		return rows;
	}
}

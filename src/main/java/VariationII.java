import org.apache.commons.lang3.RandomStringUtils;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VariationII {
	private static int NUM_ROWS   = 5000000;
	private static int BATCH_SIZE = 50000;
	private static int MIN = 1;
	private static int MAX = 50000;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String url = "jdbc:sqlite:C:/Users/javie/Documents/Data_Engineering/hw2.db";
		// Load the driver
		try
		{
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Unable to find driver");
			return;
		}
		Connection connection = Utils.connect(url);
		Utils.createTable(connection);
		int numLoops = NUM_ROWS / BATCH_SIZE;
		double processTime = 0.0;
		for(int i = 0; i < numLoops; i++)
		{
			List<TableRow> rows = generateRows(i, BATCH_SIZE);
			long startTime = System.nanoTime();
			Utils.insertBatch(connection,rows);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			processTime += (double) executionTime;
		}
		double seconds = (double) processTime / 1000000000.0;
		System.out.println("Variation II took " + seconds + " to insert " + NUM_ROWS + " rows.");
		Utils.dropTable(connection);

		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// generate the rows such that the primary key value is chosen at random,
	// without replacement, from the integers.
	private static List<TableRow> generateRows(int n, int batchSize){
		int numRows = BATCH_SIZE;
		int min = MIN;
		int max = MAX;
		List<Integer> keys= new ArrayList<Integer>();
		for(int i = 0; i < numRows; i++){
			keys.add(i + n * numRows);
		}

		Random r = new Random();
		List<TableRow> rows = new ArrayList<TableRow>();
		for (int i = 0; i < numRows; i++){
			int index = r.nextInt(keys.size());
			int key = keys.get(index);
			keys.remove(index);
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

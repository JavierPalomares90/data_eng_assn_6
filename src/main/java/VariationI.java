import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class VariationI
{
	private static int MIN = 1;
	private static int MAX = 50000;

	private static boolean CREATE_INDEX_A = true;
	private static boolean CREATE_INDEX_B = false;
	private static boolean CREATE_INDEX_A_B = false;

	private static boolean DROP_TABLE_FLAG = false;
	private static boolean CREATE_TABLE_FLAG = true;

	private static boolean INSERT_DATA_FLAG = true;
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
		if(CREATE_TABLE_FLAG){
			Utils.createTable(connection);
		}
		if(INSERT_DATA_FLAG){
			List<TableRow> rows = generateRows(Utils.NUM_ROWS);
			long startTime = System.nanoTime();
			Utils.insertBatch(connection,rows);
			Utils.createIndexColumnA(connection);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation I took " + seconds + " to insert " + Utils.NUM_ROWS + " rows.");

		}
		if(CREATE_INDEX_A){
			long startTime = System.nanoTime();
			Utils.createIndexColumnA(connection);
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			double seconds = (double) executionTime/ 1000000000.0;
			System.out.println("Variation I took " + seconds + " to createIndex A" + Utils.NUM_ROWS + " rows.");
		}
		if(CREATE_INDEX_B){
			long startTime = System.nanoTime();
			Utils.createIndexColumnB(connection);
		}
		if(CREATE_INDEX_A_B){
			long startTime = System.nanoTime();
			Utils.createIndexColumnAB(connection);
		}
		if(DROP_TABLE_FLAG){
			long startTime = System.nanoTime();
			Utils.dropTable(connection);
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// generate and load the rows in sorted order on the primary key.
	private static List<TableRow> generateRows( int batchSize){
		int numRows = batchSize;
		int min = MIN;
		int max = MAX;
		List<TableRow> rows = new ArrayList<TableRow>();
		Random r = new Random();
		for (int i = 0; i < numRows; i++){
			TableRow row = new TableRow();
			row.theKey = i;
			// columnA is a random int between 1 and 50
			row.columnA = r.nextInt((max - min) + 1) + min;
			row.columnB = r.nextInt((max - min) + 1) + min;
			row.filler = RandomStringUtils.randomAlphabetic(246);
			rows.add(row);
		}
		return rows;
	}
}

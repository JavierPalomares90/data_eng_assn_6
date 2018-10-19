import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class VariationI
{
	private static int NUM_ROWS = 50;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String url = "jdbc:sqlite:/Users/PXJ2D5A/Documents/hw3_db.db";
		//Class.forName("org.sqlite.JDBC");
		Connection connection = Utils.connect(url);
		Utils.createTable(connection);
		List<TableRow> rows = generateRows();
		//insertOneRow(connection, row);
		long startTime = System.nanoTime();
		Utils.insertBatch(connection,rows);
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		Utils.dropTable(connection);
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// generate and load the rows in sorted order on the primary key.
	private static List<TableRow> generateRows(){
		int numRows = NUM_ROWS;
		int min = 1;
		int max = 50;
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

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VariationII {
	private static int NUM_ROWS = 50;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String url = "jdbc:sqlite:/Users/PXJ2D5A/Documents/hw3_db.db";
		//Class.forName("org.sqlite.JDBC");
		Connection connection = Utils.connect(url);
		List<TableRow> rows = generateRows();
		//insertOneRow(connection, row);
		Utils.insertBatch(connection,rows);
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
	private static List<TableRow> generateRows(){
		int numRows = NUM_ROWS;
		int min = 1;
		int max = 50;
		List<Integer> keys= new ArrayList<Integer>();
		for(int i = 0; i < numRows; i++){
			keys.add(i);
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

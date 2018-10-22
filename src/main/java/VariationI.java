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


	// generate and load the rows in sorted order on the primary key.
	public static List<TableRow> generateRows( int batchSize){
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

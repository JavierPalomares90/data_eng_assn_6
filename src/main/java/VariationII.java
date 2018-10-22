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


	// generate the rows such that the primary key value is chosen at random,
	// without replacement, from the integers.
	public static List<TableRow> generateRows(int batchSize){
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

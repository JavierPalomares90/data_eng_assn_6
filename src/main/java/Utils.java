import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Utils {
	private static String SQL = "INSERT INTO benchmark(theKey,columnA,columnB,filler) VALUES(?,?,?,?)";
	public static Connection connect(String url) {
		Connection conn = null;
		try {
			// db parameters
			// Change this to the appropriate path
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void insertOneRow(Connection conn, TableRow row){
		if(conn == null){
			return;
		}
		try{
			PreparedStatement statement = conn.prepareStatement(SQL);
			statement.setInt(1,row.theKey);
			statement.setInt(2,row.columnA);
			statement.setInt(3,row.columnB);
			statement.setString(4,row.filler);
			statement.executeUpdate();
		}catch (SQLException e){
			System.err.println(e.getMessage());
		}
		/**
		 * TODO: Complete implementation
		 */
	}

	public static void insertBatch(Connection conn, List<TableRow> rows){
		if(conn == null){
			return;
		}
		// set auto-commit mode to false
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		for(TableRow row: rows){
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				statement.setInt(1, row.theKey);
				statement.setInt(2, row.columnA);
				statement.setInt(3, row.columnB);
				statement.setString(4, row.filler);
				statement.executeUpdate();
			}catch (SQLException e){
				System.err.println(e.getMessage());
				return;
			}
		}

		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

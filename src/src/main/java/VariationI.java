import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VariationI
{
	private static int NUM_ROWS = 0;
	private static String SQL = "INSERT INTO benchmark(theKey,columnA,columnB,filler) VALUES(?,?,?,?)";
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Class.forName("org.sqlite.JDBC");
		Connection connection = connect();
		TableRow row = new TableRow();
		row.theKey = 2;
		row.columnA = 3;
		row.columnB = 4;
		row.filler = "this is a test";
		insertData(connection, row);
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection connect() {
		Connection conn = null;
		try {
			// db parameters
			// Change this to the appropriate path
			String url = "jdbc:sqlite:/Users/PXJ2D5A/Documents/hw3_db.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private static void insertData(Connection conn, TableRow row){
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

}

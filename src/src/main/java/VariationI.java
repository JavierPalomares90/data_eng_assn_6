import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VariationI
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//Class.forName("org.sqlite.JDBC");
		Connection connection = connect();
		insertData(connection);
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

	private static void insertData(Connection conn) {
		/**
		 * TODO: Complete implementation
		 */
	}

}

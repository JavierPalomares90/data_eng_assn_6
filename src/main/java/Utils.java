import java.sql.*;
import java.util.List;

public class Utils {
	private static String SQL = "INSERT INTO benchmark(theKey,columnA,columnB,filler) VALUES(?,?,?,?)";
	private static String CREATE_TABLE = "CREATE TABLE benchmark (  theKey NUMBER PRIMARY KEY,  columnA NUMBER,  columnB NUMBER,  filler CHAR(247) );";
	private static String DROP_TABLE = "DROP TABLE benchmark";
	private static String COLUMN_A_INDEX = "CREATE INDEX columnA_index on benchmark(columnA)";
	private static String COLUMN_B_INDEX = "CREATE INDEX columnB_index on benchmark(columnB)";
	private static String COLUMN_A_B_INDEX = "CREATE INDEX columnA_B_index on benchmark(columnA,columnB)";

	private static String DROP_COLUMN_A_INDEX = "DROP INDEX columnA_index";
	private static String DROP_COLUMN_B_INDEX = "DROP INDEX columnB_index";
	private static String DROP_COLUMN_A_B_INDEX = "DROP INDEX columnA_B_index";

	private static String QUERY_1 = "SELECT * FROM benchmark WHERE benchmark.columnA = ?";
	private static String QUERY_2 = "SELECT * FROM benchmark WHERE benchmark.columnB = ?";
	private static String QUERY_3 = "SELECT * FROM benchmark WHERE benchmark.columnA = ? AND benchmark.columnB = ?";


	public static int NUM_ROWS   = 5000000;
	public static int BATCH_SIZE = 50000;

	public static int[] columnAVals = {10301,23,308,7785,45898,867,73,88,343,234};
	public static int[] columnBVals = {18775,3564,87,4787,5,92,345,48998,12,9};

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

	public static void closeConnection(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void createTable(Connection conn){
		try
		{
			Statement stmt = conn.createStatement();
			stmt.execute(CREATE_TABLE);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void dropTable(Connection conn){
		try
		{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(DROP_TABLE);
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

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
	}
	private  static void executeSql(Connection conn, String sql){
		PreparedStatement statement = null;
		try
		{
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally {

			if(statement!=null){
				try
				{
					statement.close();
				}catch (SQLException e){
					System.err.println(e.getMessage());
				}
			}
		}

	}

	public static void dropIndexAB(Connection conn){
		if(conn == null){
			return;
		}
		executeSql(conn,DROP_COLUMN_A_B_INDEX);
	}

	public static void dropIndexA(Connection conn){
		if(conn == null){
			return;
		}
		executeSql(conn,DROP_COLUMN_A_INDEX);
	}

	public static void dropIndexB(Connection conn){
		if(conn == null){
			return;
		}
		executeSql(conn,DROP_COLUMN_B_INDEX);
	}


	public static void createIndexColumnAB(Connection conn){
		if(conn == null){
			return;
		}
		executeSql(conn,COLUMN_A_B_INDEX);
	}

	public static void createIndexColumnA(Connection connn){
	    if(connn == null){
	    	return;
		}
		executeSql(connn,COLUMN_A_INDEX);
	}

	public static void createIndexColumnB(Connection conn){
		if(conn == null){
			return;
		}
		executeSql(conn,COLUMN_B_INDEX);

	}

	public static void query3(Connection connection,int value1, int value2){
		if(connection == null){
			return;
		}
		PreparedStatement statement = null;
		ResultSet rs = null;
		try{
			statement = connection.prepareStatement(QUERY_3);
			statement.setInt(1,value1);
			statement.setInt(2, value2);
			rs = statement.executeQuery();
		}catch (SQLException e){
		    System.err.print(e.getMessage());
		}finally
		{
			if(statement!=null){
				try
				{
					statement.close();
				}catch (SQLException e){
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public static void query2(Connection connection, int value){
		if(connection == null){
			return;
		}
		PreparedStatement statement = null;
		ResultSet rs = null;
		try{
			statement = connection.prepareStatement(QUERY_2);
			statement.setInt(1,value);
			rs = statement.executeQuery();

		}catch (SQLException e){
			System.err.print(e.getMessage());
		}finally
		{
			if(statement!=null){
				try
				{
					statement.close();
				}catch (SQLException e){
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public static void query1(Connection connection,int value){
		if(connection == null){
			return;
		}
		PreparedStatement statement = null;
		ResultSet rs = null;
		try{
			statement = connection.prepareStatement(QUERY_1);
			statement.setInt(1,value);
			rs = statement.executeQuery();
		}catch (SQLException e){
			System.err.print(e.getMessage());
		}finally
		{
			if(statement!=null){
				try
				{
					statement.close();
				}catch (SQLException e){
					System.err.println(e.getMessage());
				}
			}
		}
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
		int count = 0;
		PreparedStatement statement = null;
		try {
            statement = conn.prepareStatement(SQL);
            for(TableRow row: rows)
			{
				statement.setInt(1, row.theKey);
				statement.setInt(2, row.columnA);
				statement.setInt(3, row.columnB);
				statement.setString(4, row.filler);
				statement.addBatch();
				count++;
				if (count % BATCH_SIZE == 0)
				{
					System.out.println("Commit the batch of size " + BATCH_SIZE);
					int[] result = statement.executeBatch();
					System.out.println("Number of rows inserted: " + result.length);
					conn.commit();
				}
			}

        }catch (SQLException e){
            System.err.println(e.getMessage());
            return;
        }finally
		{

		    if(statement!=null){
		        try
				{
					statement.close();
				}catch (SQLException e){
					System.err.println(e.getMessage());
				}
			}
		}

	}
}

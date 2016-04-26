package tickets;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DBMSOperation {
	
	private static Connection dbmsConn;
	private static String mysqlHost = "jdbc:mysql://127.0.0.1:3306/movieTickets";

	public static Connection getDBConnection() {

		if (dbmsConn != null)
			return dbmsConn;

		synchronized(Connection.class) {
			if (dbmsConn == null) {
				// load mysql
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("successfully loaded MySql");
				} catch (ClassNotFoundException e) {
					System.out.println("\n\nerror loading mysql\n\n");
					e.printStackTrace();
				}

				// connect mysql
				try {
					dbmsConn = DriverManager.getConnection(mysqlHost, "root", "tiankk");
					System.out.println("successfully connected to mysql");
				} catch (SQLException e) {
					System.out.println("\n\nfail to connect mysql");
					e.printStackTrace();
					System.out.println("\n\n");
				}
			}
		}	
		return dbmsConn;
	}	// end getConnection

}
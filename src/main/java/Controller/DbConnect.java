package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
	private static Connection connection;

	public static Connection connectToDb() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mariadb://themannen.xyz:3302/LTUServices",
				"java",
				"grupp7sju");
		return connection;
	}
	public static void closeDbConnection() throws Exception {
		connection.close();
	}


}

package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private static Connection connection;

	public static Connection connectToDb() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/bothnia",
				"themannen",
				"asdf");
		return connection;
	}

	public static void closeDbConnection() throws Exception {
		connection.close();
	}

}

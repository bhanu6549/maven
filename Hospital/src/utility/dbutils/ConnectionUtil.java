package utility.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static final String DBURL = "jdbc:mysql://localhost:3306/hospitaldb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "BHANU";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public static String closeConnection(Connection connection) {
		String result = "";

		try {
			connection.close();
			result = "Succesfully Closed the connection object";
		} catch (Exception ex) {
			result = ex.getLocalizedMessage();
		}
		return result;
	}

}

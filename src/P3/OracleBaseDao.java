package P3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	protected static Connection conn;
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
	private static final String DB_USER = "OPDRACHT";
	private static final String DB_PASS = "Wachtwoord1";

	protected static Connection getConnection() throws SQLException {
		// Besluit welke driver je gaat gebruiken voor je verbinding
		try {
			Class.forName(DB_DRIV).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
		return conn;
	}

	public static void closeConnection() throws SQLException {
		conn.close();
	}
}

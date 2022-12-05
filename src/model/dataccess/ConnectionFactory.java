package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public ConnectionFactory() {
		
	}
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		final String URL = "jdbc:postgresql://localhost:5432/authentication";

		final String USER = "postgres";

		final String PWD = "Malem@123";

		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(URL, USER, PWD);
	}
}

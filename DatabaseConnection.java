package studysync;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	private static Connection connection = null;
	static {
		try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			String dbname = properties.getProperty("hsqldb.dbname");
			String username = properties.getProperty("hsqldb.username");
			String password = properties.getProperty("hsqldb.password");
			String url = "jdbc:hsqldb:file:" + dbname;

			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}

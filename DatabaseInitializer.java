package studysync;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseInitializer {
	public static void initialize() {
		try (Connection connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement()){
			
			InputStream input = DatabaseInitializer.class.getClassLoader().getResourceAsStream("schema.sql");
			String sql = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			Scanner scanner = new Scanner(sql);
			scanner.useDelimiter(";");
			
			while (scanner.hasNext()) {
				String sqlStatement = scanner.next().trim();
				if (!sqlStatement.isEmpty()) {
					statement.execute(sqlStatement);
				}
			}
			System.out.println("Datebase initialized successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

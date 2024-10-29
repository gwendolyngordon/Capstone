package studysync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection; 
	public UserDAO() {
		this.connection = DatabaseConnection.getConnection();
	}
	public void addUser(String name, String email, String password) {
		String sql = "INSERT INTO user (name, email, password) VALUES (?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				return new User (id, name, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateUser(User user) {
		String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

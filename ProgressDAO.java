package studysync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgressDAO {
	private Connection connection;
	public ProgressDAO() {
		this.connection = DatabaseConnection.getConnection();
	}
	public void addProgress(int userId, String subject, String topic, int correctAnswers, int totalQuestions) {
		String sql = "INSERT INTO progress (user_id, subject, topic, correct_answers, total_questions) VALUES (?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, userId);
			statement.setString(2, subject);
			statement.setString(3, topic);
			statement.setInt(4, correctAnswers);
			statement.setInt(5, totalQuestions);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Progress getProgressById(int id) {
		String sql = "SELECT * FROM progress WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String subject = resultSet.getString("subject");
				String topic = resultSet.getString("topic");
				int correctAnswers = resultSet.getInt("correct_answers");
				int totalQuestions = resultSet.getInt("total_questions");
				return new Progress(id, userId, subject, topic, correctAnswers, totalQuestions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Progress> getAllProgress(){
		List<Progress> progressList = new ArrayList<>();
		String sql = "SELECT * FROM progress";
		try (PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()){
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int userId = resultSet.getInt("user_id");
				String subject = resultSet.getString("subject");
				String topic = resultSet.getString("topic");
				int correctAnswers = resultSet.getInt("correct_answers");
				int totalQuestions = resultSet.getInt("total_questions");
				progressList.add(new Progress(id, userId, subject, topic, correctAnswers, totalQuestions));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return progressList;
	}

}

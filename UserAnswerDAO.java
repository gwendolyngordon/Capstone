package studysync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAnswerDAO {
	private Connection connection;
	public UserAnswerDAO() {
		this.connection = DatabaseConnection.getConnection();
	}
	public void addUserAnswer(int userId, int questionId, String userAnswer, boolean isCorrect) {
		String sql = "INSERT INTO user_answers (user_id, question_id, user_answer, is_correct) VALUES (?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, userId);
			statement.setInt(2, questionId);
			statement.setString(3, userAnswer);
			statement.setBoolean(4, isCorrect);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public UserAnswer getUserAnswerById(int id) {
		String sql = "SELECT * FROM user_answers WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				int questionId = resultSet.getInt("question_id");
				String userAnswer = resultSet.getString("user_answer");
				boolean isCorrect = resultSet.getBoolean("is_correct");
				return new UserAnswer (id, userId, questionId, userAnswer, isCorrect);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<UserAnswer> getAllUserAnswers(){
		List<UserAnswer> userAnswers = new ArrayList<>();
		String sql = "SELECT * FROM user_answers";
		try (PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()){
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int userId = resultSet.getInt("user_id");
				int questionId = resultSet.getInt("question_id");
				String userAnswer = resultSet.getString("user_answer");
				boolean isCorrect = resultSet.getBoolean("is_correct");
				userAnswers.add(new UserAnswer(id, userId, questionId, userAnswer, isCorrect));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAnswers;
	}
	
}

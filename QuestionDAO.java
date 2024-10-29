package studysync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
	private Connection connection;
	public QuestionDAO() {
		this.connection = DatabaseConnection.getConnection();
	}
	public void addQuestion(String subject, String topic, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
		String sql = "INSERT INTO questions (subject, topic, question_text, option_a, option_b, option_c, option_d, correct_option) VALUE (?,?,?,?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, subject);
			statement.setString(2, topic);
			statement.setString(3, questionText);
			statement.setString(4, optionA);
			statement.setString(5, optionB);
			statement.setString(6, optionC);
			statement.setString(7, optionD);
			statement.setString(8, correctOption);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateQuestion(Question question) {
		String sql = "UPDATE questions SET subject = ?, topic = ?, question_text = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, correction_option = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, question.getSubject());
			statement.setString(2, question.getTopic());
			statement.setString(3, question.getQuestionText());
			statement.setString(4, question.getOptionA());
			statement.setString(5, question.getOptionB());
			statement.setString(6, question.getOptionC());
			statement.setString(7, question.getOptionD());
			statement.setString(8, question.getCorrectOption());
			statement.setInt(9, question.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteQuestion(int id) {
		String sql = "DELETE FROM questions WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

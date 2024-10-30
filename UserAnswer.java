package studysync;

public class UserAnswer {
	private int id;
	private int userId;
	private int questionId;
	private String userAnswer;
	private boolean isCorrect;
	
	public UserAnswer(int id, int userId, int questionId, String userAnswer, boolean isCorrect) {
		this.id = id;
		this.userId = userId;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.isCorrect = isCorrect;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}

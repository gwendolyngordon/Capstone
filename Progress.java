package studysync;

public class Progress {
	private int id;
	private int userId;
	private String subject;
	private String topic;
	private int correctAnswers;
	private int totalQuestions;
	
	public Progress(int id, int userId, String subject, String topic, int correctAnswers, int totalQuestions) {
		this.id = id; 
		this.userId = userId;
		this.subject = subject;
		this.topic = topic;
		this.correctAnswers = correctAnswers;
		this.totalQuestions = totalQuestions;
	}
	public int getId() {
		return userId;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
}

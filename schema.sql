CREATE TABLE users (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE questions (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	subject VARCHAR(100) NOT NULL,
	topic VARCHAR(100) NOT NULL,
	question_text VARCHAR(100) NOT NULL,
	question_type VARCHAR(50) NOT NULL,
	correct_answer VARCHAR(1000) NOT NULL
);

CREATE TABLE user_answers (
	id INTEGER GENERATE BY DEFAULT AS IDENTITY PRIMARY KEY,
	user_id INTEGER,
	question_id INTEGER,
	user_answer VARCHAR(1000),
	is_correct BOOLEAN,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE progress (
	id INTEGER GENERATE BY DEFAULT AS IDENTITY PRIMARY KEY,
	user_id INTEGER,
	subject VARCHAR(100),
	topic VARCHAR(100),
	correct_answers INTEGER,
	total_questions INTEGER,
	FOREIGN KEY (user_id) REFERNCES users(id)
);
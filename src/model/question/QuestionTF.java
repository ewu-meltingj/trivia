/*
 * 
 */
package model.question;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionTF.
 * 
 * @author jeremy
 */

// TODO replace with team members

public class QuestionTF {

	/** The _question. */
	private String _question;

	/** The _answer. */
	private String _answer;

	/**
	 * Instantiates a new question tf.
	 */
	public QuestionTF() {
		_question = "Hamburgers are Better than hotdogs. (true)";
		_answer = "true";
	}

	/**
	 * Check answer.
	 * 
	 * @param userAnswer
	 *            the user answer
	 * @return true, if successful
	 */
	public boolean checkAnswer(String userAnswer) {
		return userAnswer.equalsIgnoreCase(_answer);
	}

	/**
	 * Gets the answer.
	 * 
	 * @return the answer
	 */
	public String getAnswer() {
		return _answer;
	}

	/**
	 * Gets the question.
	 * 
	 * @return the question
	 */
	public String getQuestion() {
		return _question;
	}

}

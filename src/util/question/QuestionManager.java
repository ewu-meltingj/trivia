/*
 * 
 */
package util.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionManager.
 */
public class QuestionManager {

	/** The _trivial question amount. */
	private final int _trivialQuestionAmount = 19; // used as placeholder

	/** The _random. */
	private Random _random;

	/** The _question total clipped. */
	private int _questionTotalClipped;

	/** The _question total. */
	private int _questionTotal;

	/** The _question per side. */
	private int _questionPerSide;

	/** The _used random question i ds. */
	private List<Integer> _usedRandomQuestionIDs;

	/**
	 * Instantiates a new question manager.
	 */
	public QuestionManager() {
		_questionTotal = getTotalFromDatabase();
		_questionPerSide = questionTotalRoot(_questionTotal);
		_questionTotalClipped = _questionPerSide * _questionPerSide;
		_random = new Random();
		_usedRandomQuestionIDs = new ArrayList<Integer>();
	}

	/**
	 * Gets the next random id.
	 * 
	 * @return the next random id
	 */
	public int getNextRandomID() {
		if (_usedRandomQuestionIDs.size() == _questionTotal)
			throw new RuntimeException("ID larger that number of quesitons.");

		Integer questionID = _random.nextInt(_questionTotal);
		while (_usedRandomQuestionIDs.contains(questionID))
			questionID = _random.nextInt(_questionTotal);

		_usedRandomQuestionIDs.add(questionID);
		return questionID;
	}

	/**
	 * Gets the total from database.
	 * 
	 * @return the total from database
	 */
	private int getTotalFromDatabase() {
		return _trivialQuestionAmount;
	}

	/**
	 * Gets the used i ds.
	 * 
	 * @return the used i ds
	 */
	public List<Integer> getUsedIDs() {
		return _usedRandomQuestionIDs;
	}

	/**
	 * Lendth side.
	 * 
	 * @return the int
	 */
	public int lendthSide() {
		return _questionPerSide;
	}

	/**
	 * Length.
	 * 
	 * @return the int
	 */
	public int length() {
		return _questionTotal;
	}

	/**
	 * Length cleaned.
	 * 
	 * @return the int
	 */
	public int lengthCleaned() {
		return _questionTotalClipped;
	}

	/**
	 * Question total root.
	 * 
	 * @param total
	 *            the total
	 * @return the int
	 */
	private int questionTotalRoot(int total) {
		return ((int) Math.sqrt(total));
	}
}

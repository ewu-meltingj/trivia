/*
 * 
 */
package view;

import model.question.QuestionTF;

import com.googlecode.blacken.terminal.BlackenMouseEvent;
import com.googlecode.blacken.terminal.BlackenWindowEvent;
import com.googlecode.blacken.terminal.TerminalInterface;
import com.googlecode.blacken.terminal.TerminalView;
import com.googlecode.blacken.terminal.TerminalViewInterface;
import com.googlecode.blacken.terminal.editing.CodepointCallbackInterface;
import com.googlecode.blacken.terminal.editing.SingleLine;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewQuestion.
 */
public class ViewQuestion implements CodepointCallbackInterface {

	/** The term. */
	private final TerminalInterface term;

	/** The view. */
	private TerminalViewInterface view;

	/** The _question. */
	private QuestionTF _question;

	/**
	 * Instantiates a new view question.
	 * 
	 * @param term
	 *            the term
	 * @param question
	 *            the question
	 */
	public ViewQuestion(TerminalInterface term, QuestionTF question) {
		this.term = term;
		_question = question;
		view = new TerminalView(term);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.blacken.terminal.editing.CodepointCallbackInterface#
	 * handleCodepoint(int)
	 */
	@Override
	public int handleCodepoint(int codepoint) {
		return codepoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.blacken.terminal.editing.CodepointCallbackInterface#
	 * handleMouseEvent(com.googlecode.blacken.terminal.BlackenMouseEvent)
	 */
	@Override
	public boolean handleMouseEvent(BlackenMouseEvent mouse) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.blacken.terminal.editing.CodepointCallbackInterface#
	 * handleResizeEvent()
	 */
	@Override
	public void handleResizeEvent() {
		term.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.blacken.terminal.editing.CodepointCallbackInterface#
	 * handleWindowEvent(com.googlecode.blacken.terminal.BlackenWindowEvent)
	 */
	@Override
	public boolean handleWindowEvent(BlackenWindowEvent window) {
		return false;
	}

	/**
	 * Run.
	 * 
	 * @return true, if successful
	 */
	public boolean run() {
		term.clear();
		SingleLine.putString(view, 4, 3, _question.getQuestion(), 50, 0);
		String answer = SingleLine.getString(term, 20, 3, 22, null);

		return _question.checkAnswer(answer);
	}

}

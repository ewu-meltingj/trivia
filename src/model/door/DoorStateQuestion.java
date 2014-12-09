/*
 * 
 */
package model.door;

import model.question.QuestionTF;
import view.observer.ObserveDoor;

// TODO: Auto-generated Javadoc
/**
 * The Class DoorStateQuestion.
 * 
 * @author jeremy
 */

// TODO add interaction
public class DoorStateQuestion implements I_DoorState {

	/** The _question tf. */
	QuestionTF _questionTF;

	/*
	 * A PassageQuestion has a room and a question.
	 */
	/**
	 * Instantiates a new door state question.
	 */
	public DoorStateQuestion() {
		_questionTF = new QuestionTF();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.door.I_DoorState#accept(view.observer.ObserveDoor)
	 */
	@Override
	public void accept(ObserveDoor viewObserveDoor) {
		viewObserveDoor.handleState(this);
	}

	/**
	 * Gets the question.
	 * 
	 * @return the question
	 */
	public QuestionTF getQuestion() {
		return _questionTF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.door.I_DoorState#getSymbol()
	 */
	@Override
	public int getSymbol() {
		return "?".codePointAt(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.door.I_DoorState#getSymbolSimple()
	 */
	@Override
	public int getSymbolSimple() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.door.I_DoorState#interact(model.door.Door)
	 */
	@Override
	public boolean interact(Door door) {
		door.getPassage().isStateChanged(true);
		return false;
	}
}
/*
 * 
 */
package view.observer;

import model.door.Door;
import model.door.DoorStateBlocked;
import model.door.DoorStateCleared;
import model.door.DoorStateQuestion;
import view.ViewQuestion;
import view.drawer.Drawer;

import com.googlecode.blacken.terminal.TerminalInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ObserveDoor.
 * 
 * @author jeremy
 */

public class ObserveDoor implements I_Observe {

	/** The _door. */
	private Door _door;

	/** The _drawer. */
	private Drawer _drawer;

	/** The _term. */
	private TerminalInterface _term;

	/**
	 * Instantiates a new observe door.
	 * 
	 * @param door
	 *            the door
	 * @param drawer
	 *            the drawer
	 * @param term
	 *            the term
	 */
	public ObserveDoor(Door door, Drawer drawer, TerminalInterface term) {
		_door = door;
		_drawer = drawer;
		_term = term;
	}

	/**
	 * Handle state.
	 * 
	 * @param blockedState
	 *            the blocked state
	 */
	public void handleState(DoorStateBlocked blockedState) {
	}

	/**
	 * Handle state.
	 * 
	 * @param clearedState
	 *            the cleared state
	 */
	public void handleState(DoorStateCleared clearedState) {
	}

	/**
	 * Handle state.
	 * 
	 * @param questionState
	 *            the question state
	 */
	public void handleState(DoorStateQuestion questionState) {
		ViewQuestion questionAnswerer;
		boolean isCorrect;
		questionAnswerer = new ViewQuestion(_term, questionState.getQuestion());
		isCorrect = questionAnswerer.run();

		if (isCorrect) {
			_door.setDoorState(new DoorStateCleared());
			_door.getSibling().setDoorState(new DoorStateCleared());
		} else {
			_door.setDoorState(new DoorStateBlocked());
			_door.getSibling().setDoorState(new DoorStateBlocked());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.observer.I_Observe#update()
	 */
	@Override
	public void update() {
		if (_door.isStateChanged()) {
			_door.getState().accept(this);
			_drawer.drawDoor(_door);
			_door.isStateChanged(false);
		}
	}
}

/*
 * 
 */
package model.door;

import view.observer.ObserveDoor;

// TODO: Auto-generated Javadoc
/**
 * The Class DoorStateCleared.
 * 
 * @author jeremy
 */
public class DoorStateCleared implements I_DoorState {

	/*
	 * A PassageQuestion has a room and a question.
	 */
	/**
	 * Instantiates a new door state cleared.
	 */
	public DoorStateCleared() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.door.I_DoorState#getSymbol()
	 */
	@Override
	public int getSymbol() {
		return "+".codePointAt(0);
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
		return true;
	}
}
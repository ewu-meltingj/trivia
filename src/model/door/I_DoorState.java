/*
 * 
 */
package model.door;

import view.observer.ObserveDoor;

// TODO: Auto-generated Javadoc
//import model.player.Player;

/**
 * The Interface I_DoorState.
 * 
 * @author jeremy
 */
public interface I_DoorState {

	/**
	 * Accept.
	 * 
	 * @param viewObserveDoor
	 *            the view observe door
	 */
	public void accept(ObserveDoor viewObserveDoor);

	/**
	 * Gets the symbol.
	 * 
	 * @return the symbol
	 */
	public int getSymbol();

	/**
	 * Gets the symbol simple.
	 * 
	 * @return the symbol simple
	 */
	public int getSymbolSimple();

	/**
	 * Interact.
	 * 
	 * @param door
	 *            the door
	 * @return true, if successful
	 */
	public boolean interact(Door door);
}

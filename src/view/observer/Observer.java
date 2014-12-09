/*
 * 
 */
package view.observer;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Observer.
 * 
 * @author jeremy
 */

public class Observer {

	/** The door observers. */
	private List<I_Observe> doorObservers = new ArrayList<I_Observe>();

	/** The player observers. */
	private List<I_Observe> playerObservers = new ArrayList<I_Observe>();

	/**
	 * Instantiates a new observer.
	 */
	public Observer() {
	}

	/**
	 * Gets the doors.
	 * 
	 * @return the doors
	 */
	public List<I_Observe> getDoors() {
		return doorObservers;
	}

	/**
	 * Notify all elements.
	 */
	public void notifyAllElements() {
		notifyDoors();
		notifyPlayers();
	}

	/**
	 * Notify doors.
	 */
	public void notifyDoors() {
		for (I_Observe ob : doorObservers)
			ob.update();
	}

	/**
	 * Notify players.
	 */
	public void notifyPlayers() {
		for (I_Observe ob : playerObservers)
			ob.update();
	}

	/**
	 * Register door.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void registerDoor(I_Observe observer) {
		doorObservers.add(observer);
	}

	/**
	 * Register player.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void registerPlayer(I_Observe observer) {
		playerObservers.add(observer);
	}

	/**
	 * Removes the door.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void removeDoor(I_Observe observer) {
		doorObservers.remove(observer);
	}

	/**
	 * Removes the player.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void removePlayer(I_Observe observer) {
		playerObservers.remove(observer);
	}

	/**
	 * Sets the doors.
	 * 
	 * @param doors
	 *            the new doors
	 */
	public void setDoors(List<I_Observe> doors) {
		doorObservers = doors;
	}

	/**
	 * Sets the players.
	 * 
	 * @param players
	 *            the new players
	 */
	public void setPlayers(List<I_Observe> players) {
		playerObservers = players;
	}

}
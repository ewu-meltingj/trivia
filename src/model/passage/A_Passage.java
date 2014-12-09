/*
 * 
 */
package model.passage;

import model.door.Door;
import model.door.DoorStateBlocked;
import model.door.DoorStateCleared;
import model.door.DoorStateQuestion;
import model.player.Player;
import model.point.Point;
import model.region.RegionRoom;
import contracts.I_Interactive;

// TODO: Auto-generated Javadoc
/**
 * The Class A_Passage.
 * 
 * @author jeremy
 */
public abstract class A_Passage implements I_Interactive {

	/** The _first door. */
	protected Door _firstDoor;

	/** The _second door. */
	protected Door _secondDoor;

	/** The _passage end. */
	protected Point _passageEnd;

	/** The _passage origin. */
	protected Point _passageOrigin;

	/**
	 * Instantiates a new a_ passage.
	 * 
	 * @param firstRoom
	 *            the first room
	 * @param secondRoom
	 *            the second room
	 */
	public A_Passage(RegionRoom firstRoom, RegionRoom secondRoom) {
		_firstDoor = new Door(new DoorStateQuestion());
		_firstDoor.setRoom(firstRoom);
		_firstDoor.setPassage(this);

		_secondDoor = new Door(new DoorStateQuestion());
		_secondDoor.setRoom(secondRoom);
		_secondDoor.setPassage(this);
	}

	/**
	 * Block doors.
	 */
	public void blockDoors() {
		_firstDoor.setDoorState(new DoorStateBlocked());
		_firstDoor.isStateChanged(true);
		_secondDoor.setDoorState(new DoorStateBlocked());
		_secondDoor.isStateChanged(true);
	}

	/**
	 * Clear doors.
	 */
	public void clearDoors() {
		_firstDoor.setDoorState(new DoorStateCleared());
		_firstDoor.isStateChanged(true);
		_secondDoor.setDoorState(new DoorStateCleared());
		_secondDoor.isStateChanged(true);
	}

	/**
	 * Gets the door first.
	 * 
	 * @return the door first
	 */
	public Door getDoorFirst() {
		return _firstDoor;
	}

	/**
	 * Gets the door second.
	 * 
	 * @return the door second
	 */
	public Door getDoorSecond() {
		return _secondDoor;
	}

	/**
	 * Gets the door sibling.
	 * 
	 * @param door
	 *            the door
	 * @return the door sibling
	 */
	public Door getDoorSibling(Door door) {
		if (!_firstDoor.equals(door))
			return _firstDoor;
		return _secondDoor;
	}

	public boolean contains(Point point) {
		int x = point.getX();
		int y = point.getY();

		if (x >= _passageOrigin.getX() && x <= _passageEnd.getX())
			if (y >= _passageOrigin.getY() && y <= _passageEnd.getY())
				return true;
		return false;
	}

	/**
	 * Gets the point end.
	 * 
	 * @return the point end
	 */
	public Point getEnd() {
		return _passageEnd;
	}
	
	public void interact(Player player, Point direction){
		
	}

	/**
	 * Gets the point origin.
	 * 
	 * @return the point origin
	 */
	public Point getOrigin() {
		return _passageOrigin;
	}
	
	public int getHeight() {
		return _passageEnd.getX() - _passageOrigin.getX();
	}
	public int getWidth() {
		return  _passageEnd.getY() - _passageOrigin.getY();
	}

	/**
	 * Checks if is state changed.
	 * 
	 * @param state
	 *            the state
	 */
	public abstract void isStateChanged(boolean state);

}

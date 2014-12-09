/*
 * 
 */
package model.door;

import model.passage.A_Passage;
import model.point.Point;
import model.region.RegionRoom;
import contracts.I_ChangeState;
import contracts.I_Interactive;

// TODO: Auto-generated Javadoc
/**
 * The Class Door.
 * 
 * @author jeremy
 */
public class Door implements I_ChangeState, I_Interactive {

	/** The _door state. */
	private I_DoorState _doorState;

	/** The _passage. */
	private A_Passage _passage;

	/** The _origin. */
	private Point _origin;

	/** The _room. */
	private transient RegionRoom _room;

	/** The _is state changed. */
	private boolean _isStateChanged;

	/**
	 * Instantiates a new door.
	 * 
	 * @param door
	 *            the door
	 */
	public Door(I_DoorState door) {
		if (door == null)
			throw new RuntimeException("Stuff passed in Doors is null");
		_doorState = door;
		_isStateChanged = false;
	}

	/**
	 * Block door.
	 */
	public void blockDoor() {
		_passage.blockDoors();
	}

	/**
	 * Clear door.
	 */
	public void clearDoor() {
		_passage.clearDoors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Door door = (Door) obj;
		if (!this._origin.equals(door.getOrigin()))
			return false;

		return true;
	}

	/**
	 * Gets the origin.
	 * 
	 * @return the origin
	 */
	public Point getOrigin() {
		return _origin;
	}

	/**
	 * Gets the passage.
	 * 
	 * @return the passage
	 */
	public A_Passage getPassage() {
		return _passage;
	}

	/**
	 * Gets the room.
	 * 
	 * @return the room
	 */
	public RegionRoom getRoom() {
		return _room;
	}

	/**
	 * Gets the sibling.
	 * 
	 * @return the sibling
	 */
	public Door getSibling() {
		return _passage.getDoorSibling(this);
	}

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public I_DoorState getState() {
		return _doorState;
	}

	/**
	 * Gets the symbol.
	 * 
	 * @return the symbol
	 */
	public int getSymbol() {
		return _doorState.getSymbol();
	}

	/**
	 * Gets the symbol simple.
	 * 
	 * @return the symbol simple
	 */
	public int getSymbolSimple() {
		return _doorState.getSymbolSimple();
	}

	/**
	 * Interact.
	 * 
	 * @return true, if successful
	 */
	public boolean interact() {
		return _doorState.interact(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contracts.I_ChangeState#isStateChanged()
	 */
	@Override
	public boolean isStateChanged() {
		return _isStateChanged;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contracts.I_ChangeState#isStateChanged(boolean)
	 */
	@Override
	public void isStateChanged(boolean isChanged) {
		_isStateChanged = isChanged;
	}

	/**
	 * Sets the door state.
	 * 
	 * @param door
	 *            the new door state
	 */
	public void setDoorState(I_DoorState door) {
		if (door == null)
			throw new RuntimeException("Negative");
		_doorState = door;
	}

	/**
	 * Sets the origin.
	 * 
	 * @param origin
	 *            the new origin
	 */
	public void setOrigin(Point origin) {
		_origin = origin;
	}

	/**
	 * Sets the passage.
	 * 
	 * @param passage
	 *            the new passage
	 */
	public void setPassage(A_Passage passage) {
		_passage = passage;
	}

	/**
	 * Sets the room.
	 * 
	 * @param room
	 *            the new room
	 */
	public void setRoom(RegionRoom room) {
		_room = room;
	}

	/* (non-Javadoc)
	 * @see contracts.I_Interactive#getWidth()
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see contracts.I_Interactive#getHeight()
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}

/*
 * 
 */
package model.player;

//import observer.ElementObserver;

import java.io.Serializable;

import model.point.Point;
import model.region.RegionRoom;
import util.text.TextSlug;
import contracts.I_ChangeState;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 * 
 * @author jeremy
 */

public class Player implements I_ChangeState, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7414025333294430792L;

	/** The _x coordinate. */
	private int _xCoordinate;

	/** The _y coordinate. */
	private int _yCoordinate;

	/** The _old position. */
	private Point _oldPosition;

	/** The _symbol player. */
	private int _symbolPlayer;

	/** The _current room. */
	private transient RegionRoom _currentRoom;

	/** The _current room id. */
	private int _currentRoomID;

	/** The _has quit. */
	private boolean _hasQuit;

	/** The _is state changed. */
	private boolean _isStateChanged;

	/**
	 * Instantiates a new player.
	 * 
	 * @param newRoom
	 *            the new room
	 */
	public Player(RegionRoom newRoom) {
		_currentRoom = newRoom;
		_currentRoomID = newRoom.getId();
		this.setPlayerPosition(newRoom.center());
		_oldPosition = new Point(_yCoordinate, _xCoordinate);
		_hasQuit = false;
		_isStateChanged = true;
		_symbolPlayer = TextSlug.LOOKING_DOWN;
	}

	/**
	 * Gets the player position.
	 * 
	 * @return the player position
	 */
	public Point getPosition() {
		return new Point(_yCoordinate, _xCoordinate);
	}

	/**
	 * Gets the player position prev.
	 * 
	 * @return the player position prev
	 */
	public Point getPlayerPositionPrev() {
		return _oldPosition;
	}

	/**
	 * Gets the player symbol.
	 * 
	 * @return the player symbol
	 */
	public int getPlayerSymbol() {
		return _symbolPlayer;
	}

	/**
	 * Gets the room current id.
	 * 
	 * @return the room current id
	 */
	public int getRoomCurrentID() {
		return _currentRoomID;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return _xCoordinate;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return _yCoordinate;
	}

	/**
	 * Checks for quit.
	 * 
	 * @return true, if successful
	 */
	public boolean hasQuit() {
		return _hasQuit;
	}

	/**
	 * Checks for quit.
	 * 
	 * @param hasQuit
	 *            the has quit
	 */
	public void hasQuit(boolean hasQuit) {
		_hasQuit = hasQuit;
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
	 * Move.
	 * 
	 * @param direction
	 *            the direction
	 */
	public void move(Point direction) {
		_oldPosition = getPosition();
		this.setPlayerPosition(_yCoordinate + direction.getY(), _xCoordinate
				+ direction.getX());
		_isStateChanged = true;
	}

	/**
	 * Sets the player position.
	 * 
	 * @param yCoord
	 *            the y coord
	 * @param xCoord
	 *            the x coord
	 */
	public void setPlayerPosition(int yCoord, int xCoord) {
		_xCoordinate = xCoord;
		_yCoordinate = yCoord;
	}

	/**
	 * Sets the player position.
	 * 
	 * @param position
	 *            the new player position
	 */
	public void setPlayerPosition(Point position) {
		_xCoordinate = position.getX();
		_yCoordinate = position.getY();
	}

	/**
	 * Sets the player position prev.
	 * 
	 * @param prev
	 *            the new player position prev
	 */
	public void setPlayerPositionPrev(Point prev) {
		_oldPosition = prev;
	}

	/**
	 * Sets the player symbol.
	 * 
	 * @param symbolPlayer
	 *            the new player symbol
	 */
	public void setPlayerSymbol(int symbolPlayer) {
		_symbolPlayer = symbolPlayer;
	}

	/**
	 * Sets the room.
	 * 
	 * @param newRoom
	 *            the new room
	 */
	public void setRoom(RegionRoom newRoom) {
		_currentRoom = newRoom;
		_currentRoomID = _currentRoom.getId();
	}

}

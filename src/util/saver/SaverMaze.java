/*
 * 
 */
package util.saver;

import java.io.Serializable;
import java.util.List;

import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class SaverMaze.
 */
public class SaverMaze implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2398789582979807509L;

	/** The _rooms. */
	private int _rooms;

	/** The _rooms map. */
	private List<RegionRoom> _roomsMap;

	/** The _maze width. */
	private int _mazeWidth;

	/** The _maze height. */
	private int _mazeHeight;

	/**
	 * Instantiates a new saver maze.
	 * 
	 * @param maze
	 *            the maze
	 */
	public SaverMaze(RegionMaze maze) {
		_rooms = maze.getRoomTotalSquared();
		_roomsMap = maze.getRooms();
		_mazeWidth = maze.getWidth();
		_mazeHeight = maze.getHeight();
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return _mazeHeight;
	}

	/**
	 * Gets the number room.
	 * 
	 * @return the number room
	 */
	public int getNumberRoom() {
		return _rooms;
	}

	/**
	 * Gets the rooms.
	 * 
	 * @return the rooms
	 */
	public List<RegionRoom> getRooms() {
		return _roomsMap;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return _mazeWidth;
	}
}

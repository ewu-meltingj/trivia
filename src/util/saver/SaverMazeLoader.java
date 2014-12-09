/*
 * 
 */
package util.saver;

import model.passage.A_Passage;
import model.passage.PassageHorizontal;
import model.passage.PassageVertical;
import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class SaverMazeLoader.
 */
public class SaverMazeLoader {

	/** The _maze. */
	private RegionMaze _maze;

	/** The _total side rooms. */
	private int _totalSideRooms;

	/** The Constant ROOM_WIDTH. */
	private static final int ROOM_WIDTH = 11;

	/** The Constant ROOM_HEIGHT. */
	private static final int ROOM_HEIGHT = 5;

	/** The Constant ROOM_PADDING. */
	private static final int ROOM_PADDING = 5;

	/**
	 * Instantiates a new saver maze loader.
	 */
	public SaverMazeLoader() {

	}

	// add passages to the left neighbor and to itself.
	/**
	 * Adds the doors lr.
	 * 
	 * @param roomAdjacent
	 *            the room adjacent
	 * @param roomCurrent
	 *            the room current
	 */
	private void addDoorsLR(RegionRoom roomAdjacent, RegionRoom roomCurrent) {
		// System.out.println("Adjacent: " + roomAdjacent + " Adjacent: " +
		// roomCurrent);
		A_Passage pass = new PassageHorizontal(roomAdjacent, roomCurrent);
		_maze.addPassage(pass);
		roomAdjacent.addDoor(pass.getDoorFirst());
		roomCurrent.addDoor(pass.getDoorSecond());
	}

	// add passages to the top neighbor and to itself.
	/**
	 * Adds the doors ud.
	 * 
	 * @param roomAdjacent
	 *            the room adjacent
	 * @param roomCurrent
	 *            the room current
	 */
	private void addDoorsUD(RegionRoom roomAdjacent, RegionRoom roomCurrent) {
		A_Passage pass = new PassageVertical(roomAdjacent, roomCurrent);
		_maze.addPassage(pass);
		roomAdjacent.addDoor(pass.getDoorFirst());
		roomCurrent.addDoor(pass.getDoorSecond());
	}

	/**
	 * Creates the.
	 * 
	 * @param attributes
	 *            the attributes
	 * @return the region maze
	 */
	public RegionMaze create(SaverMaze attributes) {
		_maze = new RegionMaze(attributes.getNumberRoom());
		_maze.setHeight(attributes.getHeight());
		_maze.setWidth(attributes.getWidth());
		_totalSideRooms = _maze.getRoomTotalSquared();
		int roomId;

		for (RegionRoom roomCurrent : attributes.getRooms()) {
			roomId = roomCurrent.getId();
			_maze.addRoom(roomId, roomCurrent);
			// System.out.println("Current: " + roomCurrent);

			// connect rooms
			if (hasRoomAdjacentLeft(roomId)) {
				RegionRoom roomLeft = _maze.getRoom(roomId - 1);
				// System.out.println("AdjacentLeft: " + roomLeft);
				addDoorsLR(roomLeft, roomCurrent);
			}
			if (hasRoomAdjacentUp(roomId)) {
				RegionRoom roomUp = _maze.getRoom(roomId
						- _maze.getRoomTotalSquared());
				// System.out.println("AdjacentUp: " + roomUp);
				addDoorsUD(roomUp, roomCurrent);
			}
		}
		return _maze;
	}

	/**
	 * Grid height.
	 * 
	 * @return the int
	 */
	public int gridHeight() {
		return (ROOM_HEIGHT + ROOM_PADDING) * _totalSideRooms + ROOM_PADDING;
	}

	/**
	 * Grid width.
	 * 
	 * @return the int
	 */
	public int gridWidth() {
		return (ROOM_WIDTH + ROOM_PADDING) * _totalSideRooms + ROOM_PADDING;
	}

	// check if the current room has a neighbor to its left.
	/**
	 * Checks for room adjacent left.
	 * 
	 * @param roomId
	 *            the room id
	 * @return true, if successful
	 */
	private boolean hasRoomAdjacentLeft(int roomId) {
		return _maze.hasRoom(roomId - 1) && roomId % _totalSideRooms != 0;
	}

	// check if the current room has a neighbor above itself.
	/**
	 * Checks for room adjacent up.
	 * 
	 * @param roomId
	 *            the room id
	 * @return true, if successful
	 */
	private boolean hasRoomAdjacentUp(int roomId) {
		return _maze.hasRoom(roomId - _totalSideRooms);
	}
}

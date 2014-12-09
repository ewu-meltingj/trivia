/*
 * 
 */
package util.maze;

import java.util.HashMap;
import java.util.Map;

import contracts.I_Interactive;

import model.passage.A_Passage;
import model.passage.PassageHorizontal;
import model.passage.PassageVertical;
import model.point.Point;
import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class MazeBuilder.
 */
public class MazeBuilder {

	private Map<Point, I_Interactive> interactiveMap;

	/** The _maze. */
	private RegionMaze _maze;

	/** The _total rooms. */
	private int _totalRooms;

	/** The _total side rooms. */
	private int _totalSideRooms;

	/** The Constant ROOM_WIDTH. */
	private static final int ROOM_WIDTH = 11;

	/** The Constant ROOM_HEIGHT. */
	private static final int ROOM_HEIGHT = 5;

	/** The Constant ROOM_PADDING. */
	private static final int ROOM_PADDING = 5;

	/**
	 * Instantiates a new maze builder.
	 */
	public MazeBuilder() {
		interactiveMap = new HashMap<Point, I_Interactive>();
	}

	/**
	 * Adds the Left and Right Doors to their associated rooms and to their
	 * shared pasage.
	 * 
	 * @param roomAdjacent
	 *            the left room
	 * @param roomCurrent
	 *            the right room
	 */
	private void addDoorsLR(RegionRoom roomAdjacent, RegionRoom roomCurrent) {
		A_Passage pass = new PassageHorizontal(roomAdjacent, roomCurrent);
		_maze.addPassage(pass);
		roomAdjacent.addDoor(pass.getDoorFirst());
		roomCurrent.addDoor(pass.getDoorSecond());
		addToMapAll(new I_Interactive[] { roomAdjacent, roomCurrent, pass,
				pass.getDoorFirst(), pass.getDoorSecond() });
	}

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
		addToMapAll(new I_Interactive[] { roomAdjacent, roomCurrent, pass,
				pass.getDoorFirst(), pass.getDoorSecond() });
	}

	/**
	 * Creates the.
	 * 
	 * @param maze
	 *            the maze
	 */
	public void create(RegionMaze maze) {
		_maze = maze;
		_totalRooms = maze.getRoomTotal();
		_totalSideRooms = maze.getRoomTotalSquared();
		maze.setWidth(gridWidth());
		maze.setHeight(gridHeight());

		for (int roomId = 0; roomId < _totalRooms; roomId++) {
			RegionRoom roomCurrent = new RegionRoom(roomId,
					createRoomOrigin(roomId), ROOM_WIDTH, ROOM_HEIGHT);
			maze.addRoom(roomId, roomCurrent);

			// connect rooms
			if (hasRoomAdjacentLeft(roomId)) {
				RegionRoom roomLeft = maze.getRoom(roomId - 1);
				addDoorsLR(roomLeft, roomCurrent);
			}
			if (hasRoomAdjacentUp(roomId)) {
				RegionRoom roomUp = maze.getRoom(roomId
						- maze.getRoomTotalSquared());
				addDoorsUD(roomUp, roomCurrent);
			}
		}
	}

	private void addToMap(I_Interactive active) {
		int originY = active.getOrigin().getY();
		int originX = active.getOrigin().getX();
		int endY = active.getHeight() + originY;
		int endX = active.getWidth() + originX;
		for (int y = originY; y < endY; y++)
			for (int x = originX; x < endX; x++)
				interactiveMap.put(new Point(y, x), active);
	}

	private void addToMapAll(I_Interactive[] active) {
		for (int i = 0; i < active.length; i++)
			addToMap(active[i]);
	}

	/**
	 * Creates the room origin.
	 * 
	 * @param roomID
	 *            the room id
	 * @return the point
	 */
	public Point createRoomOrigin(int roomID) {
		int offsetX = ROOM_WIDTH + ROOM_PADDING;// 20
		int offsetY = ROOM_HEIGHT + ROOM_PADDING;// 8
		int yCoord = roomID / _totalSideRooms;
		int xCoord = roomID % _totalSideRooms;
		return new Point(yCoord * offsetY + ROOM_PADDING, xCoord * offsetX
				+ ROOM_PADDING);
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

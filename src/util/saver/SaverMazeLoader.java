package util.saver;

import model.passage.A_Passage;
import model.passage.PassageHorizontal;
import model.passage.PassageVertical;
import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc

public class SaverMazeLoader {

	private RegionMaze _maze;

	private int _totalSideRooms;

	private static final int ROOM_WIDTH = 11;

	private static final int ROOM_HEIGHT = 5;

	private static final int ROOM_PADDING = 5;

	public SaverMazeLoader() {

	}

	// add passages to the left neighbor and to itself.

	private void addDoorsLR(RegionRoom roomAdjacent, RegionRoom roomCurrent) {
		// System.out.println("Adjacent: " + roomAdjacent + " Adjacent: " +
		// roomCurrent);
		A_Passage pass = new PassageHorizontal(roomAdjacent, roomCurrent);
		_maze.addPassage(pass);
		roomAdjacent.addDoor(pass.getDoorFirst());
		roomCurrent.addDoor(pass.getDoorSecond());
	}

	// add passages to the top neighbor and to itself.

	private void addDoorsUD(RegionRoom roomAdjacent, RegionRoom roomCurrent) {
		A_Passage pass = new PassageVertical(roomAdjacent, roomCurrent);
		_maze.addPassage(pass);
		roomAdjacent.addDoor(pass.getDoorFirst());
		roomCurrent.addDoor(pass.getDoorSecond());
	}

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

	public int gridHeight() {
		return (ROOM_HEIGHT + ROOM_PADDING) * _totalSideRooms + ROOM_PADDING;
	}

	public int gridWidth() {
		return (ROOM_WIDTH + ROOM_PADDING) * _totalSideRooms + ROOM_PADDING;
	}

	// check if the current room has a neighbor to its left.

	private boolean hasRoomAdjacentLeft(int roomId) {
		return _maze.hasRoom(roomId - 1) && roomId % _totalSideRooms != 0;
	}

	// check if the current room has a neighbor above itself.

	private boolean hasRoomAdjacentUp(int roomId) {
		return _maze.hasRoom(roomId - _totalSideRooms);
	}
}

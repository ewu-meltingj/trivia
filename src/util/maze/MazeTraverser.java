/*
 * 
 */
package util.maze;

import model.door.Door;
import model.passage.A_Passage;
import model.player.Player;
import model.point.Point;
import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class MazeTraverser.
 */
public class MazeTraverser {

	/** The _maze to check. */
	private int[][] _mazeToCheck;

	/** The _was here. */
	private boolean[][] _wasHere;

	/** The _maze. */
	private RegionMaze _maze;

	/** The _maze height. */
	private int _mazeHeight;

	/** The _maze width. */
	private int _mazeWidth;

	/** The _player. */
	private Player _player;

	/** The _start. */
	private Point _start;

	/** The _end. */
	private Point _end;

	/**
	 * Instantiates a new maze traverser.
	 * 
	 * @param maze
	 *            the maze
	 * @param player
	 *            the player
	 */
	public MazeTraverser(RegionMaze maze, Player player) {
		_maze = maze;
		_mazeHeight = _maze.getHeight();
		_mazeWidth = _maze.getWidth();
		_mazeToCheck = new int[_mazeHeight][_mazeWidth];
		_wasHere = new boolean[_mazeHeight][_mazeWidth];
		_player = player;
		_start = _player.getPlayerPosition();
		_end = maze.getRoomEnd().center();
		drawMaze();
		drawPassages();
	}

	/**
	 * Draw maze.
	 */
	private void drawMaze() {
		for (int y = 0; y < _mazeHeight; y++)
			for (int x = 0; x < _mazeWidth; x++)
				_mazeToCheck[y][x] = 2;
	}

	/**
	 * Draw passages.
	 */
	private void drawPassages() {
		for (A_Passage passage : _maze.getPassages()) {

			Point origin = passage.getPointOrigin();
			Point end = passage.getPointEnd();
			int lenthHorizontal = end.getX() - origin.getX();
			int lenthVertical = end.getY() - origin.getY();

			for (int y = 0; y < lenthVertical; y++)
				_mazeToCheck[y + origin.getY()][origin.getX()] = 1;

			for (int x = 0; x < lenthHorizontal; x++)
				_mazeToCheck[origin.getY()][origin.getX() + x] = 1;
		}
	}

	/**
	 * Draw rooms and doors.
	 */
	private void drawRoomsAndDoors() {
		for (RegionRoom room : _maze.getRooms()) {
			int yRoomOrigin = room.getOrigin().getY();
			int xRoomOrigin = room.getOrigin().getX();
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++)
					_mazeToCheck[y + yRoomOrigin][x + xRoomOrigin] = 1;

			for (Door door : room.getDoors()) {
				int yDoorOrigin = door.getOrigin().getY();
				int xDoorOrigin = door.getOrigin().getX();
				_mazeToCheck[yDoorOrigin][xDoorOrigin] = door.getSymbolSimple();
			}
		}
	}

	/**
	 * Inits the.
	 */
	private void init() {
		drawRoomsAndDoors();
	}

	/**
	 * Prints the maze.
	 */
	public void printMaze() {
		for (int y = 0; y < _mazeHeight; y++) {
			for (int x = 0; x < _mazeWidth; x++)
				System.out.print(_mazeToCheck[y][x]);
			System.out.println("");
		}
		System.out.println("\n");
	}

	/**
	 * Recursive solve.
	 * 
	 * @param y
	 *            the y
	 * @param x
	 *            the x
	 * @return true, if successful
	 */
	public boolean recursiveSolve(int y, int x) {
		if (y == _end.getY() && x == _end.getX())
			return true; // If you reached the end
		if (_mazeToCheck[y][x] == 2 || _wasHere[y][x])
			return false;
		// If you are on a wall or already were here
		_wasHere[y][x] = true;
		if (x != 0) // Checks if not on left edge
			if (recursiveSolve(y - 1, x)) { // Recalls method one to the left
				return true;
			}
		if (x != _mazeWidth - 1) // Checks if not on right edge
			if (recursiveSolve(y + 1, x)) { // Recalls method one to the right
				return true;
			}
		if (y != 0) // Checks if not on top edge
			if (recursiveSolve(y, x - 1)) { // Recalls method one up
				return true;
			}
		if (y != _mazeHeight - 1) // Checks if not on bottom edge
			if (recursiveSolve(y, x + 1)) { // Recalls method one down
				return true;
			}
		return false;
	}

	/**
	 * Solve maze.
	 * 
	 * @return true, if successful
	 */
	public boolean solveMaze() {
		init();
		for (int row = 0; row < _mazeHeight; row++)
			for (int col = 0; col < _mazeWidth; col++)
				_wasHere[row][col] = false;
		return recursiveSolve(_start.getY(), _start.getX());
	}

}

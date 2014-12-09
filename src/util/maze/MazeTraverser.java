package util.maze;

import model.door.Door;
import model.passage.A_Passage;
import model.player.Player;
import model.point.Point;
import model.region.RegionMaze;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc

public class MazeTraverser {

	private int[][] _mazeToCheck;

	private boolean[][] _wasHere;

	private RegionMaze _maze;

	private int _mazeHeight;

	private int _mazeWidth;

	private Player _player;

	private Point _start;

	private Point _end;

	public MazeTraverser(RegionMaze maze, Player player) {
		_maze = maze;
		_mazeHeight = _maze.getHeight();
		_mazeWidth = _maze.getWidth();
		_mazeToCheck = new int[_mazeHeight][_mazeWidth];
		_wasHere = new boolean[_mazeHeight][_mazeWidth];
		_player = player;
		_start = _player.getPosition();
		_end = maze.getRoomEnd().center();
		drawMaze();
		drawPassages();
	}

	private void drawMaze() {
		for (int y = 0; y < _mazeHeight; y++)
			for (int x = 0; x < _mazeWidth; x++)
				_mazeToCheck[y][x] = 2;
	}

	private void drawPassages() {
		for (A_Passage passage : _maze.getPassages()) {

			Point origin = passage.getOrigin();
			Point end = passage.getEnd();
			int lenthHorizontal = end.getX() - origin.getX();
			int lenthVertical = end.getY() - origin.getY();

			for (int y = 0; y < lenthVertical; y++)
				_mazeToCheck[y + origin.getY()][origin.getX()] = 1;

			for (int x = 0; x < lenthHorizontal; x++)
				_mazeToCheck[origin.getY()][origin.getX() + x] = 1;
		}
	}

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

	private void init() {
		drawRoomsAndDoors();
	}

	public void printMaze() {
		for (int y = 0; y < _mazeHeight; y++) {
			for (int x = 0; x < _mazeWidth; x++)
				System.out.print(_mazeToCheck[y][x]);
			System.out.println("");
		}
		System.out.println("\n");
	}

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

	public boolean solveMaze() {
		init();
		for (int row = 0; row < _mazeHeight; row++)
			for (int col = 0; col < _mazeWidth; col++)
				_wasHere[row][col] = false;
		return recursiveSolve(_start.getY(), _start.getX());
	}

}

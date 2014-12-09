/*
 * 
 */
package view.drawer;

import java.util.List;
import java.util.Random;

import model.door.Door;
import model.passage.A_Passage;
import model.player.Player;
import model.point.Point;
import model.region.RegionRoom;
import util.text.TextMaze;
import util.text.TextSpecial;

import com.googlecode.blacken.grid.BlackenGrid;
import com.googlecode.blacken.grid.BlackenPoint;

// TODO: Auto-generated Javadoc
/**
 * The Class Drawer.
 * 
 * @author jeremy
 */

public class Drawer {

	/** The _b grid. */
	private BlackenGrid<Integer> _bGrid;

	/** The _old block. */
	private Integer _oldBlock = TextMaze.FLOOR; // feels like code smell

	/**
	 * Instantiates a new drawer.
	 * 
	 * @param bGrid
	 *            the b grid
	 */
	public Drawer(BlackenGrid<Integer> bGrid) {
		_bGrid = bGrid;
	}

	/**
	 * Draw door.
	 * 
	 * @param door
	 *            the door
	 */
	public void drawDoor(Door door) {
		Point origin = door.getOrigin();
		_bGrid.set(origin.getY(), origin.getX(), door.getSymbol());
	}

	/**
	 * Draw door all.
	 * 
	 * @param doorList
	 *            the door list
	 */
	public void drawDoorAll(List<Door> doorList) {
		for (Door door : doorList)
			drawDoor(door);
	}

	/**
	 * Draw maze.
	 */
	public void drawMaze() {
		_bGrid.box(_bGrid.getHeight(), _bGrid.getWidth(), 0, 0,
				TextMaze.MAZE_WALL_LEFT, TextMaze.MAZE_WALL_RIGHT,
				TextMaze.MAZE_WALL_TOP, TextMaze.MAZE_WALL_BOTTOM,
				TextMaze.MAZE_WALL_TOP_LEFT, TextMaze.MAZE_WALL_TOP_RIGHT,
				TextMaze.MAZE_WALL_BOTTOM_LEFT,
				TextMaze.MAZE_WALL_BOTTOM_RIGHT, TextMaze.EMPTY_FLOOR);
		drawMazeRandoms();
	}

	/**
	 * Draw maze randoms.
	 */
	private void drawMazeRandoms() {
		drawMazeRandoms(TextSpecial.SPECIAL_GRAVE);
		drawMazeRandoms(TextSpecial.SPECIAL_FLOWER);
	}

	/**
	 * Draw maze randoms.
	 * 
	 * @param what
	 *            the what
	 */
	private void drawMazeRandoms(int what) {
		int randElements = 15;
		Random rand = new Random();
		int numberElements = 0;
		int[] placement = { -1, -1 };
		for (int t = 0; t < _bGrid.getHeight() * _bGrid.getWidth()
				&& numberElements < randElements; t++) {
			int x = rand.nextInt(_bGrid.getWidth());
			int y = rand.nextInt(_bGrid.getHeight());
			if (_bGrid.get(y, x) == TextMaze.EMPTY_FLOOR) {
				_bGrid.set(y, x, new Integer(what));
				placement[0] = y;
				placement[1] = x;
				numberElements++;
			}
		}
	}

	/**
	 * Draw passage.
	 * 
	 * @param passage
	 *            the passage
	 */
	public void drawPassage(A_Passage passage) {
		Point pointOrigin = passage.getOrigin();
		Point pointEnd = passage.getEnd();

		if (passageIsHorizontal(pointOrigin, pointEnd))
			drawPassageHorizontal(pointOrigin, pointEnd, _bGrid);
		else
			drawPassageVertical(pointOrigin, pointEnd, _bGrid);
	}

	/**
	 * Draw passage all.
	 * 
	 * @param passageList
	 *            the passage list
	 */
	public void drawPassageAll(List<A_Passage> passageList) {
		for (A_Passage passage : passageList)
			drawPassage(passage);
	}

	/**
	 * Draw passage horizontal.
	 * 
	 * @param pointOrigin
	 *            the point origin
	 * @param pointEnd
	 *            the point end
	 * @param bGrid
	 *            the b grid
	 */
	private void drawPassageHorizontal(Point pointOrigin, Point pointEnd,
			BlackenGrid<Integer> bGrid) {
		for (int yCoord = pointOrigin.getY(); yCoord <= pointEnd.getY(); yCoord++)
			bGrid.set(yCoord, pointOrigin.getX(), TextMaze.FLOOR_HALL);
	}

	/**
	 * Draw passage vertical.
	 * 
	 * @param pointOrigin
	 *            the point origin
	 * @param pointEnd
	 *            the point end
	 * @param bGrid
	 *            the b grid
	 */
	private void drawPassageVertical(Point pointOrigin, Point pointEnd,
			BlackenGrid<Integer> bGrid) {
		for (int xCoord = pointOrigin.getX(); xCoord <= pointEnd.getX(); xCoord++)
			bGrid.set(pointEnd.getY(), xCoord, TextMaze.FLOOR_HALL);
	}

	/**
	 * Draw player.
	 * 
	 * @param player
	 *            the player
	 */
	public void drawPlayer(Player player) {
		BlackenPoint playerPointCurr = new BlackenPoint(player
				.getPlayerPosition().getY(), player.getPlayerPosition().getX());
		BlackenPoint playerPointPrev = new BlackenPoint(player
				.getPlayerPositionPrev().getY(), player.getPlayerPositionPrev()
				.getX());

		_bGrid.set(playerPointPrev, _oldBlock);
		_oldBlock = _bGrid.get(playerPointCurr);
		_bGrid.set(playerPointCurr, player.getPlayerSymbol());
		player.setPlayerPositionPrev(player.getPlayerPosition());
	}

	/**
	 * Draw room.
	 * 
	 * @param room
	 *            the room
	 */
	public void drawRoom(RegionRoom room) {
		BlackenGrid<Integer> roomGrid = new BlackenGrid<Integer>(0,
				room.getHeight(), room.getWidth(), room.getOrigin().getY(),
				room.getOrigin().getX());
		roomGrid.box(room.getHeight(), room.getWidth(),
				room.getOrigin().getY(), room.getOrigin().getX(),
				TextMaze.ROOM_WALL_LEFT, TextMaze.ROOM_WALL_RIGHT,
				TextMaze.ROOM_WALL_TOP, TextMaze.ROOM_WALL_BOTTOM,
				TextMaze.ROOM_WALL_TOP_LEFT, TextMaze.ROOM_WALL_TOP_RIGHT,
				TextMaze.ROOM_WALL_BOTTOM_LEFT,
				TextMaze.ROOM_WALL_BOTTOM_RIGHT, TextMaze.FLOOR);
		_bGrid.addGrid(roomGrid);
	}

	/**
	 * Draw room all.
	 * 
	 * @param roomList
	 *            the room list
	 */
	public void drawRoomAll(List<RegionRoom> roomList) {
		for (RegionRoom room : roomList)
			drawRoom(room);
	}

	/**
	 * Passage is horizontal.
	 * 
	 * @param pointOrigin
	 *            the point origin
	 * @param pointEnd
	 *            the point end
	 * @return true, if successful
	 */
	private boolean passageIsHorizontal(Point pointOrigin, Point pointEnd) {
		return pointOrigin.getY() != pointEnd.getY();
	}
}

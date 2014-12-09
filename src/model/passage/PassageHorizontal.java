/*
 * 
 */
package model.passage;

import model.point.Point;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class PassageHorizontal.
 * 
 * @author jeremy
 */
public class PassageHorizontal extends A_Passage {

	/**
	 * Instantiates a new passage horizontal.
	 * 
	 * @param leftRoom
	 *            the left room
	 * @param rightRoom
	 *            the right room
	 */
	public PassageHorizontal(RegionRoom leftRoom, RegionRoom rightRoom) {
		super(leftRoom, rightRoom);
		_firstDoor.setOrigin(originRight(leftRoom));
		_secondDoor.setOrigin(originLeft(rightRoom));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.passage.A_Passage#isStateChanged(boolean)
	 */
	@Override
	public void isStateChanged(boolean state) {
		_firstDoor.isStateChanged(true);
		_secondDoor.isStateChanged(true);
	}

	/**
	 * Origin left.
	 * 
	 * @param room
	 *            the room
	 * @return the point
	 */
	private Point originLeft(RegionRoom room) {
		int xCoord = room.getOrigin().getX();
		int yCoord = room.getOrigin().getY() + room.getHeight() / 2;
		Point point = new Point(yCoord, xCoord);
		_passageEnd = point;
		return point;
	}

	/**
	 * Origin right.
	 * 
	 * @param room
	 *            the room
	 * @return the point
	 */
	private Point originRight(RegionRoom room) {
		int xCoord = room.getOrigin().getX() + room.getWidth() - 1;
		int yCoord = room.getOrigin().getY() + room.getHeight() / 2;
		Point point = new Point(yCoord, xCoord);
		_passageOrigin = point;
		return point;
	}

}

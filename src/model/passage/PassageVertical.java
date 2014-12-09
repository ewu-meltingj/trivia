/*
 * 
 */
package model.passage;

import model.point.Point;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class PassageVertical.
 * 
 * @author jeremy
 */
public class PassageVertical extends A_Passage {

	/**
	 * Instantiates a new passage vertical.
	 * 
	 * @param topRoom
	 *            the top room
	 * @param bottomRoom
	 *            the bottom room
	 */
	public PassageVertical(RegionRoom topRoom, RegionRoom bottomRoom) {
		super(topRoom, bottomRoom);
		_firstDoor.setOrigin(originBottom(topRoom));
		_secondDoor.setOrigin(originTop(bottomRoom));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.passage.A_Passage#contains(model.point.Point)
	 */
	@Override
	public boolean contains(Point point) {
		if (point.getY() > this._passageOrigin.getY()
				&& point.getY() < this._passageEnd.getY()
				&& point.getX() == this._passageOrigin.getX())
			return true;
		return false;
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
	 * Origin bottom.
	 * 
	 * @param room
	 *            the room
	 * @return the point
	 */
	private Point originBottom(RegionRoom room) {
		int xCoord = room.getOrigin().getX() + room.getWidth() / 2;
		int yCoord = room.getOrigin().getY() + room.getHeight() - 1;
		Point point = new Point(yCoord, xCoord);
		_passageOrigin = point;
		return point;
	}

	/**
	 * Origin top.
	 * 
	 * @param room
	 *            the room
	 * @return the point
	 */
	private Point originTop(RegionRoom room) {
		int xCoord = room.getOrigin().getX() + room.getWidth() / 2;
		int yCoord = room.getOrigin().getY();
		Point point = new Point(yCoord, xCoord);
		_passageEnd = point;
		return point;
	}
}

package model.passage;

import model.point.Point;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc

public class PassageHorizontal extends A_Passage {

	public PassageHorizontal(RegionRoom leftRoom, RegionRoom rightRoom) {
		super(leftRoom, rightRoom);
		_firstDoor.setOrigin(originRight(leftRoom));
		_secondDoor.setOrigin(originLeft(rightRoom));
	}

	@Override
	public void isStateChanged(boolean state) {
		_firstDoor.isStateChanged(true);
		_secondDoor.isStateChanged(true);
	}

	private Point originLeft(RegionRoom room) {
		int xCoord = room.getOrigin().getX();
		int yCoord = room.getOrigin().getY() + room.getHeight() / 2;
		Point point = new Point(yCoord, xCoord);
		_passageEnd = point;
		return point;
	}

	private Point originRight(RegionRoom room) {
		int xCoord = room.getOrigin().getX() + room.getWidth() - 1;
		int yCoord = room.getOrigin().getY() + room.getHeight() / 2;
		Point point = new Point(yCoord, xCoord);
		_passageOrigin = point;
		return point;
	}

}

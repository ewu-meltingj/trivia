package model.passage;

import util.maze.Interactive;
import model.door.Door;
import model.door.DoorStateBlocked;
import model.door.DoorStateCleared;
import model.door.DoorStateQuestion;
import model.player.Player;
import model.point.Point;
import model.region.RegionRoom;
import contracts.I_UserInteract;

// TODO: Auto-generated Javadoc

public abstract class A_Passage implements I_UserInteract {

	protected Door _firstDoor;

	protected Door _secondDoor;

	protected Point _passageEnd;

	protected Point _passageOrigin;

	public A_Passage(RegionRoom firstRoom, RegionRoom secondRoom) {
		_firstDoor = new Door(new DoorStateQuestion());
		_firstDoor.setPassage(this);

		_secondDoor = new Door(new DoorStateQuestion());
		_secondDoor.setPassage(this);
	}

	public void blockDoors() {
		_firstDoor.setDoorState(new DoorStateBlocked());
		_secondDoor.setDoorState(new DoorStateBlocked());
	}

	public void clearDoors() {
		_firstDoor.setDoorState(new DoorStateCleared());
		_secondDoor.setDoorState(new DoorStateCleared());
	}

	@Override
	public boolean contains(Point point) {
		int x = point.getX();
		int y = point.getY();

		if (x >= _passageOrigin.getX() && x <= _passageEnd.getX())
			if (y >= _passageOrigin.getY() && y <= _passageEnd.getY())
				return true;
		return false;
	}

	public Door getDoorFirst() {
		return _firstDoor;
	}

	public Door getDoorSecond() {
		return _secondDoor;
	}

	public Door getDoorSibling(Door door) {
		if (!_firstDoor.equals(door))
			return _firstDoor;
		return _secondDoor;
	}

	public Point getEnd() {
		return _passageEnd;
	}

	@Override
	public int getHeight() {
		return _passageEnd.getY() - _passageOrigin.getY();
	}

	@Override
	public Point getOrigin() {
		return _passageOrigin;
	}

	@Override
	public int getWidth() {
		return _passageEnd.getX() - _passageOrigin.getX();
	}

	@Override
	public void interact(Player player, Point direction) {
		player.move(direction);
	}

	@Override
	public void setBounds(Interactive active) {
		Point origin = _passageOrigin;
		Point end = _passageEnd;
		int lenthHorizontal = end.getX() - origin.getX() ;
		int lenthVertical = end.getY() - origin.getY();

		for (int y = 0 ; y < lenthVertical; y++)
			active.put(new Point(y + origin.getY() , origin.getX()), this);

		for (int x = 1; x < lenthHorizontal; x++)
		active.put(new Point(origin.getY() , origin.getX() + x), this);
	}

	public abstract void isStateChanged(boolean state);

}

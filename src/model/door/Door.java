package model.door;

import model.passage.A_Passage;
import model.player.Player;
import model.point.Point;
import contracts.I_GetObserved;
import contracts.I_HaveDoorStates;
import contracts.I_UserInteract;

// TODO: Auto-generated Javadoc

public class Door implements I_GetObserved, I_UserInteract {

	private I_HaveDoorStates _doorState;

	private A_Passage _passage;

	private Point _origin;

	// private transient RegionRoom _room;

	private boolean _isStateChanged;

	public Door(I_HaveDoorStates doorState) {
		if (doorState == null)
			throw new RuntimeException("Stuff passed in Doors is null");
		_doorState = doorState;
		_isStateChanged = false;
	}

	public void blockDoor() {
		_passage.blockDoors();
	}

	public void clearDoor() {
		_passage.clearDoors();
	}

	@Override
	public boolean contains(Point point) {
		return _origin.equals(point);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Door door = (Door) obj;
		if (!this._origin.equals(door.getOrigin()))
			return false;

		return true;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	//
	//
	// public RegionRoom getRoom() {
	// return _room;
	// }

	@Override
	public Point getOrigin() {
		return _origin;
	}

	//
	//
	// public I_HaveStates getState() {
	// return _doorState;
	// }

	public A_Passage getPassage() {
		return _passage;
	}

	public Door getSibling() {
		return _passage.getDoorSibling(this);
	}

	//
	//
	// public boolean interact() {
	// return _doorState.interact(this);
	// }

	public int getSymbol() {
		return _doorState.getSymbol();
	}

	public int getSymbolSimple() {
		return _doorState.getSymbolSimple();
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void interact(Player player, Point direction) {
		_doorState.interactedWell(player, direction);
	}

	@Override
	public boolean isStateChanged() {
		return _isStateChanged;
	}

	// public void setRoom(RegionRoom room) {
	// _room = room;
	// }

	@Override
	public void isStateChanged(boolean isChanged) {
		_isStateChanged = isChanged;
	}

	public void setDoorState(I_HaveDoorStates door) {
		if (door == null)
			throw new RuntimeException("Negative");
		_doorState = door;
	}

	public void setOrigin(Point origin) {
		_origin = origin;
	}

	public void setPassage(A_Passage passage) {
		_passage = passage;
	}
}

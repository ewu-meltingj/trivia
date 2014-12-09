package model.door;

import model.player.Player;
import model.point.Point;
import contracts.I_HaveDoorState;


public class DoorStateBlocked implements I_HaveDoorState {
	
//	private Door _door;

	public DoorStateBlocked() {
	}

	@Override
	public int getSymbol() {
		return "X".codePointAt(0);
	}

	@Override
	public int getSymbolSimple() {
		return 2;
	}

	@Override
	public void interact(Player player, Point direction) {
		player.move(Point.refuse(direction));
	}

	@Override
	public void setdoor(Door door) {
//		_door = door;
	}
}
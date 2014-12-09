package model.door;

import model.player.Player;
import model.point.Point;
import contracts.I_HaveDoorStates;

// TODO: Auto-generated Javadoc

public class DoorStateBlocked implements I_HaveDoorStates {

	public DoorStateBlocked() {
	}

	// @Override
	// public void accept(ObserveDoor viewObserveDoor) {
	// viewObserveDoor.handleState(this);
	// }

	@Override
	public int getSymbol() {
		return "X".codePointAt(0);
	}

	@Override
	public int getSymbolSimple() {
		return 2;
	}

	// @Override
	// public boolean interact(Door door) {
	// return false;
	// }

	@Override
	public void interactedWell(Player player, Point direction) {
	}
}
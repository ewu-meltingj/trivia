package model.door;

import model.player.Player;
import model.point.Point;
import contracts.I_HaveDoorStates;

public class DoorStateCleared implements I_HaveDoorStates {

	public DoorStateCleared() {
	}

	@Override
	public int getSymbol() {
		return "+".codePointAt(0);
	}

	@Override
	public int getSymbolSimple() {
		return 1;
	}

	@Override
	public void interactedWell(Player player, Point direction) {
		player.move(direction);
	}
}
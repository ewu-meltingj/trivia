package contracts;

import model.player.Player;
import model.point.Point;

public interface I_HaveDoorStates {

	public int getSymbol();

	public int getSymbolSimple();

	public void interactedWell(Player player, Point direction);
}

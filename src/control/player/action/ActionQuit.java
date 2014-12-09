package control.player.action;

import model.player.Player;
import util.maze.Interactive;

// TODO: Auto-generated Javadoc

public class ActionQuit implements I_ActionHandler {

	@Override
	public void handleAction(Player _player, Interactive _activeElements) {
		_player.hasQuit(true);
	}

}

/*
 * 
 */
package control.player.action;

import util.maze.Interactive;
import model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionQuit.
 * 
 * @author jeremy
 */
public class ActionQuit implements I_ActionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player _player, Interactive _activeElements) {
		_player.hasQuit(true);
	}

}

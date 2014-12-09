/*
 * 
 */
package control.player.action;

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
	public void handleAction(Player _player) {
		_player.hasQuit(true);
	}

}

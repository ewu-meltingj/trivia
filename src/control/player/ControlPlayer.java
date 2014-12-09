/*  
 *
 * <h4>Description</h4>
 *
 * <h4>Notes</h4>
 *
 * <h4>References</h4>
 *
 * @author      Team LazerSlugs
 *
 * @version     %I%, %G%       
 */
package control.player;

import model.player.Player;
import terminal.Terminal;
import control.player.action.I_ActionHandler;

// TODO: Auto-generated Javadoc
/**
 * Created by Jeremy on 11/7/14.
 */
public class ControlPlayer {

	/** The _terminal. */
	private Terminal _terminal;

	/** The _player. */
	private Player _player;

	/**
	 * Instantiates a new player controller.
	 * 
	 * @param terminal
	 *            the terminal
	 * @param player
	 *            the player
	 */
	public ControlPlayer(Terminal terminal, Player player) {
		_terminal = terminal;
		_player = player;
	}

	/**
	 * Check command given by the end user.
	 */
	public void checkCommand() {
		doAction(_terminal.getKey());
	}

	/**
	 * Acts on the command given by the end user.
	 * 
	 * @param actionHandler
	 *            the action handler
	 */
	public void doAction(I_ActionHandler actionHandler) {
		actionHandler.handleAction(_player);
	}

}

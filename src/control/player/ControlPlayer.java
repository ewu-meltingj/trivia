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

import java.util.Map;

import model.player.Player;
import model.point.Point;
import terminal.Terminal;
import contracts.I_Interactive;
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
	
	Map<Point, I_Interactive> _active;

	/**
	 * Instantiates a new player controller.
	 * 
	 * @param terminal
	 *            the terminal
	 * @param player
	 *            the player
	 */
	public ControlPlayer(Terminal terminal, Player player, Map<Point, I_Interactive> active) {
		_terminal = terminal;
		_player = player;
		_active = active;
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
		actionHandler.handleAction(_player, _active);
	}

}

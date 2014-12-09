/*
 * 
 */
package control.player.action;

import util.maze.Interactive;
import model.player.Player;

// TODO: Auto-generated Javadoc
//import com.googlecode.blacken.grid.Grid;

/**
 * The Interface I_ActionHandler.
 * 
 * @author jeremy
 */
public interface I_ActionHandler {

	/**
	 * Handle action.
	 * 
	 * @param _player
	 *            the _player
	 */
	public void handleAction(Player _player, Interactive _activeElements);

}

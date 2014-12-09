/*
 * 
 */
package control.player.action;

import java.util.Map;

import contracts.I_Interactive;
import model.player.Player;
import model.point.Point;

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
	public void handleAction(Player _player, Map<Point, I_Interactive> _active);

}

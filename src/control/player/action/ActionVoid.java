/*
 * 
 */
package control.player.action;

import java.util.Map;

import contracts.I_Interactive;
import model.player.Player;
import model.point.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionVoid.
 * 
 * @author jeremy
 */
public class ActionVoid implements I_ActionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player _player, Map<Point, I_Interactive> _active) {

	}

}

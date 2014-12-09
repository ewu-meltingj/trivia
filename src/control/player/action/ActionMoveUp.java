/*
 * 
 */
package control.player.action;

import java.util.Map;

import contracts.I_Interactive;
import model.player.Player;
import model.point.Point;
import util.text.TextSlug;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionMoveUp.
 * 
 * @author jeremy
 */

public class ActionMoveUp extends A_ActionMove implements I_ActionHandler {

	/** The Constant MOVE_UP. */
	private static final Point MOVE_UP = new Point(-1, 0);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player, Map<Point, I_Interactive> _active) {
		player.setPlayerSymbol(TextSlug.LOOKING_UP);
		handleMove(MOVE_UP, player, _active);
	};
}

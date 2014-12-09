/*
 * 
 */
package control.player.action;

import model.player.Player;
import model.point.Point;
import util.text.TextSlug;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionMoveLeft.
 * 
 * @author jeremy
 */
public class ActionMoveLeft extends A_ActionMove implements I_ActionHandler {

	/** The Constant MOVE_LEFT. */
	private static final Point MOVE_LEFT = new Point(0, -1);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player) {
		player.setPlayerSymbol(TextSlug.LOOKING_LEFT);
		handleMove(MOVE_LEFT, player);
	};
}

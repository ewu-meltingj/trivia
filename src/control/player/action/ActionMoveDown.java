/*
 * 
 */
package control.player.action;

import model.player.Player;
import model.point.Point;
import util.text.TextSlug;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionMoveDown.
 * 
 * @author jeremy
 */
public class ActionMoveDown extends A_ActionMove implements I_ActionHandler {

	/** The Constant MOVE_DOWN. */
	private static final Point MOVE_DOWN = new Point(+1, 0);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player) {
		player.setPlayerSymbol(TextSlug.LOOKING_DOWN);
		handleMove(MOVE_DOWN, player);
	}
}

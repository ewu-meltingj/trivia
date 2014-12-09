/*
 * 
 */
package control.player.action;

import model.player.Player;
import model.point.Point;
import util.text.TextSlug;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionMoveRight.
 * 
 * @author jeremy
 */
public class ActionMoveRight extends A_ActionMove implements I_ActionHandler {

	/** The Constant MOVE_RIGHT. */
	private static final Point MOVE_RIGHT = new Point(0, +1);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player) {
		player.setPlayerSymbol(TextSlug.LOOKING_RIGHT);
		handleMove(MOVE_RIGHT, player);
	};
}

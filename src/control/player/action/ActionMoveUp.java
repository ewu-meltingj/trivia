/*
 * 
 */
package control.player.action;

import model.player.Player;
import model.point.Point;
import util.maze.Interactive;
import util.text.TextSlug;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionMoveUp.
 * 
 * @author jeremy
 */

public class ActionMoveUp implements I_ActionHandler {

	/** The Constant MOVE_UP. */
	private static final Point MOVE_UP = new Point(-1, 0);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player, Interactive _activeElements) {
		player.setPlayerSymbol(TextSlug.LOOKING_UP);
		if(_activeElements.isInteractive(player, MOVE_UP))
			System.out.println("boom");
	};
}

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
 * The Class ActionMoveLeft.
 * 
 * @author jeremy
 */
public class ActionMoveLeft implements I_ActionHandler {

	/** The Constant MOVE_LEFT. */
	private static final Point MOVE_LEFT = new Point(0, -1);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player, Interactive _activeElements) {
		player.setPlayerSymbol(TextSlug.LOOKING_LEFT);
		if(_activeElements.isInteractive(player, MOVE_LEFT))
			System.out.println("boom");
	};
}

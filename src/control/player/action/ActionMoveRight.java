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
 * The Class ActionMoveRight.
 * 
 * @author jeremy
 */
public class ActionMoveRight implements I_ActionHandler {

	/** The Constant MOVE_RIGHT. */
	private static final Point MOVE_RIGHT = new Point(0, +1);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * control.player.action.I_ActionHandler#handleAction(model.player.Player)
	 */
	@Override
	public void handleAction(Player player, Interactive _activeElements) {
		player.setPlayerSymbol(TextSlug.LOOKING_RIGHT);
		if(_activeElements.isInteractive(player, MOVE_RIGHT))
			System.out.println("boom");
	};
}

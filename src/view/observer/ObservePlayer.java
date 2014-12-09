/*
 * 
 */
package view.observer;

import model.player.Player;
import view.drawer.Drawer;

// TODO: Auto-generated Javadoc
/**
 * The Class ObservePlayer.
 * 
 * @author jeremy
 */

public class ObservePlayer implements I_Observe {

	/** The _player. */
	private Player _player;

	/** The _drawer. */
	private Drawer _drawer;

	/**
	 * Instantiates a new observe player.
	 * 
	 * @param door
	 *            the door
	 * @param drawer
	 *            the drawer
	 */
	public ObservePlayer(Player door, Drawer drawer) {
		_player = door;
		_drawer = drawer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.observer.I_Observe#update()
	 */
	@Override
	public void update() {
		if (_player.isStateChanged()) {
			_drawer.drawPlayer(_player);
			_player.isStateChanged(false);
		}
	}
}

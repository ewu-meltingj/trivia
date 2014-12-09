/**
 *
 * <h4>Description</h4>
 *
 *
 * @author      Team LazerSlugs
 *
 * @version     %I%, %G%
 *
 * @see         
 */
package util.maze;

import java.util.HashMap;
import java.util.Map;

import model.player.Player;
import model.point.Point;
import contracts.I_Interactive;

/**
 * The Class Interactive.
 * 
 * @author jeremy
 */
public class Interactive {
	private Map<Point, I_Interactive> _interactiveGrid;

	public Interactive() {
		_interactiveGrid = new HashMap<Point, I_Interactive>();
	}

	public Interactive(Interactive interactive) {
		_interactiveGrid = interactive.getInteractiveGrid();
	}

	public void addToMap(I_Interactive active) {
		int originY = active.getOrigin().getY();
		int originX = active.getOrigin().getX();
		int endY = active.getHeight() + originY;
		int endX = active.getWidth() + originX;
		for (int y = originY; y <= endY; y++)
			for (int x = originX; x <= endX; x++)
				_interactiveGrid.put(new Point(y, x), active);
	}

	public void addToMapAll(I_Interactive[] active) {
		for (int i = 0; i < active.length; i++)
			addToMap(active[i]);
	}

	public Map<Point, I_Interactive> getInteractiveGrid() {
		return _interactiveGrid;
	}

	public boolean isInteractive(Player player, Point direction) {
		Point possibleMove = Point.translate(player.getPosition(), direction);
		return _interactiveGrid.containsKey(possibleMove);
	}
	
//	public I_Interactive getInteractiveItem(Player player, Point direction) {
//		Point possibleMove = Point.translate(player.getPosition(), direction);
//		return _interactiveGrid.get(possibleMove);
//	}
	
	public void interactWith(Player player, Point direction) {
		Point possibleMove = Point.translate(player.getPosition(), direction);
		_interactiveGrid.get(possibleMove).interact(player, direction);
	}
}

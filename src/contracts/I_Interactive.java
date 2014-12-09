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
package contracts;

import model.player.Player;
import model.point.Point;

/**
 * @author jeremy
 *
 */
public interface I_Interactive {
	public int getWidth();
	public int getHeight();
	public boolean contains(Point point);
	public Point getOrigin();
	public void interact(Player player, Point direction);
}

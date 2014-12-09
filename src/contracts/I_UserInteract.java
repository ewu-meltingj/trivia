package contracts;

import model.player.Player;
import model.point.Point;

public interface I_UserInteract {
	public boolean contains(Point point);

	public int getHeight();

	public Point getOrigin();

	public int getWidth();

	public void interact(Player player, Point direction);
}

/*
 * 
 */
package control.player.action;

import model.door.Door;
import model.passage.A_Passage;
import model.player.Player;
import model.point.Point;
import model.region.RegionRoom;

// TODO: Auto-generated Javadoc
/**
 * The Class A_ActionMove.
 * 
 * @author jeremy
 */
public abstract class A_ActionMove {

	/**
	 * Handle move.
	 * 
	 * @param direction
	 *            the direction
	 * @param player
	 *            the player
	 */
	protected void handleMove(Point direction, Player player) {
		Point possibleMove = Point.translate(player.getPlayerPosition(),
				direction);
		RegionRoom currentRoom = player.getRoomCurrent();

		if (isAPassableDoor(possibleMove, player, currentRoom))
			player.move(direction);
		else if (isInsideRoom(possibleMove, currentRoom))
			player.move(direction);
		else if (isAPassage(possibleMove, currentRoom))
			player.move(direction);
	}

	/**
	 * Checks if is a passable door.
	 * 
	 * @param possibleMove
	 *            the possible move
	 * @param player
	 *            the player
	 * @param currentRoom
	 *            the current room
	 * @return true, if is a passable door
	 */
	private boolean isAPassableDoor(Point possibleMove, Player player,
			RegionRoom currentRoom) {
		for (Door door : currentRoom.getDoors()) {
			if (door.getOrigin().equals(possibleMove)) {
				player.setRoom(door.getRoom());
				return door.interact();
			} else if (door.getSibling().getOrigin().equals(possibleMove)) {
				player.setRoom(door.getSibling().getRoom());
				return door.interact();
			}
		}
		return false;
	}

	/**
	 * Checks if is a passage.
	 * 
	 * @param possibleMove
	 *            the possible move
	 * @param currentRoom
	 *            the current room
	 * @return true, if is a passage
	 */
	private boolean isAPassage(Point possibleMove, RegionRoom currentRoom) {
		for (Door door : currentRoom.getDoors()) {
			A_Passage passage = door.getPassage();
			if (passage.contains(possibleMove))
				return true;
		}
		return false;
	}

	/**
	 * Checks if is inside room.
	 * 
	 * @param possibleMove
	 *            the possible move
	 * @param currentRoom
	 *            the current room
	 * @return true, if is inside room
	 */
	private boolean isInsideRoom(Point possibleMove, RegionRoom currentRoom) {
		return currentRoom.contains(possibleMove);
	}
}

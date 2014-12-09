package model.region;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.door.Door;
import model.player.Player;
import model.point.Point;
import contracts.I_UserInteract;

// TODO: Auto-generated Javadoc

// TODO using null values is a bad practice. Fix actions so that they are not
// needed.
public class RegionRoom extends A_Region implements Serializable,
		I_UserInteract {

	private static final long serialVersionUID = -6898900693260805420L;

	private int _id;

	private transient List<Door> _doorList;

	public RegionRoom(int id, Point origin, int width, int height) {
		super(height, width, origin, id);
		_id = id;
		_doorList = new ArrayList<Door>();
	}

	public void addDoor(Door door) {
		_doorList.add(door);
	}

	public List<Door> getDoors() {
		return _doorList;
	}

	@Override
	public void interact(Player player, Point direction) {
		if (this.contains(player.possible(direction)))
			player.move(direction);
	}

	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject();
		_doorList = new ArrayList<Door>();
	}

	@Override
	public String toString() {
		return "ID:" + _id + " Height:" + _height + " Width:" + _width;
	}
}

/*
 * 
 */
package model.region;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.door.Door;
import model.point.Point;

// TODO: Auto-generated Javadoc
/**
 * Created by Jeremy on 11/7/14.
 */

// TODO using null values is a bad practice. Fix actions so that they are not
// needed.
public class RegionRoom extends A_Region implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6898900693260805420L;

	/** The _id. */
	private int _id;

	/** The _door list. */
	private transient List<Door> _doorList;

	/*
	 * A room can hold four passages. The room will know which passages it
	 * holds. A room also has an id starting from 0. Thus if there are 4 rooms
	 * then the ids will be 0, 1 , 2, 3. The ids are used for connecting rooms
	 * to eachother, identifying room, and for the maze to calculate
	 * coordinates.
	 */
	/**
	 * Instantiates a new region room.
	 * 
	 * @param id
	 *            the id
	 * @param origin
	 *            the origin
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public RegionRoom(int id, Point origin, int width, int height) {
		super(height, width, origin, id);
		_id = id;
		_doorList = new ArrayList<Door>();
	}

	/**
	 * Adds the door.
	 * 
	 * @param door
	 *            the door
	 */
	public void addDoor(Door door) {
		_doorList.add(door);
	}

	/**
	 * Gets the doors.
	 * 
	 * @return the doors
	 */
	public List<Door> getDoors() {
		return _doorList;
	}

	/**
	 * Read object.
	 * 
	 * @param stream
	 *            the stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject();
		_doorList = new ArrayList<Door>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID:" + _id + " Height:" + _height + " Width:" + _width;
	}
}

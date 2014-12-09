/*
 * 
 */
package model.region;

import model.point.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class A_Region.
 */
public abstract class A_Region {

	/** The _width. */
	protected int _width;

	/** The _height. */
	protected int _height;

	/** The _origin. */
	protected Point _origin;

	/** The _id. */
	protected int _id;

	/**
	 * Instantiates a new a_ region.
	 * 
	 * @param id
	 *            the id
	 */
	public A_Region(int id) {
		_width = 0;
		_height = 0;
		_origin = new Point(0, 0);
		_id = id;
	}

	/**
	 * Instantiates a new a_ region.
	 * 
	 * @param height
	 *            the height
	 * @param width
	 *            the width
	 * @param origin
	 *            the origin
	 * @param id
	 *            the id
	 */
	public A_Region(int height, int width, Point origin, int id) {
		_width = width;
		_height = height;
		_origin = origin;
		_id = id;
	}

	/**
	 * Center.
	 * 
	 * @return the point
	 */
	public Point center() {
		int y = _origin.getY() + _height / 2;
		int x = _origin.getX() + _width / 2;
		return new Point(y, x);
	}

	/**
	 * Contains.
	 * 
	 * @param point
	 *            the point
	 * @return true, if successful
	 */
	public boolean contains(Point point) {
		int x = point.getX();
		int y = point.getY();

		if (x >= _origin.getX() + 1 && x < _origin.getX() + getWidth() - 1) {
			if (y >= _origin.getY() + 1 && y < _origin.getY() + getHeight() - 1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return _height;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return _id;
	}

	/**
	 * Gets the origin.
	 * 
	 * @return the origin
	 */
	public Point getOrigin() {
		return _origin;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return _width;
	}

	/**
	 * Sets the height.
	 * 
	 * @param height
	 *            the new height
	 */
	public void setHeight(int height) {
		_height = height;
	}

	/**
	 * Sets the width.
	 * 
	 * @param width
	 *            the new width
	 */
	public void setWidth(int width) {
		_width = width;
	}

}

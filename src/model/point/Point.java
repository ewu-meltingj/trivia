/*
 * 
 */
package model.point;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Point.
 */
public class Point implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5522070899577942L;

	/**
	 * Translate.
	 * 
	 * @param pointOne
	 *            the point one
	 * @param pointTwo
	 *            the point two
	 * @return the point
	 */
	public static Point translate(Point pointOne, Point pointTwo) {
		return new Point(pointOne.getY() + pointTwo.getY(), pointOne.getX()
				+ pointTwo.getX());
	}

	/** The _x coordinate. */
	private int _xCoordinate;

	/** The _y coordinate. */
	private int _yCoordinate;

	/**
	 * Instantiates a new point.
	 * 
	 * @param yCoordinate
	 *            the y coordinate
	 * @param xCoordinate
	 *            the x coordinate
	 */
	public Point(int yCoordinate, int xCoordinate) {
		_xCoordinate = xCoordinate;
		_yCoordinate = yCoordinate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object point) {
		if (this == point)
			return true;
		if (!(point instanceof Point))
			return false;
		Point pos = (Point) point;
		if (this.getY() != pos.getY())
			return false;
		if (this.getX() != pos.getX())
			return false;
		return true;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return _xCoordinate;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public int getY() {
		return _yCoordinate;
	}

	/**
	 * Sets the x.
	 * 
	 * @param xCoord
	 *            the new x
	 */
	public void setX(int xCoord) {
		_xCoordinate = xCoord;
	}

	/**
	 * Sets the y.
	 * 
	 * @param yCoord
	 *            the new y
	 */
	public void setY(int yCoord) {
		_xCoordinate = yCoord;
	}
}

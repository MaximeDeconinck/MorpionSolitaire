package application;

/**
 * The Point class represents a point in a two-dimensional coordinate system. It
 * provides a constructor for creating a point with specified x and y
 * coordinates, and methods for checking if two points are equal and for
 * generating a string representation of the point.
 */
public class Point {

	/**
	 * The x-coordinate of the point.
	 */
	int x;

	/**
	 * The y-coordinate of the point.
	 */
	int y;

	/**
	 * Constructs a Point object with the specified x and y coordinates.
	 *
	 * @param x the x-coordinate of the point
	 * @param y the y-coordinate of the point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns true if the point is equal to the specified point. Two points are
	 * equal if they have the same x and y coordinates. Returns false otherwise.
	 *
	 * @param point the point to be checked for equality
	 * @return true if the point is equal to the specified point, false otherwise
	 */
	public boolean equals(Point point) {
		return (this.x == point.x) && (this.y == point.y);
	}

	/**
	 * Returns a string representation of the point in the form (x,y).
	 *
	 * @return a string representation of the point
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

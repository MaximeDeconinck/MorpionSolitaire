package application;

import java.util.ArrayList;
import application.Point;

/**
The Line class represents a list of points and a direction.
It provides methods for retrieving the list of points, direction, first and second extremities,
and checking if it has a common point with another line and if it is parallel to another line.
*/
public class Line {
	
	/**
	* The list of points.
	*/
	public ArrayList<Point> points;

	/**
	* The direction of the line.
	*/
	public String dir;

	/**
	* Constructs a Line object with an empty list of points.
	*/
	public Line() {
		this.points = new ArrayList<>();
	}

	/**
	* Returns the list of points.
	*
	* @return the list of points
	*/
	public ArrayList<Point> getPoints() {
	    return points;
	}

	/**
	* Returns the direction of the line.
	*
	* @return the direction of the line
	*/
	public String getDirection() {
		return dir;
	}

	/**
	* Returns the first extremity of the line (the first point in the list).
	* If the list of points is empty, returns null.
	*
	* @return the first extremity of the line
	*/
	public Point firstExtremity() {
		if (!this.points.isEmpty()) {
			return this.points.get(0);
		}
		return null;
	}

	/**
	* Returns the second extremity of the line (the last point in the list).
	* If the list of points is empty, returns null.
	*
	* @return the second extremity of the line
	*/
	public Point secondExtremity() {
		if (!this.points.isEmpty()) {
			return this.points.get(this.points.size()-1);
		}
		return null;
	}

	/**
	* Returns true if the line has at least one point in common with the specified line.
	* Returns false otherwise.
	*
	* @param line the line to be checked for common points
	* @return true if the line has at least one point in common with the specified line, false otherwise
	*/
	public boolean hasCommonPoint(Line line) {
		for (Point point1 : this.points) {
			for (Point point2 : line.points) {
				if (point1.equals(point2)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	* Returns true if the line is parallel to the specified line.
	* Returns false otherwise.
	*
	* @param line the line to be checked for parallelism
	* @return true if the line is parallel to the specified line, false otherwise
	*/
	public boolean isParallelTo(Line line) {
		return this.dir.equals(line.dir);
	}
	
	@Override
	public String toString() {
		return points.toString() + dir;
	}
}

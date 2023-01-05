package application;

import java.util.ArrayList;

import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
import javafx.scene.shape.Line;

/**
 * A utility class for finding the intersection points of a list of horizontal
 * lines and a list of vertical lines.
 */
public class LineIntersectionFinder {

	/**
	 * Finds the intersection points of the given horizontal and vertical lines and
	 * returns them as a list of Point2D objects.
	 *
	 * @param horizontalLines the list of horizontal lines
	 * @param verticalLines   the list of vertical lines
	 * @return the list of intersection points, or an empty list if there are no
	 *         intersection points
	 */
	public List<Point2D> getIntersectionCoordinates(List<Line> horizontalLines, List<Line> verticalLines) {
		List<Point2D> intersectionCoordinates = new ArrayList<>();
		for (Line horizontalLine : horizontalLines) {
			for (Line verticalLine : verticalLines) {
				Point2D intersection = getIntersection(horizontalLine, verticalLine);

				if (intersection != null) {
					intersectionCoordinates.add(intersection);
				}
			}
		}
		return intersectionCoordinates;
	}

	/**
	 * Calculates the intersection point of the given lines, if it exists.
	 * 
	 * @param line1 the first line
	 * @param line2 the second line
	 * @return the intersection point, or null if the lines do not intersect
	 */
	private Point2D getIntersection(Line line1, Line line2) {
		double x1 = line1.getStartX();
		double y1 = line1.getStartY();
		double x2 = line1.getEndX();
		double y2 = line1.getEndY();
		double x3 = line2.getStartX();
		double y3 = line2.getStartY();
		double x4 = line2.getEndX();
		double y4 = line2.getEndY();

		double det = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

		if (det == 0) {
			return null;
		}

		double xIntersection = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / det;
		double yIntersection = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / det;

		return new Point2D(xIntersection, yIntersection);
	}

	/**
	 * 
	 * Creates checkboxes for each intersection point in the given list and returns
	 * them as a list of CheckBox objects. The checkboxes will be positioned at the
	 * coordinates of the intersection points.
	 * 
	 * @param intersectionCoordinates the list of intersection points
	 * @return the list of CheckBox objects
	 */
	public List<CheckBox> getIntersectionCheckBoxes(List<Point2D> intersectionCoordinates) {
		List<CheckBox> intersectionCheckBoxes = new ArrayList<>();
		for (Point2D intersectionCoordinate : intersectionCoordinates) {
			CheckBox checkBox = new CheckBox();
			checkBox.setLayoutX(intersectionCoordinate.getX());
			checkBox.setLayoutY(intersectionCoordinate.getY());

			intersectionCheckBoxes.add(checkBox);
		}
		return intersectionCheckBoxes;
	}

}
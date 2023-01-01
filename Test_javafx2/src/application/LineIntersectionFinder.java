package application;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class LineIntersectionFinder {
	
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
    
    private Point2D getIntersection(Line line1, Line line2) {
        double x1 = line1.getStartX();
        double y1 = line1.getStartY();
        double x2 = line1.getEndX();
        double y2 = line1.getEndY();
        double x3 = line2.getStartX();
        double y3 = line2.getStartY();
        double x4 = line2.getEndX();
        double y4 = line2.getEndY();
        double det1And2 = determinant(x1, y1, x2, y2);
        double det3And4 = determinant(x3, y3, x4, y4);
        double x1y2_y1x2 = determinant(x1, y1, x2, y2);
        double x3y4_y3x4 = determinant(x3, y3, x4, y4);
        double xIntersection = determinant(det1And2, x1y2_y1x2, det3And4, x3y4_y3x4) / determinant(x1 - x2, x3 - x4, y1 - y2, y3 - y4);
        double yIntersection = determinant(det1And2, x1y2_y1x2, det3And4, x3y4_y3x4) / determinant(x1 - x2, x3 - x4, y1 - y2, y3 - y4);
        if (isBetween(xIntersection, x1, x2) && isBetween(xIntersection, x3, x4)) {
            return new Point2D(xIntersection, yIntersection);
        }
		return null;

    }

    private double determinant(double a, double b, double c, double d) {
        return a * d - b * c;
    }
    
    private boolean isBetween(double x, double start, double end) {
        return (start < x && x < end) || (end < x && x < start);
    }
  
}

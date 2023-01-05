package application;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
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
		
		double det = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

		if (det == 0) {
		    return null;
		}

		double xIntersection = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / det;
		double yIntersection = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / det;

		

		return new Point2D(xIntersection, yIntersection);
}
	
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

package application;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class LineIntersectionDrawer {
    
    private static final double RADIUS = 5;
    private static final Paint FILL_COLOR = Color.RED;
    
    public List<Circle> drawIntersections(List<Line> horizontalLines, List<Line> verticalLines) {
        LineIntersectionFinder finder = new LineIntersectionFinder();
        List<Point2D> intersectionCoordinates = finder.getIntersectionCoordinates(horizontalLines, verticalLines);
        List<Circle> intersectionPoints = new ArrayList<>();
        for (Point2D point : intersectionCoordinates) {
            Circle circle = new Circle(point.getX(), point.getY(), RADIUS);
            circle.setFill(FILL_COLOR);
            intersectionPoints.add(circle);
        }
        return intersectionPoints;
    }
    
}
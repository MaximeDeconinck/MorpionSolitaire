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
    private static final Paint FILL_COLOR = Color.BLUE;
    int row = 0;
    int col = 0;
    
    public List<Circle> drawIntersections(List<Line> horizontalLines, List<Line> verticalLines) {
        LineIntersectionFinder finder = new LineIntersectionFinder();
        List<Point2D> intersectionCoordinates = finder.getIntersectionCoordinates(horizontalLines, verticalLines);
        List<Circle> intersectionPoints = new ArrayList<>();
        for (Point2D point : intersectionCoordinates) {
            Circle circle = new Circle(point.getX(), point.getY(), RADIUS);
            circle.setFill(FILL_COLOR);
            circle.setOpacity(0);
            circle.setUserData(new Point2D(row, col));
            intersectionPoints.add(circle);
            col++;
            if (col > 16) {
                row++;
                col = 1;
            }
            
        }
      
       
        
        
        
        for (Circle circle : intersectionPoints) {
            Point2D point = (Point2D) circle.getUserData();
            if (Point_depart().contains(point)) {
                circle.setOpacity(1);
            }
        }
        
        
        
        
        
    
        
        return intersectionPoints;
    }
    
     public List<Point2D> Point_depart() {
        List<Point2D> points = new ArrayList<>();
        
        points.add(new Point2D(3, 7));
        points.add(new Point2D(3, 8));
        points.add(new Point2D(3, 9));
        points.add(new Point2D(6, 3));
        points.add(new Point2D(6, 4));
        points.add(new Point2D(6, 5));
        points.add(new Point2D(6, 6));
        points.add(new Point2D(6, 9));
        points.add(new Point2D(6, 10));
        points.add(new Point2D(6, 11));
        points.add(new Point2D(6, 12));
        points.add(new Point2D(9, 3));
        points.add(new Point2D(9, 4));
        points.add(new Point2D(9, 5));
        points.add(new Point2D(9, 6));
        points.add(new Point2D(9, 9));
        points.add(new Point2D(9, 10));
        points.add(new Point2D(9, 11));
        points.add(new Point2D(9, 12));
        points.add(new Point2D(12, 6));
        points.add(new Point2D(12, 7));
        points.add(new Point2D(12, 8));
        points.add(new Point2D(12, 9));
        points.add(new Point2D(4, 6));
        points.add(new Point2D(4, 9));
        points.add(new Point2D(5, 6));
        points.add(new Point2D(3, 6));
        points.add(new Point2D(5, 9));
        points.add(new Point2D(7, 3));
        points.add(new Point2D(7, 12));
        points.add(new Point2D(8, 3));
        points.add(new Point2D(8, 12));
        points.add(new Point2D(10, 6));
        points.add(new Point2D(10, 9));
        points.add(new Point2D(11, 6));
        points.add(new Point2D(11, 9));
        
        return points;
        }
    
}
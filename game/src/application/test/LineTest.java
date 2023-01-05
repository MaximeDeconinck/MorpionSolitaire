package application.test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Line;
import application.Point;

public class LineTest {
    @Test
    public void testGetPoints() {
        Line line = new Line();
        line.points.add(new Point(1, 2));
        line.points.add(new Point(3, 4));
        
        assertArrayEquals(line.getPoints().toArray(), new Point[] {new Point(1, 2), new Point(3, 4)});
    }
    
    @Test
    public void testFirstAndSecondExtremities() {
        Line line = new Line();
        line.points.add(new Point(1, 2));
        line.points.add(new Point(3, 4));
        
        assertTrue(line.firstExtremity().equals(new Point(1, 2)));
        assertTrue(line.secondExtremity().equals(new Point(3, 4)));
        
        line = new Line();
        assertNull(line.firstExtremity());
        assertNull(line.secondExtremity());
    }
    
    @Test
    public void testHasCommonPoint() {
        Line line1 = new Line();
        line1.points.add(new Point(1, 2));
        line1.points.add(new Point(3, 4));
        
        Line line2 = new Line();
        line2.points.add(new Point(3, 4));
        line2.points.add(new Point(5, 6));
        
        assertTrue(line1.hasCommonPoint(line2));
        
        line2 = new Line();
        line2.points.add(new Point(5, 6));
        line2.points.add(new Point(7, 8));
        
        assertFalse(line1.hasCommonPoint(line2));
    }
    
    @Test
    public void testIsParallelTo() {
        Line line1 = new Line();
        line1.dir = "horizontal";
        
        Line line2 = new Line();
        line2.dir = "horizontal";
        
        assertTrue(line1.isParallelTo(line2));
        
        line2.dir = "vertical";
        
        assertFalse(line1.isParallelTo(line2));
    }
}

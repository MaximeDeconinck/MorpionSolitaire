package application.test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Point;

public class PointTest {

    @Test
    public void testConstructor() {
        Point p = new Point(3, 4);
        assertEquals(p.getX(), 3);
        assertEquals(p.getY(), 4);
    }

    @Test
    public void testEquals() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 4);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }

    @Test
    public void testToString() {
        Point p = new Point(5, 6);
        assertEquals(p.toString(), "(5,6)");
    }

}
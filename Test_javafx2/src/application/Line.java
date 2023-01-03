	package application;

import java.util.ArrayList;
import application.Point;

public class Line {
	
	ArrayList<Point> points;
	String dir;
	
	public Line() {
		this.points = new ArrayList<>();
	}
	
	public ArrayList<Point> getPoints() {
	    return points;
	}
	
	public String getDirection() {
		return dir;
	}
	
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
	
	public boolean isParallelTo(Line line) {
		return this.dir.equals(line.dir);
	}
	
	@Override
	public String toString() {
		return points.toString() + dir;
	}
}

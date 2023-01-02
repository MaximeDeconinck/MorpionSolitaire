package application;

import java.util.ArrayList;
import application.Point;

public class Line {
	
	ArrayList<Point> points;
	String dir;
	
	public Line() {
		this.points = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return points.toString() + dir;
	}
}

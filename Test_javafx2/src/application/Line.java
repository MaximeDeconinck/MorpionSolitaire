package application;

import java.util.ArrayList;

public class Line {
	
	ArrayList<Integer> points;
	String dir;
	
	public Line() {
		this.points = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return points.toString() + dir;
	}
}

package application;

public class Point {
	
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point point) {
		return (this.x == point.x) && (this.y == point.y);
	}

}

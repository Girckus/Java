public record Point(double x, double y) {
	// A custom constructor
	public Point() { this(0, 0); }
	
	// A method
	public double distanceFromOrigin() {
		return Math.hypot(x, y);
	}
	
	// A static field and method
	public static Point ORIGIN = new Point();
	
	public static double distance(Point p, Point q) {
		return Math.hypot(p.x - q.x, p.y - q.y);
	}
}

import java.awt.Rectangle;

public class Functions {
	public static int distance(int x1, int y1, int x2, int y2) {
		double sq1 = Math.pow((x1-x2),2);
		double sq2 = Math.pow((y1-y2),2);
		return (int)Math.sqrt(sq1+sq2);
	}
	
	public static Rectangle getIntersection(Rectangle a, Rectangle b) {
		return a.intersection(b);
	}
}

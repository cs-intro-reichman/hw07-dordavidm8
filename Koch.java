/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		snowFlake(Integer.parseInt(args[0]));

	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);	
		} else {
			double xA = (2 * x1 + x2) / 3;
			double yA = (2 * y1 + y2) / 3;
			double xB = (x1 + 2 * x2) / 3;
			double yB = (y1 + 2 * y2) / 3;
			double xC = (x1 + x2) / 2 - (Math.sqrt(3) * (y2 - y1)) / 6;
			double yC = (y1 + y2) / 2 + (Math.sqrt(3) * (x2 - x1)) / 6;
			
			StdDraw.line(xA, yA, xB, yB);
			
			curve(n - 1, x1, y1, xA, yA);
			curve(n - 1, xA, yA, xC, yC);
			curve(n - 1, xC, yC, xB, yB);
			curve(n - 1, xB, yB, x2, y2);
		}
	}
    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setXscale(-0.1, 1.1);
        StdDraw.setYscale(-0.1, 1.1);
		//// Write your code below.
	double sideLength = 0.6;
        double height = sideLength * Math.sqrt(3) / 2.0;

        double x1 = 0.5;
        double y1 = 0.2 + height;
        double x2 = 0.5 + sideLength / 2.0;
        double y2 = 0.2;
        double x3 = 0.5 - sideLength / 2.0;
        double y3 = 0.2;

		StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);	
	}
}

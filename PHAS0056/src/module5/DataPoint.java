package module5;

public class DataPoint {
	
	private double x; //
	private double y;
	private double ey;
	
	public DataPoint(double x, double y, double ey) {
		/*
		 * DataPoint Constructor 
		 */
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	// getter functions for x, y and ey
	double getX () {return x;}
	double getY () {return y;}
	double getEy () {return ey;}
}

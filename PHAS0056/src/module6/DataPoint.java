package module6;

public class DataPoint {
	
	protected double x; //
	protected double y;
	protected double ey;
	
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
	
	// to string method
	public String toString() {
		return "x = " + this.x+ ", y = " + this.y + " +- " + this.ey;
	}
}

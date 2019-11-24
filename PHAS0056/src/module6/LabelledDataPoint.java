package module6;

/*
 * Subclass extending DataPoint to include a String label in addition to the 3 double values
 */
public class LabelledDataPoint extends DataPoint {
	
	private String label;

	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}
	
	// to string method
	public String toString() {
		return this.label + ": x = " + this.x+ ", y = " + this.y + " +- " + this.ey;
	}

}

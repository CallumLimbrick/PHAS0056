package module6;
/*
 * Class that implements y = ax^2 + bx + c function given values of a, b and c
 */
public class QuadraticTheory implements Theory {
	
	private double a;
	private double b;
	private double c;
	
	// constructor
	public QuadraticTheory (double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// toString method
	public String toString() {
		return a + "x^2 + " + b + "x + " + c;
	}
	
	@Override
	// method carrying out and returning double value for ax^2 + bx + c function
	public double y(double x) {
		return a*Math.pow(x, 2) + b*x + c;
	}

}

package module6;

/*
 * Class that implements y = x^n function given value of n
 */
public class PowerLawTheory implements Theory {

	private double n;

	// Constructor 
	public PowerLawTheory (double n) {
		this.n = n;
	}

	// toString method
	public String toString() {
		return "y = x^" + n;
	}

	@Override
	// method carrying out x^n and returning double value for x^n function
	public double y(double x) {
		return Math.pow(x, n);
	}
}
package module3;

public class FallingParticle {
	
	// Initializing variables
	private double m;
	private double d;
	private static double h;
	private double t;
	private double z;
	private double v;
	private static final double g = -9.81;
	
	// Constructor for Falling Particle class
	public FallingParticle (double m, double d) throws Exception {
		this.m = m;
		this.d = d;
		if (m <= 0) {
		throw new Exception("Unphysical mass. Mass must satisfy, m > 0");
		}
		if (d < 0) {
		throw new Exception("Unphysical drag coefficient. Drag coefficient must satisfy, d >= 0");
		}
	}
	
	// Set and Get functions for h, v, z and t
	static void setH (double val) throws Exception{
		if (val <= 0) {
			throw new Exception("Height cannot be set to less than or equal to zero");
		}
		h = val;
		}
	void setV (double val) {v = val;}
	double getZ () {return z;}
	double getV () {return v;}
	double getT () {return t;}
	
	// Time step function that updates the position an velocity of a falling particle
	void doTimeStep(double deltaT) throws Exception {
		if (deltaT <= 0) {
			throw new Exception("Unphysical delta T. Delta T must satisfy, deltaT > 0");
		}
		double a = (d*v*v/m) + g;
		v = v + a*deltaT;
		z = z + v*deltaT;
		}
	
	//  drop function that loops doTimeStep for a given time interval until particle hits ground
	void drop(double deltaT) throws Exception {
		v = 0;
		t = 0;
		for (z = h; z > 0; t = t +deltaT) {
			doTimeStep(deltaT);
		}
	}

}

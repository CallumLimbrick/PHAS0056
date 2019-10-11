package module2;

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
	public FallingParticle (double m, double d) {
		this.m = m;
		this.d = d;
	}
	
	// Set and Get functions for h, v, z and t
	static void setH (double val) {h = val;}
	void setV (double val) {v = val;}
	double getZ () {return z;}
	double getV () {return v;}
	double getT () {return t;}
	
	// Time step function that updates the position an velocity of a falling particle
	void doTimeStep(double deltaT) {
		double a = (d*v*v/m) + g;
		v = v + a*deltaT;
		z = z + v*deltaT;
		}
	
	//  drop function that loops doTimeStep for a given time interval until partical hits ground
	void drop(double deltaT) {
		v = 0;
		t = 0;
		for (z = h; z > 0; t = t +deltaT) {
			doTimeStep(deltaT);
		}
	}

}

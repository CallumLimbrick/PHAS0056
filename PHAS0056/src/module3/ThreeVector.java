package module3;

import java.lang.Math;

public class ThreeVector {
	
	private double x;
	private double y;
	private double z;
	
	// ThreeVector constructor with 3 double values
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// Getting and Setting methods
	double getX () {return x;}
	double getY () {return y;}
	double getZ () {return z;}
	void setX (double val) {x = val;}
	void setY (double val) {y = val;}
	void setz (double val) {z = val;}
	
	// Magnitude method for "this" ThreeVector, returns type double
	public double magnitude() {
		x = this.getX();
		y = this.getY();
		z = this.getZ();
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	// unitVector method for "this" ThreeVector, returns type ThreeVector
	public ThreeVector unitVector() throws Exception {
		double mag = magnitude();
		double unitX = this.getX()/mag;
		double unitY = this.getY()/mag;
		double unitZ = this.getZ()/mag;
		if (unitX == 0 && unitY == 0 && unitZ == 0) {
			throw new Exception("Unit vector for a zero vector does not exits");
		}
		ThreeVector unit = new ThreeVector(unitX, unitY, unitZ);
		return unit;
	}
	
	// toString method for "this" ThreeVector, returns components in a string
	public String toString() {
		return "x = "+x+", y = "+y+", z = "+z;
	}
	
	// Static scalarProduct method for two ThreeVectors, returns type double
	public static double scalarProduct(ThreeVector a, ThreeVector b) {
		double prod = a.getX()*b.getX() + a.getY()*b.getY() + a.getZ()*b.getZ();
		return prod;
	}
	
	// Static vectorProduct method for two ThreeVectors, returns type ThreeVector
	public static ThreeVector vectorProduct(ThreeVector a, ThreeVector b) {
		double x = a.getY()*b.getZ() - a.getZ()*b.getY();
		double y = a.getZ()*b.getX() - a.getX()*b.getZ();
		double z = a.getX()*b.getY() - a.getY()*b.getX();
		ThreeVector prod = new ThreeVector(x, y , z);
		return prod;
	}
	
	// Static add method for two ThreeVectors, returns type ThreeVector
	public static ThreeVector add(ThreeVector a, ThreeVector b) {
		ThreeVector added = new ThreeVector(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
		return added;
	}
	
	// Static angle method for two ThreeVectors, returns type double
	public static double angle(ThreeVector a, ThreeVector b) throws Exception {
		double num = scalarProduct(a, b);
		double den = a.magnitude()*b.magnitude();
		if (den == 0) {
			throw new Exception("One or both of vectors are zero vectors, cannot divide by zero");
		}
		double cosine = num/den;
		double angle = Math.acos(cosine);
		return angle;
	}
	
	// scalarProduct method for a given and "this" ThreeVector, returns type double 
	public double scalarProduct(ThreeVector a) {
		return scalarProduct(this, a);
	}
	
	// vectorProduct method for a given and "this" ThreeVector, returns type ThreeVector 
	public ThreeVector vectorProduct(ThreeVector a) {
		return vectorProduct(this, a);
	}
	
	// add method for a given and "this" ThreeVector, returns type double 
	public ThreeVector add(ThreeVector a) {
		return add(this, a);
	}
	
	// angle for a given and "this" ThreeVector, returns type double 
	public double angle(ThreeVector a) throws Exception {
		return angle(this, a);
	}
}

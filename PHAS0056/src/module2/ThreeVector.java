package module2;

public class ThreeVector {
	
	private double x;
	private double y;
	private double z;
	
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	double getX () {return x;}
	double getY () {return y;}
	double getZ () {return z;}
	
	void setX (double val) {x = val;}
	void setY (double val) {y = val;}
	void setz (double val) {z = val;}
					
	public double magnitude() {
		x = this.getX();
		y = this.getY();
		z = this.getZ();
		return Math.sqrt(x*x + y*y + z*z);
	}

	public ThreeVector unitVector() {
		double mag = magnitude();
		double unitX = this.getX()/mag;
		double unitY = this.getY()/mag;
		double unitZ = this.getZ()/mag;
		ThreeVector unit = new ThreeVector(unitX, unitY, unitZ);
		return unit;
	}
	
	

	public static void main(String[] args) {
		
		ThreeVector test = new ThreeVector(2.0, 2.0, 2.0);
		
		double mag;
		mag = test.magnitude();
		System.out.println(mag);
		
		ThreeVector unitVec = test.unitVector();
		System.out.println(unitVec.getX());
	}

}

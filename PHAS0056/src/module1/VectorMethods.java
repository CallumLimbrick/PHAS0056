package module1;

import java.lang.Math;

public class VectorMethods {
	
	public double magnitude(double[] a) {
		double mag;
		mag = Math.sqrt(a[0]*a[0] + a[1]*a[1] + a[2]*a[2]);
		return mag;
	};
	
	public double dotProduct(double[] a, double[] b){
		double prod;
		prod = a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
		return prod;	
	};	
	
	public double angle(double[] a, double[] b){
		double cosine; 
		double ang;
		cosine = dotProduct(a, b)/(magnitude(a)*magnitude(b));
		ang = Math.toDegrees(Math.acos(cosine));
		return ang;
	};

	public static void main(String[] args) {
		
		// Initialising vm object
		VectorMethods vm = new VectorMethods();
			
			// Calling magnitude method
			double[] a = {4, 3, 2};
			double mags = vm.magnitude(a);
			System.out.println("The magnitude of vector a is:");
			System.out.println(mags);
		
			// Calling dotProduct method
			double[] b = {1, 5, 4};
			double dots = vm.dotProduct(a, b);
			System.out.println("The dot product of vectors a and b is:");
			System.out.println(dots);
			
			// Calling angle method
			double angs = vm.angle(a, b);
			System.out.println("The angle between vectors a and b in degrees is:");
			System.out.println(angs);
			
			System.out.println("When using vectors (4,3,2) and (1,5,4) the output of the angle method is 39.31791362002883");
			System.out.println("When using vectors (4,3,2) and (0,0,0) the output of the angle method is NaN as there can be no angle from (0,0,0)");
		}}
		
package module1;

public class VectorMethods {

	public static void main(String[] args) {
		
		// Initialising vm object
		VectorMethods vm = new VectorMethods();
		

		
		// Initialising x, y, z values
		double x = 1;
		double y = 2;
		double z = -3;
		
		
		
		double mag = vm.magnitude(x, y, z);
		
		System.out.println(mag);

	}

}

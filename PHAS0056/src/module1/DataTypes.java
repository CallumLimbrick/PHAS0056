package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		// Initialising variables of specific types
		double doubVar = 5.0;
		System.out.println("doubVar: " + doubVar);
		
		float floatVar = 5;
		System.out.println("floatVar: " + floatVar);
		
		int intVar = 5;
		System.out.println("intVar: " + intVar);
		
		long longVar = 5;
		System.out.println("longVar: " + longVar);
		
		byte byteVar = 5;
		System.out.println("byteVar: " + byteVar);
		
		// Outputting the square of the above values
		System.out.println("doubVar squared is " + doubVar*doubVar);
		System.out.println("floatVar squared is " + floatVar*floatVar);
		System.out.println("intVar squared is " + intVar*intVar);
		System.out.println("longVar squared is " + longVar*longVar);
		System.out.println("byteVar squared is " + byteVar*byteVar);
		
		// Investigating what happens when different types are mixed together
		char charVar = 'c' + 10;
		System.out.println("The value for c + 10 is " + charVar + ". This is because this is the tenth character after c.");
		
		System.out.println(byteVar + floatVar);
		System.out.println("byte type and float tpye added together returns a float type.");
		
		System.out.println("String" + floatVar + intVar);
		System.out.println("When adding together a string and floats and ints then it concatenates the three");
		
		// Investigating what happens when using a non-initialised value
		// int j=1;
		// int i;
		// j = i +1;
		System.out.println("You cannot use a value that has not been initialised in functions");
		
		// Investigating a double to int cast
		double test = 4.99;
		System.out.println((int) test + " Is the double, 4.99, cast to an int. This converts the float to an integer, rounding down.");

	}

}

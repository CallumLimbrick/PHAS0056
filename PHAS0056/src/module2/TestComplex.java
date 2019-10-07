package module2;

public class TestComplex {

	public static void main(String[] args) {
		
		// Initialising complex numbers
		Complex c1 = new Complex(1, -2);
		Complex c2 = new Complex(-2, 1);
		
		// Calculating test results
		Complex prod1 = Complex.multiply(c1, c2);
		System.out.println("The product of c1 and c2 is: "+prod1);
		
		Complex ratio1 = Complex.divide(c1, c2);
		System.out.println("The ratio of c1:c2 is: "+ratio1);
		
		Complex prod2 = Complex.multiply(c1, Complex.I);
		System.out.println("The product of c1 and I is: "+prod2);
		
		Complex ratio2 = Complex.divide(c1, Complex.ZERO);
		System.out.println("The ratio of c1:ZERO is "+ratio2);
		
		Complex prod3 = Complex.multiply(c1,  c2.conjugate());
		System.out.println("The product of c1 and the conjugate of c2 is: "+prod3);
		
		Complex prod4 = Complex.multiply(c2,  c2.conjugate());
		System.out.println("The product of c2 and it's conjugate is: "+prod4);
	}

}

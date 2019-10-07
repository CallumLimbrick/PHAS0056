package module2;

public class Complex {

	private double re;
	private double im;
	
	// Complex number constructor.
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	// Getting and Setting methods
		double getRe () {return re;}
		double getIm () {return im;}
		void setRe (double val) {re = val;}
		void setIm (double val) {im = val;}
		
	// Returning the real number for "this" Complex class.
	public double real() {
		return this.getRe();
	}
	
	// Returning the imaginary number for "this" Complex class.
	public double imag() {
		return this.getIm();
	}
	
	// Calculating and returning the modulus for "this" Complex class.
	public double modulus() {
		return Math.sqrt(imag()*imag() + real()*real());
	}
	
	// Calculating and returning the conjugate of "this" Complex class.
	public Complex conjugate() {
		double imC = -this.getIm(); 
		Complex conj =  new Complex(this.getRe(), imC);
		return conj;
	}
	
	// Calculating and returning the normalised Complex number of "this" Complex method.
	public Complex normalised() {
		double reN = this.getRe()/this.modulus();
		double imN = this.getIm()/this.modulus();
		Complex norm = new Complex(reN, imN);
		return norm;
	}
	
	// Checking if "this" Complex number is the same as the given number
	public boolean equal(Complex c) {
		return this == c;
	}
	
	// toString method to convert complex number to string
	public String toString() {
		return re+" + "+im+"i";
	}
	
	// initialising real number given modulus and argument as arguments
	public Complex setFromModulusAngle(double mag, double ang) {
		double real = mag*Math.cos(ang);
		double imaginary = mag*Math.sin(ang);
		Complex modAng = new Complex(real, imaginary);
		return modAng;
	}
	
	// Static method that adds two complex numbers
	public static Complex add(Complex a, Complex b) {
		double real = a.getRe() + b.getRe();
		double imaginary = a.getIm() + b.getIm();
		Complex addition = new Complex(real, imaginary);
		return addition;
	}
	
	// Static method that subtracts the second complex number from the first
	public static Complex subtract(Complex a, Complex b) {
		double real = a.getRe() - b.getRe();
		double imaginary = a.getIm() - b.getIm();
		Complex subtraction = new Complex(real, imaginary);
		return subtraction;
	}
	
	// Static method that multiplies two complex numbers
	public static Complex multiply(Complex a, Complex b) {
		double real = a.getRe()*b.getRe() - a.getIm()*b.getIm();
		double imaginary = a.getRe()*b.getIm() + a.getIm()*b.getRe();
		Complex multiplication = new Complex(real, imaginary);
		return multiplication;
	}
	
	// Static method that divides the first complex number by the second
	public static Complex divide(Complex a, Complex b) {
		Complex num = multiply(a, b.conjugate());
		double den = b.getRe()*b.getRe() - b.getIm()*b.getIm();
		double real = num.getRe()/den;
		double imaginary = num.getIm()/den;
		Complex division = new Complex(real, imaginary);
		return division;
	}
	
	// Initialising static variables
	static Complex ONE = new Complex(1, 0);
	static Complex ZERO = new Complex(0, 0);
	static Complex I =  new Complex(0, 1);
	
	
	public static void main(String[] args) {
		
	}

}

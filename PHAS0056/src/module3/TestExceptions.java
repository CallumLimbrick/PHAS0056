package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		try {
			Complex test = new Complex(0,0);
			System.out.println(test.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Complex test1 = new Complex(0,0);
			Complex test2 = new Complex(1,1);
			System.out.println(Complex.divide(test2,  test1));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			ThreeVector test = new ThreeVector(0,0,0);
			System.out.println(test.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			ThreeVector test1 = new ThreeVector(0,0,0);
			ThreeVector test2 = new ThreeVector(1,1,1);
			System.out.println(ThreeVector.angle(test1, test2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle test = new FallingParticle(0,1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle test = new FallingParticle(1,-1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle test = new FallingParticle(1,1);
			FallingParticle.setH(-1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			FallingParticle test = new FallingParticle(1,1);
			test.doTimeStep(0);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

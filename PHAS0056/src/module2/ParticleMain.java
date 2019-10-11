package module2;

public class ParticleMain {
	
	public static void main(String[] args) {
		
		FallingParticle.setH(5);
		FallingParticle test = new FallingParticle(4.3, 2.4);
		
		test.drop(0.5);
		System.out.println("The time taken for an interval of 0.5s is:");
		System.out.printf("%1.1f%n", test.getT());
		
		test.drop(0.1);
		System.out.println("The time taken for an interval of 0.1s is:");
		System.out.printf("%1.1f%n", test.getT());
		
		test.drop(0.01);
		System.out.println("The time taken for an interval of 0.01s is:");
		System.out.printf("%1.2f%n", test.getT());
		
		test.drop(0.001);
		System.out.println("The time taken for an interval of 0.001s is:");
		System.out.printf("%1.3f%n", test.getT());
		
		test.drop(0.0001);
		System.out.println("The time taken for an interval of 0.0001s is:");
		System.out.printf("%1.4f%n", test.getT());
		
		// Using the float formatting a java shows results for some with many significant figures despite only being accurate to a few
		
		System.out.println("The time taken for the paticle to drop changes as the time interval (deltaT) used to calculate it changes. This is because with a smaller time interval the output becomes more");
		System.out.println("accurate, as shown by the increased number of significant figures in the result. The script will however take longer with smaller intervals as it will require more loops to");
		System.out.println("complete.");
	}

}

package module1;

public class AlgorithmControl {

	public void loop() {
		System.out.println("Loop function");
		for (int i = 1; i < 9; i++) {
			System.out.println(i);
		}
	}	
	
	public void decrement() {
		System.out.println("Decrement function");
		int i = 10;
		while (i > -6) {
			System.out.println(i);
			i--;
		}
	}
	
	public void increment() {
		System.out.println("Increment function");
		for (double i = 2.5; i <= 4.3; i = i + 0.1) {
			System.out.printf("%1.1f%n", i);
		}
	}
	
	public static int timer(long maxTime, int loopSteps) {
		System.out.println("Timer");
		
		// Initialising the time and loop count variables
		long timeNow = System.currentTimeMillis();
		long startTime = timeNow;
		int i = 0;
		
		// Initialising while loop
		while (timeNow - startTime < maxTime) {
			timeNow = System.currentTimeMillis();
			i++;
			
			// If function to check if loop count multiple of 100
			if (i%loopSteps == 0) {
				System.out.println(i);
			}
		}
		
		return i;
	}
	
	
	
	public static void main(String[] args) {
		
		AlgorithmControl ac = new AlgorithmControl();
		
		int maxTime1 = 10000;
		int loopSteps1 = 1000;
		
		int totalLoops1 = timer(maxTime1, loopSteps1);
		System.out.println("The total number of loops is: " + totalLoops1);
		
		int maxTime2 = 10000;
		int loopSteps2 = 50000;
		
		int totalLoops2 = timer(maxTime2, loopSteps2);
		System.out.println("The total number of loops is: " + totalLoops2);
		
//		ac.timer();
//		ac.loop();
//		ac.decrement();
//		ac.increment();
	}

}

package module8;

/*
 * Class with main method to run both threads, CountdownTask and PrimeNumberTask, in parallel. 
 * The PrimeNumberTask will run until it is interrupted which will happen when the CoundownTask has returned.
 */
public class ThreadsMain {

	public static void main(String[] args) throws InterruptedException {
	
		Thread countdown = new Thread(new CountdownTask(10));
		Thread prime = new Thread(new PrimeNumberTask());
		countdown.start();
		prime.start();
		
		// Blocking the interrupt until countdown thread is complete
		countdown.join();
		prime.interrupt();
	}
}

package module8;



/*
 * 
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

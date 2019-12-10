package module8;



/*
 * 
 */
public class ThreadsMain {

	public static void main(String[] args) {
	
		Thread countdown = new Thread(new CountdownTask(10));
		Thread prime = new Thread(new PrimeNumberTask());
		countdown.start();
		prime.start();
		try {
			Thread.sleep(10000);
		}
		catch (InterruptedException e) {
			
		}
		prime.interrupt();
	}
}

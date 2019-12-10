package module8;

import java.util.ArrayList;

/*
 * Class used to calculate as many prime numbers as possible and place those numbers in a list while it's thread is running.
 */
public class PrimeNumberTask implements Runnable {

	ArrayList<Long> primes = new ArrayList<Long>();
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Method calculates whether or not concurrent integers are prime and if they are they are added to a list
	 */
	@Override
	public void run() {
		long j = 3;
		primes.add(2L);
		while(Thread.currentThread().isInterrupted() == false) { //prime checker will run till interrupted
			boolean flag = true;
			for(long k=2; k<j; k++) {
				if(j%k == 0L) {
					flag = false;
					break;
				}
			}
			if(flag) {
				primes.add(j);
			}
			j += 1;
		}
		
		// Printing statements
		System.out.println("The largest/last number to be checked for being prime was: " + j);
		System.out.println("The largest prime number found was: " + primes.get(primes.size() -1));
		System.out.println("There were " + primes.size() + " prime numbers found.");
		return;
	}
}

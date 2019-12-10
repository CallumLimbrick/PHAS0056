package module8;

import java.util.ArrayList;

/*
 * 
 */
public class PrimeNumberTask implements Runnable {

	ArrayList<Long> primes = new ArrayList<Long>();
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long j = 3;
		primes.add((long) 2);
		while(Thread.currentThread().isInterrupted() == false) {
			boolean flag = true;
			for(int k=2; k<j;k++) {
				if(j%k != 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				primes.add(j);
			}
			j += 1;
		}
		
		System.out.println("The largest/last number to be checked for being prime was: " + j);
		System.out.println("The largest prime number found was: " + primes.get(primes.size() -1));
		System.out.println("There were " + primes.size() + " prime numbers found.");
		return;
	}
}

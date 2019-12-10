package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Class has main method that calculates the time it takes to estimate a value for PI using
 * the MonteCarloPiCalculator class using both one thread, and multiple
 */
public class ThreadsTimer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*
		 * Try block calculating the value of pi using just a single thread
		 */
		try {
			long initialTime = System.currentTimeMillis();
			long nPoints = 10000000L;
			MonteCarloPiCalculatorTask task1 = new MonteCarloPiCalculatorTask(nPoints);
			double pi1 = task1.call();
			long totalTime = System.currentTimeMillis() - initialTime;
			System.out.println("The value of pi calculated when a single thread is used is " + pi1 + " and took " + totalTime + " milliseconds to calculate.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		/*
		 * Try block calculating the value of pi using four threads
		 */
		try {
			long initialTime = System.currentTimeMillis();
			long nPoints = 10000000L;
			int nThreads = 4;
			ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
			List<Future<Double>> futures = new ArrayList<Future<Double>>();
			for (int iThread = 0; iThread < nThreads; ++iThread) {
				MonteCarloPiCalculatorTask task2 = new MonteCarloPiCalculatorTask(nPoints/nThreads);
				Future<Double> future = threadPool.submit(task2);
				futures.add(future);
			}
			double sum = 0.0;
			for (int iThread = 0; iThread < nThreads; ++iThread) {
				double result = futures.get(iThread).get();
				sum += result;
			}
			threadPool.shutdown();
			double pi2 = sum/nThreads;
			long totalTime = System.currentTimeMillis() - initialTime;
			System.out.println("The value of pi calculated when four threads are used is " + pi2 + " and took " + totalTime + "milliseconds to calculate.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

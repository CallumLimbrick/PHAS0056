package module8;

/*
 * Class to count down from a given number, printing every second that passes.
 */
public class CountdownTask implements Runnable {

	private int number;

	/*
	 * Constructor for CountdownTask with an integer parameter for the value in seconds that the countdown starts at.
	 */
	public CountdownTask(int number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Method that runs for the specified number of seconds, printing every second and returning once the timer reaches zero.
	 */
	@Override
	public void run() {
		int i = number;
		while (i>0) { // run until reaching zero
			if (Thread.currentThread().isInterrupted()) return;
			System.out.print(i+ "\n");
			i -= 1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

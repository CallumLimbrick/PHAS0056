package module8;

/*
 * 
 */
public class CountdownTask implements Runnable {

	private int number;

	/*
	 * 
	 */
	public CountdownTask(int number) {
		this.number = number;
	}
	
	/*
	 * Getter function for number of seconds on countdown.
	 */
	public int getNumber() {return number;}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i = number;
		while (i>=0) { // run until interrupted
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

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
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i = number;
		while (true) { // run until interrupted
			if (Thread.currentThread().isInterrupted()) return;
			System.out.print(i);
			i -= 1;
		}
	}
}

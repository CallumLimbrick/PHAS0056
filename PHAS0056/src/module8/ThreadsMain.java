package module8;



/*
 * 
 */
public class ThreadsMain {

	public static void main(String[] args) {
	
		Thread countdown = new Thread(new CountdownTask(10));
		countdown.start();
	}
}


public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Started ...");
		NumbersTask task = new NumbersTask();
		
		Thread numbersThread1 = new Thread(task);
		numbersThread1.start();
		Thread numbersThread2 = new Thread(task);
		numbersThread2.start();
		
		numbersThread1.join();
		numbersThread2.join();
		
		System.out.println("Finished ...");
	}

}

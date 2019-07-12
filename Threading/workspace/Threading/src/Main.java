
public class Main {

	public static void main(String[] args) {
		System.out.println("Started ...");
		NumbersTask task = new NumbersTask();
		
		/*Thread numbersThread = new Thread(task);
		numbersThread.start();
		Thread numbersThread2 = new Thread(task);
		numbersThread2.start();*/
		
		for(int i=0;i<5;++i) {
			Thread numbersThread = new Thread(task);
			numbersThread.start();
		}
		System.out.println("Finished ...");
	}

}

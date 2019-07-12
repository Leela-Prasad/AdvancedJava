import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Started ...");
		NumbersTask task = new NumbersTask();
		
		ExecutorService pool = null;
		try {
			pool = Executors.newFixedThreadPool(2);
			Future<Double> result = pool.submit(task);
			
			while(!result.isDone()) {
				System.out.println("sleeping");
				Thread.sleep(500);
			}
			
			System.out.println("Result ::: " + result.get());
			
			System.out.println("Finished ...");
		}
		finally {
			pool.shutdown();
			
			while(!pool.isTerminated()) {
				Thread.sleep(500);
			}
		}
	}

}

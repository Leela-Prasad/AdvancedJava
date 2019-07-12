import java.util.concurrent.Callable;

public class NumbersTask implements Callable<Double> {

	private Double longRunningMethod() throws InterruptedException {
		Double d = 1.01;
		for(long i=1; i<1000000000l; ++i) {
			d+= 1.01;
			if(Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
		return d;
	}
	
	@Override
	public Double call() {
		Double result = 0d;
		try {
			result = longRunningMethod();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	   return result;
	}

}

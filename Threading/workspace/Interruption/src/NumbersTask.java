
public class NumbersTask implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=1000000000;++i) {
			System.out.println("Thread " + Thread.currentThread().getName() + " outputting number " + i);
			
			// If thread is interrupted then we need 
			// terminate this thread gracefully by 
			// releasing locks and resources.
			if(Thread.interrupted()) {
				break;
			}
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " completed");
	}

}

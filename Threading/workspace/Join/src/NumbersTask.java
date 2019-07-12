
public class NumbersTask implements Runnable {

	private void longRunningMethod() throws InterruptedException {
		System.out.println("Long Running Method starts ...");
		Double d = 1.01;
		for(long i=1; i<10000l; ++i) {
			d+= 1.01;
			
			// Here Interruption flag will be cleared when 
			// Thread.interrupted() evaluates to true and it's 
			// our responsibility to let caller know about this 
			// interruption so we will throw InterruptedException.
			if(Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
		System.out.println("Long Running Method ends ...");
	}
	
	@Override
	public void run() {
		for(int i=1;i<=1000;++i) {
			System.out.println("Thread " + Thread.currentThread().getName() + " outputting number " + i);
			
			try {
				longRunningMethod();
			} catch (InterruptedException e) {
				// Here Interruption flag will be cleared when 
				// InterruptedException is handled and it's  
				// our responsibility to set this interruption flag so that rest of the code knowns about this  
				// interruption 
				Thread.currentThread().interrupt();
			}
			// If thread is interrupted then we need 
			// terminate this thread gracefully by 
			// releasing locks and resources.
			if(Thread.interrupted()) {
				System.out.println("EXECUTED!!!");
				break;
			}
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " completed");
	}

}
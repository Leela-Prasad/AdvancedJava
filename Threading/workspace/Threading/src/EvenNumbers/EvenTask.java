package EvenNumbers;

public class EvenTask implements Runnable {

	private EvenNumberHolder holder;
	
	public EvenTask(EvenNumberHolder holder) {
		this.holder = holder;
	}
	
	@Override
	public void run() {
		while(true) {
		int value = holder.getNextEven();
		System.out.println("Thread : " + Thread.currentThread().getName() + " got number " + value);
		
		if(value%2!=0) {
			System.out.println("Odd Number Detected Thread : " + Thread.currentThread().getName() + " got number " + value);
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

}

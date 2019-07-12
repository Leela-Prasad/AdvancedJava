package EvenNumbers;

public class Generator {

	public static void main(String[] args) {
		
		EvenNumberHolder holder = new EvenNumberHolder();
		EvenTask task = new EvenTask(holder);
		for(int i=0;i<5; ++i) {
			Thread t = new Thread(task);
			t.start();
		}
	}

}

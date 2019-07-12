import java.util.ArrayList;
import java.util.List;


public class CustomersList {

	private List<Customer> customers = new ArrayList<Customer>();

	public void addToList(Customer customer) {
		synchronized (this) {
			while(customers.size() > 100) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			customers.add(customer);
			//notifyAll will wakeup all threads which are in waiting state and ask to retry
			//notifyAll is not a harmful method and releases ITS LOCK ONLY WHEN SYNCHRONIZED BLOCK IS COMPLETED. 
			notifyAll();
		}
	}

	public Customer getFromList() {
		synchronized (this) {
			while (customers.size() ==0) {
				try {
					// Wait will make this thread in waiting state until someone notifies 
					// and releases LOCK IMMEDIATELY.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Customer customer =  customers.remove(0);
			notifyAll();
			return customer;
		}
	}
}


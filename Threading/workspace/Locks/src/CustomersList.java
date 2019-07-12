import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CustomersList {

	private List<Customer> customers = new ArrayList<Customer>();
	private Lock customersLock = new ReentrantLock();
	private Condition customersAvailable = customersLock.newCondition();
	private Condition listHasSpace = customersLock.newCondition();
	
	public void addToList(Customer customer) {
		customersLock.lock();
			while(customers.size() > 100) {
				try {
					listHasSpace.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			customers.add(customer);
			customersAvailable.signalAll();
		customersLock.unlock();
	}

	public Customer getFromList() {
		customersLock.lock();
			while (customers.size() ==0) {
				try {
					customersAvailable.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Customer customer =  customers.remove(0);
			listHasSpace.signalAll();
		customersLock.unlock();
			return customer;
	}
}


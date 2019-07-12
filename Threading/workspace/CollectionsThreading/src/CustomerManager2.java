import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CustomerManager2 {

	// CopyOnWriteArrayList will create another arraylist by copying the contents
	// when the arraylist is modified. so that old thread will see only static data.
	// CopyOnWriteArrayList is ThreadSafe.
	private List<Customer> customers = new CopyOnWriteArrayList();
	private int nextId = 0;

	public  void addCustomer(Customer customer) {
		synchronized(this) {
			customer.setId(nextId);
			nextId++;
		}
		customers.add(customer);
	}

	public void howManyCustomers() {
		int size = 0;
		size = customers.size();
		System.out.println("" + new Date() + " : " + size + " customers created");
	}

	public void displayCustomers() {
		for (Customer c : customers) {
			System.out.println(c.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}

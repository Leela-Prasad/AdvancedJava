
public class StringWorker<T,U> {

	public T o1;
	public U o2;
	
	public StringWorker(T o1, U o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public String toString() {
		return "String Worker : " + o1.toString() + " : " + o2.toString();
	}
	
	// Here for this statiic methods Generics are required as this can 
	// be called without instantiation of object and it is an independent method.
	public static <A,B> String toString2(A o1, B o2) {
		return "String Worker : " + o1.toString() + " : " + o2.toString();
	}
	
	public static <A> String toString3(A o1, A o2) {
		return "String Worker : " + o1.toString() + " : " + o2.toString();
	}
}

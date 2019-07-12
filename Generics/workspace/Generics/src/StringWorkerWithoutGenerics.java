
public class StringWorkerWithoutGenerics {

	public String o1;
	public String o2;
	
	public StringWorkerWithoutGenerics(String o1, String o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public String toString() {
		return "String Worker : " + o1.toString() + " : " + o2.toString();
	}
}

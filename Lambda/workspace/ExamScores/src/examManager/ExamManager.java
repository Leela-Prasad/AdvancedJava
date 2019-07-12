package examManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import calculators.CalculationFunctionInterface;

public class ExamManager {

	private List<Double> myScores;

	public ExamManager() {
		myScores = new ArrayList<Double>();
		myScores.add(78.3);
		myScores.add(69.2);
		myScores.add(44.7);
		myScores.add(61.6);
		myScores.add(80.2);
		myScores.add(66.9);
		myScores.add(54.1);
	}

	public Double customCalculation(CalculationFunctionInterface calculator) {
		return calculator.execute(myScores);
	}
	
	public void printScores() {
		Comparator<Double> descendingComparator = (arg0,arg1) -> {
			int result=0;
			if(arg0 < arg1) return 1;
			if(arg0 > arg1) return -1;
			return result;
		};
		myScores.sort(descendingComparator);
		myScores.forEach(score -> System.out.println(score));
	}
	
	public void printSelectedScores(Predicate<Double> testCriteria) {
		myScores.forEach(score -> {
			if(testCriteria.test(score))
				System.out.println(score);
		});
	}
	
	public void printSelectedScoresV2(Predicate<Double> testCriteria) {
		myScores.stream().filter(testCriteria).forEach(s -> System.out.println(s));
	}
	
	public Double calculateTotal() {
		/*return myScores.stream().reduce(0d, (a,b) -> {
			System.out.println("a " + a + " b " + b);
			return a+b;
		});*/
		
		return myScores.stream().reduce(0d, (a,b) -> a+b);
	}
	
	public void doubleAllElements() {
		myScores.stream().map(d -> d*2).forEach(s -> System.out.println(s));
	}
	
	public List<Double> doubleAllElementsAndStoreInCollection() {
		return myScores.stream().map(d -> d*2).collect(Collectors.toList());
	}
}

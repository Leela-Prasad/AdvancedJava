package examManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExamManager2 {

	private List<Double> myScores;

	public ExamManager2() {
		myScores = new ArrayList<Double>();
		myScores.add(78.3);
		myScores.add(69.2);
		myScores.add(44.7);
		myScores.add(61.6);
		myScores.add(80.2);
		myScores.add(66.9);
		myScores.add(54.1);
	}

	public Double customCalculation(Function<List<Double>,Double> calculator) {
		return calculator.apply(myScores);
	}
}

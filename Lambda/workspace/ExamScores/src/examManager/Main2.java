package examManager;

import java.util.List;
import java.util.function.Function;

public class Main2 {

	public static void main(String[] args) {
		ExamManager2 examManager = new ExamManager2();
		
		Function<List<Double>,Double> average = myScores -> {
			Double sum = 0d;
			
			for (Double nextScore : myScores) {
				sum += nextScore;
			}
			return sum / myScores.size();
		};
		
		Function<List<Double>,Double> highestScore = myScores -> {
			Double highest = 0d;
			for (Double nextScore : myScores) {
				highest = Math.max(highest, nextScore);
			}
			return highest;
		};
		
		System.out.println ("The average score is " + examManager.customCalculation(average));
		System.out.println ("The highest score is " + examManager.customCalculation(highestScore));
		System.out.println("First Score is " + examManager.customCalculation(myScores -> myScores.get(0)));
	}

}

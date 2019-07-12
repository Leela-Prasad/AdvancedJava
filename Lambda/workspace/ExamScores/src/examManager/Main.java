package examManager;

import calculators.CalculationFunctionInterface;

public class Main {

	public static void main(String[] args) {
		ExamManager examManager = new ExamManager();
		
		CalculationFunctionInterface average = myScores -> {
			Double sum = 0d;
			
			for (Double nextScore : myScores) {
				sum += nextScore;
			}
			return sum / myScores.size();
		};
		
		CalculationFunctionInterface highestScore = myScores -> {
			Double highest = 0d;
			for (Double nextScore : myScores) {
				highest = Math.max(highest, nextScore);
			}
			return highest;
		};
		
		/*System.out.println ("The average score is " + examManager.customCalculation(new AverageCalculator()));
		System.out.println ("The highest score is " + examManager.customCalculation(new HighestScoreCalculator()));*/
		
		System.out.println ("The average score is " + examManager.customCalculation(average));
		System.out.println ("The highest score is " + examManager.customCalculation(highestScore));
		examManager.printScores();
		System.out.println("---");
		examManager.printSelectedScores(score -> score<=50);
		System.out.println("---");
		System.out.println(examManager.calculateTotal());
		System.out.println("---");
		examManager.printSelectedScoresV2(score -> score<=50);
		System.out.println("---");
		examManager.doubleAllElements();
		System.out.println("---");
		System.out.println(examManager.doubleAllElementsAndStoreInCollection());
	}

}

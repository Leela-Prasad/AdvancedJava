package calculators;

import java.util.List;

@FunctionalInterface
public interface CalculationFunctionInterface {

	public Double execute(List<Double> scores);
}

package examManager;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForEachPerformanceTest {

	public static void main(String[] args) {
		
		List<Double> sampleList = new ArrayList<>();
		Random random = new Random();
		for(int i=1; i<1000000; ++i) {
			sampleList.add(random.nextDouble());
		}
		
		Instant startLoop = Instant.now();
		for(Double d : sampleList) {
			System.out.println(d);
		}
		Instant stopLoop = Instant.now();
		
		
		Instant startLambda = Instant.now();
		sampleList.forEach(System.out::println);
		Instant stopLambda = Instant.now();
		
		Duration loopDuration = Duration.between(startLoop, stopLoop);
		Duration lambdaDuration = Duration.between(startLambda, stopLambda);
		
		System.out.println("for each loop took " + loopDuration.toMillis());
		System.out.println("lambda loop took " + lambdaDuration.toMillis());
	}

}
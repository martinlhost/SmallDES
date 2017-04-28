package Example;

import Simulation.Rand;

public class TestRand {

	public static void main(String[] args) {
		double sum = 0;
		int n = 100000;
		double lambda = 1.0;
		for (int i = 0; i < n; i++) {
			sum += Rand.exp(lambda);
		}
		System.out.println("Mean: " + (sum/n));
	}

}

package Simulation;

import java.util.concurrent.ThreadLocalRandom;

public class Rand {

	public static double rect(double least, double bound){
		return ThreadLocalRandom.current().nextDouble(least, bound);
	}
	
	public static double exp(double lambda){
		double u = ThreadLocalRandom.current().nextDouble();
	    return Math.log(1-u)/(-lambda);
	}
	
	public static double gauss(double mean, double stddev){
		double r = ThreadLocalRandom.current().nextGaussian();
		return r*stddev+mean;
	}
  
}

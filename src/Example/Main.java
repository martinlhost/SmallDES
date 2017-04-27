package Example;

import Simulation.Simulation;

public class Main {

	public static void main(String[] args) {
		Simulation s = new Simulation();
		MM1 mm1 = new MM1(s);
		Generator g = new Generator(s, mm1);
		Sampler sampler = new Sampler(s, mm1);
		s.simulate(50000000);
		sampler.done();
	}

}

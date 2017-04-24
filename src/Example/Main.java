package Example;

import Simulation.Event;
import Simulation.Simulation;

public class Main {

	public static void main(String[] args) {
		Simulation s = new Simulation();
		MM1 mm1 = new MM1(s);
		Generator g = new Generator(s, mm1);
		g.message(new Event());  // start event
		s.simulate(1000);
	}

}

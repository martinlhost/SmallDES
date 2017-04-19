package Example;

import Simulation.Event;
import Simulation.Simulation;

public class Main {

	public static void main(String[] args) {
		Simulation s = new Simulation();
		Generator A = new Generator(s, "A");
		Generator B = new Generator(s, "B");
		A.message(new Event());
		B.message(new Event());
		s.simulate(100);
	}

}

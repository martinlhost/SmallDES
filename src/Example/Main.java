package Example;

import Simulation.Event;
import Simulation.Simulation;

public class Main {

	public static void main(String[] args) {
		Simulation s = new Simulation();
		for (int i = 0; i < 100; i++) 
			new TestProcess(s, "TP"+i).message(new Event());
		s.simulate(10);
	}

}

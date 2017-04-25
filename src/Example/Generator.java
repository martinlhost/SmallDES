package Example;

import Simulation.Event;
import Simulation.Process;
import Simulation.Simulation;

public class Generator extends Process {
	
	private static double interArrivalTime = 15.0;
	
	private MM1 myMM1;

	public Generator(Simulation s, MM1 mm1) {
		super(s);
		myMM1 = mm1;
	}

	public void handleEvent(Event e) {
		myMM1.message(new Event("newJob"));
		this.setTimer(s.negExp(interArrivalTime), new Event());		
	}


}

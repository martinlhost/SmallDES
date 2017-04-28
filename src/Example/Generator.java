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
		this.setTimer(0.0, new Event());  // start the generator
	}

	public void handleEvent(Event e) {
		myMM1.newJob();
		this.setTimer(s.negExp(interArrivalTime), new Event());		
	}


}

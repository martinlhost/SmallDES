package hospital;

import Simulation.Event;
import Simulation.Process;
import Simulation.Rand;
import Simulation.Simulation;

public class Generator extends Process {
	
	private Hospital h;
	int n = 0;           // nr generated patients
	

	public Generator(Simulation s, Hospital h) {
		super(s);
		this.h = h;
		this.setTimer(Rand.exp(1/Hospital.INTER_ARRIVAL_TIME), new Event());  // start the generator
	}

	public void handleEvent(Event e) {
		n++;
		sendMessage(h, new HospitalEvent("newPatient", new Patient("P"+n)));
		this.setTimer(Rand.exp(1/Hospital.INTER_ARRIVAL_TIME), new Event());		
	}
}

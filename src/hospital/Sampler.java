package hospital;

import java.io.IOException;
import java.io.PrintWriter;

import Simulation.Event;
import Simulation.Process;
import Simulation.Rand;
import Simulation.Simulation;

public class Sampler extends Process {
	
	private PrintWriter file;
	private Hospital h;
	
	public Sampler(Simulation s, Hospital h) {
		super(s);
		this.h = h;
		try{
		    file = new PrintWriter("output.sim", "UTF-8");  // textfile
		    file.println("NrJobs");  // heading
		} catch (IOException e) {
		   System.out.println("Error opening file");
		}
		this.setTimer(0.0, new Event());  // start the sampler
	}

	@Override
	public void handleEvent(Event e) {
		file.println("" + h.nrJobs());
		this.setTimer(Rand.exp(1/Hospital.SAMPLE_INTERVAL), new Event());
	}
	
	public void done() {
		file.close();
	}

}

package Example;

import java.io.IOException;
import java.io.PrintWriter;

import Simulation.Event;
import Simulation.Process;
import Simulation.Simulation;

public class Sampler extends Process {

	private static double sampleInterval = 800.0;
	
	private PrintWriter file;
	private MM1 mm1;
	
	public Sampler(Simulation s, MM1 mm1) {
		super(s);
		this.mm1 = mm1;
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
		file.println("" + mm1.nrJobs());
		this.setTimer(s.negExp(sampleInterval), new Event());
	}
	
	public void done() {
		file.close();
	}

}

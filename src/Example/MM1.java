package Example;



import Simulation.*;
import Simulation.Process;


public class MM1 extends Process {

	private static double jobExecutionTime = 10.0;

	int n; // number jobs in queue + server
	
	public MM1(Simulation s) {
		super(s);
		n = 0;
	}

	public void handleEvent(Event e) {
		if (e.type().equals("newJob")){
			System.out.println("New job at " + s.getTime());
			n++;
			if (n==1) // the server was empty
				this.setTimer(s.negExp(jobExecutionTime), new Event("jobDone"));
			return;
		}
		if (e.type().equals("jobDone")) {
			System.out.println("Job done at " + s.getTime());
			n--;
			if (n>0) // the queue isn't empty
				this.setTimer(s.negExp(jobExecutionTime), new Event("jobDone"));
			return;
		}
		System.out.println("Error: unexpected event type");
	}

}

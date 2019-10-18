package Simulation;

public class ProgressBar extends Process {
	
	private static int nrMarks = 40;
	private double timeBetweenMarks;

	public ProgressBar(Simulation s, double simTime) {
		super(s);
		timeBetweenMarks = simTime/nrMarks;
		this.setTimer(timeBetweenMarks, new Event());
	}

	public void handleEvent(Event e) {
		System.out.print("x");
		this.setTimer(timeBetweenMarks, new Event()); 
	}

}

package Simulation;

import java.util.Comparator; 
import java.util.PriorityQueue;

public class Simulation {
	
	private PriorityQueue<Event> queue;      	// the event queue
	private double time; 						// the global time
	private boolean progressBar = false;        // whether we want to show progr bar

	
	public Simulation() {
		queue = new PriorityQueue<Event>(1000, new Comparator<Event>() {
			      public int compare(Event o1, Event o2) {
				     return (o1.getT() < o2.getT() ? -1 : (o1.getT() > o2.getT() ? 1 : 0));
			      }
		        });
		time = 0.0; 
	}
	
	public Simulation(boolean progressBar) {
		this();
		this.progressBar = progressBar;
	}	
	
	public void addEvent(Event e) {
		queue.add(e);
	}
	
	public double getTime() {
		return time;
	}
	
	public void simulate(double simulationTime) {
		long startTime = System.currentTimeMillis();
		if (progressBar)
			new ProgressBar(this, simulationTime);
		while (time < simulationTime) {
			Event e = queue.poll();
			time = e.getT();
			e.getProcess().handleEvent(e);
		}
		if(progressBar)
			System.out.println();
		long endTime = System.currentTimeMillis();
		long measuredTime = endTime - startTime;
		System.out.println("*** Simulation done in " + measuredTime/1e3 + " seconds (real time) ***"); 
	}
		
};

package Simulation;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Simulation {
	
	private PriorityQueue<Event> queue;      	// the event queue
	private double time; 						// the global time

	
	public Simulation() {
		queue = new PriorityQueue<Event>(1000, new Comparator<Event>() {
			      public int compare(Event o1, Event o2) {
				     return (o1.getT() < o2.getT() ? -1 : (o1.getT() > o2.getT() ? 1 : 0));
			      }
		        });
		time = 0.0; 
	}
	

	
	public void addEvent(Event e) {
		queue.add(e);
	}
	
	public double getTime() {
		return time;
	}
	
	public void simulate(double simulationTime) {
		while (time < simulationTime) {
			Event e = queue.poll();
			time = e.getT();
			e.getProcess().handleEvent(e);
		}
	}
	
	
};

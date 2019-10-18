package Simulation;

/**
 * Event in simulation model
 * @author martinh
 *
 */
public class Event {
	
	private double t;
	private Process p;
	private String eventType;
	
	
	public Event(String eventType) {
		t = 0.0;
		this.eventType = eventType;
	}

	public Event() {
		this(null);
	}

	
	public void setTime(double t) {
		this.t = t;
	}

	public double getT() {
		return t;
	}
	
	public void setProcess(Process p) {
		this.p = p;
	}
	
	public Process getProcess() {
		return p;
	}
	
	public String type() {
		return eventType;
	}
	
	public String toString() {
		return "E:" + t + "  ";
	}

}

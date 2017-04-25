package Simulation;

public class Event {
	
	private double t;
	private Process p;
	private String eventType = null;
	
	public Event() {
		t = 0.0;
	}
	
	public Event(String eventType) {
		t = 0.0;
		this.eventType = eventType;
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

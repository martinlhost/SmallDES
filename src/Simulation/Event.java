package Simulation;

public class Event {
	
	private double t;
	private Process p;
	
	public Event() {
		t = 0.0;
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
	
	public String toString() {
		return "E:" + t + "  ";
	}

}

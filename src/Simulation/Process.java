package Simulation;


public abstract class Process {
	
	protected Simulation s;	
	
	public Process (Simulation s) {
		this.s = s;
	}
		
	public abstract void handleEvent(Event e);
		
	protected void setTimer(double duration, Event e) {
		e.setProcess(this);
		e.setTime(duration + s.getTime());
		s.addEvent(e);
	}
	
	protected void sendMessage(Process p, Event e) {
		e.setProcess(p);
		e.setTime(s.getTime());
		s.addEvent(e);
	}
	

}

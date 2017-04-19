package Simulation;

public abstract class Process {
	
	protected Simulation s;
	
	public Process (Simulation s) {
		this.s = s;
	}
	
	public abstract void handleEvent(Event e);
	
	public void message(Event e)  {
		e.setProcess(this);
		e.setTime(s.getTime());
		s.addEvent(e);
	}
	
	public Event setTimer(double duration) {
		Event e = new Event();
		e.setProcess(this);
		e.setTime(duration + s.getTime());
		s.addEvent(e);
		return e;  // return e so that deleteTimer can be implemented
	}

}

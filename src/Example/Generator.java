package Example;

import Simulation.*;
import Simulation.Process;

public class Generator extends Process {

	String name;
	
	public Generator(Simulation s, String name) {
		super(s);
		this.name = name;
	}

	public void handleEvent(Event e) {
		System.out.println(name + " " + s.getTime());
		Event dummy = setTimer((name.equals("A") ? 10.0: 15.0));
	}

}

package Example;

import java.util.Random;

import Simulation.*;
import Simulation.Process;

public class TestProcess extends Process {

	String name;
	Random r = new Random();
	
	public TestProcess(Simulation s, String name) {
		super(s);
		this.name = name;
	}

	public void handleEvent(Event e) {
		System.out.println(name + " " + s.getTime());
		setTimer(r.nextDouble(), new Event());
	}

}

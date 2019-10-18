package hospital;

import Simulation.*;
import Simulation.Process;

public class Doctor extends Process{
	
	private String name;
	private Patient currentPatient;
	private Hospital h;
	
	public Doctor(Simulation s, Hospital h, String name) {
		super(s);
		this.name = name; 
		this.h = h;
	}
	
	public void handleEvent(Event e) {
		switch (e.type()) {
		case "newPatient": // from hospital
			currentPatient = ((HospitalEvent) e).getPatient();
			h.log("Patient " + currentPatient + " started treatment by " + this);
			this.setTimer(Rand.exp(1/Hospital.TRETMENT_TIME), new Event("patientTreated"));
			break;
		case "patientTreated" :  // my timer, i.e. patient treated
			sendMessage(h, new HospitalEvent("patientTreated", currentPatient, this));
			break;
		}
	}
	
	public String toString() {
		return name;
	}
	

}

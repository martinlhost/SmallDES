package hospital;

import java.util.LinkedList;
import java.util.List;

import Simulation.*;
import Simulation.Process;

/**
 * This class simulates a hospital. It has a pool of doctors, and a waiting room with patients. 
 * @author martinh
 *
 */
public class Hospital extends Process {

	/**
	 * The main function of the program
	 * @param args args
	 */
	public static void main(String[] args) {
		Simulation s = new Simulation(!loggingOn);
		Hospital h = new Hospital(s);
		Generator g = new Generator(s, h);
		Sampler sampler = new Sampler(s, h);
		s.simulate(1e6);
		sampler.done();
	}
	
	public static double interArrivalTime = 15.0;
	public static double treatmentTime = 13;
	public static int nrDoctors = 1;
	public static double sampleInterval = 60;
	
	private static boolean loggingOn = false;  // true -> print events on std out. 

	private Simulation s;

	private LinkedList<Doctor> doctorPool = new LinkedList<Doctor>();  
	private LinkedList<Patient> waitRoom = new LinkedList<Patient>();
	
	/**
	 * Constructs a new hospital
	 * @param s the active simulation
	 */
	public Hospital(Simulation s) {
		super(s);
		this.s = s;
		for (int i = 0; i<nrDoctors; i++)
			doctorPool.add(new Doctor(s, this, "DR"+(i+1)));
	}
		                                                 	
	
	public void handleEvent(Event e) {
		Patient p;
		Doctor d;
		switch (e.type()) {
		case "newPatient":  // from generator
			p = ((HospitalEvent) e).getPatient();
			if (!doctorPool.isEmpty()) {
				sendMessage(doctorPool.removeFirst(), e); // "newPatient" to a doctor
			} else {
				waitRoom.add(p);
				log("Patient " + p + " to waitroom");
			}
			break;
		case "patientTreated": // from a doctor
			p = ((HospitalEvent) e).getPatient();
			d = ((HospitalEvent) e).getDoctor();
			log("Patient " + p + " treated by " + d);
			if (!waitRoom.isEmpty()) {
				sendMessage(d, new HospitalEvent("newPatient", waitRoom.removeFirst())); // give the doctor a new patient
			} else 
				doctorPool.add(d);
			break;
		}
	}

	/**
	 * Returns the number of patients at the hospital, both the ones treated by doctors, 
	 * and the ones waiting in the waiting room. 
	 * @return the number of patients at the hospital
	 */
	public int nrJobs() {
		int nrDoctorsWorking = nrDoctors - doctorPool.size();
		return waitRoom.size() + nrDoctorsWorking;   // queue length + nr occupied servers
	}
	
	/**
	 * Prints a log-message on std out if loggingOn == true
	 * @param text the text to print
	 */
	public void log(String text) {
		if (loggingOn) 
			System.out.println(text + " at " + s.getTime());
	}
	
}

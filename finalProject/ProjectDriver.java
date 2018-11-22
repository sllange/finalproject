/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to test the final project for CIS152.
 * 
 * @author Samantha Lange
 *
 */
public class ProjectDriver {
	public static void main(String[] args) {
		// create multiple patients, doctors, and appointments on load of the application.
		int patQueueSize = 20;
		QueueFP patients = new QueueFP(patQueueSize);
		Doctor doc1 = new Doctor("Patrick", "Miller", 1977, "3334442334", "patM@meds.com", "Primary", "7-3");
		
		Doctor doc2 = new Doctor("Mary", "Johnson", 1980, "4562347878", "mj80@meds.com", "Primary", "8-4");
		
		Patient pat1 = new Patient("Bob", "Smith", 1956, "5554432234", "bsmith@aol.com", doc1);
		patients.enqueue(pat1);
		Patient pat2 = new Patient("Sara", "Lewis", 1991, "8764562323", "saral@hotmail.com", doc2);
		patients.enqueue(pat2);
		Appointment app1 = new Appointment("12-8", "7am", "flu", doc2, pat2);
		Appointment app2 = new Appointment("12-9", "11am", "physical", doc1, pat1);
		System.out.println(app1.toString());
		System.out.println(app2.toString());
		System.out.println(patients.size());
		System.out.println(patients.dequeue().getPrimaryDr().getLastName());
		// queue to hold appointment times by date? and must assign 
		// or queue to hold patients that have been added to system but not to an appointment yet. appt add screen auto removes first from queue
	}
}

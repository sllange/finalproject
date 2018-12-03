/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create and modify a Link.
 * 
 * @author Samantha Lange
 *
 */
public class Link {
	// fields
	public Appointment appData;
	public Doctor docData;
	public Patient patData;
	public Link next;

	/**
	 * Constructor that accepts a parameter
	 * with the appointment data.
	 * 
	 * @param app	the appointment data
	 */
	public Link(Appointment app) {
		super();
		this.appData = app;
	}
	
	/**
	 * Constructor that accepts a parameter
	 * with the doctor data.
	 * 
	 * @param docData	the doctor data
	 */
	public Link(Doctor docData) {
		super();
		this.docData = docData;
	}
	
	/**
	 * Constructor that accepts a parameter
	 * with the patient data.
	 * 
	 * @param patData	the patient data
	 */
	public Link(Patient patData) {
		super();
		this.patData = patData;
	}
	
	/**
	 * This method displays the link's data.
	 */
	public void displayLink()
	{
		if(appData != null)
		{
			System.out.println(appData);
		}
		if(docData != null)
		{
			System.out.println(docData.getFirstName() + " " + docData.getLastName());
		}
		if(patData != null)
		{
			System.out.println(patData.getFirstName() + " " + patData.getLastName());
		}	
	}
}

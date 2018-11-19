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
	 * This method displays the appointment data.
	 */
	public void displayLink()
	{
		System.out.println(appData);
	}
}

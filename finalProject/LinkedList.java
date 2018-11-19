/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create and modify a Linked List.
 * 
 * @author Samantha Lange
 *
 */
public class LinkedList {
	// field - first item on list
	private Link first;

	/**
	 * Constructor that sets first to null to reflect an empty list.
	 */
	public LinkedList() {
		super();
		first = null;
	}
	
	/**
	 * This method checks if the list is empty.
	 * If empty, returns true, if not empty
	 * returns false.
	 * 
	 * @return	true if list is empty
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * This method searches for an appointment in the list.
	 * 
	 * @param app	the appointment to search for
	 * @return		whether the appointment was found or not
	 */
	public Appointment search(Appointment app) {							
		Link current = first;
		if(!isEmpty())
		{
			while(current.appData != app)
			{
				if(current.next == null)
				{
					return null;
				}
				else
				{
					current = current.next;
				}
			}
			return current.appData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method inserts an appointment into the list,
	 * in order by the last name of the patient.
	 * 
	 * @param app	the appointment to insert
	 */
	public void insert(Appointment app) {
		Link link = new Link(app);
		Link previous = null;
		Link current = first;
		
		while(current != null && app.getApptPatient().getLastName().compareToIgnoreCase(current.appData.getApptPatient().getLastName()) > 0)
		{
			previous = current;
			current = current.next;
		}
		
		if(previous == null)
		{
			first = link;
		}
		else
		{
			previous.next = link;
		}
		
		link.next = current;
	}
	
	/**
	 * This method deletes an appointment from the list.
	 * 
	 * @param app	the appointment to be deleted
	 * @return		the deleted appointment
	 */
	public Appointment delete(Appointment app) {   
		Link previous = first;
		Link current = first;
		if(!isEmpty())
		{
			while(current.appData != app)
			{
				if(current.next == null)
				{
					return null;
				}
				else
				{
					previous = current;
					current = current.next;
				}
			}
			
			if(current == first)
			{
				first = first.next;
			}
			else
			{
				previous.next = current.next;
			}
			return current.appData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method displays the list.
	 */
	public void displayList() {
		if(!isEmpty())
		{
			Link current = first;
			while(current != null)
			{
				current.displayLink();
				current = current.next;
			}
		}
	}
}

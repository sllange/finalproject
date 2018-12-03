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
	private int numItemsInList;

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
	 * This method searches for a doctor in the list.
	 * 
	 * @param doc	the doctor to search for
	 * @return		whether the doctor was found or not
	 */
	public Doctor search(Doctor doc) {							
		Link current = first;
		if(!isEmpty())
		{
			while(current.docData != doc)
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
			return current.docData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method searches for a patient in the list.
	 * 
	 * @param pat	the patient to search for
	 * @return		whether the patient was found or not
	 */
	public Patient search(Patient pat) {							
		Link current = first;
		if(!isEmpty())
		{
			while(current.patData != pat)
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
			return current.patData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method inserts an appointment into the list,
	 * in order by the date of the appointment and by
	 * the time of the appointment.
	 * 
	 * @param app	the appointment to insert
	 */
	public void insert(Appointment app) {
		Link link = new Link(app);
		Link previous = null;
		Link current = first;
		
		// orders appointments by date first
		while(current != null && app.getDateOfAppt().compareToIgnoreCase(current.appData.getDateOfAppt()) > 0)
		{
			previous = current;
			current = current.next;
		}
		// orders appointments by time of the appointment second
		while(current != null && app.getTimeOfAppt().compareToIgnoreCase(current.appData.getTimeOfAppt()) > 0
					&& app.getDateOfAppt().compareToIgnoreCase(current.appData.getDateOfAppt()) == 0)
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
		numItemsInList++;
	}
	
	/**
	 * This method inserts a doctor into the list,
	 * in order by the last name of the doctor.
	 * 
	 * @param doc	the doctor to insert
	 */
	public void insert(Doctor doc) {
		Link link = new Link(doc);
		Link previous = null;
		Link current = first;
		
		while(current != null && doc.getLastName().compareToIgnoreCase(current.docData.getLastName()) > 0)
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
		numItemsInList++;
	}
	
	/**
	 * This method inserts a patient into the list,
	 * in order by the last name of the patient.
	 * 
	 * @param pat	the patient to insert
	 */
	public void insert(Patient pat) {
		Link link = new Link(pat);
		Link previous = null;
		Link current = first;
		
		while(current != null && pat.getLastName().compareToIgnoreCase(current.patData.getLastName()) > 0)
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
		numItemsInList++;
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
			numItemsInList--;
			return current.appData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method deletes a doctor from the list.
	 * 
	 * @param doc	the doctor to be deleted
	 * @return		the deleted doctor
	 */
	public Doctor delete(Doctor doc) {   
		Link previous = first;
		Link current = first;
		if(!isEmpty())
		{
			while(current.docData != doc)
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
			numItemsInList--;
			return current.docData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This method deletes a patient from the list.
	 * 
	 * @param pat	the patient to be deleted
	 * @return		the deleted patient
	 */
	public Patient delete(Patient pat) {   
		Link previous = first;
		Link current = first;
		if(!isEmpty())
		{
			while(current.patData != pat)
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
			numItemsInList--;
			return current.patData;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * This methods returns the number of items in the list.
	 * 
	 * @return	the number of items in the list
	 */
	public int size() {
		return numItemsInList;
	}
	
	/**
	 * This method returns the first link.
	 * 
	 * @return	the first link
	 */
	public Link getFirst() {
		return first;
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

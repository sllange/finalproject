/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create an Appointment object.
 * 
 * @author Samantha Lange
 *
 */
public class Appointment {
	// fields
	private String dateOfAppt;
	private String timeOfAppt;
	private String reasonForAppt;
	private Doctor apptDoctor;
	
	/**
	 * Class default constructor.
	 * Creates an empty Appointment object.
	 */
	public Appointment() {
		super();
	}

	/**
	 * This constructor accepts parameters for
	 * the date, time, and reason for an appointment,
	 * and the doctor requested for the appointment,
	 * and creates an Appointment object.
	 * 
	 * @param date		the date of the appointment
	 * @param time		the time of the appointment
	 * @param reason	the reason for the appointment
	 * @param doc		the doctor of the appointment
	 */
	public Appointment(String date, String time, String reason, Doctor doc) {
		super();
		this.dateOfAppt = date;
		this.timeOfAppt = time;
		this.reasonForAppt = reason;
		this.apptDoctor = doc;
	}

	/**
	 * This method returns the date of the appointment.
	 * 
	 * @return	the date of the appointment
	 */
	public String getDateOfAppt() {
		return dateOfAppt;
	}

	/**
	 * This method sets the date of the appointment.
	 * 
	 * @param date	the date of the appointment
	 */
	public void setDateOfAppt(String date) {
		this.dateOfAppt = date;
	}

	/**
	 * This method returns the time of the appointment.
	 * 
	 * @return	the time of the appointment
	 */
	public String getTimeOfAppt() {
		return timeOfAppt;
	}

	/**
	 * This method sets the time of the appointment.
	 * 
	 * @param time	the time of the appointment
	 */
	public void setTimeOfAppt(String time) {
		this.timeOfAppt = time;
	}

	/**
	 * This method returns the reason for the appointment.
	 * 
	 * @return	the reason for the appointment
	 */
	public String getReasonForAppt() {
		return reasonForAppt;
	}

	/**
	 * This method sets the reason for the appointment.
	 * 
	 * @param reason	the reason for the appointment
	 */
	public void setReasonForAppt(String reason) {
		this.reasonForAppt = reason;
	}

	/**
	 * This method returns the doctor of the appointment.
	 * 
	 * @return	the doctor of the appointment
	 */
	public Doctor getApptDoctor() {
		return apptDoctor;
	}

	/**
	 * This method sets the doctor of the appointment.
	 * 
	 * @param doc	the doctor of the appointment
	 */
	public void setApptDoctor(Doctor doc) {
		this.apptDoctor = doc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Appointment [dateOfAppt=" + dateOfAppt + ", timeOfAppt=" + timeOfAppt + ", reasonForAppt="
				+ reasonForAppt + ", apptDoctor=" + apptDoctor + "]";
	}
}

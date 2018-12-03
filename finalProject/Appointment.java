/**
 * This package groups all of the files for the final project.
 */
package finalProject;

import java.util.ArrayList;

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
	private Patient apptPatient;
	
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
	 * @param pat		the patient who the appointment is for
	 */
	public Appointment(String date, String time, String reason, Doctor doc, Patient pat) {
		super();
		setDateOfAppt(date);
		setTimeOfAppt(time);
		setReasonForAppt(reason);
		setApptDoctor(doc);
		setApptPatient(pat);
		removeTimeFromSched();
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

	/**
	 * This method returns the patient who the appointment is for.
	 * 
	 * @return	the patient who the appointment is for
	 */
	public Patient getApptPatient() {
		return apptPatient;
	}

	/**
	 * This method sets the patient who the appointment is for.
	 * 
	 * @param pat	the patient who the appointment is for
	 */
	public void setApptPatient(Patient pat) {
		this.apptPatient = pat;
	}
	
	/**
	 * This method removes the time of this appointment from the doctor's available schedule.
	 */
	public void removeTimeFromSched() {
		ArrayList<DoctorSchedules> sched = this.getApptDoctor().getDailySched();
		if(sched != null)
		{
			for(int i = 0; i < sched.size(); i++)
			{
				String apptDate = sched.get(i).getDate();
				if(apptDate.equals(getDateOfAppt()))
				{
					for(int j = 0; j < sched.get(i).getTime().size(); j++)
					{
						String time = sched.get(i).getTime().get(j);
						if(time.equals(this.getTimeOfAppt()))
						{
							sched.get(i).removeTime(j);
							if(sched.get(i).getTime().isEmpty())
							{
								sched.remove(i);
								break;
							}
						}
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Date: " + dateOfAppt + ", Time: " + timeOfAppt + ", Patient: " + apptPatient.toString() 
				+ ", Doctor: " + apptDoctor.toString() + ", Reason: " + reasonForAppt;
	}
}

/**
 * This package groups all of the files for the final project.
 */
package finalProject;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The purpose of this class is to create a Doctor object, an extension of the Person class.
 * 
 * @author Samantha Lange
 *
 */
public class Doctor extends Person {
	// fields
	private String specialization;
	private String schedule;
	private ArrayList<DoctorSchedules> dailySched;
	
	/**
	 * Class default constructor.
	 * Creates an empty Doctor object.
	 */
	public Doctor() {
		super();
	}
	
	/**
	 * This constructor accepts all parameters for the
	 * Person class, as well as the specialization and
	 * schedule parameters for the Doctor class and
	 * creates a Doctor object.
	 * 
	 * @param fName		the first name of the doctor
	 * @param lName		the last name of the doctor
	 * @param year		the birth year of the doctor
	 * @param phone		the phone number of the doctor
	 * @param email		the email address of the doctor
	 * @param spec		the specialization of the doctor
	 * @param schedule	the schedule of the doctor
	 */
	public Doctor(String fName, String lName, String year, String phone, String email, String spec, String sched) {
		super(fName, lName, year, phone, email);
		setSpecialization(spec);
		dailySched = new ArrayList<DoctorSchedules>();
		setSchedule(sched);
		setDailySched();
	}

	/**
	 * This method returns the specialization of the doctor.
	 * 
	 * @return	the specialization of the doctor
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * This method sets the specialization of the doctor.
	 * 
	 * @param spec	the specialization of the doctor
	 */
	public void setSpecialization(String spec) {
		this.specialization = spec;
	}

	/**
	 * This method returns the schedule of the doctor.
	 * 
	 * @return	the schedule of the doctor
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * This method sets the schedule of the doctor.
	 * 
	 * @param sched	the schedule of the doctor
	 */
	public void setSchedule(String sched) {
		this.schedule = sched;
	}
	
	/**
	 * This method returns the daily schedule of the doctor.
	 * 
	 * @return	the daily schedule of the doctor
	 */
	public ArrayList<DoctorSchedules> getDailySched() {
		return dailySched;
	}

	/**
	 * This method sets the daily schedule of the doctor.
	 * This will set the schedule for the current month
	 * and following month.
	 * 
	 * @param dailySched	the daily schedule of the doctor
	 */
	public void setDailySched() {
		String inSched = getSchedule();
		int[] daysIn2019 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // also works for remainder of 2018
		LocalDate todaysDate = LocalDate.now();
		int todaysMonth = todaysDate.getMonthValue() - 1;
		int todaysDay = todaysDate.getDayOfMonth();
		int daysInMonth = daysIn2019[todaysMonth];
		if(todaysDay != daysInMonth && todaysDay + 1 <= daysInMonth) // current month's schedule
		{
			for(int i = todaysDay + 1; i <= daysInMonth; i++)
			{
				dailySched.add(new DoctorSchedules(todaysMonth + 1, i, inSched));
			}
		}
		if(todaysMonth + 1 > 11) // next month's schedule
		{
			todaysMonth = 0;
		}
		else
		{
			todaysMonth++;
		}
		todaysDay = 1;
		daysInMonth = daysIn2019[todaysMonth];
		for(int i = todaysDay; i <= daysInMonth; i++)
		{
			dailySched.add(new DoctorSchedules(todaysMonth + 1, i, inSched));
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName();
	}
}

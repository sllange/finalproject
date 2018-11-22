/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create a Doctor object, an extension of the Person class.
 * 
 * @author Samantha Lange
 *
 */
public class Doctor extends Person {
	// fields
	private String specialization;
	private String schedule; // make this an array???
	
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
	public Doctor(String fName, String lName, int year, String phone, String email, String spec, String sched) {
		super(fName, lName, year, phone, email);
		setSpecialization(spec);
		setSchedule(sched);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [specialization=" + specialization + ", schedule=" + schedule + "]";
	}
}

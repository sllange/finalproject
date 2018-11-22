/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create a Patient object, an extension of the Person class.
 * 
 * @author Samantha Lange
 *
 */
public class Patient extends Person {
	// fields
	private Doctor primaryDr;
	
	/**
	 * Class default constructor.
	 * Creates an empty Patient object.
	 */
	public Patient() {
		super();
	}
	
	/**
	 * This constructor accepts all parameters for the
	 * Person class, as well as the primary doctor and
	 * address parameters for the Patient class and
	 * creates a Patient object.
	 * 
	 * @param fName		the first name of the patient
	 * @param lName		the last name of the patient
	 * @param year		the birth year of the patient
	 * @param phone		the phone number of the patient
	 * @param email		the email address of the patient
	 * @param primaryDr	the primary doctor of the patient
	 */
	public Patient(String fName, String lName, int year, String phone, String email, Doctor primaryDr) {
		super(fName, lName, year, phone, email);
		setPrimaryDr(primaryDr);
	}

	/**
	 * This method returns the primary doctor of the patient.
	 * 
	 * @return	the primary doctor of the patient
	 */
	public Doctor getPrimaryDr() {
		return primaryDr;
	}

	/**
	 * This method sets the primary doctor of the patient.
	 * 
	 * @param primaryDr	the primary doctor of the patient
	 */
	public void setPrimaryDr(Doctor primaryDr) {
		this.primaryDr = primaryDr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Patient [primaryDr=" + primaryDr + "]";
	}
}

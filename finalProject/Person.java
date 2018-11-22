/**
 * This package groups all of the files for the final project.
 */
package finalProject;

/**
 * The purpose of this class is to create a Person object.
 * 
 * @author Samantha Lange
 *
 */
public class Person {
	// fields
	private String firstName;
	private String lastName;
	private int birthYear;
	private String phone;
	private String email;
	
	/**
	 * Class default constructor.
	 * Creates an empty person object.
	 */
	public Person() {
		super();
	}

	/**
	 * Constructor that accepts parameters for name,
	 * birth year, phone number and email, and creates
	 * a person object.
	 * 
	 * @param fName	the first name of the person
	 * @param lName	the last name of the person
	 * @param year	the birth year of the person
	 * @param phone	the phone number of the person
	 * @param email	the email address of the person
	 */
	public Person(String fName, String lName, int year, String phone, String email) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.birthYear = year;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * This method returns the first name of the person.
	 * 
	 * @return	the first name of the person
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets the first name of the person.
	 * 
	 * @param fName	the first name of the person
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	/**
	 * This method returns the last name of the person.
	 * 
	 * @return	the last name of the person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method sets the last name of the person.
	 * 
	 * @param lName	the last name of the person
	 */
	public void setLastName(String lName) {
		this.lastName = lName;
	}

	/**
	 * This method returns the year of birth of the person.
	 * 
	 * @return	the birth year of the person
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * This method sets the year of birth of the person.
	 * 
	 * @param year the birth year of the person
	 */
	public void setBirthYear(int year) {
		this.birthYear = year;
	}

	/**
	 * This method returns the phone number of the person.
	 * 
	 * @return	the phone number of the person
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method sets the phone number of the person.
	 * 
	 * @param phone	the phone number of the person
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method returns the email address of the person.
	 * 
	 * @return	the email address of the person
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets the email address of the person.
	 * 
	 * @param email	the email address of the person
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear + ", phone="
				+ phone + ", email=" + email + "]";
	}
}

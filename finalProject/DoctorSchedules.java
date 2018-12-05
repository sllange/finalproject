/**
 * This package groups all of the files for the final project.
 */
package finalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The purpose of this class is to create a daily schedule of available
 * appointment slots for a doctor.
 * 
 * @author Samantha Lange
 *
 */
public class DoctorSchedules {
	// fields
	private String date;
	private ArrayList<String> timeAvailable;
	private String workHours;
	
	/**
	 * Constructor that accepts work hours, month, and
	 * day parameters to create a doctor's daily schedule.
	 * 
	 * @param month		the month of the schedule
	 * @param day		the day of the schedule
	 * @param workHours	the doctor's schedule
	 */
	public DoctorSchedules(int month, int day, String workHours) {
		super();
		timeAvailable = new ArrayList<String>();
		setDate(month, day);
		setWorkHours(workHours);
		setTime();
	}

	/**
	 * This method returns the date of the available appointments.
	 * 
	 * @return	the date of the available appointments
	 */
	public String getDate() {
		return date;
	}

	/**
	 * This method returns the date of the available appointments.
	 * 
	 * @param date	the date of the available appointments
	 */
	public void setDate(int month, int day) {
		String dayString = "";
		if(day < 10)
		{
			for(int i = 0; i < 10; i++)
			{
				if(day == i)
				{
					dayString = "0" + i;
				}
			}
			this.date = month + "-" + dayString;
		}
		else
		{
			this.date = month + "-" + day;
		}
	}

	/**
	 * This method returns the available time slots.
	 * 
	 * @return	the available time slots
	 */
	public List<String> getTime() {
		return timeAvailable;
	}

	/**
	 * This method sets the available time slots.
	 * 
	 * @param time	the available time slots
	 */
	public void setTime() {
		ArrayList<String> slots = new ArrayList<String>();
		String inSched = getWorkHours();
		switch(inSched) {
		case "6AM-3PM":
			ArrayList<String> sched1 = new ArrayList<String>(Arrays.asList("06AM","07AM","08AM","09AM","10AM","12PM","1PM","2PM","3PM"));
			slots = sched1;
			break;
		case "7AM-4PM":
			ArrayList<String> sched2 = new ArrayList<String>(Arrays.asList("07AM","08AM","09AM","10AM","11AM","1PM","2PM","3PM","4PM"));
			slots = sched2;
			break;
		case "8AM-5PM":
			ArrayList<String> sched3 = new ArrayList<String>(Arrays.asList("08AM","09AM","10AM","11AM","12PM","2PM","3PM","4PM","5PM"));
			slots = sched3;
			break;
		case "9AM-6PM":
			ArrayList<String> sched4 = new ArrayList<String>(Arrays.asList("09AM","10AM","11AM","12PM","1PM","3PM","4PM","5PM","6PM"));
			slots = sched4;
			break;
		case "10AM-7PM":
			ArrayList<String> sched5 = new ArrayList<String>(Arrays.asList("10AM","11AM","12PM","1PM","2PM","4PM","5PM","6PM","7PM"));
			slots = sched5;
			break;
		default:
			slots.add("No appointments available for this date.");
		}
		this.timeAvailable = slots;
	}
	
	/**
	 * This method updates the available time slots by
	 * removing the index passed in to the method.
	 * 
	 * @param index	the index of the item to remove
	 */
	public void removeTime(int index) {
		this.timeAvailable.remove(index);
	}

	/**
	 * This method returns the doctor's working hours.
	 * 
	 * @return	the doctor's working hours
	 */
	public String getWorkHours() {
		return workHours;
	}

	/**
	 * This method sets the doctor's working hours.
	 * 
	 * @param schedule	the doctor's working hours
	 */
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DoctorSchedules [date=" + date + ", timeAvailable=" + timeAvailable + ", workHours=" + workHours + "]";
	}
}

/**
 * This package groups all of the files for the final project.
 */
package finalProject;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The purpose of this class is to test the final project for CIS152.
 * This class loads starting data on launch of the application's GUI.
 * This class contains several methods to allow functionality between 
 * the GUI (AppUI) and other classes. This keeps the data
 * separate from the GUI class.
 * 
 * @author Samantha Lange
 *
 */
public class ProjectDriver {
	// fields
	static AppUI window = new AppUI();
	static LinkedList apps;
	static LinkedList docs;
	static LinkedList pats;
	static int patQueueSize = 20;
	static QueueFP patients;
	
	/**
	 * This method fills the appointment view tab with all of the appointment data.
	 * This method also loads the list on the appointment cancel tab with data.
	 */
	public static void appTable() {
		while(window.modelApp.getRowCount() > 0)
		{
				window.modelApp.removeRow(0);
		}
		window.listModelApp.removeAllElements();
		if(!apps.isEmpty())
		{
			Link current = apps.getFirst();
			while(current != null)
			{
				Vector<String> row = new Vector<String>();
				row.add(current.appData.getDateOfAppt());
				row.add(current.appData.getTimeOfAppt());
				row.add(current.appData.getReasonForAppt());
				row.add(current.appData.getApptDoctor().getFirstName() + " " + current.appData.getApptDoctor().getLastName());
				row.add(current.appData.getApptPatient().getFirstName() + " " + current.appData.getApptPatient().getLastName());
				window.modelApp.addRow(row);
				window.listModelApp.addElement(current.appData);
				current = current.next;
			}
		}
	}
	
	/**
	 * This method fills the doctor view tab with all of the doctor data.
	 */
	public static void docTable() {
		while(window.modelDoc.getRowCount() > 0)
		{
				window.modelDoc.removeRow(0);
		}
		if(!docs.isEmpty())
		{
			int rowCount = window.modelDoc.getRowCount();
			if(rowCount > 0)
			{
				for(int i = 0; i < rowCount; i++)
				{
					window.modelDoc.removeRow(i);
				}
			}
			Link current = docs.getFirst();
			while(current != null)
			{
				Vector<String> row = new Vector<String>();
				row.add(current.docData.toString());
				row.add(current.docData.getBirthYear());
				row.add(current.docData.getPhone());
				row.add(current.docData.getEmail());
				row.add(current.docData.getSpecialization());
				row.add(current.docData.getSchedule());
				window.modelDoc.addRow(row);
				current = current.next;
			}
			getDocs();
		}
	}
	
	/**
	 * This method fills the patient view tab with all of the patient data.
	 */
	public static void patTable() {
		while(window.modelPat.getRowCount() > 0)
		{
				window.modelPat.removeRow(0);
		}
		if(!pats.isEmpty())
		{
			int rowCount = window.modelPat.getRowCount();
			if(rowCount > 0)
			{
				for(int i = 0; i < rowCount; i++)
				{
					window.modelPat.removeRow(i);
				}
			}
			Link current = pats.getFirst();
			while(current != null)
			{
				Vector<String> row = new Vector<String>();
				row.add(current.patData.toString());
				row.add(current.patData.getBirthYear());
				row.add(current.patData.getPhone());
				row.add(current.patData.getEmail());
				row.add(current.patData.getPrimaryDr().toString());
				window.modelPat.addRow(row);
				current = current.next;
			}
			getPats();
		}
	}
	
	/**
	 * This method loads combo boxes and a list with doctors.
	 */
	public static void getDocs() {
		window.comboBoxDoc.removeAllItems();
		window.comboBoxPrim.removeAllItems();
		window.comboBoxPrimPatUp.removeAllItems();
		window.listModelDoc.removeAllElements();
		if(!docs.isEmpty())
		{
			Link current = docs.getFirst();
			while(current != null)
			{
				window.comboBoxDoc.addItem(current.docData);
				window.comboBoxPrim.addItem(current.docData);
				window.comboBoxPrimPatUp.addItem(current.docData);
				window.listModelDoc.addElement(current.docData);
				current = current.next;
			}
		}
	}
	
	/**
	 * This method loads a combo box with a doctor's date schedule.
	 * 
	 * @param inDoc	the doctor to get the date schedule of
	 */
	public static void getDateSched(Doctor inDoc) {
		if(inDoc != null) 
		{
			window.comboBoxTime.removeAllItems();
			window.comboBoxDate.removeAllItems();
			
			ArrayList<DoctorSchedules> sched = inDoc.getDailySched();
			if(sched != null)
			{
				for(int i = 0; i < sched.size(); i++)
				{
					window.comboBoxDate.addItem(sched.get(i).getDate());
				}
			}
		}
	}
	
	/**
	 * This method loads a combo box with the available time
	 * slots per each day of a doctor's schedule.
	 * 
	 * @param inDoc	the doctor to get the time slots of
	 * @param date	the date to get the time slots of
	 */
	public static void getTimeSched(Doctor inDoc, String date) {
		if(inDoc != null && date != null)
		{
			window.comboBoxTime.removeAllItems();
			ArrayList<DoctorSchedules> sched = inDoc.getDailySched();
			if(sched != null)
			{
				for(int i = 0; i < sched.size(); i++)
				{
					String apptDate = sched.get(i).getDate();
					if(apptDate.equals(date))
					{
						for(int j = 0; j < sched.get(i).getTime().size(); j++)
						{
							String time = sched.get(i).getTime().get(j);
							window.comboBoxTime.addItem(time);
						}
					}
				}
			}
		}
	}
	
	/**
	 * This method loads a combo box and list with patients.
	 */
	public static void getPats() {
		window.comboBoxPat.removeAllItems();
		window.listModelPat.removeAllElements();
		if(!pats.isEmpty())
		{
			Link current = pats.getFirst();
			while(current != null)
			{
				window.comboBoxPat.addItem(current.patData);
				window.listModelPat.addElement(current.patData);
				current = current.next;
			}
		}
	}
	
	/**
	 * Main method of the application.
	 * Launch the application, and load starting data.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// create multiple patients, doctors, and appointments on load of the application
		patients = new QueueFP(patQueueSize);
		Doctor doc1 = new Doctor("Patrick", "Miller", "1977", "333-444-2334", "patM@meds.com", "Pediatrician", "6AM-3PM");
		Doctor doc2 = new Doctor("Mary", "Johnson", "1980", "456-234-7878", "mj80@meds.com", "Family", "8AM-5PM");
		docs = new LinkedList();
		docs.insert(doc1);
		docs.insert(doc2);
		docTable();
		Patient pat1 = new Patient("Bob", "Smith", "1956", "555-443-2234", "bsmith@aol.com", doc1);
		Patient pat2 = new Patient("Sara", "Lewis", "1991", "876-456-2323", "saral@hotmail.com", doc2);
		pats = new LinkedList();
		pats.insert(pat1);
		pats.insert(pat2);
		patTable();
		Appointment app1 = new Appointment("12-8", "08AM", "Flu", doc2, pat2);
		Appointment app2 = new Appointment("12-9", "10AM", "Physical", doc1, pat1);
		apps = new LinkedList();
		apps.insert(app1);
		apps.insert(app2);
		appTable();
	}
}

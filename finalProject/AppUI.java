package finalProject;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import java.awt.TextArea;
import javax.swing.JButton;

public class AppUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppUI window = new AppUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMain.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPaneMain.setBounds(0, 0, 706, 453);
		desktopPane.add(tabbedPaneMain);
		
		/* ----- Appointments Tab ----- */
		JLayeredPane layeredPaneApp = new JLayeredPane();
		tabbedPaneMain.addTab("Appointments", null, layeredPaneApp, null);
		
		JTabbedPane tabbedPaneApp = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneApp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPaneApp.setBounds(0, 0, 701, 425);
		layeredPaneApp.add(tabbedPaneApp);
		
		JLayeredPane layeredPaneAppView = new JLayeredPane();
		tabbedPaneApp.addTab("View", null, layeredPaneAppView, null);
		
		Object[][] dataApp = {
			{"test", null, null, null, null}
		};
		String[] columnNamesApp = {
			"Date", "Time", "Reason", "Doctor", "Patient"
		};
		table = new JTable(dataApp, columnNamesApp);
		table.setBounds(125, 57, 403, 192);
		layeredPaneAppView.setLayout(new BorderLayout());
		layeredPaneAppView.add(table.getTableHeader(), BorderLayout.PAGE_START);
		layeredPaneAppView.add(table, BorderLayout.CENTER);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLayeredPane layeredPaneAppAdd = new JLayeredPane();
		tabbedPaneApp.addTab("Add", null, layeredPaneAppAdd, null);
		
		JComboBox<Object> comboBoxDate = new JComboBox<Object>();
		comboBoxDate.setModel(new DefaultComboBoxModel<Object>(new String[] {"test", "test 2"}));
		comboBoxDate.setBounds(279, 80, 73, 23);
		layeredPaneAppAdd.add(comboBoxDate);
		
		Label lblDateA = new Label("Date");
		lblDateA.setAlignment(Label.RIGHT);
		lblDateA.setBounds(203, 80, 70, 22);
		layeredPaneAppAdd.add(lblDateA);
		
		JComboBox<Object> comboBoxTime = new JComboBox<Object>();
		comboBoxTime.setModel(new DefaultComboBoxModel<Object>(new String[] {"test", "test 2"}));
		comboBoxTime.setBounds(279, 109, 73, 23);
		layeredPaneAppAdd.add(comboBoxTime);
		
		Label lblTimeA = new Label("Time");
		lblTimeA.setAlignment(Label.RIGHT);
		lblTimeA.setBounds(203, 109, 70, 22);
		layeredPaneAppAdd.add(lblTimeA);
		
		JComboBox<Object> comboBoxDoc = new JComboBox<Object>();
		comboBoxDoc.setModel(new DefaultComboBoxModel<Object>(new String[] {"test", "test 2"}));
		comboBoxDoc.setBounds(472, 80, 73, 23);
		layeredPaneAppAdd.add(comboBoxDoc);
		
		Label lblDocA = new Label("Doctor");
		lblDocA.setAlignment(Label.RIGHT);
		lblDocA.setBounds(386, 80, 80, 22);
		layeredPaneAppAdd.add(lblDocA);
		
		JComboBox<Object> comboBoxPat = new JComboBox<Object>();
		comboBoxPat.setModel(new DefaultComboBoxModel<Object>(new String[] {"test", "test 2"}));
		comboBoxPat.setBounds(472, 108, 73, 23);
		layeredPaneAppAdd.add(comboBoxPat);
		
		Label lblPatA = new Label("Patient");
		lblPatA.setAlignment(Label.RIGHT);
		lblPatA.setBounds(386, 108, 80, 22);
		layeredPaneAppAdd.add(lblPatA);
		
		TextArea txtReasonA = new TextArea();
		txtReasonA.setRows(5);
		txtReasonA.setBounds(279, 167, 175, 60);
		layeredPaneAppAdd.add(txtReasonA);
		
		Label lblReasonA = new Label("Reason");
		lblReasonA.setAlignment(Label.RIGHT);
		lblReasonA.setBounds(203, 167, 70, 22);
		layeredPaneAppAdd.add(lblReasonA);
		
		JButton btnSubmitA = new JButton("Submit");
		btnSubmitA.setBounds(266, 305, 89, 23);
		layeredPaneAppAdd.add(btnSubmitA);
		
		JButton btnClearA = new JButton("Clear");
		btnClearA.setBounds(365, 305, 89, 23);
		layeredPaneAppAdd.add(btnClearA);
		
		JLayeredPane layeredPaneAppUpdate = new JLayeredPane();
		tabbedPaneApp.addTab("Update", null, layeredPaneAppUpdate, null);
		
		/* ----- Doctors Tab ----- */
		JLayeredPane layeredPaneDoc = new JLayeredPane();
		tabbedPaneMain.addTab("Doctors", null, layeredPaneDoc, null);
		
		JTabbedPane tabbedPaneDoc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDoc.setBounds(0, 0, 701, 425);
		layeredPaneDoc.add(tabbedPaneDoc);
		
		JLayeredPane layeredPaneDocView = new JLayeredPane();
		tabbedPaneDoc.addTab("View", null, layeredPaneDocView, null);
		
		Object[][] dataDoc = {
			{"test", null, null, null, null, null, null}
		};
		String[] columnNamesDoc = {
			"First Name", "Last Name", "Birth Year", "Phone", "Email", "Specilization", "Schedule"
		};
		table = new JTable(dataDoc, columnNamesDoc);
		table.setBounds(125, 57, 403, 192);
		layeredPaneDocView.setLayout(new BorderLayout());
		layeredPaneDocView.add(table.getTableHeader(), BorderLayout.PAGE_START);
		layeredPaneDocView.add(table, BorderLayout.CENTER);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLayeredPane layeredPaneDocAdd = new JLayeredPane();
		tabbedPaneDoc.addTab("Add", null, layeredPaneDocAdd, null);
		
		TextField txtFirstD = new TextField();
		txtFirstD.setBounds(279, 80, 73, 23);
		layeredPaneDocAdd.add(txtFirstD);
		
		Label lblFirstD = new Label("First Name");
		lblFirstD.setAlignment(Label.RIGHT);
		lblFirstD.setBounds(203, 80, 70, 22);
		layeredPaneDocAdd.add(lblFirstD);
		
		TextField txtLastD = new TextField();
		txtLastD.setBounds(279, 109, 73, 23);
		layeredPaneDocAdd.add(txtLastD);
		
		Label lblLastD = new Label("Last Name");
		lblLastD.setAlignment(Label.RIGHT);
		lblLastD.setBounds(203, 109, 70, 22);
		layeredPaneDocAdd.add(lblLastD);
		
		TextField txtPhoneD = new TextField();
		txtPhoneD.setBounds(472, 80, 73, 23);
		layeredPaneDocAdd.add(txtPhoneD);
		
		Label lblPhoneD = new Label("Phone");
		lblPhoneD.setAlignment(Label.RIGHT);
		lblPhoneD.setBounds(386, 80, 80, 22);
		layeredPaneDocAdd.add(lblPhoneD);
		
		TextField txtEmailD = new TextField();
		txtEmailD.setBounds(472, 108, 73, 23);
		layeredPaneDocAdd.add(txtEmailD);
		
		Label lblEmailD = new Label("Email");
		lblEmailD.setAlignment(Label.RIGHT);
		lblEmailD.setBounds(386, 108, 80, 22);
		layeredPaneDocAdd.add(lblEmailD);
		
		TextField txtYearD = new TextField();
		txtYearD.setBounds(472, 136, 73, 23);
		layeredPaneDocAdd.add(txtYearD);
		
		Label lblYearD = new Label("Year of Birth");
		lblYearD.setAlignment(Label.RIGHT);
		lblYearD.setBounds(386, 136, 80, 22);
		layeredPaneDocAdd.add(lblYearD);
		
		JComboBox<Object> comboBoxSpec = new JComboBox<Object>();
		comboBoxSpec.setModel(new DefaultComboBoxModel<Object>(new String[] {"Family-Primary", "Surgeon"}));
		comboBoxSpec.setBounds(279, 167, 73, 23);
		layeredPaneDocAdd.add(comboBoxSpec);
		
		Label lblSpec = new Label("Specialty");
		lblSpec.setAlignment(Label.RIGHT);
		lblSpec.setBounds(203, 167, 70, 22);
		layeredPaneDocAdd.add(lblSpec);
		
		Label lblSched = new Label("Schedule");
		lblSched.setAlignment(Label.RIGHT);
		lblSched.setBounds(203, 202, 70, 22);
		layeredPaneDocAdd.add(lblSched);
		
		JComboBox<Object> comboBoxSched = new JComboBox<Object>();
		comboBoxSched.setModel(new DefaultComboBoxModel<Object>(new String[] {"6AM-3PM", "7AM-4PM", "8AM-5PM", "9AM-6PM", "10AM-7PM"}));
		comboBoxSched.setBounds(279, 201, 73, 23);
		layeredPaneDocAdd.add(comboBoxSched);
		
		JButton btnSubmitD = new JButton("Submit");
		btnSubmitD.setBounds(266, 305, 89, 23);
		layeredPaneDocAdd.add(btnSubmitD);
		
		JButton btnClearD = new JButton("Clear");
		btnClearD.setBounds(365, 305, 89, 23);
		layeredPaneDocAdd.add(btnClearD);
		
		JLayeredPane layeredPaneDocUpdate = new JLayeredPane();
		tabbedPaneDoc.addTab("Update", null, layeredPaneDocUpdate, null);
		
		/* ----- Patients Tab ----- */
		JLayeredPane layeredPanePat = new JLayeredPane();
		tabbedPaneMain.addTab("Patients", null, layeredPanePat, null);
		
		JTabbedPane tabbedPanePat = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePat.setBounds(0, 0, 701, 425);
		layeredPanePat.add(tabbedPanePat);
		
		JLayeredPane layeredPanePatView = new JLayeredPane();
		tabbedPanePat.addTab("View", null, layeredPanePatView, null);
		
		Object[][] dataPat = {
			{"test", null, null, null, null, null}
		};
		String[] columnNamesPat = {
			"First Name", "Last Name", "Birth Year", "Phone", "Email", "Primary Doctor"
		};
		table = new JTable(dataPat, columnNamesPat);
		table.setBounds(125, 57, 403, 192);
		layeredPanePatView.setLayout(new BorderLayout());
		layeredPanePatView.add(table.getTableHeader(), BorderLayout.PAGE_START);
		layeredPanePatView.add(table, BorderLayout.CENTER);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLayeredPane layeredPanePatAdd = new JLayeredPane();
		tabbedPanePat.addTab("Add", null, layeredPanePatAdd, null);
		
		Label lblFirstP = new Label("First Name");
		lblFirstP.setAlignment(Label.RIGHT);
		lblFirstP.setBounds(203, 80, 70, 22);
		layeredPanePatAdd.add(lblFirstP);
		
		TextField txtFirstP = new TextField();
		txtFirstP.setBounds(279, 80, 73, 23);
		layeredPanePatAdd.add(txtFirstP);
		
		Label lblLastP = new Label("Last Name");
		lblLastP.setAlignment(Label.RIGHT);
		lblLastP.setBounds(203, 109, 70, 22);
		layeredPanePatAdd.add(lblLastP);
		
		TextField txtLastP = new TextField();
		txtLastP.setBounds(279, 109, 73, 23);
		layeredPanePatAdd.add(txtLastP);
		
		Label lblPhoneP = new Label("Phone");
		lblPhoneP.setAlignment(Label.RIGHT);
		lblPhoneP.setBounds(386, 80, 80, 22);
		layeredPanePatAdd.add(lblPhoneP);
		
		TextField txtPhoneP = new TextField();
		txtPhoneP.setBounds(472, 80, 73, 23);
		layeredPanePatAdd.add(txtPhoneP);
		
		Label lblEmailP = new Label("Email");
		lblEmailP.setAlignment(Label.RIGHT);
		lblEmailP.setBounds(386, 108, 80, 22);
		layeredPanePatAdd.add(lblEmailP);
		
		TextField txtEmailP = new TextField();
		txtEmailP.setBounds(472, 108, 73, 23);
		layeredPanePatAdd.add(txtEmailP);
		
		Label lblYearP = new Label("Year of Birth");
		lblYearP.setAlignment(Label.RIGHT);
		lblYearP.setBounds(386, 136, 80, 22);
		layeredPanePatAdd.add(lblYearP);
		
		TextField txtYearP = new TextField();
		txtYearP.setBounds(472, 136, 73, 23);
		layeredPanePatAdd.add(txtYearP);
		
		JButton btnSubmitP = new JButton("Submit");
		btnSubmitP.setBounds(266, 305, 89, 23);
		layeredPanePatAdd.add(btnSubmitP);
		
		JButton btnClearP = new JButton("Clear");
		btnClearP.setBounds(365, 305, 89, 23);
		layeredPanePatAdd.add(btnClearP);
		
		JLayeredPane layeredPanePatUpdate = new JLayeredPane();
		tabbedPanePat.addTab("Update", null, layeredPanePatUpdate, null);
	}
}

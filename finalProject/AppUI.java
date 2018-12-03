package finalProject;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class AppUI {
	// fields
	JFrame frame;
	JTable tableApp;
	JTable tableDoc;
	JTable tablePat;
	DefaultTableModel modelApp;
	DefaultTableModel modelDoc;
	DefaultTableModel modelPat;
	JComboBox<Doctor> comboBoxDoc;
	JComboBox<Patient> comboBoxPat;
	JComboBox<Doctor> comboBoxPrim;
	JComboBox<Object> comboBoxTime;
	JComboBox<Object> comboBoxDate; 
	JComboBox<Doctor> comboBoxPrimPatUp;
	JList<Patient> listPat;
	DefaultListModel<Patient> listModelPat;
	JList<Doctor> listDoc;
	DefaultListModel<Doctor> listModelDoc;
	JList<Appointment> listApp;
	DefaultListModel<Appointment> listModelApp;
	/**
	 * Create the application.
	 */
	public AppUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 946, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMain.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPaneMain.setBounds(0, 0, 930, 635);
		desktopPane.add(tabbedPaneMain);
		
		/* ----- Appointments Tab ----- */
		JLayeredPane layeredPaneApp = new JLayeredPane();
		tabbedPaneMain.addTab("Appointments", null, layeredPaneApp, null);
		
		JTabbedPane tabbedPaneApp = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneApp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPaneApp.setBounds(0, 0, 925, 610);
		layeredPaneApp.add(tabbedPaneApp);
		
		/* ----- Appointments View Tab ----- */
		JLayeredPane layeredPaneAppView = new JLayeredPane();
		tabbedPaneApp.addTab("View", null, layeredPaneAppView, null);
		
		modelApp = new DefaultTableModel() {
			@Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		modelApp.addColumn("Date");
		modelApp.addColumn("Time");
		modelApp.addColumn("Reason");
		modelApp.addColumn("Doctor");
		modelApp.addColumn("Patient");
		layeredPaneAppView.setLayout(new BorderLayout());
		JScrollPane scrollPaneApp = new JScrollPane();
		layeredPaneAppView.add(scrollPaneApp, BorderLayout.CENTER);
		tableApp = new JTable(modelApp);
		tableApp.setRowHeight(20);
		tableApp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableApp.setFillsViewportHeight(true);
		scrollPaneApp.setViewportView(tableApp);
		tableApp.setBounds(125, 57, 403, 192);
		layeredPaneAppView.add(tableApp.getTableHeader(), BorderLayout.PAGE_START);
		tableApp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tableApp.getTableHeader().setReorderingAllowed(false);
		
		/* ----- Appointments Add Tab ----- */
		JLayeredPane layeredPaneAppAdd = new JLayeredPane();
		tabbedPaneApp.addTab("Add", null, layeredPaneAppAdd, null);
		
		comboBoxDate = new JComboBox<Object>();
		comboBoxDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doc2 = (Doctor) comboBoxDoc.getSelectedItem();
				if(e.getSource().equals(comboBoxDate))
				{
					if(comboBoxDate.getSelectedItem() != null)
					{
						String date = comboBoxDate.getSelectedItem().toString();
						finalProject.ProjectDriver.getTimeSched(doc2, date);
					}
				}
			}
		});
		comboBoxDate.setModel(new DefaultComboBoxModel<Object>());
		comboBoxDate.setBounds(291, 93, 152, 34);
		layeredPaneAppAdd.add(comboBoxDate);
		
		Label lblDateA = new Label("Date");
		lblDateA.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDateA.setAlignment(Label.RIGHT);
		lblDateA.setBounds(212, 93, 73, 34);
		layeredPaneAppAdd.add(lblDateA);
		
		comboBoxTime = new JComboBox<Object>();
		comboBoxTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxTime.setModel(new DefaultComboBoxModel<Object>());
		comboBoxTime.setBounds(291, 185, 152, 34);
		layeredPaneAppAdd.add(comboBoxTime);
		
		Label lblTimeA = new Label("Time");
		lblTimeA.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTimeA.setAlignment(Label.RIGHT);
		lblTimeA.setBounds(212, 185, 73, 34);
		layeredPaneAppAdd.add(lblTimeA);
		
		comboBoxDoc = new JComboBox<Doctor>();
		comboBoxDoc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doc1 = (Doctor) comboBoxDoc.getSelectedItem();
				finalProject.ProjectDriver.getDateSched(doc1);
			}
		});
		comboBoxDoc.setModel(new DefaultComboBoxModel<Doctor>());
		comboBoxDoc.setBounds(551, 93, 152, 34);
		layeredPaneAppAdd.add(comboBoxDoc);
		
		Label lblDocA = new Label("Doctor");
		lblDocA.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDocA.setAlignment(Label.RIGHT);
		lblDocA.setBounds(472, 93, 73, 34);
		layeredPaneAppAdd.add(lblDocA);
		
		comboBoxPat = new JComboBox<Patient>();
		comboBoxPat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxPat.setModel(new DefaultComboBoxModel<Patient>());
		comboBoxPat.setBounds(551, 185, 152, 34);
		layeredPaneAppAdd.add(comboBoxPat);
		
		Label lblPatA = new Label("Patient");
		lblPatA.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPatA.setAlignment(Label.RIGHT);
		lblPatA.setBounds(472, 185, 73, 34);
		layeredPaneAppAdd.add(lblPatA);
		
		TextArea txtReasonA = new TextArea();
		txtReasonA.setRows(5);
		txtReasonA.setBounds(399, 283, 225, 96);
		layeredPaneAppAdd.add(txtReasonA);
		
		Label lblReasonA = new Label("Reason");
		lblReasonA.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblReasonA.setAlignment(Label.RIGHT);
		lblReasonA.setBounds(320, 282, 73, 34);
		layeredPaneAppAdd.add(lblReasonA);
		
		JLabel lblAttentionApp = new JLabel("<html>ATTENTION: At least one patient has been added.<br/>"
				+ "Please add an appointment for the following patient first:<br/>" 
				+ "(If an appointment is not needed at this time, select Remove)</html>");
		lblAttentionApp.setBorder(new LineBorder(new Color(153, 0, 0)));
		lblAttentionApp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttentionApp.setVisible(false);
		lblAttentionApp.setForeground(new Color(153, 0, 0));
		lblAttentionApp.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAttentionApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttentionApp.setBounds(72, 0, 359, 64);
		layeredPaneAppAdd.add(lblAttentionApp);
		
		JLabel lblPatientQueueApp = new JLabel("patient");
		lblPatientQueueApp.setBorder(new LineBorder(new Color(153, 0, 0)));
		lblPatientQueueApp.setForeground(new Color(153, 0, 0));
		lblPatientQueueApp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPatientQueueApp.setVisible(false);
		lblPatientQueueApp.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPatientQueueApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientQueueApp.setBounds(494, 0, 189, 64);
		layeredPaneAppAdd.add(lblPatientQueueApp);
		
		JButton btnRemoveFromQueue = new JButton("<html>Remove<br/>&nbsp;&nbsp;&nbsp;From<br/>&nbsp;Queue</html>");
		btnRemoveFromQueue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveFromQueue.setVisible(false);
		btnRemoveFromQueue.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRemoveFromQueue.setBounds(755, 0, 92, 64);
		layeredPaneAppAdd.add(btnRemoveFromQueue);
		btnRemoveFromQueue.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				if(finalProject.ProjectDriver.patients.isEmpty())
				{
					lblAttentionApp.setVisible(false);
					lblPatientQueueApp.setVisible(false);
					btnRemoveFromQueue.setVisible(false);
				}
				else
				{
					lblPatientQueueApp.setText(finalProject.ProjectDriver.patients.peek().toString());
				}
			}
		});
		btnRemoveFromQueue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				finalProject.ProjectDriver.patients.dequeue();
				if(finalProject.ProjectDriver.patients.isEmpty())
				{
					lblAttentionApp.setVisible(false);
					lblPatientQueueApp.setVisible(false);
					btnRemoveFromQueue.setVisible(false);
				}
				else
				{
					lblPatientQueueApp.setText(finalProject.ProjectDriver.patients.peek().toString());
				}
			}
		});
		
		JButton btnSubmitA = new JButton("Submit");
		btnSubmitA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmitA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String date = comboBoxDate.getSelectedItem().toString();
				String time = comboBoxTime.getSelectedItem().toString();
				String reason = txtReasonA.getText();
				Doctor doc = (Doctor) comboBoxDoc.getSelectedItem();
				Patient pat = (Patient) comboBoxPat.getSelectedItem();
				Appointment app = new Appointment(date, time, reason, doc, pat);
				finalProject.ProjectDriver.apps.insert(app);
				finalProject.ProjectDriver.appTable();
				txtReasonA.setText(null);
				comboBoxDoc.setSelectedIndex(0);
				comboBoxPat.setSelectedIndex(0);
				comboBoxDate.setSelectedIndex(0);
				comboBoxTime.setSelectedIndex(0);
				Doctor docIndex = (Doctor) comboBoxDoc.getSelectedItem();
				finalProject.ProjectDriver.getDateSched(docIndex);
				if(!finalProject.ProjectDriver.patients.isEmpty() && finalProject.ProjectDriver.patients.peek().toString().equals(pat.toString()))
				{
					finalProject.ProjectDriver.patients.dequeue();
					if(finalProject.ProjectDriver.patients.isEmpty())
					{
						lblAttentionApp.setVisible(false);
						lblPatientQueueApp.setVisible(false);
						btnRemoveFromQueue.setVisible(false);
					}
					else
					{
						lblPatientQueueApp.setText(finalProject.ProjectDriver.patients.peek().toString());
					}
				}
			}
		});
		btnSubmitA.setBounds(243, 474, 189, 47);
		layeredPaneAppAdd.add(btnSubmitA);
		
		JButton btnClearA = new JButton("Clear");
		btnClearA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClearA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClearA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtReasonA.setText(null);
				comboBoxDoc.setSelectedIndex(0);
				comboBoxPat.setSelectedIndex(0);
				comboBoxDate.setSelectedIndex(0);
				comboBoxTime.setSelectedIndex(0);
			}
		});
		btnClearA.setBounds(492, 474, 189, 47);
		layeredPaneAppAdd.add(btnClearA);
		
		/* ----- Appointments Cancel Tab ----- */
		JLayeredPane layeredPaneAppCancel = new JLayeredPane();
		tabbedPaneApp.addTab("Cancel", null, layeredPaneAppCancel, null);
		
		Label lblDateAppCxlCurrent = new Label("");
		lblDateAppCxlCurrent.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblDateAppCxlCurrent.setAlignment(Label.CENTER);
		lblDateAppCxlCurrent.setBounds(446, 93, 152, 34);
		layeredPaneAppCancel.add(lblDateAppCxlCurrent);
		
		Label lblDateAppCxl = new Label("Date");
		lblDateAppCxl.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblDateAppCxl.setAlignment(Label.RIGHT);
		lblDateAppCxl.setBounds(367, 93, 73, 34);
		layeredPaneAppCancel.add(lblDateAppCxl);
		
		Label lblTimeAppCxlCurrent = new Label("");
		lblTimeAppCxlCurrent.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblTimeAppCxlCurrent.setAlignment(Label.CENTER);
		lblTimeAppCxlCurrent.setBounds(446, 185, 152, 34);
		layeredPaneAppCancel.add(lblTimeAppCxlCurrent);
		
		Label lblTimeAppCxl = new Label("Time");
		lblTimeAppCxl.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblTimeAppCxl.setAlignment(Label.RIGHT);
		lblTimeAppCxl.setBounds(367, 185, 73, 34);
		layeredPaneAppCancel.add(lblTimeAppCxl);
		
		Label lblDocAppCxlCurrent = new Label("");
		lblDocAppCxlCurrent.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblDocAppCxlCurrent.setAlignment(Label.CENTER);
		lblDocAppCxlCurrent.setBounds(702, 93, 152, 34);
		layeredPaneAppCancel.add(lblDocAppCxlCurrent);
		
		Label lblDocAppCxl = new Label("Doctor");
		lblDocAppCxl.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblDocAppCxl.setAlignment(Label.RIGHT);
		lblDocAppCxl.setBounds(623, 93, 73, 34);
		layeredPaneAppCancel.add(lblDocAppCxl);
		
		Label lblPatAppCxlCurrent = new Label("");
		lblPatAppCxlCurrent.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblPatAppCxlCurrent.setAlignment(Label.CENTER);
		lblPatAppCxlCurrent.setBounds(702, 185, 152, 34);
		layeredPaneAppCancel.add(lblPatAppCxlCurrent);
		
		Label lblPatAppCxl = new Label("Patient");
		lblPatAppCxl.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblPatAppCxl.setAlignment(Label.RIGHT);
		lblPatAppCxl.setBounds(623, 185, 73, 34);
		layeredPaneAppCancel.add(lblPatAppCxl);
		
		TextArea txtReasonAppCxl = new TextArea();
		txtReasonAppCxl.setRows(5);
		txtReasonAppCxl.setBounds(554, 283, 225, 96);
		layeredPaneAppCancel.add(txtReasonAppCxl);
		
		Label lblReasonAppCxl = new Label("Reason");
		lblReasonAppCxl.setFont(new Font("Diaglog", Font.PLAIN, 15));
		lblReasonAppCxl.setAlignment(Label.RIGHT);
		lblReasonAppCxl.setBounds(475, 282, 73, 34);
		layeredPaneAppCancel.add(lblReasonAppCxl);
		
		JButton btnCancelApp = new JButton("Cancel Appointment");
		btnCancelApp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelApp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Appointment appCxl = listApp.getSelectedValue();
				Appointment appFind = finalProject.ProjectDriver.apps.search(appCxl);
				if(appFind != null)
				{
					finalProject.ProjectDriver.apps.delete(appFind);
					finalProject.ProjectDriver.appTable();
				}
				listApp.clearSelection();
				lblDateAppCxlCurrent.setText(null);
				lblTimeAppCxlCurrent.setText(null);
				lblDocAppCxlCurrent.setText(null);
				lblPatAppCxlCurrent.setText(null);
				txtReasonAppCxl.setText(null);
			}
		});
		btnCancelApp.setBounds(412, 474, 189, 47);
		layeredPaneAppCancel.add(btnCancelApp);
		
		JButton btnKeepApp = new JButton("Keep Appointment");
		btnKeepApp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKeepApp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKeepApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listApp.clearSelection();
				lblDateAppCxlCurrent.setText(null);
				lblTimeAppCxlCurrent.setText(null);
				lblDocAppCxlCurrent.setText(null);
				lblPatAppCxlCurrent.setText(null);
				txtReasonAppCxl.setText(null);
			}
		});
		btnKeepApp.setBounds(665, 474, 189, 47);
		layeredPaneAppCancel.add(btnKeepApp);
		
		listModelApp = new DefaultListModel<Appointment>();
		JScrollPane scrollPaneAppCxl = new JScrollPane();
		scrollPaneAppCxl.setBounds(64, 93, 269, 428);
		layeredPaneAppCancel.add(scrollPaneAppCxl);
		listApp = new JList<Appointment>(listModelApp);
		scrollPaneAppCxl.setViewportView(listApp);
		listApp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApp.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!listApp.isSelectionEmpty())
				{
					Appointment appCxl = listApp.getSelectedValue();
					lblDateAppCxlCurrent.setText(appCxl.getDateOfAppt());
					lblTimeAppCxlCurrent.setText(appCxl.getTimeOfAppt());
					lblDocAppCxlCurrent.setText(appCxl.getApptDoctor().toString());
					lblPatAppCxlCurrent.setText(appCxl.getApptPatient().toString());
					txtReasonAppCxl.setText(appCxl.getReasonForAppt());
				}
			}
		});
		
		/* ----- Doctors Tab ----- */
		JLayeredPane layeredPaneDoc = new JLayeredPane();
		tabbedPaneMain.addTab("Doctors", null, layeredPaneDoc, null);
		
		JTabbedPane tabbedPaneDoc = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDoc.setBounds(0, 0, 925, 610);
		layeredPaneDoc.add(tabbedPaneDoc);
		
		/* ----- Doctors View Tab ----- */
		JLayeredPane layeredPaneDocView = new JLayeredPane();
		tabbedPaneDoc.addTab("View", null, layeredPaneDocView, null);
		
		modelDoc = new DefaultTableModel() {
			@Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		modelDoc.addColumn("Name");
		modelDoc.addColumn("Birth Year");
		modelDoc.addColumn("Phone");
		modelDoc.addColumn("Email");
		modelDoc.addColumn("Specialization");
		modelDoc.addColumn("Schedule");
		layeredPaneDocView.setLayout(new BorderLayout());
		JScrollPane scrollPaneDoc = new JScrollPane();
		layeredPaneDocView.add(scrollPaneDoc, BorderLayout.CENTER);
		tableDoc = new JTable(modelDoc);
		tableDoc.setRowHeight(20);
		tableDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableDoc.setFillsViewportHeight(true);
		scrollPaneDoc.setViewportView(tableDoc);
		tableDoc.setBounds(125, 57, 403, 192);
		layeredPaneDocView.add(tableDoc.getTableHeader(), BorderLayout.PAGE_START);
		tableDoc.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tableDoc.getTableHeader().setReorderingAllowed(false);
		
		/* ----- Doctors Add Tab ----- */
		JLayeredPane layeredPaneDocAdd = new JLayeredPane();
		tabbedPaneDoc.addTab("Add", null, layeredPaneDocAdd, null);
		
		TextField txtFirstD = new TextField();
		txtFirstD.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtFirstD.setBounds(291, 52, 152, 34);
		layeredPaneDocAdd.add(txtFirstD);
		
		Label lblFirstD = new Label("First Name");
		lblFirstD.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFirstD.setAlignment(Label.RIGHT);
		lblFirstD.setBounds(200, 52, 85, 34);
		layeredPaneDocAdd.add(lblFirstD);
		
		TextField txtLastD = new TextField();
		txtLastD.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLastD.setBounds(551, 52, 152, 34);
		layeredPaneDocAdd.add(txtLastD);
		
		Label lblLastD = new Label("Last Name");
		lblLastD.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLastD.setAlignment(Label.RIGHT);
		lblLastD.setBounds(460, 52, 85, 34);
		layeredPaneDocAdd.add(lblLastD);
		
		TextField txtPhoneD = new TextField();
		txtPhoneD.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPhoneD.setBounds(291, 138, 152, 34);
		layeredPaneDocAdd.add(txtPhoneD);
		
		Label lblPhoneD = new Label("Phone");
		lblPhoneD.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhoneD.setAlignment(Label.RIGHT);
		lblPhoneD.setBounds(200, 138, 85, 34);
		layeredPaneDocAdd.add(lblPhoneD);
		
		TextField txtEmailD = new TextField();
		txtEmailD.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmailD.setBounds(551, 138, 152, 34);
		layeredPaneDocAdd.add(txtEmailD);
		
		Label lblEmailD = new Label("Email");
		lblEmailD.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmailD.setAlignment(Label.RIGHT);
		lblEmailD.setBounds(460, 138, 85, 34);
		layeredPaneDocAdd.add(lblEmailD);
		
		JComboBox<Object> comboBoxYearD = new JComboBox<Object>();
		comboBoxYearD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxYearD.setModel(new DefaultComboBoxModel<Object>());
		comboBoxYearD.setBounds(551, 224, 152, 34);
		layeredPaneDocAdd.add(comboBoxYearD);
		for(int i = 2018; i >= 1900; i--)
		{
			comboBoxYearD.addItem(i);
		}
		
		Label lblYearD = new Label("Year of Birth");
		lblYearD.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblYearD.setAlignment(Label.RIGHT);
		lblYearD.setBounds(460, 224, 85, 34);
		layeredPaneDocAdd.add(lblYearD);
		
		JComboBox<Object> comboBoxSpec = new JComboBox<Object>();
		comboBoxSpec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSpec.setModel(new DefaultComboBoxModel<Object>(new String[] {"Family", "Pediatrician", "Surgeon", "Dermatologist", "Anesthesiologist", "Emergency"}));
		comboBoxSpec.setBounds(291, 224, 152, 34);
		layeredPaneDocAdd.add(comboBoxSpec);
		
		Label lblSpec = new Label("Specialty");
		lblSpec.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSpec.setAlignment(Label.RIGHT);
		lblSpec.setBounds(200, 224, 85, 34);
		layeredPaneDocAdd.add(lblSpec);
		
		Label lblSched = new Label("Schedule");
		lblSched.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSched.setAlignment(Label.RIGHT);
		lblSched.setBounds(200, 310, 85, 34);
		layeredPaneDocAdd.add(lblSched);
		
		JComboBox<Object> comboBoxSched = new JComboBox<Object>();
		comboBoxSched.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSched.setModel(new DefaultComboBoxModel<Object>(new String[] {"6AM-3PM", "7AM-4PM", "8AM-5PM", "9AM-6PM", "10AM-7PM"}));
		comboBoxSched.setBounds(291, 310, 152, 34);
		layeredPaneDocAdd.add(comboBoxSched);
		
		JButton btnSubmitD = new JButton("Submit");
		btnSubmitD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmitD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String first = txtFirstD.getText();
				String last = txtLastD.getText();
				String phone = txtPhoneD.getText();
				String email = txtEmailD.getText();
				String birthYear = comboBoxYearD.getSelectedItem().toString();
				String spec = comboBoxSpec.getSelectedItem().toString();
				String sched = comboBoxSched.getSelectedItem().toString();
				Doctor doc = new Doctor(first, last, birthYear, phone, email, spec, sched);
				finalProject.ProjectDriver.docs.insert(doc);
				finalProject.ProjectDriver.docTable();
				txtFirstD.setText(null);
				txtLastD.setText(null);
				txtPhoneD.setText(null);
				txtEmailD.setText(null);
				comboBoxYearD.setSelectedIndex(0);
				comboBoxSpec.setSelectedIndex(0);
				comboBoxSched.setSelectedIndex(0);
			}
		});
		btnSubmitD.setBounds(243, 474, 189, 47);
		layeredPaneDocAdd.add(btnSubmitD);
		
		JButton btnClearD = new JButton("Clear");
		btnClearD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClearD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClearD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstD.setText(null);
				txtLastD.setText(null);
				txtPhoneD.setText(null);
				txtEmailD.setText(null);
				comboBoxYearD.setSelectedIndex(0);
				comboBoxSpec.setSelectedIndex(0);
				comboBoxSched.setSelectedIndex(0);
			}
		});
		btnClearD.setBounds(492, 474, 189, 47);
		layeredPaneDocAdd.add(btnClearD);
		
		/* ----- Doctors Update Tab ----- */
		JLayeredPane layeredPaneDocUpdate = new JLayeredPane();
		tabbedPaneDoc.addTab("Update", null, layeredPaneDocUpdate, null);
		
		TextField txtFirstDocUp = new TextField();
		txtFirstDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtFirstDocUp.setBounds(370, 52, 152, 34);
		layeredPaneDocUpdate.add(txtFirstDocUp);
		
		Label lblFirstDocUp = new Label("First Name");
		lblFirstDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFirstDocUp.setAlignment(Label.RIGHT);
		lblFirstDocUp.setBounds(279, 52, 85, 34);
		layeredPaneDocUpdate.add(lblFirstDocUp);
		
		TextField txtLastDocUp = new TextField();
		txtLastDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLastDocUp.setBounds(702, 52, 152, 34);
		layeredPaneDocUpdate.add(txtLastDocUp);
		
		Label lblLastDocUp = new Label("Last Name");
		lblLastDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLastDocUp.setAlignment(Label.RIGHT);
		lblLastDocUp.setBounds(611, 52, 85, 34);
		layeredPaneDocUpdate.add(lblLastDocUp);
		
		TextField txtPhoneDocUp = new TextField();
		txtPhoneDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPhoneDocUp.setBounds(370, 138, 152, 34);
		layeredPaneDocUpdate.add(txtPhoneDocUp);
		
		Label lblPhoneDocUp = new Label("Phone");
		lblPhoneDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhoneDocUp.setAlignment(Label.RIGHT);
		lblPhoneDocUp.setBounds(279, 138, 85, 34);
		layeredPaneDocUpdate.add(lblPhoneDocUp);
		
		TextField txtEmailDocUp = new TextField();
		txtEmailDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmailDocUp.setBounds(702, 138, 152, 34);
		layeredPaneDocUpdate.add(txtEmailDocUp);
		
		Label lblEmailDocUp = new Label("Email");
		lblEmailDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmailDocUp.setAlignment(Label.RIGHT);
		lblEmailDocUp.setBounds(611, 138, 85, 34);
		layeredPaneDocUpdate.add(lblEmailDocUp);
		
		JComboBox<Object> comboBoxYearDocUp = new JComboBox<Object>();
		comboBoxYearDocUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxYearDocUp.setModel(new DefaultComboBoxModel<Object>());
		comboBoxYearDocUp.setBounds(702, 224, 152, 34);
		layeredPaneDocUpdate.add(comboBoxYearDocUp);
		for(int i = 2018; i >= 1900; i--)
		{
			comboBoxYearDocUp.addItem(i);
		}
		
		Label lblYearDocUp = new Label("Year of Birth");
		lblYearDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblYearDocUp.setAlignment(Label.RIGHT);
		lblYearDocUp.setBounds(611, 224, 85, 34);
		layeredPaneDocUpdate.add(lblYearDocUp);
		
		JComboBox<Object> comboBoxSpecDocUp = new JComboBox<Object>();
		comboBoxSpecDocUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSpecDocUp.setModel(new DefaultComboBoxModel<Object>(new String[] {"Family", "Pediatrician", "Surgeon", "Dermatologist", "Anesthesiologist", "Emergency"}));
		comboBoxSpecDocUp.setBounds(370, 224, 152, 34);
		layeredPaneDocUpdate.add(comboBoxSpecDocUp);
		
		Label lblSpecDocUp = new Label("Specialty");
		lblSpecDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSpecDocUp.setAlignment(Label.RIGHT);
		lblSpecDocUp.setBounds(279, 224, 85, 34);
		layeredPaneDocUpdate.add(lblSpecDocUp);
		
		Label lblSchedDocUp = new Label("Schedule");
		lblSchedDocUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSchedDocUp.setAlignment(Label.RIGHT);
		lblSchedDocUp.setBounds(279, 310, 85, 34);
		layeredPaneDocUpdate.add(lblSchedDocUp);
		
		JComboBox<Object> comboBoxSchedDocUp = new JComboBox<Object>();
		comboBoxSchedDocUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxSchedDocUp.setModel(new DefaultComboBoxModel<Object>(new String[] {"6AM-3PM", "7AM-4PM", "8AM-5PM", "9AM-6PM", "10AM-7PM"}));
		comboBoxSchedDocUp.setBounds(370, 310, 152, 34);
		layeredPaneDocUpdate.add(comboBoxSchedDocUp);
		
		JButton btnUpdateDocUp = new JButton("Update Doctor");
		btnUpdateDocUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateDocUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateDocUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String first = txtFirstDocUp.getText();
				String last = txtLastDocUp.getText();
				String phone = txtPhoneDocUp.getText();
				String email = txtEmailDocUp.getText();
				String birthYear = comboBoxYearDocUp.getSelectedItem().toString();
				String spec = comboBoxSpecDocUp.getSelectedItem().toString();
				String sched = comboBoxSchedDocUp.getSelectedItem().toString();
				Doctor doc = listDoc.getSelectedValue();
				Doctor docFind = finalProject.ProjectDriver.docs.search(doc);
				if(docFind != null)
				{
					docFind.setFirstName(first);
					docFind.setLastName(last);
					docFind.setPhone(phone);
					docFind.setEmail(email);
					docFind.setBirthYear(birthYear);
					docFind.setSpecialization(spec);
					docFind.setSchedule(sched);
					finalProject.ProjectDriver.docTable();
					finalProject.ProjectDriver.patTable();
					finalProject.ProjectDriver.appTable();
				}
				txtFirstDocUp.setText(null);
				txtLastDocUp.setText(null);
				txtPhoneDocUp.setText(null);
				txtEmailDocUp.setText(null);
				comboBoxYearDocUp.setSelectedIndex(0);
				comboBoxSpecDocUp.setSelectedIndex(0);
				comboBoxSchedDocUp.setSelectedIndex(0);
			}
		});
		btnUpdateDocUp.setBounds(348, 474, 189, 47);
		layeredPaneDocUpdate.add(btnUpdateDocUp);
		
		JButton btnCancelDocUp = new JButton("Cancel Update");
		btnCancelDocUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelDocUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelDocUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstDocUp.setText(null);
				txtLastDocUp.setText(null);
				txtPhoneDocUp.setText(null);
				txtEmailDocUp.setText(null);
				comboBoxYearDocUp.setSelectedIndex(0);
				comboBoxSpecDocUp.setSelectedIndex(0);
				comboBoxSchedDocUp.setSelectedIndex(0);
			}
		});
		btnCancelDocUp.setBounds(601, 474, 189, 47);
		layeredPaneDocUpdate.add(btnCancelDocUp);
		
		listModelDoc = new DefaultListModel<Doctor>();
		JScrollPane scrollPaneDocUp = new JScrollPane();
		scrollPaneDocUp.setBounds(64, 52, 151, 469);
		layeredPaneDocUpdate.add(scrollPaneDocUp);
		listDoc = new JList<Doctor>(listModelDoc);
		listDoc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPaneDocUp.setViewportView(listDoc);
		listDoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDoc.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!listDoc.isSelectionEmpty())
				{
					Doctor docUp = listDoc.getSelectedValue();
					txtFirstDocUp.setText(docUp.getFirstName());
					txtLastDocUp.setText(docUp.getLastName());
					txtPhoneDocUp.setText(docUp.getPhone());
					txtEmailDocUp.setText(docUp.getEmail());
					comboBoxYearDocUp.setSelectedItem(Integer.parseInt(docUp.getBirthYear()));
					comboBoxSpecDocUp.setSelectedItem(docUp.getSpecialization());
					comboBoxSchedDocUp.setSelectedItem(docUp.getSchedule());
				}
			}
		});
		
		/* ----- Patients Tab ----- */
		JLayeredPane layeredPanePat = new JLayeredPane();
		tabbedPaneMain.addTab("Patients", null, layeredPanePat, null);
		
		JTabbedPane tabbedPanePat = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePat.setBounds(0, 0, 925, 610);
		layeredPanePat.add(tabbedPanePat);
		
		/* ----- Patients View Tab ----- */
		JLayeredPane layeredPanePatView = new JLayeredPane();
		tabbedPanePat.addTab("View", null, layeredPanePatView, null);
		
		modelPat= new DefaultTableModel() {
			@Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
		};
		modelPat.addColumn("Name");
		modelPat.addColumn("Birth Year");
		modelPat.addColumn("Phone");
		modelPat.addColumn("Email");
		modelPat.addColumn("Primary Doctor");
		layeredPanePatView.setLayout(new BorderLayout());
		JScrollPane scrollPanePat = new JScrollPane();
		layeredPanePatView.add(scrollPanePat, BorderLayout.CENTER);
		tablePat = new JTable(modelPat);
		tablePat.setRowHeight(20);
		tablePat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablePat.setFillsViewportHeight(true);
		scrollPanePat.setViewportView(tablePat);
		tablePat.setBounds(125, 57, 403, 192);
		layeredPanePatView.add(tablePat.getTableHeader(), BorderLayout.PAGE_START);
		tablePat.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tablePat.getTableHeader().setReorderingAllowed(false);
		
		/* ----- Patients Add Tab ----- */
		JLayeredPane layeredPanePatAdd = new JLayeredPane();
		tabbedPanePat.addTab("Add", null, layeredPanePatAdd, null);
		
		Label lblFirstP = new Label("First Name");
		lblFirstP.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFirstP.setAlignment(Label.RIGHT);
		lblFirstP.setBounds(200, 52, 85, 34);
		layeredPanePatAdd.add(lblFirstP);
		
		TextField txtFirstP = new TextField();
		txtFirstP.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtFirstP.setBounds(291, 52, 152, 34);
		layeredPanePatAdd.add(txtFirstP);
		
		Label lblLastP = new Label("Last Name");
		lblLastP.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLastP.setAlignment(Label.RIGHT);
		lblLastP.setBounds(460, 52, 85, 34);
		layeredPanePatAdd.add(lblLastP);
		
		TextField txtLastP = new TextField();
		txtLastP.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLastP.setBounds(551, 52, 152, 34);
		layeredPanePatAdd.add(txtLastP);
		
		Label lblPhoneP = new Label("Phone");
		lblPhoneP.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhoneP.setAlignment(Label.RIGHT);
		lblPhoneP.setBounds(200, 138, 85, 34);
		layeredPanePatAdd.add(lblPhoneP);
		
		TextField txtPhoneP = new TextField();
		txtPhoneP.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPhoneP.setBounds(291, 138, 152, 34);
		layeredPanePatAdd.add(txtPhoneP);
		
		Label lblEmailP = new Label("Email");
		lblEmailP.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmailP.setAlignment(Label.RIGHT);
		lblEmailP.setBounds(460, 138, 85, 34);
		layeredPanePatAdd.add(lblEmailP);
		
		TextField txtEmailP = new TextField();
		txtEmailP.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmailP.setBounds(551, 138, 152, 34);
		layeredPanePatAdd.add(txtEmailP);
		
		Label lblYearP = new Label("Year of Birth");
		lblYearP.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblYearP.setAlignment(Label.RIGHT);
		lblYearP.setBounds(460, 224, 85, 34);
		layeredPanePatAdd.add(lblYearP);
		
		JComboBox<Object> comboBoxYearP = new JComboBox<Object>();
		comboBoxYearP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxYearP.setModel(new DefaultComboBoxModel<Object>());
		comboBoxYearP.setBounds(551, 224, 152, 34);
		layeredPanePatAdd.add(comboBoxYearP);
		for(int i = 2018; i >= 1900; i--)
		{
			comboBoxYearP.addItem(i);
		}

		comboBoxPrim = new JComboBox<Doctor>();
		comboBoxPrim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxPrim.setModel(new DefaultComboBoxModel<Doctor>());
		comboBoxPrim.setBounds(291, 224, 152, 34);
		layeredPanePatAdd.add(comboBoxPrim);
		
		Label lblPrim = new Label("Primary Dr");
		lblPrim.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPrim.setAlignment(Label.RIGHT);
		lblPrim.setBounds(200, 224, 85, 34);
		layeredPanePatAdd.add(lblPrim);
		
		JButton btnSubmitP = new JButton("Submit");
		btnSubmitP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmitP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmitP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String first = txtFirstP.getText();
				String last = txtLastP.getText();
				String phone = txtPhoneP.getText();
				String email = txtEmailP.getText();
				String birthYear = comboBoxYearP.getSelectedItem().toString();
				Doctor doc = (Doctor) comboBoxPrim.getSelectedItem();
				Patient pat = new Patient(first, last, birthYear, phone, email, doc);
				finalProject.ProjectDriver.pats.insert(pat);
				finalProject.ProjectDriver.patients.enqueue(pat);
				finalProject.ProjectDriver.patTable();
				txtFirstP.setText(null);
				txtLastP.setText(null);
				txtPhoneP.setText(null);
				txtEmailP.setText(null);
				comboBoxYearP.setSelectedIndex(0);
				comboBoxPrim.setSelectedIndex(0);
				lblAttentionApp.setVisible(true);
				lblPatientQueueApp.setVisible(true);
				btnRemoveFromQueue.setVisible(true);
			}
		});
		btnSubmitP.setBounds(243, 474, 189, 47);
		layeredPanePatAdd.add(btnSubmitP);
		
		JButton btnClearP = new JButton("Clear");
		btnClearP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClearP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClearP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstP.setText(null);
				txtLastP.setText(null);
				txtPhoneP.setText(null);
				txtEmailP.setText(null);
				comboBoxYearP.setSelectedIndex(0);
				comboBoxPrim.setSelectedIndex(0);
			}
		});
		btnClearP.setBounds(492, 474, 189, 47);
		layeredPanePatAdd.add(btnClearP);
		
		/* ----- Patients Update Tab ----- */
		JLayeredPane layeredPanePatUpdate = new JLayeredPane();
		tabbedPanePat.addTab("Update", null, layeredPanePatUpdate, null);
		layeredPanePatUpdate.setLayout(null);
		
		Label lblFirstPatUp = new Label("First Name");
		lblFirstPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFirstPatUp.setAlignment(Label.RIGHT);
		lblFirstPatUp.setBounds(279, 52, 85, 34);
		layeredPanePatUpdate.add(lblFirstPatUp);
		
		TextField txtFirstPatUp = new TextField();
		txtFirstPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtFirstPatUp.setBounds(370, 52, 152, 34);
		layeredPanePatUpdate.add(txtFirstPatUp);
		
		Label lblLastPatUp = new Label("Last Name");
		lblLastPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblLastPatUp.setAlignment(Label.RIGHT);
		lblLastPatUp.setBounds(611, 52, 85, 34);
		layeredPanePatUpdate.add(lblLastPatUp);
		
		TextField txtLastPatUp = new TextField();
		txtLastPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLastPatUp.setBounds(702, 52, 152, 34);
		layeredPanePatUpdate.add(txtLastPatUp);
		
		Label lblPhonePatUp = new Label("Phone");
		lblPhonePatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhonePatUp.setAlignment(Label.RIGHT);
		lblPhonePatUp.setBounds(279, 138, 85, 34);
		layeredPanePatUpdate.add(lblPhonePatUp);
		
		TextField txtPhonePatUp = new TextField();
		txtPhonePatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPhonePatUp.setBounds(370, 138, 152, 34);
		layeredPanePatUpdate.add(txtPhonePatUp);
		
		Label lblEmailPatUp = new Label("Email");
		lblEmailPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmailPatUp.setAlignment(Label.RIGHT);
		lblEmailPatUp.setBounds(611, 138, 85, 34);
		layeredPanePatUpdate.add(lblEmailPatUp);
		
		TextField txtEmailPatUp = new TextField();
		txtEmailPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmailPatUp.setBounds(702, 138, 152, 34);
		layeredPanePatUpdate.add(txtEmailPatUp);
		
		Label lblYearPatUp = new Label("Year of Birth");
		lblYearPatUp.setAlignment(Label.RIGHT);
		lblYearPatUp.setBounds(611, 224, 85, 34);
		layeredPanePatUpdate.add(lblYearPatUp);
		
		JComboBox<Object> comboBoxYearPatUp = new JComboBox<Object>();
		comboBoxYearPatUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxYearPatUp.setModel(new DefaultComboBoxModel<Object>());
		comboBoxYearPatUp.setBounds(702, 224, 152, 34);
		layeredPanePatUpdate.add(comboBoxYearPatUp);
		for(int i = 2018; i >= 1900; i--)
		{
			comboBoxYearPatUp.addItem(i);
		}

		comboBoxPrimPatUp = new JComboBox<Doctor>();
		comboBoxPrimPatUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxPrimPatUp.setModel(new DefaultComboBoxModel<Doctor>());
		comboBoxPrimPatUp.setBounds(370, 224, 152, 34);
		layeredPanePatUpdate.add(comboBoxPrimPatUp);
		
		Label lblPrimPatUp = new Label("Primary Dr");
		lblPrimPatUp.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPrimPatUp.setAlignment(Label.RIGHT);
		lblPrimPatUp.setBounds(279, 224, 85, 34);
		layeredPanePatUpdate.add(lblPrimPatUp);
		
		JButton btnUpdatePatUp = new JButton("Update Patient");
		btnUpdatePatUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdatePatUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdatePatUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String first = txtFirstPatUp.getText();
				String last = txtLastPatUp.getText();
				String phone = txtPhonePatUp.getText();
				String email = txtEmailPatUp.getText();
				String birthYear = comboBoxYearPatUp.getSelectedItem().toString();
				Doctor doc = (Doctor) comboBoxPrimPatUp.getSelectedItem();
				Patient patUp = listPat.getSelectedValue();
				Patient patFind = finalProject.ProjectDriver.pats.search(patUp);
				if(patFind != null)
				{
					patFind.setFirstName(first);
					patFind.setLastName(last);
					patFind.setPhone(phone);
					patFind.setEmail(email);
					patFind.setBirthYear(birthYear);
					patFind.setPrimaryDr(doc);
					finalProject.ProjectDriver.patTable();
					finalProject.ProjectDriver.docTable();
					finalProject.ProjectDriver.appTable();
				}
				if(!finalProject.ProjectDriver.patients.isEmpty())
				{
					lblPatientQueueApp.setText(finalProject.ProjectDriver.patients.peek().toString());
				}
				listPat.clearSelection();
				txtFirstPatUp.setText(null);
				txtLastPatUp.setText(null);
				txtPhonePatUp.setText(null);
				txtEmailPatUp.setText(null);
				comboBoxYearPatUp.setSelectedIndex(0);
				comboBoxPrimPatUp.setSelectedItem(null);
			}
		});
		btnUpdatePatUp.setBounds(348, 474, 189, 47);
		layeredPanePatUpdate.add(btnUpdatePatUp);
		
		JButton btnCancelPatUp = new JButton("Cancel Update");
		btnCancelPatUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelPatUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelPatUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listPat.clearSelection();
				txtFirstPatUp.setText(null);
				txtLastPatUp.setText(null);
				txtPhonePatUp.setText(null);
				txtEmailPatUp.setText(null);
				comboBoxYearPatUp.setSelectedIndex(0);
				comboBoxPrimPatUp.setSelectedItem(null);
			}
		});
		btnCancelPatUp.setBounds(601, 474, 189, 47);
		layeredPanePatUpdate.add(btnCancelPatUp);
		
		listModelPat = new DefaultListModel<Patient>();
		JScrollPane scrollPanePatUp = new JScrollPane();
		scrollPanePatUp.setBounds(64, 52, 151, 469);
		layeredPanePatUpdate.add(scrollPanePatUp);
		listPat = new JList<Patient>(listModelPat);
		listPat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPanePatUp.setViewportView(listPat);
		listPat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPat.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(!listPat.isSelectionEmpty())
				{
					Patient patUp = listPat.getSelectedValue();
					txtFirstPatUp.setText(patUp.getFirstName());
					txtLastPatUp.setText(patUp.getLastName());
					txtPhonePatUp.setText(patUp.getPhone());
					txtEmailPatUp.setText(patUp.getEmail());
					comboBoxYearPatUp.setSelectedItem(Integer.parseInt(patUp.getBirthYear()));
					comboBoxPrimPatUp.setSelectedItem(patUp.getPrimaryDr());
				}
			}
		});
	}
}

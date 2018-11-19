package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.ButtonGroup;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class AppointmentUI {

	private JFrame frmSchedulingSystem;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentUI window = new AppointmentUI();
					window.frmSchedulingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppointmentUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSchedulingSystem = new JFrame();
		frmSchedulingSystem.setTitle("Scheduling System");
		frmSchedulingSystem.setBounds(100, 100, 729, 550);
		frmSchedulingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmSchedulingSystem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
		);
		JLayeredPane layeredPaneA = new JLayeredPane();
		tabbedPane.addTab("Appointments", null, layeredPaneA, null);
		layeredPaneA.setLayout(null);
		
		TextField txtFirstA = new TextField();
		txtFirstA.setBounds(279, 80, 73, 23);
		layeredPaneA.add(txtFirstA);
		
		Label lblFirstA = new Label("First Name");
		lblFirstA.setBounds(203, 80, 70, 22);
		layeredPaneA.add(lblFirstA);
		lblFirstA.setVisible(false);
		lblFirstA.setAlignment(Label.RIGHT);
		
		Label lblLastA = new Label("Last Name");
		lblLastA.setBounds(203, 109, 70, 22);
		layeredPaneA.add(lblLastA);
		lblLastA.setVisible(false);
		lblLastA.setAlignment(Label.RIGHT);
		
		TextField txtLastA = new TextField();
		txtLastA.setBounds(279, 109, 73, 23);
		layeredPaneA.add(txtLastA);
		
		Label lblPhoneA = new Label("Phone");
		lblPhoneA.setBounds(386, 80, 80, 22);
		layeredPaneA.add(lblPhoneA);
		lblPhoneA.setVisible(false);
		lblPhoneA.setAlignment(Label.RIGHT);
		
		TextField txtPhoneA = new TextField();
		txtPhoneA.setBounds(472, 80, 73, 23);
		layeredPaneA.add(txtPhoneA);
		
		Label lblEmailA = new Label("Email");
		lblEmailA.setBounds(386, 108, 80, 22);
		layeredPaneA.add(lblEmailA);
		lblEmailA.setVisible(false);
		lblEmailA.setAlignment(Label.RIGHT);
		
		TextField txtEmailA = new TextField();
		txtEmailA.setBounds(472, 108, 73, 23);
		layeredPaneA.add(txtEmailA);
		
		Label lblYearA = new Label("Year of Birth");
		lblYearA.setBounds(386, 136, 80, 22);
		layeredPaneA.add(lblYearA);
		lblYearA.setVisible(false);
		lblYearA.setAlignment(Label.RIGHT);
		
		TextField txtYearA = new TextField();
		txtYearA.setBounds(472, 136, 73, 23);
		layeredPaneA.add(txtYearA);
		
		Panel panelA = new Panel();
		panelA.setBounds(192, 63, 459, 358);
		layeredPaneA.add(panelA);
		GroupLayout gl_panelA = new GroupLayout(panelA);
		gl_panelA.setHorizontalGroup(
				gl_panelA.createParallelGroup(Alignment.LEADING)
				.addGap(86)
		);
		gl_panelA.setVerticalGroup(
				gl_panelA.createParallelGroup(Alignment.LEADING)
				.addGap(128)
		);
		panelA.setLayout(gl_panelA);
		GroupLayout gl_panelP = new GroupLayout(panelA);
		gl_panelP.setHorizontalGroup(
				gl_panelP.createParallelGroup(Alignment.LEADING)
				.addGap(86)
		);
		gl_panelP.setVerticalGroup(
				gl_panelP.createParallelGroup(Alignment.LEADING)
				.addGap(128)
		);
		panelA.setLayout(gl_panelP);
		
		JRadioButton rdbViewA = new JRadioButton("View");
		rdbViewA.setBounds(27, 115, 109, 23);
		layeredPaneA.add(rdbViewA);
		
		JRadioButton rdbAddA = new JRadioButton("Add");
		rdbAddA.setBounds(27, 141, 109, 23);
		layeredPaneA.add(rdbAddA);
		
		JRadioButton rdbRemoveA = new JRadioButton("Remove");
		rdbRemoveA.setBounds(27, 167, 109, 23);
		layeredPaneA.add(rdbRemoveA);
		txtYearA.setVisible(false);
		txtEmailA.setVisible(false);
		txtPhoneA.setVisible(false);
		txtLastA.setVisible(false);
		txtFirstA.setVisible(false);
		
		/*---- Doctors tab ----*/
		JLayeredPane layeredPaneD = new JLayeredPane();
		tabbedPane.addTab("Doctors", null, layeredPaneD, null);
		
		TextField txtFirstD = new TextField();
		txtFirstD.setVisible(false);
		txtFirstD.setBounds(279, 80, 73, 23);
		layeredPaneD.add(txtFirstD);
		
		Label lblFirstD = new Label("First Name");
		lblFirstD.setVisible(false);
		lblFirstD.setAlignment(Label.RIGHT);
		lblFirstD.setBounds(203, 80, 70, 22);
		layeredPaneD.add(lblFirstD);
		
		TextField txtLastD = new TextField();
		txtLastD.setVisible(false);
		txtLastD.setBounds(279, 109, 73, 23);
		layeredPaneD.add(txtLastD);
		
		Label lblLastD = new Label("Last Name");
		lblLastD.setVisible(false);
		lblLastD.setAlignment(Label.RIGHT);
		lblLastD.setBounds(203, 109, 70, 22);
		layeredPaneD.add(lblLastD);
		
		TextField txtPhoneD = new TextField();
		txtPhoneD.setVisible(false);
		txtPhoneD.setBounds(472, 80, 73, 23);
		layeredPaneD.add(txtPhoneD);
		
		Label lblPhoneD = new Label("Phone");
		lblPhoneD.setVisible(false);
		lblPhoneD.setAlignment(Label.RIGHT);
		lblPhoneD.setBounds(386, 80, 80, 22);
		layeredPaneD.add(lblPhoneD);
		
		TextField txtEmailD = new TextField();
		txtEmailD.setVisible(false);
		txtEmailD.setBounds(472, 108, 73, 23);
		layeredPaneD.add(txtEmailD);
		
		Label lblEmailD = new Label("Email");
		lblEmailD.setVisible(false);
		lblEmailD.setAlignment(Label.RIGHT);
		lblEmailD.setBounds(386, 108, 80, 22);
		layeredPaneD.add(lblEmailD);
		
		TextField txtYearD = new TextField();
		txtYearD.setVisible(false);
		txtYearD.setBounds(472, 136, 73, 23);
		layeredPaneD.add(txtYearD);
		
		Label lblYearD = new Label("Year of Birth");
		lblYearD.setVisible(false);
		lblYearD.setAlignment(Label.RIGHT);
		lblYearD.setBounds(386, 136, 80, 22);
		layeredPaneD.add(lblYearD);
		
		TextField txtSpec = new TextField();
		txtSpec.setVisible(false);
		txtSpec.setBounds(279, 167, 73, 23);
		layeredPaneD.add(txtSpec);
		
		Label lblSpec = new Label("Specialty");
		lblSpec.setVisible(false);
		lblSpec.setAlignment(Label.RIGHT);
		lblSpec.setBounds(203, 167, 70, 22);
		layeredPaneD.add(lblSpec);
		
		Label lblSched = new Label("Schedule");
		lblSched.setVisible(false);
		lblSched.setAlignment(Label.RIGHT);
		lblSched.setBounds(203, 202, 70, 22);
		layeredPaneD.add(lblSched);
		
		Panel panelD = new Panel();
		panelD.setBounds(192, 63, 459, 358);
		layeredPaneD.add(panelD);
		
		JList list = new JList();
		list.setVisible(false);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"6AM-3PM", "7AM-4PM", "8AM-5PM", "9AM-6PM", "10AM-7PM"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_panelD = new GroupLayout(panelD);
		gl_panelD.setHorizontalGroup(
				gl_panelD.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelD.createSequentialGroup()
					.addGap(86)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(300, Short.MAX_VALUE))
		);
		gl_panelD.setVerticalGroup(
				gl_panelD.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelD.createSequentialGroup()
					.addContainerGap(139, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(128))
		);
		panelD.setLayout(gl_panelD);
		
		JRadioButton rdbtnViewD = new JRadioButton("View");
		buttonGroup.add(rdbtnViewD);
		rdbtnViewD.setBounds(27, 115, 109, 23);
		layeredPaneD.add(rdbtnViewD);
		
		JRadioButton rdbtnAddD = new JRadioButton("Add");
		rdbtnAddD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtFirstD.setVisible(false);
				lblFirstD.setVisible(false);
				lblLastD.setVisible(false);
				txtPhoneD.setVisible(false);
				lblPhoneD.setVisible(false);
				txtEmailD.setVisible(false);
				lblEmailD.setVisible(false);
				txtYearD.setVisible(false);
				lblYearD.setVisible(false);
				txtSpec.setVisible(false);
				lblSpec.setVisible(false); 
				lblSched.setVisible(false);
				list.setVisible(false);
			}
		});
		rdbtnAddD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstD.setVisible(true);
				lblFirstD.setVisible(true);
				lblLastD.setVisible(true);
				txtPhoneD.setVisible(true);
				lblPhoneD.setVisible(true);
				txtEmailD.setVisible(true);
				lblEmailD.setVisible(true);
				txtYearD.setVisible(true);
				lblYearD.setVisible(true);
				txtSpec.setVisible(true);
				lblSpec.setVisible(true); 
				lblSched.setVisible(true);
				list.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnAddD);
		rdbtnAddD.setBounds(27, 141, 109, 23);
		layeredPaneD.add(rdbtnAddD);
		
		JRadioButton rdbtnRemoveD = new JRadioButton("Remove");
		buttonGroup.add(rdbtnRemoveD);
		rdbtnRemoveD.setBounds(27, 167, 109, 23);
		layeredPaneD.add(rdbtnRemoveD);
		
		/*---- Patients tab ----*/
		JLayeredPane layeredPaneP = new JLayeredPane();
		tabbedPane.addTab("Patients", null, layeredPaneP, null);
		
		TextField txtFirstP = new TextField();
		txtFirstP.setVisible(false);
		txtFirstP.setBounds(279, 80, 73, 23);
		layeredPaneP.add(txtFirstP);
		
		Label lblFirstP = new Label("First Name");
		lblFirstP.setVisible(false);
		lblFirstP.setAlignment(Label.RIGHT);
		lblFirstP.setBounds(203, 80, 70, 22);
		layeredPaneP.add(lblFirstP);
		
		Label lblLastP = new Label("Last Name");
		lblLastP.setVisible(false);
		lblLastP.setAlignment(Label.RIGHT);
		lblLastP.setBounds(203, 109, 70, 22);
		layeredPaneP.add(lblLastP);
		
		TextField txtLastP = new TextField();
		txtLastP.setVisible(false);
		txtLastP.setBounds(279, 109, 73, 23);
		layeredPaneP.add(txtLastP);
		
		Label lblPhoneP = new Label("Phone");
		lblPhoneP.setVisible(false);
		lblPhoneP.setAlignment(Label.RIGHT);
		lblPhoneP.setBounds(386, 80, 80, 22);
		layeredPaneP.add(lblPhoneP);
		
		TextField txtPhoneP = new TextField();
		txtPhoneP.setVisible(false);
		txtPhoneP.setBounds(472, 80, 73, 23);
		layeredPaneP.add(txtPhoneP);
		
		Label lblEmailP = new Label("Email");
		lblEmailP.setVisible(false);
		lblEmailP.setAlignment(Label.RIGHT);
		lblEmailP.setBounds(386, 108, 80, 22);
		layeredPaneP.add(lblEmailP);
		
		TextField txtEmailP = new TextField();
		txtEmailP.setVisible(false);
		txtEmailP.setBounds(472, 108, 73, 23);
		layeredPaneP.add(txtEmailP);
		
		Label lblYearP = new Label("Year of Birth");
		lblYearP.setVisible(false);
		lblYearP.setAlignment(Label.RIGHT);
		lblYearP.setBounds(386, 136, 80, 22);
		layeredPaneP.add(lblYearP);
		
		TextField txtYearP = new TextField();
		txtYearP.setVisible(false);
		txtYearP.setBounds(472, 136, 73, 23);
		layeredPaneP.add(txtYearP);
		
		Panel panelP = new Panel();
		panelP.setBounds(192, 63, 459, 358);
		layeredPaneP.add(panelP);
		
		JRadioButton rdbViewP = new JRadioButton("View");
		rdbViewP.setBounds(27, 115, 109, 23);
		layeredPaneP.add(rdbViewP);
		
		JRadioButton rdbAddP = new JRadioButton("Add");
		rdbAddP.setBounds(27, 141, 109, 23);
		layeredPaneP.add(rdbAddP);
		
		JRadioButton rdbRemoveP = new JRadioButton("Remove");
		rdbRemoveP.setBounds(27, 167, 109, 23);
		layeredPaneP.add(rdbRemoveP);
	}
}

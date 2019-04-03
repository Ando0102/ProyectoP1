package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.toedter.calendar.JCalendar;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;

public class VentanaDoctor_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JTextField txtCorreoElect;
	private JPanel panel_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel btnSiguiente;
	public JDateChooser dcFechaNacimiento;
	public JComboBox cbxPais;
	public JComboBox cbxGenero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaDoctor_admin dialog = new VentanaDoctor_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaDoctor_admin() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDoctor_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Doctor");
		setBounds(100, 100, 668, 551);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(230, 230, 250));
		panel.add(tabbedPane, BorderLayout.CENTER);
		
				//  Define a keyword attribute
		
				
				
				panel_2 = new JPanel();
				panel_2.setBackground(new Color(230, 230, 250));
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				tabbedPane.addTab("Agregar Nuevo Doctor", null, panel_2, null);
				
				JLabel label_5 = new JLabel("");
				label_5.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/plus_15650.png")));
				label_5.setBounds(468, 134, 64, 74);
				panel_2.add(label_5);
				
				JLabel label = new JLabel("Nombres :");
				label.setBounds(29, 28, 72, 22);
				panel_2.add(label);
				
				JLabel label_1 = new JLabel("Apellidos :");
				label_1.setBounds(234, 28, 93, 18);
				panel_2.add(label_1);
				
				JLabel label_2 = new JLabel("Cedula :");
				label_2.setBounds(234, 83, 64, 18);
				panel_2.add(label_2);
				
				JLabel label_3 = new JLabel("Tel\u00E9fono :");
				label_3.setBounds(29, 83, 72, 18);
				panel_2.add(label_3);
				
				JLabel label_4 = new JLabel("Direcci\u00F3n :");
				label_4.setBounds(29, 142, 72, 16);
				panel_2.add(label_4);
				
				JLabel lblSexo = new JLabel("Sexo :");
				lblSexo.setBounds(29, 272, 72, 14);
				panel_2.add(lblSexo);
				
				JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen :");
				lblPasDeOrigen.setBounds(206, 272, 98, 20);
				panel_2.add(lblPasDeOrigen);
				
				JLabel label_7 = new JLabel("Correo El\u00E9ctronico :");
				label_7.setBounds(29, 200, 145, 20);
				panel_2.add(label_7);
				
				JLabel label_8 = new JLabel("Fecha de Nacimiento :");
				label_8.setBounds(29, 333, 125, 14);
				panel_2.add(label_8);
				
				JLabel label_12 = new JLabel("");
				label_12.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctor.png")));
				label_12.setBounds(498, 83, 99, 103);
				panel_2.add(label_12);
				
				
				JLabel label_13 = new JLabel("");
				label_13.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
				label_13.setBounds(429, 80, 93, 109);
				panel_2.add(label_13);
				
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(29, 107, 135, 20);
				panel_2.add(txtTelefono);
				
				txtCedula = new JTextField();
				txtCedula.setColumns(10);
				txtCedula.setBounds(234, 107, 135, 20);
				panel_2.add(txtCedula);
				
				txtApellido = new JTextField();
				txtApellido.setColumns(10);
				txtApellido.setBounds(234, 52, 135, 20);
				panel_2.add(txtApellido);
				
				cbxPais = new JComboBox();
				cbxPais.setBackground(new Color(240, 248, 255));
				cbxPais.setMaximumRowCount(5);
				cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
				cbxPais.setSelectedIndex(0);
				cbxPais.setBounds(211, 297, 135, 20);
				panel_2.add(cbxPais);
				
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(29, 169, 340, 20);
				panel_2.add(txtDireccion);
				
				dcFechaNacimiento = new JDateChooser();
				dcFechaNacimiento.setBounds(29, 360, 135, 20);
				panel_2.add(dcFechaNacimiento);
				
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(29, 56, 135, 20);
				panel_2.add(txtNombre);
				
				cbxGenero = new JComboBox();
				cbxGenero.setBackground(new Color(240, 248, 255));
				cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Sexo>", "Masculino", "Femenino"}));
				cbxGenero.setSelectedIndex(0);
				cbxGenero.setBounds(29, 297, 135, 20);
				panel_2.add(cbxGenero);
				
				txtCorreoElect = new JTextField();
				txtCorreoElect.setColumns(10);
				txtCorreoElect.setBounds(29, 231, 340, 20);
				panel_2.add(txtCorreoElect);
				
				JButton btnNewButton = new JButton("Siguiente");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						PanelSeguridadDoct aux = new PanelSeguridadDoct(txtApellido, txtCedula, txtCorreoElect, txtDireccion, txtNombre, txtTelefono, cbxGenero, cbxPais, dcFechaNacimiento);
						aux.setVisible(true);
						dispose();
					}
				});
				btnNewButton.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
				btnNewButton.setBounds(496, 425, 127, 34);
				panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Modificar Doctor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 213, 613, 246);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
		lblNewLabel_3.setBounds(500, 89, 83, 72);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(10, 32, 71, 19);
		panel_4.add(lblNombre);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setBounds(20, 56, 130, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(182, 34, 83, 14);
		panel_4.add(lblApellidos);
		
		textField_9 = new JTextField();
		textField_9.setBounds(192, 56, 130, 20);
		panel_4.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setBounds(358, 34, 83, 19);
		panel_4.add(lblTelfono);
		
		textField_10 = new JTextField();
		textField_10.setBounds(368, 56, 122, 20);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCorreoElctronico = new JLabel("Correo El\u00E9ctronico :");
		lblCorreoElctronico.setBounds(10, 87, 174, 20);
		panel_4.add(lblCorreoElctronico);
		
		textField_11 = new JTextField();
		textField_11.setBounds(20, 115, 302, 20);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n :");
		lblDireccin.setBounds(10, 146, 93, 19);
		panel_4.add(lblDireccin);
		
		textField_12 = new JTextField();
		textField_12.setBounds(20, 176, 302, 20);
		panel_4.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/edit_pencil_6320 (1).png")));
		btnModificar.setBounds(473, 178, 130, 41);
		panel_4.add(btnModificar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		lblNewLabel_2.setBounds(518, 44, 76, 96);
		panel_4.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 613, 191);
		panel_3.add(scrollPane);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}

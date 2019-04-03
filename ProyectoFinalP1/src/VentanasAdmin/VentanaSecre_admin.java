package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;
import Logical.Secretaria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSecre_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElect;
	private JPanel panelAgregar;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private int cantidadSecretarias = 0;
	private JComboBox cbxPais;
	private JComboBox cbxGenero;
	private JDateChooser dcFechaNacimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaSecre_admin dialog = new VentanaSecre_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaSecre_admin() {
		setTitle("Informaci\u00F3n de Secretaria");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSecre_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 617, 541);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBackground(new Color(230, 230, 250));
				panel.add(tabbedPane, BorderLayout.CENTER);
				{
					panelAgregar = new JPanel();
					panelAgregar.setBackground(new Color(230, 230, 250));
					panelAgregar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de la Nueva Secretaria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					tabbedPane.addTab("Agregar Nueva Secretaria", null, panelAgregar, null);
					panelAgregar.setLayout(null);
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/plus_15650.png")));
						lblNewLabel_1.setBounds(432, 142, 72, 67);
						panelAgregar.add(lblNewLabel_1);
					}
					{
						JLabel label = new JLabel("Nombres :");
						label.setBounds(36, 36, 72, 22);
						panelAgregar.add(label);
					}
					{
						txtNombre = new JTextField();
						txtNombre.setColumns(10);
						txtNombre.setBounds(36, 64, 158, 20);
						panelAgregar.add(txtNombre);
					}
					{
						JLabel label = new JLabel("Apellidos :");
						label.setBounds(218, 40, 93, 18);
						panelAgregar.add(label);
					}
					{
						txtApellido = new JTextField();
						txtApellido.setColumns(10);
						txtApellido.setBounds(218, 64, 158, 20);
						panelAgregar.add(txtApellido);
					}
					{
						JLabel label = new JLabel("Cedula :");
						label.setBounds(36, 106, 64, 18);
						panelAgregar.add(label);
					}
					{
						txtCedula = new JTextField();
						txtCedula.setColumns(10);
						txtCedula.setBounds(36, 130, 158, 20);
						panelAgregar.add(txtCedula);
					}
					{
						JLabel label = new JLabel("Tel\u00E9fono :");
						label.setBounds(218, 101, 72, 18);
						panelAgregar.add(label);
					}
					{
						txtTelefono = new JTextField();
						txtTelefono.setColumns(10);
						txtTelefono.setBounds(218, 130, 158, 20);
						panelAgregar.add(txtTelefono);
					}
					{
						JLabel label = new JLabel("Direcci\u00F3n :");
						label.setBounds(36, 161, 72, 16);
						panelAgregar.add(label);
					}
					{
						txtDireccion = new JTextField();
						txtDireccion.setColumns(10);
						txtDireccion.setBounds(36, 189, 340, 20);
						panelAgregar.add(txtDireccion);
					}
					{
						JLabel lblSexo = new JLabel("Sexo :");
						lblSexo.setBounds(36, 297, 72, 14);
						panelAgregar.add(lblSexo);
					}
					{
						cbxGenero = new JComboBox();
						cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Sexo>", "Masculino", "Femenino"}));
						cbxGenero.setSelectedIndex(0);
						cbxGenero.setBounds(36, 322, 158, 20);
						panelAgregar.add(cbxGenero);
					}
					{
						JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen :");
						lblPasDeOrigen.setBounds(218, 297, 98, 20);
						panelAgregar.add(lblPasDeOrigen);
					}
					{
						cbxPais = new JComboBox();
						cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
						cbxPais.setSelectedIndex(0);
						cbxPais.setMaximumRowCount(5);
						cbxPais.setBounds(218, 322, 158, 20);
						panelAgregar.add(cbxPais);
					}
					{
						JLabel label = new JLabel("Correo El\u00E9ctronico :");
						label.setBounds(36, 220, 145, 20);
						panelAgregar.add(label);
					}
					{
						txtCorreoElect = new JTextField();
						txtCorreoElect.setColumns(10);
						txtCorreoElect.setBounds(36, 251, 340, 20);
						panelAgregar.add(txtCorreoElect);
					}
					{
						JLabel label = new JLabel("Fecha de Nacimiento :");
						label.setBounds(36, 365, 125, 14);
						panelAgregar.add(label);
					}
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/teacher_128_44171.png")));
						lblNewLabel.setBounds(432, 64, 125, 128);
						panelAgregar.add(lblNewLabel);
					}
					
					dcFechaNacimiento = new JDateChooser();
					dcFechaNacimiento.setBounds(36, 392, 158, 20);
					panelAgregar.add(dcFechaNacimiento);
					{
						JButton btnNewButton = new JButton("Siguiente");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								PanelSeguridadSecre aux = new PanelSeguridadSecre(txtApellido, txtCedula, txtCorreoElect, txtDireccion, txtNombre, txtTelefono, cbxGenero, cbxPais, dcFechaNacimiento);
								aux.setVisible(true);
							}
						});
						btnNewButton.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
						btnNewButton.setBounds(451, 412, 125, 41);
						panelAgregar.add(btnNewButton);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(230, 230, 250));
					tabbedPane.addTab("Modificar Secretaria", null, panel_1, null);
					panel_1.setLayout(null);
					{
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(new Color(230, 230, 250));
						panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de la Secretaria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						panel_2.setBounds(10, 185, 566, 268);
						panel_1.add(panel_2);
						panel_2.setLayout(null);
						{
							JLabel label = new JLabel("");
							label.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
							label.setBounds(413, 135, 93, 70);
							panel_2.add(label);
						}
						{
							JLabel label = new JLabel("Nombres :");
							label.setBounds(10, 23, 71, 19);
							panel_2.add(label);
						}
						{
							textField_8 = new JTextField();
							textField_8.setColumns(10);
							textField_8.setBounds(10, 53, 130, 20);
							panel_2.add(textField_8);
						}
						{
							JLabel label = new JLabel("Apellidos :");
							label.setBounds(182, 28, 83, 14);
							panel_2.add(label);
						}
						{
							textField_9 = new JTextField();
							textField_9.setColumns(10);
							textField_9.setBounds(182, 53, 130, 20);
							panel_2.add(textField_9);
						}
						{
							JLabel label = new JLabel("Tel\u00E9fono :");
							label.setBounds(348, 24, 83, 19);
							panel_2.add(label);
						}
						{
							textField_10 = new JTextField();
							textField_10.setColumns(10);
							textField_10.setBounds(348, 53, 130, 20);
							panel_2.add(textField_10);
						}
						{
							JLabel label = new JLabel("Correo El\u00E9ctronico :");
							label.setBounds(10, 135, 174, 20);
							panel_2.add(label);
						}
						{
							textField_11 = new JTextField();
							textField_11.setColumns(10);
							textField_11.setBounds(10, 105, 302, 20);
							panel_2.add(textField_11);
						}
						{
							JLabel label = new JLabel("Direcci\u00F3n :");
							label.setBounds(10, 84, 93, 19);
							panel_2.add(label);
						}
						{
							textField_12 = new JTextField();
							textField_12.setColumns(10);
							textField_12.setBounds(10, 166, 302, 20);
							panel_2.add(textField_12);
						}
						{
							JLabel lblNewLabel_5 = new JLabel("");
							lblNewLabel_5.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/secretaria.png")));
							lblNewLabel_5.setBounds(439, 105, 93, 86);
							panel_2.add(lblNewLabel_5);
						}
						{
							JButton btnNewButton_1 = new JButton("Cancelar\r\n");
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								}
							});
							btnNewButton_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/cancelar2.png")));
							btnNewButton_1.setBounds(423, 216, 130, 36);
							panel_2.add(btnNewButton_1);
						}
						{
							JButton btnNewButton_2 = new JButton("Listo");
							btnNewButton_2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								}
							});
							btnNewButton_2.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/acceptar.png")));
							btnNewButton_2.setBounds(286, 216, 130, 36);
							panel_2.add(btnNewButton_2);
						}
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 11, 566, 152);
						panel_1.add(scrollPane);
					}
				}
			}
		}
	}
}

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

public class VentanaSecre_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElect;
	private JTextField txtanos;
	private JPanel panelAgregar;
	private JPanel panelSegurida;
	private JTextField txtUsuario;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel lblNewLabel_3;
	private int cantidadSecretarias = 0;
	private JSpinner spinDias;
	private JComboBox cbxMeses;
	private JComboBox cbxPais;
	private JComboBox cbxGenero;

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
		setBounds(100, 100, 781, 465);
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
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(230, 230, 250));
					tabbedPane.addTab("Información General", null, panel_1, null);
					panel_1.setLayout(null);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 46, 730, 261);
					panel_1.add(scrollPane);
				}
				{
					panelAgregar = new JPanel();
					panelAgregar.setBackground(new Color(230, 230, 250));
					panelAgregar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de la Nueva Secretaria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					tabbedPane.addTab("Agregar Nueva Secretaria", null, panelAgregar, null);
					panelAgregar.setLayout(null);
					
					panelSegurida = new JPanel();
					panelSegurida.setBorder(new TitledBorder(null, "Informaci\u00F3n de la Nueva Secretaria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelSegurida.setBackground(new Color(230, 230, 250));
					panelSegurida.setBounds(0, 0, 750, 388);
					panelSegurida.setVisible(false);
					panelAgregar.add(panelSegurida);
					panelSegurida.setLayout(null);
					
					JLabel lblNewLabel_4 = new JLabel("");
					lblNewLabel_4.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							panelSegurida.setVisible(false);
							panelAgregar.setVisible(true);
						}
					});
					lblNewLabel_4.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/atraspeque\u00F1a.png")));
					lblNewLabel_4.setBounds(634, 334, 44, 54);
					panelSegurida.add(lblNewLabel_4);
					
					JTextPane txtpnEstimadaSecretairaPor = new JTextPane();
					txtpnEstimadaSecretairaPor.setText("Estimada Secretaria. Por este medio se le informa que la siguiente informaci\u00F3n que usted mismo sumistrar\u00E1 a continuaci\u00F3n, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie est\u00E1 informaci\u00F3n, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber est\u00E1 informaci\u00F3n a demas de usted. Es su deber como profesional y miembro de est\u00E1 instituci\u00F3n cumplir esta normal. ");
					txtpnEstimadaSecretairaPor.setFont(new Font("Tahoma", Font.PLAIN, 12));
					txtpnEstimadaSecretairaPor.setEditable(false);
					txtpnEstimadaSecretairaPor.setBackground(new Color(230, 230, 250));
					txtpnEstimadaSecretairaPor.setBounds(182, 46, 399, 126);
					panelSegurida.add(txtpnEstimadaSecretairaPor);
					
					JLabel label_1 = new JLabel("");
					label_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/Escudo.png")));
					label_1.setBounds(634, 41, 115, 161);
					panelSegurida.add(label_1);
					
					JLabel label_2 = new JLabel("");
					label_2.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/LogoGrande.png")));
					label_2.setBounds(10, 46, 128, 161);
					panelSegurida.add(label_2);
					
					JLabel label_3 = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
					label_3.setBounds(255, 188, 162, 14);
					panelSegurida.add(label_3);
					
					txtUsuario = new JTextField();
					txtUsuario.setColumns(10);
					txtUsuario.setBounds(265, 213, 150, 20);
					panelSegurida.add(txtUsuario);
					
					JLabel label_4 = new JLabel("Contrase\u00F1a :");
					label_4.setBounds(255, 244, 100, 14);
					panelSegurida.add(label_4);
					
					passwordField1 = new JPasswordField();
					passwordField1.setBounds(265, 269, 152, 20);
					panelSegurida.add(passwordField1);
					
					JLabel label_5 = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
					label_5.setBounds(255, 300, 179, 14);
					panelSegurida.add(label_5);
					
					passwordField2 = new JPasswordField();
					passwordField2.setBounds(265, 325, 152, 20);
					panelSegurida.add(passwordField2);
					{
						lblNewLabel_3 = new JLabel("");
						lblNewLabel_3.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/acceptar.png")));
						lblNewLabel_3.setBounds(688, 334, 61, 54);
						panelSegurida.add(lblNewLabel_3);
					}
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/plus_15650.png")));
						lblNewLabel_1.setBounds(523, 239, 72, 67);
						panelAgregar.add(lblNewLabel_1);
					}
					{
						JLabel label = new JLabel("Nombres :");
						label.setBounds(10, 36, 72, 22);
						panelAgregar.add(label);
					}
					{
						txtNombre = new JTextField();
						txtNombre.setColumns(10);
						txtNombre.setBounds(20, 64, 135, 20);
						panelAgregar.add(txtNombre);
					}
					{
						JLabel label = new JLabel("Apellidos :");
						label.setBounds(192, 40, 93, 18);
						panelAgregar.add(label);
					}
					{
						txtApellido = new JTextField();
						txtApellido.setColumns(10);
						txtApellido.setBounds(202, 64, 135, 20);
						panelAgregar.add(txtApellido);
					}
					{
						JLabel label = new JLabel("Cedula :");
						label.setBounds(396, 40, 64, 18);
						panelAgregar.add(label);
					}
					{
						txtCedula = new JTextField();
						txtCedula.setColumns(10);
						txtCedula.setBounds(406, 64, 135, 20);
						panelAgregar.add(txtCedula);
					}
					{
						JLabel label = new JLabel("Tel\u00E9fono :");
						label.setBounds(10, 106, 72, 18);
						panelAgregar.add(label);
					}
					{
						txtTelefono = new JTextField();
						txtTelefono.setColumns(10);
						txtTelefono.setBounds(20, 135, 135, 20);
						panelAgregar.add(txtTelefono);
					}
					{
						JLabel label = new JLabel("Direcci\u00F3n :");
						label.setBounds(192, 107, 72, 16);
						panelAgregar.add(label);
					}
					{
						txtDireccion = new JTextField();
						txtDireccion.setColumns(10);
						txtDireccion.setBounds(202, 135, 340, 20);
						panelAgregar.add(txtDireccion);
					}
					{
						JLabel label = new JLabel("G\u00E9nero :");
						label.setBounds(10, 166, 72, 14);
						panelAgregar.add(label);
					}
					{
						cbxGenero = new JComboBox();
						cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<G\u00E9nero>", "Masculino", "Femenino"}));
						cbxGenero.setSelectedIndex(0);
						cbxGenero.setBounds(20, 191, 93, 20);
						panelAgregar.add(cbxGenero);
					}
					{
						JLabel label = new JLabel("Nacionalidad :");
						label.setBounds(187, 166, 98, 20);
						panelAgregar.add(label);
					}
					{
						cbxPais = new JComboBox();
						cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
						cbxPais.setSelectedIndex(0);
						cbxPais.setMaximumRowCount(5);
						cbxPais.setBounds(202, 191, 135, 20);
						panelAgregar.add(cbxPais);
					}
					{
						JLabel label = new JLabel("Correo El\u00E9ctronico :");
						label.setBounds(10, 222, 145, 20);
						panelAgregar.add(label);
					}
					{
						txtCorreoElect = new JTextField();
						txtCorreoElect.setColumns(10);
						txtCorreoElect.setBounds(20, 253, 317, 20);
						panelAgregar.add(txtCorreoElect);
					}
					{
						JLabel label = new JLabel("Fecha de Nacimiento :");
						label.setBounds(10, 284, 125, 14);
						panelAgregar.add(label);
					}
					{
						JLabel label = new JLabel("Dia :");
						label.setBounds(20, 312, 46, 14);
						panelAgregar.add(label);
					}
					{
						JLabel label = new JLabel("Mes :");
						label.setBounds(99, 312, 46, 14);
						panelAgregar.add(label);
					}
					{
						cbxMeses = new JComboBox();
						cbxMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Agosto", "Octubre", "Noviembre", "Diciembre"}));
						cbxMeses.setSelectedIndex(0);
						cbxMeses.setMaximumRowCount(4);
						cbxMeses.setBounds(133, 309, 99, 20);
						panelAgregar.add(cbxMeses);
					}
					{
						JLabel label = new JLabel("A\u00F1o :");
						label.setBounds(256, 312, 46, 14);
						panelAgregar.add(label);
					}
					{
						txtanos = new JTextField();
						txtanos.setColumns(10);
						txtanos.setBounds(288, 309, 86, 20);
						panelAgregar.add(txtanos);
					}
					{
						spinDias = new JSpinner();
						spinDias.setModel(new SpinnerNumberModel(1, 1, 31, 1));
						spinDias.setBounds(52, 309, 37, 20);
						panelAgregar.add(spinDias);
					}
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/teacher_128_44171.png")));
						lblNewLabel.setBounds(531, 166, 125, 128);
						panelAgregar.add(lblNewLabel);
					}
					
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							panelAgregar.setVisible(false);
							panelSegurida.setVisible(true);
						}
					});
					lblNewLabel_2.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
					lblNewLabel_2.setBounds(686, 325, 64, 52);
					panelAgregar.add(lblNewLabel_2);
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
						panel_2.setBounds(10, 180, 730, 197);
						panel_1.add(panel_2);
						panel_2.setLayout(null);
						{
							JLabel label = new JLabel("");
							label.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
							label.setBounds(544, 69, 93, 70);
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
							textField_8.setBounds(21, 53, 130, 20);
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
							textField_9.setBounds(193, 53, 130, 20);
							panel_2.add(textField_9);
						}
						{
							JLabel label = new JLabel("Tel\u00E9fono :");
							label.setBounds(358, 24, 83, 19);
							panel_2.add(label);
						}
						{
							textField_10 = new JTextField();
							textField_10.setColumns(10);
							textField_10.setBounds(369, 53, 122, 20);
							panel_2.add(textField_10);
						}
						{
							JLabel label = new JLabel("Correo El\u00E9ctronico :");
							label.setBounds(10, 84, 174, 20);
							panel_2.add(label);
						}
						{
							textField_11 = new JTextField();
							textField_11.setColumns(10);
							textField_11.setBounds(20, 105, 302, 20);
							panel_2.add(textField_11);
						}
						{
							JLabel label = new JLabel("Direcci\u00F3n :");
							label.setBounds(10, 136, 93, 19);
							panel_2.add(label);
						}
						{
							textField_12 = new JTextField();
							textField_12.setColumns(10);
							textField_12.setBounds(20, 166, 302, 20);
							panel_2.add(textField_12);
						}
						{
							JLabel lblNewLabel_5 = new JLabel("");
							lblNewLabel_5.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/secretaria.png")));
							lblNewLabel_5.setBounds(570, 39, 93, 86);
							panel_2.add(lblNewLabel_5);
						}
						{
							JLabel lblNewLabel_6 = new JLabel("");
							lblNewLabel_6.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/acceptar.png")));
							lblNewLabel_6.setBounds(618, 150, 46, 44);
							panel_2.add(lblNewLabel_6);
						}
						{
							JLabel lblNewLabel_7 = new JLabel("");
							lblNewLabel_7.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									dispose();
								}
							});
							lblNewLabel_7.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/cancelar2.png")));
							lblNewLabel_7.setBounds(671, 150, 59, 44);
							panel_2.add(lblNewLabel_7);
						}
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 11, 730, 158);
						panel_1.add(scrollPane);
					}
				}
			}
		}
		
//////////////////////////////////////////////////METODO AGREGAR SECRETARIA/////////////////////////////////////////////////////		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nombre, cedula, apellido, correo, direccion, telefono, nacionalidad, usuario, contraseña = null;
				boolean sexo = false;
				Calendar fecha_de_nacimiento = null;
				
				
				if(!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("") && !txtDireccion.getText().equalsIgnoreCase("") && cbxGenero.getSelectedIndex() != 0 && !txtanos.getText().equalsIgnoreCase("") &&
						!txtCedula.getText().equalsIgnoreCase("") && !txtTelefono.getText().equalsIgnoreCase("") && !txtUsuario.getText().equalsIgnoreCase("") && !passwordField1.getText().equalsIgnoreCase("") && !passwordField2.getText().equalsIgnoreCase("") && cbxPais.getSelectedIndex() != 0) {
					if(passwordField1.getText().equalsIgnoreCase(passwordField2.getText())) {
						
						 nombre = txtNombre.getText();
						 apellido = txtApellido.getText();
						 cedula = txtCedula.getText();
						 correo = txtCorreoElect.getText();
						 telefono = txtTelefono.getText();
						 direccion = txtDireccion.getText();
						usuario = txtUsuario.getText();
						contraseña = passwordField2.getText();
						nacionalidad = cbxPais.getSelectedItem().toString();
					//aqui esta el asunto	fecha_de_nacimiento.set(Integer.parseInt(txtanos.getText()), cbxMeses.getSelectedIndex(), Integer.parseInt(spinDias.getValue().toString()));
						
						if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Masculino")) {
							sexo = true;
						}else if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Femenino")) {
							sexo = false;
						}
						
						Persona aux = new Doctor(Integer.toString(cantidadSecretarias), nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, "Doctor");
							Clinica.getInstance().insertarPersona(aux);
							cantidadSecretarias = cantidadSecretarias + 1;
							JOptionPane.showMessageDialog(null, "Nuevo Doctor/ar Agregado", "Información", JOptionPane.INFORMATION_MESSAGE, null);
							dispose();	
						
					}else {
						 JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
					}
					
					
				}else {
					 JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
	}
}

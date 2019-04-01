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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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

public class VentanaDoctor_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreoElect;
	private JTextField txtanos;
	private JTextField txtUsuario;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JPanel panelSeguridad;
	private JPanel panel_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel btnSiguiente;
	private int cantidadDoctores = 0;
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
		setBounds(100, 100, 799, 494);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Estadística", null, panel_1, null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Agregar Nuevo Doctor", null, panel_2, null);
		
		panelSeguridad = new JPanel();
		panelSeguridad.setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSeguridad.setBackground(new Color(230, 230, 250));
		panelSeguridad.setBounds(0, 0, 764, 413);
		panelSeguridad.setVisible(false);
		panel_2.add(panelSeguridad);
		panelSeguridad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/LogoGrande.png")));
		lblNewLabel.setBounds(10, 40, 128, 161);
		panelSeguridad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Escudo.png")));
		lblNewLabel_1.setBounds(639, 40, 115, 161);
		panelSeguridad.add(lblNewLabel_1);
		
		JLabel btnAtras = new JLabel("");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_2.setVisible(true);
				panelSeguridad.setVisible(false);
			}
		});
		btnAtras.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/atraspeque\u00F1a.png")));
		btnAtras.setBackground(UIManager.getColor("Button.highlight"));
		btnAtras.setBounds(639, 368, 53, 34);
		panelSeguridad.add(btnAtras);
		
		JTextPane txtpnLasPartesExponen = new JTextPane();
		txtpnLasPartesExponen.setBackground(new Color(230, 230, 250));	
		StyledDocument doc = txtpnLasPartesExponen.getStyledDocument();

		//  Define a keyword attribute

		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.BLACK);
		StyleConstants.setBold(keyWord, true);

		//  Add some text

		try
		{
		    doc.insertString(0, "Estimado Doctor/ar. Por este medio se le informa que la siguiente información que usted mismo suministrará a continuación, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie está información, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber está información a demas de usted. Es su deber como profesional y miembro de está institución cumplir esta normal." , null );
		    doc.insertString(doc.getLength(), "\n", null );
		}
		catch(Exception e) { System.out.println(e); }
		
		txtpnLasPartesExponen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnLasPartesExponen.setBounds(178, 51, 411, 150);
		panelSeguridad.add(txtpnLasPartesExponen);
		
		JLabel lblUsuarioParaIniciar = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
		lblUsuarioParaIniciar.setBounds(269, 211, 162, 14);
		panelSeguridad.add(lblUsuarioParaIniciar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(279, 236, 150, 20);
		panelSeguridad.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(269, 267, 100, 14);
		panelSeguridad.add(lblContrasea);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(279, 292, 152, 20);
		panelSeguridad.add(passwordField1);
		
		JLabel lblConfimacinDeContrasea = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
		lblConfimacinDeContrasea.setBounds(269, 323, 179, 14);
		panelSeguridad.add(lblConfimacinDeContrasea);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(279, 352, 152, 20);
		panelSeguridad.add(passwordField2);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/acceptar.png")));
		lblNewLabel_4.setBounds(693, 367, 71, 35);
		panelSeguridad.add(lblNewLabel_4);
		
		JLabel label = new JLabel("Nombres :");
		label.setBounds(10, 28, 72, 22);
		panel_2.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(20, 56, 135, 20);
		panel_2.add(txtNombre);
		
		JLabel label_1 = new JLabel("Apellidos :");
		label_1.setBounds(192, 32, 93, 18);
		panel_2.add(label_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(202, 56, 135, 20);
		panel_2.add(txtApellido);
		
		JLabel label_2 = new JLabel("Cedula :");
		label_2.setBounds(396, 32, 64, 18);
		panel_2.add(label_2);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(406, 56, 135, 20);
		panel_2.add(txtCedula);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono :");
		label_3.setBounds(10, 98, 72, 18);
		panel_2.add(label_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(20, 127, 135, 20);
		panel_2.add(txtTelefono);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n :");
		label_4.setBounds(192, 99, 72, 16);
		panel_2.add(label_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(202, 127, 340, 20);
		panel_2.add(txtDireccion);
		
		JLabel label_5 = new JLabel("G\u00E9nero :");
		label_5.setBounds(10, 183, 72, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Nacionalidad :");
		label_6.setBounds(187, 183, 98, 20);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Correo El\u00E9ctronico :");
		label_7.setBounds(10, 252, 145, 20);
		panel_2.add(label_7);
		
		txtCorreoElect = new JTextField();
		txtCorreoElect.setColumns(10);
		txtCorreoElect.setBounds(20, 283, 317, 20);
		panel_2.add(txtCorreoElect);
		
		JLabel label_8 = new JLabel("Fecha de Nacimiento :");
		label_8.setBounds(10, 328, 125, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Dia :");
		label_9.setBounds(20, 356, 46, 14);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Mes :");
		label_10.setBounds(99, 356, 46, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("A\u00F1o :");
		label_11.setBounds(256, 356, 46, 14);
		panel_2.add(label_11);
		
		txtanos = new JTextField();
		txtanos.setColumns(10);
		txtanos.setBounds(288, 353, 86, 20);
		panel_2.add(txtanos);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctor.png")));
		label_12.setBounds(605, 238, 99, 103);
		panel_2.add(label_12);
		
		btnSiguiente = new JLabel("");
		btnSiguiente.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
		btnSiguiente.setBounds(690, 368, 64, 34);
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panelSeguridad.setVisible(true);
			}
		});
		panel_2.add(btnSiguiente);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		label_13.setBounds(512, 238, 93, 109);
		panel_2.add(label_13);
		
		final JComboBox cbxMeses = new JComboBox();
		cbxMeses.setBackground(new Color(240, 248, 255));
		cbxMeses.setMaximumRowCount(4);
		cbxMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Agosto", "Octubre", "Noviembre", "Diciembre"}));
		cbxMeses.setSelectedIndex(0);
		cbxMeses.setBounds(133, 353, 99, 20);
		panel_2.add(cbxMeses);
		
		final JSpinner spinDias = new JSpinner();
		spinDias.setBackground(new Color(240, 248, 255));
		spinDias.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinDias.setBounds(52, 353, 37, 20);
		panel_2.add(spinDias);
		
		final JComboBox cbxPais = new JComboBox();
		cbxPais.setBackground(new Color(240, 248, 255));
		cbxPais.setMaximumRowCount(5);
		cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
		cbxPais.setSelectedIndex(0);
		cbxPais.setBounds(202, 208, 135, 20);
		panel_2.add(cbxPais);
		
		final JComboBox cbxGenero = new JComboBox();
		cbxGenero.setBackground(new Color(240, 248, 255));
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<G\u00E9nero>", "", "Femenino"}));
		cbxGenero.setSelectedIndex(0);
		cbxGenero.setBounds(20, 208, 93, 20);
		panel_2.add(cbxGenero);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Modificar Doctor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 172, 744, 230);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
		lblNewLabel_3.setBounds(484, 132, 83, 72);
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
		btnModificar.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/edit_pencil_6320 (1).png")));
		btnModificar.setBounds(604, 176, 130, 41);
		panel_4.add(btnModificar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		lblNewLabel_2.setBounds(502, 87, 76, 96);
		panel_4.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 744, 150);
		panel_3.add(scrollPane);
		
		
///////////////////////////////////////////////////////////CREANDO NUEVO DOCTOR////////////////////////////////////////////////////////		
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
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
						fecha_de_nacimiento.set(Integer.parseInt(txtanos.getText()), cbxMeses.getSelectedIndex(), Integer.parseInt(spinDias.getValue().toString()));
						
						if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Masculino")) {
							sexo = true;
						}else if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Femenino")) {
							sexo = false;
						}
						
						Persona aux = new Doctor(Integer.toString(cantidadDoctores), nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, "Doctor");
							Clinica.getInstance().insertarPersona(aux);
							cantidadDoctores = cantidadDoctores + 1;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	
}

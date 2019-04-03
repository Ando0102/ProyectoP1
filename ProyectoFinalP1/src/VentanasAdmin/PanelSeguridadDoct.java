package VentanasAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;

public class PanelSeguridadDoct extends JPanel {

	private JTextField txtUsuario;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	/**
	 * Create the panel.
	 */
	PanelSeguridadDoct() {
	
	setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	setBackground(new Color(230, 230, 250));
	setBounds(0, 0, 764, 413);
	setVisible(false);
	setLayout(null);
	/*
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/LogoGrande.png")));
	lblNewLabel.setBounds(10, 40, 128, 161);
	//PanelSeguridadDoct.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Escudo.png")));
	lblNewLabel_1.setBounds(639, 40, 115, 161);
	//panelSeguridad.add(lblNewLabel_1);
	
	JLabel btnAtras = new JLabel("");
	btnAtras.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}
	});
	btnAtras.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/atraspeque\u00F1a.png")));
	btnAtras.setBackground(UIManager.getColor("Button.highlight"));
	btnAtras.setBounds(639, 368, 53, 34);
	//panelSeguridad.add(btnAtras);
	
	JTextPane txtpnLasPartesExponen = new JTextPane();
	txtpnLasPartesExponen.setBackground(new Color(230, 230, 250));	
	StyledDocument doc = txtpnLasPartesExponen.getStyledDocument();
	
	SimpleAttributeSet keyWord = new SimpleAttributeSet();
	StyleConstants.setForeground(keyWord, Color.BLACK);
	StyleConstants.setBold(keyWord, true);


	try
	{
	    doc.insertString(0, "Estimado Doctor/ar. Por este medio se le informa que la siguiente información que usted mismo suministrará a continuación, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie está información, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber está información a demas de usted. Es su deber como profesional y miembro de está institución cumplir esta normal." , null );
	    doc.insertString(doc.getLength(), "\n", null );
	}
	catch(Exception e) { System.out.println(e); }
	
	txtpnLasPartesExponen.setFont(new Font("Tahoma", Font.PLAIN, 12));
	txtpnLasPartesExponen.setBounds(178, 51, 411, 150);
	//panelSeguridad.add(txtpnLasPartesExponen);
	
	JLabel lblUsuarioParaIniciar = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
	lblUsuarioParaIniciar.setBounds(269, 211, 162, 14);
	//panelSeguridad.add(lblUsuarioParaIniciar);
	
	txtUsuario = new JTextField();
	txtUsuario.setBounds(279, 236, 150, 20);
	//panelSeguridad.add(txtUsuario);
	txtUsuario.setColumns(10);
	
	JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
	lblContrasea.setBounds(269, 267, 100, 14);
	//panelSeguridad.add(lblContrasea);
	
	passwordField1 = new JPasswordField();
	passwordField1.setBounds(279, 292, 152, 20);
	//panelSeguridad.add(passwordField1);
	
	JLabel lblConfimacinDeContrasea = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
	lblConfimacinDeContrasea.setBounds(269, 323, 179, 14);
	//panelSeguridad.add(lblConfimacinDeContrasea);
	
	passwordField2 = new JPasswordField();
	passwordField2.setBounds(279, 352, 152, 20);
	//panelSeguridad.add(passwordField2);
	JLabel lblNewLabel_4 = new JLabel("");
	lblNewLabel_4.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/acceptar.png")));
	lblNewLabel_4.setBounds(693, 367, 71, 35);
	//panelSeguridad.add(lblNewLabel_4);
	
	
	
///////////////////////////////////////////////////////////CREANDO NUEVO DOCTOR////////////////////////////////////////////////////////		
/*	
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
			
			
			
			
			@SuppressWarnings("null")
			@Override
			public void mouseClicked(MouseEvent e) {
			String nombre, cedula, apellido, correo, direccion, telefono, nacionalidad, usuario, contraseña = null;
			boolean sexo = false;
			//JCalendar fecha_de_nacimiento = JCalendar.get
			Calendar fecha_de_nacimiento  = Calendar.getInstance();
			//elimine el anno
			if((dcFechaNacimiento.getDate()!=null)&&!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("") && !txtDireccion.getText().equalsIgnoreCase("") && cbxGenero.getSelectedIndex() != 0 &&
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
			//aqui esta el asuntofecha_de_nacimiento.set(Integer.parseInt(txtanos.getText()), cbxMeses.getSelectedIndex(), Integer.parseInt(spinDias.getValue().toString()));
			
			
			//pasanddo la fecha seleccionada
			fecha_de_nacimiento.setTime(dcFechaNacimiento.getDate());
			if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Masculino")) {
			sexo = true;
			}else if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Femenino")) {
			sexo = false;
			}
			
			///Clinica.getInstance().get
			///	Doctor aux = new LOGICO.Persona(nombre, apellido, cedula, correo, fecha_nacimiento);
			Persona aux = new Doctor("CD- "+Integer.toString(cantidadDoctores), nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, "Doctor");
			Clinica.getInstance().insertarPersona(aux);
			
			//no esto seguro que esta aparte funcione sobre cantida de doctores
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
*/
}
}

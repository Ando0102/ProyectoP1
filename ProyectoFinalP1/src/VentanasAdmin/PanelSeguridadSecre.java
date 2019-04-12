package VentanasAdmin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.toedter.calendar.JDateChooser;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;
import Logical.Secretaria;
import Logical.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JEditorPane;

public class PanelSeguridadSecre extends JDialog {
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnNewButton;
	
	
	public PanelSeguridadSecre(final JTextField txtApellido, final JFormattedTextField txtCedula, final JTextField txtCorreoElect, final JTextField txtNombre, final JFormattedTextField txtTelefono, final JComboBox cbxGenero, final JComboBox cbxPais, final JDateChooser dcFechaNacimiento, final JCheckBox rbtDoctor, final JCheckBox rbtSecre, final JCheckBox rtbAdministrador) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelSeguridadSecre.class.getResource("/Imagenes/LogoPeque.png")));
		setResizable(false);
		setTitle("Informaci\u00F3n del Nuevo Empleado");
		setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 617, 541);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(240, 248, 255));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Informaci\u00F3n Privada del Nuevo Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 591, 490);
		panel.setBackground(new Color(230, 230, 250));
		getContentPane().add(panel);
		panel.setLayout(null);
	
		
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setBounds(343, 436, 114, 43);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSecre_admin aux2 = new VentanaSecre_admin();
				aux2.cbxGenero.setSelectedIndex(cbxGenero.getSelectedIndex());
				aux2.txtNombre.setText(txtNombre.getText());
				aux2.cbxPais.setSelectedIndex(cbxPais.getSelectedIndex());
				aux2.txtApellido.setText(txtApellido.getText());
				aux2.txtCedula.setValue(txtCedula.getValue());
				aux2.txtCorreoElect.setText(txtCorreoElect.getText());
				aux2.txtTelefono.setValue(txtTelefono.getValue());
				aux2.dcFechaNacimiento.setCalendar(dcFechaNacimiento.getCalendar());
				dispose();
				aux2.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/atraspeque\u00F1a.png")));
		
		btnNewButton = new JButton("Listo");
		btnNewButton.setBounds(467, 436, 114, 43);
		panel.add(btnNewButton);
		
		btnNewButton.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/acceptar.png")));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(211, 387, 152, 20);
		panel.add(passwordField_1);
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(457, 27, 114, 160);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/Escudo.png")));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 27, 125, 160);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/LogoGrande.png")));
		
		JLabel label = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
		label.setBounds(211, 250, 162, 14);
		panel.add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(211, 275, 150, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a :");
		label_1.setBounds(211, 306, 100, 14);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 331, 152, 20);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
		label_2.setBounds(211, 362, 179, 14);
		panel.add(label_2);
		
		JLabel lblTextPanel = new JLabel("New label");
		lblTextPanel.setBounds(150, 27, 290, 195);
		lblTextPanel.setText("<html><P ALIGN=justify>Por este medio se le informa que la siguiente información que usted mismo sumistrará a continuación, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie está información, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted. Absolutamente nadie debe de saber está información a demas de usted. Es su deber como profesional y miembro de está institución cumplir esta normal.");
		panel.add(lblTextPanel);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre, cedula, apellido, correo, telefono, nacionalidad, usuario = null, contraseña, rol = null;
				boolean sexo = false;
				Calendar fecha_de_nacimiento  = Calendar.getInstance();

				
				if((dcFechaNacimiento.getDate()!=null)&&!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("")  && cbxGenero.getSelectedIndex() != 0 &&
						txtCedula.getValue() != null && txtTelefono.getValue() != null && !txtUsuario.getText().equalsIgnoreCase("") && !passwordField.getText().equalsIgnoreCase("") && !passwordField_1.getText().equalsIgnoreCase("") && cbxPais.getSelectedIndex() != 0) {
					
					if(!VerificadorUsuario(usuario)) {
					
					if(passwordField.getText().equalsIgnoreCase(passwordField_1.getText())) {
						
						 nombre = txtNombre.getText();
						 apellido = txtApellido.getText();
						 cedula = (String) txtCedula.getValue();
						 correo = txtCorreoElect.getText();
						 telefono = (String)txtTelefono.getValue();
						usuario = txtUsuario.getText();
						contraseña = passwordField_1.getText();
						nacionalidad = cbxPais.getSelectedItem().toString();
						
				
						
						if(rbtDoctor.isSelected()) {
							rol = rbtDoctor.getText();
						}else if(rbtSecre.isSelected()) {
							rol = rbtSecre.getText();
						}else {
							rol = rtbAdministrador.getText();
						}
						
					
						
						//pasanddo la fecha seleccionada
						fecha_de_nacimiento.setTime(dcFechaNacimiento.getDate());
						if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Masculino")) {
							sexo = true;
						}else if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Femenino")) {
							sexo = false;
						}
							
								if(rbtDoctor.isSelected()) {	
									Persona aux = new Doctor(nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, rol);
									Clinica.getInstance().insertarPersona(aux);
									Clinica.setCantidadDoctor(Clinica.getCantidadDoctor() + 1);
									JOptionPane.showMessageDialog(null, "Nueva Doctor Agregado", "Información", JOptionPane.INFORMATION_MESSAGE, null);
									setVisible(false);
									VentanaSecre_admin aux2 = new VentanaSecre_admin();
									aux2.dispose();
									
								}else if(rbtSecre.isSelected()) {
									
									Persona aux = new Secretaria(nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, rol);
									Clinica.getInstance().insertarPersona(aux);
									Clinica.setCantidadSecretaria(Clinica.getCantidadSecretaria() + 1);
									JOptionPane.showMessageDialog(null, "Nueva Secretaria Agregada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
									setVisible(false);
									VentanaSecre_admin aux2 = new VentanaSecre_admin();
									aux2.dispose();
									
								}else {
									
									Persona aux = new User(nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, rol);
									Clinica.getInstance().insertarPersona(aux);
									Clinica.setCantidadDoctor(Clinica.getCantidadDoctor() + 1);
									JOptionPane.showMessageDialog(null, "Nuevo Administrador Agregado", "Información", JOptionPane.INFORMATION_MESSAGE, null);
									setVisible(false);
									VentanaSecre_admin aux2 = new VentanaSecre_admin();
									aux2.dispose();
						
								}
						
						}else {
							 JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
						}
					
					}else {
						 JOptionPane.showMessageDialog(null, "Este Usuario Ya Existe", "Advertencia", JOptionPane.WARNING_MESSAGE, null);

					}
					
				}else {
					 JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
				}
				
				
				
				
			}

			private boolean VerificadorUsuario(String usuario) {
				boolean esta = false;
				
				for(int i = 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
					
					if(Clinica.getInstance().getMisPersonas().get(i) instanceof User) {
						
						if(((User)Clinica.getInstance().getMisPersonas().get(i)).getUsuario().equalsIgnoreCase(usuario)) {
							esta = true;
						}
						
					}
					
				}
				
				return esta;
			}

			
		});

		
		
	}
}

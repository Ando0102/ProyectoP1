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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class PanelSeguridadSecre extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	
	public PanelSeguridadSecre(final JTextField txtApellido, final JTextField txtCedula, final JTextField txtCorreoElect, final JTextField txtDireccion, final JTextField txtNombre, final JTextField txtTelefono, final JComboBox cbxGenero, final JComboBox cbxPais, final JDateChooser dcFechaNacimiento) {
		
		setBorder(new TitledBorder(null, "Informaci\u00F3n de la Nueva Secretaria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 617, 541);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/LogoGrande.png")));
		lblNewLabel.setBounds(10, 48, 125, 160);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/Escudo.png")));
		lblNewLabel_1.setBounds(485, 48, 114, 160);
		add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		StyledDocument doc = textPane.getStyledDocument();
		
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.BLACK);
		StyleConstants.setBold(keyWord, true);

		try
		{
		    doc.insertString(0, "Estimada Secretaria. Por este medio se le informa que la siguiente informaci\u00F3n que usted mismo sumistrar\u00E1 a continuaci\u00F3n, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie est\u00E1 informaci\u00F3n, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber est\u00E1 informaci\u00F3n a demas de usted. Es su deber como profesional y miembro de est\u00E1 instituci\u00F3n cumplir esta normal. " , null );
		    doc.insertString(doc.getLength(), "\n", null );
		}
		catch(Exception e) { System.out.println(e); }
		
		textPane.setBounds(178, 48, 249, 228);
		textPane.setBackground(new Color(230, 230, 250));
		add(textPane);
		
		JLabel label = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
		label.setBounds(223, 299, 162, 14);
		add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(223, 324, 150, 20);
		add(txtUsuario);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a :");
		label_1.setBounds(223, 355, 100, 14);
		add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 380, 152, 20);
		add(passwordField);
		
		JLabel label_2 = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
		label_2.setBounds(223, 411, 179, 14);
		add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(223, 436, 152, 20);
		add(passwordField_1);
		
		JButton btnNewButton = new JButton("Listo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre, cedula, apellido, correo, direccion, telefono, nacionalidad, usuario, contraseña = null;
				boolean sexo = false;
				Calendar fecha_de_nacimiento  = Calendar.getInstance();

				
				if((dcFechaNacimiento.getDate()!=null)&&!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("") && !txtDireccion.getText().equalsIgnoreCase("") && cbxGenero.getSelectedIndex() != 0 &&
						!txtCedula.getText().equalsIgnoreCase("") && !txtTelefono.getText().equalsIgnoreCase("") && !txtUsuario.getText().equalsIgnoreCase("") && !passwordField.getText().equalsIgnoreCase("") && !passwordField_1.getText().equalsIgnoreCase("") && cbxPais.getSelectedIndex() != 0) {
					if(passwordField.getText().equalsIgnoreCase(passwordField_1.getText())) {
						
						 nombre = txtNombre.getText();
						 apellido = txtApellido.getText();
						 cedula = txtCedula.getText();
						 correo = txtCorreoElect.getText();
						 telefono = txtTelefono.getText();
						 direccion = txtDireccion.getText();
						usuario = txtUsuario.getText();
						contraseña = passwordField_1.getText();
						nacionalidad = cbxPais.getSelectedItem().toString();
						//aqui esta el asuntofecha_de_nacimiento.set(Integer.parseInt(txtanos.getText()), cbxMeses.getSelectedIndex(), Integer.parseInt(spinDias.getValue().toString()));
					
						
						//pasanddo la fecha seleccionada
						fecha_de_nacimiento.setTime(dcFechaNacimiento.getDate());
						if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Masculino")) {
							sexo = true;
						}else if(cbxGenero.getSelectedItem().toString().equalsIgnoreCase("Femenino")) {
							sexo = false;
						}
						

						Persona aux = new Secretaria("CS - "+Integer.toString(Clinica.getCantidadSecretaria()), nombre, apellido, cedula, sexo, telefono, nacionalidad, fecha_de_nacimiento, correo, usuario, contraseña, "Secretaria");
						Clinica.getInstance().insertarPersona(aux);
						Clinica.setCantidadSecretaria(Clinica.getCantidadSecretaria() + 1);
						JOptionPane.showMessageDialog(null, "Nueva Secretaria Agregada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
						setVisible(false);
						VentanaSecre_admin aux2 = new VentanaSecre_admin();
						aux2.dispose();
						
					}else {
						 JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
					}
					
					
				}else {
					 JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
				}
				
				
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/acceptar.png")));
		btnNewButton.setBounds(485, 487, 114, 43);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PanelSeguridadSecre.class.getResource("/Imagenes/atraspeque\u00F1a.png")));
		btnNewButton_1.setBounds(354, 487, 114, 43);
		add(btnNewButton_1);
		
		
		
		
		
	}

	
}

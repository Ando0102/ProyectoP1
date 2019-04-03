package VentanasAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

import com.toedter.calendar.JDateChooser;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;

public class PanelSeguridadDoct extends JDialog {

	private JTextField txtUsuario;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	/*SimpleAttributeSet keyWord = new SimpleAttributeSet();
	StyleConstants.setForeground(keyWord, Color.BLACK);
	StyleConstants.setBold(keyWord, true);


	try
	{
	    doc.insertString(0, "Estimado Doctor/ar. Por este medio se le informa que la siguiente información que usted mismo suministrará a continuación, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie está información, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber está información a demas de usted. Es su deber como profesional y miembro de está institución cumplir esta normal." , null );
	    doc.insertString(doc.getLength(), "\n", null );
	}
	catch(Exception e) { System.out.println(e); }/**
	 * Create the panel.
	 */
	public	PanelSeguridadDoct(JTextField txtApellido, JTextField txtCedula, JTextField txtCorreoElect, JTextField txtDireccion, JTextField txtNombre, JTextField txtTelefono, JComboBox cbxGenero, JComboBox cbxPais, JDateChooser dcFechaNacimiento) {
	
	setBackground(new Color(230, 230, 250));
	setBounds(0, 0, 764, 413);
	setLayout(null);
	
	}


}

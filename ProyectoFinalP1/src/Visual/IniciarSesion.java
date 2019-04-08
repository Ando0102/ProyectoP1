package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import com.placeholder.PlaceHolder;

public class IniciarSesion extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	private JTextField txtUsuario;

///
	//metodo de prueba
	//dsndns 
	private JLabel LabelUsuario;
	private JLabel LabelContraseña;
	private Dimension tamaño; // Dimension de la Ventana
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
//<<<<<<< HEAD
	private PlaceHolder cons; //constrasenna
	private PlaceHolder us;//usuario
	private JPasswordField txtContrasenna;
	private JPanel panel_1;

//=======
//	private static int presionados = 0;
//>>>>>>> branch 'master' of https://github.com/Ando0102/ProyectoP1.git
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				///Creando los objecto para leer y escribir
				
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				//esta parte la realizo el profesor. Estudien los Stream
				try {
					//leer
					empresa = new FileInputStream ("ADAClinica.dat");
					empresaRead = new ObjectInputStream(empresa);
					Clinica temp = (Clinica)empresaRead.readObject();
					Clinica.setMiClinica(temp);
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("ADAClinica.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						Calendar fecha_nacimiento = Calendar.getInstance();
						fecha_nacimiento.setTime(fechaActual());
						User aux = new User("Admi", "Admi", "Admi",false, "Admi", "Admi", fecha_nacimiento, "Admi", "Admin", "123", "Admi");
			
								////User("Administrador", "Admin", "Admin");
						Clinica.getInstance().insertarPersona(aux);
						empresaWrite.writeObject(Clinica.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//////
				
				try {
					IniciarSesion Dialog = new IniciarSesion();
					Dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(175, 238, 238));
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Inicio de Sesi\u00F3n");
		setBounds(100, 100, 510, 404);
		tamaño = super.getToolkit().getScreenSize();
		super.setSize(tamaño.width, tamaño.height);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(433, 208, 474, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEntrar = new JButton("Iniciar Sesi\u00F3n");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//<<<<<<< HEAD
				String usuario = "";
				String constrasenna = "";
				usuario = txtUsuario.getText().toString();
				constrasenna = txtContrasenna.getText().toString();
				
				if(constrasenna.equalsIgnoreCase("Ingrese su constraseña...")|| usuario.equalsIgnoreCase("Ingrese su usuario...")) {
					JOptionPane.showMessageDialog(null, "Campos Incompletos!", "Error", JOptionPane.ERROR_MESSAGE, null);
				}else {
				if(Clinica.getInstance().buscarUsuario(usuario, constrasenna)!=null) {
					User aux =Clinica.getInstance().buscarUsuario(usuario, constrasenna);

					if(aux instanceof Secretaria) {
						//secretaria
						VentanaSecretaria frame = new VentanaSecretaria((Secretaria) aux);
						frame.setVisible(true);
						dispose();
						
					}else if(aux instanceof Doctor) {
						//Doctor
						
						VentaDoctor frame = new VentaDoctor((Doctor) aux);
						frame.setVisible(true);
						dispose();
						
					}else {
						//Administrador general
						Administrator ad = new Administrator();
						
						ad.setVisible(true);
						dispose();
						
						
					}
					
					
					

				//	JOptionPane.showMessageDialog(null, "Bienvenido/a a la Clinica ADA!", "Bienvenido/a", JOptionPane.INFORMATION_MESSAGE, null);

			}else {

			    	   JOptionPane.showMessageDialog(null, "Usuario no existe!", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
			      
				
				}}
			}

});
		
		LabelContraseña = new JLabel("");
		LabelContraseña.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/candadito.png")));
		LabelUsuario = new JLabel("");
		LabelUsuario.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/hombrecito.png")));
		LabelUsuario.setForeground(UIManager.getColor("Button.darkShadow"));
		LabelUsuario.setBounds(110, 143, 28, 40);
		panel.add(LabelUsuario);
		LabelContraseña.setForeground(UIManager.getColor("Button.darkShadow"));
		LabelContraseña.setBounds(110, 193, 28, 34);
		panel.add(LabelContraseña);
		btnEntrar.setBounds(79, 267, 118, 34);
		panel.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/groups_people_people_1715.png")));
		lblNewLabel.setBounds(178, 11, 135, 128);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();

		
		txtUsuario.setForeground(new Color(128, 128, 128));

	
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsuario.setBounds(148, 157, 177, 20);
		/////
		if(txtUsuario .getText().equalsIgnoreCase("")) {
	        // set the echo character of the password field 
			//txtUsuario .setEchoChar((char)0); 
  
        // set initial text for password field 
	//	txtContraseña.setText("enter password"); 	
		cons = new PlaceHolder(txtUsuario , "Ingrese su usuario...");
		}
		///
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		


		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//PantallaTrasera.dispose();
				dispose();
			}
		});
		btnNewButton.setBounds(276, 267, 118, 34);
		panel.add(btnNewButton);
		
		txtContrasenna = new JPasswordField();
		txtContrasenna.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				///
				char c = evt.getKeyChar();
				 if(((c<'a'||c>'z')&&(c<'A'||c>'Z')&&(c<' '||c>' '))||(c<'0'||c>'9')) {
					 //if(c<'0'||c>'9')
					 txtContrasenna.setEchoChar('*');
				 }
				if(txtContrasenna.getText().length()==0) {
					if(c==8) {
						txtContrasenna.setEchoChar((char)0); 
						  cons.muestraHolderTxt(txtContrasenna, "Ingrese su constraseña...", 10);
				        // set initial text for password field 
					//	txtContraseña.setText("enter password"); 	
						
					}
					
				}
				//
				
			}
		});
		txtContrasenna.setColumns(10);
		txtContrasenna.setBounds(148, 206, 177, 20);
		///
		if(txtContrasenna.getText().equalsIgnoreCase("")) {
	        // set the echo character of the password field 
		txtContrasenna.setEchoChar((char)0); 
  
        // set initial text for password field 
	//	txtContraseña.setText("enter password"); 	
		cons = new PlaceHolder(txtContrasenna, "Ingrese su constraseña...");
		}else {
			txtContrasenna.setEchoChar('*');
		}
		//
		
		
		panel.add(txtContrasenna);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/LogoMuyGrande.png")));
		label.setBounds(10, 60, 366, 541);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/LogoMuyGrande.png")));
		label_1.setBounds(1084, 60, 256, 541);
		contentPane.add(label_1);
		
		label_2 = new JLabel("                           \"El mejor m\u00E9dico es el que conoce la inutilidad de la mayor parte de las medicinas.\"\r\n  - Benjamin Franklin");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(194, 545, 961, 138);
		contentPane.add(label_2);
		
		label_3 = new JLabel("BIENVENIDO/A A LA CLINICA ADA ");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("Sylfaen", Font.BOLD, 22));
		label_3.setBounds(476, 11, 445, 138);
		contentPane.add(label_3);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, new Color(192, 192, 192)));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(433, 175, 474, 34);
		contentPane.add(panel_1);
	}
	public static Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
}

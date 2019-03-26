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

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField LETRASdeContraseña;
	private JPasswordField txtContraseña;
	private JLabel LabelUsuario;
	private JLabel LabelContraseña;
	private Dimension tamaño; // Dimension de la Ventana
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

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
						User aux = new User("Admin-1", "Admi", "Admi", "Admi",false, "Admi", "Admi", fecha_nacimiento, "Admi", "Admin", "123", "Admi");
			
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(433, 208, 474, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEntrar = new JButton("Iniciar Sesi\u00F3n");
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "";
				String constrasenna = "";
				usuario = txtUsuario.getText().toString();
				constrasenna = txtContraseña.getPassword().toString();
				if(Clinica.getInstance().buscarUsuario(usuario, constrasenna)!=null) {
						//(textField.getText(),textField_1.getText())){

					JOptionPane.showMessageDialog(null, "Bienvenido", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
					///Principal frame = new Principal();
					//dispose();
					///frame.setVisible(true);
				}else {
			    	   JOptionPane.showMessageDialog(null, "No se pudo Acceder", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
			       //System.out.println(Clinica.getInstance().getMisPersonas().get(0).getApellidos());
			       }
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
		txtUsuario.setText(" Usuario");
		txtUsuario.setForeground(new Color(128, 128, 128));
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUsuario.setText("");
				txtUsuario.setForeground(new Color(0, 0, 0));
				txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			}
		});

		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsuario.setBounds(148, 157, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		LETRASdeContraseña = new JTextField();
		LETRASdeContraseña.setText(" Contraseña ");
		LETRASdeContraseña.setForeground(new Color(128, 128, 128));
		LETRASdeContraseña.setText(" Contraseña ");
		LETRASdeContraseña.setForeground(new Color(128, 128, 128));
		LETRASdeContraseña.setColumns(10);
		LETRASdeContraseña.setBounds(148, 207, 177, 20);
		panel.add(LETRASdeContraseña);
		
		LETRASdeContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LETRASdeContraseña.setVisible(false);
				
				txtContraseña = new JPasswordField();
				txtContraseña.setColumns(10);
				txtContraseña.setBounds(148, 207, 177, 20);
				txtContraseña.setForeground(new Color(0, 0, 0));
				panel.add(txtContraseña);
			
			}
		});
		

		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//PantallaTrasera.dispose();
				dispose();
			}
		});
		btnNewButton.setBounds(276, 267, 118, 34);
		panel.add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/LogoMuyGrande.png")));
		label.setBounds(10, 60, 366, 541);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/LogoMuyGrande.png")));
		label_1.setBounds(1069, 60, 271, 541);
		contentPane.add(label_1);
		
		label_2 = new JLabel("                           \"El mejor m\u00E9dico es el que conoce la inutilidad de la mayor parte de las medicinas.\"\r\n  - Benjamin Franklin");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(194, 545, 961, 138);
		contentPane.add(label_2);
		
		label_3 = new JLabel("BIENVENIDO/A A LA CLINICA BDA ");
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		label_3.setBounds(492, 11, 366, 138);
		contentPane.add(label_3);
	}
	public static Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
	
}

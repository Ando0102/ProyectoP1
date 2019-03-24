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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				///Creando los objecto para leer y escribir
				FileInputStream Empresa_Clinica;
				FileOutputStream AuxEmpresa;
				ObjectInputStream Empresa_Clinica_Read;
				ObjectOutputStream Empresa_Clinica_Write;
				try {
					//leer
					Empresa_Clinica = new FileInputStream ("EmpresaClinca.dat");
					Empresa_Clinica_Read = new ObjectInputStream(Empresa_Clinica);
					
					Clinica miClinica = (Clinica)Empresa_Clinica_Read.readObject();
					Clinica.setMiClinica(miClinica);
				} catch (FileNotFoundException e) {
					try {
						AuxEmpresa = new  FileOutputStream("EmpresaClinca.dat");
						Empresa_Clinica_Write = new ObjectOutputStream(AuxEmpresa);
						
						Calendar fecha_nacimiento = Calendar.getInstance();
						fecha_nacimiento.setTime(fechaActual());
						
						//usuario Administrador
						User aux = new User("0", "Admin", "Admin", "Admin", false, "Admin", "Admin", fecha_nacimiento, "Admin", "Admin", "123", "Administrador");
								//Logical.User("0", "Admin", "Admin", "Admin", false, "0", "Dominica", fecha_nacimiento, "Admin", "Admin", "123", "Admin");
						Clinica.getInstance().insertarPersona(aux);
						Empresa_Clinica_Write.writeObject(Clinica.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				///
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 336);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/////////////////////////PROTECTOR DE PANTALLA///////////////////////////////////////
		final ProtectorDePantalla PantallaTrasera = new ProtectorDePantalla();
		PantallaTrasera.setVisible(true);
		////////////////////////////////////////////////////////////////////////////////////
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 556, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 63, 71, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblContrasea.setBounds(10, 106, 71, 14);
		panel.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(67, 75, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(67, 125, 177, 20);
		panel.add(txtContraseña);
		
		JButton btnEntrar = new JButton("Iniciar Sesi\u00F3n");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "";
				String constrasenna = "";
				usuario = txtUsuario.getText().toString();
				constrasenna = txtContraseña.getText().toString();
				if(Clinica.getInstance().buscarUsuario(usuario, constrasenna)!=null) {
						//(textField.getText(),textField_1.getText())){

					JOptionPane.showMessageDialog(null, "Bienvenido", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
			       }
			}
		});
		btnEntrar.setBounds(300, 241, 118, 23);
		panel.add(btnEntrar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaTrasera.dispose();
				dispose();
			}
		});
		btnNewButton.setBounds(428, 241, 118, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/users.png")));
		lblNewLabel.setBounds(344, 11, 142, 177);
		panel.add(lblNewLabel);
	}
	public static Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
}

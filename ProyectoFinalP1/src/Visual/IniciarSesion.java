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

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 25, 323, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 25, 71, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 50, 71, 14);
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(75, 22, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 47, 86, 20);
		panel.add(textField_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "";
				String constrasenna = "";
				usuario = textField.getText().toString();
				constrasenna = textField_1.getText().toString();
				if(Clinica.getInstance().buscarUsuario(usuario, constrasenna)!=null) {
						//(textField.getText(),textField_1.getText())){

					JOptionPane.showMessageDialog(null, "Bienvenido", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
			       }
			}
		});
		btnEntrar.setBounds(72, 100, 89, 23);
		panel.add(btnEntrar);
	}
	public static Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
}

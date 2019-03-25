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
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class IniciarSesion extends JDialog {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JLabel LabelUsuario;
	private JLabel LabelContraseña;

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
				try {
					//leer
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Clinica temp = (Clinica)empresaRead.readObject();
					Clinica.setMiClinica(temp);
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						Calendar fecha_nacimiento = Calendar.getInstance();
						fecha_nacimiento.setTime(fechaActual());
						User aux = new User("Admin", "Admin", "Admin", "Admin", false, "Admin", "Admin", fecha_nacimiento, "Admin", "Admin", "123", "Admin");
								//User("Administrador", "Admin", "Admin");
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
				//
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
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBackground(new Color(175, 238, 238));
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Inicio de Sesi\u00F3n");
		setBounds(100, 100, 510, 404);
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
		panel.setBounds(10, 11, 474, 343);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEntrar = new JButton("Iniciar Sesi\u00F3n");
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "";
				String constrasenna = "";
				usuario = txtUsuario.getText().toString();
				constrasenna = txtContraseña.getText().toString();
				if(Clinica.getInstance().buscarUsuario(usuario, constrasenna)!=null) {
						//(textField.getText(),textField_1.getText())){

					JOptionPane.showMessageDialog(null, "Bienvenido", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
			       }else {
			    	   JOptionPane.showMessageDialog(null, "No se pudo Acceder", "Información.", JOptionPane.INFORMATION_MESSAGE, null);
			       }
			}
		});
		
		LabelContraseña = new JLabel("");
		LabelContraseña.setIcon(new ImageIcon("C:\\Users\\arman\\Downloads\\lock-padlock-symbol-for-protect_icon-icons.com_56926.png"));
		LabelUsuario = new JLabel("");
		LabelUsuario.setIcon(new ImageIcon("C:\\Users\\arman\\Downloads\\user_icon-icons.com_57997.png"));
		LabelUsuario.setForeground(UIManager.getColor("Button.darkShadow"));
		LabelUsuario.setBounds(100, 143, 38, 40);
		panel.add(LabelUsuario);
		LabelContraseña.setForeground(UIManager.getColor("Button.darkShadow"));
		LabelContraseña.setBounds(94, 193, 44, 34);
		panel.add(LabelContraseña);
		btnEntrar.setBounds(79, 267, 118, 34);
		panel.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/Imagenes/users.png")));
		lblNewLabel.setBounds(178, 11, 135, 128);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(0, 0, 0));
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUsuario.setBounds(148, 157, 177, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(148, 207, 177, 20);
		panel.add(txtContraseña);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaTrasera.dispose();
				dispose();
			}
		});
		btnNewButton.setBounds(276, 267, 118, 34);
		panel.add(btnNewButton);
	}
	public static Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
}

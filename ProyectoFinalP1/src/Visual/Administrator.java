package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import VentanasAdmin.VentanaCita_admin;
import VentanasAdmin.VentanaEnfermedad_admin;
import VentanasAdmin.VentanaEstadisticas;
import VentanasAdmin.VentanaPacientes_admin;
import VentanasAdmin.VentanaSecre_admin;
import VentanasAdmin.VentanaVacuna_admin;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Administrator extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextPane txtHoraYFecha;
	private Dimension tamano;
	private Thread Tiempo;
	private int hora;
	private int minutos;
	private int segundos;
	private int mes;
	private int ano;
	private int dia;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public Administrator() {
		//metodo prueba
		//prueba existosa! 
		/**
		 * Sirve para para saber si se ha cerrado 
		 * la venta
		*/
		
		//Decomentar esta parte para que guarde los datos tomados 
		//en administrador
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("ADAClinica.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Clinica.getInstance());
				empresa2.close();
				empresaWrite.close();
				} catch (FileNotFoundException e1) {
					System.out.println("Error: No se ha podido guardar.");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		////
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		tamano = super.getToolkit().getScreenSize();
		super.setSize(tamano.width, (tamano.height-50));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 11, 199, 647);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/man.png")));
		lblNewLabel.setBounds(55, 11, 89, 129);
		panel_1.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a ");
		lblBienvenidoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBienvenidoa.setBounds(55, 151, 89, 49);
		panel_1.add(lblBienvenidoa);
		
		txtHoraYFecha = new JTextPane();
		txtHoraYFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtHoraYFecha.setBackground(new Color(240, 248, 255));
		txtHoraYFecha.setEditable(false);
		txtHoraYFecha.setBounds(10, 532, 179, 104);
		
		////////HILO PARA EL RELOJ///////////////////////////////////////////
		Tiempo = new Thread(this);
		Tiempo.start();
		/////////////////////////////////////////////////////////////////
		panel_1.add(txtHoraYFecha);
		
		JButton btnNewButton = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, null); 
					if(resp == 0){
						IniciarSesion aux =  new IniciarSesion();
						aux.setVisible(true);
						dispose();						
					} else{
							repaint();
						}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/stop_exit_close_6291.png")));
		btnNewButton.setBounds(10, 376, 179, 57);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tablero");
		btnNewButton_1.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/controlPanel.png")));
		btnNewButton_1.setBounds(10, 308, 179, 57);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agenda");
		btnNewButton_2.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/calendario.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(10, 240, 179, 57);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(219, 11, 1111, 647);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton botonEmpleados = new JButton();
		botonEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaSecre_admin aux = new VentanaSecre_admin();
				aux.setVisible(true);
			}
		});
		
		
		botonEmpleados.setBackground(new Color(240, 248, 255));
		botonEmpleados.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botonEmpleados.setBounds(105, 100, 230, 140);
		panel_2.add(botonEmpleados);
		botonEmpleados.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("");
		lblEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
			}
		});
		lblEmpleados.setBounds(72, 11, 86, 94);
		lblEmpleados.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/doctor.png")));
		botonEmpleados.add(lblEmpleados);
		
		JLabel llbTxtEmpleados = new JLabel("EMPLEADOS");
		llbTxtEmpleados.setForeground(Color.BLACK);
		llbTxtEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
		llbTxtEmpleados.setBounds(79, 107, 80, 22);
		botonEmpleados.add(llbTxtEmpleados);
		
		JButton panelPaciente = new JButton();
		panelPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPacientes_admin aux = new VentanaPacientes_admin();
				aux.setVisible(true);
			}
		});
		panelPaciente.setBackground(new Color(240, 248, 255));
		panelPaciente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPaciente.setBounds(440, 100, 230, 140);
		panel_2.add(panelPaciente);
		panelPaciente.setLayout(null);
		
		JLabel lblPaciente = new JLabel("");
		lblPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPacientes_admin aux = new VentanaPacientes_admin();
				aux.setVisible(true);
			}
		});
		lblPaciente.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/Paciente Mujer.png")));
		lblPaciente.setBounds(77, 11, 104, 94);
		panelPaciente.add(lblPaciente);
		
		JLabel lbltextpaciente = new JLabel("PACIENTES");
		lbltextpaciente.setForeground(Color.BLACK);
		lbltextpaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextpaciente.setBounds(89, 105, 91, 29);
		panelPaciente.add(lbltextpaciente);
		
		JButton botonEstadistica = new JButton();
		botonEstadistica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEstadisticas aux = new VentanaEstadisticas();
				aux.setVisible(true);
			}
		});
		botonEstadistica.setBackground(new Color(240, 248, 255));
		botonEstadistica.setLayout(null);
		botonEstadistica.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botonEstadistica.setBounds(105, 342, 230, 140);
		panel_2.add(botonEstadistica);
		
		JLabel lblEstadistica = new JLabel("");
		lblEstadistica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEstadisticas aux = new VentanaEstadisticas();
				aux.setVisible(true);
			}
		});
		lblEstadistica.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/grafica1.png")));
		lblEstadistica.setBounds(62, 11, 100, 94);
		botonEstadistica.add(lblEstadistica);
		
		JLabel lbltextEstadistica = new JLabel("ESTADÍSTICAS");
		lbltextEstadistica.setForeground(new Color(0, 0, 0));
		lbltextEstadistica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextEstadistica.setBounds(70, 107, 93, 22);
		botonEstadistica.add(lbltextEstadistica);
		
		JButton panelEnfermedad = new JButton();
		panelEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEnfermedad_admin aux = new VentanaEnfermedad_admin();
				aux.setVisible(true);
			}
		});
		panelEnfermedad.setBackground(new Color(240, 248, 255));
		panelEnfermedad.setLayout(null);
		panelEnfermedad.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelEnfermedad.setBounds(775, 100, 230, 140);
		panel_2.add(panelEnfermedad);
		
		JLabel lblEnfermedad = new JLabel("");
		lblEnfermedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEnfermedad_admin aux = new VentanaEnfermedad_admin();
				aux.setVisible(true);
			}
		});
		lblEnfermedad.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/Enfermedad2.png")));
		lblEnfermedad.setBounds(67, 11, 103, 94);
		panelEnfermedad.add(lblEnfermedad);
		
		JLabel lbltextenfermedad = new JLabel("ENFERMEDADES");
		lbltextenfermedad.setForeground(new Color(0, 0, 0));
		lbltextenfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextenfermedad.setBounds(75, 101, 89, 28);
		panelEnfermedad.add(lbltextenfermedad);
		
		JButton panelVacuna = new JButton();
		panelVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaVacuna_admin aux = new VentanaVacuna_admin();
				aux.setVisible(true);
			}
		});
		
		JButton panelCitas = new JButton();
		panelCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCita_admin aux = new VentanaCita_admin();
				aux.setVisible(true);
			}
		});
		panelCitas.setBackground(new Color(240, 248, 255));
		panelCitas.setLayout(null);
		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(440, 342, 230, 140);
		panel_2.add(panelCitas);
		panelCitas.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/cita5.png")));
		lblNewLabel_1.setBounds(65, 11, 97, 88);
		panelCitas.add(lblNewLabel_1);
		
		JLabel lblEstadstica = new JLabel("CITAS");
		lblEstadstica.setForeground(new Color(0, 0, 0));
		lblEstadstica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstadstica.setBounds(93, 110, 109, 19);
		panelCitas.add(lblEstadstica);
		
		panelVacuna.setBackground(new Color(240, 248, 255));
		panelVacuna.setLayout(null);
		panelVacuna.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelVacuna.setBounds(775, 342, 230, 140);
		panel_2.add(panelVacuna);
		
		JLabel lblVacuna = new JLabel("");
		lblVacuna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaVacuna_admin aux = new VentanaVacuna_admin();
				aux.setVisible(true);
			}
		});
		lblVacuna.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/Vacuna2.png")));
		lblVacuna.setBounds(69, 11, 114, 94);
		panelVacuna.add(lblVacuna);
		
		JLabel lbltextvacuna = new JLabel("VACUNAS");
		lbltextvacuna.setForeground(new Color(0, 0, 0));
		lbltextvacuna.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextvacuna.setBounds(93, 107, 58, 22);
		panelVacuna.add(lbltextvacuna);
	}
	

////////////////////////////////////FUNCIONES PARA EL RELOJ//////////////////////////////
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == Tiempo) {
            calcula();
            txtHoraYFecha.setText("\n          " + hora + ":" + minutos + ":" + segundos +"\n        " + dia + "|"+ mes +"|"+ ano);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
		
	}
	
	
	public void calcula() {
		//Hora utilizando Hilo
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        
        //Fecha de Forma Manual
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = 4;  //calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);
        
        
    }
}

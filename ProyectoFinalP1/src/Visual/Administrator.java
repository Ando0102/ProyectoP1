package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VentanasAdmin.VentanaCita_admin;
import VentanasAdmin.VentanaDoctor_admin;
import VentanasAdmin.VentanaEnfermedad_admin;
import VentanasAdmin.VentanaPacientes_admin;
import VentanasAdmin.VentanaSecre_admin;
import VentanasAdmin.VentanaVacuna_admin;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	public Administrator() {
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		tamano = super.getToolkit().getScreenSize();
		super.setSize(tamano.width, (tamano.height-50));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
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
		txtHoraYFecha.setBackground(Color.WHITE);
		txtHoraYFecha.setEditable(false);
		txtHoraYFecha.setBounds(10, 532, 179, 104);
		
		////////HILO PARA EL RELOJ///////////////////////////////////////////
		Tiempo = new Thread(this);
		Tiempo.start();
		/////////////////////////////////////////////////////////////////
		panel_1.add(txtHoraYFecha);
		
		JButton btnNewButton = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/logout1.png")));
		btnNewButton.setBounds(10, 376, 179, 57);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tablero");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/controlPanel.png")));
		btnNewButton_1.setBounds(10, 308, 179, 57);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agenda");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/calendario.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(10, 240, 179, 57);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(219, 11, 1111, 647);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelDoctor = new JPanel();
		panelDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaDoctor_admin aux = new VentanaDoctor_admin();
				aux.setVisible(true);
			}
		});
		panelDoctor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDoctor.setBounds(105, 100, 230, 140);
		panel_2.add(panelDoctor);
		panelDoctor.setLayout(null);
		
		JLabel lblDoctor = new JLabel("");
		lblDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaDoctor_admin aux = new VentanaDoctor_admin();
				aux.setVisible(true);
			}
		});
		lblDoctor.setBounds(72, 11, 86, 94);
		lblDoctor.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/doctor.png")));
		panelDoctor.add(lblDoctor);
		
		JLabel lbltextdoctor = new JLabel("DOCTOR");
		lbltextdoctor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextdoctor.setBounds(93, 107, 65, 22);
		panelDoctor.add(lbltextdoctor);
		
		JPanel panelPaciente = new JPanel();
		panelPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPacientes_admin aux = new VentanaPacientes_admin();
				aux.setVisible(true);
			}
		});
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
		
		JLabel lbltextpaciente = new JLabel("PACIENTE");
		lbltextpaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextpaciente.setBounds(90, 100, 91, 29);
		panelPaciente.add(lbltextpaciente);
		
		JPanel panelSecretaria = new JPanel();
		panelSecretaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaSecre_admin aux = new VentanaSecre_admin();
				aux.setVisible(true);
			}
		});
		panelSecretaria.setLayout(null);
		panelSecretaria.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSecretaria.setBounds(105, 342, 230, 140);
		panel_2.add(panelSecretaria);
		
		JLabel lblSecretaria = new JLabel("");
		lblSecretaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaSecre_admin aux = new VentanaSecre_admin();
				aux.setVisible(true);
			}
		});
		lblSecretaria.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/secretaria.png")));
		lblSecretaria.setBounds(72, 11, 86, 94);
		panelSecretaria.add(lblSecretaria);
		
		JLabel lbltextsecretaria = new JLabel("SECRETARIA");
		lbltextsecretaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextsecretaria.setBounds(83, 107, 91, 22);
		panelSecretaria.add(lbltextsecretaria);
		
		JPanel panelCitas = new JPanel();
		panelCitas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCita_admin aux = new VentanaCita_admin();
				aux.setVisible(true);
			}
		});
		panelCitas.setLayout(null);
		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(440, 342, 230, 140);
		panel_2.add(panelCitas);
		
		JLabel lblCita = new JLabel("");
		lblCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCita_admin aux = new VentanaCita_admin();
				aux.setVisible(true);
			}
		});
		lblCita.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/cita5.png")));
		lblCita.setBounds(67, 11, 96, 94);
		panelCitas.add(lblCita);
		
		JLabel lbltextcitas = new JLabel("CITA");
		lbltextcitas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextcitas.setBounds(103, 107, 57, 22);
		panelCitas.add(lbltextcitas);
		
		JPanel panelEnfermedad = new JPanel();
		panelEnfermedad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaEnfermedad_admin aux = new VentanaEnfermedad_admin();
				aux.setVisible(true);
			}
		});
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
		
		JLabel lbltextenfermedad = new JLabel("ENFERMEDAD");
		lbltextenfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextenfermedad.setBounds(81, 101, 89, 28);
		panelEnfermedad.add(lbltextenfermedad);
		
		JPanel panelVacuna = new JPanel();
		panelVacuna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaVacuna_admin aux = new VentanaVacuna_admin();
				aux.setVisible(true);
			}
		});
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
		
		JLabel lbltextvacuna = new JLabel("VACUNA");
		lbltextvacuna.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltextvacuna.setBounds(100, 107, 58, 22);
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
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);
        
        
    }
	///////////////////////////////////////////////////////////////////////////
}

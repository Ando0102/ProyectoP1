package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ventanasSecretaria.NuevaCita;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSecretaria extends JFrame {

	private JPanel contentPane;
	JPanel panelCitas = new JPanel();
	private Dimension tamaño; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSecretaria frame = new VentanaSecretaria();
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
	public VentanaSecretaria() {
		String vi="HOLA";
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setResizable(false);
		setTitle("Secretario/a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 594);
		tamaño = super.getToolkit().getScreenSize();
		super.setSize(tamaño.width, tamaño.height);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Holaaaaaaa
		
		JMenu mnNuevaCita = new JMenu("Nueva Cita");
		mnNuevaCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnNuevaCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/medical-15_icon-icons.com_73938 (1).png")));
		menuBar.add(mnNuevaCita);
		
		JMenu mnModificarCita = new JMenu("Modificar Cita");
		mnModificarCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/medical-12_icon-icons.com_73944 (1).png")));
		menuBar.add(mnModificarCita);
		
		JMenu mnCerrarSesion = new JMenu("Cerrar Sesion");
		mnCerrarSesion.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/medical-27_icon-icons.com_73934 (1).png")));
		menuBar.add(mnCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(new Color(240, 255, 240));
		panelBienvenida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBienvenida.setBounds(10, 11, 199, 673);
		panel.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/Paciente Mujer.png")));
		lblNewLabel.setBounds(50, 30, 108, 107);
		panelBienvenida.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a !");
		lblBienvenidoa.setBounds(60, 162, 83, 14);
		panelBienvenida.add(lblBienvenidoa);
		
		JPanel panelCitas = new JPanel();
		panelCitas.setBackground(new Color(240, 255, 240));
		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(219, 11, 1121, 673);
		panel.add(panelCitas);
		panelCitas.setLayout(null);
	}
}

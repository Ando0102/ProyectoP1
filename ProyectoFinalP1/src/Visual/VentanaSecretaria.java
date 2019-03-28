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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSecretaria extends JFrame {

	private JPanel contentPane;
	JPanel panelCitas = new JPanel();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setResizable(false);
		setTitle("Secretario/a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 594);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevaCita = new JMenu("Nueva Cita");
		mnNuevaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNuevaCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/cita2.png")));
		menuBar.add(mnNuevaCita);
		
		JMenu mnModificarCita = new JMenu("Modificar Cita");
		mnModificarCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/libro2.png")));
		menuBar.add(mnModificarCita);
		
		JMenu mnCerrarSesion = new JMenu("Cerrar Sesion");
		mnCerrarSesion.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/logoout2.png")));
		menuBar.add(mnCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBienvenida.setBounds(10, 11, 199, 499);
		panel.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\secretaria.png"));
		lblNewLabel.setBounds(50, 30, 83, 107);
		panelBienvenida.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a !");
		lblBienvenidoa.setBounds(60, 162, 83, 14);
		panelBienvenida.add(lblBienvenidoa);
		
		JPanel panelCitas = new JPanel();
		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(219, 11, 797, 499);
		panel.add(panelCitas);
		panelCitas.setLayout(null);
	}
}

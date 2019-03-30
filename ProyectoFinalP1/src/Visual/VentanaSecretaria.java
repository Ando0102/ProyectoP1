package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ventanasSecretaria.ModificarCita;
import ventanasSecretaria.NuevaCita;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setResizable(false);
		setTitle("Secretario/a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 594);
		tamaño = super.getToolkit().getScreenSize();
		super.setSize(tamaño.width, tamaño.height);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		setJMenuBar(menuBar);
		//Holaaaaaaa
		
		JMenu mnNuevaCita = new JMenu("Nueva Cita");
		mnNuevaCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NuevaCita citas = new NuevaCita();
				citas.setModal(true);
				citas.setLocationRelativeTo(null);
				citas.visualizarCampos(true);
			}
		});
		mnNuevaCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/controlpanel_task_10822.png")));
		menuBar.add(mnNuevaCita);
		
		JMenu mnModificarCita = new JMenu("Modificar Cita");
		mnModificarCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModificarCita modi = new ModificarCita();
				modi.setModal(true);
				modi.setLocationRelativeTo(null);
				modi.setVisible(true);
			}
		});
		mnModificarCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/editnote_pencil_edi_6175 (1).png")));
		menuBar.add(mnModificarCita);
		
		JMenu mnCerrarSesion = new JMenu("Cerrar Sesion");
		mnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IniciarSesion inicio = new IniciarSesion();
				int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Si", "No" }, null); 
				if(resp == 0){
				setVisible(false);
				inicio.setVisible(true);} else{
					repaint();
				}
				
			}
		});
		mnCerrarSesion.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/stop_exit_close_6291.png")));
		menuBar.add(mnCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(SystemColor.inactiveCaptionBorder);
		panelBienvenida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBienvenida.setBounds(10, 11, 199, 673);
		panel.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/nurse_128_44165.png")));
		lblNewLabel.setBounds(50, 23, 96, 128);
		panelBienvenida.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a !");
		lblBienvenidoa.setBounds(60, 162, 83, 14);
		panelBienvenida.add(lblBienvenidoa);
		
		JPanel panelCitas = new JPanel();
		panelCitas.setBackground(SystemColor.inactiveCaptionBorder);
		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(219, 11, 1121, 673);
		panel.add(panelCitas);
		panelCitas.setLayout(null);
	}
}

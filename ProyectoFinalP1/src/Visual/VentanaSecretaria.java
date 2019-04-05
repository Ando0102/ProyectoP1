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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Logical.Clinica;
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
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class VentanaSecretaria extends JFrame {

	private JPanel contentPane;
	JPanel panelCitas = new JPanel();
	private Dimension tamaño; 
	private JTable tableCitas;
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(new Color(176, 196, 222));
		panelBienvenida.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBienvenida.setBounds(10, 11, 199, 707);
		panel.add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/nurse_128_44165.png")));
		lblNewLabel.setBounds(50, 23, 96, 128);
		panelBienvenida.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a !");
		lblBienvenidoa.setBounds(60, 162, 83, 14);
		panelBienvenida.add(lblBienvenidoa);
		
		JButton btnNuevaCita = new JButton("Nueva Cita");
		btnNuevaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaCita citas = new NuevaCita();
				citas.setModal(true);
				citas.setLocationRelativeTo(null);
				citas.visualizarCampos(true);
				//citas.cargarLista();
				
			}
		});
		btnNuevaCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/controlpanel_task_10822.png")));
		btnNuevaCita.setBounds(10, 240, 179, 63);
		panelBienvenida.add(btnNuevaCita);
		
		JButton btnModificarCita = new JButton("Modificar Cita");
		btnModificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCita modi = new ModificarCita();
				modi.setModal(true);
				modi.setLocationRelativeTo(null);
				modi.setVisible(true);
			}
		});
		btnModificarCita.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/editnote_pencil_edi_6175 (1).png")));
		btnModificarCita.setBounds(10, 332, 179, 63);
		panelBienvenida.add(btnModificarCita);
		
		JButton btnSalir = new JButton("Cerrar Sesion");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion inicio = new IniciarSesion();
				int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Si", "No" }, null); 
				if(resp == 0){
				setVisible(false);
				inicio.setVisible(true);} else{
					repaint();
				}
			}
		});
		btnSalir.setIcon(new ImageIcon(VentanaSecretaria.class.getResource("/Imagenes/stop_exit_close_6291.png")));
		btnSalir.setBounds(10, 424, 179, 63);
		panelBienvenida.add(btnSalir);
		
		JPanel panelCitas = new JPanel();
		panelCitas.setBackground(new Color(176, 196, 222));
		panelCitas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Lista de Citas:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCitas.setBounds(219, 11, 1121, 707);
		panel.add(panelCitas);
		panelCitas.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 1101, 627);
		panelCitas.add(scrollPane);
		
		tableCitas = new JTable();
		tableCitas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cedula", "Nombre Completo", "Doctor", "Fecha", "Hora","Estado"
				}
			));
			JTableHeader header = tableCitas.getTableHeader();
		    header.setBackground(new Color(176, 196, 222));
		    tableCitas.setDefaultEditor(Object.class, null);
		    tableCitas.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableCitas);
	}
}

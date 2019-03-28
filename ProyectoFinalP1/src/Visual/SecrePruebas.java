package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;

public class SecrePruebas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecrePruebas frame = new SecrePruebas();
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
	public SecrePruebas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setResizable(false);
		setTitle("Secretario/a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		
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
		panelBienvenida.setBounds(10, 11, 199, 411);
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
		panelCitas.setBounds(219, 11, 787, 411);
		panel.add(panelCitas);
		panelCitas.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Datos de Persona:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 767, 247);
		panelCitas.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 160, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 118, 77, 14);
		panel_1.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 143, 112, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(156, 118, 69, 14);
		panel_1.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 143, 124, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCedula_1 = new JLabel("Cedula:");
		lblCedula_1.setBounds(10, 84, 46, 14);
		panel_1.add(lblCedula_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(65, 81, 160, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 174, 46, 14);
		panel_1.add(lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 199, 46, 20);
		panel_1.add(comboBox);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(156, 174, 69, 14);
		panel_1.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setBounds(156, 199, 124, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Pais de Origen:");
		lblNacionalidad.setBounds(379, 118, 106, 14);
		panel_1.add(lblNacionalidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(379, 143, 153, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(379, 58, 153, 14);
		panel_1.add(lblFechaDeNacimiento);
		
		textField_5 = new JTextField();
		textField_5.setBounds(379, 81, 124, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setBounds(379, 174, 124, 14);
		panel_1.add(lblCorreoElectronico);
		
		textField_6 = new JTextField();
		textField_6.setBounds(379, 199, 206, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnBuscarPersona = new JButton("");
		btnBuscarPersona.setIcon(new ImageIcon(SecrePruebas.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		btnBuscarPersona.setBounds(180, 36, 42, 23);
		panel_1.add(btnBuscarPersona);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SecrePruebas.class.getResource("/Imagenes/woman.png")));
		lblNewLabel_1.setBounds(616, 48, 95, 154);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblBusquedaDePersona = new JLabel("Busqueda de Persona:");
		lblBusquedaDePersona.setBounds(10, 11, 132, 14);
		panel_1.add(lblBusquedaDePersona);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Cita:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 261, 767, 139);
		panelCitas.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDoctor = new JLabel("Busqueda de Doctor:");
		lblDoctor.setBounds(10, 25, 128, 14);
		panel_2.add(lblDoctor);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 50, 163, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnBuscarDoctor = new JButton("");
		btnBuscarDoctor.setIcon(new ImageIcon(SecrePruebas.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		btnBuscarDoctor.setBounds(183, 49, 42, 23);
		panel_2.add(btnBuscarDoctor);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 81, 73, 14);
		panel_2.add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		lblApellido_1.setBounds(150, 81, 75, 14);
		panel_2.add(lblApellido_1);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(10, 106, 113, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(150, 106, 121, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(321, 25, 46, 14);
		panel_2.add(lblFecha);
		
		textField_10 = new JTextField();
		textField_10.setBounds(321, 50, 113, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(321, 81, 46, 14);
		panel_2.add(lblHora);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setBounds(321, 106, 39, 20);
		panel_2.add(spinner);
		
		JRadioButton rdbtnAm = new JRadioButton("AM");
		rdbtnAm.setBounds(366, 105, 53, 23);
		panel_2.add(rdbtnAm);
		
		JRadioButton rdbtnPm = new JRadioButton("PM");
		rdbtnPm.setBounds(421, 105, 52, 23);
		panel_2.add(rdbtnPm);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.setIcon(new ImageIcon(SecrePruebas.class.getResource("/Imagenes/acceptar.png")));
		btnNewButton.setBounds(630, 60, 113, 34);
		panel_2.add(btnNewButton);
		
		JLabel lblObservacion = new JLabel("Observacion:");
		lblObservacion.setBounds(479, 25, 89, 14);
		panel_2.add(lblObservacion);
		
		textField_11 = new JTextField();
		textField_11.setBounds(479, 50, 113, 76);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		
	}
}

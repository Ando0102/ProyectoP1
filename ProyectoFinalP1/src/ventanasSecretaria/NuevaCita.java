package ventanasSecretaria;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NuevaCita extends JPanel {
	private JTextField txtBusquedaPersona;
	private JTextField txtNombrePersona;
	private JTextField txtApellidoPersona;
	private JTextField txtID;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtNombreDoctor;
	private JTextField txtApellidoDoctor;

	/**
	 * Create the panel.
	 */
	public NuevaCita() {
		setLayout(null);
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setBounds(219, 11, 797, 499);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBorder(new TitledBorder(null, "Datos de Persona:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelDatosPersona.setBounds(10, 11, 777, 297);
		add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblBusquedaDePersona = new JLabel("Busqueda de Persona:");
		lblBusquedaDePersona.setBounds(10, 11, 127, 14);
		panelDatosPersona.add(lblBusquedaDePersona);
		
		txtBusquedaPersona = new JTextField();
		txtBusquedaPersona.setBounds(10, 29, 159, 20);
		panelDatosPersona.add(txtBusquedaPersona);
		txtBusquedaPersona.setColumns(10);
		
		JButton btnBusquedaPersona = new JButton("");
		btnBusquedaPersona.setIcon(new ImageIcon(NuevaCita.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		btnBusquedaPersona.setBounds(187, 28, 65, 23);
		panelDatosPersona.add(btnBusquedaPersona);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido:");
		lblNombreYApellido.setBounds(10, 79, 127, 14);
		panelDatosPersona.add(lblNombreYApellido);
		
		txtNombrePersona = new JTextField();
		txtNombrePersona.setBounds(10, 104, 108, 20);
		panelDatosPersona.add(txtNombrePersona);
		txtNombrePersona.setColumns(10);
		
		txtApellidoPersona = new JTextField();
		txtApellidoPersona.setBounds(140, 104, 108, 20);
		panelDatosPersona.add(txtApellidoPersona);
		txtApellidoPersona.setColumns(10);
		
		JLabel lblNumeroDeIdentificacion = new JLabel("Numero de Identificacion:");
		lblNumeroDeIdentificacion.setBounds(10, 144, 143, 14);
		panelDatosPersona.add(lblNumeroDeIdentificacion);
		
		txtID = new JTextField();
		txtID.setBounds(10, 169, 127, 20);
		panelDatosPersona.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 209, 46, 14);
		panelDatosPersona.add(lblSexo);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"F", "M"}));
		cmbSexo.setBounds(10, 234, 46, 20);
		panelDatosPersona.add(cmbSexo);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de Telefono:");
		lblNumeroDeTelefono.setBounds(140, 209, 108, 14);
		panelDatosPersona.add(lblNumeroDeTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(140, 234, 108, 20);
		panelDatosPersona.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblPaisDeOrigen = new JLabel("Pais de Origen:");
		lblPaisDeOrigen.setBounds(345, 79, 101, 14);
		panelDatosPersona.add(lblPaisDeOrigen);
		
		JComboBox cmbPaisOrigen = new JComboBox();
		cmbPaisOrigen.setBounds(345, 104, 134, 20);
		panelDatosPersona.add(cmbPaisOrigen);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(345, 209, 101, 14);
		panelDatosPersona.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(345, 234, 265, 20);
		panelDatosPersona.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setBounds(345, 144, 101, 14);
		panelDatosPersona.add(lblCorreoElectronico);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(345, 169, 265, 20);
		panelDatosPersona.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/agregarPacientes1.png")));
		lblNewLabel.setBounds(631, 68, 65, 72);
		panelDatosPersona.add(lblNewLabel);
		
		JPanel panelDatosCita = new JPanel();
		panelDatosCita.setBorder(new TitledBorder(null, "Datos de la Cita:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelDatosCita.setBounds(10, 319, 777, 169);
		add(panelDatosCita);
		panelDatosCita.setLayout(null);
		
		JLabel lblBusquedaDeDoctor = new JLabel("Busqueda de Doctor:");
		lblBusquedaDeDoctor.setBounds(10, 11, 108, 14);
		panelDatosCita.add(lblBusquedaDeDoctor);
		
		JComboBox cmbBusquedaDoctor = new JComboBox();
		cmbBusquedaDoctor.setEditable(true);
		cmbBusquedaDoctor.setBounds(10, 35, 176, 20);
		panelDatosCita.add(cmbBusquedaDoctor);
		
		JLabel lblNombreYApellido_1 = new JLabel("Nombre y Apellido:");
		lblNombreYApellido_1.setBounds(10, 77, 118, 14);
		panelDatosCita.add(lblNombreYApellido_1);
		
		txtNombreDoctor = new JTextField();
		txtNombreDoctor.setEditable(false);
		txtNombreDoctor.setBounds(10, 100, 108, 20);
		panelDatosCita.add(txtNombreDoctor);
		txtNombreDoctor.setColumns(10);
		
		txtApellidoDoctor = new JTextField();
		txtApellidoDoctor.setEditable(false);
		txtApellidoDoctor.setColumns(10);
		txtApellidoDoctor.setBounds(140, 100, 108, 20);
		panelDatosCita.add(txtApellidoDoctor);
		
	}
}

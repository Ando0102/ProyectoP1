package ventanasSecretaria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import javafx.scene.control.ComboBox;

import java.awt.Toolkit;
import java.awt.Color;

public class NuevaCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBusquedaPersona;
	private JTextField txtIdPersona;
	private JTextField txtNombrePersona;
	private JTextField txtApellidoPersona;
	private JTextField txtTelefono;
	private JTextField txtNacimientoPersona;
	private JTextField txtCorreoPersona;
	private JTextField txtBusquedaDoctor;
	private JTextField txtNombreDoctor;
	private JTextField txtApellidoDoctor;
	private JTextField txtFechaCita;
	private JTextField txtHoraCita;
	private JComboBox cmbSexoPersona;
	private JComboBox cmbPaisOrigenPersona;
	private static int opcion = 0;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			NuevaCita dialog = new NuevaCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevaCita() {
		setTitle("Nueva Cita");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevaCita.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 839, 659);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDatosPersona.setBackground(new Color(230, 230, 250));
		panelDatosPersona.setBounds(10, 11, 803, 354);
		contentPanel.add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblBusquedaDePersona = new JLabel("Busqueda de Persona:");
		lblBusquedaDePersona.setBounds(10, 11, 166, 14);
		panelDatosPersona.add(lblBusquedaDePersona);
		
		txtBusquedaPersona = new JTextField();
		txtBusquedaPersona.setBackground(new Color(255, 255, 255));
		txtBusquedaPersona.setBounds(10, 36, 166, 20);
		panelDatosPersona.add(txtBusquedaPersona);
		txtBusquedaPersona.setColumns(10);
		
		JButton btnBusquedaPersona = new JButton("");
		btnBusquedaPersona.setBackground(new Color(230, 230, 250));
		btnBusquedaPersona.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/preview_search_find_locate_1551.png")));
		btnBusquedaPersona.setBorder(null);
		btnBusquedaPersona.setBorderPainted(false);
		btnBusquedaPersona.setBounds(186, 36, 32, 32);
		panelDatosPersona.add(btnBusquedaPersona);
		
		JLabel lblNumeroDeIdentificacion = new JLabel("Numero de Identificacion:");
		lblNumeroDeIdentificacion.setBounds(10, 165, 166, 14);
		panelDatosPersona.add(lblNumeroDeIdentificacion);
		
		txtIdPersona = new JTextField();
		txtIdPersona.setBackground(new Color(255, 255, 255));
		txtIdPersona.setBounds(10, 190, 166, 20);
		panelDatosPersona.add(txtIdPersona);
		txtIdPersona.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 89, 67, 14);
		panelDatosPersona.add(lblNombre);
		
		txtNombrePersona = new JTextField();
		txtNombrePersona.setBackground(new Color(255, 255, 255));
		txtNombrePersona.setBounds(10, 114, 166, 20);
		panelDatosPersona.add(txtNombrePersona);
		txtNombrePersona.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(268, 89, 75, 14);
		panelDatosPersona.add(lblApellido);
		
		txtApellidoPersona = new JTextField();
		txtApellidoPersona.setBackground(new Color(255, 255, 255));
		txtApellidoPersona.setBounds(268, 114, 166, 20);
		panelDatosPersona.add(txtApellidoPersona);
		txtApellidoPersona.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 247, 46, 14);
		panelDatosPersona.add(lblSexo);
		
		cmbSexoPersona = new JComboBox();
		cmbSexoPersona.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		cmbSexoPersona.setBackground(new Color(240, 248, 255));
		cmbSexoPersona.setBounds(10, 272, 166, 20);
		panelDatosPersona.add(cmbSexoPersona);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(268, 247, 75, 14);
		panelDatosPersona.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBackground(new Color(255, 255, 255));
		txtTelefono.setBounds(268, 272, 166, 20);
		panelDatosPersona.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(268, 165, 146, 14);
		panelDatosPersona.add(lblFechaDeNacimiento);
		
		txtNacimientoPersona = new JTextField();
		txtNacimientoPersona.setBackground(new Color(255, 255, 255));
		txtNacimientoPersona.setBounds(268, 190, 166, 20);
		panelDatosPersona.add(txtNacimientoPersona);
		txtNacimientoPersona.setColumns(10);
		
		JLabel lblPaisDeOrigen = new JLabel("Pais de Origen:");
		lblPaisDeOrigen.setBounds(516, 165, 109, 14);
		panelDatosPersona.add(lblPaisDeOrigen);
		
		cmbPaisOrigenPersona = new JComboBox();
		cmbPaisOrigenPersona.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos", "Republica Dominicana", "Puerto Rico", "Haiti", "Colombia", "Venezuela"}));
		cmbPaisOrigenPersona.setBackground(new Color(240, 248, 255));
		cmbPaisOrigenPersona.setBounds(516, 190, 220, 20);
		panelDatosPersona.add(cmbPaisOrigenPersona);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setBounds(516, 247, 109, 14);
		panelDatosPersona.add(lblCorreoElectronico);
		
		txtCorreoPersona = new JTextField();
		txtCorreoPersona.setBackground(new Color(255, 255, 255));
		txtCorreoPersona.setBounds(516, 272, 220, 20);
		panelDatosPersona.add(txtCorreoPersona);
		txtCorreoPersona.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/Paciente Mujer.png")));
		lblNewLabel_1.setBounds(542, 32, 83, 122);
		panelDatosPersona.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/person_user_customer_man_male_man_boy_people_1687.png")));
		lblNewLabel_3.setBounds(625, 36, 83, 98);
		panelDatosPersona.add(lblNewLabel_3);
		
		JPanel panelBusquedaDoctor = new JPanel();
		panelBusquedaDoctor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelBusquedaDoctor.setBackground(new Color(230, 230, 250));
		panelBusquedaDoctor.setBounds(10, 376, 384, 190);
		contentPanel.add(panelBusquedaDoctor);
		panelBusquedaDoctor.setLayout(null);
		
		JLabel lblBusquedaDeDoctor = new JLabel("Busqueda de Doctor:");
		lblBusquedaDeDoctor.setBounds(10, 11, 152, 14);
		panelBusquedaDoctor.add(lblBusquedaDeDoctor);
		
		txtBusquedaDoctor = new JTextField();
		txtBusquedaDoctor.setBackground(new Color(255, 255, 255));
		txtBusquedaDoctor.setBounds(10, 36, 167, 20);
		panelBusquedaDoctor.add(txtBusquedaDoctor);
		txtBusquedaDoctor.setColumns(10);
		
		JButton btnBusquedaDoctor = new JButton("");
		btnBusquedaDoctor.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/preview_search_find_locate_1551.png")));
		btnBusquedaDoctor.setBackground(new Color(230, 230, 250));
		btnBusquedaDoctor.setBounds(187, 36, 32, 32);
		btnBusquedaDoctor.setBorder(null);
		btnBusquedaDoctor.setBorderPainted(false);
		panelBusquedaDoctor.add(btnBusquedaDoctor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 167, 97);
		panelBusquedaDoctor.add(scrollPane);
		
		JList listDoctores = new JList();
		listDoctores.setBackground(new Color(240, 248, 255));
		listDoctores.setBorder(new TitledBorder(null, "Lista de Doctores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(listDoctores);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/doctor_128_44166.png")));
		lblNewLabel.setBounds(252, 58, 96, 97);
		panelBusquedaDoctor.add(lblNewLabel);
		
		JPanel panelDatosCita = new JPanel();
		panelDatosCita.setBackground(new Color(230, 230, 250));
		panelDatosCita.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDatosCita.setBounds(404, 376, 409, 190);
		contentPanel.add(panelDatosCita);
		panelDatosCita.setLayout(null);
		
		JLabel lblDatosDeCita = new JLabel("Datos de Cita:");
		lblDatosDeCita.setBounds(10, 11, 119, 14);
		panelDatosCita.add(lblDatosDeCita);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(10, 36, 66, 14);
		panelDatosCita.add(lblDoctor);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 61, 66, 14);
		panelDatosCita.add(lblNombre_1);
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		lblApellido_1.setBounds(165, 61, 72, 14);
		panelDatosCita.add(lblApellido_1);
		
		txtNombreDoctor = new JTextField();
		txtNombreDoctor.setBackground(new Color(255, 255, 255));
		txtNombreDoctor.setEditable(false);
		txtNombreDoctor.setBounds(10, 86, 119, 20);
		panelDatosCita.add(txtNombreDoctor);
		txtNombreDoctor.setColumns(10);
		
		txtApellidoDoctor = new JTextField();
		txtApellidoDoctor.setBackground(new Color(255, 255, 255));
		txtApellidoDoctor.setEditable(false);
		txtApellidoDoctor.setBounds(165, 86, 119, 20);
		panelDatosCita.add(txtApellidoDoctor);
		txtApellidoDoctor.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 117, 66, 14);
		panelDatosCita.add(lblFecha);
		
		txtFechaCita = new JTextField();
		txtFechaCita.setBackground(new Color(255, 255, 255));
		txtFechaCita.setBounds(10, 142, 119, 20);
		panelDatosCita.add(txtFechaCita);
		txtFechaCita.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(165, 117, 46, 14);
		panelDatosCita.add(lblHora);
		
		txtHoraCita = new JTextField();
		txtHoraCita.setBackground(new Color(255, 255, 255));
		txtHoraCita.setBounds(165, 142, 119, 20);
		panelDatosCita.add(txtHoraCita);
		txtHoraCita.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/edit_pencil_6320.png")));
		lblNewLabel_2.setBounds(303, 61, 96, 101);
		panelDatosCita.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("");
				okButton.setBackground(new Color(240, 248, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(opcion == 0){
						JOptionPane.showMessageDialog(null, "Cita creada exitosamente!","Aviso!", JOptionPane.INFORMATION_MESSAGE);
						repaint(); } else {
							JOptionPane.showMessageDialog(null, "Cita editada exitosamente!","Aviso!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						
					}
				});
				okButton.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/acceptar.png")));
				okButton.setActionCommand("OK");
				okButton.setBorder(null);
				okButton.setBorderPainted(false);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/cancelar2.png")));
				cancelButton.setBackground(new Color(240, 248, 255));
				cancelButton.setBorder(null);
				cancelButton.setBorderPainted(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void visualizarCampos(boolean visualizar){
		if(visualizar){
			opcion = 0;
			setVisible(true);
			
		}
		else {
			opcion = 1;
			txtBusquedaPersona.setEditable(false);
			txtNombrePersona.setEditable(false);
			txtApellidoPersona.setEditable(false);
			txtIdPersona.setEditable(false);
			txtNacimientoPersona.setEditable(false);
			txtTelefono.setEditable(false);
			cmbSexoPersona.setEnabled(false);
			cmbPaisOrigenPersona.setEnabled(false);
			txtCorreoPersona.setEditable(false);
			setTitle("Editar Cita");
			setVisible(true);
			
		}
	}
	
}

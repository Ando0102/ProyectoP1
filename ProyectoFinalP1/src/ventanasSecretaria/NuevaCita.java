package ventanasSecretaria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;
import javafx.scene.control.ComboBox;


import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;
import javax.swing.JTable;

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
	private String [] nombres;
	private JTable tableDoctores;
	private TableRowSorter<TableModel> sorter;
	private DefaultTableModel model;
	private Object[] rows;
	private MaskFormatter formatoIDPersona;
	
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
		setBounds(100, 100, 839, 639);
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
		panelDatosPersona.setBounds(10, 11, 803, 327);
		contentPanel.add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblBusquedaDePersona = new JLabel("Busqueda de Persona:");
		lblBusquedaDePersona.setBounds(10, 11, 166, 14);
		panelDatosPersona.add(lblBusquedaDePersona);
		
		txtBusquedaPersona = new JTextField();
        formatoIDPersona = null;
		
		try {
			formatoIDPersona = new MaskFormatter("###########");
			
		}catch (Exception e) {
			
		}
		txtBusquedaPersona = new JFormattedTextField(formatoIDPersona);
		txtBusquedaPersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0'||c>'9') e.consume();
			}
		});
		txtBusquedaPersona.setBackground(new Color(255, 255, 255));
		txtBusquedaPersona.setBounds(10, 36, 166, 20);
		panelDatosPersona.add(txtBusquedaPersona);
		txtBusquedaPersona.setColumns(10);
		
		JButton btnBusquedaPersona = new JButton("");
		btnBusquedaPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Falta validar que no este vacio el textField
				Persona miPersona = null;
				if(!txtBusquedaPersona.getText().isEmpty()){
					miPersona = Clinica.getInstance().miPersona(txtBusquedaPersona.getText().toString());
					if(miPersona!=null){
						JOptionPane.showMessageDialog(null, "Persona encontrada","Informacion", JOptionPane.INFORMATION_MESSAGE);
						txtIdPersona.setText(miPersona.getID().toString());
						txtIdPersona.setEditable(false);
						txtNombrePersona.setText(miPersona.getNombre().toString());
						txtNombrePersona.setEditable(false);
						txtApellidoPersona.setText(miPersona.getApellidos().toString());
						txtApellidoPersona.setEditable(false);
						txtCorreoPersona.setText(miPersona.getCorreo_electronico().toString());
						txtCorreoPersona.setEditable(false);
						if(miPersona.isSexo()== true){
							cmbSexoPersona.setSelectedIndex(0);
						}else{
							cmbSexoPersona.setSelectedIndex(1);
						}
						cmbSexoPersona.setEditable(false);
						cmbPaisOrigenPersona.setSelectedItem(miPersona.getNacionalidad().toString());
						cmbPaisOrigenPersona.setEditable(false);
						txtTelefono.setText(miPersona.getTelefono().toString());
						txtTelefono.setEditable(false);
					}else{
						JOptionPane.showMessageDialog(null, "Persona no encontrada","Aviso", JOptionPane.WARNING_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Favor insertar numero de identificacion","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBusquedaPersona.setBackground(new Color(230, 230, 250));
		btnBusquedaPersona.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/preview_search_find_locate_1551.png")));
		btnBusquedaPersona.setBorder(null);
		btnBusquedaPersona.setBorderPainted(false);
		btnBusquedaPersona.setBounds(186, 36, 32, 32);
		panelDatosPersona.add(btnBusquedaPersona);
		
		JLabel lblNumeroDeIdentificacion = new JLabel("Numero de Identificacion:");
		lblNumeroDeIdentificacion.setBounds(10, 89, 166, 14);
		panelDatosPersona.add(lblNumeroDeIdentificacion);
		
		txtIdPersona = new JTextField();
MaskFormatter formatoIDPersona1 = null;
		
		try {
			formatoIDPersona1 = new MaskFormatter("###########");
			
		}catch (Exception e) {
			
		}
		txtIdPersona = new JFormattedTextField(formatoIDPersona1);
		txtIdPersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0'||c>'9') e.consume();
			}
		});
		txtIdPersona.setBackground(new Color(255, 255, 255));
		txtIdPersona.setBounds(10, 114, 166, 20);
		panelDatosPersona.add(txtIdPersona);
		txtIdPersona.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 165, 67, 14);
		panelDatosPersona.add(lblNombre);
		
		txtNombrePersona = new JTextField();
		txtNombrePersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c>'0'&&c<'9') e.consume();
			}
		});
		txtNombrePersona.setBackground(new Color(255, 255, 255));
		txtNombrePersona.setBounds(10, 190, 166, 20);
		panelDatosPersona.add(txtNombrePersona);
		txtNombrePersona.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 247, 75, 14);
		panelDatosPersona.add(lblApellido);
		
		txtApellidoPersona = new JTextField();
		txtApellidoPersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c>'0'&&c<'9') e.consume();
			}
		});
		txtApellidoPersona.setBackground(new Color(255, 255, 255));
		txtApellidoPersona.setBounds(10, 272, 166, 20);
		panelDatosPersona.add(txtApellidoPersona);
		txtApellidoPersona.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(268, 89, 46, 14);
		panelDatosPersona.add(lblSexo);
		
		cmbSexoPersona = new JComboBox();
		cmbSexoPersona.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		cmbSexoPersona.setBackground(new Color(240, 248, 255));
		cmbSexoPersona.setBounds(268, 114, 166, 20);
		panelDatosPersona.add(cmbSexoPersona);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(516, 165, 75, 14);
		panelDatosPersona.add(lblTelefono);
		
		txtTelefono = new JTextField();
MaskFormatter formatoIDPersona2 = null;
		
		try {
			formatoIDPersona2 = new MaskFormatter("###-###-####");
			
		}catch (Exception e) {
			
		}
		txtTelefono = new JFormattedTextField(formatoIDPersona2);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0'||c>'9') e.consume();
			}
		});
		txtTelefono.setBackground(new Color(255, 255, 255));
		txtTelefono.setBounds(516, 190, 220, 20);
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
		lblPaisDeOrigen.setBounds(268, 247, 109, 14);
		panelDatosPersona.add(lblPaisDeOrigen);
		
		cmbPaisOrigenPersona = new JComboBox();
		cmbPaisOrigenPersona.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos", "Republica Dominicana", "Puerto Rico", "Haiti", "Colombia", "Venezuela"}));
		cmbPaisOrigenPersona.setBackground(new Color(240, 248, 255));
		cmbPaisOrigenPersona.setBounds(268, 272, 166, 20);
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
		panelBusquedaDoctor.setBounds(10, 349, 384, 199);
		contentPanel.add(panelBusquedaDoctor);
		panelBusquedaDoctor.setLayout(null);
		
		JLabel lblBusquedaDeDoctor = new JLabel("Busqueda de Doctor:");
		lblBusquedaDeDoctor.setBounds(10, 11, 152, 14);
		panelBusquedaDoctor.add(lblBusquedaDeDoctor);
		
		
		txtBusquedaDoctor= new JTextField();
		txtBusquedaDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c>'0'&&c<'9') e.consume();
			}
		});
		
		txtBusquedaDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!txtBusquedaDoctor.isEnabled()) {
					return;
				}
				else{
							tableFilter(txtBusquedaDoctor.getText(), tableDoctores.getColumnCount());
						
					}
					
				}
			
		});
		
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
		scrollPane.setBounds(10, 82, 209, 97);
		
		panelBusquedaDoctor.add(scrollPane);
		
		model = new DefaultTableModel();
		sorter = new TableRowSorter<TableModel>(model);
		model.setColumnCount(1);
		
		tableDoctores = new JTable();
		tableDoctores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lista de Doctores"
			}
		));
		JTableHeader header = tableDoctores.getTableHeader();
	    header.setBackground(new Color(230, 230, 250));
	     
	    tableDoctores.setBackground( new Color(240, 248, 255));
		tableDoctores.setDefaultEditor(Object.class, null);
		tableDoctores.setAutoCreateRowSorter(true);
		tableDoctores.setColumnSelectionAllowed(true);
		tableDoctores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableDoctores.setCellSelectionEnabled(true);
		//tableDoctores.setCellEditor(null);
		tableDoctores.setVisible(true);
		tableDoctores.setCellSelectionEnabled(true);
		tableDoctores.setRowSorter(sorter);
		tableDoctores.setName("Lista de Doctores");
		loadtable();
		scrollPane.setViewportView(tableDoctores);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/doctor_128_44166.png")));
		lblNewLabel.setBounds(252, 58, 96, 97);
		panelBusquedaDoctor.add(lblNewLabel);
		
		JPanel panelDatosCita = new JPanel();
		panelDatosCita.setBackground(new Color(230, 230, 250));
		panelDatosCita.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDatosCita.setBounds(404, 349, 409, 199);
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
				JButton btnListo = new JButton("Listo");
				btnListo.setBackground(UIManager.getColor("Button.highlight"));
				btnListo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(opcion == 0){
						JOptionPane.showMessageDialog(null, "Cita creada exitosamente!","Aviso!", JOptionPane.INFORMATION_MESSAGE);
						repaint(); } else {
							JOptionPane.showMessageDialog(null, "Cita editada exitosamente!","Aviso!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						
					}
				});
				btnListo.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/acceptar.png")));
				btnListo.setActionCommand("OK");
				buttonPane.add(btnListo);
				getRootPane().setDefaultButton(btnListo);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Si", "No" }, null); 
						if(resp == 0){
						dispose();
						} else{
							repaint();
						}
						
					}
				});
				btnCancelar.setIcon(new ImageIcon(NuevaCita.class.getResource("/Imagenes/cancelar2.png")));
				btnCancelar.setBackground(UIManager.getColor("Button.highlight"));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
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
	
	private Object[][] fillDoctores() {
		ArrayList <Doctor> misDoctores = new ArrayList <Doctor>();
		misDoctores =  Clinica.getInstance().doctores();
		Object[][] result = new Object[misDoctores.size()][1];
		String[] aux = null;
		
		for (int i = 0; i <misDoctores.size() ; i++) {
			aux = new String[4];
			aux[0] = misDoctores.get(i).getNombre()+" "+ misDoctores.get(i).getApellidos();
			result[i] = aux;
			}
		return result;
	}
	private void loadtable() {
		//Cargar la tabla
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Doctor aux : Clinica.getInstance().doctores()) {
			addRow(aux);
		}
	}

	private void addRow(Doctor aux) {
		//Agregar fila
		rows[0] = aux.getNombre()+" "+ aux.getApellidos();
		
		model.addRow(rows);
	}
	
	private void tableFilter(String text, int index) {
		//Filtro de la tabla
	    RowFilter<TableModel, Object> filter = null;
	    try {
	    	filter = RowFilter.regexFilter("(?i)"+text, 0);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(filter);
	}
	
}

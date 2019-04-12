package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import Logical.Cita;
import Logical.Clinica;
import Logical.Doctor;
import Logical.Persona;
import Logical.Secretaria;
import Logical.User;
import Visual.Administrator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;

public class VentanaEmpleados_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JFormattedTextField txtCedula;
	public JFormattedTextField txtTelefono;
	public JTextField txtCorreoElect;
	private JPanel panelAgregar;
	public JTextField txtNombreModi;
	public JTextField txtApellidoModi;
	public JFormattedTextField txtTelefonoModi;
	public JTextField txtCorreoModi;
	public JComboBox cbxPais;
	public JComboBox cbxGenero;
	public JDateChooser dcFechaNacimiento;
	private JTabbedPane tabbedPane;
	public JCheckBox rtbAdministrador;
	public JCheckBox rbtDoctor;
	public JCheckBox rbtSecre;
	private JPanel PanelinfoEmpleado;
	public ButtonGroup botones1;
	private DefaultTableModel model;
	private Object[] rows;
	private TableRowSorter<TableModel> sorter;
	private JTable tablaEmpleados;
	private int elegido;
	private JScrollPane scrollPane;
	private Object[] fila;
	private JTable table;
	private int index;
	private JRadioButton rbtAdmModi;
	private JRadioButton rbtDoctModi;
	private JRadioButton rbtSecreModi;
	private JButton btnNewButton_2;
	private User Personaje;

	/**
	 * Launch the application.
	 *//*
	
	public static void main(String[] args) {
		try {
			VentanaEmpleados_admin dialog = new VentanaEmpleados_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaEmpleados_admin() {
		setResizable(false);
		setModal(true);
		setTitle("Informaci\u00F3n de los empleados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEmpleados_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 617, 557);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		botones1 = new ButtonGroup(); //GRUPO PARA LOS BOTONES
		
		MaskFormatter  formatoCedu = null, formatoTele = null;
		try {
			formatoTele = new MaskFormatter("###-###-####");
			formatoCedu = new MaskFormatter("###-#######-#");

		}catch (Exception e) {
			
		}

		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBackground(new Color(240, 248, 255));
				panel.add(tabbedPane, BorderLayout.CENTER);
				{
					panelAgregar = new JPanel();
					panelAgregar.setBackground(new Color(230, 230, 250));
					panelAgregar.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Informaci\u00F3n del Nuevo Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					tabbedPane.addTab("Agregar Nuevo Empleado", null, panelAgregar, null);
					panelAgregar.setLayout(null);
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/plus_15650.png")));
						lblNewLabel_1.setBounds(412, 142, 72, 67);
						panelAgregar.add(lblNewLabel_1);
					}
					{
						JLabel label = new JLabel("Nombres :");
						label.setBounds(36, 36, 72, 22);
						panelAgregar.add(label);
					}
					{
						txtNombre = new JTextField();
						txtNombre.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent arg0) {
								txtNombre.setBorder( new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtNombre.setColumns(10);
						txtNombre.setBounds(36, 64, 158, 20);
						txtNombre.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(txtNombre);
					}
					{
						JLabel label = new JLabel("Apellidos :");
						label.setBounds(218, 40, 93, 18);
						panelAgregar.add(label);
					}
					{
						txtApellido = new JTextField();
						txtApellido.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								txtApellido.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtApellido.setColumns(10);
						txtApellido.setBounds(218, 64, 158, 20);
						txtApellido.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(txtApellido);
					}
					{
						JLabel label = new JLabel("Cedula :");
						label.setBounds(36, 106, 64, 18);
						panelAgregar.add(label);
					}
					{
						txtCedula = new JFormattedTextField(formatoCedu);
						txtCedula.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								txtCedula.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtCedula.setColumns(10);
						txtCedula.setBounds(36, 130, 158, 20);
						txtCedula.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(txtCedula);
					}
					{
						JLabel label = new JLabel("Tel\u00E9fono :");
						label.setBounds(218, 101, 72, 18);
						panelAgregar.add(label);
					}
					{
						txtTelefono = new JFormattedTextField(formatoTele);
						txtTelefono.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								txtTelefono.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtTelefono.setColumns(10);
						txtTelefono.setBounds(218, 130, 158, 20);
						txtTelefono.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(txtTelefono);
					}
					{
						JLabel lblSexo = new JLabel("Sexo :");
						lblSexo.setBounds(30, 247, 72, 14);
						panelAgregar.add(lblSexo);
					}
					{
						cbxGenero = new JComboBox();
						cbxGenero.setBackground(new Color(240, 248, 255));
						cbxGenero.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								cbxGenero.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Sexo>", "Masculino", "Femenino"}));
						cbxGenero.setSelectedIndex(0);
						cbxGenero.setBounds(30, 272, 158, 20);
						cbxGenero.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(cbxGenero);
					}
					{
						JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen :");
						lblPasDeOrigen.setBounds(406, 244, 98, 20);
						panelAgregar.add(lblPasDeOrigen);
					}
					{
						cbxPais = new JComboBox();
						cbxPais.setBackground(new Color(240, 248, 255));
						cbxPais.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cbxPais.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
						cbxPais.setSelectedIndex(0);
						cbxPais.setMaximumRowCount(5);
						cbxPais.setBounds(406, 272, 158, 20);
						cbxPais.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(cbxPais);
					}
					{
						JLabel label = new JLabel("Correo El\u00E9ctronico :");
						label.setBounds(36, 170, 145, 20);
						panelAgregar.add(label);
					}
					{
						txtCorreoElect = new JTextField();
						txtCorreoElect.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								txtCorreoElect.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtCorreoElect.setColumns(10);
						txtCorreoElect.setBounds(36, 201, 340, 20);
						txtCorreoElect.setBorder(new LineBorder(new Color(192, 192, 192)));
						
						panelAgregar.add(txtCorreoElect);
					}
					{
						JLabel label = new JLabel("Fecha de Nacimiento :");
						label.setBounds(218, 247, 125, 14);
						panelAgregar.add(label);
					}
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/users.png")));
						lblNewLabel.setBounds(439, 60, 125, 128);
						panelAgregar.add(lblNewLabel);
					}
					
					dcFechaNacimiento = new JDateChooser();
					dcFechaNacimiento.setBackground(new Color(255, 255, 255));
					dcFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dcFechaNacimiento.setBorder( new LineBorder( new Color(192, 192, 192)));
						}
					});
					dcFechaNacimiento.setBounds(218, 274, 158, 20);
					dcFechaNacimiento.setBorder( new LineBorder( new Color(192, 192, 192)));
					panelAgregar.add(dcFechaNacimiento);
					
					
					rtbAdministrador = new JCheckBox("Administrador");
					rtbAdministrador.setBounds(60, 345, 109, 23);
					rtbAdministrador.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rtbAdministrador);
					botones1.add(rtbAdministrador);
					
					rbtDoctor = new JCheckBox("Doctor");
					rbtDoctor.setBounds(236, 345, 109, 23);
					rbtDoctor.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rbtDoctor);
					botones1.add(rbtDoctor);
					
					rbtSecre = new JCheckBox("Secretaria");
					rbtSecre.setBounds(412, 345, 109, 23);
					rbtSecre.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rbtSecre);
					botones1.add(rbtSecre);
					
					{
						JButton btnNewButton = new JButton("Siguiente");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
												
								if((dcFechaNacimiento.getDate()!=null)&&!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("") && cbxGenero.getSelectedIndex() != 0 &&
										txtCedula.getValue() != null && txtTelefono.getValue() != null && (rbtDoctor.isSelected() || rbtSecre.isSelected() || rtbAdministrador.isSelected()) && cbxPais.getSelectedIndex() != 0){
										
									
									///Calendario ACTUAL//// Esto está aqui adentro por protección/
									  Calendar calendario = new GregorianCalendar();
									  calendario.add(Calendar.DATE, -30);
									  Calendar esfimero = new GregorianCalendar();
									  esfimero.setTime(dcFechaNacimiento.getDate());
									/////////////////////////////////

									
									if(esfimero.getTime().compareTo(calendario.getTime()) < 0) {			
											if(VerificandoExistencia((String)txtCedula.getValue())) {
														PanelSeguridadSecre aux = new PanelSeguridadSecre(txtApellido, txtCedula, txtCorreoElect, txtNombre, txtTelefono, cbxGenero, cbxPais, dcFechaNacimiento, rbtDoctor, rbtSecre, rtbAdministrador);
														dispose();
														aux.setVisible(true);
											}else {
												JOptionPane.showMessageDialog(null, "La persona que desea agregar, ya está Registrada", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
		
											}
										}else {
											JOptionPane.showMessageDialog(null, "Revisar Fecha de Nacimiento, la persona debe tener 1 mes de nacida ", "Advertencia", JOptionPane.WARNING_MESSAGE, null);

										}
									
								}else {
									JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
									
									if(txtNombre.getText().equalsIgnoreCase("")) {
										
										txtNombre.setBorder(new LineBorder(new Color(204, 0, 0)));
									}
									if(txtApellido.getText().equalsIgnoreCase("")) {
										txtApellido.setBorder(new LineBorder(new Color(204, 0 , 0)));
									}
									if(txtCedula.getValue() == null) {
										txtCedula.setBorder(new LineBorder(new Color(204, 0, 0)));
									}
									if(txtTelefono.getValue() == null) {
										txtTelefono.setBorder( new LineBorder( new Color(204, 0, 0)));
									}
									if(txtCorreoElect.getText().equalsIgnoreCase("")) {
										txtCorreoElect.setBorder(new LineBorder(new Color(204, 0 , 0)));
									}
									if(cbxGenero.getSelectedIndex() == 0) {
										cbxGenero.setBorder( new LineBorder(new Color(204, 0, 0)));
									}
									if(cbxPais.getSelectedIndex() == 0) {
										cbxPais.setBorder( new LineBorder(new Color(204, 0, 0)));
									}
									if(dcFechaNacimiento.getDate() == null) {
										dcFechaNacimiento.setBorder( new LineBorder(new Color(204, 0, 0)));
									}
								}	
							}

							
						});
						btnNewButton.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
						btnNewButton.setBounds(461, 438, 125, 41);
						panelAgregar.add(btnNewButton);
					}
					

					
					JLabel lblRolDelEmpleado = new JLabel("Rol del Empleado en la Clinica :");
					lblRolDelEmpleado.setBounds(30, 314, 234, 16);
					panelAgregar.add(lblRolDelEmpleado);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_1.setBackground(new Color(230, 230, 250));
					tabbedPane.addTab("Modificar Empleado", null, panel_1, null);
					panel_1.setLayout(null);
					{
						PanelinfoEmpleado = new JPanel();
						PanelinfoEmpleado.setBackground(new Color(230, 230, 250));
						PanelinfoEmpleado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						PanelinfoEmpleado.setBounds(10, 178, 576, 253);
						panel_1.add(PanelinfoEmpleado);
						PanelinfoEmpleado.setLayout(null);
						{
							JLabel label = new JLabel("");
							label.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
							label.setBounds(447, 122, 93, 70);
							PanelinfoEmpleado.add(label);
						}
						{
							JLabel label = new JLabel("Nombres :");
							label.setBounds(10, 23, 71, 19);
							PanelinfoEmpleado.add(label);
						}
						{
							txtNombreModi = new JTextField();
							txtNombreModi.setColumns(10);
							txtNombreModi.setBounds(10, 53, 130, 20);
							PanelinfoEmpleado.add(txtNombreModi);
						}
						{
							JLabel label = new JLabel("Apellidos :");
							label.setBounds(182, 28, 83, 14);
							PanelinfoEmpleado.add(label);
						}
						{
							txtApellidoModi = new JTextField();
							txtApellidoModi.setColumns(10);
							txtApellidoModi.setBounds(182, 53, 130, 20);
							PanelinfoEmpleado.add(txtApellidoModi);
						}
						{
							JLabel label = new JLabel("Tel\u00E9fono :");
							label.setBounds(348, 24, 83, 19);
							PanelinfoEmpleado.add(label);
						}
						{
							txtTelefonoModi = new JFormattedTextField(formatoTele);
							txtTelefonoModi.setColumns(10);
							txtTelefonoModi.setBounds(348, 53, 130, 20);
							PanelinfoEmpleado.add(txtTelefonoModi);
						}
						{
							JLabel label = new JLabel("Correo El\u00E9ctronico :");
							label.setBounds(10, 97, 174, 20);
							PanelinfoEmpleado.add(label);
						}
						{
							txtCorreoModi = new JTextField();
							txtCorreoModi.setColumns(10);
							txtCorreoModi.setBounds(10, 128, 302, 20);
							PanelinfoEmpleado.add(txtCorreoModi);
						}
						{
							JLabel lblNewLabel_5 = new JLabel("");
							lblNewLabel_5.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/doctora.png")));
							lblNewLabel_5.setBounds(473, 71, 93, 107);
							PanelinfoEmpleado.add(lblNewLabel_5);
						}
						{
							JLabel label = new JLabel("Rol del Empleado en la Clinica :");
							label.setBounds(10, 176, 234, 16);
							PanelinfoEmpleado.add(label);
						}
						{
							rbtAdmModi = new JRadioButton("Administrador");
							rbtAdmModi.setBackground(new Color(230, 230, 250));
							rbtAdmModi.setBounds(38, 199, 109, 23);
							PanelinfoEmpleado.add(rbtAdmModi);
							botones1.add(rbtAdmModi);
						}
						{
							rbtDoctModi = new JRadioButton("Doctor");
							rbtDoctModi.setBackground(new Color(230, 230, 250));
							rbtDoctModi.setBounds(214, 199, 109, 23);
							PanelinfoEmpleado.add(rbtDoctModi);
							botones1.add(rbtDoctModi);
						}
						{
							rbtSecreModi = new JRadioButton("Secretaria");
							rbtSecreModi.setBackground(new Color(230, 230, 250));
							rbtSecreModi.setBounds(390, 199, 109, 23);
							PanelinfoEmpleado.add(rbtSecreModi);
							botones1.add(rbtSecreModi);
						}
					}
					
				
					{
						
						String[] titu = {"Cedula", "Nombre ", "Rol en la Clinica"};
						model = new DefaultTableModel();
						model.setColumnIdentifiers(titu);
						loadtable();

					}
					{
						btnNewButton_2 = new JButton("Listo");
						
						btnNewButton_2.setBounds(316, 442, 130, 36);
						panel_1.add(btnNewButton_2);
						btnNewButton_2.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/acceptar.png")));
					}
					{
						JButton btnNewButton_1 = new JButton("Cancelar\r\n");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
							}
						});
						btnNewButton_1.setBounds(456, 442, 130, 36);
						panel_1.add(btnNewButton_1);
						btnNewButton_1.setIcon(new ImageIcon(VentanaEmpleados_admin.class.getResource("/Imagenes/cancelar2.png")));
					}
					
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new TitledBorder(null, "Lista de Empleados", TitledBorder.CENTER, TitledBorder.TOP, null, null));
					panel_2.setBounds(10, 11, 576, 156);
					panel_2.setBackground(new Color(230, 230, 250));
					panel_1.add(panel_2);
					panel_2.setLayout(new BorderLayout(0, 0));
					scrollPane = new JScrollPane();
					panel_2.add(scrollPane, BorderLayout.CENTER);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						
						@Override
						public void mouseClicked(MouseEvent arg0) {
								if(table.getSelectedRow()>=0){
								
									String buscarCedula = null;
									
									buscarCedula = (String) table.getValueAt(table.getSelectedRow(), 0);
									CargarModificacion(BuscarEmpleado(buscarCedula));
									
								}
							
						}

						

					});		
					
											table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
											table.setModel(model);
											scrollPane.setViewportView(table);
											
									btnNewButton_2.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
												
												User aux = null;
												aux = Personaje;
												Personaje = null;
													
												if(!txtApellidoModi.getText().equalsIgnoreCase("") && !txtCorreoModi.getText().equalsIgnoreCase("") && !txtNombreModi.getText().equalsIgnoreCase("")) {
													
													for(int i = 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
														
														if(Clinica.getInstance().getMisPersonas().get(i).getCedula().equalsIgnoreCase(aux.getCedula())) {
															Clinica.getInstance().getMisPersonas().remove(i);
														}
													}
													
														if(rbtDoctModi.isSelected()) {
															
															Persona aux2 = new Doctor(txtNombreModi.getText(), txtApellidoModi.getText(), aux.getCedula(), aux.isSexo(), txtTelefonoModi.getText(), aux.getNacionalidad(), aux.getFecha_nacimiento(), txtCorreoModi.getText(), aux.getUsuario(), aux.getConstrasenna(), "Doctor");
															Clinica.getInstance().insertarPersona(aux2);
															JOptionPane.showMessageDialog(null, "Doctor Modificado", "Información", JOptionPane.INFORMATION_MESSAGE, null);
															dispose();
															
														}else if(rbtSecreModi.isSelected()) {
															
															Persona aux2 = new Secretaria(txtNombreModi.getText(), txtApellidoModi.getText(), aux.getCedula(), aux.isSexo(), txtTelefonoModi.getText(), aux.getNacionalidad(), aux.getFecha_nacimiento(), txtCorreoModi.getText(), aux.getUsuario(), aux.getConstrasenna(), "Secretaria");
															Clinica.getInstance().insertarPersona(aux2);
															JOptionPane.showMessageDialog(null, "Secretaria Modificada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
															dispose();
															
														}else {
															Persona aux2 = new User(txtNombreModi.getText(), txtApellidoModi.getText(), aux.getCedula(), aux.isSexo(), txtTelefonoModi.getText(), aux.getNacionalidad(), aux.getFecha_nacimiento(), txtCorreoModi.getText(), aux.getUsuario(), aux.getConstrasenna(), "Administrador");
															Clinica.getInstance().insertarPersona(aux2);
															JOptionPane.showMessageDialog(null, "Administrador Modificado", "Información", JOptionPane.INFORMATION_MESSAGE, null);
															dispose();
															
														}
													
													
												}else {
													
													JOptionPane.showMessageDialog(null, "Por favor, Completar Los Campos Vacio", "Advertencia", JOptionPane.WARNING_MESSAGE, null);

													
												}
											}
									});
				}
			}
		}
	}
	
	/////////////METODOS PARA LA TABLA////////////////////////////////////////
	
	private void loadtable() {
		//Cargar la tabla
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i= 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
			if(Clinica.getInstance().getMisPersonas().get(i) instanceof User) {
				
				
				fila[0] = Clinica.getInstance().getMisPersonas().get(i).getCedula();
				fila[1] = Clinica.getInstance().getMisPersonas().get(i).getNombre() + " " + Clinica.getInstance().getMisPersonas().get(i).getApellidos();
				fila[2] = ((User)Clinica.getInstance().getMisPersonas().get(i)).getRol();
						
				
				model.addRow(fila);
				
			
			}
		}
		
	}

	
	private void tableFilter(String text) {
		//Filtro de la tabla
	    RowFilter<TableModel, Object> filter = null;
	    try {
	    	filter = RowFilter.regexFilter("(?i)"+ text, 1);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(filter);
	}
	
	private boolean VerificandoExistencia(String value) {
		Boolean No_esta = true;
		
			for(int i =0 ; i<Clinica.getInstance().getMisPersonas().size(); i++) {
				
				if(Clinica.getInstance().getMisPersonas().get(i).getCedula().equalsIgnoreCase(value)) {
					No_esta = false;
				}
				
			}
		
		
		return No_esta;
	}
	
	private User BuscarEmpleado(String buscarCedula) { //Busca empleados mediante cedula
		User aux = null;
		for(int i= 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
			
		
				if(Clinica.getInstance().getMisPersonas().get(i).getCedula().equalsIgnoreCase(buscarCedula)) {
					
					aux = ((User)Clinica.getInstance().getMisPersonas().get(i));
				}
		}
		
		
		return aux;
	}

	
	private void CargarModificacion(User aux) {
		
		txtNombreModi.setText(aux.getNombre());
		txtApellidoModi.setText(aux.getApellidos());
		txtCorreoModi.setText(aux.getCorreo_electronico());
		txtTelefonoModi.setText(aux.getTelefono());
		
		if(aux.getRol().equalsIgnoreCase("Doctor")) {
			rbtDoctModi.setSelected(true);
			
		}else if(aux.getRol().equalsIgnoreCase("Secretaria")) {
			rbtSecreModi.setSelected(true);
		}else {
			rbtAdmModi.setSelected(true);
		}
		
		Personaje = aux;
	}
	}


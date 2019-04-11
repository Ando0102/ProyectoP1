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

public class VentanaSecre_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JFormattedTextField txtCedula;
	public JFormattedTextField txtTelefono;
	public JTextField txtDireccion;
	public JTextField txtCorreoElect;
	private JPanel panelAgregar;
	public JTextField textField_8;
	public JTextField textField_9;
	public JTextField textField_10;
	public JTextField textField_11;
	public JTextField textField_12;
	public JComboBox cbxPais;
	public JComboBox cbxGenero;
	public JDateChooser dcFechaNacimiento;
	private JTabbedPane tabbedPane;
	private JTextField txtBusqueda;
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

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			VentanaSecre_admin dialog = new VentanaSecre_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaSecre_admin() {
		setResizable(false);
		setModal(true);
		setTitle("Informaci\u00F3n de los empleados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaSecre_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 617, 557);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
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
				tabbedPane.setBackground(new Color(230, 230, 250));
				panel.add(tabbedPane, BorderLayout.CENTER);
				{
					panelAgregar = new JPanel();
					panelAgregar.setBackground(new Color(230, 230, 250));
					panelAgregar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n del Nuevo Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					tabbedPane.addTab("Agregar Nuevo Empleado", null, panelAgregar, null);
					panelAgregar.setLayout(null);
					{
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/plus_15650.png")));
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
						JLabel label = new JLabel("Direcci\u00F3n :");
						label.setBounds(36, 161, 72, 16);
						panelAgregar.add(label);
					}
					{
						txtDireccion = new JTextField();
						txtDireccion.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								txtDireccion.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						txtDireccion.setColumns(10);
						txtDireccion.setBounds(36, 189, 340, 20);
						txtDireccion.setBorder(new LineBorder(new Color(192, 192, 192)));
						
						panelAgregar.add(txtDireccion);
					}
					{
						JLabel lblSexo = new JLabel("Sexo :");
						lblSexo.setBounds(30, 297, 72, 14);
						panelAgregar.add(lblSexo);
					}
					{
						cbxGenero = new JComboBox();
						cbxGenero.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								cbxGenero.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<Sexo>", "Masculino", "Femenino"}));
						cbxGenero.setSelectedIndex(0);
						cbxGenero.setBounds(30, 322, 158, 20);
						cbxGenero.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(cbxGenero);
					}
					{
						JLabel lblPasDeOrigen = new JLabel("Pa\u00EDs de Origen :");
						lblPasDeOrigen.setBounds(406, 294, 98, 20);
						panelAgregar.add(lblPasDeOrigen);
					}
					{
						cbxPais = new JComboBox();
						cbxPais.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								cbxPais.setBorder(new LineBorder(new Color(192, 192, 192)));
							}
						});
						cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
						cbxPais.setSelectedIndex(0);
						cbxPais.setMaximumRowCount(5);
						cbxPais.setBounds(406, 322, 158, 20);
						cbxPais.setBorder(new LineBorder(new Color(192, 192, 192)));
						panelAgregar.add(cbxPais);
					}
					{
						JLabel label = new JLabel("Correo El\u00E9ctronico :");
						label.setBounds(36, 220, 145, 20);
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
						txtCorreoElect.setBounds(36, 251, 340, 20);
						txtCorreoElect.setBorder(new LineBorder(new Color(192, 192, 192)));
						
						panelAgregar.add(txtCorreoElect);
					}
					{
						JLabel label = new JLabel("Fecha de Nacimiento :");
						label.setBounds(218, 297, 125, 14);
						panelAgregar.add(label);
					}
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/users.png")));
						lblNewLabel.setBounds(439, 60, 125, 128);
						panelAgregar.add(lblNewLabel);
					}
					
					dcFechaNacimiento = new JDateChooser();
					dcFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dcFechaNacimiento.setBorder( new LineBorder( new Color(192, 192, 192)));
						}
					});
					dcFechaNacimiento.setBounds(218, 324, 158, 20);
					dcFechaNacimiento.setBorder( new LineBorder( new Color(192, 192, 192)));
					panelAgregar.add(dcFechaNacimiento);
					
					
					rtbAdministrador = new JCheckBox("Administrador");
					rtbAdministrador.setBounds(60, 395, 109, 23);
					rtbAdministrador.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rtbAdministrador);
					botones1.add(rtbAdministrador);
					
					rbtDoctor = new JCheckBox("Doctor");
					rbtDoctor.setBounds(236, 395, 109, 23);
					rbtDoctor.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rbtDoctor);
					botones1.add(rbtDoctor);
					
					rbtSecre = new JCheckBox("Secretaria");
					rbtSecre.setBounds(412, 395, 109, 23);
					rbtSecre.setBackground(new Color(230, 230, 250));
					panelAgregar.add(rbtSecre);
					botones1.add(rbtSecre);
					
					{
						JButton btnNewButton = new JButton("Siguiente");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								///Calendario ACTUAL////
								  Calendar calendario = new GregorianCalendar();
								  calendario.add(Calendar.DATE, -30);
								  Calendar esfimero = new GregorianCalendar();
								  esfimero.setTime(dcFechaNacimiento.getDate());
								/////////////
								
								if((dcFechaNacimiento.getDate()!=null)&&!txtNombre.getText().equalsIgnoreCase("") && !txtApellido.getText().equalsIgnoreCase("") && !txtCorreoElect.getText().equalsIgnoreCase("") && !txtDireccion.getText().equalsIgnoreCase("") && cbxGenero.getSelectedIndex() != 0 &&
										txtCedula.getValue() != null && txtTelefono.getValue() != null && (rbtDoctor.isSelected() || rbtSecre.isSelected() || rtbAdministrador.isSelected()) && cbxPais.getSelectedIndex() != 0){
										
									if(esfimero.getTime().compareTo(calendario.getTime()) < 0) {			
											if(VerificandoExistencia((String)txtCedula.getValue())) {
														PanelSeguridadSecre aux = new PanelSeguridadSecre(txtApellido, txtCedula, txtCorreoElect, txtDireccion, txtNombre, txtTelefono, cbxGenero, cbxPais, dcFechaNacimiento, rbtDoctor, rbtSecre, rtbAdministrador);
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
									if(txtDireccion.getText().equalsIgnoreCase("")) {
										txtDireccion.setBorder(new LineBorder(new Color(204, 0 , 0)));
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
						btnNewButton.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/arrowPeque\u00F1a.png")));
						btnNewButton.setBounds(461, 438, 125, 41);
						panelAgregar.add(btnNewButton);
					}
					

					
					JLabel lblRolDelEmpleado = new JLabel("Rol del Empleado en la Clinica :");
					lblRolDelEmpleado.setBounds(30, 364, 234, 16);
					panelAgregar.add(lblRolDelEmpleado);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(230, 230, 250));
					tabbedPane.addTab("Modificar Empleado", null, panel_1, null);
					panel_1.setLayout(null);
					{
						PanelinfoEmpleado = new JPanel();
						PanelinfoEmpleado.setBackground(new Color(230, 230, 250));
						PanelinfoEmpleado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						PanelinfoEmpleado.setBounds(10, 159, 576, 272);
						panel_1.add(PanelinfoEmpleado);
						PanelinfoEmpleado.setLayout(null);
						{
							JLabel label = new JLabel("");
							label.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
							label.setBounds(413, 135, 93, 70);
							PanelinfoEmpleado.add(label);
						}
						{
							JLabel label = new JLabel("Nombres :");
							label.setBounds(10, 23, 71, 19);
							PanelinfoEmpleado.add(label);
						}
						{
							textField_8 = new JTextField();
							textField_8.setColumns(10);
							textField_8.setBounds(10, 53, 130, 20);
							PanelinfoEmpleado.add(textField_8);
						}
						{
							JLabel label = new JLabel("Apellidos :");
							label.setBounds(182, 28, 83, 14);
							PanelinfoEmpleado.add(label);
						}
						{
							textField_9 = new JTextField();
							textField_9.setColumns(10);
							textField_9.setBounds(182, 53, 130, 20);
							PanelinfoEmpleado.add(textField_9);
						}
						{
							JLabel label = new JLabel("Tel\u00E9fono :");
							label.setBounds(348, 24, 83, 19);
							PanelinfoEmpleado.add(label);
						}
						{
							textField_10 = new JTextField();
							textField_10.setColumns(10);
							textField_10.setBounds(348, 53, 130, 20);
							PanelinfoEmpleado.add(textField_10);
						}
						{
							JLabel label = new JLabel("Correo El\u00E9ctronico :");
							label.setBounds(10, 135, 174, 20);
							PanelinfoEmpleado.add(label);
						}
						{
							textField_11 = new JTextField();
							textField_11.setColumns(10);
							textField_11.setBounds(10, 105, 302, 20);
							PanelinfoEmpleado.add(textField_11);
						}
						{
							JLabel label = new JLabel("Direcci\u00F3n :");
							label.setBounds(10, 84, 93, 19);
							PanelinfoEmpleado.add(label);
						}
						{
							textField_12 = new JTextField();
							textField_12.setColumns(10);
							textField_12.setBounds(10, 166, 302, 20);
							PanelinfoEmpleado.add(textField_12);
						}
						{
							JLabel lblNewLabel_5 = new JLabel("");
							lblNewLabel_5.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/doctora.png")));
							lblNewLabel_5.setBounds(439, 84, 93, 107);
							PanelinfoEmpleado.add(lblNewLabel_5);
						}
						{
							JLabel label = new JLabel("Rol del Empleado en la Clinica :");
							label.setBounds(10, 201, 234, 16);
							PanelinfoEmpleado.add(label);
						}
						{
							JRadioButton rbtNewAdm = new JRadioButton("Administrador");
							rbtNewAdm.setBackground(new Color(230, 230, 250));
							rbtNewAdm.setBounds(40, 224, 109, 23);
							PanelinfoEmpleado.add(rbtNewAdm);
						}
						{
							JRadioButton rbtNewDoct = new JRadioButton("Doctor");
							rbtNewDoct.setBackground(new Color(230, 230, 250));
							rbtNewDoct.setBounds(216, 224, 109, 23);
							PanelinfoEmpleado.add(rbtNewDoct);
						}
						{
							JRadioButton rbtNewSecre = new JRadioButton("Secretaria");
							rbtNewSecre.setBackground(new Color(230, 230, 250));
							rbtNewSecre.setBounds(392, 224, 109, 23);
							PanelinfoEmpleado.add(rbtNewSecre);
						}
					}
					
				
					{
						scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 66, 576, 82);
					
					
						panel_1.add(scrollPane);
					}
					
					JLabel lblEmpleado = new JLabel("Empleado :");
					lblEmpleado.setBounds(10, 11, 94, 14);
					panel_1.add(lblEmpleado);
					
					txtBusqueda = new JTextField();
					txtBusqueda.setBounds(10, 35, 145, 20);
					txtBusqueda.setColumns(10);
					txtBusqueda.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							if (!txtBusqueda.isEnabled()) {
								return;
							}else {
							tableFilter(txtBusqueda.getText()); }
													
							}
						
					});
					panel_1.add(txtBusqueda);
					
					JButton btnNewButton_3 = new JButton("Buscar");
					btnNewButton_3.setBounds(173, 34, 89, 23);
					panel_1.add(btnNewButton_3);
					{
						JButton btnNewButton_2 = new JButton("Listo");
						btnNewButton_2.setBounds(316, 442, 130, 36);
						panel_1.add(btnNewButton_2);
						btnNewButton_2.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/acceptar.png")));
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
						btnNewButton_1.setIcon(new ImageIcon(VentanaSecre_admin.class.getResource("/Imagenes/cancelar2.png")));
					}
				}
			}
		}
	}
	
	/////////////METODOS PARA LA TABLA////////////////////////////////////////
	
	private void loadtable() {
		//Cargar la tabla
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Persona aux : Clinica.getInstance().getMisPersonas()) {
			if(aux instanceof User) {
			addRow(aux);
			}
		}
		
	}

	private void addRow(Persona aux) {
		User empleado = null;
		empleado = (User) aux;
		//Agregar fila
		rows[0] = empleado.getCedula();
		rows[1] = empleado.getNombre()+" "+ empleado.getApellidos();
		rows[2] = empleado.getRol();
		
		model.addRow(rows);
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
	
	
	}


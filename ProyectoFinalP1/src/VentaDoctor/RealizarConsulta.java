package VentaDoctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Logical.Cita;
import Logical.Clinica;
import Logical.Consulta;
import Logical.Doctor;
import Logical.Enfermedad;
import Logical.HistorialMedico;
import Logical.Paciente;
import Logical.Persona;
import Logical.Secretaria;
import Logical.Vacuna;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JInternalFrame;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RealizarConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField txtTelefono;
	private JTextField textSexo;
	private JTextField textPeso;
	private JTextField textContatoEmergencia;
	private JTable tableListaVacuna;
	private JCheckBox chckbxNo;
	private JCheckBox chckbxSi;
	private JTable tableListaEnfermeda;
	//Variables para grupar botones
	private ButtonGroup botonesGrupo1;//sirve para aya;dir un grupo de botones a una famila
	private ButtonGroup botonesGrupo2;
	///
	// 
	private static String[] columnNames_Enfermedades = {"Código","Cédula","Nombre","Dirección","Prestamos"};
	DefaultTableModel modelo;
	private JTextArea textDiagnotico;
	private JScrollPane scrollPane_3;
	private Object[] filaEnfermedades;
	//
	private static Object[] fila;
	private Cita micita = null;
	private JCheckBox chckbxNo_Historial;
	@SuppressWarnings("unused")
	private MaskFormatter formatoTele;
	private JComboBox cbxTipoSangre;
	private JTextArea textHistorialMedico;
	private JCheckBox checkBox_Si__Historial;
	private JButton okButton;
	

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unused")
	public RealizarConsulta(Cita mi) {
		
		
		///formato
		MaskFormatter formatoTele = null;
		try {
			
			formatoTele = new MaskFormatter("(###)-###-####");
		}catch (Exception e) {
			
		}
		
		///
		this.micita = mi;
		setBounds(100, 100, 936, 626);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 11, 480, 250);
		contentPanel.add(panel_1);
		
		botonesGrupo1 = new ButtonGroup(); //GRUPO PARA LOS BOTONES
		botonesGrupo2 = new ButtonGroup();
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(10, 32, 67, 14);
		panel_1.add(label_2);
		
		textNombre = new JTextField(" "+micita.getMiPersona().getNombre()+" "+micita.getMiPersona().getApellidos());
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(10, 57, 270, 20);
		panel_1.add(textNombre);
		
		JLabel label_4 = new JLabel("Sexo:");
		label_4.setBounds(183, 88, 46, 14);
		panel_1.add(label_4);
		
		JLabel lblContactoDeEmergencia = new JLabel("Telefono:\r\n");
		lblContactoDeEmergencia.setBounds(10, 88, 139, 14);
		panel_1.add(lblContactoDeEmergencia);
		
		txtTelefono = new JTextField();

		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(10, 113, 155, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setText(" "+micita.getMiPersona().getTelefono());
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(542, 32, 83, 122);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(625, 36, 83, 98);
		panel_1.add(label_10);
		
		textSexo = new JTextField();
		textSexo.setEditable(false);
		textSexo.setColumns(10);
		textSexo.setBackground(Color.WHITE);
		textSexo.setBounds(183, 114, 97, 20);
		panel_1.add(textSexo);
		if(micita.getMiPersona().isSexo()) {
			textSexo.setText(" "+"Masculino");
		}else {
			textSexo.setText(" "+"Femenino");
		}
		
		JLabel lblTipoDeSangre = new JLabel("Tipo de sangre:\r\n");
		lblTipoDeSangre.setBounds(306, 141, 97, 14);
		panel_1.add(lblTipoDeSangre);
		
		cbxTipoSangre = new JComboBox();
		cbxTipoSangre.setEditable(true);
		cbxTipoSangre.setBackground(Color.WHITE);
		cbxTipoSangre.setModel(new DefaultComboBoxModel(new String[] {"Eliga tipo Sangre", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		cbxTipoSangre.setBounds(306, 169, 133, 20);
		panel_1.add(cbxTipoSangre);
		
		JLabel lblPesokg = new JLabel("Peso: (kg)");
		lblPesokg.setBounds(183, 145, 97, 14);
		panel_1.add(lblPesokg);
		
		textPeso = new JTextField();
		textPeso.setBackground(Color.WHITE);
		textPeso.setBounds(183, 169, 97, 20);
		panel_1.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblContactoDeEmergencia_1 = new JLabel("Contacto De Emergencia:\r\n\r\n");
		lblContactoDeEmergencia_1.setBounds(10, 145, 163, 14);
		panel_1.add(lblContactoDeEmergencia_1);
		
		textContatoEmergencia = new JFormattedTextField(formatoTele);
		textContatoEmergencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textContatoEmergencia.setBackground(new Color(240, 248, 255));

			}
			@Override
			public void focusLost(FocusEvent e) {
				textContatoEmergencia.setBackground(Color.white);
			}
		});
		textContatoEmergencia.setColumns(10);
		textContatoEmergencia.setBackground(Color.white);
		textContatoEmergencia.setBounds(10, 169, 155, 20);
		panel_1.add(textContatoEmergencia);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(RealizarConsulta.class.getResource("/Imagenes/person_user_customer_man_male_man_boy_people_1687.png")));
		label_1.setBounds(319, 36, 97, 97);
		panel_1.add(label_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(401, 86, 36, -27);
		panel_1.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 272, 480, 250);
		contentPanel.add(panel);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(542, 32, 83, 122);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(625, 36, 83, 98);
		panel.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 213, 150);
		panel.add(scrollPane);
		
		tableListaVacuna = new JTable();
		
		visualizar_tabla_ListaVacuna();

       
		
	//
		scrollPane.setViewportView(tableListaVacuna);
		
		JLabel lblListaDeVacunas = new JLabel("Lista De vacunas: ");
		lblListaDeVacunas.setBounds(10, 49, 170, 14);
		panel.add(lblListaDeVacunas);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(233, 74, 237, 150);
		panel.add(scrollPane_2);
		
		tableListaEnfermeda = new JTable();

	//
		scrollPane_2.setViewportView(tableListaEnfermeda);
		
		JLabel lblEnfermo = new JLabel("Se Encuentra Enfermo?");
		lblEnfermo.setBounds(10, 19, 151, 14);
		panel.add(lblEnfermo);
		
		chckbxSi = new JCheckBox("Si.");
		chckbxSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visualizar_tabla_Enfermedades();
			}
		});
		chckbxSi.setBounds(165, 15, 58, 23);
		panel.add(chckbxSi);
		chckbxSi.setBackground(new Color(230, 230, 250));
		botonesGrupo1.add(chckbxSi);
		
		chckbxNo = new JCheckBox("NO.");
		chckbxNo.setSelected(true);
		chckbxNo.setBounds(233, 15, 58, 23);
		panel.add(chckbxNo);
		chckbxNo.setBackground(new Color(230, 230, 250));
		botonesGrupo1.add(chckbxNo);
		
		
		JLabel lblListaEnfermedades_1 = new JLabel("Lista Enfermedades:\r\n");
		lblListaEnfermedades_1.setBounds(233, 49, 170, 14);
		panel.add(lblListaEnfermedades_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(500, 11, 397, 511);
		contentPanel.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(542, 32, 83, 122);
		panel_2.add(label);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(625, 36, 83, 98);
		panel_2.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(319, 36, 97, 97);
		panel_2.add(label_5);
		
		JLabel lblFechaConsulta = new JLabel("Fecha Consulta:");
		lblFechaConsulta.setBounds(20, 457, 91, 14);
		panel_2.add(lblFechaConsulta);
		
		JDateChooser fechaConsulta = new JDateChooser();
		fechaConsulta.setBounds(131, 457, 111, 20);
		panel_2.add(fechaConsulta);
		fechaConsulta.setEnabled(false);
		fechaConsulta.setDate(fechaActual());
		
		JLabel lblListaEnfermedades = new JLabel("Diagn\u00F3stico:\r\n\r\n");
		lblListaEnfermedades.setBounds(20, 11, 216, 34);
		panel_2.add(lblListaEnfermedades);
		
		checkBox_Si__Historial = new JCheckBox("Si.");
		checkBox_Si__Historial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//boton agregar historial al edico
				textHistorialMedico.setEnabled(true);
			}
			
		});
		checkBox_Si__Historial.setBackground(new Color(230, 230, 250));
		checkBox_Si__Historial.setBounds(286, 242, 49, 23);
		panel_2.add(checkBox_Si__Historial);
		botonesGrupo2.add(checkBox_Si__Historial);
		
		chckbxNo_Historial = new JCheckBox("No.");
		chckbxNo_Historial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textHistorialMedico.setEnabled(false);
			}
		});
		chckbxNo_Historial.setSelected(true);
		chckbxNo_Historial.setBackground(new Color(230, 230, 250));
		chckbxNo_Historial.setBounds(333, 242, 58, 23);
		panel_2.add(chckbxNo_Historial);
		botonesGrupo2.add(chckbxNo_Historial);
		/*
		 * JScrollPane pScroll = new JScrollPane( ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
panel.add( pScroll, BorderLayout.CENTER);
add( panel); //getContentPane ya es algo pasado
pack(); // abre la ventana conforme el tamaño necesario de los componentes
		 */
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 56, 353, 160);
		panel_2.add(scrollPane_3);
		
		textDiagnotico = new JTextArea(4,22);
		scrollPane_3.setViewportView(textDiagnotico);
		
		JLabel lblDeseaAgregarAnotaciones = new JLabel("Agregar Observaciones al Historial Medico?");
		lblDeseaAgregarAnotaciones.setBounds(20, 237, 260, 28);
		panel_2.add(lblDeseaAgregarAnotaciones);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 289, 353, 147);
		panel_2.add(scrollPane_4);
		
		textHistorialMedico = new JTextArea();
		textHistorialMedico.setEnabled(false);
		scrollPane_4.setViewportView(textHistorialMedico);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar Consulta");
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
		cargarPaciente();
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				Boolean v= (Boolean) tableListaVacuna.getValueAt(0, 1);
		        if(v==true) {
		        	 System.out.println("VAMOS BIEN"+v);
		        }else {
		        	 System.out.println("F");

		        }	
		        */
		        leerDatosConsulta_CrearPasiente();
			}
		});
	
	}
	  public void visualizar_tabla_ListaVacuna(){
		  
		    boolean[] editable = {false,true,true};
		        tableListaVacuna.setDefaultRenderer(Object.class, new Render());
		        DefaultTableModel dt = new DefaultTableModel(new String[]{ "Nombre", "La tiene"}
		        ,0) {
		 
		            Class[] types = new Class[]{
		                java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
		            };
		 
		           
		            public Class getColumnClass(int columnIndex) {
		                return types[columnIndex];
		            }
		           
		            public boolean isCellEditable(int row, int column){
		                return editable[column];
		            }
		           
		        };
		        fila = new Object[dt.getColumnCount()];	
		
		        for (Vacuna b : Clinica.getInstance().getMisVacunas()) {
		        	 fila[0] = b.getNombre_vacuna();
		        	 
		        	 if(micita.getMiPersona() instanceof Paciente) {
		        		Boolean estado = false;
		        		estado =((Paciente) micita.getMiPersona()).buscar_vacuna(b.getNombre_vacuna());
		        	 
		        		if(estado==true) {
		        			fila[1] = true;
		        		}else {
		        			fila[1] = false;
		        		}
		        	 }else {
		        		 
		        		 fila[1] = false;
		        	 }
				    
				    dt.addRow(fila);
				}
	

		       tableListaVacuna.setModel(dt);
		       
		      
		    }
	  public void visualizar_tabla_Enfermedades(){
		  
		    boolean[] editable = {false,true,true};
		        tableListaEnfermeda.setDefaultRenderer(Object.class, new Render());
		        DefaultTableModel dt = new DefaultTableModel(new String[]{ "Nombre", "La tiene"}
		        ,0) {
		 
		            Class[] types = new Class[]{
		                java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
		            };
		           
		            public Class getColumnClass(int columnIndex) {
		                return types[columnIndex];
		            }
		           
		            public boolean isCellEditable(int row, int column){
		            	
		                return editable[column];
		                
		            }
		           
		        };
				
		        filaEnfermedades = new Object[dt.getColumnCount()];	
		        JCheckBox N = new JCheckBox();
		        N.setSelected(false);
		        for (Enfermedad b : Clinica.getInstance().getEnfermedades()) {
		        	filaEnfermedades[0] = b.getNombre_enfermedad();
		        	filaEnfermedades[1] = false;
				   dt.addRow(filaEnfermedades);
				}
		        
		       tableListaEnfermeda.setModel(dt);
		       
		   
		    

		    }

	  public Date fechaActual() {
			Date fecha = new Date();
			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
			
			return fecha;
		}

	  @SuppressWarnings("unused")
	public void leerDatosConsulta_CrearPasiente() {
		  String Diagnostico = "";
		  Boolean enfermo = false;
		  ArrayList<Vacuna> misVacunas = null;

				//si no esta vacio 
				
				/*
				 * String nombre, String apellidos, String cedula, boolean sexo, String telefono,
			      String nacionalidad, Calendar fecha_nacimiento, String correo_electronico, String tipo_sangre,
			      String estado, String contacto_emergencia, float peso
				 */
				
					//leyendo dato de persona para convertirlo paciente("   -       - ")
				if (micita.getMiPersona() instanceof Paciente) {
					System.out.println("Cargar Dato solamente pasiente");			
					///Se realiza consulta--------------------------------------------
					realiandoConsulta();
					//----------------------------------------------------------------
					if(checkBox_Si__Historial.isSelected()) {
						//se carga funcion para guardar a historia 
						guadarAHistorial();
					}

					incertandoVacunas_y_Enfermedades();
					
				
				}else {
					// se crea el pasiente y se realiza su primera consulta
					creandoPasiente();
				}
			}
					
	  public void guadarAHistorial() {
			if(textHistorialMedico.getText().equalsIgnoreCase("")) {
				
			}else {
				HistorialMedico miHistoria = null;
				Calendar f = Calendar.getInstance();
				f.setTime(fechaActual());
				miHistoria = new HistorialMedico(micita.getMiDoctor(), f, textHistorialMedico.getText());
				Clinica.getInstance().incertarHisto_paciente((Paciente) micita.getMiPersona(), miHistoria);
			}
			
			
		}
		
		  
	  public void realiandoConsulta() {
		// TODO Auto-generated method stub
		  Consulta miconsulta = null;
		  if(!textDiagnotico.getText().equalsIgnoreCase("")) {
			  
			  Calendar f = Calendar.getInstance();
			  f.setTime(fechaActual());
			  miconsulta =new Consulta(textDiagnotico.getText(), f);
			  boolean aux=Clinica.getInstance().incertarConsulta_paciente(micita.getMiPersona(), miconsulta);
			  if(aux==true){
				  System.out.println("Consulta incertada de manera existosa");
			  }else {
				  System.out.println("Consulta NO incertada de manera existosa");
			  }
		  }else {
			  //debe rellenar los textDiagnotica
		  }
		 
		  
		
	}
	  public void cargarPaciente() {
		  System.out.println("Probando si es paciente");
			if (micita.getMiPersona() instanceof Paciente) {
				System.out.println("Es un paciente");
				//leyendo dato paciente
				String contacto_Emergencia=((Paciente) micita.getMiPersona()).getContacto_emergencia();
				Float peso =((Paciente) micita.getMiPersona()).getPeso();
				//mostrando dato
				textContatoEmergencia.setText(contacto_Emergencia);
				textContatoEmergencia.setEditable(false);
				cbxTipoSangre.setEditable(false);
				/*
				 * A+
				 * A-
				 * B+
				 * B-
				 * O+
				 * O-
				 * AB+
				 * AB-
				 */
			//cargando tipo de sangre 
				cargarTipoSangre();
				textPeso.setText(peso.toString());
				textPeso.setEditable(false);
				
			}
	  }
	  public void cargarTipoSangre() {
		  System.out.println("Cargando el tipo de sangre");
		  switch (((Paciente) micita.getMiPersona()).getTipo_sangre()) {
			case "A+":
				cbxTipoSangre.setSelectedIndex(1);

				break;
			case "A-":
				cbxTipoSangre.setSelectedIndex(2);

				break;
			case "B+":
				cbxTipoSangre.setSelectedIndex(3);

				break;
			case "B-":
				cbxTipoSangre.setSelectedIndex(4);

				break;
			case "O+":
				cbxTipoSangre.setSelectedIndex(5);

				break;
			case "O-":
				cbxTipoSangre.setSelectedIndex(6);

				break;
			case "AB+":
				cbxTipoSangre.setSelectedIndex(7);

				break;
			case "AB-":
				cbxTipoSangre.setSelectedIndex(8);

				break;
			default:
				break;
			}
			
		  
	  }

	  public void creandoPasiente() {

		  Paciente personaAux = null;
			//falta validar mas datos
			if(textContatoEmergencia.getText().equalsIgnoreCase("(   )-   -    ")&&textPeso.getText().equalsIgnoreCase("")
					&&textDiagnotico.getText().equalsIgnoreCase("")) {
				     
				///JOptionPane.showMessageDialog(null, "El Cliente se ha registrado de manera exitosa!", "Información", JOptionPane.INFORMATION_MESSAGE, null);

				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos de manera correcta! ", "Información", JOptionPane.INFORMATION_MESSAGE, null);

				//si los campo estan vacio
				System.out.println("To rapido");
			}else {
				///crendo paciente

				 String nombre = micita.getMiPersona().getNombre();
				 String apellidos =micita.getMiPersona().getApellidos();
				 String cedula = micita.getMiPersona().getCedula();
				 boolean sexo = micita.getMiPersona().isSexo();
				 String telefono =  micita.getMiPersona().getTelefono();
				 String nacionalidad =  micita.getMiPersona().getNacionalidad();
				 Calendar fecha_nacimiento = Calendar.getInstance();
				 fecha_nacimiento = micita.getMiPersona().getFecha_nacimiento();
				 String correo_electronico =  micita.getMiPersona().getCorreo_electronico();
				 
				 String tipo_sangre = "";
				
				 tipo_sangre = cbxTipoSangre.getSelectedItem().toString();
				 String contacto_emergencia=textContatoEmergencia.getText();
				 Float peso = Float.parseFloat(textPeso.getText());
				 String estado = "";
				 if(chckbxSi.isSelected()) {
					 estado ="Enfermo";//no se que significa el estado 
				 }else {
					 estado ="Sano";
				 }
			
				 boolean estadoEliminado = Clinica.getInstance().eliminarPersona(micita.getMiPersona());
				 
				 personaAux = new Paciente(nombre, apellidos, cedula, sexo, telefono, nacionalidad, fecha_nacimiento, correo_electronico, tipo_sangre, estado, contacto_emergencia, peso);
				
				
				
				 //dato para actualizar cita
				 Calendar fecha = Calendar.getInstance();
				 fecha = micita.getFecha();
				 Doctor miDoctor = null;
				 miDoctor = micita.getMiDoctor();
				 int hora = micita.getHora();
				 Secretaria secretaria = null;
				 secretaria = micita.getSecretaria();
				 String estadoA ="Realizada";
				 ///-----------------------consulta-------------------------------
				 Consulta mi = null;
				 mi = new Consulta(textDiagnotico.getText(), fecha);
				 personaAux.incertarConsulta(mi);
				 //---------------------------------------------------------------
				 if(checkBox_Si__Historial.isSelected()) {
					 HistorialMedico his = new HistorialMedico(miDoctor, fecha, textHistorialMedico.getText());
				 
					 personaAux.incertar_HistorialMedico(his);
				 }
				 //-----------------incertando vacunas
				 for(int i=0; i<tableListaVacuna.getRowCount();i++) {
					 //buscando enfermedades
					 boolean va = (boolean) tableListaVacuna.getModel().getValueAt(i, 1);
					 if(va==true) {
						 String nombreVacuna = (String) tableListaVacuna.getModel().getValueAt(i, 0);
						 Vacuna miVacuna = Clinica.getInstance().buscarVacuna(nombreVacuna);
					 
						 if(miVacuna!=null) {
							// personaAux.incertar_Vacuna(miVacuna);
							 System.out.println("Se ha incertado las vacuna");
						 }
						
						 
					 }
				 }
				 //-----------------------------incertando enfermedades--------------------------------------
				 for(int i=0; i<tableListaEnfermeda.getRowCount();i++) {
					 boolean va = (boolean) tableListaEnfermeda.getModel().getValueAt(i, 1);
					 if(va==true) {
						 String nombreEnfermedad = (String) tableListaVacuna.getModel().getValueAt(i, 0);
						 Enfermedad miVa =Clinica.getInstance().buscarEnfermedad(nombreEnfermedad);

						 if(miVa!=null) {
							 personaAux.incertar_enfermedades(miVa);
							 System.out.println("Se ha incertado las enfermeda");
						 }
					 }

				 }

				// ---------------------------------------------------------------------------------
				 
				 Cita citaNueva = new Cita(miDoctor, personaAux, fecha, hora, estadoA, secretaria);
				 ////
				 
				 //creando paciente y actualizando cita
				 
				 Clinica.getMiClinica().insertarPersona(personaAux);
				 Boolean e= Clinica.getInstance().acutalizar_Cita(micita, citaNueva);
				 miDoctor.acutalizar_Cita(micita, citaNueva);
				for (Cita n :  miDoctor.getMisCitas()) {
					if(n.getMiPersona() instanceof Paciente ) {
						System.out.println("La cita del doctor ya tiene un paciente");
					}
					
				}
				 if(e) {
					System.out.println("Dato actualizado");
				}else {
					System.out.println("Dato no se pudo actualizar");
				}
				/*
				 for (Persona mi : Clinica.getMiClinica().getMisPersonas()) {
					if(mi instanceof Paciente) {
						System.out.println("Incertado paciente");
					}
				}
				*/
				if(estadoEliminado) {
				System.out.println("Se realizo de manera correcta");
				}else {
					System.out.println("No se pudo eliminar");
				}
			}
		
	  }


	  public void incertandoVacunas_y_Enfermedades() {
		  //-----------------incertando vacunas
			 for(int i=0; i<tableListaVacuna.getRowCount();i++) {
				 //buscando enfermedades
				 boolean va = (boolean) tableListaVacuna.getModel().getValueAt(i, 1);
				 if(va==true) {
					 String nombreVacuna = (String) tableListaVacuna.getModel().getValueAt(i, 0);
					 Vacuna miVacuna = Clinica.getInstance().buscarVacuna(nombreVacuna);
				 
					 if(miVacuna!=null) {
						 boolean v= Clinica.getInstance().incertarVacuna_paciente((Paciente) micita.getMiPersona(), miVacuna);
						if(v==true) {
						 System.out.println("Se ha incertado las vacuna");
						 }
					 }
					
					 
				 }
			 }
			 //-----------------------------incertando enfermedades--------------------------------------
			 for(int i=0; i<tableListaEnfermeda.getRowCount();i++) {
				 boolean va = (boolean) tableListaEnfermeda.getModel().getValueAt(i, 1);
				 if(va==true) {
					 String nombreEnfermedad = (String) tableListaVacuna.getModel().getValueAt(i, 0);
					 Enfermedad miVa =Clinica.getInstance().buscarEnfermedad(nombreEnfermedad);

					 if(miVa!=null) {
						 boolean v = Clinica.getInstance().incertarEnfermedad_paciente((Paciente) micita.getMiPersona(), miVa);
						 if(v=true) {
							 System.out.println("Se ha incertado las enfermeda");
						 }
						 
					 }
				 }

			 }
	  }
}

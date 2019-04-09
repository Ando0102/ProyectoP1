package VentaDoctor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Logical.Cita;
import Logical.Clinica;
import Logical.Enfermedad;
import Logical.Paciente;
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
	private JCheckBox chckbxNo_1;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			RealizarConsulta dialog = new RealizarConsulta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RealizarConsulta(Cita mi) {
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Eliga tipo Sangre", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox.setBounds(306, 169, 133, 20);
		panel_1.add(comboBox);
		
		JLabel lblPesokg = new JLabel("Peso: (kg)");
		lblPesokg.setBounds(183, 145, 97, 14);
		panel_1.add(lblPesokg);
		
		textPeso = new JTextField();
		textPeso.setBounds(183, 169, 97, 20);
		panel_1.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblContactoDeEmergencia_1 = new JLabel("Contacto De Emergencia:\r\n\r\n");
		lblContactoDeEmergencia_1.setBounds(10, 145, 163, 14);
		panel_1.add(lblContactoDeEmergencia_1);
		
		textContatoEmergencia = new JTextField();
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
		
		JLabel lblEnfermo = new JLabel("Enfermo:");
		lblEnfermo.setBounds(233, 20, 91, 14);
		panel.add(lblEnfermo);
		
		chckbxSi = new JCheckBox("Si.");
		chckbxSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visualizar_tabla_Enfermedades();
			}
		});
		chckbxSi.setBounds(310, 15, 58, 23);
		panel.add(chckbxSi);
		chckbxSi.setBackground(new Color(230, 230, 250));
		botonesGrupo1.add(chckbxSi);
		
		chckbxNo = new JCheckBox("NO.");
		chckbxNo.setSelected(true);
		chckbxNo.setBounds(370, 15, 58, 23);
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
		lblFechaConsulta.setBounds(262, 422, 91, 14);
		panel_2.add(lblFechaConsulta);
		
		JDateChooser fechaConsulta = new JDateChooser();
		fechaConsulta.setBounds(262, 447, 111, 20);
		panel_2.add(fechaConsulta);
		fechaConsulta.setEnabled(false);
		fechaConsulta.setDate(fechaActual());
		
		JLabel lblListaEnfermedades = new JLabel("Diagn\u00F3stico:\r\n\r\n");
		lblListaEnfermedades.setBounds(20, 11, 216, 34);
		panel_2.add(lblListaEnfermedades);
		
		JLabel lblDeseaAgregarA = new JLabel("Agregar al historial medico? ");
		lblDeseaAgregarA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeseaAgregarA.setBounds(20, 422, 161, 14);
		panel_2.add(lblDeseaAgregarA);
		
		JCheckBox checkBox = new JCheckBox("Si.");
		checkBox.setBackground(new Color(230, 230, 250));
		checkBox.setBounds(30, 447, 58, 23);
		panel_2.add(checkBox);
		botonesGrupo2.add(checkBox);
		
		chckbxNo_1 = new JCheckBox("No.");
		chckbxNo_1.setSelected(true);
		chckbxNo_1.setBackground(new Color(230, 230, 250));
		chckbxNo_1.setBounds(123, 447, 58, 23);
		panel_2.add(chckbxNo_1);
		botonesGrupo2.add(chckbxNo_1);
		/*
		 * JScrollPane pScroll = new JScrollPane( ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
panel.add( pScroll, BorderLayout.CENTER);
add( panel); //getContentPane ya es algo pasado
pack(); // abre la ventana conforme el tamaño necesario de los componentes
		 */
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 56, 353, 316);
		panel_2.add(scrollPane_3);
		
		textDiagnotico = new JTextArea(4,22);
		scrollPane_3.setViewportView(textDiagnotico);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar Consulta");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Boolean v= (Boolean) tableListaVacuna.getValueAt(0, 1);
				        if(v==true) {
				        	 System.out.println("VAMOS BIEN"+v);
				        }else {
				        	 System.out.println("F");

				        }		
					}
				});
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

	  public void leerDatosConsulta() {
		  String Diagnostico = "";
		  Boolean enfermo = false;
		  ArrayList<Vacuna> misVacunas = null;
		  
	  }

}

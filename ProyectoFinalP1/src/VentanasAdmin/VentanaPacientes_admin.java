package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Doctor;
import Logical.Paciente;
import Logical.Persona;
import Logical.Secretaria;
import Logical.User;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class VentanaPacientes_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPanePacientes;
	private DefaultTableModel modelPacientes;
	private JTable tablaPacientes;
	private JScrollPane scrollPaneDoctor;
	private DefaultTableModel modelDoctor;
	private JTable tablaDoctor;
	private JScrollPane scrollPaneSecre;
	private DefaultTableModel modelSecre;
	private JTable tablaSecre;
	private JScrollPane scrollPaneAdmin;
	private DefaultTableModel modelAdmin;
	private JTable tablaAdmin;
	private Object[] filaPacientes;
	private Object[] filaDoctor;
	private Object[] filaSecre;
	private Object[] filaAdmin;
	private SimpleDateFormat dateformart1 = new SimpleDateFormat("dd - MM - yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPacientes_admin dialog = new VentanaPacientes_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPacientes_admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPacientes_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n General");
		setBounds(100, 100, 820, 491);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(240, 255, 255));
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panelPacientes = new JPanel();
				panelPacientes.setBackground(new Color(230, 230, 250));
				tabbedPane.addTab("Lista de Pacientes", null, panelPacientes, null);
				panelPacientes.setLayout(new BorderLayout(0, 0));
				
				scrollPanePacientes = new JScrollPane();
				panelPacientes.add(scrollPanePacientes, BorderLayout.CENTER);
				
				String[] titu = {"Nombre", "Genéro", "Fecha de Nacimiento", "Telefono"};
				modelPacientes = new DefaultTableModel();
				modelPacientes.setColumnIdentifiers(titu);
				
				tablaPacientes = new JTable();
				tablaPacientes.setModel(modelPacientes);
				LoadTablas(0);
				scrollPanePacientes.setViewportView(tablaPacientes);
				
			}
			{
				JPanel panelDoctor = new JPanel();
				tabbedPane.addTab("Lista de Doctores", null, panelDoctor, null);
				panelDoctor.setLayout(new BorderLayout(0, 0));
				
				scrollPaneDoctor = new JScrollPane();
				panelDoctor.add(scrollPaneDoctor, BorderLayout.CENTER);
				
				String[] titu = {"Nombre del Doctor", "Genéro", "Cantidad de Pacientes","Usuario", "Telefono"};
				modelDoctor = new DefaultTableModel();
				modelDoctor.setColumnIdentifiers(titu);
				
				tablaDoctor = new JTable();
				tablaDoctor.setModel(modelDoctor);
				scrollPaneDoctor.setViewportView(tablaDoctor);
			}
			{
				JPanel panelSecre = new JPanel();
				tabbedPane.addTab("Lista de Secretarias", null, panelSecre, null);
				panelSecre.setLayout(new BorderLayout(0, 0));
				
				scrollPaneSecre = new JScrollPane();
				panelSecre.add(scrollPaneSecre, BorderLayout.CENTER);
				
				String[] titu = {"Nombre de la Secretaria", "Cantidad de Citas ", "Usuario", "Telefono"};
				modelSecre = new DefaultTableModel();
				modelSecre.setColumnIdentifiers(titu);
				
				tablaSecre = new JTable();
				tablaSecre.setModel(modelSecre);
				scrollPaneSecre.setViewportView(tablaSecre);
			}
			{
				JPanel panelAdmin = new JPanel();
				tabbedPane.addTab("Lista de Administradores", null, panelAdmin, null);
				panelAdmin.setLayout(new BorderLayout(0, 0));
				
				scrollPaneAdmin = new JScrollPane();
				panelAdmin.add(scrollPaneAdmin);
				
				String[] titu = {"Nombre del Administrador", "Genéro","Usuario", "Telefono"};
				modelAdmin = new DefaultTableModel();
				modelAdmin.setColumnIdentifiers(titu);
				
				tablaAdmin = new JTable();
				tablaAdmin.setModel(modelAdmin);
				scrollPaneAdmin.setViewportView(tablaAdmin);
			}
		}
	}

	private void LoadTablas(int SelectordeTabla) {
		
		switch (SelectordeTabla) {
		
		case 0:
			
			modelPacientes.setRowCount(0);
			filaPacientes = new Object[modelPacientes.getColumnCount()];
			
			for (int i = 0; i <Clinica.getInstance().getMisPersonas().size(); i++) {
				
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof Paciente) {
					
					filaPacientes[0] = Clinica.getInstance().getMisPersonas().get(i).getNombre() + " " + Clinica.getInstance().getMisPersonas().get(i).getApellidos();
					filaPacientes[1] = Sexo(i);
					filaPacientes[2] = dateformart1.format(Clinica.getInstance().getMisPersonas().get(i).getFecha_nacimiento().getTime());
					filaPacientes[3] = Clinica.getInstance().getMisPersonas().get(i).getTelefono();
					modelPacientes.addRow(filaPacientes);
				}
			}
			
		break;
		
		case 1:
			
			modelDoctor.setRowCount(0);
			filaDoctor = new Object[modelDoctor.getColumnCount()];
			
			for (int i = 0; i <Clinica.getInstance().getMisPersonas().size(); i++) {
				
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof Doctor) {
					
					filaDoctor[0] = Clinica.getInstance().getMisPersonas().get(i).getNombre() + " " + Clinica.getInstance().getMisPersonas().get(i).getApellidos();
					filaDoctor[1] = Sexo(i);
					filaDoctor[2] = ((Doctor)Clinica.getInstance().getMisPersonas().get(i)).getMisPacientes().size();
					filaDoctor[3] = ((Doctor)Clinica.getInstance().getMisPersonas().get(i)).getUsuario();
					filaDoctor[4] = Clinica.getInstance().getMisPersonas().get(i).getTelefono();
					modelDoctor.addRow(filaDoctor);
				}
			}
			
		
		break;
		
		case 2:
			
			modelSecre.setRowCount(0);
			filaSecre = new Object[modelSecre.getColumnCount()];
			
			for (int i = 0; i <Clinica.getInstance().getMisPersonas().size(); i++) {
				
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof Secretaria) {
					
					filaSecre[0] = Clinica.getInstance().getMisPersonas().get(i).getNombre() + " " + Clinica.getInstance().getMisPersonas().get(i).getApellidos();
					filaSecre[1] = ((Secretaria)Clinica.getInstance().getMisPersonas().get(i)).getUsuario();
					filaSecre[2] = ContadorCitas(i);
					filaSecre[3] = Clinica.getInstance().getMisPersonas().get(i).getTelefono();
					modelSecre.addRow(filaSecre);
				}
			}

			
		break;
		
		case 3:
		
			modelAdmin.setRowCount(0);
			filaAdmin = new Object[modelAdmin.getColumnCount()];
			
			for (int i = 0; i <Clinica.getInstance().getMisPersonas().size(); i++) {
				
				if(Clinica.getInstance().getMisPersonas().get(i) instanceof User && !(Clinica.getInstance().getMisPersonas().get(i) instanceof Doctor) && !(Clinica.getInstance().getMisPersonas().get(i) instanceof Secretaria)
						&& !(Clinica.getInstance().getMisPersonas().get(i) instanceof Paciente)) {
					
					filaAdmin[0] = Clinica.getInstance().getMisPersonas().get(i).getNombre() + " " + Clinica.getInstance().getMisPersonas().get(i).getApellidos();
					filaAdmin[1] = Sexo(i);
					filaAdmin[2] = ((User)Clinica.getInstance().getMisPersonas().get(i)).getUsuario();
					filaAdmin[3] = Clinica.getInstance().getMisPersonas().get(i).getTelefono();
					modelAdmin.addRow(filaAdmin);
				}
			}
			
			
		break;
		
		default:
			break;
		}
		
		
		
	}

	private int ContadorCitas(int LaSecre) {
		int cantidad = 0;
		
		Persona aux = Clinica.getInstance().getMisPersonas().get(LaSecre);
		
		for(int i = 0; i<Clinica.getInstance().getMisCitas().size(); i++) {
			
			if(Clinica.getInstance().getMisCitas().get(i).getSecretaria().equals(aux)) {
				cantidad++;
			}
			
		}
		
		return cantidad;
	}

	private String Sexo(int i) {
		String genero = "";
		
		if(!Clinica.getInstance().getMisPersonas().get(i).isSexo()) {
			
			genero = "Femenino";
		}else {
			genero = "Masculino";
		}
		
		return genero;
	}
}

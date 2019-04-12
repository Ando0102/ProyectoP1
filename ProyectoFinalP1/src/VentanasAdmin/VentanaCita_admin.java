package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.border.BevelBorder;

public class VentanaCita_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable tabla;
	private Object[] fila;
	private SimpleDateFormat dataforma = new SimpleDateFormat("dd - MM - yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCita_admin dialog = new VentanaCita_admin();
			dialog.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCita_admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCita_admin.class.getResource("/Imagenes/LogoPeque.png")));
		//setIcon(Toolkit.getDefaultToolkit().getImage(VentanaCita_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Citas");
		setBounds(100, 100, 762, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Citas Actuales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				
				String[] titu = {"Nombre de la Persona", "Doctor", "Secretaria", "Fecha", "Estado"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(titu);
				
				tabla = new JTable();
				tabla.setModel(model);
				
				model.setRowCount(0);
				fila = new Object[model.getColumnCount()];
				
				for (int i = 0; i <Clinica.getInstance().getMisCitas().size(); i++) {
					
				
						fila[0] = Clinica.getInstance().getMisCitas().get(i).getMiPersona().getNombre();
						fila[1] = Clinica.getInstance().getMisCitas().get(i).getMiDoctor().getNombre();
						fila[2] = Clinica.getInstance().getMisCitas().get(i).getSecretaria().getNombre();
						fila[3] = dataforma.format(Clinica.getInstance().getMisCitas().get(i).getFecha().getTime());
						fila[4] = Clinica.getInstance().getMisCitas().get(i).getEstado();
						
							if(Clinica.getInstance().getMisCitas().get(i).getEstado().equalsIgnoreCase("Cancelada")) {
								
								tabla.setBackground(Color.RED);
								
							}else if(Clinica.getInstance().getMisCitas().get(i).getEstado().equalsIgnoreCase("Pendiente")) {
								
							}
						model.addRow(fila);
						
					
				}
				
				
				scrollPane.setViewportView(tabla);
				
			}
		}
	}

}

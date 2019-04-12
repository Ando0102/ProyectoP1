package VentaDoctor;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.sun.javafx.event.EventQueue;

import Logical.Doctor;
import Logical.Paciente;



public class ListaPaciente extends JPanel {
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;

 Doctor tuDoctor=null;
	/**
	 * Create the panel.
	 */

	public ListaPaciente(Doctor miDoc) {
		this.tuDoctor = miDoc;
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		setBounds(0, 0, 1071, 625);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1051, 534);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Cedula","Nombre","Sexo","Nacionalidad","Telefono", "Correo Electronico", "Estado"};
		tableModel.setColumnIdentifiers(columnNames);
		CargarPaciente(tuDoctor);
		
		scrollPane.setViewportView(table);
		
		JButton btnVerHistoria = new JButton("Ver Historia");
		btnVerHistoria.setBounds(956, 572, 105, 42);
		add(btnVerHistoria);

	}

	public static void CargarPaciente(Doctor tuDoctor) {
		tableModel.setRowCount(0);
		System.out.println("Cantidad pasoente:");
		fila = new Object[tableModel.getColumnCount()];
	  int i=0;
	  System.out.println("CANT "+tuDoctor.getMisPacientes().size());
		for (Paciente pa : tuDoctor.getMisPacientes()) {
		//	
			i++;
	    	System.out.println("Cantidad pasoente:" +i);
	    	///String[] columnNames = {"Cedula","Nombre","Sexo","Nacionalidad","Telefono", "Correo Electronico","Cantidad Cita", "Estado"};
	    	fila[0]=pa.getCedula();
	    	fila[1] = pa.getNombre() +" "+pa.getApellidos();
	    	if(pa.isSexo()) {
	    		fila[2] = "Hombre";
	    		
	    	}else {
	    		fila[2] = "Mujer";
	    	}
	    	fila[2] ="22";
	    	fila[3] = pa.getNacionalidad();
	    	fila[4] = pa.getTelefono();
	    	fila[5] = pa.getCorreo_electronico();
	    	fila[6] = pa.getEstado();
	    	fila[0]="l;k";
	    	tableModel.addRow(fila);
	    }
	
		
	
		
	
		
		table.setModel(tableModel);
		
		/*
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);///
		table.getTableHeader().setReorderingAllowed(false);//
		
		
		TableColumnModel columnModel = table.getColumnModel();
		
		///
		/*
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(195);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(0).setPreferredWidth(81);
*/
		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/
		
		
	}
	
}

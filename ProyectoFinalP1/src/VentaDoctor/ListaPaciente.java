package VentaDoctor;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.event.EventQueue;

import Logical.Clinica;
import Logical.Doctor;
import Logical.HistorialMedico;
import Logical.Paciente;
import Logical.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ListaPaciente extends JPanel {
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private String cedula="";

 Doctor tuDoctor=null;
private SimpleDateFormat dateformart1;
private JButton btnVerHistoria;
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
		table.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				int row =0;
				int colu = 0;
				if(table.getSelectedRow()>=0){
					row = table.getSelectedRow();
					colu=table.getSelectedColumn();
					
					cedula =(String) table.getModel().getValueAt(row, 0);
				btnVerHistoria.setEnabled(true);
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Cedula","Nombre","Sexo","Nacionalidad","Telefono", "Correo Electronico", "Estado"};
		tableModel.setColumnIdentifiers(columnNames);
		CargarPaciente(tuDoctor);
		
		scrollPane.setViewportView(table);
		
		btnVerHistoria = new JButton("Ver Historia");
		btnVerHistoria.setEnabled(false);
		btnVerHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Paciente aux= Clinica.getInstance().buscarPersona(cedula);
			String sexo ="";
			if(aux!=null) {
				System.out.println("Existe!!!!");
				if(aux.isSexo()) {
					sexo = "Masculino";
					
				}else {
					sexo = "Femenino";
				}
				try {
					generar(aux, aux.getCedula(), aux.getNombre(), aux.getCedula(), sexo);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			abrir(cedula);
			
			}
		});
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
	    
	    	fila[3] = pa.getNacionalidad();
	    	fila[4] = pa.getTelefono();
	    	fila[5] = pa.getCorreo_electronico();
	    	fila[6] = pa.getEstado();
	    	
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
public void generar( Paciente  mipaciente, String nombre, String Nombre_paciente, String Cedula, String sexo) throws DocumentException, MalformedURLException, IOException {
		
        

		
        FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        Image c = Image.getInstance("src\\Imagenes\\LOGOADA.PNG");
        c.setAlignment(Element.ALIGN_CENTER);
        
        
        ///
        Paragraph parrafo = new Paragraph("Datos Personales: ");
        parrafo.setAlignment(1);
        documento.add(c);
        documento.add(parrafo);


        documento.add(new Paragraph("Nombre Completo: " + Nombre_paciente));
        documento.add(new Paragraph("Cedula: " +Cedula))
        ;documento.add(new Paragraph("Sexo: " +sexo));
        documento.add(new Paragraph("_____________________________________________________________________________"));
        documento.add(new Paragraph("\n"));

        
        Paragraph parrafo2 = new Paragraph("                                                      Historia Medico: ");
        parrafo.setAlignment(1);
        
        documento.add(parrafo2);
        
        dateformart1 = new SimpleDateFormat("dd/MM/YYYY");
       
        
        for (HistorialMedico element : mipaciente.getMisHistorialMedico()) {
        	
        	documento.add(new Paragraph(" "+" En la Fecha:  "+dateformart1.format(element.getFecha().getTime())
        			+"el Doctor: "+element.getMiDoctor().getApellidos()+" Mensiona que: "+element.getSuceso()));
        	
        	////+ element.getSuceso()));

	
            documento.add(new Paragraph("_____________________________________________________________________________"));

		}
       
        
        documento.close();

    }
public void abrir(String nombre) {
    try {
        File path = new File(nombre + ".pdf");
        Desktop.getDesktop().open(path);
    } catch (Exception ex) {
     ///   JOptionPane.showMessageDialog(null, ex,"Atención",2);
    }
}
	
}

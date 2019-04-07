package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Logical.Clinica;
import Logical.Enfermedad;
import Logical.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaVacuna_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField textField_1;
	private JDateChooser dcFechadeVencimiento;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private JButton buttonModificar;
	private JButton buttonEliminar;
	private int index = 0;
	private Object[] fila;
	private JButton btnRegistrarNuevaVacuna;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			VentanaVacuna_admin dialog = new VentanaVacuna_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaVacuna_admin() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaVacuna_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Vacunas");
		setBounds(100, 100, 682, 519);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			
			/////////////////////////////////FICHERO/////////////////////////////////////////////////////////
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					FileOutputStream empresa2;
					ObjectOutputStream empresaWrite;
					try {
						empresa2 = new  FileOutputStream("ADAClinica.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						empresaWrite.writeObject(Clinica.getInstance());
					empresa2.close();
					empresaWrite.close();
					} catch (FileNotFoundException e1) {
						System.out.println("Error: No se ha podido guardar.");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			///////////////////////////////////////////////////////////////////////////////////7
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Registrar Nueva Vacuna", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 274, 646, 195);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(VentanaVacuna_admin.class.getResource("/Imagenes/plus_15650.png")));
			lblNewLabel.setBounds(61, 97, 96, 61);
			panel_1.add(lblNewLabel);
			
			JLabel lblNombreDeLa = new JLabel("Nombre de la Vacuna :");
			lblNombreDeLa.setBounds(171, 64, 169, 27);
			panel_1.add(lblNombreDeLa);
			
			txtNombre = new JTextField();
			txtNombre.setBorder(new LineBorder(new Color(192, 192, 192)));
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					txtNombre.setBorder(new LineBorder(new Color(192, 192, 192)));
				}
			});
			txtNombre.setBounds(171, 90, 197, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaVacuna_admin.class.getResource("/Imagenes/Vacuna2.png")));
			label.setBounds(22, 38, 146, 106);
			panel_1.add(label);
			
			JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento :");
			lblFechaDeVencimiento.setBounds(418, 70, 139, 14);
			panel_1.add(lblFechaDeVencimiento);
			
			dcFechadeVencimiento = new JDateChooser();
			dcFechadeVencimiento.getCalendarButton().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dcFechadeVencimiento.setBorder(new LineBorder(new Color(192, 192, 192)));
				}
			});
			dcFechadeVencimiento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dcFechadeVencimiento.setBorder(new LineBorder(new Color(192, 192, 192)));
				}
			});
			dcFechadeVencimiento.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
			dcFechadeVencimiento.setBounds(418, 90, 139, 20);
			panel_1.add(dcFechadeVencimiento);
			
			btnRegistrarNuevaVacuna = new JButton("Registrar Nueva Vacuna");
			btnRegistrarNuevaVacuna.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = null;
					Calendar FechaVencimiento = Calendar.getInstance();
					Calendar FechaInicial = Calendar.getInstance();
					
					if(!txtNombre.getText().equalsIgnoreCase("") && dcFechadeVencimiento.getDate() != null) {
						
						nombre = txtNombre.getText();
						FechaVencimiento.setTime(dcFechadeVencimiento.getDate());
						
						
						Vacuna aux = new Vacuna(FechaVencimiento, FechaInicial, nombre);
						Clinica.getInstance().insertarVacuna(aux);
						
						if(!buttonEliminar.isEnabled()) {
							
						JOptionPane.showMessageDialog(null, "Nueva Vacuna Registrada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
						}else {
							
						JOptionPane.showMessageDialog(null, "Vacuna Modificada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
		
						}
						
						Limpiador();
						
					}else {
						JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
						
						if(txtNombre.getText().equalsIgnoreCase("")) {
							
							txtNombre.setBorder(new LineBorder(new Color(204, 0, 0)));
							
						}if(dcFechadeVencimiento.getDate() == null) {
							
							dcFechadeVencimiento.setBorder(new LineBorder(new Color(204, 0, 0)));
							
						}
					}
					
				}

				
			});
			btnRegistrarNuevaVacuna.setBounds(439, 157, 197, 27);
			panel_1.add(btnRegistrarNuevaVacuna);
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Vacunas Existentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 11, 646, 252);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 25, 626, 179);
			panel_2.add(scrollPane);
			
			String[] titu = {"Nombre de la Vacuna", "Fecha de Vencimiento"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(titu);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				

				@Override
				public void mouseClicked(MouseEvent arg0) {
						if(table.getSelectedRow()>=0){
							buttonEliminar.setEnabled(true);
							buttonModificar.setEnabled(true);
							index = table.getSelectedRow();
							indentificador();
							
						}
					
				}



			});		

			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(model);
			LoadTabla();
			scrollPane.setViewportView(table);
			
			buttonModificar = new JButton("Modificar");
			buttonModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Vacuna aux = null;
					for(int i = 0; i<Clinica.getInstance().getMisVacunas().size(); i++) {
						
						if(Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna().equalsIgnoreCase(indentificador())) {
							aux = Clinica.getInstance().getMisVacunas().get(i);
						}
					
					}
					txtNombre.setText(aux.getNombre_vacuna());

					Clinica.getInstance().getMisVacunas().remove(index);
					buttonModificar.setEnabled(false);
					btnRegistrarNuevaVacuna.setText("Modificar Vacuna");
				}
			});
			buttonModificar.setBounds(448, 215, 89, 23);
			buttonModificar.setEnabled(false);
			panel_2.add(buttonModificar);
			
			buttonEliminar = new JButton("Eliminar");
			buttonEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int resp = JOptionPane.showOptionDialog(null, "Está Seguro que Desea Eliminar la Vacuna [" + indentificador() + "]", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"}, null); 
					if(resp == 0) {
						
						Clinica.getInstance().getMisVacunas().remove(index);
						
						Limpiador();
						
					}else {
						repaint();
					}
					
					}
				
			});
			buttonEliminar.setBounds(547, 215, 89, 23);
			buttonEliminar.setEnabled(false);
			panel_2.add(buttonEliminar);
	
		}
	}    


	private void LoadTabla() {
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (int i = 0; i <Clinica.getInstance().getMisVacunas().size(); i++) {
			
			
			
			fila[0] = Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna();
			fila[1] = Clinica.getInstance().getMisVacunas().get(i).getFecha_vencimiento().toString();///ERROR AQUI!!!
			model.addRow(fila);
		}
		
	}
	
	private String indentificador() {
		String nombre = "";
		nombre = Clinica.getInstance().getMisVacunas().get(index).getNombre_vacuna();
		return nombre;
	}
	
	private void Limpiador() {
		btnRegistrarNuevaVacuna.setText("Registrar Nueva Vacuna");
		txtNombre.setText("");
		dcFechadeVencimiento.resetKeyboardActions();
		LoadTabla();
		scrollPane.setViewportView(table);
		buttonEliminar.setEnabled(false);
		buttonModificar.setEnabled(false);

		
	}
}

package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaEnfermedad_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextPane txtSintomas;
	private JTextPane txtTratamiento;
	private JCheckBox chxPeligrosa;
	private JCheckBox cbxNormal;
	private ButtonGroup tipos;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private Object[] fila;
	private JButton buttonModificar;
	private JButton buttonEliminar;
	private int index = 0;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			VentanaEnfermedad_admin dialog = new VentanaEnfermedad_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaEnfermedad_admin() {
		setModal(true);
		setTitle("Informaci\u00F3n de Enfermedades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEnfermedad_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 759, 668);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		//////////////////////FICHERO///////////////////////////////////////////////////
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
		
		////////////////////////////////////////////////////////////////////////////////////
		
		final Color ColorEstandar = new Color(192, 192, 192);
		tipos = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 248, 255));
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Agregar Nueva Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 11, 713, 368);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Nombre de la Enfermedad :");
		label.setBounds(49, 24, 212, 22);
		panel_1.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				txtNombre.setBorder(new LineBorder(ColorEstandar));
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(49, 48, 283, 20);
		panel_1.add(txtNombre);
		
		JLabel label_1 = new JLabel("S\u00EDntomas :");
		label_1.setBounds(49, 79, 103, 22);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Tratamiento General :");
		label_2.setBounds(49, 210, 130, 22);
		panel_1.add(label_2);
		
		txtSintomas = new JTextPane();
		txtSintomas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				txtSintomas.setBorder(new LineBorder(ColorEstandar));
			}
		});
		txtSintomas.setBorder(new LineBorder(ColorEstandar));
		txtSintomas.setBounds(49, 107, 497, 92);
		panel_1.add(txtSintomas);
		
		txtTratamiento = new JTextPane();
		txtTratamiento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtTratamiento.setBorder(new LineBorder(ColorEstandar));
			}
		});
		txtTratamiento.setBorder(new LineBorder(ColorEstandar));
		txtTratamiento.setBounds(49, 238, 614, 70);
		panel_1.add(txtTratamiento);
		
		
		chxPeligrosa = new JCheckBox("Peligrosa");
		chxPeligrosa.setBounds(584, 114, 97, 23);
		chxPeligrosa.setBackground(new Color(230, 230, 250));
		panel_1.add(chxPeligrosa);
		tipos.add(chxPeligrosa);
		
		cbxNormal = new JCheckBox("Normal");
		cbxNormal.setBounds(584, 172, 97, 23);
		cbxNormal.setBackground(new Color(230, 230, 250));
		panel_1.add(cbxNormal);
		tipos.add(cbxNormal);

		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(VentanaEnfermedad_admin.class.getResource("/Imagenes/new-file_40454.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre, sintomas, tratamiento = null;
				boolean tipoEnfermedad = false;  //TRUE PELIGROSA  && FALSE NORMAL
				
				if(!txtNombre.getText().equalsIgnoreCase("") && !txtSintomas.getText().equalsIgnoreCase("") && !txtTratamiento.getText().equalsIgnoreCase("") && (cbxNormal.isSelected() || chxPeligrosa.isSelected())) {
					
					nombre = txtNombre.getText();
					sintomas = txtSintomas.getText();
					tratamiento = txtTratamiento.getText();
					
					if(cbxNormal.isSelected()) {
						tipoEnfermedad = false;
					}else {
						tipoEnfermedad = true;
					}
					
					Enfermedad aux = new Enfermedad(nombre, sintomas, tratamiento, tipoEnfermedad);
					Clinica.getInstance().insertarEnfermedad(aux);
					
					if(!buttonEliminar.isEnabled()) {
						
					JOptionPane.showMessageDialog(null, "Nueva Enfermedad Registrada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
					}else {
						
					JOptionPane.showMessageDialog(null, "Enfermedad Modificada", "Información", JOptionPane.INFORMATION_MESSAGE, null);
	
					}
					
					
					Limpiador();
				}else {
					JOptionPane.showMessageDialog(null, "Por favor, Completar Todos los Campos", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
					
					if(txtNombre.getText().equalsIgnoreCase("")) {
						
						txtNombre.setBorder(new LineBorder(new Color(204, 0, 0)));
						
					}if(txtSintomas.getText().equalsIgnoreCase("")) {
						
						txtSintomas.setBorder(new LineBorder(new Color(204, 0, 0)));
						
					}if(txtTratamiento.getText().equalsIgnoreCase("")) {
						
						txtTratamiento.setBorder(new LineBorder(new Color(204, 0, 0)));
					}
				}
				
			}


		});
		btnAgregar.setBounds(534, 319, 169, 38);
		panel_1.add(btnAgregar);
		
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Informaci\u00F3n de la Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(10, 390, 713, 218);
		panel.add(panel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 693, 137);
		panel_2.add(scrollPane);
		
		//////////////////////////////////////TABLA/////////////////////////////////////////////////////////////
		String[] titu = {"Tipo", "Nombre", "Sintomas", "Tratamiento"};
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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		buttonEliminar = new JButton("Eliminar\r\n");
		buttonEliminar.setIcon(new ImageIcon(VentanaEnfermedad_admin.class.getResource("/Imagenes/cancelar1.png")));
		buttonEliminar.setEnabled(false);
		buttonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		int resp = JOptionPane.showOptionDialog(null, "Está Seguro que Desea Eliminar la Enfermedad [" + Clinica.getInstance().getEnfermedades().get(index).getNombre_enfermedad() + "]", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"}, null); 
			if(resp == 0) {
				
				Clinica.getInstance().getEnfermedades().remove(index);
				
				Limpiador();
				
			}else {
				repaint();
			}
			
			}
		});
		buttonEliminar.setBounds(563, 171, 140, 36);
		panel_2.add(buttonEliminar);
		
		buttonModificar = new JButton("Modificar");
		buttonModificar.setIcon(new ImageIcon(VentanaEnfermedad_admin.class.getResource("/Imagenes/editnote_pencil_edi_6175 (1).png")));
		buttonModificar.setEnabled(false);
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enfermedad aux = null;
				for(int i = 0; i<Clinica.getInstance().getEnfermedades().size(); i++) {
					
					if(Clinica.getInstance().getEnfermedades().get(i).getNombre_enfermedad().equalsIgnoreCase(indentificador())) {
						aux = Clinica.getInstance().getEnfermedades().get(i);
					}
				
				}
				txtNombre.setText(aux.getNombre_enfermedad());
				txtSintomas.setText(aux.getSintomas());
				txtTratamiento.setText(aux.getTratamiento());
				if(aux.isTipo_enfermedad()) {
					chxPeligrosa.setSelected(true);;
				}else {
					cbxNormal.setSelected(true);;
				}
				Clinica.getInstance().getEnfermedades().remove(index);
				buttonModificar.setEnabled(false);
				btnAgregar.setText("Modificar Enfermedad");
			}
		});
		buttonModificar.setBounds(415, 171, 140, 36);
		panel_2.add(buttonModificar);
	}

	private void LoadTabla() {
	
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		String tipo = "";
		
		for (int i = 0; i <Clinica.getInstance().getEnfermedades().size(); i++) {
			
			
				if(Clinica.getInstance().getEnfermedades().get(i).isTipo_enfermedad() == true) {   //TIPO DE ENFERMEDAD
						tipo = "Peligrosa";
				}else if(Clinica.getInstance().getEnfermedades().get(i).isTipo_enfermedad() == false){
						tipo = "Normal";
				}
			
			
			fila[0] = tipo;
			fila[1] = Clinica.getInstance().getEnfermedades().get(i).getNombre_enfermedad();
			fila[2] = Clinica.getInstance().getEnfermedades().get(i).getSintomas();
			fila[3]= Clinica.getInstance().getEnfermedades().get(i).getTratamiento();
			model.addRow(fila);
		}
	
		
	}
	
	private String indentificador() {
		String nombre = "";
		
		nombre = Clinica.getInstance().getEnfermedades().get(index).getNombre_enfermedad();
		
		return nombre;
	}
	
	private void Limpiador() {
		
		btnAgregar.setText("Agregar Nueva Enfermedad");
		txtNombre.setText("");
		txtSintomas.setText("");
		txtTratamiento.setText("");
		tipos.clearSelection();
		LoadTabla();
		scrollPane.setViewportView(table);
		buttonEliminar.setEnabled(false);
		buttonModificar.setEnabled(false);

		
	}

}

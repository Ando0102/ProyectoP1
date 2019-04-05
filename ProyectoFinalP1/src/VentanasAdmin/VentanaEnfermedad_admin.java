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
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import Logical.Clinica;
import Logical.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class VentanaEnfermedad_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextPane txtSintomas;
	private JTextPane txtTratamiento;
	private JCheckBox chxPeligrosa;
	private JCheckBox cbxNormal;

	/**
	 * Launch the application.
	 */
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
		setTitle("Informaci\u00F3n de Enfermedades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEnfermedad_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 759, 668);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 248, 255));
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Agregar Nueva Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 11, 713, 368);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Nombre de la Enfermedad :");
		label.setBounds(49, 24, 212, 22);
		panel_1.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new LineBorder(new Color(192, 192, 192)));
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
		txtSintomas.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtSintomas.setBounds(49, 107, 497, 92);
		panel_1.add(txtSintomas);
		
		txtTratamiento = new JTextPane();
		txtTratamiento.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtTratamiento.setBounds(49, 238, 614, 79);
		panel_1.add(txtTratamiento);
		
		chxPeligrosa = new JCheckBox("Peligrosa");
		chxPeligrosa.setBounds(584, 114, 97, 23);
		chxPeligrosa.setBackground(new Color(230, 230, 250));
		panel_1.add(chxPeligrosa);
		
		cbxNormal = new JCheckBox("Normal");
		cbxNormal.setBounds(584, 172, 97, 23);
		cbxNormal.setBackground(new Color(230, 230, 250));
		panel_1.add(cbxNormal);

		
		JButton button = new JButton("Agregar Nueva Enfermedad");
		button.addActionListener(new ActionListener() {
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
					
					JOptionPane.showMessageDialog(null, "Nueva Enfermedad Registrada", "Información", JOptionPane.OK_OPTION, null);
					repaint();
					
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
		button.setBounds(505, 334, 198, 23);
		panel_1.add(button);
		
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n de la Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(10, 390, 713, 218);
		panel.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 693, 143);
		panel_2.add(scrollPane);
		
		JButton button_1 = new JButton("Eliminar\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(614, 184, 89, 23);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("Modificar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(515, 184, 89, 23);
		panel_2.add(button_2);
	}
}

package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDoctor_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaDoctor_admin dialog = new VentanaDoctor_admin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaDoctor_admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDoctor_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Doctor");
		setBounds(100, 100, 764, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 174, 718, 161);
			panel.add(scrollPane);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n del Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 718, 152);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 29, 66, 14);
			panel_1.add(lblNombre);
			
			textField = new JTextField();
			textField.setBounds(61, 26, 106, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 74, 66, 14);
			panel_1.add(lblApellido);
			
			textField_1 = new JTextField();
			textField_1.setBounds(61, 71, 106, 20);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono : ");
			lblTelefono.setBounds(280, 71, 79, 14);
			panel_1.add(lblTelefono);
			
			textField_2 = new JTextField();
			textField_2.setBounds(345, 68, 161, 20);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblCorreoElectronico = new JLabel("Correo Electronico :");
			lblCorreoElectronico.setBounds(212, 28, 147, 17);
			panel_1.add(lblCorreoElectronico);
			
			textField_3 = new JTextField();
			textField_3.setBounds(314, 26, 192, 20);
			panel_1.add(textField_3);
			textField_3.setColumns(10);
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(619, 118, 89, 23);
			panel_1.add(btnModificar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Registrar Nuevo Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(btnNewButton);
		
		JMenu mnNewMenu = new JMenu("Estadisticas de Doctores");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consultas Por D\u00EDa");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
	}
}

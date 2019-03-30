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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaEnfermedad_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 735, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				panel.add(tabbedPane, BorderLayout.CENTER);
				{
					JPanel panel_1 = new JPanel();
					tabbedPane.addTab("Estadística", null, panel_1, null);
					panel_1.setLayout(null);
					{
						JLabel label = new JLabel("");
						label.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								dispose();
							}
						});
						label.setIcon(new ImageIcon(VentanaEnfermedad_admin.class.getResource("/Imagenes/cancelar2.png")));
						label.setBounds(652, 361, 42, 41);
						panel_1.add(label);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					tabbedPane.addTab("Enfermedades", null, panel_1, null);
					panel_1.setLayout(null);
					{
						JPanel panel_2 = new JPanel();
						panel_2.setBorder(new TitledBorder(null, "Agregar Nueva Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel_2.setBounds(10, 11, 684, 153);
						panel_1.add(panel_2);
						panel_2.setLayout(null);
						{
							JLabel lblNombreDeEnfermedad = new JLabel("Nombre de Enfermedad :");
							lblNombreDeEnfermedad.setBounds(64, 39, 140, 22);
							panel_2.add(lblNombreDeEnfermedad);
						}
						{
							textField = new JTextField();
							textField.setBounds(74, 67, 130, 20);
							panel_2.add(textField);
							textField.setColumns(10);
						}
						{
							JLabel lblSntomas = new JLabel("S\u00EDntomas :");
							lblSntomas.setBounds(248, 43, 103, 22);
							panel_2.add(lblSntomas);
						}
						{
							textField_1 = new JTextField();
							textField_1.setBounds(258, 67, 115, 22);
							panel_2.add(textField_1);
							textField_1.setColumns(10);
						}
						{
							JLabel lblTratamientoGeneral = new JLabel("Tratamiento General :");
							lblTratamientoGeneral.setBounds(440, 43, 130, 22);
							panel_2.add(lblTratamientoGeneral);
						}
						{
							textField_2 = new JTextField();
							textField_2.setBounds(450, 67, 166, 20);
							panel_2.add(textField_2);
							textField_2.setColumns(10);
						}
						
						JButton btnAgregarNuevaEnfermedad = new JButton("Agregar Nueva Enfermedad");
						btnAgregarNuevaEnfermedad.setBounds(475, 119, 199, 23);
						panel_2.add(btnAgregarNuevaEnfermedad);
					}
					{
						JPanel panel_2 = new JPanel();
						panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n de la Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel_2.setBounds(10, 183, 684, 190);
						panel_1.add(panel_2);
						panel_2.setLayout(null);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(10, 30, 664, 88);
						panel_2.add(scrollPane);
						{
							JButton btnNewButton = new JButton("Eliminar\r\n");
							btnNewButton.setBounds(585, 156, 89, 23);
							panel_2.add(btnNewButton);
						}
						{
							JButton btnModificar = new JButton("Modificar");
							btnModificar.setBounds(472, 156, 89, 23);
							panel_2.add(btnModificar);
						}
					}
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								dispose();
							}
						});
						lblNewLabel.setIcon(new ImageIcon(VentanaEnfermedad_admin.class.getResource("/Imagenes/cancelar2.png")));
						lblNewLabel.setBounds(652, 372, 42, 41);
						panel_1.add(lblNewLabel);
					}
				}
			}
		}
	}
}

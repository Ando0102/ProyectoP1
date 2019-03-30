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
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;

public class VentanaDoctor_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPanel panelSeguridad;
	private JPanel panel_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

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
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDoctor_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Doctor");
		setBounds(100, 100, 799, 494);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Estadística", null, panel_1, null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Agregar Nuevo Doctor", null, panel_2, null);
		
		panelSeguridad = new JPanel();
		panelSeguridad.setBackground(new Color(211, 211, 211));
		panelSeguridad.setBounds(0, 0, 764, 364);
		panelSeguridad.setVisible(false);
		panel_2.add(panelSeguridad);
		panelSeguridad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/LogoGrande.png")));
		lblNewLabel.setBounds(10, 11, 128, 161);
		panelSeguridad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Escudo.png")));
		lblNewLabel_1.setBounds(639, 11, 115, 161);
		panelSeguridad.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(665, 330, 89, 23);
		panelSeguridad.add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(true);
				panelSeguridad.setVisible(false);
			}
		});
		btnAtras.setBounds(566, 330, 89, 23);
		panelSeguridad.add(btnAtras);
		
		JTextPane txtpnLasPartesExponen = new JTextPane();
		txtpnLasPartesExponen.setText("Estimado Doctor/a. Por este medio se le informa que la siguiente informaci\u00F3n que usted mismo sumistrar\u00E1 a continuaci\u00F3n, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie est\u00E1 informaci\u00F3n, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber est\u00E1 informaci\u00F3n a demas de usted. Es su deber como profesional y miembro de est\u00E1 instituci\u00F3n cumplir esta normal. ");
		txtpnLasPartesExponen.setBackground(new Color(211, 211, 211));
		txtpnLasPartesExponen.setEditable(false);
		txtpnLasPartesExponen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnLasPartesExponen.setBounds(165, 22, 399, 126);
		panelSeguridad.add(txtpnLasPartesExponen);
		
		JLabel lblUsuarioParaIniciar = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
		lblUsuarioParaIniciar.setBounds(195, 175, 162, 14);
		panelSeguridad.add(lblUsuarioParaIniciar);
		
		textField_7 = new JTextField();
		textField_7.setBounds(205, 200, 150, 20);
		panelSeguridad.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(195, 231, 100, 14);
		panelSeguridad.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 256, 152, 20);
		panelSeguridad.add(passwordField);
		
		JLabel lblConfimacinDeContrasea = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
		lblConfimacinDeContrasea.setBounds(195, 287, 179, 14);
		panelSeguridad.add(lblConfimacinDeContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(205, 312, 152, 20);
		panelSeguridad.add(passwordField_1);
		
		JLabel label = new JLabel("Nombres :");
		label.setBounds(10, 28, 72, 22);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 56, 135, 20);
		panel_2.add(textField);
		
		JLabel label_1 = new JLabel("Apellidos :");
		label_1.setBounds(192, 32, 93, 18);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(202, 56, 135, 20);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("Cedula :");
		label_2.setBounds(396, 32, 64, 18);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(406, 56, 135, 20);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono :");
		label_3.setBounds(10, 98, 72, 18);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(20, 127, 135, 20);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n :");
		label_4.setBounds(192, 99, 72, 16);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(202, 127, 340, 20);
		panel_2.add(textField_4);
		
		JLabel label_5 = new JLabel("G\u00E9nero :");
		label_5.setBounds(10, 158, 72, 14);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Nacionalidad :");
		label_6.setBounds(187, 158, 98, 20);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Correo El\u00E9ctronico :");
		label_7.setBounds(10, 214, 145, 20);
		panel_2.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(20, 245, 317, 20);
		panel_2.add(textField_5);
		
		JLabel label_8 = new JLabel("Fecha de Nacimiento :");
		label_8.setBounds(10, 276, 125, 14);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Dia :");
		label_9.setBounds(20, 304, 46, 14);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Mes :");
		label_10.setBounds(99, 304, 46, 14);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("A\u00F1o :");
		label_11.setBounds(256, 304, 46, 14);
		panel_2.add(label_11);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(288, 301, 86, 20);
		panel_2.add(textField_6);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctor.png")));
		label_12.setBounds(605, 206, 99, 103);
		panel_2.add(label_12);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(630, 338, 89, 23);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(false);
				panelSeguridad.setVisible(true);
			}
		});
		panel_2.add(btnSiguiente);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		label_13.setBounds(512, 206, 93, 109);
		panel_2.add(label_13);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumRowCount(4);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Agosto", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(133, 301, 99, 20);
		panel_2.add(comboBox_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(52, 301, 37, 20);
		panel_2.add(spinner);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(5);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(202, 183, 135, 20);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<G\u00E9nero>", "Masculino", "Femenino"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(20, 183, 93, 20);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/cancelar2.png")));
		lblNewLabel_4.setBounds(713, 372, 51, 32);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Modificar Doctor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Informaci\u00F3n para Modificar del Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 135, 744, 226);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Rueda_dentada.png")));
		lblNewLabel_3.setBounds(484, 132, 83, 72);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(10, 32, 71, 19);
		panel_4.add(lblNombre);
		
		textField_8 = new JTextField();
		textField_8.setBounds(20, 56, 130, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(182, 34, 83, 14);
		panel_4.add(lblApellidos);
		
		textField_9 = new JTextField();
		textField_9.setBounds(192, 56, 130, 20);
		panel_4.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setBounds(358, 34, 83, 19);
		panel_4.add(lblTelfono);
		
		textField_10 = new JTextField();
		textField_10.setBounds(368, 56, 122, 20);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCorreoElctronico = new JLabel("Correo El\u00E9ctronico :");
		lblCorreoElctronico.setBounds(10, 87, 174, 20);
		panel_4.add(lblCorreoElctronico);
		
		textField_11 = new JTextField();
		textField_11.setBounds(20, 115, 302, 20);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n :");
		lblDireccin.setBounds(10, 146, 93, 19);
		panel_4.add(lblDireccin);
		
		textField_12 = new JTextField();
		textField_12.setBounds(20, 176, 302, 20);
		panel_4.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(645, 192, 89, 23);
		panel_4.add(btnModificar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		lblNewLabel_2.setBounds(502, 87, 76, 96);
		panel_4.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 744, 113);
		panel_3.add(scrollPane);
	}
}

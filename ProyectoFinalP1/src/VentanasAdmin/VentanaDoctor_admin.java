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
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JButton btnFinalizar;
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
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(230, 230, 250));
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Estadística", null, panel_1, null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Informaci\u00F3n del Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Agregar Nuevo Doctor", null, panel_2, null);
		
		panelSeguridad = new JPanel();
		panelSeguridad.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSeguridad.setBackground(new Color(230, 230, 250));
		panelSeguridad.setBounds(10, 24, 731, 344);
		panelSeguridad.setVisible(false);
		panel_2.add(panelSeguridad);
		panelSeguridad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/LogoGrande.png")));
		lblNewLabel.setBounds(10, 11, 128, 161);
		panelSeguridad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/Escudo.png")));
		lblNewLabel_1.setBounds(619, 11, 115, 161);
		panelSeguridad.add(lblNewLabel_1);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/back_icon-icons.com_74430.png")));
		btnAtras.setBackground(UIManager.getColor("Button.highlight"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(true);
				panelSeguridad.setVisible(false);
				btnSiguiente.setVisible(true);
				btnCancelar.setVisible(false);
				btnFinalizar.setVisible(false);
				
			}
		});
		btnAtras.setBounds(527, 293, 128, 34);
		panelSeguridad.add(btnAtras);
		
		JTextPane txtpnLasPartesExponen = new JTextPane();
		txtpnLasPartesExponen.setText("Estimado Doctor/a. Por este medio se le informa que la siguiente informaci\u00F3n que usted mismo sumistrar\u00E1 a continuaci\u00F3n, es de total confidencialidad para su persona. Es su deber mantener en secreto y no divulgar u compartir con nadie est\u00E1 informaci\u00F3n, sin importar que a las personas las cuales usted desea compartirla sean colegas o superiores de usted.  Absolutamente nadie debe de saber est\u00E1 informaci\u00F3n a demas de usted. Es su deber como profesional y miembro de est\u00E1 instituci\u00F3n cumplir esta normal. ");
		txtpnLasPartesExponen.setBackground(new Color(230, 230, 250));
		txtpnLasPartesExponen.setEditable(false);
		txtpnLasPartesExponen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnLasPartesExponen.setBounds(165, 22, 399, 126);
		panelSeguridad.add(txtpnLasPartesExponen);
		
		JLabel lblUsuarioParaIniciar = new JLabel("Usuario para Iniciar Sesi\u00F3n :");
		lblUsuarioParaIniciar.setBounds(195, 159, 162, 14);
		panelSeguridad.add(lblUsuarioParaIniciar);
		
		textField_7 = new JTextField();
		textField_7.setBounds(205, 184, 150, 20);
		panelSeguridad.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(195, 215, 100, 14);
		panelSeguridad.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 240, 152, 20);
		panelSeguridad.add(passwordField);
		
		JLabel lblConfimacinDeContrasea = new JLabel("Confimaci\u00F3n de Contrase\u00F1a :");
		lblConfimacinDeContrasea.setBounds(195, 271, 179, 14);
		panelSeguridad.add(lblConfimacinDeContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(205, 300, 152, 20);
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
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/next_icon-icons.com_74443.png")));
		btnSiguiente.setBounds(540, 334, 125, 34);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(false);
				panelSeguridad.setVisible(true);
				btnSiguiente.setVisible(false);
				btnCancelar.setVisible(true);
				btnFinalizar.setVisible(true);
							}
		});
		panel_2.add(btnSiguiente);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/doctora.png")));
		label_13.setBounds(512, 206, 93, 109);
		panel_2.add(label_13);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(240, 248, 255));
		comboBox_2.setMaximumRowCount(4);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Agosto", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(133, 301, 99, 20);
		panel_2.add(comboBox_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(new Color(240, 248, 255));
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(52, 301, 37, 20);
		panel_2.add(spinner);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(240, 248, 255));
		comboBox_1.setMaximumRowCount(5);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Pa\u00EDs>", "Alemania", "Argentina", "Australia", "Burgar\u00EDa", "Canad\u00E1", "Colombia", "Cuba", "Hait\u00ED", "Mexico", "Rep. Dominicana", "Rusia", "Rep. Checa", "Venezuela", "Jap\u00F3n"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(202, 183, 135, 20);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(240, 248, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<G\u00E9nero>", "Masculino", "Femenino"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(20, 183, 93, 20);
		panel_2.add(comboBox);
		
		btnCancelar= new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/cancelar2.png")));
		btnCancelar.setVisible(false);
		btnCancelar.setBounds(616, 379, 125, 34);
		panel_2.add(btnCancelar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(477, 379, 128, 34);
		panel_2.add(btnFinalizar);
		btnFinalizar.setBackground(UIManager.getColor("Button.highlight"));
		btnFinalizar.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/acceptar.png")));
		btnFinalizar.setVisible(false);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Modificar Doctor", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(10, 135, 744, 228);
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
		textField_8.setBackground(new Color(255, 255, 255));
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
		btnModificar.setIcon(new ImageIcon(VentanaDoctor_admin.class.getResource("/Imagenes/edit_pencil_6320 (1).png")));
		btnModificar.setBounds(604, 183, 130, 34);
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

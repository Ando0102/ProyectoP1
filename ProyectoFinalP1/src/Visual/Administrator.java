package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoraYFecha;

	
	public Administrator() {
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registrar");
		mnNewMenu.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/cita2.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnDoctor = new JMenu("Doctor");
		mnNewMenu.add(mnDoctor);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Doctor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnDoctor.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Doctores Existentes");
		mnDoctor.add(mntmNewMenuItem_1);
		
		JMenu mnSecretaria = new JMenu("Secretaria");
		mnNewMenu.add(mnSecretaria);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agregar Secretaria");
		mnSecretaria.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Secretarias Existentes");
		mnSecretaria.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Estadisticas");
		mnNewMenu_1.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/grafica2.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mnNewMenu_1.add(mntmEmpleados);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Pacientes");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Consultas");
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Enfermedades");
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmVacunas = new JMenuItem("Vacunas");
		mnNewMenu_1.add(mntmVacunas);
		
		JMenu mnNewMenu_2 = new JMenu("Enfermedades");
		mnNewMenu_2.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/Enfermedad.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nueva Enfermedad");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Enfermedades Existentes");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Vacunas");
		mnNewMenu_3.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/vacuna.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Nueva Vacuna");
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Vacunas Existentes");
		mnNewMenu_3.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 11, 199, 411);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/man.png")));
		lblNewLabel.setBounds(55, 11, 89, 129);
		panel_1.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a ");
		lblBienvenidoa.setBounds(55, 151, 89, 49);
		panel_1.add(lblBienvenidoa);
		
		txtHoraYFecha = new JTextField();
		txtHoraYFecha.setBackground(Color.WHITE);
		txtHoraYFecha.setEditable(false);
		txtHoraYFecha.setText("          HORA Y FECHA\r\n");
		txtHoraYFecha.setBounds(10, 296, 179, 104);
		panel_1.add(txtHoraYFecha);
		txtHoraYFecha.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(219, 11, 787, 411);
		panel.add(panel_2);
		panel_2.setLayout(null);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

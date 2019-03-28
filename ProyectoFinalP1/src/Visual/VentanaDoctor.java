package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PanelesDoctor.pnlCitasTodas;
import PanelesDoctor.pnlEnfermedades;

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
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;

public class VentanaDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoraYFecha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDoctor frame = new VentanaDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaDoctor() {
       // new CambiaPanel(pnlPrincipal, new pnlCitasTodas());

		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDoctor.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCitas = new JMenu("Citas");
		mnCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			}
		});
		menuBar.add(mnCitas);
		
		JMenuItem mntmTodas = new JMenuItem("Todas ");

		mnCitas.add(mntmTodas);
		
		JMenu mnNewMenu_2 = new JMenu("Enfermedades");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntLista = new JMenuItem("Lista");

		mnNewMenu_2.add(mntLista);
		
		JMenu mnNewMenu_3 = new JMenu("Vacunas");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mnNewMenu_3.add(mntmLista);
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
		lblNewLabel.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/Imagenes/man.png")));
		lblNewLabel.setBounds(10, 11, 89, 129);
		panel_1.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a ");
		lblBienvenidoa.setBounds(55, 151, 89, 49);
		panel_1.add(lblBienvenidoa);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaDoctor.class.getResource("/Imagenes/woman.png")));
		lblNewLabel_1.setBounds(109, 11, 80, 129);
		panel_1.add(lblNewLabel_1);
		
		txtHoraYFecha = new JTextField();
		txtHoraYFecha.setBackground(Color.WHITE);
		txtHoraYFecha.setEditable(false);
		txtHoraYFecha.setText("          HORA Y FECHA\r\n");
		txtHoraYFecha.setBounds(10, 296, 179, 104);
		panel_1.add(txtHoraYFecha);
		txtHoraYFecha.setColumns(10);
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlPrincipal.setBounds(219, 11, 787, 411);
		panel.add(pnlPrincipal);
	  new CambiaPanel(pnlPrincipal, new pnlCitasTodas());
	  pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.X_AXIS));

	  ///es una accion para la enfermedades
		mntLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  new CambiaPanel(pnlPrincipal, new pnlEnfermedades());

			}
		});
	////
		mntmTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			///mostrar todas las citas
			//System.out.println("Hola mundo cruel");
				new CambiaPanel(pnlPrincipal, new pnlCitasTodas());

			}
		});
	
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

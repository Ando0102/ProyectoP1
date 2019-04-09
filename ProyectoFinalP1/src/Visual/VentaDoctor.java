package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;




import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import Logical.Doctor;
import VentaDoctor.pnlCitasbtn;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentaDoctor extends JFrame implements Runnable {

	///
	//private static JTable table;
	private static Object[] fila;
	private static String[] columnNames = {"Nombre","Cedula", "Sexo","Edad","Fecha Cita", "Telefono", "Coreo"};
	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	
	///
	private JPanel contentPane;
	private JTextPane txtHoraYFecha;
	private Dimension tamano;
	private Thread Tiempo;
	private int hora;
	private int minutos;
	private int segundos;
	private int mes;
	private int ano;
	private int dia;
	private JDateChooser dateChooser;
	private Doctor miDoctor=null;
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaDoctor frame = new VentaDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public VentaDoctor(Doctor mi) {
		this.miDoctor = mi;
		setTitle("Doctor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentaDoctor.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		tamano = super.getToolkit().getScreenSize();
		super.setSize(tamano.width, (tamano.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pasiente");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmLista_1 = new JMenuItem("Lista");
		mnNewMenu.add(mntmLista_1);
		
		JMenu mnEnfermedades = new JMenu("Enfermedades");
		menuBar.add(mnEnfermedades);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mnEnfermedades.add(mntmLista);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 0, 199, 658);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentaDoctor.class.getResource("/Imagenes/medical-29_icon-icons.com_73943.png")));
		lblNewLabel.setBounds(55, 11, 89, 129);
		panel_1.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a ");
		lblBienvenidoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBienvenidoa.setBounds(55, 151, 89, 49);
		panel_1.add(lblBienvenidoa);
		
		txtHoraYFecha = new JTextPane();
		txtHoraYFecha.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtHoraYFecha.setBackground(new Color(240, 248, 255));
		txtHoraYFecha.setEditable(false);
		txtHoraYFecha.setBounds(54, 553, 135, 33);
		
		////////HILO PARA EL RELOJ///////////////////////////////////////////
		Tiempo = new Thread(this);
		Tiempo.start();
		/////////////////////////////////////////////////////////////////
		panel_1.add(txtHoraYFecha);
		
		JButton btnNewButton = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setIcon(new ImageIcon(VentaDoctor.class.getResource("/Imagenes/stop_exit_close_6291.png")));
		btnNewButton.setBounds(10, 376, 179, 57);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tablero");
		btnNewButton_1.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon(VentaDoctor.class.getResource("/Imagenes/controlPanel.png")));
		btnNewButton_1.setBounds(10, 308, 179, 57);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agenda");
		btnNewButton_2.setBackground(UIManager.getColor("Button.highlight"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon(VentaDoctor.class.getResource("/Imagenes/calendario.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(10, 240, 179, 57);
		panel_1.add(btnNewButton_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(54, 597, 135, 33);
		panel_1.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(219, 0, 1111, 658);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelCitas = new JPanel();
		panelCitas.setBackground(new Color(240, 248, 255));
		

		panelCitas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelCitas.setBounds(20, 20, 1071, 627);
		panel_2.add(panelCitas);
		panelCitas.setLayout(new BorderLayout(0, 0));
		///
	    new CambiaPanel(panelCitas, new pnlCitasbtn(miDoctor));
		inciarFecha();
		
		
		
	}
	

////////////////////////////////////FUNCIONES PARA EL RELOJ//////////////////////////////
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == Tiempo) {
            calcula();
            txtHoraYFecha.setText("          " + hora + ":" + minutos + ":" + segundos +"\n        " );
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
		
	}
	
	
	public void calcula() {
		//Hora utilizando Hilo
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        
        //Fecha de Forma Manual
     //   dia = calendario.get(Calendar.DAY_OF_MONTH);
      //  mes = 3;  //calendario.get(Calendar.MONTH);
      //  ano = calendario.get(Calendar.YEAR);
        
        
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

	public Date fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
		
		return fecha;
	}
	public void inciarFecha() {
		Calendar fecha = Calendar.getInstance();

		fecha.setTime(fechaActual());
		dateChooser.setCalendar(fecha);
	}
	
}

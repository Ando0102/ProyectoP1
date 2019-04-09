package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Logical.Clinica;
import Logical.Paciente;
import VentanasAdmin.VentanaCita_admin;
import VentanasAdmin.VentanaEnfermedad_admin;
import VentanasAdmin.VentanaEstadisticas;
import VentanasAdmin.VentanaPacientes_admin;
import VentanasAdmin.VentanaSecre_admin;
import VentanasAdmin.VentanaVacuna_admin;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.JToolBar;

public class Administrator extends JFrame implements Runnable {

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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Administrator() {
		setResizable(false);
//////////////////////////////////////////fichero//////////////////////		
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
		
		
//////////////////////////////////////////////////////////////////////		////
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 503);
		tamano = super.getToolkit().getScreenSize();
		super.setSize(tamano.width, (tamano.height-50));
		setLocationRelativeTo(null);
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
		panel_1.setBounds(10, 11, 199, 618);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/man.png")));
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
		txtHoraYFecha.setBounds(10, 503, 179, 104);
		
		////////HILO PARA EL RELOJ///////////////////////////////////////////
		Tiempo = new Thread(this);
		Tiempo.start();
		/////////////////////////////////////////////////////////////////
		panel_1.add(txtHoraYFecha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(219, 11, 1121, 618);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelDeVacunas = new JPanel();
		panelDeVacunas.setBackground(new Color(176, 196, 222));
		panelDeVacunas.setBounds(21, 112, 528, 426);
		panel_2.add(panelDeVacunas);
		
	    JPanel panelDeEnfermedades = new JPanel();
	    panelDeEnfermedades.setBounds(570, 109, 528, 426);
	    panel_2.add(panelDeEnfermedades);
	    panelDeEnfermedades.setLayout(new BorderLayout(0, 0));
		
////////////////////////////////////////////////GRAFICOS/////////////////////////////////////////////////////////
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
      //EJEMPLO DE PRUEBA
    	   dataset.setValue(8, "Vacunados", "Contra el Dengue");
    	   dataset.setValue(4, "No Vacunados", "Contra el Dengue");
    	   
    	for(int i=0; i<Clinica.getInstance().getMisVacunas().size(); i++) { 
    		
    	 dataset.setValue(ContadorDeVacunas(Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna(), true), "Vacunados", Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna());
    	 dataset.setValue(ContadorDeVacunas(Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna(), false), "No Vacunados", Clinica.getInstance().getMisVacunas().get(i).getNombre_vacuna());
    	 
    	}
        // Creando el Grafico
        JFreeChart chartVacunas = ChartFactory.createBarChart3D
        ("Pacientes Vacunados","Vacunas", "Pacientes", dataset, PlotOrientation.VERTICAL, true,true, false);
        chartVacunas.setBackgroundPaint(new Color(176, 196, 222));
        chartVacunas.getTitle().setPaint(Color.black);
        chartVacunas.getTitle().setFont(new Font("Tahoma", Font.BOLD, 12));
        CategoryPlot p = chartVacunas.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.BLACK); 
        // Mostrar Grafico
        ChartPanel chartPanelVacunas = new ChartPanel(chartVacunas);
        chartPanelVacunas.setBounds(100, 120, 200, 300);
        panelDeVacunas.setLayout(new BorderLayout(0, 0));
        panelDeVacunas.add(chartPanelVacunas);
        
 
    //////////////////////////////Grafico2///////////////////////////////////////////    
        // Fuente de Datos
        DefaultCategoryDataset datasetEnfermedades = new DefaultCategoryDataset();
        
        datasetEnfermedades.setValue(3, "Peligrosas", "Dengue");
        datasetEnfermedades.setValue(10, "Normal", "Fiebre");
        datasetEnfermedades.setValue(8, "Normal", "Diarrea");
        datasetEnfermedades.setValue(20, "Peligrosas", "Colera");
        
        
        /*for(int i = 0; i<Clinica.getInstance().getEnfermedades().size(); i++) {
        	
	        datasetEnfermedades.setValue(ContadorDeEfermedades(true), "Peligrosas", Clinica.getInstance().getEnfermedades().get(i).getNombre_enfermedad());
	        datasetEnfermedades.setValue(ContadorDeEfermedades(false), "Normales", Clinica.getInstance().getEnfermedades().get(i).getNombre_enfermedad());

        }*/
 
        // Creando el Grafico
        JFreeChart chartEnfermedades=ChartFactory.createBarChart3D("Estadisticas de Enfermedades", "Enfermedad", "Contagios", datasetEnfermedades, PlotOrientation.VERTICAL,true, true, false); 
        chartEnfermedades.getTitle().setFont(new Font("Tahoma", Font.BOLD, 12));
        chartEnfermedades.setBackgroundPaint(new Color(176, 196, 222));
        CategoryPlot q = chartEnfermedades.getCategoryPlot(); 
        q.setRangeGridlinePaint(Color.red); 
        
        // Mostrar Grafico
        ChartPanel chartPanelEnfermedades = new ChartPanel(chartEnfermedades);
        chartPanelEnfermedades.setSize(528, 426);
        panelDeEnfermedades.add(chartPanelEnfermedades);
        
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, BorderLayout.NORTH);
        
        JButton botonEmpleados = new JButton();
        botonEmpleados.setFont(new Font("Tahoma", Font.BOLD, 11));
        toolBar.add(botonEmpleados);
        botonEmpleados.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/hombrecito.png")));
        botonEmpleados.setText("Empleados   ");
        botonEmpleados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		VentanaSecre_admin aux = new VentanaSecre_admin();
        		aux.setVisible(true);
        	}
        });
        
        
        botonEmpleados.setBackground(UIManager.getColor("Button.highlight"));
        botonEmpleados.setLayout(null);
        
        JButton panelPaciente = new JButton();
        panelPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
        toolBar.add(panelPaciente);
        panelPaciente.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/grafica2.png")));
        panelPaciente.setText("Poblaci\u00F3n   ");
        panelPaciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaPacientes_admin aux = new VentanaPacientes_admin();
        		aux.setVisible(true);
        	}
        });
        panelPaciente.setBackground(UIManager.getColor("Button.highlight"));
        panelPaciente.setLayout(null);
        
        JButton panelCitas = new JButton();
        panelCitas.setFont(new Font("Tahoma", Font.BOLD, 11));
        toolBar.add(panelCitas);
        panelCitas.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/cita2.png")));
        panelCitas.setText("Citas    ");
        panelCitas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaCita_admin aux = new VentanaCita_admin();
        		aux.setVisible(true);
        	}
        });
        panelCitas.setBackground(UIManager.getColor("Button.highlight"));
        panelCitas.setLayout(null);
        panelCitas.setLayout(null);
        
        JButton panelVacuna = new JButton();
        panelVacuna.setFont(new Font("Tahoma", Font.BOLD, 11));
        toolBar.add(panelVacuna);
        panelVacuna.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/vacuna.png")));
        panelVacuna.setText("Vacunas    \r\n");
        panelVacuna.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaVacuna_admin aux = new VentanaVacuna_admin();
        		aux.setVisible(true);
        	}
        });
        
        panelVacuna.setBackground(UIManager.getColor("Button.highlight"));
        panelVacuna.setLayout(null);
        
        JButton panelEnfermedad = new JButton();
        panelEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 11));
        toolBar.add(panelEnfermedad);
        panelEnfermedad.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/Enfermedad.png")));
        panelEnfermedad.setText("Enfermedades    ");
        panelEnfermedad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VentanaEnfermedad_admin aux = new VentanaEnfermedad_admin();
        		aux.setVisible(true);
        	}
        });
        panelEnfermedad.setBackground(UIManager.getColor("Button.highlight"));
        panelEnfermedad.setLayout(null);
        
        JButton btnNewButton = new JButton("Cerrar Sesi\u00F3n  ");
        toolBar.add(btnNewButton);
        btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No"}, null); 
        			if(resp == 0){
        				IniciarSesion aux =  new IniciarSesion();
        				aux.setVisible(true);
        				dispose();						
        			} else{
        					repaint();
        				}
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setIcon(new ImageIcon(Administrator.class.getResource("/Imagenes/stop_exit_close_6291.png")));
	}
	



	////////////////////////////////////FUNCIONES PARA EL RELOJ//////////////////////////////
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == Tiempo) {
            calcula();
            txtHoraYFecha.setText("\n          " + hora + ":" + minutos + ":" + segundos +"\n        " + dia + "|"+ mes +"|"+ ano);
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
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = 4;  //calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);
        
        
    }
	
	public int ContadorDeVacunas(String NombreVacuna, boolean Return) { //TRUE = return Vacunados FALSE = return NO Vacunados
		int Vacunados = 0;
		int NOvacunados = 0;
		boolean tiene = false;
		
		 for(int i = 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
	    	   
	    	   if (Clinica.getInstance().getMisPersonas().get(i) instanceof Paciente ) {
	    		   
	    		 for(int y = 0; y<((Paciente)Clinica.getInstance().getMisPersonas().get(i)).getMisVacunas().size(); y++) {
	    			 
		    		   if (((Paciente)Clinica.getInstance().getMisPersonas().get(i)).getMisVacunas().get(y).getNombre_vacuna().equalsIgnoreCase(NombreVacuna)) {
		    			   Vacunados++;
		    			   tiene = true;   
		    		   }
		    		   
	    		  }
	    		 	if(tiene == false) {
	    			   NOvacunados++;
	    		 	}
	    		 	tiene = false;
	    	   }
	    	   	  
		 }
		 
		if(Return) {
		return Vacunados;
		}else {
		return NOvacunados;
		}
	}
	
	private int ContadorDeEfermedades(boolean Return) {
		int EnfermedadesPeligrosas = 0;
		int EnfermedadesNormales = 0;
		
		
		 for(int i = 0; i<Clinica.getInstance().getMisPersonas().size(); i++) {
	    	   
	    	   if (Clinica.getInstance().getMisPersonas().get(i) instanceof Paciente ) {
	    		   
	    		 for(int y = 0; y<((Paciente)Clinica.getInstance().getMisPersonas().get(i)).getMisEnfermedas().size(); y++) {
	    			 
		    		   if (((Paciente)Clinica.getInstance().getMisPersonas().get(i)).getMisEnfermedas().get(y).isTipo_enfermedad()) {
		    			  
		    			   EnfermedadesPeligrosas++;  
		    		   }else {
		    			   EnfermedadesNormales++;
		    		   }
		    		   
	    		  }
	    		 	
	    	   }
	    	   	  
		 }

		if(Return) {
			return EnfermedadesPeligrosas;
		}else {
			return EnfermedadesNormales;
		}
	}
}

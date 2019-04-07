package VentaDoctor;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Logical.Cita;
import Logical.Doctor;
import javafx.scene.layout.Background;




public class pnlCitasbtn extends JPanel {
	//private static JTable table;
			private static Object[] fila;
			private static String[] columnNames = {"", "Domingo", "Lunes", "Martes", 
					"Miercoles", "Jueves", "Viernes", "Sabado"

				};
			private static DefaultTableModel modelo;
			private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
			private static JTable table;
			Doctor miDoctor = null;
			
		/**
		 * Create the applet.
		 */
		public pnlCitasbtn(Doctor miDoc) {
			this.miDoctor=miDoc;
			
			setBackground(Color.BLUE);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 550, 1071, 73);
		    add(panel);
			panel.setLayout(null);
			
			JButton btnRealizarCita = new JButton("Realizar Consulta");
			btnRealizarCita.setEnabled(false);
			btnRealizarCita.setBounds(906, 11, 155, 51);
			panel.add(btnRealizarCita);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 63, 1071, 488);
			add(panel_1);
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setSize(1071, 443);
			scrollPane.setLocation(0, 0);
			panel_1.add(scrollPane);
			setBounds(0, 0, 1071, 507);
			table = new JTable();
			table.setDefaultEditor(Object.class, null);//sirve para evitar que se edite la table
			table.setDefaultRenderer(Object.class, new DTable());//dando formato
			
			modelo = new DefaultTableModel();
			cargar();
			table.setModel(modelo);
		//
			
			
			
			cargarDatos();
			scrollPane.setViewportView(table);

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Calendar d = Calendar.getInstance();
					d.setTime(fechaActual());
				/*String country;
					int delivery;*/
					if(table.getSelectedRow()>=0){
						d.get(Calendar.DAY_OF_WEEK);
						System.out.println("row: "+table.getSelectedRow()+"Column"+table.getSelectedColumn());
						
					//	btnEliminar.setEnabled(true);
						///btnModificar.setEnabled(true);
						//int index = table.getSelectedRow();
						//code = (int)table.getModel().getValueAt(index, 0);

						
					}
				}
			});

		}
		
		public static void  cargar() {
			
			modelo.setColumnIdentifiers(columnNames);	
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];		
			int y =8;
			for (int i=0; i<11; i++) {	
				
				if(i==0) {
					fila[0] = "0"+y + ":00";
					
				}else {
					
				}
				if(i==1) {
					fila[0] = "0"+y + ":00";
				}
				if(i==2)
					fila[0] = y + ":00";
				if(i==3)
					fila[0] = y + ":00";
				if(i==4)
					fila[0] = y + ":00";
				if(i==5)
					fila[0] = y + ":00";
				if(i==6)
					fila[0] = y + ":00";
				if(i==7)
					fila[0] = y + ":00";
				if(i==8)
					fila[0] = y + ":00";
				if(i==9)
					fila[0] = y + ":00";
				if(i==10)
					fila[0] = y + ":00";
					
				
					//fila[1] = 
					//fila[2] = 
					//fila[3] = 
					///fila[4] = 
				y++;
				modelo.addRow(fila);
					
				}	
			/*
			 * 	table.setRowHeight(40);
			
			table.setModel(tableModel);		
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getTableHeader().setReorderingAllowed(false);
			TableColumnModel columnModel = table.getColumnModel();
			
			 */
				table.setRowHeight(40);
				
				table.setModel(modelo);		
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				TableColumnModel columnModel = table.getColumnModel();
				

				//sirve para dar un tamnno a las columnas 
			
				columnModel.getColumn(0).setPreferredWidth(91);
				columnModel.getColumn(1).setPreferredWidth(140);
				columnModel.getColumn(2).setPreferredWidth(140);
				columnModel.getColumn(3).setPreferredWidth(140);
				columnModel.getColumn(4).setPreferredWidth(140);
				columnModel.getColumn(5).setPreferredWidth(140);
				columnModel.getColumn(6).setPreferredWidth(140);
				columnModel.getColumn(7).setPreferredWidth(140);
				
				
				
			}	
		public void  cargarDatos() {
			String aux = "Bobo lentin";
			table.getModel().setValueAt(aux, 3, 3);
			//dias_semana();
			Calendar c = Calendar.getInstance();
			
			c.setTime(fechaActual());
			//fecha_dia_uno__de_semana(c);
			String[] fechasSemana = {
					"","","","",
					"","",""
			};
//------------------------------			
			Calendar Domingo = Calendar.getInstance();
			Calendar Lunes = Calendar.getInstance();
			Calendar Martes = Calendar.getInstance();
			Calendar Miercoles = Calendar.getInstance();
			Calendar Jueves = Calendar.getInstance();
			Calendar Viernes = Calendar.getInstance();
			Calendar Sabado = Calendar.getInstance();

//----------------------------------------------------------
			
			fechasSemana = fechas_semana(c);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {

					Domingo.setTime(sdf.parse(fechasSemana[0]));
					Lunes.setTime(sdf.parse(fechasSemana[1]));
					Martes.setTime(sdf.parse(fechasSemana[2]));
					Miercoles.setTime(sdf.parse(fechasSemana[3]));
					Jueves.setTime(sdf.parse(fechasSemana[4]));
					Viernes.setTime(sdf.parse(fechasSemana[5]));
					Sabado.setTime(sdf.parse(fechasSemana[6]));
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Error a cargar fecha semanas");
				e.printStackTrace();
			}
			
			System.out.println("DIA: "+Domingo.get(Calendar.DATE));
			
//-------------------------------------------------------------------------			
			
			System.out.println("Domingo:   " +fechasSemana[0]);
			System.out.println("Lunes:     "+fechasSemana[1]);
			System.out.println("Martes:    "+fechasSemana[2]);
			System.out.println("Miercoles: "+fechasSemana[3]);
			System.out.println("Jueves:    "+fechasSemana[4]);
			System.out.println("Viernes:   "+fechasSemana[5]);
			System.out.println("Sabado:    "+fechasSemana[6]);
			
//-------------------------------------------------------------------------			
			///
			String cedula = "";
			
			
			///
			
			table.getModel().setValueAt("L-08:00", 0, 1);
			table.getModel().setValueAt("L-09:00", 1, 1);
			table.getModel().setValueAt("L-10:00", 2, 1);
			table.getModel().setValueAt("L-11:00", 3, 1);
			table.getModel().setValueAt("L-12:00", 4, 1);
			table.getModel().setValueAt("L-13:00", 5, 1);
			table.getModel().setValueAt("L-14:00", 6, 1);
			table.getModel().setValueAt("L-15:00", 7, 1);
			table.getModel().setValueAt("L-16:00", 8, 1);
			table.getModel().setValueAt("L-17:00", 9, 1);
			table.getModel().setValueAt("L-18:00", 10, 1);
			
		
			Calendar auxFecha = Calendar.getInstance();
			
			System.out.println("pepe: ");
			
			System.out.println("Cantida: "+miDoctor.getMisCitas().size());
			for (Cita miCita : miDoctor.getMisCitas()) {
				System.out.println("Cantida: "+miDoctor.getMisCitas().size());
				System.out.println("HORAS: "+ miCita.getHora());
				switch (miCita.getHora()) {
				case 8://hora a las 8
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 0, 7);

						break;

					default:
						break;
					}
					
///------------------------------
				case 9:
					if(miCita.getHora()==9) {
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 1, 7);

						break;
					
					default:
					}
						break;
						
					}
					
					break;
						
//---------------------------------------------------------------------					
					
				
				case 10://hora 10
//----------------------------------------------------------------------
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 2, 7);

						break;

					default:
						break;
					}
					
//----------------------------------------------------------------------					
					break;
				case 11:
//----------------------------------------------
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 3, 7);

						break;

					default:
						break;
					}
					
					break;
//------------------------------------------
				case 12:
//------------------------------------------------------------------------------------------------------					
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 4, 7);

						break;

					default:
						break;
					}
					
//---------------------------------------------------------------------------------------------------------					
					break;
//--------------------------------------------------------------------------------------------
				case 13:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 5, 7);

						break;

					default:
						break;
					}
										
					break;
//--------------------------------------------------------------------------//--------------------------------------------------------------------------------------------
				case 14:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 6, 7);

						break;

					default:
						break;
					}
					
					break;
					
					
//--------------------------------------------------------------------------					
					//--------------------------------------------------------------------------------------------
				case 15:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 7, 7);

						break;

					default:
						break;
					}
					
					break;
					
					
//--------------------------------------------------------------------------					
//--------------------------------------------------------------------------------------------
				case 16:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 2);
						break;
					case 3:
						//martes8
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 8, 7);

						break;

					default:
						break;
					}
						break;
					
					
//--------------------------------------------------------------------------					
				case 17:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 9, 7);

						break;

					default:
						break;
					}
					
					break;
					
					
//--------------------------------------------------------------------------					
				case 18:
					auxFecha = miCita.getFecha();
					auxFecha.get(Calendar.DAY_OF_WEEK);
					//
					switch (auxFecha.get(Calendar.DAY_OF_WEEK)) {
					case 1:
						//Domingo
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 1);
						
						break;
					case 2:
						// lunes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 2);
						break;
					case 3:
						//martes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 3);
					case 4:
						//miercoles
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 4);
						break;
				
					case 5:
						//Jueves 
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 5);

						break;
					case 6:
						//Viernes
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 6);

						break;
					case 7:
						//Sabado
						table.getModel().setValueAt(miCita.getMiPersona().getNombre(), 10, 7);

						break;

					default:
						break;
					}
							
					break;
					
					
//--------------------------------------------------------------------------					
								default:
					break;
				
			//table.getModel().setValueAt(, 10, 1);
			//table.getModel().setValueAt("L-18:00", 0, 10);
		//	table.getModel().setValueAt(aValue, rowIndex, columnIndex);
		}
		}
			}
		public void dias_semana() {
			int restadia=0;//para obtener luego dia inicial de una semana 
			String[] strDays = new String[]{
					"Domingo",
					"Lunes",
					"Martes",
					"Miercoles",
					"Jueves",
					"Viernes",
					"Sabado"
					};	
			
			Calendar f = Calendar.getInstance();
			GregorianCalendar calendar = new GregorianCalendar();
			 calendar.setTime(fechaActual());
			f.setTime(fechaActual());
			int dia  = f.get(Calendar.DATE);//dia >n 
			int mes  = f.get(Calendar.MONTH);
			int anno = f.get(Calendar.YEAR);
			
			
			System.out.println("Hoy es : " + strDays[f.get(Calendar.DAY_OF_WEEK) - 1]);

			//f.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
			//int nuevo = f.get(Calendar.DATE);
			//System.out.println("EL nuevo dia: "+nuevo );//dia >n );
			//System.out.println("Hoy es : " + strDays[f.get(Calendar.DAY_OF_WEEK) - 1]);

			
			System.out.println("DIA SEMANA: "+ f.get(Calendar.DAY_OF_WEEK));
			switch (f.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				//Domingo
				restadia = 0;
				break;
			case 2:
				// lunes
				restadia = -1;
				break;
			case 3:
				//martes
				restadia = -2;
				break;
			case 4:
				//miercoles
				restadia = -3;
				break;
			case 5:
				//Jueves 
				restadia = -4;
				break;
			case 6:
				//Viernes
				restadia = -5;
				break;
			case 7:
				//Sabado
				restadia = -6;
				break;

			default:
				break;
			}
			f.add(Calendar.DAY_OF_YEAR, restadia);  // numero de días a añadir, o restar en caso de días<0
			System.out.println("Primer dia semana : " + f.get(Calendar.DATE));

			/*
			int ks = 6;
			int[] mesesValor = {
					0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0
					};
			
			*/
					
		
			//
			/*
		//	f.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
			int ultimoDigito = anno%1000;//ultimo digito A
			if(calendar.isLeapYear(anno)) {
				//El año es bisiesto
				mesesValor[0] = 6;
				mesesValor[1] = 2;
				
			}else {
				mesesValor[0] = 0;
				mesesValor[1] = 3;
				//El año NO es bisiesto 
			}
			mesesValor[2] = 3;
			mesesValor[3] = 6;
			mesesValor[4] = 1;
			mesesValor[5] = 4;
			mesesValor[6] = 6;
			mesesValor[7] = 2;
			mesesValor[8] = 5;
			mesesValor[9] = 0;
			mesesValor[10] = 3;
			mesesValor[11]  =  5;
			//(Calendar.MONTH));
			//annio = Integer.toString(c.get(Calendar.YEAR))
			System.out.println("dia: "+dia+"mes: "+mes +" Anno: "+anno+"Ultimo digito: "+ultimoDigito);
		*/
			
			/*
			int N = dia;
			int M = mesesValor[mes-1];
			int A = ultimoDigito;
			int diaSemanaActual = (N  + M + A+ A/4+ks)%7;//dia actua
			System.out.println("EL DIA DE LA SEMANA: "+diaSemanaActual);

		/*
		 *0 > D
		 *1 > L
		 *
		 * 6 > S
		 *
		 */
		

		//el dia de la semana obtien get(Calendar.DAY_OF_WEEK)
		// El dia de la semana inicia en el 1 mientras que el array empieza en el 0
		
		}
		
		public Date fechaActual() {
			Date fecha = new Date();
			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY");
			
			return fecha;
		}
		
		public Calendar fecha_dia_uno__de_semana(Calendar fecha) {
			//debuelve la fecha del primer dia de la semana 
			
			//retonarna el primer dia de la semana actual
			Calendar aux = Calendar.getInstance();
			int restadia =0;
			switch (aux.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				//Domingo
				restadia = 0;
				break;
			case 2:
				// lunes
				restadia = -1;
				break;
			case 3:
				//martes
				restadia = -2;
				break;
			case 4:
				//miercoles
				restadia = -3;
				break;
		
			case 5:
				//Jueves 
				restadia = -4;
				break;
			case 6:
				//Viernes
				restadia = -5;
				break;
			case 7:
				//Sabado
				restadia = -6;
				break;

			default:
				break;
			}
			aux.add(Calendar.DAY_OF_YEAR, restadia); 
			System.out.println("El primer dia de la semana: "+ aux.get(Calendar.DATE));
			return aux;
		}

		
		public String[] fechas_semana(Calendar fecha) {
			//Devuelve las fecha de los 7 dia de la semana 
			String fechasx[] = {
					"","","","","",
					"","","",""};
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
			Calendar a = Calendar.getInstance();
			
			a = fecha_dia_uno__de_semana(fecha);
			fechasx[0]= sdf.format(a.getTime());

		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[1]= sdf.format(a.getTime());

		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[2]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[3]= sdf.format(a.getTime());
		   
		    a.add(Calendar.DAY_OF_YEAR, 1);	
		    fechasx[4]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);
		    fechasx[5]= sdf.format(a.getTime());
		    
		    a.add(Calendar.DAY_OF_YEAR, 1);//sabado
		    fechasx[6]= sdf.format(a.getTime());
		    return fechasx;
			
		}


		public void cargar_Agenda_Doctor() {
			Doctor miDoctor= null;
			
			for (Cita miCita : miDoctor.getMisCitas()) {
				
				
			}
			
			
			
		}
}
